package cn.moondust.auther.controller;

import cn.moondust.auther.entity.AuthClient;
import cn.moondust.auther.entity.AuthToken;
import cn.moondust.auther.entity.difs.AutherType;
import cn.moondust.auther.exception.AuthLoginException;
import cn.moondust.auther.exception.PhoneAndPsdException;
import cn.moondust.auther.service.AuthClientService;
import cn.moondust.auther.service.AutherCoreService;
import cn.moondust.auther.utils.StringUtil;
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


    @Autowired
    AutherCoreService autherCoreService;

    @RequestMapping(value = "/auth_login", method = RequestMethod.GET)
    public String authlogin(@RequestParam("client_id") String client_id,
                            @RequestParam("redirect_url") String redirectUrl,
                            @RequestParam("state") String state,
                            @RequestParam("scope") String scope,
                            @RequestParam("auth_type") String authType,
                            @RequestParam(value = "auther_password", required = false) String password,
                            @RequestParam(value = "auther_phone", required = false) String phone,
                            @RequestParam(value = "client_secret", required = false) String clientSecret,
                            Model model) throws AuthLoginException, PhoneAndPsdException {
        if (AutherType.AUTH_CODE.equals(authType)) {
            AuthClient client = autherCoreService.authByAuthCode(client_id, scope, redirectUrl, authType);
            model.addAttribute("client", client);
            model.addAttribute("state", state);
            model.addAttribute("redirectUrl", redirectUrl);
            return "/auth/auth_page";
        } else if (AutherType.PASSWORD.equals(authType)) {
            if (!StringUtil.empty(password) && !StringUtil.empty(phone) && !StringUtil.empty(clientSecret)) {
                AuthToken token = autherCoreService.authByPassword(client_id, clientSecret, scope, phone, password);
                StringBuffer urlWithToken = new StringBuffer("redirect:").append(redirectUrl);
                urlWithToken.append("?access_token=")
                        .append(token.getAccessToken())
                        .append("&refresh_token=")
                        .append(token.getRefreshToken())
                        .append("&expired_id=")
                        .append(token.getExpiredIn());
                return urlWithToken.toString();
            } else {
                throw new AuthLoginException();
            }
        } else {
            throw new AuthLoginException();
        }
    }


    @RequestMapping(value = "/auth_qacode", method = RequestMethod.GET)
    public String authqacode(@RequestParam("client_id") String client_id,
                             @RequestParam("scope") String scope,
                             @RequestParam("redirect_url") String redirectUrl,
                             @RequestParam("state") String state) {


        return "home/auth/auth_page";
    }


    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String authLogin(@RequestParam("auth_username") String username,
                            @RequestParam("auth_password") String password,
                            @RequestParam("client_id") String client_id,
                            @RequestParam("redirect_url") String redirectUrl) {





        return "redirect:" + redirectUrl + "?code=asdasd16513215as4d6asd136566";
    }


}
