package com.sunmnet.bigdata.web.controller.teaching;

import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.web.model.request.teaching.TeachingAchievementREQ;
import com.sunmnet.bigdata.web.service.teaching.TeachingAchievementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachingAchievement")
@Api(tags = "教学-教学成果")
public class TeachingAchievementController extends BaseController {

    @Autowired
    private TeachingAchievementService teachingAchievementService;

    @ApiOperation(value = "教材建设:规划教材")
    @GetMapping(value = "/getPlanningTextbook")
    @LoggerManage("教材建设:规划教材")
    public JsonResult getPlanningTextbook() {
        return buildSuccJson(teachingAchievementService.getPlanningTextbook());
    }

    @ApiOperation(value = "教材建设:历年规划教材情况")
    @GetMapping(value = "/listPlanningTextbookByAnnual")
    @LoggerManage("教材建设:历年规划教材情况")
    public JsonResult listPlanningTextbookByAnnual() {
        return buildSuccJson(teachingAchievementService.listPlanningTextbookByAnnual());
    }

    @ApiOperation(value = "教材建设:教材选优情况")
    @GetMapping(value = "/getExcellentTeachingMaterial")
    @LoggerManage("教材建设:教材选优情况")
    public JsonResult getExcellentTeachingMaterial() {
        return buildSuccJson(teachingAchievementService.getExcellentTeachingMaterial());
    }

    @ApiOperation(value = "教材建设:教材选新情况")
    @GetMapping(value = "/getTextbooksSelection")
    @LoggerManage("教材建设:教材选新情况")
    public JsonResult getTextbooksSelection() {
        return buildSuccJson(teachingAchievementService.getTextbooksSelection());
    }

    @ApiOperation(value = "教材建设:优秀教材")
    @GetMapping(value = "/listExcellentTeachingMaterial")
    @LoggerManage("教材建设:优秀教材")
    public JsonResult listExcellentTeachingMaterial() {
        return buildSuccJson(teachingAchievementService.listExcellentTeachingMaterial());
    }

    @ApiOperation(value = "教材建设:专著情况")
    @GetMapping(value = "/listAchievementsMonographs")
    @LoggerManage("教材建设:专著情况")
    public JsonResult listAchievementsMonographs() {
        return buildSuccJson(teachingAchievementService.listAchievementsMonographs());
    }

    @ApiOperation(value = "本科生教改:教育教学研究与改革项目数量分析")
    @GetMapping(value = "/getReformProjectNumber")
    @LoggerManage("本科生教改:教育教学研究与改革项目数量分析")
    public JsonResult getReformProjectNumber() {
        return buildSuccJson(teachingAchievementService.getReformProjectNumber());
    }

    @ApiOperation(value = "本科生教改:教育教学研究与改革项目经费分析")
    @GetMapping(value = "/getReformProjectAmount")
    @LoggerManage("本科生教改:教育教学研究与改革项目经费分析")
    public JsonResult getReformProjectAmount() {
        return buildSuccJson(teachingAchievementService.getReformProjectAmount());
    }

    @ApiOperation(value = "本科生教改:各学院教改情况")
    @GetMapping(value = "/listReformProjectAnnual")
    @LoggerManage("本科生教改:各学院教改情况")
    public JsonResult listReformProjectAnnual(TeachingAchievementREQ req) {
        return buildSuccJson(teachingAchievementService.listReformProjectAnnual(req));
    }

    @ApiOperation(value = "研究生教改:校级学位与研究生教育研究基金等教改项目-数量")
    @GetMapping(value = "/getEducationalProjectNumber")
    @LoggerManage("研究生教改:校级学位与研究生教育研究基金等教改项目-数量")
    public JsonResult getEducationalProjectNumber() {
        return buildSuccJson(teachingAchievementService.getEducationalProjectNumber());
    }

    @ApiOperation(value = "研究生教改:校级学位与研究生教育研究基金等教改项目-金额")
    @GetMapping(value = "/getEducationalProjectAmount")
    @LoggerManage("研究生教改:校级学位与研究生教育研究基金等教改项目-金额")
    public JsonResult getEducationalProjectAmount() {
        return buildSuccJson(teachingAchievementService.getEducationalProjectAmount());
    }

    @ApiOperation(value = "研究生教改:各学院教改情况")
    @GetMapping(value = "/listEducationalProjectAnnual")
    @LoggerManage("研究生教改:各学院教改情况")
    public JsonResult listEducationalProjectAnnual(TeachingAchievementREQ req) {
        return buildSuccJson(teachingAchievementService.listEducationalProjectAnnual(req));
    }

    @ApiOperation(value = "教学成果奖:获奖累计值统计")
    @GetMapping(value = "/getTeachingAchievementAward")
    @LoggerManage("教学成果奖:获奖累计值统计")
    public JsonResult getTeachingAchievementAward(TeachingAchievementREQ req) {
        return buildSuccJson(teachingAchievementService.getTeachingAchievementAward(req));
    }

    @ApiOperation(value = "教学成果奖:各学院获奖分布")
    @GetMapping(value = "/listTeachingAchievementAward")
    @LoggerManage("教学成果奖:各学院获奖分布")
    public JsonResult listTeachingAchievementAward(TeachingAchievementREQ req) {
        return buildSuccJson(teachingAchievementService.listTeachingAchievementAward(req));
    }

    @ApiOperation(value = "研究生创新:研究生创新教育")
    @GetMapping(value = "/listPostgraduateInnovationYear")
    @LoggerManage("研究生创新:研究生创新教育")
    public JsonResult listPostgraduateInnovationYear() {
        return buildSuccJson(teachingAchievementService.listPostgraduateInnovationYear());
    }

    @ApiOperation(value = "研究生创新:各学院研究生创新教育")
    @GetMapping(value = "/listPostgraduateInnovationAcademy")
    @LoggerManage("研究生创新:各学院研究生创新教育")
    public JsonResult listPostgraduateInnovationAcademy() {
        return buildSuccJson(teachingAchievementService.listPostgraduateInnovationAcademy());
    }

}
