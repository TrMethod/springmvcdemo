package com.cyzs.controller;

import beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoH
 * @create 2019-06-28-18:51
 */
@Controller
public class UserController {

    @InitBinder
    public void inirbinder(WebDataBinder dataBinder){
        ///忽略LastName属性赋值
        dataBinder.setDisallowedFields();
    }


    @RequestMapping("/toAdd")
    public String add(Map<String,Object> map){
        map.put("user",new User());
        return "forward:add.jsp";
    }

    @RequestMapping(value = "/addUser" ,method = RequestMethod.POST)
    public String addUser(User user){
        System.out.println("------------");
        System.out.println(user);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/testJson")
    public List<User> testJson(){
        List<User> list = new ArrayList<>();
        User user = new User("王二", 1, new Date(), "北京");
        User user1 = new User("王二", 1, new Date(), "北京");
        User user2 = new User("王二", 1, new Date(), "北京");
        User user3 = new User("王二", 1, new Date(), "北京");
        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list;
    }



}
