package com.sunmnet.bigdata.systemManage.controller;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.*;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserRoleInfoResponse;
import com.sunmnet.bigdata.systemManage.biz.UserInfoBiz;
import com.sunmnet.bigdata.systemManage.common.exception.SystemManageException;
import com.sunmnet.bigdata.systemManage.common.log.LoggerManage;
import com.sunmnet.bigdata.systemManage.service.IndexInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *功能描述 公共调用
 * @author lkg
 * @date 2019/5/30
 */
@Api(tags="指标信息")
@RestController
@RequestMapping("/manage/index")
public class IndexInfoController extends BaseController{
	
	@Autowired
	private IndexInfoService indexInfoService;

	/**
	 *功能描述 通过组件编号获取指标
	 * @author lkg
	 * @date 2019/5/30
	 */
	@ApiOperation(value = "通过组件编号获取指标")
	@SuppressWarnings("unchecked")
	@RequestMapping("/indexInfo")
	@LoggerManage(description = "通过组件编号获取指标")
	public BaseResponseInfo<Object> indexInfo( @Validated IndexInfoRequest indexInfoRequest,BindingResult bindingResult) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = indexInfoService.indexInfo(indexInfoRequest);
		} catch (Exception e) {
			logger.error("通过组件编号获取指标--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
	}

	@ApiOperation(value = "新增指标")
	@SuppressWarnings("unchecked")
	@RequestMapping("/addIndexInfo")
	@LoggerManage(description = "新增指标")
	public BaseResponseInfo<Object> addIndexInfo( @Validated AddIndexInfoRequest addIndexInfoRequest,BindingResult bindingResult) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = indexInfoService.addIndexInfo(addIndexInfoRequest);
		} catch (Exception e) {
			logger.error("新增指标--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
	}

	@ApiOperation(value = "获取四级功能点")
	@SuppressWarnings("unchecked")
	@RequestMapping("/listPageFunctional")
	@LoggerManage(description = "获取四级功能点")
	public BaseResponseInfo<Object> listPageFunctional( @Validated IndexInfoRequest indexInfoRequest,BindingResult bindingResult) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = indexInfoService.listPageFunctional(indexInfoRequest);
		} catch (Exception e) {
			logger.error("获取四级功能点--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
	}

	@ApiOperation(value = "搜索三级菜单")
	@SuppressWarnings("unchecked")
	@RequestMapping("/searchMenu")
	@LoggerManage(description = "搜索三级菜单")
	public BaseResponseInfo<Object> searchMenu(String content) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = indexInfoService.searchMenu(content);
		} catch (Exception e) {
			logger.error("搜索三级菜单--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
	}

	@ApiOperation(value = "获取数据报告")
	@SuppressWarnings("unchecked")
	@RequestMapping("/pageDataSource")
	@LoggerManage(description = "获取数据报告")
	public BaseResponseInfo<Object> pageDataSource(String menuNo) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = indexInfoService.pageDataSource(menuNo);
		} catch (Exception e) {
			logger.error("获取数据报告--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
	}
}
