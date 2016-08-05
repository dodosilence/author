package cn.moondust.auther.advice;

import cn.moondust.auther.controller.business.AuthorityController;
import cn.moondust.auther.exception.AuthLoginException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by j0 on 2016/8/3.
 */
@ControllerAdvice(basePackageClasses = AuthorityController.class,annotations = Controller.class)
public class AuthControllerAdvice {

    @ExceptionHandler(AuthLoginException.class)
    public String authLoginException(){

        return "500";
    }





}
