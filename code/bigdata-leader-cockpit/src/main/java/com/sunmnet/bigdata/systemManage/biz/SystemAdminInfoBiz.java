package com.sunmnet.bigdata.systemManage.biz;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddSystemAdminInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.DeleteSystemAdminInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifySystemAdminInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifySystemAdminPasswordRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifySystemAdminStutasRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QuerySystemAdminInfoPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QuerySystemAdminInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ResetSystemAdminPasswordRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.SetSystemAdminMenuRoleRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QuerySystemAdminInfoResponse;



/**
 * 管理员信息校验
 * @author wm
 * @create 2018-04-04
 */
public interface SystemAdminInfoBiz {

	
	/**
     * 新增管理员
     * @param addSystemAdminInfoRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	public BaseResponseInfo<Object> addSystemAdminInfo(AddSystemAdminInfoRequest addSystemAdminInfoRequest);
	/**
     * 删除管理员
     * @param deleteSystemAdminInfoRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	public BaseResponseInfo<Object> deleteSystemAdminInfo(DeleteSystemAdminInfoRequest deleteSystemAdminInfoRequest);
	
	/**
     * 修改管理员状态
     * @param modifySystemAdminInfoRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	public BaseResponseInfo<Object> modifySystemAdminStatus(ModifySystemAdminStutasRequest modifySystemAdminInfoRequest);
	/**
     * 查询管理员信息列表
     * @param querySystemAdminInfoPageRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	public BaseResponseInfo<PageResult> querySystemAdminInfoPage(QuerySystemAdminInfoPageRequest querySystemAdminInfoPageRequest);
	/**
     * 查询管理员详细信息
     * @param querySystemAdminInfoRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	public BaseResponseInfo<QuerySystemAdminInfoResponse> querySystemAdminInfo(QuerySystemAdminInfoRequest querySystemAdminInfoRequest);
	/**
     * 重置管理员秘密
     * @param resetSystemAdminPasswordRequest
     * @author wm
     * @create 2018-04-06
     * @return
     */
	public BaseResponseInfo<Object> resetSystemAdminPassword(ResetSystemAdminPasswordRequest resetSystemAdminPasswordRequest);
	/**
     * 设置管理员菜单权限
     * @param setSystemAdminMenuRoleRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	public BaseResponseInfo<Object> setSystemAdminMenuRole(SetSystemAdminMenuRoleRequest setSystemAdminMenuRoleRequest);
	
	/**
     * 修改管理员信息
     * @param modifySystemAdminInfoRequest
     * @author wm
     * @create 2018-04-09
     * @return
     */
	public BaseResponseInfo<Object> modifySystemAdminInfo(ModifySystemAdminInfoRequest modifySystemAdminInfoRequest);
	/**
     * 修改管理员密码
     * @param modifySystemAdminPasswordRequest
     * @author wm
     * @create 2018-04-06
     * @return
     */
	public BaseResponseInfo<Object> modifySystemAdminPassword(ModifySystemAdminPasswordRequest modifySystemAdminPasswordRequest);

	
}
