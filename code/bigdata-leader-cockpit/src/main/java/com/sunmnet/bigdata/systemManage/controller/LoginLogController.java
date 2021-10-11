package com.sunmnet.bigdata.systemManage.controller;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.AccountLoginInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AccountLoginHistoryPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AccountLoginPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddIndexInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.IndexInfoRequest;
import com.sunmnet.bigdata.systemManage.common.exception.SystemManageException;
import com.sunmnet.bigdata.systemManage.common.log.LoggerManage;
import com.sunmnet.bigdata.systemManage.service.IndexInfoService;
import com.sunmnet.bigdata.systemManage.service.LoginLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *功能描述 登陆日志
 * @author lkg
 * @date 2019/7/26
 */
@Api(tags="登陆日志")
@RestController
@RequestMapping("/loginLog")
public class LoginLogController extends BaseController{
	

	@Autowired
	private LoginLogService loginLogService;

	@ApiOperation(value = "登录时增加登录日志 （只是为了测试）")
	@SuppressWarnings("unchecked")
	@RequestMapping("/addLoginLog")
	@LoggerManage(description = "登录时增加登录日志")
	public BaseResponseInfo<Object> addLoginLog(AccountLoginInfo accountLoginInfo) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			int i = loginLogService.addLoginLog(accountLoginInfo);
			responseInfo.setCode(i + "");
			responseInfo.setMessage("登录时增加登录日志成功");
		} catch (Exception e) {
			logger.error("登录时增加登录日志--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
	}

	@ApiOperation(value = "分页查询全部用户登陆信息列表")
	@SuppressWarnings("unchecked")
	@RequestMapping("/accountLoginPage")
	@LoggerManage(description = "分页查询全部用户登陆信息列表")
	public BaseResponseInfo<Object> accountLoginPage( @Validated AccountLoginPageRequest accountLoginPageRequest,BindingResult bindingResult) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = loginLogService.accountLoginPage(accountLoginPageRequest);
		} catch (Exception e) {
			logger.error("分页查询全部用户登陆信息列表--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
	}

	@ApiOperation(value = "分页查询用户登陆历史信息列表")
	@SuppressWarnings("unchecked")
	@RequestMapping("/accountLoginHistoryPage")
	@LoggerManage(description = "分页查询用户登陆历史信息列表")
	public BaseResponseInfo<Object> accountLoginHistoryPage( @Validated AccountLoginHistoryPageRequest accountLoginHistoryPageRequest,BindingResult bindingResult) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = loginLogService.accountLoginHistoryPage(accountLoginHistoryPageRequest);
		} catch (Exception e) {
			logger.error("分页查询用户登陆历史信息列表--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
	}
}
