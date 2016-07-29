package cn.moondust.auther.controller;

import cn.moondust.auther.entity.AuthClient;
import cn.moondust.auther.service.AuthClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by j0 on 2016/7/29.
 */
@Controller
@RequestMapping("/")
public class AuthorityController {


    @Autowired
    AuthClientService authClientService;

    @RequestMapping(value = "/auth_login", method = RequestMethod.GET)
    public String authlogin(@RequestParam("client_id") String client_id,
                            @RequestParam("scope") String scope,
                            @RequestParam("redirect_url") String redirectUrl,
                            @RequestParam("state") String state, Model model) {
        boolean res = false;
        AuthClient client = authClientService.selectClientByClientId(client_id);
        model.addAttribute("client",client);
        model.addAttribute("state",state);
        model.addAttribute("redirectUrl",redirectUrl);
        return "/auth/auth_page";
    }








    @RequestMapping(value = "/auth_qacode", method = RequestMethod.GET)
    public String authqacode(@RequestParam("client_id") String client_id,
                             @RequestParam("scope") String scope,
                             @RequestParam("redirect_url") String redirectUrl,
                             @RequestParam("state") String state) {


        return "home/auth/auth_page";
    }






    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String authLogin(@RequestParam("auth_username") String username,
                            @RequestParam("auth_password") String password,
                            @RequestParam("client_id") String client_id,
                            @RequestParam("redirect_url") String redirectUrl){



        return "redirect:"+redirectUrl+"?code=asdasd16513215as4d6asd136566";
    }


}
