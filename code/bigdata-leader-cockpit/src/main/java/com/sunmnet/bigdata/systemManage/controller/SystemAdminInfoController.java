package com.sunmnet.bigdata.systemManage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.sunmnet.bigdata.systemManage.biz.SystemAdminInfoBiz;
import com.sunmnet.bigdata.systemManage.common.exception.SystemManageException;
import com.sunmnet.bigdata.systemManage.common.log.LoggerManage;

/**
 * 管理员信息
 * @author wm
 * @create 2018-04-04
 */
@RestController
@RequestMapping("/manage/systemAdmin")
public class SystemAdminInfoController extends BaseController{
	
	@Autowired
	private SystemAdminInfoBiz systemAdminInfoBiz;
	
	/**
     * 新增管理员
     * @param addSystemAdminInfoRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/addSystemAdminInfo")
    @LoggerManage(description = "新增管理员")
    public BaseResponseInfo<Object> addSystemAdminInfo(@Validated  AddSystemAdminInfoRequest addSystemAdminInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = systemAdminInfoBiz.addSystemAdminInfo(addSystemAdminInfoRequest);
		} catch (Exception e) {
			logger.error("新增管理员--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 修改管理员信息
     * @param modifySystemAdminInfoRequest
     * @author wm
     * @create 2018-04-09
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/modifySystemAdminInfo")
    @LoggerManage(description = "修改管理员信息")
    public BaseResponseInfo<Object> modifySystemAdminInfo(@Validated  ModifySystemAdminInfoRequest modifySystemAdminInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = systemAdminInfoBiz.modifySystemAdminInfo(modifySystemAdminInfoRequest);
		} catch (Exception e) {
			logger.error("修改管理员信息--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	
	
	/**
     * 删除管理员
     * @param deleteSystemAdminInfoRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/deleteSystemAdminInfo")
    @LoggerManage(description = "删除管理员")
    public BaseResponseInfo<Object> deleteSystemAdminInfo(@Validated  DeleteSystemAdminInfoRequest deleteSystemAdminInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = systemAdminInfoBiz.deleteSystemAdminInfo(deleteSystemAdminInfoRequest);
		} catch (Exception e) {
			logger.error("删除管理员--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 修改管理员状态
     * @param modifySystemAdminInfoRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/modifySystemAdminStatus")
    @LoggerManage(description = "修改管理员状态")
    public BaseResponseInfo<Object> modifySystemAdminStatus(@Validated  ModifySystemAdminStutasRequest modifySystemAdminInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = systemAdminInfoBiz.modifySystemAdminStatus(modifySystemAdminInfoRequest);
		} catch (Exception e) {
			logger.error("修改管理员状态--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	
	/**
     * 查询管理员信息列表
     * @param querySystemAdminInfoPageRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/querySystemAdminInfoPage")
    @LoggerManage(description = "查询管理员信息列表")
    public BaseResponseInfo<PageResult> querySystemAdminInfoPage(@Validated  QuerySystemAdminInfoPageRequest querySystemAdminInfoPageRequest ,BindingResult bindingResult) {
		BaseResponseInfo<PageResult> responseInfo = new BaseResponseInfo<PageResult>();
		try {
			responseInfo = systemAdminInfoBiz.querySystemAdminInfoPage(querySystemAdminInfoPageRequest);
		} catch (Exception e) {
			logger.error("查询管理员信息列表--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 查询管理员详细信息
     * @param querySystemAdminInfoRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/querySystemAdminInfo")
    @LoggerManage(description = "查询管理员详细信息")
    public BaseResponseInfo<QuerySystemAdminInfoResponse> querySystemAdminInfo(@Validated  QuerySystemAdminInfoRequest querySystemAdminInfoRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<QuerySystemAdminInfoResponse> responseInfo = new BaseResponseInfo<QuerySystemAdminInfoResponse>();
		try {
			responseInfo = systemAdminInfoBiz.querySystemAdminInfo(querySystemAdminInfoRequest);
		} catch (Exception e) {
			logger.error("查询管理员详细信息--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 重置管理员秘密
     * @param resetSystemAdminPasswordRequest
     * @author wm
     * @create 2018-04-06
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/resetSystemAdminPassword")
    @LoggerManage(description = "重置管理员秘密")
    public BaseResponseInfo<Object> resetSystemAdminPassword(@Validated  ResetSystemAdminPasswordRequest resetSystemAdminPasswordRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = systemAdminInfoBiz.resetSystemAdminPassword(resetSystemAdminPasswordRequest);
		} catch (Exception e) {
			logger.error("重置管理员秘密--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 设置管理员菜单权限
     * @param setSystemAdminMenuRoleRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/setSystemAdminMenuRole")
    @LoggerManage(description = "设置管理员菜单权限")
    public BaseResponseInfo<Object> setSystemAdminMenuRole(@Validated SetSystemAdminMenuRoleRequest setSystemAdminMenuRoleRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = systemAdminInfoBiz.setSystemAdminMenuRole(setSystemAdminMenuRoleRequest);
		} catch (Exception e) {
			logger.error("设置管理员菜单权限--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	
	/**
     * 修改管理员密码
     * @param modifySystemAdminPasswordRequest
     * @author wm
     * @create 2018-04-06
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/modifySystemAdminPassword")
    @LoggerManage(description = "修改管理员密码")
    public BaseResponseInfo<Object> modifySystemAdminPassword(@Validated  ModifySystemAdminPasswordRequest modifySystemAdminPasswordRequest ,BindingResult bindingResult) {
		
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = systemAdminInfoBiz.modifySystemAdminPassword(modifySystemAdminPasswordRequest);
		} catch (Exception e) {
			logger.error("修改管理员密码--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
}
