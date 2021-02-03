package com.example.demo.liuyi.component.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice

public class globalHander {

    @ExceptionHandler(expireException.class)
    public @ResponseBody
    String handleExpireException(Exception e){
        if(e instanceof expireException){
            return ((expireException) e).er;
        }
        return "no";
    }
}
