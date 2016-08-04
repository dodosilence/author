package cn.moondust.auther.repository.redis;

import cn.moondust.auther.utils.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by j0 on 2016/8/3.
 */
@Repository
public class SmsCodeRedisDao {
    public static final String key = "msm:{phone}";
    private static  final  int dbindex=10;

    @Autowired
    RedisTemplate<String, String> redisTemplate;


    public void saveMsgCode(String phone, Map msmValue,Long expire) {
        String opKey = key.replace("{phone}", phone);
        RedisCallback<Boolean> calback=redisConnection -> {
            redisConnection.select(dbindex);
            redisConnection.set(opKey.getBytes(), JSONUtil.objectToJsonStr(msmValue).getBytes());
            return redisConnection.expire(opKey.getBytes(), expire);
        };
        redisTemplate.execute(calback);
    }

    public Map getMsgCode(String phone) {
        String opKey = key.replace("{phone}", phone);
        RedisCallback<Map> calback=redisConnection -> {
            redisConnection.select(dbindex);
            byte[] bytes = redisConnection.get(opKey.getBytes());

            if (bytes==null){
                return null;
            }
            String res = new String(bytes);
            Map<String, Object> map=null;
            try {
                 map= JSONUtil.jsonToMap(JSONObject.parseObject(res));
            } catch (Exception e) {

            }
            return  map;
        };
        return redisTemplate.execute(calback);
    }


    public void dropMsgCode(String phone) {
        String opKey = key.replace("{phone}", phone);
        RedisCallback<Long> calback=redisConnection -> {
            redisConnection.select(dbindex);
            return redisConnection.del(opKey.getBytes());
        };
        redisTemplate.execute(calback);
    }


}
