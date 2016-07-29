package cn.moondust.auther.service;

import cn.moondust.auther.entity.AuthClient;
import cn.moondust.auther.repository.AuthClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by j0 on 2016/7/29.
 */
@Service
public class AuthClientService {
    @Autowired
    AuthClientRepository authClientRepository;


    @Transactional
    public AuthClient selectClientByClientId(String client_id) {
        List<AuthClient> authClients = authClientRepository.findAll();

        return null;
    }
}
