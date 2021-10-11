package com.sunmnet.bigdata.systemManage.service;

import javax.servlet.http.HttpSession;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.SystemAdminLoginRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.SystemAdminLoginResponse;



/**
 * 管理员登录
 * @author wm
 * @create 2018-02-20
 */
public interface LoginService {
	/**
     * 管理员登录
     * @param systemAdminLoginRequest
	 * @param session 
	 * @author wm
     * @create 2018-03-20
     * @return
     */
	public BaseResponseInfo<SystemAdminLoginResponse> loginIn(SystemAdminLoginRequest systemAdminLoginRequest, HttpSession session);
	/**
     * 管理员注销
     * @param session
     * @author wm
     * @create 2018-03-20
     * @return
     */
	public BaseResponseInfo<Object> logout(HttpSession session);
	
}
