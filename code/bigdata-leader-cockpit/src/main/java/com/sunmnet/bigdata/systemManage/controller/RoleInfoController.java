package com.sunmnet.bigdata.systemManage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.sunmnet.bigdata.systemManage.biz.RoleInfoBiz;
import com.sunmnet.bigdata.systemManage.common.exception.SystemManageException;
import com.sunmnet.bigdata.systemManage.common.log.LoggerManage;

/**
 * 角色信息
 * @author wm
 * @create 2018-04-04
 */
@RestController
@RequestMapping("/manage/role")
public class RoleInfoController extends BaseController{
	
	@Autowired
	private RoleInfoBiz roleInfoBiz;
	
	/**
     * 添加角色
     * @param addRoleInfoRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/addRoleInfo")
    @LoggerManage(description = "添加角色")
    public BaseResponseInfo<Object> addRoleInfo(@Validated  AddRoleInfoRequest addRoleInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = roleInfoBiz.addRoleInfo(addRoleInfoRequest);
		} catch (Exception e) {
			logger.error("添加角色--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 修改角色信息
     * @param modifyRoleInfoRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/modifyRoleInfo")
    @LoggerManage(description = "修改角色信息")
    public BaseResponseInfo<Object> modifyRoleInfo(@Validated  ModifyRoleInfoRequest modifyRoleInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = roleInfoBiz.modifyRoleInfo(modifyRoleInfoRequest);
		} catch (Exception e) {
			logger.error("修改角色信息--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	/**
     * 删除角色信息
     * @param deleteRoleInfoRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/deleteRoleInfo")
    @LoggerManage(description = "删除角色信息")
    public BaseResponseInfo<Object> deleteRoleInfo(@Validated  DeleteRoleInfoRequest deleteRoleInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = roleInfoBiz.deleteRoleInfo(deleteRoleInfoRequest);
		} catch (Exception e) {
			logger.error("删除角色信息--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	/**
     * 查询角色信息详情
     * @param queryRoleInfoRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryRoleInfo")
    @LoggerManage(description = "查询角色信息详情")
    public BaseResponseInfo<QueryRoleInfoResponse> queryRoleInfo(@Validated  QueryRoleInfoRequest queryRoleInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<QueryRoleInfoResponse> responseInfo = new BaseResponseInfo<QueryRoleInfoResponse>();
		try {
			responseInfo = roleInfoBiz.queryRoleInfo(queryRoleInfoRequest);
		} catch (Exception e) {
			logger.error("查询角色信息详情--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 分页查询角色信息列表
     * @param queryReleInfoPageRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryRoleInfoPage")
    @LoggerManage(description = "分页查询角色信息列表")
    public BaseResponseInfo<PageResult> queryRoleInfoPage(@Validated  QueryRoleInfoPageRequest queryReleInfoPageRequest ,BindingResult bindingResult) {
		BaseResponseInfo<PageResult> responseInfo = new BaseResponseInfo<PageResult>();
		try {
			responseInfo = roleInfoBiz.queryRoleInfoPage(queryReleInfoPageRequest);
		} catch (Exception e) {
			logger.error("分页查询角色信息列表--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 角色授权菜单、功能点
     * @param roleSetMenuFunctionRequest
     * @author wm
     * @create 2018-04-08
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/roleSetMenuFunction")
    @LoggerManage(description = "角色授权菜单、功能点")
    public BaseResponseInfo<Object> roleSetMenuFunction(@Validated  RoleSetMenuFunctionRequest roleSetMenuFunctionRequest ,BindingResult bindingResult) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = roleInfoBiz.roleSetMenuFunction(roleSetMenuFunctionRequest);
		} catch (Exception e) {
			logger.error("角色授权菜单、功能点--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 查询角色列表
     * @author zfb
     * @create 2018-04-11
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryRoleDropdown")
    @LoggerManage(description = "查询角色列表")
    public BaseResponseInfo<QueryRoleDropdownResponse> queryRoleDropdown() {
		
		BaseResponseInfo<QueryRoleDropdownResponse> responseInfo = new BaseResponseInfo<QueryRoleDropdownResponse>();
		try {
			responseInfo = roleInfoBiz.queryRoleDropdown();
		} catch (Exception e) {
			logger.error("查询角色下拉框选择--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	
	
	
	
}
