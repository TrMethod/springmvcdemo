package com.cyzs.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xiaoH
 * @create 2019-06-28-23:11
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler
    public ModelAndView exception1(Exception ex){
        //出现异常时跳转到errorPage页面   经过视图解析器
        ModelAndView modelAndView = new ModelAndView("errorPage");
        //errorPage页面添加异常信息
        modelAndView.addObject("exception", ex.getMessage());
        return modelAndView;
    }
}
