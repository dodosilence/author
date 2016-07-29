package cn.moondust.auther.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by j0 on 2016/7/29.
 */
@Controller
public class HomePageController {
    @RequestMapping({"/","","index**"})
    public String homePage(){

        return "index";
    }
}
