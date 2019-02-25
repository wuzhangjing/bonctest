package com.wisely.springMvc;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;

//WebApplicationInitializer  替代了web.xml 实现此接口将会自动被SpringServletContainerInitializer（用来启动servlet3.0容器）获取到。
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException{
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MyMvcConfig.class);
        //新建WebApplicationContext, 注册配置，并将其和当前servletContext关联。
        ctx.setServletContext(servletContext);

        //注册Spring MVC的DispatcherServlet.
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
