package cn.moondust.auther.repository.redis;

import cn.moondust.auther.entity.AuthToken;
import cn.moondust.auther.entity.User;
import cn.moondust.auther.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * Created by j0 on 2016/8/4.
 */

@Repository
public class TokenRedisDao {

    private static final String  tokenKey="token:{access_token}";
    private static  final  String  refreshTokenKey ="refreshToken:{refresh_token}";
    private final  int dbindex=1;

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    public void saveToken(AuthToken authToken, User user) {
        String access_token_key=tokenKey.replace("{access_token}",authToken.getAccessToken());
        String refresh_token_key=refreshTokenKey.replace("{refresh_token}",authToken.getRefreshToken());
        HashMap<String, Object> access_token_value = new HashMap<>();
        access_token_value.put("access_token",authToken.getAccessToken());
        access_token_value.put("refresh_token",authToken.getRefreshToken());
        access_token_value.put("expired_id",authToken.getExpiredIn());
        access_token_value.put("user_id",user.getUuid());
        String value = JSONUtil.objectToJsonStr(access_token_value);
        RedisCallback<Boolean> calback=redisConnection -> {
            redisConnection.select(dbindex);
            redisConnection.set(access_token_key.getBytes(),value.getBytes());
            redisConnection.expire(access_token_key.getBytes(),authToken.getExpiredIn()*2);
            redisConnection.set(refresh_token_key.getBytes(),value.getBytes());
            return true;
        };
        redisTemplate.execute(calback);
    }
}
