package com.sunmnet.bigdata.web.controller.personnel;

import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.web.service.personnel.HighLevelTalentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/highLevelTalent")
@Api(tags="高层次人才")
public class HighLevelTalentController extends BaseController
{
    @Autowired
    private HighLevelTalentService highLevelTalentService;


	@ApiOperation(value = "人才分布：高层次人才单位分布")
	@GetMapping(value = "/talentCollegeDistribute")
	@LoggerManage("人才分布：高层次人才单位分布")
	public JsonResult talentCollegeDistribute(){
		return buildSuccJson(highLevelTalentService.talentCollegeDistribute());
	}

	@ApiOperation(value = "人才分布：高层次人才学科分布")
	@GetMapping(value = "/talentSubjectDistribute")
	@LoggerManage("人才分布：高层次人才学科分布")
	public JsonResult talentSubjectDistribute(){
		return buildSuccJson(highLevelTalentService.talentSubjectDistribute());
	}

	@ApiOperation(value = "引进分析：人才引进源（学院）")
	@GetMapping(value = "/introduceAcademicStr")
	@LoggerManage("引进分析：人才引进源（学院）")
	public JsonResult introduceAcademicStr(){
		return buildSuccJson(highLevelTalentService.introduceAcademicStr());
	}

	@ApiOperation(value = "引进分析：人才引进源（学科）")
	@GetMapping(value = "/introduceSubjectStr")
	@LoggerManage("引进分析：人才引进源（学科）")
	public JsonResult introduceSubjectStr(){
		return buildSuccJson(highLevelTalentService.introduceSubjectStr());
	}

	@ApiOperation(value = "引进分析：学院历年引进人才分析")
	@GetMapping(value = "/listIntroduceTalent")
	@LoggerManage("引进分析：学院历年引进人才分析")
	public JsonResult listIntroduceTalent(){
		return buildSuccJson(highLevelTalentService.listIntroduceTalent());
	}

}
