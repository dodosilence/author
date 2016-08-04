package cn.moondust.auther.service;

import cn.moondust.auther.entity.AuthClient;
import cn.moondust.auther.repository.AuthClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by j0 on 2016/7/29.
 */
@Service
public class AuthClientService {
    @Autowired
    AuthClientRepository authClientRepository;


    @Transactional(readOnly = true)
    public AuthClient selectClientByClientId(String client_id) {
        AuthClient authClient = authClientRepository.findOneByClientId(client_id);
        return authClient;
    }

    @Transactional
    public AuthClient insertOneClient(AuthClient authClient) {
        return  authClientRepository.save(authClient);
    }



}
