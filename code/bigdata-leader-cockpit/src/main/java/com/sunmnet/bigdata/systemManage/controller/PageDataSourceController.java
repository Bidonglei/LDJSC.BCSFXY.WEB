package com.sunmnet.bigdata.systemManage.controller;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddIndexInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.IndexInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.UpdateDataSourceRequest;
import com.sunmnet.bigdata.systemManage.common.exception.SystemManageException;
import com.sunmnet.bigdata.systemManage.common.log.LoggerManage;
import com.sunmnet.bigdata.systemManage.service.IndexInfoService;
import com.sunmnet.bigdata.systemManage.service.PageDataSourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *功能描述 数据报告
 * @author lkg
 * @date 2019/8/29
 */
@Api(tags="数据报告")
@RestController
@RequestMapping("/dataSource")
public class PageDataSourceController extends BaseController{
	
	@Autowired
	private PageDataSourceService pageDataSourceService;

	/**
	 *功能描述 获取数据报告
	 * @author lkg
	 * @date 2019/8/29
	 */
	@ApiOperation(value = "获取数据报告")
	@SuppressWarnings("unchecked")
	@RequestMapping("/listDataSourceByPageCode")
	@LoggerManage(description = "获取数据报告")
	public BaseResponseInfo<Object> listDataSourceByPageCode(String pageCode) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = pageDataSourceService.listDataSourceByPageCode(pageCode);
		} catch (Exception e) {
			logger.error("获取数据报告--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
	}

	/**
	 *功能描述 修改数据报告
	 * @author lkg
	 * @date 2019/8/29
	 */
	@ApiOperation(value = "修改数据报告")
	@SuppressWarnings("unchecked")
	@RequestMapping("/updateDataSource")
	@LoggerManage(description = "修改数据报告")
	public BaseResponseInfo<Object> updateDataSource(@Validated UpdateDataSourceRequest updateDataSourceRequest,BindingResult bindingResult) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = pageDataSourceService.updateDataSource(updateDataSourceRequest);
		} catch (Exception e) {
			logger.error("修改数据报告--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
	}

	/**
	 *功能描述 删除数据报告
	 * @author lkg
	 * @date 2019/8/29
	 */
	@ApiOperation(value = "删除数据报告")
	@SuppressWarnings("unchecked")
	@RequestMapping("/deleteDataSource")
	@LoggerManage(description = "删除数据报告")
	public BaseResponseInfo<Object> deleteDataSource(Long id) {
		BaseResponseInfo<Object> responseInfo = new BaseResponseInfo<Object>();
		try {
			responseInfo = pageDataSourceService.deleteDataSource(id);
		} catch (Exception e) {
			logger.error("删除数据报告--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
	}

}
