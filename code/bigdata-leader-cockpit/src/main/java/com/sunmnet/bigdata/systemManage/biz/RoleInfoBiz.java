package com.sunmnet.bigdata.systemManage.biz;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddRoleInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.DeleteRoleInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyRoleInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRoleInfoPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRoleInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.RoleSetMenuFunctionRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryRoleDropdownResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryRoleInfoResponse;



/**
 * 角色信息校验
 * @author wm
 * @create 2018-04-04
 */
public interface RoleInfoBiz {
	/**
     * 添加角色
     * @param addRoleInfoRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	public BaseResponseInfo<Object> addRoleInfo(AddRoleInfoRequest addRoleInfoRequest);
	/**
     * 修改角色信息
     * @param modifyRoleInfoRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	public BaseResponseInfo<Object> modifyRoleInfo(ModifyRoleInfoRequest modifyRoleInfoRequest);
	/**
     * 删除角色信息
     * @param deleteRoleInfoRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	public BaseResponseInfo<Object> deleteRoleInfo(DeleteRoleInfoRequest deleteRoleInfoRequest);
	/**
     * 查询角色信息详情
     * @param queryRoleInfoRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	public BaseResponseInfo<QueryRoleInfoResponse> queryRoleInfo(QueryRoleInfoRequest queryRoleInfoRequest);
	/**
     * 分页查询角色信息列表
     * @param queryReleInfoPageRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	public BaseResponseInfo<PageResult> queryRoleInfoPage(QueryRoleInfoPageRequest queryReleInfoPageRequest);
	/**
     * 角色授权菜单、功能点
     * @param roleSetMenuFunctionRequest
     * @author wm
     * @create 2018-04-08
     * @return
     */
	public BaseResponseInfo<Object> roleSetMenuFunction(RoleSetMenuFunctionRequest roleSetMenuFunctionRequest);
	/**
     * 查询角色列表下拉框     
     * @author zfb
     * @create 2018-04-11
     * @return
     */
	public BaseResponseInfo<QueryRoleDropdownResponse> queryRoleDropdown();

	
}
