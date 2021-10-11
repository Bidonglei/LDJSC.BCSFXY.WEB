package com.sunmnet.bigdata.systemManage.biz;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetUserInfoEntity;
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



/**
 * 用户信息校验
 * @author zfb
 * @create 2018-03-27
 */
public interface UserInfoBiz {

	/**
     * 新增用户
     * @param addUserInfoRequest
     * @author wm
     * @create 2018-03-21
     * @return
     */
	public BaseResponseInfo<Object> add(AddUserInfoRequest addUserInfoRequest);

	/**
     * 删除用户信息
     * @param deleteUserInfoRequest
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	public BaseResponseInfo<Object> deleteUserInfo(DeleteUserInfoRequest deleteUserInfoRequest);

	/**
     * 查询用户详细信息
     * @param queryUserInfoRequest
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	public BaseResponseInfo<QueryUserInfoResponse> queryUserInfo(QueryUserInfoRequest queryUserInfoRequest);

	/**
     * 修改用户状态
     * @param modifyUserStatusRequest
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	public BaseResponseInfo<Object> modifyUserStatus(ModifyUserStatusRequest modifyUserStatusRequest);

	/**
     * 重置用户密码
     * @param modifyUserPasswordRequest
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	public BaseResponseInfo<Object> resetPassword(ResetUserPasswordRequest resetUserPasswordRequest);

	/**
     * 分页查询用户信息
     * @param queryUserInfoPageRequest
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	public BaseResponseInfo<PageResult> query(QueryUserInfoPageRequest queryUserInfoPageRequest);
	/**
     * 设置用户角色权限
     * @param setUserRoleRequest
     * @author  wm
     * @create 2018-04-07
     * @return
     */
	public BaseResponseInfo<Object> setUserRole(SetUserRoleRequest setUserRoleRequest);

	/**
     * 设置用户信息
     * @param modifyUserInfoRequest
     * @author  zfb
     * @create 2018-04-09
     * @return
     */
	public BaseResponseInfo<Object> modifyUserInfo(ModifyUserInfoRequest modifyUserInfoRequest);

	/**
     * 查询远程用户详细信息
     * @param userLoginReques
     * @author zfb
     * @create 2018-04-10
     * @return
     */
	public BaseResponseInfo<SunmnetUserInfoEntity> queryUserInfoRemote(QueryUserInfoByRelationRequest queryUserInfoByRelationRequest);

	/**
     * 修改用户密码
     * @param modifyUserPasswordRequest
     * @author zfb
     * @create 2018-04-10
     * @return
     */
	public BaseResponseInfo<Object> modifyPassword(ModifyUserPasswordRequest modifyUserPasswordRequest);

	
	/**
     * 根据用户编号查询角色信息
     * @param queryUserRoleInfoRequest
     * @author zfb
     * @create 2018-04-18
     * @return
     */
	public BaseResponseInfo<QueryUserRoleInfoResponse> queryUserRoleInfo(
			QueryUserRoleInfoRequest queryUserRoleInfoRequest);

	/**
     * 根据筛选条件查询教职工信息
     * @author fr
     * @create 2018-06-23
     * @return
     */
	public BaseResponseInfo<PageResult> queryRemoteTeacherList(
			QueryRemoteTeacherListRequest queryRemoteTeacherListRequest);
	/**
     * 根据筛选条件查询学生信息
     * @author fr
     * @create 2018-06-23
     * @return
     */
	public BaseResponseInfo<PageResult> queryRemoteStudentList(
			QueryRemoteStudentListRequest queryRemoteStudentListRequest);
	/**
     * 生成学院学生登录用户
     * @author wm
     * @create 2018-06-27
     * @return
     */
	public BaseResponseInfo<Object> generationStudentUser(
			GenerationStudentUserRequest generationStudentUserRequest);

	/**
     * 生成学院教职工登录用户
     * @author wm
     * @create 2018-06-27
     * @return
     */
	public BaseResponseInfo<Object> generationTeacherUser(
			GenerationTeacherUserRequest generationTeacherUserRequest);
	/**
     * 用户批量授权角色
     * @author wm
     * @create 2018-07-11
     * @return
     */
	public BaseResponseInfo<Object> batchUserRole(
			BatchUserRoleRequest batchUserRoleRequest);
	
}
