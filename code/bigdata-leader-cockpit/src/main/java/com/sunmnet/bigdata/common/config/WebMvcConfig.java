package com.sunmnet.bigdata.common.config;

import javax.annotation.Resource;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.sunmnet.bigdata.common.interceptor.ApiCostInterceptor;

/**
 * Spring Boot MVC相关配置
 */
@SpringBootConfiguration
//@EnableWebMvc
//@EnableAspectJAutoProxy
//@ComponentScan(basePackages = {"com.sunmnet.bigdata.common","com.sunmnet.bigdata.web", "com.sunmnet.bigdata.systemManage", "com.sunmnet.bigdata.loginWeb"})
public class WebMvcConfig extends WebMvcConfigurerAdapter
{

    @Resource
    private ApplicationContext ctx;

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        super.addInterceptors(registry);
        registry.addInterceptor(ctx.getBean(ApiCostInterceptor.class)).addPathPatterns("/**");
        // registry.addInterceptor(ctx.getBean(SecurityInterceptor.class)).addPathPatterns("/**")
        // .excludePathPatterns("/user/login","/user/redirectLogin", "/user/getAccessMenu",
        // "/base_word/findAllWordBook","/student/find");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
//        super.addResourceHandlers(registry);
//        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
