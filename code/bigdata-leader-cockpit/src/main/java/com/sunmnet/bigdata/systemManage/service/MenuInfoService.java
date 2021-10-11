package com.sunmnet.bigdata.systemManage.service;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetMenuInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddMenuFunctionRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddMenuRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.MenuSortRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyMenuFunctionRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyMenuInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryAdminRoleMenuRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryMenuDownDropdownRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryMenuDropdownRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRoleMenuInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserRoleMenuAllRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserRoleMenuInfoRemoteRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserSystemNoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryMenuDownDropdownResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryMenuDropdownResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryMenuInfoByMenuNoResonse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryMenuInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryRoleMenuInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QuerySystemMenuInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserRoleMenuAllResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserRoleMenuInfoRemoteResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserSystemNoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;


/**
 * 菜单信息
 * @author wm
 * @create 2018-03-30
 */
public interface MenuInfoService {
	/**
     * 查询管理系统菜单列表
     * @param querySystemMenuInfoRequest
     * @author wm
     * @create 2018-04-06
     * @return
     */
	public SystemManageResponseInfo<QuerySystemMenuInfoResponse> querySystemMenuInfo(QueryAdminRoleMenuRequest queryAdminRoleMenuRequest);
	/**
	 * 添加菜单
	 * @param addMenuRequest
	 * @author wm
	 * @create 2018-04-07
	 */
	public SystemManageResponseInfo<Object> addMenu(AddMenuRequest addMenuRequest);
	/**
     * 修改菜单信息
     * @param modifyMenuInfoRequest
     * @author wm
     * @create 2018-04-08
     * @return
     */
	public SystemManageResponseInfo<Object> modifyMenuInfo(ModifyMenuInfoRequest modifyMenuInfoRequest);
	/**
     * 删除菜单信息
     * @param deleteMenuInfoRequest
     * @author wm
     * @create 2018-04-08
     * @return
     */
	public SystemManageResponseInfo<Object> deleteMenuInfo(SunmnetMenuInfoEntity sunmnetMenuInfoEntity);
	/**
	 * 查询菜单下拉框
	 * @param queryMenuDorpdownRequest
	 * @author zfb
	 * @create 2018-04-08
	 */
	public SystemManageResponseInfo<QueryMenuDropdownResponse> queryDepartmentDropdown(
			QueryMenuDropdownRequest queryMenuDorpdownRequest);
	/**
     * 添加功能点
     * @param addMenuFunctionRequest
     * @author wm
     * @create 2018-04-08
     * @return
     */
	public SystemManageResponseInfo<Object> addMenuFunction(AddMenuFunctionRequest addMenuFunctionRequest);
	
	/**
     * 修改功能点信息
     * @param modifyMenuFunctionRequest
     * @author wm
     * @create 2018-04-08
     * @return
     */
	public SystemManageResponseInfo<Object> modifyMenuFunction(ModifyMenuFunctionRequest modifyMenuFunctionRequest);
	
	/**
     * 查询角色授权的菜单信息
     * @param queryRoleMenuInfoRequest
     * @author wm
     * @create 2018-04-08
     * @return
     */
	public SystemManageResponseInfo<QueryRoleMenuInfoResponse> queryRoleMenuInfo(QueryRoleMenuInfoRequest queryRoleMenuInfoRequest);
	/**
     * 查询菜单信息     
     * @author zfb
     * @create 2018-04-12
     * @return
     */
	public SystemManageResponseInfo<QueryMenuInfoResponse> queryMenuInfo();
	/**
     * 查询用户登录的权限菜单信息服务间调用根据用户编号和系统编号
     * @param queryUserRoleMenuInfoRemoteRequest
     * @author wm
	 * @param systemName 
     * @create 2018-04-12
     * @return
     */
	public SystemManageResponseInfo<QueryUserRoleMenuInfoRemoteResponse> queryUserRoleMenuInfoRemote(
			QueryUserRoleMenuInfoRemoteRequest queryUserRoleMenuInfoRemoteRequest, String systemName);
	/**
     * 根据菜单编号查询菜单下级菜单下拉框
     * @author wm
     * @create 2018-04-12
     * @return
     */
	public SystemManageResponseInfo<QueryMenuDownDropdownResponse> queryMenuDownDropdown(
			QueryMenuDownDropdownRequest queryMenuDownDropdownRequest);
	/**
     * 根据菜单编号查询菜单详细信息
     * @param sunmnetMenuInfoEntity
     * @author zfb
     * @create 2018-04-13
     * @return
     */
	public SystemManageResponseInfo<QueryMenuInfoByMenuNoResonse> queryMenuInfoByMenuNo(
			SunmnetMenuInfoEntity sunmnetMenuInfoEntity);
	/**
     * 查询用户权限菜单编号服务间调用
     * @param queryUserMenuNoAllRequest
     * @author wm
     * @create 2018-05-27
     * @return
     */
	public SystemManageResponseInfo<QueryUserRoleMenuAllResponse> queryUserRoleMenuAll(
			QueryUserRoleMenuAllRequest queryUserRoleMenuAllRequest);
	
	/**
     * 查询用户拥有的系统权限
     * @param queryUserSystemNoRequest
     * @author wm
     * @create 2018-07-31
     * @return
     */
	public SystemManageResponseInfo<QueryUserSystemNoResponse> queryUserSystemNo(
			QueryUserSystemNoRequest queryUserSystemNoRequest);
	
	/**
     * 菜单排序
     * @param menuSort
     * @author zfb
     * @create 2018-09-17
     * @return
     */
	public SystemManageResponseInfo<Object> menuSort(
			MenuSortRequest menuSortRequest);
	
}
