package com.cyzs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaoH
 * @create 2019-06-27-18:53
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello成功";
    }

    //跳转到  success.html
    @RequestMapping("/page")
    public String page(){
        return "success";
    }



}
