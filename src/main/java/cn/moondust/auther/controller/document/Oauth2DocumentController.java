package cn.moondust.auther.controller.document;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by j0 on 2016/8/5.
 */
@Controller
@RequestMapping("api")
public class Oauth2DocumentController {

    @RequestMapping("oauth2.0.html")
    public String oauth2Doc() {

        return "/root/apis/oauth2.0";
    }


}
