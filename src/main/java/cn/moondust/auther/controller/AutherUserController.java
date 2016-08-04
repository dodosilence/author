package cn.moondust.auther.controller;

import cn.moondust.auther.exception.UserRegisterException;
import cn.moondust.auther.service.AutherUserService;
import cn.moondust.auther.utils.PatternUtil;
import cn.moondust.auther.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by j0 on 2016/8/3.
 */
@Controller
@RequestMapping("authuser")
public class AutherUserController {
    @Autowired
    AutherUserService autherUserService;


    /**
     * @param phone
     * @return 0成功   -1手机号格式不正确 1发送频繁
     */
    @RequestMapping(value = "sendcode", method = RequestMethod.POST)
    @ResponseBody
    public Object sendCode(@RequestParam(value = "phone", required = true) String phone, HttpServletRequest request) {
        return autherUserService.sendMsgCode(phone);
    }


    /**
     * @param truename
     * @param phone
     * @param code
     * @param password
     * @param passwordConfirm
     * @return 0   成功    1 已经被注册   2  验证码错误   3密码不合法   4密码不同  10其他错误
     * @throws UserRegisterException
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public Object register(@RequestParam("register_truename") String truename,
                           @RequestParam("phone") String phone, @RequestParam("code") String code,
                           @RequestParam("register_password") String password,
                           @RequestParam("register_password_confirm") String passwordConfirm) throws UserRegisterException {
        if (StringUtil.empty(password) || password.length() <= 6)  return 3;

        if (!password.equals(passwordConfirm))  return 4;

        return  autherUserService.registerUser(truename, phone, code, password);
    }


}
