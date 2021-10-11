package com.sunmnet.bigdata.systemManage.biz;

import javax.servlet.http.HttpSession;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.SystemAdminLoginRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.SystemAdminLoginResponse;



/**
 * 用户登录校验
 * @author wm
 * @create 2018-03-20
 */
public interface LoginBiz {
	/**
     * 用户登录
     * @param systemAdminLoginRequest
     * @param session 
     * @author wm
     * @create 2018-03-20
     * @return
     */
	public BaseResponseInfo<SystemAdminLoginResponse> loginIn(SystemAdminLoginRequest systemAdminLoginRequest,HttpSession session);
	/**
     * 用户注销
     * @param session
     * @author wm
     * @create 2018-03-20
     * @return
     */
	public BaseResponseInfo<Object> logout(HttpSession session);
	
}
