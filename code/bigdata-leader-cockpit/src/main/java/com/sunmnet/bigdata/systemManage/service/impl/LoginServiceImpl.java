package com.sunmnet.bigdata.systemManage.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemAdminInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.AdminStatusEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.SystemManageResultEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.AdminMenuInfoRoleModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.SystemAdminLoginRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.SystemAdminLoginResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetSystemAdminInfoDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetSystemAdminMenuInfoDao;
import com.sunmnet.bigdata.systemManage.service.LoginService;
import com.sunmnet.bigdata.systemManage.util.SystemManageConstants;

/**
 * 管理员登录实现
 * @author wm
 * @create 2018-03-20
 */
@Service
public class LoginServiceImpl implements LoginService {
	
	private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Autowired
	private SunmnetSystemAdminInfoDao sunmnetSystemAdminInfoDao;
	@Autowired
	private SunmnetSystemAdminMenuInfoDao sunmnetSystemAdminMenuInfoDao;
	/**
     * 管理员登录
     * @param userLoginRequest
     * @param session 
     * @author wm
     * @create 2018-03-20
     * @return
     */
	@Override
	public BaseResponseInfo<SystemAdminLoginResponse> loginIn(SystemAdminLoginRequest systemAdminLoginRequest,HttpSession session) {
		SystemManageResponseInfo<SystemAdminLoginResponse> responseInfo = new SystemManageResponseInfo<SystemAdminLoginResponse>();
		try {
			//1、判断管理员是否存在
			String adminMobile = systemAdminLoginRequest.getAdminMobile();
			SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity = sunmnetSystemAdminInfoDao.getSystemAdminInfoByAdminMobile(adminMobile);
			if(sunmnetSystemAdminInfoEntity==null){
				logger.info("管理员登录--无此用户;管理员手机号："+adminMobile);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_SYSTEM_AMDIN);
				return responseInfo;
			}
			String adminPasswordQuery = sunmnetSystemAdminInfoEntity.getAdminPassword();
			String adminPassword = systemAdminLoginRequest.getAdminPassword();
			String adminNo = sunmnetSystemAdminInfoEntity.getAdminNo();
			if(adminPasswordQuery.equals(adminPassword)){
				SystemAdminLoginResponse systemAdminLoginResponse = new SystemAdminLoginResponse();
				systemAdminLoginResponse.setAdminName(sunmnetSystemAdminInfoEntity.getAdminName());
				systemAdminLoginResponse.setAdminNo(adminNo);
				//2、检验用户状态
				AdminStatusEnum adminStatus = sunmnetSystemAdminInfoEntity.getAdminStatus();
				if(!AdminStatusEnum.NORMAL.equals(adminStatus)){
					logger.info("管理员登录--管理员状态不正常;管理员编号："+adminNo);
					responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.STATUS_NOT_NORMAL);
					return responseInfo;
				}
				//3、把管理员数据，权限相关信息保存在session域对象中
				session.setAttribute("adminInfo", sunmnetSystemAdminInfoEntity);
				//4、判断管理员密码是否是初始密码，初始密码登录失败返回修改密码
				if(adminPassword.equals(SystemManageConstants.ADMIN_INIT_PASSWORD)){
					logger.info("管理员登录--密码是初始密码;管理员编号："+adminNo);
					responseInfo.setBaseResponseInfo(BaseResultEnum.INIT_PASSWORD,systemAdminLoginResponse);
					return responseInfo;
				}
				
				//查询管理员菜单权限信息返回
				List<AdminMenuInfoRoleModel> menuList = sunmnetSystemAdminMenuInfoDao.findSystemAdminMenuUrlByAdminNo(adminNo);
				systemAdminLoginResponse.setMenuUrls(menuList);
				responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,systemAdminLoginResponse);
			}else{
				logger.info("管理员登录--密码错误;管理员编号："+adminNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.ERROR_PASSWORD);
				return responseInfo;
			}
					
		} catch (Exception e) {
			logger.error("管理员登录--异常", e);
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
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
            //把用户数据从session对象中剔除
            if(session!=null){ 
            	 session.removeAttribute("adminInfo");
            	// 注销用户，使session失效。
            	 session.invalidate();
            }  
            responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("管理员注销--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
}
