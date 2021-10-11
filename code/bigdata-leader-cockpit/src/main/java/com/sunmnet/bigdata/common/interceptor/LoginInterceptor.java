package com.sunmnet.bigdata.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.sunmnet.bigdata.loginWeb.supwisdom.Constants;
import com.sunmnet.bigdata.loginWeb.supwisdom.LoginUser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Auther: lkg
 * @Date: 2019/7/16 14:50
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		LoginUser user = (LoginUser) request.getSession().getAttribute(Constants.LOGIN_USER_KEY);
		//如果session中没有user，表示没登陆
//		if (user == null){
			//这个方法返回false表示忽略当前请求，如果一个用户调用了需要登陆才能使用的接口，如果他没有登陆这里会直接忽略掉
			//当然你可以利用response给用户返回一些提示信息，告诉他没登陆
//			Map<String,Object> error = new HashMap<>();
//			error.put("obj","-1");
//			response.setCharacterEncoding("UTF-8");
//			PrintWriter printWriter=response.getWriter();
//			printWriter.write(JSON.toJSONString(error));
//			printWriter.flush();
//			printWriter.close();
//			return false;
//		}else {
			return true;    //如果session里有user，表示该用户已经登陆，放行，用户即可继续调用自己需要的接口
//		}

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}