package com.cyzs.controller;

import beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

/**
 * @author xiaoH
 * @create 2019-06-27-20:30
 */
@SessionAttributes(value = {"user"},types = {String.class})
@Controller
public class RequestMappingDemoController {

    private final String SUCCESS="success";

    @RequestMapping("/forward")
    public String testForward(){
        //转发不经过视图解析器
        return "forward:/WEB-INF/pages/abc.jsp";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("重定向");
        //重定向，根据/viewTest进行请求处理
        return "redirect:/viewTest";
    }

    @RequestMapping("/viewTest")
    public String viewTest(Map<String,Object>map){
        System.out.println("视图分析");
        map.put("abc","哈哈");
        return SUCCESS;
    }

    /**
     * @ModelAttribute注解的方法在目标方法执行之前被调用
     * map中放的user，和页面传入的user对象属性，综合之后传到在目标方法参数中
     * @param id
     * @param map
     */
    @ModelAttribute
    public void getUser(@RequestParam(value = "id",required = false)Integer id,Map<String ,Object>map){
        if(id!=null){
            User user = new User("wang", 1, new Date(), "北京");
            System.out.println("从数据库获取");
            map.put("user",user);
        }
    }
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println(user);
        return SUCCESS;
    }

    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String,Object>map){
        map.put("user",new User("王二",1,new Date(),"北京"));
        map.put("company","阿里");
        return SUCCESS;
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","王二");
        modelAndView.setViewName(SUCCESS);
        return modelAndView;
    }

    /*
      value,method,params,headers,consumes,produces指定更具体的匹配
     */
    @RequestMapping(value = "/paramTest",method = RequestMethod.GET,params = {"name=tom"})
    public String param(){

        return "success";
    }

    @RequestMapping(value = "/header",headers = {})
    public String header(){
        return "success";
    }

    @RequestMapping("/requestParam")
    public String requestParam(@RequestParam(value = "name",required = false)String name){
        System.out.println(name+"========");
        return "success";
    }

    @RequestMapping("/cookie")
    public String cookie(@CookieValue(value = "JSESSIONID")String sessionID){
        System.out.println(sessionID);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/put/{id}",method = RequestMethod.PUT)
    public String put(@PathVariable("id")Integer id){
        System.out.println("put请求"+id);
        return "seccess";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public String delete(){
        System.out.println("delete请求");
        return "seccess";
    }

    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public String post(User user){
        System.out.println(user);
        return "seccess";
    }
}
