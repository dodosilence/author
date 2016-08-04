package cn.moondust.auther.service;

import cn.moondust.auther.entity.User;
import cn.moondust.auther.exception.UserRegisterException;
import cn.moondust.auther.modules.taobao.SendMsmService;
import cn.moondust.auther.repository.UserRepository;
import cn.moondust.auther.repository.redis.SmsCodeRedisDao;
import cn.moondust.auther.utils.PatternUtil;
import cn.moondust.auther.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by j0 on 2016/8/3.
 */
@Service
public class AutherUserService {
    @Autowired
    SmsCodeRedisDao smsCodeRedisDao;


    @Autowired
    UserRepository userRepository;


    @Autowired
    SendMsmService sendMsmService;


    //过期时间是六十秒
    private long expriedTime = 600;

    private long resendtime = 60;

    /**
     * @param phone
     * @return 0成功   -1手机号格式不正确 1发送频繁 2发送失败
     */
    public int sendMsgCode(String phone) {
        if (!PatternUtil.isPhone(phone)) {
            return -1;
        }
        Map map = smsCodeRedisDao.getMsgCode(phone);
        if (map != null) {
            try {
                if (Long.parseLong(map.get("resendTime").toString()) >= System.currentTimeMillis()) {
                    return 1;
                }
            } catch (Exception e) {
                return 1;
            }
        }
        HashMap<String, Object> msmValue = new HashMap<>();
        msmValue.put("phone", phone);
        String code = RandomUtil.numberRedom(6);
        boolean res = sendMsmService.sendMsmCode(phone, code);
        if (!res) {
            return 2;
        }
        msmValue.put("code", code);
        msmValue.put("expiryDate", System.currentTimeMillis() + expriedTime * 1000);
        msmValue.put("resendTime", System.currentTimeMillis() + resendtime * 1000);
        smsCodeRedisDao.saveMsgCode(phone, msmValue, expriedTime);
        return 0;
    }


    @Transactional
    public int registerUser(String truename, String phone, String code, String password) throws UserRegisterException {
        Map msgCode = smsCodeRedisDao.getMsgCode(phone);
        User user = userRepository.findOneByPhone(phone);
        if (user != null) {
            return 1;
        }

        if (msgCode == null || !code.equals(msgCode.get("code").toString())) {
            return 2;
        }

        user = new User();
        user.setTruename(truename);
        user.setNickname(phone);
        user.setPassword(password);
        user.setPhone(phone);
        user = userRepository.save(user);
        smsCodeRedisDao.dropMsgCode(phone);
        if (user.getUuid() == null) {
            return 10;
        }
        return 0;
    }


    /**
     * @param phone
     * @param password
     * @return 0验证成功  1无该用户  2密码错误 3其他
     */
    @Transactional(readOnly = true)
    public int authUserPhoneAndPassword(String phone, String password) {
        User user = userRepository.findOneByPhone(phone);
        if (user == null) {
            return 1;
        }
        if (!user.getPassword().equals(password.trim())) {
            return 2;
        }
        return 0;
    }
}
