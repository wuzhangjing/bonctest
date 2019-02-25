package com.wisely.springMvc.web.ch4_3;


import com.wisely.springMvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

//此类是一个控制器
@Controller
//映射此类的访问路径是/anno
@RequestMapping("/anno")
public class DemoAnnoController {

    //此方法未标注路径，因此使用类级别的访问路径/anno，produces可定制返回的response的媒体类型和字符集，
    // 或需要返回的是json对象，则设置produces="application/json;charset=UTF-8"
    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public @ResponseBody String index(HttpServletRequest request){   //可接受httpServletRequest作为参数
        return "url:" + request.getRequestURL() + " can accss";
    }

    //接收参数路径，并在方法前结合@PathVariable使用，访问路径为/anno/pathvar/XX
    @RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String demoPathVar(@PathVariable String str, HttpServletRequest request){
        return "url:" + request.getRequestURL() + " can access, str: " + str;
    }

    //演示常规的request参数获取，访问路径为/anno/requestParam?id=1。
    @RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String passRequestParam(Long id, HttpServletRequest request){
        return "url:" + request.getRequestURL() + " can access, id: " + id;
    }

    //演示解释参数到对象，访问路径为/anno/obj?id=1&name=XX
    @RequestMapping(value = "obj", produces = "application/json;charset=UTF-8")
    @ResponseBody   //@requestBody也可以放在方法上
    public String passObj(DemoObj obj, HttpServletRequest request){
        return "url:" + request.getRequestURL() + obj.getId() + " obj name: " + obj.getName();
    }

    //映射不通的路径到相同的方法上，访问路径为/anno/name1或/anno/name2
    @RequestMapping(value = {"/name1", "name2"}, produces = "text/plain;charset=UTF-8")
    public @ResponseBody String remove(HttpServletRequest request){
        return "url:" + request.getRequestURL() + " can access";
    }

}
