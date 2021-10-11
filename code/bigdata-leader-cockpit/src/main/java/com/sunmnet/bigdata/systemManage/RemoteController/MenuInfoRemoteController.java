package com.sunmnet.bigdata.systemManage.RemoteController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserRoleMenuAllRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserRoleMenuInfoRemoteRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserSystemNoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserRoleMenuAllResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserRoleMenuInfoRemoteResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserSystemNoResponse;
import com.sunmnet.bigdata.systemManage.biz.MenuInfoBiz;
import com.sunmnet.bigdata.systemManage.common.exception.SystemManageException;
import com.sunmnet.bigdata.systemManage.common.log.LoggerManage;
import com.sunmnet.bigdata.systemManage.controller.BaseController;

/**
 * 菜单权限服务间调用
 * @author wm
 * @create 2018-04-11
 */
@RestController
@RequestMapping("/menuRemote")
public class MenuInfoRemoteController  extends BaseController {
	

	@Autowired
	private MenuInfoBiz menuInfoBiz;
	
	
	/**
     * 查询用户登录的权限菜单信息服务间调用根据用户编号和系统编号
     * @param queryUserRoleMenuInfoRemoteRequest
     * @author wm
     * @create 2018-04-12
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryUserRoleMenuInfoRemote")
    @LoggerManage(description = "查询用户登录的权限菜单信息服务间调用根据用户编号和系统编号")
    public BaseResponseInfo<QueryUserRoleMenuInfoRemoteResponse> queryUserRoleMenuInfoRemote(@Validated  QueryUserRoleMenuInfoRemoteRequest queryUserRoleMenuInfoRemoteRequest ,BindingResult bindingResult) {
		BaseResponseInfo<QueryUserRoleMenuInfoRemoteResponse> responseInfo = new BaseResponseInfo<QueryUserRoleMenuInfoRemoteResponse>();
		try {
			responseInfo = menuInfoBiz.queryUserRoleMenuInfoRemote(queryUserRoleMenuInfoRemoteRequest);
		} catch (Exception e) {
			logger.error("查询用户登录的权限菜单信息服务间调用根据用户编号和系统编号--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	
	/**
     * 查询用户权限菜单编号服务间调用
     * @param queryUserMenuNoAllRequest
     * @author wm
     * @create 2018-05-27
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryUserRoleMenuAll")
    @LoggerManage(description = "查询用户权限菜单编号服务间调用")
    public BaseResponseInfo<QueryUserRoleMenuAllResponse> queryUserRoleMenuAll(@RequestBody @Validated  QueryUserRoleMenuAllRequest queryUserRoleMenuAllRequest ,BindingResult bindingResult) {
		BaseResponseInfo<QueryUserRoleMenuAllResponse> responseInfo = new BaseResponseInfo<QueryUserRoleMenuAllResponse>();
		try {
			responseInfo = menuInfoBiz.queryUserRoleMenuAll(queryUserRoleMenuAllRequest);
		} catch (Exception e) {
			logger.error("查询用户权限菜单编号服务间调用--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 查询用户拥有的系统权限
     * @param queryUserSystemNoRequest
     * @author wm
     * @create 2018-07-31
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryUserSystemNo")
    @LoggerManage(description = "查询用户拥有的系统权限")
    public BaseResponseInfo<QueryUserSystemNoResponse> queryUserSystemNo(@RequestBody @Validated  QueryUserSystemNoRequest queryUserSystemNoRequest ,BindingResult bindingResult) {
		BaseResponseInfo<QueryUserSystemNoResponse> responseInfo = new BaseResponseInfo<QueryUserSystemNoResponse>();
		try {
			responseInfo = menuInfoBiz.queryUserSystemNo(queryUserSystemNoRequest);
		} catch (Exception e) {
			logger.error("查询用户拥有的系统权限--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
}
