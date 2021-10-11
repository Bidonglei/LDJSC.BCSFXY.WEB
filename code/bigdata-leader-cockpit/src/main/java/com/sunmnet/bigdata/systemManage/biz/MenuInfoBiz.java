package com.sunmnet.bigdata.systemManage.biz;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddMenuFunctionRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddMenuRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.DeleteMenuInfoOrFunctionRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.MenuSortRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyMenuFunctionRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyMenuInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryAdminRoleMenuRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryMenuDownDropdownRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryMenuDropdownRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryMenuInfoRequest;
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



/**
 * 菜单信息校验
 * @author wm
 * @create 2018-03-30
 */
public interface MenuInfoBiz {

	/**
     * 查询管理系统菜单列表
     * @param querySystemMenuInfoRequest
     * @author wm
     * @create 2018-04-06
     * @return
     */
	public BaseResponseInfo<QuerySystemMenuInfoResponse> querySystemMenuInfo(QueryAdminRoleMenuRequest queryAdminRoleMenuRequest);
	/**
	 * 添加菜单
	 * @param addMenuRequest
	 * @author wm
	 * @create 2018-04-07
	 */
	public BaseResponseInfo<Object> addMenu(AddMenuRequest addMenuRequest);
	/**
     * 修改菜单信息
     * @param modifyMenuInfoRequest
     * @author wm
     * @create 2018-04-08
     * @return
     */
	public BaseResponseInfo<Object> modifyMenuInfo(ModifyMenuInfoRequest modifyMenuInfoRequest);
	/**
     * 删除菜单,功能点信息
     * @param deleteMenuInfoOrFunctionRequest
     * @author wm
     * @create 2018-04-08
     * @return
     */
	public BaseResponseInfo<Object> deleteMenuInfoOrFunction(DeleteMenuInfoOrFunctionRequest deleteMenuInfoOrFunctionRequest);
	/**
	 * 查询菜单下拉框
	 * @param queryMenuDorpdownRequest
	 * @author zfb
	 * @create 2018-04-08
	 */
	public BaseResponseInfo<QueryMenuDropdownResponse> queryMenuDropdown(
			QueryMenuDropdownRequest queryMenuDorpdownRequest);
	/**
     * 添加功能点
     * @param addMenuFunctionRequest
     * @author wm
     * @create 2018-04-08
     * @return
     */
	public BaseResponseInfo<Object> addMenuFunction(AddMenuFunctionRequest addMenuFunctionRequest);
	/**
     * 修改功能点信息
     * @param modifyMenuFunctionRequest
     * @author wm
     * @create 2018-04-08
     * @return
     */
	public BaseResponseInfo<Object> modifyMenuFunction(ModifyMenuFunctionRequest modifyMenuFunctionRequest);
	/**
     * 查询角色授权的菜单信息
     * @param queryRoleMenuInfoRequest
     * @author wm
     * @create 2018-04-08
     * @return
     */
	public BaseResponseInfo<QueryRoleMenuInfoResponse> queryRoleMenuInfo(QueryRoleMenuInfoRequest queryRoleMenuInfoRequest);
	/**
     * 查询菜单信息     
     * @author zfb
     * @create 2018-04-12
     * @return
     */
	public BaseResponseInfo<QueryMenuInfoResponse> queryMenuInfo();
	/**
     * 查询用户登录的权限菜单信息服务间调用根据用户编号和系统编号
     * @param queryUserRoleMenuInfoRemoteRequest
     * @author wm
     * @create 2018-04-12
     * @return
     */
	public BaseResponseInfo<QueryUserRoleMenuInfoRemoteResponse> queryUserRoleMenuInfoRemote(
			QueryUserRoleMenuInfoRemoteRequest queryUserRoleMenuInfoRemoteRequest);
	/**
     * 根据菜单编号查询菜单下级菜单下拉框
     * @author wm
     * @create 2018-04-12
     * @return
     */
	public BaseResponseInfo<QueryMenuDownDropdownResponse> queryMenuDownDropdown(
			QueryMenuDownDropdownRequest queryMenuDownDropdownRequest);
	/**
     * 根据菜单编号查询菜单详细信息
     * @param queryMenuInfoRequest
     * @author zfb
     * @create 2018-04-13
     * @return
     */
	public BaseResponseInfo<QueryMenuInfoByMenuNoResonse> queryMenuInfoByMenuNo(
			QueryMenuInfoRequest queryMenuInfoRequest);
	/**
     * 查询用户权限菜单编号服务间调用
     * @param queryUserMenuNoAllRequest
     * @author wm
     * @create 2018-05-27
     * @return
     */
	public BaseResponseInfo<QueryUserRoleMenuAllResponse> queryUserRoleMenuAll(QueryUserRoleMenuAllRequest queryUserRoleMenuAllRequest);
	/**
     * 查询用户拥有的系统权限
     * @param queryUserSystemNoRequest
     * @author wm
     * @create 2018-07-31
     * @return
     */
	public BaseResponseInfo<QueryUserSystemNoResponse> queryUserSystemNo(QueryUserSystemNoRequest queryUserSystemNoRequest);
	
	/**
     *菜单排序
     * @param menuSort
     * @author zfb
     * @create 2018-09-17
     * @return
     */
	public BaseResponseInfo<Object> menuSort(MenuSortRequest menuSortRequest);
	
}
