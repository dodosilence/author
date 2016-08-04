package cn.moondust.auther.controller;

import cn.moondust.auther.entity.AuthClient;
import cn.moondust.auther.service.AuthClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.UUID;

/**
 * Created by j0 on 2016/8/3.
 */
@Controller
@RequestMapping("auth")
public class AutherClientController {
    @Autowired
    AuthClientService authClientService;



    @RequestMapping(value = "register",method = RequestMethod.POST)
    @ResponseBody
    public Object registerClient(){
        AuthClient authClient = new AuthClient();
        authClient.setClientId(UUID.randomUUID().toString());
        authClient.setClientSecret(UUID.randomUUID().toString());
        authClient.setAuthType("password");
        authClient.setScope("all");
        authClient.setRedirectUrl("http://www.baidu.com");
        authClient.setCreateDate(new Date());
        authClient.setUpdateDate(new Date());
        authClient=authClientService.insertOneClient(authClient);
        return authClient;
    }










}
