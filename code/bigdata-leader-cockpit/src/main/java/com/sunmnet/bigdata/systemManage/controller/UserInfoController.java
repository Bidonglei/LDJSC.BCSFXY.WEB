package com.sunmnet.bigdata.systemManage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
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
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserInfoPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserRoleInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ResetUserPasswordRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.SetUserRoleRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserRoleInfoResponse;
import com.sunmnet.bigdata.systemManage.biz.UserInfoBiz;
import com.sunmnet.bigdata.systemManage.common.exception.SystemManageException;
import com.sunmnet.bigdata.systemManage.common.log.LoggerManage;


/**
 * 用户信息
 * @author wm
 * @create 2018-03-27
 */
@RestController
@RequestMapping("/manage/user")
public class UserInfoController extends BaseController{
	
	@Autowired
	private UserInfoBiz userInfoBiz;
	
	/**
     * 新增用户
     * @param addUserInfoRequest
     * @author wm
     * @create 2018-03-21
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/add")
    @LoggerManage(description = "新增用户")
    public BaseResponseInfo<Object> add(@Validated  AddUserInfoRequest addUserInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = userInfoBiz.add(addUserInfoRequest);
		} catch (Exception e) {
			logger.error("新增用户--异常",e);
			return SystemManageException.exception();
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
	@SuppressWarnings("unchecked")
	@RequestMapping("/deleteUserInfo")
    @LoggerManage(description = "删除用户信息")
    public BaseResponseInfo<Object> deleteUserInfo(@Validated  DeleteUserInfoRequest deleteUserInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = userInfoBiz.deleteUserInfo(deleteUserInfoRequest);
		} catch (Exception e) {
			logger.error("删除用户信息--异常",e);
			return SystemManageException.exception();
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
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryUserInfo")
    @LoggerManage(description = "查看用户详情")
    public BaseResponseInfo<QueryUserInfoResponse> queryUserInfo(@Validated  QueryUserInfoRequest queryUserInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<QueryUserInfoResponse> responseInfo = new BaseResponseInfo<QueryUserInfoResponse>();
		try {
			responseInfo = userInfoBiz.queryUserInfo(queryUserInfoRequest);
		} catch (Exception e) {
			logger.error("查看用户详情--异常",e);
			return SystemManageException.exception();
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
	@SuppressWarnings("unchecked")
	@RequestMapping("/modifyUserStatus")
    @LoggerManage(description = "修改用户状态")
    public BaseResponseInfo<Object> modifyUserStatus(@Validated  ModifyUserStatusRequest modifyUserStatusRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = userInfoBiz.modifyUserStatus(modifyUserStatusRequest);
		} catch (Exception e) {
			logger.error("修改用户状态--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 重置密码
     * @param resetPassword
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/resetPassword")
    @LoggerManage(description = "重置密码")
    public BaseResponseInfo<Object> resetPassword(@Validated  ResetUserPasswordRequest resetUserPasswordRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = userInfoBiz.resetPassword(resetUserPasswordRequest);
		} catch (Exception e) {
			logger.error("重置密码--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 修改用户密码
     * @param modifyPassword
     * @author zfb
     * @create 2018-04-11
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/modifyPassword")
    @LoggerManage(description = "修改密码")
    public BaseResponseInfo<Object> modifyPassword(@Validated  ModifyUserPasswordRequest modifyUserPasswordRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = userInfoBiz.modifyPassword(modifyUserPasswordRequest);
		} catch (Exception e) {
			logger.error("修改密码--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 分页查询用户信息
     * @param queryUserInfoPageRequest
     * @author  zfb
     * @create 2018-04-04
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/query")
	@LoggerManage(description = "分页查询用户信息")
	public BaseResponseInfo<PageResult> query(@Validated  QueryUserInfoPageRequest queryUserInfoPageRequest ,BindingResult bindingResult){
		
		BaseResponseInfo<PageResult> responseInfo = new BaseResponseInfo<PageResult>();
		try {
			responseInfo = userInfoBiz.query(queryUserInfoPageRequest);
		} catch (Exception e) {
			logger.error("分页查询用户信息--异常",e);
			return SystemManageException.exception();
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
	@SuppressWarnings("unchecked")
	@RequestMapping("/setUserRole")
	@LoggerManage(description = "设置用户角色权限")
	public BaseResponseInfo<Object> setUserRole(@Validated  SetUserRoleRequest setUserRoleRequest ,BindingResult bindingResult){
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = userInfoBiz.setUserRole(setUserRoleRequest);
		} catch (Exception e) {
			logger.error("设置用户角色权限--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
	}
	
	/**
     * 修改用户信息
     * @param modifyUserInfoRequest
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/modifyUserInfo")
    @LoggerManage(description = "修改用户信息")
    public BaseResponseInfo<Object> modifyUserInfo(@Validated  ModifyUserInfoRequest modifyUserInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = userInfoBiz.modifyUserInfo(modifyUserInfoRequest);
		} catch (Exception e) {
			logger.error("修改用户信息--异常",e);
			return SystemManageException.exception();
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
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryUserRoleByUserNo")
    @LoggerManage(description = "根据用户编号查询角色信息")
    public BaseResponseInfo<QueryUserRoleInfoResponse> queryUserRoleByUserNo(@Validated  QueryUserRoleInfoRequest queryUserRoleInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<QueryUserRoleInfoResponse> responseInfo = new BaseResponseInfo<QueryUserRoleInfoResponse>();
		try {
			responseInfo = userInfoBiz.queryUserRoleInfo(queryUserRoleInfoRequest);
		} catch (Exception e) {
			logger.error("根据用户编号查询角色信息--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 根据筛选条件查询教职工信息
     * @author fr
     * @create 2018-06-23
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryRemoteTeacherList")
    @LoggerManage(description = "根据筛选条件查询教职工信息")
    public BaseResponseInfo<PageResult> queryRemoteTeacherList( @Validated QueryRemoteTeacherListRequest queryRemoteTeacherListRequest,BindingResult bindingResult) {
		BaseResponseInfo<PageResult> responseInfo = new BaseResponseInfo<PageResult>();
		try {
			responseInfo = userInfoBiz.queryRemoteTeacherList(queryRemoteTeacherListRequest);
		} catch (Exception e) {
			logger.error("根据筛选条件查询教职工信息--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    } 
	/**
     * 根据筛选条件查询学生信息
     * @author fr
     * @create 2018-06-23
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryRemoteStudentList")
    @LoggerManage(description = "根据筛选条件查询学生信息")
    public BaseResponseInfo<PageResult> queryRemoteStudentList( @Validated QueryRemoteStudentListRequest queryRemoteStudentListRequest,BindingResult bindingResult) {
		BaseResponseInfo<PageResult> responseInfo = new BaseResponseInfo<PageResult>();
		try {
			responseInfo = userInfoBiz.queryRemoteStudentList(queryRemoteStudentListRequest);
		} catch (Exception e) {
			logger.error("根据筛选条件查询学生信息--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    } 
	
	
	/**
     * 生成学院学生登录用户
     * @author wm
     * @create 2018-06-27
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/generationStudentUser")
    @LoggerManage(description = "生成学院学生登录用户")
    public BaseResponseInfo<Object> generationStudentUser( @Validated GenerationStudentUserRequest generationStudentUserRequest,BindingResult bindingResult) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = userInfoBiz.generationStudentUser(generationStudentUserRequest);
		} catch (Exception e) {
			logger.error("生成学院学生登录用户--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    } 
	
	/**
     * 生成学院教职工登录用户
     * @author wm
     * @create 2018-06-27
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/generationTeacherUser")
    @LoggerManage(description = "生成学院教职工登录用户")
    public BaseResponseInfo<Object> generationTeacherUser( @Validated GenerationTeacherUserRequest generationTeacherUserRequest,BindingResult bindingResult) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = userInfoBiz.generationTeacherUser(generationTeacherUserRequest);
		} catch (Exception e) {
			logger.error("生成学院教职工登录用户--异常",e);
			return SystemManageException.exception();	
		}
		return responseInfo;
    } 
	
	/**
     * 用户批量授权角色
     * @author wm
     * @create 2018-07-11
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/batchUserRole")
    @LoggerManage(description = "用户批量授权角色")
    public BaseResponseInfo<Object> batchUserRole( @Validated BatchUserRoleRequest batchUserRoleRequest,BindingResult bindingResult) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = userInfoBiz.batchUserRole(batchUserRoleRequest);
		} catch (Exception e) {
			logger.error("用户批量授权角色--异常",e);
			return SystemManageException.exception();	
		}
		return responseInfo;
    } 
	
	
	
	
}
