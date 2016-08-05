package cn.moondust.auther.controller.business;

import cn.moondust.auther.controller.entity.RespEntity;
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
import org.springframework.web.bind.annotation.ResponseBody;

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

                            Model model) throws AuthLoginException, PhoneAndPsdException {
        if (AutherType.AUTH_CODE.equals(authType)) {
            AuthClient client = autherCoreService.authByAuthCode(client_id, scope, redirectUrl, authType);
            model.addAttribute("client", client);
            model.addAttribute("state", state);
            model.addAttribute("redirectUrl", redirectUrl);
            return "/auth/auth_page";
        } else if (AutherType.PASSWORD.equals(authType)) {

            return "redirect:/auth_password";

        } else {
            throw new AuthLoginException();
        }
    }


    @RequestMapping(value = "auth_password", method = RequestMethod.GET)
    @ResponseBody
    public Object authPassword(@RequestParam("client_id") String client_id,
                               @RequestParam("redirect_url") String redirectUrl,
                               @RequestParam("scope") String scope,
                               @RequestParam(value = "auther_password", required = false) String password,
                               @RequestParam(value = "auther_phone", required = false) String phone,
                               @RequestParam(value = "client_secret", required = false) String clientSecret) {
        AuthToken token = null;
        if (!StringUtil.empty(password) && !StringUtil.empty(phone) && !StringUtil.empty(clientSecret)) {
            try {
                token = autherCoreService.authByPassword(client_id, clientSecret, scope, phone, password);
            } catch (AuthLoginException e) {
                return new RespEntity(11, "client_bad_verification");
            } catch (PhoneAndPsdException e) {
                return new RespEntity(e.getCode(), "user_bad_verification");
            }
        }
        return token;
    }


    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String authLogin(@RequestParam("auth_username") String username,
                            @RequestParam("auth_password") String password,
                            @RequestParam("client_id") String client_id,
                            @RequestParam("redirect_url") String redirectUrl) {


        return "redirect:" + redirectUrl + "?code=asdasd16513215as4d6asd136566";
    }


}
