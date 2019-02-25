package com.wisely.springMvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//继承HandlerInterceptorAdapter类来实现自定义拦截器
public class DemoInterceptor extends HandlerInterceptorAdapter {

    @Override
    //重写preHandle方法，在请求发生前执行
    public boolean preHandle (HttpServletRequest request,
                              HttpServletResponse response, Object handle) throws Exception{
        long startTime = System.currentTimeMillis();
        request.setAttribute("starttime", startTime);
        return true;
    }

    @Override
    //重写postHandle，在请求完成后执行
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handle,
                           ModelAndView modelAndView) throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.println("本次请求处理时间为：" + new Long(endTime - startTime) + "ms");
        request.setAttribute("handlingTime", endTime - startTime);
    }

    /*@Bean
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }

    @Override
    public void addInterceptor(InterceptorRegistry registry){
        registry.addInterceptor(demoInterceptor());
    }*/
}
