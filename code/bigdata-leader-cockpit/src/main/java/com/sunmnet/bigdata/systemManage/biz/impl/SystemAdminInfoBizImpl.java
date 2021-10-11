package com.sunmnet.bigdata.systemManage.biz.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemAdminInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemAdminMenuInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.SystemManageResultEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddSystemAdminInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.DeleteSystemAdminInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifySystemAdminInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifySystemAdminPasswordRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifySystemAdminStutasRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QuerySystemAdminInfoPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QuerySystemAdminInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ResetSystemAdminPasswordRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.SetSystemAdminMenuRoleRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QuerySystemAdminInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;
import com.sunmnet.bigdata.systemManage.biz.SystemAdminInfoBiz;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetSystemAdminInfoDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetSystemAdminMenuInfoDao;
import com.sunmnet.bigdata.systemManage.service.SystemAdminInfoService;
import com.sunmnet.bigdata.systemManage.util.SystemManageConstants;
/**
 * 管理员校验信息实现
 * @author wm
 * @create 2018-04-04
 */
@Service
public class SystemAdminInfoBizImpl implements SystemAdminInfoBiz {

	private Logger logger = LoggerFactory.getLogger(SystemAdminInfoBizImpl.class);
	
	@Autowired
	private SystemAdminInfoService systemAdminInfoService;
	@Autowired
	private SunmnetSystemAdminInfoDao sunmnetSystemAdminInfoDao;
	@Autowired
	private SunmnetSystemAdminMenuInfoDao sunmnetSystemAdminMenuInfoDao;
	
