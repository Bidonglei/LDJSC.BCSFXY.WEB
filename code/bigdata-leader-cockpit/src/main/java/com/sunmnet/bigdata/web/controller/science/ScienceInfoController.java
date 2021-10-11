package com.sunmnet.bigdata.web.controller.science;

import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.web.model.request.science.ProjectDetailPageREQ;
import com.sunmnet.bigdata.web.model.request.science.ScienceProjectInfoPageREQ;
import com.sunmnet.bigdata.web.model.request.science.UniversityAmountPageREQ;
import com.sunmnet.bigdata.web.service.science.ScienceInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/scienceProject")
@Api(tags="科研-科研项目")
public class ScienceInfoController extends BaseController
{

    @Autowired
    private ScienceInfoService scienceInfoService;

    @ApiOperation(value = "科研项目分布：查询纵向科研项目分布")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "year", dataType = "string", required = true, value = "year", defaultValue = "2017")
    })
    @PostMapping(value = "/listScienceProByYear")
    @LoggerManage("科研项目分布：查询纵向科研项目分布")
    public JsonResult listScienceProByYear(String year){
    	return buildSuccJson(scienceInfoService.listScienceProByYear(year));
    }

	@ApiOperation(value = "项目概况：科研项目分布")
	@GetMapping(value = "/scienceProjectDis")
	@LoggerManage("项目概况：科研项目分布")
	public JsonResult scienceProjectDis(){
		return buildSuccJson(scienceInfoService.scienceProjectDis());
	}

	@ApiOperation(value = "项目概况：科研项目分页")
	@GetMapping(value = "/scienceProjectPage")
	@LoggerManage("项目概况：科研项目分页")
	public JsonResult scienceProjectPage(@Validated ScienceProjectInfoPageREQ scienceProjectInfoPageREQ,
			BindingResult bindingResult){
		return buildSuccJson(scienceInfoService.scienceProjectPage(scienceProjectInfoPageREQ));
	}
	@ApiOperation(value = "项目概况：总经费/纵向/横向经费排行榜")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "annual", dataType = "string", required = true, value = "年度", defaultValue = "2018"),
			@ApiImplicitParam(paramType = "query", name = "projectType", dataType = "string", required = false, value = "项目类型", defaultValue = "纵向")
	})
	@GetMapping(value = "/companyAmountRank")
	@LoggerManage("项目概况：总经费/纵向/横向经费排行榜")
	public JsonResult companyAmountRank(String projectType,String annual){
		return buildSuccJson(scienceInfoService.companyAmountRank(projectType,annual));
	}

	@ApiOperation(value = "项目概况：本年新增/纵向经费排行榜")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "annual", dataType = "string", required = true, value = "年度", defaultValue = "2018"),
			@ApiImplicitParam(paramType = "query", name = "projectType", dataType = "string", required = false, value = "项目类型", defaultValue = "纵向")
	})
	@GetMapping(value = "/latestAmountRank")
	@LoggerManage("项目概况：本年新增/纵向经费排行榜")
	public JsonResult latestAmountRank(String projectType,String annual){
		return buildSuccJson(scienceInfoService.latestAmountRank(projectType,annual));
	}

	@ApiOperation(value = "项目概况：师均科研经费表")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "annual", dataType = "string", required = true, value = "年度", defaultValue = "2018")
	})
	@GetMapping(value = "/scientificTeacherAvg")
	@LoggerManage("项目概况：师均科研经费表")
	public JsonResult scientificTeacherAvg(String annual){
		return buildSuccJson(scienceInfoService.scientificTeacherAvg(annual));
	}

	@ApiOperation(value = "科研经费：全校近年科研经费")
	@GetMapping(value = "/threeYearAmount")
	@LoggerManage("科研经费：全校近年科研经费")
	public JsonResult threeYearAmount(){
		return buildSuccJson(scienceInfoService.threeYearAmount());
	}

	@ApiOperation(value = "科研经费：各单位科研经费")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "annual", dataType = "string", required = true, value = "年度", defaultValue = "2018")
	})
	@GetMapping(value = "/projectTypeRank")
	@LoggerManage("科研经费：各单位科研经费")
	public JsonResult projectTypeRank(String annual){
		return buildSuccJson(scienceInfoService.projectTypeRank(annual));
	}

	@ApiOperation(value = "项目研究类别：项目研究类别")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "annual", dataType = "string", required = true, value = "年度", defaultValue = "2018")
	})
	@GetMapping(value = "/researchCategoryDist")
	@LoggerManage("项目研究类别：项目研究类别")
	public JsonResult researchCategoryDist(String annual){
		return buildSuccJson(scienceInfoService.researchCategoryDist(annual));
	}

	@ApiOperation(value = "项目进度：各单位资金执行率滞后项目数量")
	@GetMapping(value = "/projectDelayDist")
	@LoggerManage("项目进度：各单位资金执行率滞后项目数量")
	public JsonResult projectDelayDist(){
		return buildSuccJson(scienceInfoService.projectDelayDist());
	}

	@ApiOperation(value = "高校对比：科研项目金额对比")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "annual", dataType = "string", required = true, value = "年度", defaultValue = "2019")
	})
	@GetMapping(value = "/universityAmount")
	@LoggerManage("高校对比：科研项目金额对比")
	public JsonResult universityAmount(String annual){
		return buildSuccJson(scienceInfoService.universityAmount(annual));
	}

	@ApiOperation(value = "高校对比：高校经费分页")
	@GetMapping(value = "/universityAmountPage")
	@LoggerManage("高校对比：高校经费分页")
	public JsonResult universityAmountPage(@Validated UniversityAmountPageREQ universityAmountPageREQ,
			BindingResult bindingResult){
		return buildSuccJson(scienceInfoService.universityAmountPage(universityAmountPageREQ));
	}

	@ApiOperation(value = "纵向项目来源：纵向项目来源")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "annual", dataType = "string", required = true, value = "年度", defaultValue = "2018"),
			@ApiImplicitParam(paramType = "query", name = "source", dataType = "string", required = true, value = "来源", defaultValue = "QD")
	})
	@GetMapping(value = "/verticalProSource")
	@LoggerManage("纵向项目来源：纵向项目来源")
	public JsonResult verticalProSource(String annual,String source){
		return buildSuccJson(scienceInfoService.verticalProSource(annual,source));
	}

	@ApiOperation(value = "纵向项目类型排行：纵向项目类型排行")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "annual", dataType = "string", required = true, value = "年度", defaultValue = "2018")
	})
	@GetMapping(value = "/verticalProChannel")
	@LoggerManage("纵向项目类型排行：纵向项目类型排行")
	public JsonResult verticalProChannel(String annual){
		return buildSuccJson(scienceInfoService.verticalProChannel(annual));
	}

	@ApiOperation(value = "项目类别：纵向/横向项目")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "annual", dataType = "string", required = true, value = "年度", defaultValue = "2018"),
			@ApiImplicitParam(paramType = "query", name = "projectType", dataType = "string", required = false, value = "项目类型", defaultValue = "纵向")
	})
	@GetMapping(value = "/secondTypeStatistics")
	@LoggerManage("项目类别：纵向/横向项目")
	public JsonResult secondTypeStatistics(String projectType,String annual){
		return buildSuccJson(scienceInfoService.secondTypeStatistics(projectType,annual));
	}

	@ApiOperation(value = "千万级项目：项目详情分页")
	@GetMapping(value = "/projectDetailPage")
	@LoggerManage("千万级项目：项目详情分页")
	public JsonResult projectDetailPage(@Validated ProjectDetailPageREQ projectDetailPageREQ,
			BindingResult bindingResult){
		return buildSuccJson(scienceInfoService.projectDetailPage(projectDetailPageREQ));
	}

	@ApiOperation(value = "千万级项目：千万级项目图表")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "status", dataType = "string", required = false, value = "状态", defaultValue = "在研"),
			@ApiImplicitParam(paramType = "query", name = "amount", dataType = "string", required = true, value = "金额", defaultValue = "500"),
			@ApiImplicitParam(paramType = "query", name = "projectType", dataType = "string", required = false, value = "项目类型", defaultValue = "纵向")
	})
	@GetMapping(value = "/bigProjectDis")
	@LoggerManage("千万级项目：千万级项目图表")
	public JsonResult bigProjectDis(String projectType,String amount,String status){
		return buildSuccJson(scienceInfoService.bigProjectDis(projectType,amount,status));
	}
}
