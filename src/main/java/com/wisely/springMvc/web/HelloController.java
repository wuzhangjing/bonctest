package com.wisely.springMvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.GET;

//声明是一个控制器
@Controller
public class HelloController {

    //配置URL和方法之间的映射
    @RequestMapping("/index")
    public String hello(){
        System.out.println("1111111");
        //通过ViewResolver的Bean配置，返回值为index，说明我们的页面放置
        //的路径为/WEB-INF/classes/views/index.jsp
        return "index";
    }

    @RequestMapping("/")
    public String index(){
        System.out.println("1111111");
        //通过ViewResolver的Bean配置，返回值为index，说明我们的页面放置
        //的路径为/WEB-INF/classes/views/index.jsp
        return "home";
    }

    @RequestMapping(value = "/ceshi", method = RequestMethod.GET)
    public @ResponseBody void ceshi(){
        for(int i=0; i<10;i++){
            System.out.println("====i:"+i);
        }
    }
}
