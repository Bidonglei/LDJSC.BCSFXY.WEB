package com.sunmnet.bigdata.web.controller.asset;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.web.model.request.personnel.ForeignInvestmentREQ;
import com.sunmnet.bigdata.web.model.request.personnel.TeacherBoxREQ;
import com.sunmnet.bigdata.web.service.asset.OperationalAssetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/operationalAsset")
@Api(tags = "资产：经营性资产")
public class OperationalAssetController extends BaseController {
	@Autowired
	private OperationalAssetService operationalAssetService;

	@ApiOperation(value = "对外投资：投资公司列表")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "pageNum", dataType = "int", required = true, value = "pageNum", defaultValue = "1"),
			@ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", required = true, value = "pageSize", defaultValue = "10")
	})
	@GetMapping(value = "/pageForeignInvestment")
	@LoggerManage("对外投资：投资公司列表")
	public JsonResult pageForeignInvestment(ForeignInvestmentREQ foreignInvestmentREQ, int pageNum, int pageSize){
		return buildSuccJson(operationalAssetService.pageForeignInvestment(foreignInvestmentREQ,pageNum,pageSize));
	}

	@ApiOperation(value = "股权结构:通过工商注册号获取详细信息")
	@GetMapping(value = "/ownershipStructure")
	@LoggerManage("股权结构:通过工商注册号获取详细信息")
	public JsonResult ownershipStructure(String registrationNum) {
		return buildSuccJson(operationalAssetService.ownershipStructure(registrationNum));
	}

	@ApiOperation(value = "股权结构:对外经营性公司结构")
	@GetMapping(value = "/listCompanyStructure")
	@LoggerManage("股权结构:对外经营性公司结构")
	public JsonResult listCompanyStructure(){
		return buildSuccJson(operationalAssetService.listCompanyStructure());
	}
}
