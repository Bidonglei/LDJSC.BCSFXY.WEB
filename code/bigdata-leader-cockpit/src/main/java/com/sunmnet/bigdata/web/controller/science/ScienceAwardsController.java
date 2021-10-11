package com.sunmnet.bigdata.web.controller.science;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.web.model.request.science.NurturingPlanREQ;
import com.sunmnet.bigdata.web.model.request.science.ScienceAwardsREQ;
import com.sunmnet.bigdata.web.service.science.ScienceAwardsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/scienceAwards")
@Api(tags = "科研-成果绩效-获奖")
public class ScienceAwardsController extends BaseController {

    @Autowired
    private ScienceAwardsService scienceAwardsService;

    @ApiOperation(value = "各学院国家奖任务指标及完成数量")
    @GetMapping(value = "/listIndicatorsCompleted")
    @LoggerManage("各学院国家奖任务指标及完成数量")
    public JsonResult listIndicatorsCompleted(ScienceAwardsREQ req) {
        return buildSuccJson(scienceAwardsService.listIndicatorsCompleted(req));
    }

    @ApiOperation(value = "国家级奖项高校对比/列表")
    @GetMapping(value = "/listUniversityNationalAwards")
    @LoggerManage("国家级奖项高校对比/列表")
    public JsonResult listUniversityNationalAwards(ScienceAwardsREQ req) {
        return buildSuccJson(scienceAwardsService.listUniversityNationalAwards(req));
    }

    @ApiOperation(value = "国家奖-历史获奖")
    @GetMapping(value = "/listHistoryNationalAward")
    @LoggerManage("国家奖-历史获奖")
    public JsonResult listHistoryNationalAward() {
        return buildSuccJson(scienceAwardsService.listHistoryNationalAward());
    }

    @ApiOperation(value = "国家奖-历史获奖-柱图")
    @GetMapping(value = "/listHistoryNationalByYear")
    @LoggerManage("国家奖-历史获奖-柱图")
    public JsonResult listHistoryNationalByYear() {
        return buildSuccJson(scienceAwardsService.listHistoryNationalByYear());
    }

    @ApiOperation(value = "国家奖列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", dataType = "int", required = true, value = "pageNum", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", required = true, value = "pageSize", defaultValue = "10")
    })
    @GetMapping(value = "/listNationalAwardInfo")
    @LoggerManage("国家奖列表")
    public JsonResult listNationalAwardInfo(@ModelAttribute ScienceAwardsREQ req, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        final List<Map<String,Object>> list = scienceAwardsService.listNationalAwardInfo(req);
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(list);
        return buildSuccJson(pageInfo);
    }

    @ApiOperation(value = "省部级奖及社会奖-总体情况")
    @GetMapping(value = "/listProvincialAwardInfo")
    @LoggerManage("省部级奖及社会奖-总体情况")
    public JsonResult listProvincialAwardInfo(ScienceAwardsREQ req) {
        return buildSuccJson(scienceAwardsService.listProvincialAwardInfo(req));
    }

    @ApiOperation(value = "省部级奖及社会奖-总体情况(一等奖)")
    @GetMapping(value = "/listProvincialAwardOne")
    @LoggerManage("省部级奖及社会奖-总体情况(一等奖)")
    public JsonResult listProvincialAwardOne(ScienceAwardsREQ req) {
        return buildSuccJson(scienceAwardsService.listProvincialAwardOne(req));
    }

    @ApiOperation(value = "省部级奖及社会奖-历史获奖")
    @GetMapping(value = "/listHistoryProvincialAward")
    @LoggerManage("省部级奖及社会奖-历史获奖")
    public JsonResult listHistoryProvincialAward() {
        return buildSuccJson(scienceAwardsService.listHistoryProvincialAward());
    }

    @ApiOperation(value = "省部级奖及社会奖-学院获奖分布")
    @GetMapping(value = "/listProvincialAwardByAcademy")
    @LoggerManage("省部级奖及社会奖-学院获奖分布")
    public JsonResult listProvincialAwardByAcademy(ScienceAwardsREQ req) {
        return buildSuccJson(scienceAwardsService.listProvincialAwardByAcademy(req));
    }

    @ApiOperation(value = "近五年成果转化趋势")
    @GetMapping(value = "/listAchievementsConversionByYear")
    @LoggerManage("近五年成果转化趋势")
    public JsonResult listAchievementsConversionByYear() {
        return buildSuccJson(scienceAwardsService.listAchievementsConversionByYear());
    }

    @ApiOperation(value = "成果转化分布")
    @GetMapping(value = "/listAchiConversionBydepart")
    @LoggerManage("成果转化分布")
    public JsonResult listAchiConversionBydepart(ScienceAwardsREQ req) {
        return buildSuccJson(scienceAwardsService.listAchiConversionBydepart(req));
    }

    @ApiOperation(value = "国家奖培育情况：各学院培育项目当年完成度")
    @GetMapping(value = "/listAcademyComplete")
    @LoggerManage("国家奖培育情况：各学院培育项目当年完成度")
    public JsonResult listAcademyComplete(){
        return buildSuccJson(scienceAwardsService.listAcademyComplete());
    }

    @ApiOperation(value = "国家奖培育情况：当年各项目培育完成度")
    @GetMapping(value = "/listChargeComplete")
    @LoggerManage("国家奖培育情况：当年各项目培育完成度")
    public JsonResult listChargeComplete(String departmentName){
        return buildSuccJson(scienceAwardsService.listChargeComplete(departmentName));
    }

    @ApiOperation(value = "国家奖五年培育计划及完成情况")
    @GetMapping(value = "/listNurturingPlanAndDeclare")
    @LoggerManage("国家奖五年培育计划及完成情况")
    public JsonResult listNurturingPlanAndDeclare(){
        return buildSuccJson(scienceAwardsService.listNurturingPlanAndDeclare());
    }

    @ApiOperation(value = "国家奖五年培育计划及完成情况清单")
    @GetMapping(value = "/listNurturingPlanCompletion")
    @LoggerManage("国家奖五年培育计划及完成情况清单")
    public JsonResult listNurturingPlanCompletion(@Validated NurturingPlanREQ req,BindingResult bindingResult){
        return buildSuccJson(scienceAwardsService.listNurturingPlanCompletion(req));
    }

    @ApiOperation(value = "国家奖各学院五年规划情况")
    @GetMapping(value = "/listFiveYearNurturingPlan")
    @LoggerManage("国家奖各学院五年规划情况")
    public JsonResult listFiveYearNurturingPlan(){
        return buildSuccJson(scienceAwardsService.listFiveYearNurturingPlan());
    }

}
