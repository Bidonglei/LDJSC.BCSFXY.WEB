//package com.sunmnet.bigdata.common.interceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//
///**
// * 用户登录权限拦截器
// * @author wm
// * @create 2018-03-20
// */
//@Component
//public class LoginSecurityInterceptor implements HandlerInterceptor{
//
//	@SuppressWarnings("unused")
//	private Logger logger = LoggerFactory.getLogger(LoginSecurityInterceptor.class);
//
//	@Override
//	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object obj, Exception ex)
//			throws Exception {
//	}
//
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response,
//			Object obj, ModelAndView arg3) throws Exception {
//	}
//
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object obj) throws Exception {
//		//1、判断管理员session是否失效
//		/*HttpSession session = request.getSession();
//		SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity = (SunmnetSystemAdminInfoEntity)session.getAttribute("adminInfo");
//		if(sunmnetSystemAdminInfoEntity == null){
//		   logger.warn("管理员session已经过期");
//		   throw new SessionInvalidException();
//		}*/
//		return true;
//	}
//
//}
