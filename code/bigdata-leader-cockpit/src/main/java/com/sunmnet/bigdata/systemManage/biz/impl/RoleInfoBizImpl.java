package com.sunmnet.bigdata.systemManage.biz.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetRoleInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.SystemManageResultEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddRoleInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.DeleteRoleInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyRoleInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRoleInfoPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRoleInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.RoleSetMenuFunctionRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryRoleDropdownResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryRoleInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;
import com.sunmnet.bigdata.systemManage.biz.RoleInfoBiz;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetRoleInfoDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetUserRoleInfoDao;
import com.sunmnet.bigdata.systemManage.service.RoleInfoService;
import com.sunmnet.bigdata.systemManage.util.SystemManageConstants;
/**
 * 角色校验信息实现
 * @author wm
 * @create 2018-04-04
 */
@Service
public class RoleInfoBizImpl implements RoleInfoBiz {

	private Logger logger = LoggerFactory.getLogger(RoleInfoBizImpl.class);
	
	@Autowired
	private RoleInfoService roleInfoService;
	@Autowired
	private SunmnetRoleInfoDao sunmnetRoleInfoDao;
	@Autowired
	private SunmnetUserRoleInfoDao sunmnetUserRoleInfoDao;
	
	/**
     * 添加角色
     * @param addRoleInfoRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	@Override
	public BaseResponseInfo<Object> addRoleInfo(AddRoleInfoRequest addRoleInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {			
			responseInfo = roleInfoService.addRoleInfo(addRoleInfoRequest);
		} catch (Exception e) {
			logger.error("添加角色校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 修改角色信息
     * @param modifyRoleInfoRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	@Override
	public BaseResponseInfo<Object> modifyRoleInfo(ModifyRoleInfoRequest modifyRoleInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			//1、判断角色是否存在
			String roleNo = modifyRoleInfoRequest.getRoleNo();
			SunmnetRoleInfoEntity sunmnetRoleInfoEntity = sunmnetRoleInfoDao.getRoleInfoByRoleNo(roleNo);
			if(sunmnetRoleInfoEntity==null){
				logger.info("修改角色信息--角色不存在;角色员编号："+roleNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_ROLE);
				return responseInfo;
			}
			responseInfo = roleInfoService.modifyRoleInfo(modifyRoleInfoRequest);
		} catch (Exception e) {
			logger.error("修改角色信息校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 删除角色信息
     * @param deleteRoleInfoRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	@Override
	public BaseResponseInfo<Object> deleteRoleInfo(DeleteRoleInfoRequest deleteRoleInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			//1、判断角色是否存在
			String roleNo = deleteRoleInfoRequest.getRoleNo();
			SunmnetRoleInfoEntity sunmnetRoleInfoEntity = sunmnetRoleInfoDao.getRoleInfoByRoleNo(roleNo);
			if(sunmnetRoleInfoEntity==null){
				logger.info("删除角色信息--角色不存在;角色员编号："+roleNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_ROLE);
				return responseInfo;
			}
			//2、判断角色有没有分配给用户
			long count = sunmnetUserRoleInfoDao.findUserRoleInfoCount(roleNo);
			if(count>0){
				logger.info("删除角色信息--角色已经授权给用户;角色员编号："+roleNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.ROLE_SET_USER);
				return responseInfo;
			}
			responseInfo = roleInfoService.deleteRoleInfo(sunmnetRoleInfoEntity);
		} catch (Exception e) {
			logger.error("删除角色信息校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 查询角色信息详情
     * @param queryRoleInfoRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	@Override
	public BaseResponseInfo<QueryRoleInfoResponse> queryRoleInfo(QueryRoleInfoRequest queryRoleInfoRequest) {
		SystemManageResponseInfo<QueryRoleInfoResponse> responseInfo = new SystemManageResponseInfo<QueryRoleInfoResponse>();
		try {
			//1、判断角色是否存在
			String roleNo = queryRoleInfoRequest.getRoleNo();
			SunmnetRoleInfoEntity sunmnetRoleInfoEntity = sunmnetRoleInfoDao.getRoleInfoByRoleNo(roleNo);
			if(sunmnetRoleInfoEntity==null){
				logger.info("查询角色信息详情--角色不存在;角色员编号："+roleNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_ROLE);
				return responseInfo;
			}
			responseInfo = roleInfoService.queryRoleInfo(sunmnetRoleInfoEntity);
		} catch (Exception e) {
			logger.error("查询角色信息详情校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 分页查询角色信息列表
     * @param queryReleInfoPageRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	@Override
	public BaseResponseInfo<PageResult> queryRoleInfoPage(QueryRoleInfoPageRequest queryReleInfoPageRequest) {
		SystemManageResponseInfo<PageResult> responseInfo = new SystemManageResponseInfo<PageResult>();
		try {
			String startTime = queryReleInfoPageRequest.getStartTime();//开始时间格式YYYYMMDDHHmmss
		    String endTime = queryReleInfoPageRequest.getEndTime();//结束时间格式YYYYMMDDHHmmss
		    if(startTime!=null&&(!"".equals(startTime))&&endTime!=null&&(!"".equals(endTime))){
		    	//把时间处理成17位YYYYMMDDHHmmssSSS
				String startTimeNew = startTime+SystemManageConstants.TIME_ADD_ZORE;//开始时间格式YYYYMMDDHHmmss
			    String endTimeNew = endTime+SystemManageConstants.TIME_ADD_ZORE;//结束时间格式YYYYMMDDHHmmss
			    queryReleInfoPageRequest.setStartTime(startTimeNew);
			    queryReleInfoPageRequest.setEndTime(endTimeNew);
		    }
			responseInfo = roleInfoService.queryRoleInfoPage(queryReleInfoPageRequest);
		} catch (Exception e) {
			logger.error("分页查询角色信息列表校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 角色授权菜单、功能点
     * @param roleSetMenuFunctionRequest
     * @author wm
     * @create 2018-04-08
     * @return
     */
	@Override
	public BaseResponseInfo<Object> roleSetMenuFunction(RoleSetMenuFunctionRequest roleSetMenuFunctionRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			//1、判断角色是否存在
			String roleNo = roleSetMenuFunctionRequest.getRoleNo();
			SunmnetRoleInfoEntity sunmnetRoleInfoEntity = sunmnetRoleInfoDao.getRoleInfoByRoleNo(roleNo);
			if(sunmnetRoleInfoEntity==null){
				logger.info("角色授权菜单、功能点--角色不存在;角色员编号："+roleNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_ROLE);
				return responseInfo;
			}
			responseInfo = roleInfoService.roleSetMenuFunction(roleSetMenuFunctionRequest);
		} catch (Exception e) {
			logger.error("角色授权菜单、功能点校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 查询角色列表下拉框     
     * @author zfb
     * @create 2018-04-11
     * @return
     */
	@Override
	public BaseResponseInfo<QueryRoleDropdownResponse> queryRoleDropdown() {
		SystemManageResponseInfo<QueryRoleDropdownResponse> responseInfo = new SystemManageResponseInfo<QueryRoleDropdownResponse>();
		try {
			responseInfo = roleInfoService.queryRoleDropdown();
		} catch (Exception e) {
			logger.error("查询角色信息下拉框选择校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	
}
