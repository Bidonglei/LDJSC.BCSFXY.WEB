package com.sunmnet.bigdata.systemManage.service;

import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetRoleInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddRoleInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyRoleInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRoleInfoPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.RoleSetMenuFunctionRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryRoleDropdownResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryRoleInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;


/**
 * 角色信息
 * @author wm
 * @create 2018-04-04
 */
public interface RoleInfoService {
	/**
     * 添加角色
     * @param addRoleInfoRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	public SystemManageResponseInfo<Object> addRoleInfo(AddRoleInfoRequest addRoleInfoRequest);
	/**
     * 修改角色信息
     * @param modifyRoleInfoRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	public SystemManageResponseInfo<Object> modifyRoleInfo(ModifyRoleInfoRequest modifyRoleInfoRequest);
	/**
     * 删除角色信息
     * @param sunmnetRoleInfoEntity
     * @author wm
     * @create 2018-04-07
     * @return
     */
	public SystemManageResponseInfo<Object> deleteRoleInfo(SunmnetRoleInfoEntity sunmnetRoleInfoEntity);
	/**
     * 查询角色信息详情
     * @param sunmnetRoleInfoEntity
     * @author wm
     * @create 2018-04-07
     * @return
     */
	public SystemManageResponseInfo<QueryRoleInfoResponse> queryRoleInfo(SunmnetRoleInfoEntity sunmnetRoleInfoEntity);
	/**
     * 分页查询角色信息列表
     * @param queryReleInfoPageRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	public SystemManageResponseInfo<PageResult> queryRoleInfoPage(QueryRoleInfoPageRequest queryReleInfoPageRequest);
	/**
     * 角色授权菜单、功能点
     * @param roleSetMenuFunctionRequest
     * @author wm
     * @create 2018-04-08
     * @return
     */
	public SystemManageResponseInfo<Object> roleSetMenuFunction(RoleSetMenuFunctionRequest roleSetMenuFunctionRequest);
	/**
     * 查询角色下拉框     
     * @author zfb
     * @create 2018-04-11
     * @return
     */
	public SystemManageResponseInfo<QueryRoleDropdownResponse> queryRoleDropdown();

	
}
