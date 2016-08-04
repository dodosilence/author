package cn.moondust.auther.service;

import cn.moondust.auther.entity.AuthToken;
import cn.moondust.auther.repository.UserRepository;
import cn.moondust.auther.repository.redis.TokenRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by j0 on 2016/8/4.
 */
@Service
public class AuthTokenService {

    @Autowired
    TokenRedisDao tokenRedisDao;

    @Autowired
    UserRepository userRepository;

    public AuthToken buildToken(String phone, String scope) {
        UUID access_token = UUID.randomUUID();
        UUID refresh_token = UUID.randomUUID();
        AuthToken authToken = new AuthToken();
        authToken.setAccessToken(access_token.toString());
        authToken.setRefreshToken(refresh_token.toString());
        authToken.setExpiredIn(600l);
        tokenRedisDao.saveToken(authToken,userRepository.findOneByPhone(phone));
        return authToken;
    }
}
