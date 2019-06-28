package com.cyzs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiaoH
 * @create 2019-06-28-23:23
 */
@Controller
public class TestException {

    @RequestMapping("/exception")
    public String exception(){
        int a=10/0;
        return "success";
    }
}
