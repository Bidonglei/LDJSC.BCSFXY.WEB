package com.sunmnet.bigdata.systemManage.biz.impl;


import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetUserInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetUserRoleInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.BatchUserRoleTypeEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.SynchroTypeEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.SystemManageResultEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddUserInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.BatchUserRoleRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.DeleteUserInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.GenerationStudentUserRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.GenerationTeacherUserRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyUserInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyUserPasswordRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyUserStatusRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRemoteStudentListRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRemoteTeacherListRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserInfoByRelationRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserInfoPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserRoleInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ResetUserPasswordRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.SetUserRoleRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserRoleInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;
import com.sunmnet.bigdata.systemManage.biz.UserInfoBiz;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetUserInfoDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetUserRoleInfoDao;
import com.sunmnet.bigdata.systemManage.service.UserInfoService;
import com.sunmnet.bigdata.systemManage.util.SystemManageConstants;
/**
 * 用户信息实现
 * @author wm
 * @create 2018-03-27
 */
@Service
public class UserInfoBizImpl implements UserInfoBiz {

	private Logger logger = LoggerFactory.getLogger(UserInfoBizImpl.class);
	
	@Autowired
	private UserInfoService userInfoService;	
	@Autowired
	private SunmnetUserInfoDao sunmnetUserInfoDao;
	@Autowired
	private SunmnetUserRoleInfoDao sunmnetUserRoleInfoDao;
	
