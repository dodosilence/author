package cn.moondust.auther.controller.business;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by j0 on 2016/8/3.
 */
@Controller
public class StaticPageController {

    @RequestMapping(value = "registration.html",method = RequestMethod.GET)
    public String registrationPage(){
        return "registration";
    }
}
