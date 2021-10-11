package com.sunmnet.bigdata.systemManage.service;

import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemAdminInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddSystemAdminInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.DeleteSystemAdminInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifySystemAdminInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifySystemAdminPasswordRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifySystemAdminStutasRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QuerySystemAdminInfoPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ResetSystemAdminPasswordRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.SetSystemAdminMenuRoleRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QuerySystemAdminInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;


/**
 * 管理员信息
 * @author wm
 * @create 2018-04-04
 */
public interface SystemAdminInfoService {
	/**
     * 新增管理员
     * @param addSystemAdminInfoRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	public SystemManageResponseInfo<Object> addSystemAdminInfo(AddSystemAdminInfoRequest addSystemAdminInfoRequest);
	/**
     * 删除管理员
     * @param deleteSystemAdminInfoRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	public SystemManageResponseInfo<Object> deleteSystemAdminInfo(DeleteSystemAdminInfoRequest deleteSystemAdminInfoRequest);
	/**
     * 修改管理员状态
     * @param modifySystemAdminInfoRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	public SystemManageResponseInfo<Object> modifySystemAdminStatus(ModifySystemAdminStutasRequest modifySystemAdminInfoRequest);
	/**
     * 查询管理员信息列表
     * @param querySystemAdminInfoPageRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	public SystemManageResponseInfo<PageResult> querySystemAdminInfoPage(QuerySystemAdminInfoPageRequest querySystemAdminInfoPageRequest);
	/**
     * 查询管理员详细信息
     * @param sunmnetSystemAdminInfoEntity
     * @author wm
     * @create 2018-04-04
     * @return
     */
	public SystemManageResponseInfo<QuerySystemAdminInfoResponse> querySystemAdminInfo(SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity);
	/**
     * 重置管理员秘密
     * @param resetSystemAdminPasswordRequest
     * @author wm
     * @create 2018-04-06
     * @return
     */
	public SystemManageResponseInfo<Object> resetSystemAdminPassword(ResetSystemAdminPasswordRequest resetSystemAdminPasswordRequest);
	/**
     * 设置管理员菜单权限
     * @param setSystemAdminMenuRoleRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	public SystemManageResponseInfo<Object> setSystemAdminMenuRole(SetSystemAdminMenuRoleRequest setSystemAdminMenuRoleRequest);
	
	/**
     * 修改管理员信息
     * @param modifySystemAdminInfoRequest
     * @author wm
     * @create 2018-04-09
     * @return
     */
	public SystemManageResponseInfo<Object> modifySystemAdminInfo(ModifySystemAdminInfoRequest modifySystemAdminInfoRequest);
	/**
     * 修改管理员密码
     * @param modifySystemAdminPasswordRequest
     * @author wm
     * @create 2018-04-06
     * @return
     */
	public SystemManageResponseInfo<Object> modifySystemAdminPassword(ModifySystemAdminPasswordRequest modifySystemAdminPasswordRequest);

	
}
