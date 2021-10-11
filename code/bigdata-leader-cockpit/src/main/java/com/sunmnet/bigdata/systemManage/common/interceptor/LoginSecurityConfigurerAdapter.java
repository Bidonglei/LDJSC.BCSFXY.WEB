//package com.sunmnet.bigdata.systemManage.common.interceptor;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//public class LoginSecurityConfigurerAdapter extends WebMvcConfigurerAdapter {
//
//	@Override
//    public void addInterceptors(InterceptorRegistry registry) {
//		super.addInterceptors(registry);
//		registry.addInterceptor(new LoginSecurityInterceptor()).addPathPatterns("/**")
//        .excludePathPatterns("/manage/login/login").excludePathPatterns("/userRemote/**")
//        .excludePathPatterns("/menuRemote/**");
//
//    }
//}