	/**
     * 新增管理员
     * @param addSystemAdminInfoRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	@Override
	public BaseResponseInfo<Object> addSystemAdminInfo(AddSystemAdminInfoRequest addSystemAdminInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			//1、判断手机号是否存在
			String adminMobile = addSystemAdminInfoRequest.getAdminMobile();
			SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity = sunmnetSystemAdminInfoDao.getSystemAdminInfoByAdminMobile(adminMobile);
			if(sunmnetSystemAdminInfoEntity!=null){
				logger.info("新增管理员--手机号已经存在;手机号："+adminMobile);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.MOBILE_EXISTENCE);
				return responseInfo;
			}
			responseInfo = systemAdminInfoService.addSystemAdminInfo(addSystemAdminInfoRequest);
		
		} catch (Exception e) {
			logger.error("新增管理员校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 删除管理员
     * @param deleteSystemAdminInfoRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	@Override
	public BaseResponseInfo<Object> deleteSystemAdminInfo(DeleteSystemAdminInfoRequest deleteSystemAdminInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			//1、判断管理员是否存在
			String adminNo = deleteSystemAdminInfoRequest.getAdminNo();
			SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity = sunmnetSystemAdminInfoDao.getSystemAdminInfoByAdminNo(adminNo);
			if(sunmnetSystemAdminInfoEntity==null){
				logger.info("删除管理员--管理员不存在;管理员编号："+adminNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_SYSTEM_AMDIN);
				return responseInfo;
			}
			//2、判断管理员下是否授权菜单
			List<SunmnetSystemAdminMenuInfoEntity> list = sunmnetSystemAdminMenuInfoDao.findSystemAdminMenuInfoByAdminNo(adminNo);
			if(list.size()>0){
				logger.info("删除管理员--管理员存在授权菜单;管理员编号："+adminNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.AMDIN_HAVE_MENU);
				return responseInfo;
			}
			responseInfo = systemAdminInfoService.deleteSystemAdminInfo(deleteSystemAdminInfoRequest);
		} catch (Exception e) {
			logger.error("删除管理员校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 修改管理员状态
     * @param modifySystemAdminInfoRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	@Override
	public BaseResponseInfo<Object> modifySystemAdminStatus(ModifySystemAdminStutasRequest modifySystemAdminInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			//1、判断管理员是否存在
			String adminNo = modifySystemAdminInfoRequest.getAdminNo();
			SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity = sunmnetSystemAdminInfoDao.getSystemAdminInfoByAdminNo(adminNo);
			if(sunmnetSystemAdminInfoEntity==null){
				logger.info("修改管理员状态--管理员不存在;管理员编号："+adminNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_SYSTEM_AMDIN);
				return responseInfo;
			}
			responseInfo = systemAdminInfoService.modifySystemAdminStatus(modifySystemAdminInfoRequest);
		} catch (Exception e) {
			logger.error("修改管理员状态校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 查询管理员信息列表
     * @param querySystemAdminInfoPageRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	@Override
	public BaseResponseInfo<PageResult> querySystemAdminInfoPage(QuerySystemAdminInfoPageRequest querySystemAdminInfoPageRequest) {
		SystemManageResponseInfo<PageResult> responseInfo = new SystemManageResponseInfo<PageResult>();
		try {
			String startTime = querySystemAdminInfoPageRequest.getStartTime();//开始时间格式YYYYMMDDHHmmss
		    String endTime = querySystemAdminInfoPageRequest.getEndTime();//结束时间格式YYYYMMDDHHmmss
		    if(startTime!=null&&(!"".equals(startTime))&&endTime!=null&&(!"".equals(endTime))){
		    	//把时间处理成17位YYYYMMDDHHmmssSSS
				String startTimeNew = startTime+SystemManageConstants.TIME_ADD_ZORE;//开始时间格式YYYYMMDDHHmmss
			    String endTimeNew = endTime+SystemManageConstants.TIME_ADD_ZORE;//结束时间格式YYYYMMDDHHmmss
			    querySystemAdminInfoPageRequest.setStartTime(startTimeNew);
			    querySystemAdminInfoPageRequest.setEndTime(endTimeNew);
		    }
			responseInfo = systemAdminInfoService.querySystemAdminInfoPage(querySystemAdminInfoPageRequest);
		} catch (Exception e) {
			logger.error("查询管理员信息列表--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 查询管理员详细信息
     * @param querySystemAdminInfoRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	@Override
	public BaseResponseInfo<QuerySystemAdminInfoResponse> querySystemAdminInfo(QuerySystemAdminInfoRequest querySystemAdminInfoRequest) {
		SystemManageResponseInfo<QuerySystemAdminInfoResponse> responseInfo = new SystemManageResponseInfo<QuerySystemAdminInfoResponse>();
		try {
			//1、判断管理员是否存在
			String adminNo = querySystemAdminInfoRequest.getAdminNo();
			SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity = sunmnetSystemAdminInfoDao.getSystemAdminInfoByAdminNo(adminNo);
			if(sunmnetSystemAdminInfoEntity==null){
				logger.info("查询管理员详细信息--管理员不存在;管理员编号："+adminNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_SYSTEM_AMDIN);
				return responseInfo;
			}
			responseInfo = systemAdminInfoService.querySystemAdminInfo(sunmnetSystemAdminInfoEntity);
		} catch (Exception e) {
			logger.error("查询管理员详细信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 重置管理员秘密
     * @param resetSystemAdminPasswordRequest
     * @author wm
     * @create 2018-04-06
     * @return
     */
	@Override
	public BaseResponseInfo<Object> resetSystemAdminPassword(ResetSystemAdminPasswordRequest resetSystemAdminPasswordRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			//1、判断管理员是否存在
			String adminNo = resetSystemAdminPasswordRequest.getAdminNo();
			SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity = sunmnetSystemAdminInfoDao.getSystemAdminInfoByAdminNo(adminNo);
			if(sunmnetSystemAdminInfoEntity==null){
				logger.info("重置管理员秘密--管理员不存在;管理员编号："+adminNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_SYSTEM_AMDIN);
				return responseInfo;
			}
			responseInfo = systemAdminInfoService.resetSystemAdminPassword(resetSystemAdminPasswordRequest);
		} catch (Exception e) {
			logger.error("重置管理员秘密--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 设置管理员菜单权限
     * @param setSystemAdminMenuRoleRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	@Override
	public BaseResponseInfo<Object> setSystemAdminMenuRole(SetSystemAdminMenuRoleRequest setSystemAdminMenuRoleRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			//1、判断管理员是否存在
			String adminNo = setSystemAdminMenuRoleRequest.getAdminNo();
			SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity = sunmnetSystemAdminInfoDao.getSystemAdminInfoByAdminNo(adminNo);
			if(sunmnetSystemAdminInfoEntity==null){
				logger.info("设置管理员菜单权限--管理员不存在;管理员编号："+adminNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_SYSTEM_AMDIN);
				return responseInfo;
			}
			responseInfo = systemAdminInfoService.setSystemAdminMenuRole(setSystemAdminMenuRoleRequest);
		} catch (Exception e) {
			logger.error("设置管理员菜单权限--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 修改管理员信息
     * @param modifySystemAdminInfoRequest
     * @author wm
     * @create 2018-04-09
     * @return
     */
	@Override
	public BaseResponseInfo<Object> modifySystemAdminInfo(ModifySystemAdminInfoRequest modifySystemAdminInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			//1、判断管理员是否存在
			String adminNo = modifySystemAdminInfoRequest.getAdminNo();
			SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity = sunmnetSystemAdminInfoDao.getSystemAdminInfoByAdminNo(adminNo);
			if(sunmnetSystemAdminInfoEntity==null){
				logger.info("修改管理员信息--管理员不存在;管理员编号："+adminNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_SYSTEM_AMDIN);
				return responseInfo;
			}
			//2、判断手机号是否存在
			String adminMobile = modifySystemAdminInfoRequest.getAdminMobile();
			SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntityCheck = sunmnetSystemAdminInfoDao.getSystemAdminInfoByAdminMobile(adminMobile);
			if(sunmnetSystemAdminInfoEntityCheck!=null){
				logger.info("修改管理员信息--手机号已经存在;手机号："+adminMobile);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.MOBILE_EXISTENCE);
				return responseInfo;
			}
			responseInfo = systemAdminInfoService.modifySystemAdminInfo(modifySystemAdminInfoRequest);
		} catch (Exception e) {
			logger.error("修改管理员信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 修改管理员密码
     * @param modifySystemAdminPasswordRequest
     * @author wm
     * @create 2018-04-06
     * @return
     */
	@Override
	public BaseResponseInfo<Object> modifySystemAdminPassword(ModifySystemAdminPasswordRequest modifySystemAdminPasswordRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			//1、判断管理员是否存在
			String adminNo = modifySystemAdminPasswordRequest.getAdminNo();
			SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity = sunmnetSystemAdminInfoDao.getSystemAdminInfoByAdminNo(adminNo);
			if(sunmnetSystemAdminInfoEntity==null){
				logger.info("修改管理员密码--管理员不存在;管理员编号："+adminNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_SYSTEM_AMDIN);
				return responseInfo;
			}
			String oldAdminPassword = modifySystemAdminPasswordRequest.getOldAdminPassword();
			String adminPassword = sunmnetSystemAdminInfoEntity.getAdminPassword();
			if(!oldAdminPassword.equals(adminPassword)){
				logger.info("修改管理员密码--原始密码错误;管理员编号："+adminNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.OLD_PASSWORD_ERROR);
				return responseInfo;
			}
			responseInfo = systemAdminInfoService.modifySystemAdminPassword(modifySystemAdminPasswordRequest);
		} catch (Exception e) {
			logger.error("修改管理员密码--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	
}
