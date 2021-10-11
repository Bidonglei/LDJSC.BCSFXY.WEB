package com.sunmnet.bigdata.systemManage.service;

import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetUserInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddUserInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.BatchUserRoleRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.GenerationStudentUserRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.GenerationTeacherUserRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyUserInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyUserPasswordRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyUserStatusRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRemoteStudentListRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRemoteTeacherListRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserInfoPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserRoleInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.SetUserRoleRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserRoleInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;


/**
 * 用户信息
 * @author wm
 * @create 2018-03-27
 */
public interface UserInfoService {

	/**
     * 新增用户
     * @param addUserInfoRequest
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	public SystemManageResponseInfo<Object> addUserInfo(AddUserInfoRequest addUserInfoRequest);

	/**
     * 删除用户
     * @param userNo
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	public SystemManageResponseInfo<Object> deleteUserInfo(String userNo);

	/**
     * 查询用户详情
     * @param sunmnetUserInfoEntity
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	public SystemManageResponseInfo<QueryUserInfoResponse> queryUserInfoByUserNo(SunmnetUserInfoEntity sunmnetUserInfoEntity);

	/**
     * 修改用户状态
     * @param modifyUserStatusRequest
     * @param sunmnetUserInfoEntity
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	public SystemManageResponseInfo<Object> modifyUserStatus(ModifyUserStatusRequest modifyUserStatusRequest, SunmnetUserInfoEntity sunmnetUserInfoEntity);

	/**
     * 重置用户密码
     * @param modifyUserPasswordRequest
     * @param sunmnetUserInfoEntity
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	public SystemManageResponseInfo<Object> modifyUserPassword(
			ModifyUserPasswordRequest modifyUserPasswordRequest,
			SunmnetUserInfoEntity sunmnetUserInfoEntity);

	/**
     * 分页查询用户信息
     * @param queryUserInfoPageRequest     
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	public SystemManageResponseInfo<PageResult> query(
			QueryUserInfoPageRequest queryUserInfoPageRequest);
	/**
     * 设置用户角色权限
     * @param setUserRoleRequest
     * @author  wm
     * @create 2018-04-07
     * @return
     */
	public SystemManageResponseInfo<Object> setUserRole(SetUserRoleRequest setUserRoleRequest);

	/**
     * 修改用户信息
     * @param modifyUserInfoRequest
     * @param sunmnetUserInfoEntity
     * @author  zfb
     * @create 2018-04-09
     * @return
     */
	public SystemManageResponseInfo<Object> modifyUserInfo(
			ModifyUserInfoRequest modifyUserInfoRequest,
			SunmnetUserInfoEntity sunmnetUserInfoEntity);

	/**
     * 查询远程用户详情
     * @param sunmnetUserInfoEntity
     * @author zfb
     * @create 2018-04-10
     * @return
     */
	public SystemManageResponseInfo<SunmnetUserInfoEntity> queryRemoteUserInfoByUserNo(
			SunmnetUserInfoEntity sunmnetUserInfoEntity);

	/**
     * 重置用户密码     
     * @param sunmnetUserInfoEntity
     * @author  zfb
     * @create 2018-04-09
     * @return
     */
	public SystemManageResponseInfo<Object> resetUserPassword(SunmnetUserInfoEntity sunmnetUserInfoEntity);

	
	/**
     * 根据用户编号查询角色信息
     * @param queryUserRoleInfoRequest
     * @author zfb
     * @create 2018-04-18
     * @return
     */
	public SystemManageResponseInfo<QueryUserRoleInfoResponse> queryUserRoleInfoByUserNo(
			QueryUserRoleInfoRequest queryUserRoleInfoRequest);

	/**
     * 根据筛选条件查询教职工信息
     * @author fr
     * @create 2018-06-23
     * @return
     */
	public SystemManageResponseInfo<PageResult> queryRemoteTeacherList(
			QueryRemoteTeacherListRequest queryRemoteTeacherListRequest);
	/**
     * 根据筛选条件查询学生信息
     * @author fr
     * @create 2018-06-23
     * @return
     */
	public SystemManageResponseInfo<PageResult> queryRemoteStudentList(
			QueryRemoteStudentListRequest queryRemoteStudentListRequest);
	/**
     * 生成学院学生登录用户
     * @author wm
     * @create 2018-06-27
     * @return
     */
	public SystemManageResponseInfo<Object> generationStudentUser(
			GenerationStudentUserRequest generationStudentUserRequest);
	/**
     * 生成学院教职工登录用户
     * @author wm
     * @create 2018-06-27
     * @return
     */
	public SystemManageResponseInfo<Object> generationTeacherUser(
			GenerationTeacherUserRequest generationTeacherUserRequest);
	/**
     * 用户批量授权角色
     * @author wm
     * @create 2018-07-11
     * @return
     */
	public SystemManageResponseInfo<Object> batchUserRole(
			BatchUserRoleRequest batchUserRoleRequest);
}
