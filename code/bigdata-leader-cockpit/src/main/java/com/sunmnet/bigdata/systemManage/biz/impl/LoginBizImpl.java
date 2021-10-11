package com.sunmnet.bigdata.systemManage.biz.impl;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.SystemAdminLoginRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.SystemAdminLoginResponse;
import com.sunmnet.bigdata.systemManage.biz.LoginBiz;
import com.sunmnet.bigdata.systemManage.service.LoginService;

/**
 * 用户登录校验实现
 * @author wm
 * @create 2018-03-20
 */
@Service
public class LoginBizImpl implements LoginBiz {
	
	private Logger logger = LoggerFactory.getLogger(LoginBizImpl.class);
	
	
	@Autowired
	private LoginService loginService;
	
	/**
     *	管理员登录
     * @param systemAdminLoginRequest
     * @param session 
     * @author wm
     * @create 2018-03-20
     * @return
     */
	@Override
	public BaseResponseInfo<SystemAdminLoginResponse> loginIn(SystemAdminLoginRequest systemAdminLoginRequest,HttpSession session) {
		BaseResponseInfo<SystemAdminLoginResponse> responseInfo = new BaseResponseInfo<SystemAdminLoginResponse>();
		try {
			responseInfo = loginService.loginIn(systemAdminLoginRequest,session);
		} catch (Exception e) {
			logger.error("管理员登录校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 管理员注销
     * @param session
     * @author wm
     * @create 2018-03-20
     * @return
     */
	@Override
	public BaseResponseInfo<Object> logout(HttpSession session) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = loginService.logout(session);
		} catch (Exception e) {
			logger.error("管理员注销校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
}
