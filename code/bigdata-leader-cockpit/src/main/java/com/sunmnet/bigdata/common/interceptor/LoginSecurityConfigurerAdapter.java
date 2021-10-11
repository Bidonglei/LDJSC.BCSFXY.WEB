package com.sunmnet.bigdata.common.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class LoginSecurityConfigurerAdapter extends WebMvcConfigurerAdapter {

/*	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(new LoginSecurityInterceptor()).addPathPatterns("/**")
        .excludePathPatterns("/manage/login/login").excludePathPatterns("/userRemote/**")
        .excludePathPatterns("/menuRemote/**");

    }*/

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
				.excludePathPatterns("/cas/login").excludePathPatterns("/cas/validate")
				.excludePathPatterns("/cas/logout")
				.excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");

	}
}
