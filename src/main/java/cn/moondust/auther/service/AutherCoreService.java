package cn.moondust.auther.service;

import cn.moondust.auther.entity.AuthClient;
import cn.moondust.auther.entity.AuthToken;
import cn.moondust.auther.entity.difs.AutherScope;
import cn.moondust.auther.exception.AuthLoginException;
import cn.moondust.auther.exception.PhoneAndPsdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by j0 on 2016/8/3.
 */
@Service
public class AutherCoreService {

    @Autowired
    AuthClientService authClientService;


    @Autowired
    AutherUserService autherUserService;


    @Autowired
    AuthTokenService authTokenService;

    @Transactional(readOnly = true)
    public AuthClient authByAuthCode( String client_id, String scope, String redirectUrl,String auth_type) throws AuthLoginException {
        AuthClient client = authAuthClient(client_id, scope,redirectUrl,auth_type);
        return client;
    }




    @Transactional(readOnly = true)
    public AuthToken authByPassword(String client_id, String clientSecret, String scope, String phone, String password) throws AuthLoginException, PhoneAndPsdException {
        AuthClient client = authAuthClient(client_id, client_id, client_id, scope);
        if(!client.getClientSecret().equals(clientSecret)){
            throw new AuthLoginException();
        }

        int i = autherUserService.authUserPhoneAndPassword(phone, password);


        if (i!=0){
            throw new PhoneAndPsdException(i);
        }

        AuthToken token= authTokenService.buildToken(phone,scope);
        return token;
    }



    private boolean isContainerScope(String scope, AuthClient client) {
        boolean isContainer = false;
        if (AutherScope.SCOPE_ALL.equals(client.getScope())) {
            isContainer = true;
        } else {
            List<String> scopes = Arrays.asList(client.getScope().split(","));
            for(String s :scopes){
                if (s.equals(scope)){
                    isContainer=true;
                }
            }
        }
        return isContainer;
    }

    private AuthClient authAuthClient( String client_id, String scope,String redirectUrl, String auth_type) throws AuthLoginException {
        AuthClient client = authClientService.selectClientByClientId(client_id);
        if (client == null||!client.getAuthType().equals(auth_type)) {
            throw new AuthLoginException();
        }

        boolean isContainer = isContainerScope(scope, client);
        if (!isContainer){
            throw new AuthLoginException();
        }
        return client;
    }
}
