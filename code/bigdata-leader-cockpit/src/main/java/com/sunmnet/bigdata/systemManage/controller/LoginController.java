package com.sunmnet.bigdata.systemManage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.SystemAdminLoginRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.SystemAdminLoginResponse;
import com.sunmnet.bigdata.systemManage.biz.LoginBiz;
import com.sunmnet.bigdata.systemManage.common.exception.SystemManageException;
import com.sunmnet.bigdata.systemManage.common.log.LoggerManage;

/**
 * 管理员登录
 * @author wm
 * @create 2018-03-20
 */
@RestController
@RequestMapping("/manage/login")
public class LoginController extends BaseController {
	@Autowired
	private LoginBiz loginBiz;
	/**
     * 管理员登录
     * @param systemAdminLoginRequest
     * @author wm
     * @create 2018-03-20
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/login")
    @LoggerManage(description = "管理员登录")
    public BaseResponseInfo<SystemAdminLoginResponse> loginIn(@Validated  SystemAdminLoginRequest systemAdminLoginRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<SystemAdminLoginResponse> responseInfo = new BaseResponseInfo<SystemAdminLoginResponse>();
		try {
			//创建session对象
            HttpSession session = super.getRequest().getSession();
			responseInfo = loginBiz.loginIn(systemAdminLoginRequest,session);
		} catch (Exception e) {
			logger.error("管理员登录--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	/**
     * 管理员注销
     * @author wm
     * @create 2018-03-20
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/logout")
    @LoggerManage(description = "管理员注销")
    public BaseResponseInfo<Object> logout() {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			//创建session对象
            HttpSession session = super.getRequest().getSession();
			responseInfo = loginBiz.logout(session);
		
		} catch (Exception e) {
			logger.error("管理员注销--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
}
