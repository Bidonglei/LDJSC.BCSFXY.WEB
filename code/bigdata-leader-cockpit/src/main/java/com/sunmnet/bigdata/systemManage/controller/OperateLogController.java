package com.sunmnet.bigdata.systemManage.controller;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.LookAnalysisInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.MenuVisitRecordRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.OperateLogPageRequest;
import com.sunmnet.bigdata.systemManage.common.exception.SystemManageException;
import com.sunmnet.bigdata.systemManage.common.log.LoggerManage;
import com.sunmnet.bigdata.systemManage.service.OperateLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *功能描述 操作日志
 * @author lkg
 * @date 2019/8/5
 */
@Api(tags="操作日志")
@RestController
@RequestMapping("/operateLog")
public class OperateLogController extends BaseController{
	
	@Autowired
	private OperateLogService operateLogService;

	@ApiOperation(value = "增加用户查看")
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveLookRecord")
	@LoggerManage(description = "增加用户查看")
	public BaseResponseInfo<Object> saveLookRecord( @Validated LookAnalysisInfo lookAnalysisInfo,BindingResult bindingResult) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = operateLogService.saveLookRecord(lookAnalysisInfo);
		} catch (Exception e) {
			logger.error("增加用户查看--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
	}

	@ApiOperation(value = "操作日志分页列表")
	@SuppressWarnings("unchecked")
	@RequestMapping("/operateLogPage")
	@LoggerManage(description = "操作日志分页列表")
	public BaseResponseInfo<Object> operateLogPage( @Validated OperateLogPageRequest operateLogPageRequest,BindingResult bindingResult) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = operateLogService.operateLogPage(operateLogPageRequest);
		} catch (Exception e) {
			logger.error("操作日志分页列表--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
	}

	@ApiOperation(value = "登陆统计")
	@SuppressWarnings("unchecked")
	@RequestMapping("/loginStatistics")
	@LoggerManage(description = "登陆统计")
	public BaseResponseInfo<Object> loginStatistics() {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = operateLogService.loginStatistics();
		} catch (Exception e) {
			logger.error("登陆统计--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
	}

	@ApiOperation(value = "系统本月访问人次")
	@SuppressWarnings("unchecked")
	@RequestMapping("/loginMonthStatistics")
	@LoggerManage(description = "系统本月访问人次")
	public BaseResponseInfo<Object> loginMonthStatistics() {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = operateLogService.loginMonthStatistics();
		} catch (Exception e) {
			logger.error("系统本月访问人次--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
	}

	@ApiOperation(value = "各模块访问情况")
	@SuppressWarnings("unchecked")
	@RequestMapping("/menuVisitRecord")
	@LoggerManage(description = "各模块访问情况")
	public BaseResponseInfo<Object> menuVisitRecord(MenuVisitRecordRequest menuVisitRecordRequest) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = operateLogService.menuVisitRecord(menuVisitRecordRequest);
		} catch (Exception e) {
			logger.error("各模块访问情况--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
	}
}
