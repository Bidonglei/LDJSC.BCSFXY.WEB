package com.sunmnet.bigdata.systemManage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunmnet.bigdata.systemManage.base.support.beanUtil.BeanUtils;
import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.support.util.DateUtil;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetDepartmentInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetUserInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetUserRoleInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.BatchUserRoleTypeEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.RelationTypeEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.SynchroTypeEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.UserDepartmentDefaultEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.UserStatusEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.BatchUserRoleModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryUserPageModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryUserRoleInfoModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.RemoteStudentListModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.RemoteTeacherListModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddUserInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.BatchUserRoleRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.GenerationStudentUserRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.GenerationTeacherUserRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyUserInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyUserPasswordRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyUserStatusRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRemoteStudentListGroupRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRemoteStudentListRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRemoteTeacherListGroupRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRemoteTeacherListRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserInfoBeathRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserInfoPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserRoleInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.SetUserRoleRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryRemoteStudentListGroupResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryRemoteTeacherListGroupResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserRoleInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetDepartmentInfoDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetUserInfoDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetUserRoleInfoDao;
import com.sunmnet.bigdata.systemManage.service.DiagnosisStudentService;
import com.sunmnet.bigdata.systemManage.service.DiagnosisTeacherService;
import com.sunmnet.bigdata.systemManage.service.UserInfoService;
import com.sunmnet.bigdata.systemManage.util.MethodUtil;
import com.sunmnet.bigdata.systemManage.util.SequenceUtil;
import com.sunmnet.bigdata.systemManage.util.SystemManageConstants;
/**
 * 用户信息
 * @author wm
 * @create 2018-03-27
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{

	private Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
	
	@Autowired
	private SunmnetUserInfoDao sunmnetUserInfoDao;
	@Autowired
	private SunmnetDepartmentInfoDao sunmnetDepartmentInfoDao;
	@Autowired
	private SunmnetUserRoleInfoDao sunmnetUserRoleInfoDao;
	@Autowired
	private DiagnosisStudentService diagnosisStudentRemote;
	@Autowired
	private DiagnosisTeacherService diagnosisTeacherRemote;
	/**
     * 新增用户
     * @param addUserInfoRequest
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> addUserInfo(AddUserInfoRequest addUserInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			SunmnetUserInfoEntity sunmnetUserInfoEntity = new SunmnetUserInfoEntity();
			sunmnetUserInfoEntity.setUserNo(SequenceUtil.getUserNo());//用户编号
		    sunmnetUserInfoEntity.setUserName(addUserInfoRequest.getUserName());//用户姓名
		    String userNickname  = MethodUtil.produceString(SystemManageConstants.USERNICKNAME_DIGIT);
		    sunmnetUserInfoEntity.setUserNickname(userNickname); //用户昵称
		    sunmnetUserInfoEntity.setUserMobile(addUserInfoRequest.getUserMobile());//用户手机号   唯一约束
		    sunmnetUserInfoEntity.setDepartmentNo(addUserInfoRequest.getDepartmentNo()); //用户所属系统编号  关联系统表sunmnet_system_info
		    sunmnetUserInfoEntity.setUserMail(addUserInfoRequest.getUserMail());//用户邮箱		    
		    sunmnetUserInfoEntity.setUserStatus(UserStatusEnum.NORMAL);//用户状态   初始化INIT， 正常 NORMAL,  锁定 LOCK 
		    sunmnetUserInfoEntity.setUserPassword(SystemManageConstants.USER_INIT_PASSWORD);//用户密码	 （密文）
		    sunmnetUserInfoEntity.setRelationType(addUserInfoRequest.getRelationType());
		    sunmnetUserInfoEntity.setRelationNo(addUserInfoRequest.getRelationNo());
		    String nowTime = DateUtil.getDateAndTimes();
		    sunmnetUserInfoEntity.setCreateTime(nowTime);//创建时间  格式：YYYYMMDDHHmmssSSS
		    int count = sunmnetUserInfoDao.insertSelective(sunmnetUserInfoEntity);
			if(count!=1){
				logger.info("新增用户--保存信息失败;详情："+sunmnetUserInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("新增用户--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 删除用户
     * @param userNo
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> deleteUserInfo(String userNo) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			int count = sunmnetUserInfoDao.deleteUserInfoByUserNo(userNo);
			if(count!=1){
				logger.info("删除用户信息--删除用户信息失败;用户编号："+userNo);
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("删除用户信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 查询用户详情
     * @param sunmnetUserInfoEntity
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	@Override
	public SystemManageResponseInfo<QueryUserInfoResponse> queryUserInfoByUserNo(
			SunmnetUserInfoEntity sunmnetUserInfoEntity) {
		
		SystemManageResponseInfo<QueryUserInfoResponse> responseInfo = new SystemManageResponseInfo<QueryUserInfoResponse>();		
		try {
			QueryUserInfoResponse queryUserInfoResponse = new QueryUserInfoResponse();
			//查询用户部门名称
			String departmentNo = sunmnetUserInfoEntity.getDepartmentNo();
	    	queryUserInfoResponse.setDepartmentNo(departmentNo);
	    	SunmnetDepartmentInfoEntity sunmnetDepartmentInfoEntity = sunmnetDepartmentInfoDao.getDepartmentInfoByDepartmentNo(departmentNo);
	    	if(sunmnetDepartmentInfoEntity!=null){
	    		queryUserInfoResponse.setDepartmentName(sunmnetDepartmentInfoEntity.getDepartmentName());
	    	}
		    queryUserInfoResponse.setUserNo(sunmnetUserInfoEntity.getUserNo());//用户编号
		    queryUserInfoResponse.setUserName(sunmnetUserInfoEntity.getUserName());//用户姓名
		    queryUserInfoResponse.setUserNickname(sunmnetUserInfoEntity.getUserNickname());//用户昵称
		    queryUserInfoResponse.setUserMobile(sunmnetUserInfoEntity.getUserMobile());//用户手机号   唯一约束
		    queryUserInfoResponse.setUserMail(sunmnetUserInfoEntity.getUserMail());//用户邮箱
		    queryUserInfoResponse.setUserStatus(sunmnetUserInfoEntity.getUserStatus());//用户状态   初始化INIT， 正常 NORMAL,  锁定 LOCK
		    queryUserInfoResponse.setUserStatusStr(sunmnetUserInfoEntity.getUserStatus().getMsg());
		    queryUserInfoResponse.setRelationNo(sunmnetUserInfoEntity.getRelationNo());
		    queryUserInfoResponse.setRelationType(sunmnetUserInfoEntity.getRelationType());
		    queryUserInfoResponse.setRelationTypeStr(sunmnetUserInfoEntity.getRelationType().getMessage());
		    String createTime = sunmnetUserInfoEntity.getCreateTime();
			if(!("").equals(createTime)&&createTime!=null){
				queryUserInfoResponse.setCreateTime(DateUtil.formartStringDate(DateUtil.dateandtime,DateUtil.simple,createTime));//创建时间  格式：YYYYMMDDHHmmssSSS
			}
			String lastModifyTime = sunmnetUserInfoEntity.getLastModifyTime();
			if(!("").equals(lastModifyTime)&&lastModifyTime!=null){
				queryUserInfoResponse.setLastModifyTime(DateUtil.formartStringDate(DateUtil.dateandtime,DateUtil.simple,lastModifyTime));//最后修改时间  格式：YYYYMMDDHHmmssSSS
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,queryUserInfoResponse);
		} catch (Exception e) {
			logger.error("查看用户详情--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 修改用户状态
     * @param modifyUserStatusRequest
     * @param sunmnetUserInfoEntity
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> modifyUserStatus(
			ModifyUserStatusRequest modifyUserStatusRequest,
			SunmnetUserInfoEntity sunmnetUserInfoEntity) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {			
			sunmnetUserInfoEntity.setUserStatus(modifyUserStatusRequest.getUserStatus()); //用户状态
			sunmnetUserInfoEntity.setLastModifyTime(DateUtil.getDateAndTimes());//最后修改时间  格式：YYYYMMDDHHmmssSSS
			int count = sunmnetUserInfoDao.updateUserStatusByUserNo(sunmnetUserInfoEntity);
			if(count!=1){
				logger.info("修改用户状态--修改用户状态失败;详情："+sunmnetUserInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("修改用户状态--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 重置用户密码
     * @param modifyUserPasswordRequest
     * @param sunmnetUserInfoEntity
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> modifyUserPassword(
			ModifyUserPasswordRequest modifyUserPasswordRequest,
			SunmnetUserInfoEntity sunmnetUserInfoEntity) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {			
			sunmnetUserInfoEntity.setUserPassword(modifyUserPasswordRequest.getUserPassword()); //用户密码
			sunmnetUserInfoEntity.setLastModifyTime(DateUtil.getDateAndTimes());//最后修改时间  格式：YYYYMMDDHHmmssSSS
			int count = sunmnetUserInfoDao.updateUserPasswordByUserNo(sunmnetUserInfoEntity);
			if(count!=1){
				logger.info("修改用户密码--修改用户密码失败;详情："+sunmnetUserInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("修改用户密码--异常", e);
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
	public SystemManageResponseInfo<PageResult> query(
			QueryUserInfoPageRequest queryUserInfoPageRequest) {
		SystemManageResponseInfo<PageResult> responseInfo = new SystemManageResponseInfo<PageResult>();		
		try {
			int pageNum = queryUserInfoPageRequest.getPageNum(); //  当前页
			int pageSize = queryUserInfoPageRequest.getPageSize();//  每页显示的记录数量
			PageHelper.startPage(pageNum, pageSize);
			List<QueryUserPageModel> list = sunmnetUserInfoDao.findUserInfo(queryUserInfoPageRequest);
			Page<QueryUserPageModel> count = (Page<QueryUserPageModel>)list;
			List<QueryUserPageModel> listData = new ArrayList<QueryUserPageModel>(); 
			for(QueryUserPageModel queryUserPageModel : list){
				queryUserPageModel.setRelationTypeStr(queryUserPageModel.getRelationType().getMessage());
				queryUserPageModel.setUserStatusStr(queryUserPageModel.getUserStatus().getMsg());
				String createTime = queryUserPageModel.getCreateTime();
				if(!("").equals(createTime)&&createTime!=null){
					queryUserPageModel.setCreateTime(DateUtil.formartStringDate(DateUtil.dateandtime,DateUtil.simple,createTime));//创建时间  格式：YYYYMMDDHHmmssSSS
				}
				String lastModifyTime = queryUserPageModel.getLastModifyTime();
				if(!("").equals(lastModifyTime)&&lastModifyTime!=null){
					queryUserPageModel.setLastModifyTime(DateUtil.formartStringDate(DateUtil.dateandtime,DateUtil.simple,lastModifyTime));//最后修改时间  格式：YYYYMMDDHHmmssSSS
				}
				listData.add(queryUserPageModel);
			}
			
			PageResult pageResult = new PageResult(listData, count.getTotal(), pageNum, pageSize);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,pageResult);
		} catch (Exception e) {
			logger.error("分页查询用户信息--异常", e);
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
	@Transactional
	@Override
	public SystemManageResponseInfo<Object> setUserRole(SetUserRoleRequest setUserRoleRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			String userNo = setUserRoleRequest.getUserNo();
			//1、查询用户是否分配了角色
			List<SunmnetUserRoleInfoEntity> list = sunmnetUserRoleInfoDao.findUserRoleInfoByUserNo(userNo);
			//2、如果分配了角色先删除在保存
			if(list.size()>0){
				//删除原有的角色
				if(sunmnetUserRoleInfoDao.deleteRoleInfoByUserNo(userNo)<0){
					logger.info("设置用户角色权限--删除原有角色失败;管理员编号："+userNo);
					responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
					return responseInfo;
				}
			}
			String roleNos = setUserRoleRequest.getRoleNoList();
			if(StringUtils.isNotEmpty(roleNos)){
				String [] roleNoList = roleNos.split(",",-1);
				for(String roleNo : roleNoList){
					SunmnetUserRoleInfoEntity sunmnetUserRoleInfoEntity = new SunmnetUserRoleInfoEntity();
					sunmnetUserRoleInfoEntity.setUserNo(userNo); //用户编号
					sunmnetUserRoleInfoEntity.setRoleNo(roleNo);//角色编号
					sunmnetUserRoleInfoEntity.setCreateTime(DateUtil.getDateAndTimes());//创建时间  格式：YYYYMMDDHHmmssSSS
					int count = sunmnetUserRoleInfoDao.insertSelective(sunmnetUserRoleInfoEntity);
					if(count!=1){
						logger.info("设置用户角色权限--保存信息失败;详情："+sunmnetUserRoleInfoEntity.toString());
					}
				}
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("设置用户角色权限--异常", e);
			throw new RuntimeException();
		}
		return responseInfo;
	}
	/**
     * 修改用户信息
     * @param modifyUserInfoRequest
     * @param sunmnetUserInfoEntity
     * @author  zfb
     * @create 2018-04-09
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> modifyUserInfo(
			ModifyUserInfoRequest modifyUserInfoRequest,
			SunmnetUserInfoEntity sunmnetUserInfoEntity) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {			
			sunmnetUserInfoEntity.setDepartmentNo(modifyUserInfoRequest.getDepartmentNo()); //部门编号
			sunmnetUserInfoEntity.setUserName(modifyUserInfoRequest.getUserName());
			sunmnetUserInfoEntity.setUserNickname(modifyUserInfoRequest.getUserNickname());
			sunmnetUserInfoEntity.setUserMobile(modifyUserInfoRequest.getUserMobile());
			sunmnetUserInfoEntity.setUserMail(modifyUserInfoRequest.getUserMail());
			sunmnetUserInfoEntity.setLastModifyTime(DateUtil.getDateAndTimes());//最后修改时间  格式：YYYYMMDDHHmmssSSS
			sunmnetUserInfoEntity.setRelationNo(modifyUserInfoRequest.getRelationNo());
			sunmnetUserInfoEntity.setRelationType(modifyUserInfoRequest.getRelationType());
			int count = sunmnetUserInfoDao.updateUserInfoByUserNo(sunmnetUserInfoEntity);
			if(count!=1){
				logger.info("修改用户信息--修改用户信息失败;详情："+sunmnetUserInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("修改用户信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 查询远程用户详情
     * @param sunmnetUserInfoEntity
     * @author zfb
     * @create 2018-04-10
     * @return
     */
	@Override
	public SystemManageResponseInfo<SunmnetUserInfoEntity> queryRemoteUserInfoByUserNo(
			SunmnetUserInfoEntity sunmnetUserInfoEntity) {
		SystemManageResponseInfo<SunmnetUserInfoEntity> responseInfo = new SystemManageResponseInfo<SunmnetUserInfoEntity>();		
		try {			
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,sunmnetUserInfoEntity);
		} catch (Exception e) {
			logger.error("查看远程用户详情--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 重置用户密码     
     * @param sunmnetUserInfoEntity
     * @author  zfb
     * @create 2018-04-11
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> resetUserPassword(SunmnetUserInfoEntity sunmnetUserInfoEntity) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {			
			sunmnetUserInfoEntity.setUserPassword(SystemManageConstants.USER_INIT_PASSWORD); //用户密码
			sunmnetUserInfoEntity.setLastModifyTime(DateUtil.getDateAndTimes());//最后修改时间  格式：YYYYMMDDHHmmssSSS
			int count = sunmnetUserInfoDao.updateUserPasswordByUserNo(sunmnetUserInfoEntity);
			if(count!=1){
				logger.info("重置用户密码--重置用户密码失败;详情："+sunmnetUserInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("重置用户密码--异常", e);
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
	public SystemManageResponseInfo<QueryUserRoleInfoResponse> queryUserRoleInfoByUserNo(
			QueryUserRoleInfoRequest queryUserRoleInfoRequest) {
		SystemManageResponseInfo<QueryUserRoleInfoResponse> responseInfo = new SystemManageResponseInfo<QueryUserRoleInfoResponse>();		
		try {
			try {
				List<QueryUserRoleInfoModel> list = sunmnetUserRoleInfoDao.queryUserRoleInfo(queryUserRoleInfoRequest);
				QueryUserRoleInfoResponse queryUserRoleInfoResponse = new QueryUserRoleInfoResponse();
				queryUserRoleInfoResponse.setList(list);
				responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,queryUserRoleInfoResponse);
			} catch (Exception e) {
				logger.error("根据用户编号查询角色信息--异常", e);
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
			}
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
	public SystemManageResponseInfo<PageResult> queryRemoteTeacherList(
			QueryRemoteTeacherListRequest queryRemoteTeacherListRequest) {
		SystemManageResponseInfo<PageResult> responseInfo = new SystemManageResponseInfo<PageResult>();		
		try {
			BaseResponseInfo<PageResult> response = diagnosisTeacherRemote.queryRemoteTeacherList(queryRemoteTeacherListRequest);
			if(response==null){
				logger.info("根据筛选条件查询教职工信息--服务间调用返回为空");
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			logger.info("根据筛选条件查询教职工信息--服务间调用返回信息:"+response.toString());
			if(!MethodUtil.isSucceed(response)){
				logger.info("根据筛选条件查询教职工信息--服务间调用返回失败,详情:"+response.toString());
				responseInfo.setCode(response.getCode());
				responseInfo.setMessage(response.getMessage());
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,response.getData());
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
	public SystemManageResponseInfo<PageResult> queryRemoteStudentList(
			QueryRemoteStudentListRequest queryRemoteStudentListRequest) {
		SystemManageResponseInfo<PageResult> responseInfo = new SystemManageResponseInfo<PageResult>();		
		try {
			BaseResponseInfo<PageResult> response = diagnosisStudentRemote.queryRemoteStudentList(queryRemoteStudentListRequest);
			if(response==null){
				logger.info("根据筛选条件查询学生信息--服务间调用返回为空");
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			logger.info("根据筛选条件查询学生信息--服务间调用返回信息:"+response.toString());
			if(!MethodUtil.isSucceed(response)){
				logger.info("根据筛选条件查询学生信息--服务间调用返回失败,详情:"+response.toString());
				responseInfo.setCode(response.getCode());
				responseInfo.setMessage(response.getMessage());
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,response.getData());
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
	@Transactional
	@Override
	public SystemManageResponseInfo<Object> generationStudentUser(GenerationStudentUserRequest generationStudentUserRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			SynchroTypeEnum synchroType = generationStudentUserRequest.getSynchroType();
			List<SunmnetUserInfoEntity> list = new ArrayList<SunmnetUserInfoEntity>();
			if(SynchroTypeEnum.CUSTOM.equals(synchroType)){
				String studentInfoStr = generationStudentUserRequest.getStudentInfo();
				//姓名,学号,手机号码,邮箱|姓名,学号,手机号码,邮箱|姓名,学号,手机号码,邮箱
				String [] studentInfoArray = studentInfoStr.split("\\|",-1);
				for(String student:studentInfoArray){
					String [] studentInfo = student.split(",",-1);
					SunmnetUserInfoEntity sunmnetUserInfoEntity = new SunmnetUserInfoEntity();
					sunmnetUserInfoEntity.setUserNo(SequenceUtil.getUserNo());//用户编号
				    sunmnetUserInfoEntity.setUserName(studentInfo[0]);//用户姓名
				    sunmnetUserInfoEntity.setRelationNo(studentInfo[1]);
				    sunmnetUserInfoEntity.setUserMobile(studentInfo[2]);//用户手机号   唯一约束
				    sunmnetUserInfoEntity.setUserMail(studentInfo[3]);//用户邮箱		    
				    String userNickname  = MethodUtil.produceString(SystemManageConstants.USERNICKNAME_DIGIT);
				    sunmnetUserInfoEntity.setUserNickname(userNickname); //用户昵称
				    sunmnetUserInfoEntity.setDepartmentNo(UserDepartmentDefaultEnum.STUDENT.getCode()); //用户所属系统编号  关联系统表sunmnet_system_info
				    sunmnetUserInfoEntity.setUserStatus(UserStatusEnum.NORMAL);//用户状态   初始化INIT， 正常 NORMAL,  锁定 LOCK 
				    sunmnetUserInfoEntity.setUserPassword(SystemManageConstants.USER_INIT_PASSWORD);//用户密码	 （密文）
				    sunmnetUserInfoEntity.setRelationType(RelationTypeEnum.STUDENT);
				    String nowTime = DateUtil.getDateAndTimes();
				    sunmnetUserInfoEntity.setCreateTime(nowTime);//创建时间  格式：YYYYMMDDHHmmssSSS
				    sunmnetUserInfoEntity.setLastModifyTime(nowTime);
				    list.add(sunmnetUserInfoEntity);
				}
			}else{
				//服务间调用查询要分组的学生信息进行保存
				QueryRemoteStudentListGroupRequest queryRemoteStudentListGroupRequest = new QueryRemoteStudentListGroupRequest();
				BeanUtils.copyProperties(generationStudentUserRequest, queryRemoteStudentListGroupRequest);
				BaseResponseInfo<QueryRemoteStudentListGroupResponse> response = diagnosisStudentRemote.queryRemoteStudentListGroup(queryRemoteStudentListGroupRequest);
				if(response!=null){
					logger.info("生成学院学生登录用户--服务间调用返回信息:"+response.toString());
					if(!MethodUtil.isSucceed(response)){
						logger.info("生成学院学生登录用户--服务间调用返回失败,详情:"+response.toString());
					}else{
						QueryRemoteStudentListGroupResponse queryRemoteStudentListGroupResponse = response.getData();
						List<RemoteStudentListModel> studentList = queryRemoteStudentListGroupResponse.getList(); 
						for(RemoteStudentListModel remoteStudentListModel :studentList){
							SunmnetUserInfoEntity sunmnetUserInfoEntity = new SunmnetUserInfoEntity();
							sunmnetUserInfoEntity.setUserNo(SequenceUtil.getUserNo());//用户编号
						    sunmnetUserInfoEntity.setUserName(remoteStudentListModel.getStudentName());//用户姓名
						    sunmnetUserInfoEntity.setRelationNo(remoteStudentListModel.getStudentNo());
						    sunmnetUserInfoEntity.setUserMobile(remoteStudentListModel.getUserMobile());//用户手机号   唯一约束
						    sunmnetUserInfoEntity.setUserMail(remoteStudentListModel.getUserMail());//用户邮箱		    
						    String userNickname  = MethodUtil.produceString(SystemManageConstants.USERNICKNAME_DIGIT);
						    sunmnetUserInfoEntity.setUserNickname(userNickname); //用户昵称
						    sunmnetUserInfoEntity.setDepartmentNo(UserDepartmentDefaultEnum.STUDENT.getCode()); //用户所属系统编号  关联系统表sunmnet_system_info
						    sunmnetUserInfoEntity.setUserStatus(UserStatusEnum.NORMAL);//用户状态   初始化INIT， 正常 NORMAL,  锁定 LOCK 
						    sunmnetUserInfoEntity.setUserPassword(SystemManageConstants.USER_INIT_PASSWORD);//用户密码	 （密文）
						    sunmnetUserInfoEntity.setRelationType(RelationTypeEnum.STUDENT);
						    String nowTime = DateUtil.getDateAndTimes();
						    sunmnetUserInfoEntity.setCreateTime(nowTime);//创建时间  格式：YYYYMMDDHHmmssSSS
						    sunmnetUserInfoEntity.setLastModifyTime(nowTime);
						    list.add(sunmnetUserInfoEntity);
						}
					}
				}
			}
		    logger.info("生成学院学生登录用户--共:"+list.size()+"条数据");
		    //批量入库
			while (list.size()>200) {
				List<SunmnetUserInfoEntity>  temp = new ArrayList<SunmnetUserInfoEntity>();
				temp = list.subList(0,200);
				sunmnetUserInfoDao.insertBatchUserInfo(temp);
				list.removeAll(temp);
				logger.info("生成学院学生登录用户--剩余:"+list.size()+"条数据");
			}
			logger.info("生成学院学生登录用户--剩余:"+list.size()+"条数据");
			if(list.size()>0){
				sunmnetUserInfoDao.insertBatchUserInfo(list);
				list.clear();
			}
			logger.info("生成学院学生登录用户--剩余:"+list.size()+"条数据");
			
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("生成学院学生登录用户--异常", e);
			throw new  RuntimeException();
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
	public SystemManageResponseInfo<Object> generationTeacherUser(
			GenerationTeacherUserRequest generationTeacherUserRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			SynchroTypeEnum synchroType = generationTeacherUserRequest.getSynchroType();
			List<SunmnetUserInfoEntity> list = new ArrayList<SunmnetUserInfoEntity>();
			if(SynchroTypeEnum.CUSTOM.equals(synchroType)){
				String teacherInfoStr = generationTeacherUserRequest.getTeacherInfo();
				//姓名,职工号,手机号码,邮箱,二级部门编号|姓名,职工号,手机号码,邮箱,二级部门编号|姓名,职工号,手机号码,邮箱,二级部门编号
				String [] teacherInfoArray = teacherInfoStr.split("\\|",-1);
				for(String teacher:teacherInfoArray){
					String [] teacherInfo = teacher.split(",",-1);
					SunmnetUserInfoEntity sunmnetUserInfoEntity = new SunmnetUserInfoEntity();
					sunmnetUserInfoEntity.setUserNo(SequenceUtil.getUserNo());//用户编号
				    sunmnetUserInfoEntity.setUserName(teacherInfo[0]);//用户姓名
				    sunmnetUserInfoEntity.setRelationNo(teacherInfo[1]);
				    sunmnetUserInfoEntity.setUserMobile(teacherInfo[2]);//用户手机号   唯一约束
				    sunmnetUserInfoEntity.setUserMail(teacherInfo[3]);//用户邮箱		    
				    String userNickname  = MethodUtil.produceString(SystemManageConstants.USERNICKNAME_DIGIT);
				    sunmnetUserInfoEntity.setUserNickname(userNickname); //用户昵称
				    String departmentNo = teacherInfo[4];
				    if(StringUtils.isBlank(departmentNo)){
				    	departmentNo= UserDepartmentDefaultEnum.OTHER.getCode();
				    }
				    sunmnetUserInfoEntity.setDepartmentNo(departmentNo); //用户所属系统编号  关联系统表sunmnet_system_info
				    sunmnetUserInfoEntity.setUserStatus(UserStatusEnum.NORMAL);//用户状态   初始化INIT， 正常 NORMAL,  锁定 LOCK 
				    sunmnetUserInfoEntity.setUserPassword(SystemManageConstants.USER_INIT_PASSWORD);//用户密码	 （密文）
				    sunmnetUserInfoEntity.setRelationType(generationTeacherUserRequest.getRelationType());
				    String nowTime = DateUtil.getDateAndTimes();
				    sunmnetUserInfoEntity.setCreateTime(nowTime);//创建时间  格式：YYYYMMDDHHmmssSSS
				    sunmnetUserInfoEntity.setLastModifyTime(nowTime);
				    list.add(sunmnetUserInfoEntity);
				}
			}else{
				//服务间调用查询要分组的教职工信息进行保存
				QueryRemoteTeacherListGroupRequest queryRemoteTeacherListGroupRequest = new QueryRemoteTeacherListGroupRequest();
				BeanUtils.copyProperties(generationTeacherUserRequest, queryRemoteTeacherListGroupRequest);
				BaseResponseInfo<QueryRemoteTeacherListGroupResponse> response = diagnosisTeacherRemote.queryRemoteTeacherListGroup(queryRemoteTeacherListGroupRequest);
				if(response!=null){
					logger.info("生成学院教职工登录用户--服务间调用返回信息:"+response.toString());
					if(!MethodUtil.isSucceed(response)){
						logger.info("生成学院教职工登录用户--服务间调用返回失败,详情:"+response.toString());
					}else{
						QueryRemoteTeacherListGroupResponse queryRemoteTeacherListGroupResponse = response.getData();
						List<RemoteTeacherListModel> teacherList = queryRemoteTeacherListGroupResponse.getTeacherList(); 
						for(RemoteTeacherListModel remoteTeacherListModel :teacherList){
							SunmnetUserInfoEntity sunmnetUserInfoEntity = new SunmnetUserInfoEntity();
							sunmnetUserInfoEntity.setUserNo(SequenceUtil.getUserNo());//用户编号
						    sunmnetUserInfoEntity.setUserName(remoteTeacherListModel.getTeacherName());//用户姓名
						    sunmnetUserInfoEntity.setRelationNo(remoteTeacherListModel.getTeacherNo());
						    sunmnetUserInfoEntity.setUserMobile(remoteTeacherListModel.getPhone());//用户手机号   唯一约束
						    sunmnetUserInfoEntity.setUserMail(remoteTeacherListModel.getMail());//用户邮箱		    
						    String userNickname  = MethodUtil.produceString(SystemManageConstants.USERNICKNAME_DIGIT);
						    sunmnetUserInfoEntity.setUserNickname(userNickname); //用户昵称
						    String departmentNo = remoteTeacherListModel.getSecondDeptCode();
						    if(StringUtils.isBlank(departmentNo)){
						    	departmentNo= UserDepartmentDefaultEnum.OTHER.getCode();
						    }
						    sunmnetUserInfoEntity.setDepartmentNo(departmentNo); //用户所属系统编号  关联系统表sunmnet_system_info
						    sunmnetUserInfoEntity.setUserStatus(UserStatusEnum.NORMAL);//用户状态   初始化INIT， 正常 NORMAL,  锁定 LOCK 
						    sunmnetUserInfoEntity.setUserPassword(SystemManageConstants.USER_INIT_PASSWORD);//用户密码	 （密文）
						    sunmnetUserInfoEntity.setRelationType(generationTeacherUserRequest.getRelationType());
						    String nowTime = DateUtil.getDateAndTimes();
						    sunmnetUserInfoEntity.setCreateTime(nowTime);//创建时间  格式：YYYYMMDDHHmmssSSS
						    sunmnetUserInfoEntity.setLastModifyTime(nowTime);
						    list.add(sunmnetUserInfoEntity);
						}
					}
				}
			}
		    logger.info("生成学院教职工登录用户--共:"+list.size()+"条数据");
		    //批量入库
			while (list.size()>200) {
				List<SunmnetUserInfoEntity>  temp = new ArrayList<SunmnetUserInfoEntity>();
				temp = list.subList(0,200);
				sunmnetUserInfoDao.insertBatchUserInfo(temp);
				list.removeAll(temp);
				logger.info("生成学院教职工登录用户--剩余:"+list.size()+"条数据");
			}
			logger.info("生成学院教职工登录用户--剩余:"+list.size()+"条数据");
			if(list.size()>0){
				sunmnetUserInfoDao.insertBatchUserInfo(list);
				list.clear();
			}
			logger.info("生成学院教职工登录用户--剩余:"+list.size()+"条数据");
			
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("生成学院教职工登录用户--异常", e);
			throw new  RuntimeException();
		}
		return responseInfo;
	}
	
	/**
     * 用户批量授权角色
     * @author wm
     * @create 2018-07-11
     * @return
     */
	@Transactional
	@Override
	public SystemManageResponseInfo<Object> batchUserRole(BatchUserRoleRequest batchUserRoleRequest) {

		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			BatchUserRoleTypeEnum batchUserRoleType = batchUserRoleRequest.getBatchUserRoleType();
			String roleNoList = batchUserRoleRequest.getRoleNoList();
			
			//用户编号集合
			List<BatchUserRoleModel> list = new ArrayList<BatchUserRoleModel>();
			//用户要添加权限集合
			List<SunmnetUserRoleInfoEntity> userRoleList = new ArrayList<SunmnetUserRoleInfoEntity>();
			if(BatchUserRoleTypeEnum.CUSTOM.equals(batchUserRoleType)){
				String [] userNoList = batchUserRoleRequest.getUserNoList().split(",",-1);
				for(String userNo: userNoList){
					BatchUserRoleModel batchUserRoleModel = new BatchUserRoleModel();
					batchUserRoleModel.setUserNo(userNo);
					list.add(batchUserRoleModel);
				}
				if(StringUtils.isNotEmpty(roleNoList)){
					String [] roleNoArray = roleNoList.split(",",-1);
					for(String userNo: userNoList){
						for(String roleNo : roleNoArray){
							SunmnetUserRoleInfoEntity sunmnetUserRoleInfoEntity = new SunmnetUserRoleInfoEntity();
							sunmnetUserRoleInfoEntity.setUserNo(userNo); //用户编号
							sunmnetUserRoleInfoEntity.setRoleNo(roleNo);//角色编号
							sunmnetUserRoleInfoEntity.setCreateTime(DateUtil.getDateAndTimes());//创建时间  格式：YYYYMMDDHHmmssSSS
							userRoleList.add(sunmnetUserRoleInfoEntity);
						}
					}
				}
			}else{
				QueryUserInfoBeathRequest queryUserInfoBeathRequest = new QueryUserInfoBeathRequest();
				BeanUtils.copyProperties(batchUserRoleRequest, queryUserInfoBeathRequest);
				List<QueryUserPageModel> listUserIno = sunmnetUserInfoDao.findUserInfoBeath(queryUserInfoBeathRequest);
				for(QueryUserPageModel queryUserPageModel: listUserIno){
					BatchUserRoleModel batchUserRoleModel = new BatchUserRoleModel();
					batchUserRoleModel.setUserNo(queryUserPageModel.getUserNo());
					list.add(batchUserRoleModel);
				}
				if(StringUtils.isNotEmpty(roleNoList)){
					String [] roleNoArray = roleNoList.split(",",-1);
					for(QueryUserPageModel queryUserPageModel: listUserIno){
						for(String roleNo : roleNoArray){
							String userNo = queryUserPageModel.getUserNo();
							SunmnetUserRoleInfoEntity sunmnetUserRoleInfoEntity = new SunmnetUserRoleInfoEntity();
							sunmnetUserRoleInfoEntity.setUserNo(userNo); //用户编号
							sunmnetUserRoleInfoEntity.setRoleNo(roleNo);//角色编号
							sunmnetUserRoleInfoEntity.setCreateTime(DateUtil.getDateAndTimes());//创建时间  格式：YYYYMMDDHHmmssSSS
							userRoleList.add(sunmnetUserRoleInfoEntity);
						}
					}
				}
			}
			//批量删除
			logger.info("用户批量授权角色--批量删除共:"+list.size()+"条数据");
			while (list.size()>200) {
				List<BatchUserRoleModel>  temp = new ArrayList<BatchUserRoleModel>();
				temp = list.subList(0,200);
				sunmnetUserRoleInfoDao.deleteBatchRole(temp);
				list.removeAll(temp);
				logger.info("用户批量授权角色批量删除--剩余:"+list.size()+"条数据");
			}
			logger.info("用户批量授权角色--批量删除剩余:"+list.size()+"条数据");
			if(list.size()>0){
				sunmnetUserRoleInfoDao.deleteBatchRole(list);
				list.clear();
			}
			//批量入库
			logger.info("用户批量授权角色--批量入库共:"+list.size()+"条数据");
			while (userRoleList.size()>200) {
				List<SunmnetUserRoleInfoEntity>  temp = new ArrayList<SunmnetUserRoleInfoEntity>();
				temp = userRoleList.subList(0,200);
				sunmnetUserRoleInfoDao.insertBatchRole(temp);
				userRoleList.removeAll(temp);
				logger.info("用户批量授权角色--批量入库剩余:"+list.size()+"条数据");
			}
			logger.info("用户批量授权角色--批量入库剩余:"+list.size()+"条数据");
			if(userRoleList.size()>0){
				sunmnetUserRoleInfoDao.insertBatchRole(userRoleList);
				userRoleList.clear();
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("用户批量授权角色--异常", e);
			throw new RuntimeException();
		}
		return responseInfo;
	}
	

}