	/**
     * 新增用户
     * @param addUserInfoRequest
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	@Override
	public BaseResponseInfo<Object> add(AddUserInfoRequest addUserInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			//判断手机号是否存在
			String userMobile = addUserInfoRequest.getUserMobile();
			SunmnetUserInfoEntity sunmnetUserInfoEntity = sunmnetUserInfoDao.getUserInfoByUserMobile(userMobile);
			if(sunmnetUserInfoEntity!=null){
				logger.info("新增用户--手机号已经存在;手机号："+userMobile);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.MOBILE_EXISTENCE);
				return responseInfo;
			}
			
			//根据关联类型和关联编号查询是否已经创建用户
			SunmnetUserInfoEntity sunmnetUserInfoEntityCheck = sunmnetUserInfoDao.getUserInfoByrRelationNo(addUserInfoRequest.getRelationNo());
			if(sunmnetUserInfoEntityCheck!=null){
				logger.info("新增用户--关联信息已经存在;手机号："+userMobile);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.RELATION_EXISTENCE);
				return responseInfo;
			}
			responseInfo = userInfoService.addUserInfo(addUserInfoRequest);
		
		} catch (Exception e) {
			logger.error("新增用户校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 删除用户信息
     * @param deleteUserInfoRequest
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	@Override
	public BaseResponseInfo<Object> deleteUserInfo(DeleteUserInfoRequest deleteUserInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			String userNo = deleteUserInfoRequest.getUserNo();
			//1、判断用户是否存在
			SunmnetUserInfoEntity sunmnetUserInfoEntity = sunmnetUserInfoDao.getUserInfoByUserNo(userNo);
			if(sunmnetUserInfoEntity==null){
				logger.info("删除用户信息--用户信息不存在;用户编号："+userNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_USER);
				return responseInfo;
			}
			//2、查看用户是否有授权角色
			List<SunmnetUserRoleInfoEntity> userRoleInfoList = sunmnetUserRoleInfoDao.findUserRoleInfoByUserNo(userNo);
			if(userRoleInfoList.size()>0){
				logger.info("删除用户信息--用户信息有授权角色："+userNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.ROLEINFO_EXISTENCE);
				return responseInfo;
			}
			responseInfo = userInfoService.deleteUserInfo(userNo);
		} catch (Exception e) {
			logger.error("删除用户信息校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 查看用户详情
     * @param queryUserInfoRequest
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	@Override
	public BaseResponseInfo<QueryUserInfoResponse> queryUserInfo(QueryUserInfoRequest queryUserInfoRequest) {
		SystemManageResponseInfo<QueryUserInfoResponse> responseInfo = new SystemManageResponseInfo<QueryUserInfoResponse>();
		try {
			String userNo = queryUserInfoRequest.getUserNo();
			//1、判断用户是否存在
			SunmnetUserInfoEntity sunmnetUserInfoEntity = sunmnetUserInfoDao.getUserInfoByUserNo(userNo);
			if(sunmnetUserInfoEntity==null){
				logger.info("查看用户详情--用户不存在;用户编号："+userNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_USER);
				return responseInfo;
			}
			responseInfo = userInfoService.queryUserInfoByUserNo(sunmnetUserInfoEntity);
		} catch (Exception e) {
			logger.error("查看用户详情校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 修改用户状态
     * @param modifyUserStatusRequest
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	@Override
	public BaseResponseInfo<Object> modifyUserStatus(
			ModifyUserStatusRequest modifyUserStatusRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			String userNo = modifyUserStatusRequest.getUserNo();
			//1、判断用户是否存在
			SunmnetUserInfoEntity sunmnetUserInfoEntity = sunmnetUserInfoDao.getUserInfoByUserNo(userNo);
			if(sunmnetUserInfoEntity==null){
				logger.info("修改用户状态--用户信息不存在;用户编号："+userNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_USER);
				return responseInfo;
			}
			responseInfo = userInfoService.modifyUserStatus(modifyUserStatusRequest,sunmnetUserInfoEntity);
		
		} catch (Exception e) {
			logger.error("修改用户状态-异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 重置用户密码
     * @param modifyUserPasswordRequest
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	@Override
	public BaseResponseInfo<Object> resetPassword(ResetUserPasswordRequest resetUserPasswordRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			String userNo = resetUserPasswordRequest.getUserNo();
			//1、判断用户是否存在
			SunmnetUserInfoEntity sunmnetUserInfoEntity = sunmnetUserInfoDao.getUserInfoByUserNo(userNo);
			if(sunmnetUserInfoEntity==null){
				logger.info("重置用户密码--用户信息不存在;用户编号："+userNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_USER);
				return responseInfo;
			}
			responseInfo = userInfoService.resetUserPassword(sunmnetUserInfoEntity);
		
		} catch (Exception e) {
			logger.error("重置用户密码--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 分页查询用户信息
     * @param queryUserInfoPageRequest
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	@Override
	public BaseResponseInfo<PageResult> query(QueryUserInfoPageRequest queryUserInfoPageRequest) {
		SystemManageResponseInfo<PageResult> responseInfo = new SystemManageResponseInfo<PageResult>();
		try {
			//把时间处理成17位YYYYMMDDHHmmssSSS
			//把时间处理成17位YYYYMMDDHHmmssSSS	
			String startTime = queryUserInfoPageRequest.getBeginTime();//开始时间格式YYYYMMDDHHmmss
		    String endTime = queryUserInfoPageRequest.getEndTime();//结束时间格式YYYYMMDDHHmmss
		    if(startTime!=null&&(!"".equals(startTime))&&endTime!=null&&(!"".equals(endTime))){
		    	//把时间处理成17位YYYYMMDDHHmmssSSS
				String startTimeNew = startTime+SystemManageConstants.TIME_ADD_ZORE;//开始时间格式YYYYMMDDHHmmss
			    String endTimeNew = endTime+SystemManageConstants.TIME_ADD_ZORE;//结束时间格式YYYYMMDDHHmmss
			    queryUserInfoPageRequest.setBeginTime(startTimeNew);
			    queryUserInfoPageRequest.setEndTime(endTimeNew);
		    }
			responseInfo = userInfoService.query(queryUserInfoPageRequest);
		} catch (Exception e) {
			logger.error("分页查询用户信息校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 设置用户角色权限
     * @param setUserRoleRequest
     * @author  wm
     * @create 2018-04-07
     * @return
     */
	@Override
	public BaseResponseInfo<Object> setUserRole(SetUserRoleRequest setUserRoleRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			String userNo = setUserRoleRequest.getUserNo();
			//1、判断用户是否存在
			SunmnetUserInfoEntity sunmnetUserInfoEntity = sunmnetUserInfoDao.getUserInfoByUserNo(userNo);
			if(sunmnetUserInfoEntity==null){
				logger.info("设置用户角色权限--用户信息不存在;用户编号："+userNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_USER);
				return responseInfo;
			}
			responseInfo = userInfoService.setUserRole(setUserRoleRequest);
		
		} catch (Exception e) {
			logger.error("设置用户角色权限--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 修改用户信息
     * @param modifyUserInfoRequest
     * @author  zfb
     * @create 2018-04-09
     * @return
     */
	@Override
	public BaseResponseInfo<Object> modifyUserInfo(ModifyUserInfoRequest modifyUserInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			String userNo = modifyUserInfoRequest.getUserNo();
			//1、判断用户是否存在
			SunmnetUserInfoEntity sunmnetUserInfoEntity = sunmnetUserInfoDao.getUserInfoByUserNo(userNo);
			if(sunmnetUserInfoEntity==null){
				logger.info("修改用户信息--用户信息不存在;用户编号："+userNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_USER);
				return responseInfo;
			}
			//2、判断手机号是否存在
//			String userMobile = modifyUserInfoRequest.getUserMobile();
//			SunmnetUserInfoEntity userInfoEntity = sunmnetUserInfoDao.getUserInfoByUserMobile(userMobile);
//			if(userInfoEntity!=null){
//				logger.info("修改用户信息--手机号已经存在;手机号："+userMobile);
//				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.MOBILE_EXISTENCE);
//				return responseInfo;
//			}
			//根据关联类型和关联编号查询是否已经创建用户
//			SunmnetUserInfoEntity sunmnetUserInfoEntityCheck = sunmnetUserInfoDao.getUserInfoByrRelationNo(modifyUserInfoRequest.getRelationNo());
//			if(sunmnetUserInfoEntityCheck!=null){
//				logger.info("修改用户信息--关联信息已经存在;手机号："+userMobile);
//				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.RELATION_EXISTENCE);
//				return responseInfo;
//			}
			responseInfo = userInfoService.modifyUserInfo(modifyUserInfoRequest,sunmnetUserInfoEntity);
		
		} catch (Exception e) {
			logger.error("修改用户信息-异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 查询远程用户详细信息
     * @param queryUserInfoRequest
     * @author zfb
     * @create 2018-04-10
     * @return
     */
	@Override
	public BaseResponseInfo<SunmnetUserInfoEntity> queryUserInfoRemote(QueryUserInfoByRelationRequest queryUserInfoByRelationRequest) {
		SystemManageResponseInfo<SunmnetUserInfoEntity> responseInfo = new SystemManageResponseInfo<SunmnetUserInfoEntity>();
		try {
			//1、判断用户是否存在
			SunmnetUserInfoEntity sunmnetUserInfoEntity = sunmnetUserInfoDao.getUserInfoByrRelationNo(queryUserInfoByRelationRequest.getRelationNo());
			if(sunmnetUserInfoEntity==null){
				logger.info("查看远程用户详情--用户不存在;详情："+queryUserInfoByRelationRequest.toString());
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_USER);
				return responseInfo;
			}
			responseInfo = userInfoService.queryRemoteUserInfoByUserNo(sunmnetUserInfoEntity);
		} catch (Exception e) {
			logger.error("查看远程用户详情校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	@Override
	public BaseResponseInfo<Object> modifyPassword(
			ModifyUserPasswordRequest modifyUserPasswordRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			String userNo = modifyUserPasswordRequest.getUserNo();
			//1、判断用户是否存在
			SunmnetUserInfoEntity sunmnetUserInfoEntity = sunmnetUserInfoDao.getUserInfoByUserNo(userNo);
			if(sunmnetUserInfoEntity==null){
				logger.info("修改用户密码--用户信息不存在;用户编号："+userNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_USER);
				return responseInfo;
			}
			String userPassword = sunmnetUserInfoEntity.getUserPassword();
			String userOldPassword = modifyUserPasswordRequest.getUserOldPassword();
			if(!userOldPassword.equals(userPassword)){
				logger.info("修改用户密码--旧密码不正确;用户编号："+userNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.PASSWORD_ERROR_OLD);
				return responseInfo;
			}
			responseInfo = userInfoService.modifyUserPassword(modifyUserPasswordRequest,sunmnetUserInfoEntity);
		
		} catch (Exception e) {
			logger.error("修改用户密码--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 根据用户编号查询角色信息
     * @param queryUserRoleInfoRequest
     * @author zfb
     * @create 2018-04-18
     * @return
     */
	@Override
	public BaseResponseInfo<QueryUserRoleInfoResponse> queryUserRoleInfo(
			QueryUserRoleInfoRequest queryUserRoleInfoRequest) {
		SystemManageResponseInfo<QueryUserRoleInfoResponse> responseInfo = new SystemManageResponseInfo<QueryUserRoleInfoResponse>();
		try {
			String userNo = queryUserRoleInfoRequest.getUserNo();
			//1、判断用户是否存在
			SunmnetUserInfoEntity sunmnetUserInfoEntity = sunmnetUserInfoDao.getUserInfoByUserNo(userNo);
			if(sunmnetUserInfoEntity==null){
				logger.info("根据用户编号查询角色信息--用户不存在;用户编号："+userNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_USER);
				return responseInfo;
			}
			responseInfo = userInfoService.queryUserRoleInfoByUserNo(queryUserRoleInfoRequest);
		} catch (Exception e) {
			logger.error("根据用户编号查询角色信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 根据筛选条件查询教职工信息
     * @author fr
     * @create 2018-06-23
     * @return
     */
	@Override
	public BaseResponseInfo<PageResult> queryRemoteTeacherList(
			QueryRemoteTeacherListRequest queryRemoteTeacherListRequest) {
		SystemManageResponseInfo<PageResult> responseInfo = new SystemManageResponseInfo<PageResult>();
		try {
			responseInfo = userInfoService.queryRemoteTeacherList(queryRemoteTeacherListRequest);
		} catch (Exception e) {
			logger.error("根据筛选条件查询教职工信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 根据筛选条件查询学生信息
     * @author fr
     * @create 2018-06-23
     * @return
     */
	@Override
	public BaseResponseInfo<PageResult> queryRemoteStudentList(
			QueryRemoteStudentListRequest queryRemoteStudentListRequest) {
		SystemManageResponseInfo<PageResult> responseInfo = new SystemManageResponseInfo<PageResult>();
		try {
			responseInfo = userInfoService.queryRemoteStudentList(queryRemoteStudentListRequest);
		} catch (Exception e) {
			logger.error("根据筛选条件查询学生信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 生成学院学生登录用户
     * @author wm
     * @create 2018-06-27
     * @return
     */
	@Override
	public BaseResponseInfo<Object> generationStudentUser(
			GenerationStudentUserRequest generationStudentUserRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			SynchroTypeEnum synchroType = generationStudentUserRequest.getSynchroType();
			if(SynchroTypeEnum.CUSTOM.equals(synchroType)){
				String studentInfo = generationStudentUserRequest.getStudentInfo();
				if(StringUtils.isEmpty(studentInfo)){
					responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.STUDENT_INFO_IS_NULL);
					return responseInfo;
				}
			}
			responseInfo = userInfoService.generationStudentUser(generationStudentUserRequest);
		} catch (Exception e) {
			logger.error("生成学院学生登录用户--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 生成学院教职工登录用户
     * @author wm
     * @create 2018-06-27
     * @return
     */
	@Override
	public BaseResponseInfo<Object> generationTeacherUser(
			GenerationTeacherUserRequest generationTeacherUserRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			SynchroTypeEnum synchroType = generationTeacherUserRequest.getSynchroType();
			if(SynchroTypeEnum.CUSTOM.equals(synchroType)){
				String teacherInfo = generationTeacherUserRequest.getTeacherInfo();
				if(StringUtils.isEmpty(teacherInfo)){
					responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.TEACHER_INFO_IS_NULL);
					return responseInfo;
				}
			}
			responseInfo = userInfoService.generationTeacherUser(generationTeacherUserRequest);
		} catch (Exception e) {
			logger.error("生成学院教职工登录用户--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 用户批量授权角色
     * @author wm
     * @create 2018-07-11
     * @return
     */
	@Override
	public BaseResponseInfo<Object> batchUserRole(BatchUserRoleRequest batchUserRoleRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			BatchUserRoleTypeEnum batchUserRoleType = batchUserRoleRequest.getBatchUserRoleType();
			if(BatchUserRoleTypeEnum.CUSTOM.equals(batchUserRoleType)){
				String userNoList = batchUserRoleRequest.getUserNoList();
				if(StringUtils.isEmpty(userNoList)){
					responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.USERNO_IS_NULL);
					return responseInfo;
				}
			}
			//把时间处理成17位YYYYMMDDHHmmssSSS
			//把时间处理成17位YYYYMMDDHHmmssSSS	
			String startTime = batchUserRoleRequest.getBeginTime();//开始时间格式YYYYMMDDHHmmss
		    String endTime = batchUserRoleRequest.getEndTime();//结束时间格式YYYYMMDDHHmmss
		    if(startTime!=null&&(!"".equals(startTime))&&endTime!=null&&(!"".equals(endTime))){
		    	//把时间处理成17位YYYYMMDDHHmmssSSS
				String startTimeNew = startTime+SystemManageConstants.TIME_ADD_ZORE;//开始时间格式YYYYMMDDHHmmss
			    String endTimeNew = endTime+SystemManageConstants.TIME_ADD_ZORE;//结束时间格式YYYYMMDDHHmmss
			    batchUserRoleRequest.setBeginTime(startTimeNew);
			    batchUserRoleRequest.setEndTime(endTimeNew);
		    }
			responseInfo = userInfoService.batchUserRole(batchUserRoleRequest);
		} catch (Exception e) {
			logger.error("用户批量授权角色--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
}
