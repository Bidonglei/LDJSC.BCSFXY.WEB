package com.sunmnet.bigdata.web.controller.science;

import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.web.model.request.science.*;
import com.sunmnet.bigdata.web.service.science.ScienceInfoService;
import com.sunmnet.bigdata.web.service.science.ScienceResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/scienceResource")
@Api(tags="科研-科研资源")
public class ScienceResourceController extends BaseController
{

    @Autowired
    private ScienceResourceService scienceResourceService;

	@ApiOperation(value = "国家级科研专家：科研专家分页")
	@GetMapping(value = "/researchExpertPage")
	@LoggerManage("国家级科研专家：科研专家分页")
	public JsonResult researchExpertPage(@Validated ResearchExpertPageREQ researchExpertPageREQ,
			BindingResult bindingResult){
		return buildSuccJson(scienceResourceService.researchExpertPage(researchExpertPageREQ));
	}

	@ApiOperation(value = "科研项目人员：科研职称分布")
	@GetMapping(value = "/researchTitleDis")
	@LoggerManage("科研项目人员：科研职称分布")
	public JsonResult researchTitleDis(){
		return buildSuccJson(scienceResourceService.researchTitleDis());
	}

	@ApiOperation(value = "科研项目人员：科研学历分布")
	@GetMapping(value = "/researchEducationDis")
	@LoggerManage("科研项目人员：科研学历分布")
	public JsonResult researchEducationDis(){
		return buildSuccJson(scienceResourceService.researchEducationDis());
	}

	@ApiOperation(value = "科研项目人员：科研项目人员页")
	@GetMapping(value = "/projectPersonPage")
	@LoggerManage("科研项目人员：科研项目人员分页")
	public JsonResult projectPersonPage(@Validated ProjectPersonPageREQ projectPersonPageREQ,
			BindingResult bindingResult){
		return buildSuccJson(scienceResourceService.projectPersonPage(projectPersonPageREQ));
	}

	@ApiOperation(value = "科研团队：科研团队分页")
	@GetMapping(value = "/scienceTeamPage")
	@LoggerManage("科研团队：科研团队分页")
	public JsonResult scienceTeamPage(@Validated ScienceTeamPageREQ scienceTeamPageREQ,
			BindingResult bindingResult){
		return buildSuccJson(scienceResourceService.scienceTeamPage(scienceTeamPageREQ));
	}

	@ApiOperation(value = "科研团队：每个团队详情")
	@GetMapping(value = "/getTeamDetails")
	@LoggerManage("科研团队：每个团队详情")
	public JsonResult getTeamDetails(String teamNo){
		return buildSuccJson(scienceResourceService.getTeamDetails(teamNo));
	}


	@ApiOperation(value = "科研平台：各科研单位科研平台数量")
	@GetMapping(value = "/companyPlatformAmount")
	@LoggerManage("科研平台：各科研单位科研平台数量")
	public JsonResult companyPlatformAmount(){
		return buildSuccJson(scienceResourceService.companyPlatformAmount());
	}

	@ApiOperation(value = "科研平台：各学科科研平台数量")
	@GetMapping(value = "/subjectPlatformAmount")
	@LoggerManage("科研平台：各学科科研平台数量")
	public JsonResult subjectPlatformAmount(){
		return buildSuccJson(scienceResourceService.subjectPlatformAmount());
	}

	@ApiOperation(value = "科研平台：各单位科研平台分页")
	@GetMapping(value = "/sciencePlatformInfo")
	@LoggerManage("科研平台：各单位科研平台分页")
	public JsonResult sciencePlatformInfo(@Validated SciencePlatformPageREQ sciencePlatformPageREQ,
			BindingResult bindingResult){
		return buildSuccJson(scienceResourceService.sciencePlatformInfo(sciencePlatformPageREQ));
	}

	@ApiOperation(value = "国合基地：国合基地分页")
	@GetMapping(value = "/internationalCooBase")
	@LoggerManage("国合基地：国合基地分页")
	public JsonResult internationalCooBase(@Validated InternationalCooBasePageREQ internationalCooBasePageREQ,
			BindingResult bindingResult){
		return buildSuccJson(scienceResourceService.internationalCooBase(internationalCooBasePageREQ));
	}

	@ApiOperation(value = "科研仪器设备共享：科研仪器设备共享机时")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "annual", dataType = "string", required = true, value = "年度", defaultValue = "2018")
	})
	@GetMapping(value = "/equipmentShareTime")
	@LoggerManage("科研仪器设备共享：科研仪器设备共享机时")
	public JsonResult equipmentShareTime(String annual){
		return buildSuccJson(scienceResourceService.equipmentShareTime(annual));
	}

	@ApiOperation(value = "科研仪器设备共享：科研仪器设备共享收益")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "annual", dataType = "string", required = true, value = "年度", defaultValue = "2018")
	})
	@GetMapping(value = "/equipmentShareIncome")
	@LoggerManage("科研仪器设备共享：科研仪器设备共享收益")
	public JsonResult equipmentShareIncome(String annual){
		return buildSuccJson(scienceResourceService.equipmentShareIncome(annual));
	}

	@ApiOperation(value = "科研仪器设备共享：科研仪器共享中心分页")
	@GetMapping(value = "/equipmentShareCenterPage")
	@LoggerManage("科研仪器设备共享：科研仪器共享中心分页")
	public JsonResult equipmentShareCenterPage(@Validated EquipmentShareCenterPageREQ equipmentShareCenterPageREQ,
			BindingResult bindingResult){
		return buildSuccJson(scienceResourceService.equipmentShareCenterPage(equipmentShareCenterPageREQ));
	}
}
