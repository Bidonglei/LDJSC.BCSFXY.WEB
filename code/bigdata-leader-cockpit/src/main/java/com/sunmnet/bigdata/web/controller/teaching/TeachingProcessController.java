package com.sunmnet.bigdata.web.controller.teaching;

import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.common.request.BasePageRequest;
import com.sunmnet.bigdata.web.model.request.teaching.DoctorMoreThanYearsREQ;
import com.sunmnet.bigdata.web.model.request.teaching.TeachingProcessREQ;
import com.sunmnet.bigdata.web.service.teaching.TeachingProcessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachingProcess")
@Api(tags = "教学-教学过程")
public class TeachingProcessController extends BaseController {

    @Autowired
    private TeachingProcessService teachingProcessService;

    @ApiOperation(value = "教授授课率:教授授课情况")
    @GetMapping(value = "/listProfessorTeachingSituation")
    @LoggerManage("教授授课率:教授授课情况")
    public JsonResult listProfessorTeachingSituation(TeachingProcessREQ req) {
        return buildSuccJson(teachingProcessService.listProfessorTeachingSituation(req));
    }

    @ApiOperation(value = "教授授课率:教授授课学时情况")
    @GetMapping(value = "/listProfessorTeachingHours")
    @LoggerManage("教授授课率:教授授课学时情况")
    public JsonResult listProfessorTeachingHours(TeachingProcessREQ req) {
        return buildSuccJson(teachingProcessService.listProfessorTeachingHours(req));
    }

    @ApiOperation(value = "学业进度:本科生学业进度情况")
    @GetMapping(value = "/listUndergraduatesProgressCredit")
    @LoggerManage("学业进度:本科生学业进度情况")
    public JsonResult listUndergraduatesProgressCredit(TeachingProcessREQ req) {
        return buildSuccJson(teachingProcessService.listUndergraduatesProgressCredit(req));
    }

    @ApiOperation(value = "学业进度:本科生学业进度情况-扇形图")
    @GetMapping(value = "/listUndergraduatesProgress")
    @LoggerManage("学业进度:本科生学业进度情况-扇形图")
    public JsonResult listUndergraduatesProgress(TeachingProcessREQ req) {
        return buildSuccJson(teachingProcessService.listUndergraduatesProgress(req));
    }

    @ApiOperation(value = "学业进度:硕士生学业进度情况")
    @GetMapping(value = "/listMasterProgressCredit")
    @LoggerManage("学业进度:硕士生学业进度情况")
    public JsonResult listMasterProgressCredit(TeachingProcessREQ req) {
        return buildSuccJson(teachingProcessService.listMasterProgressCredit(req));
    }

    @ApiOperation(value = "学业进度:硕士生学业进度情况-扇形图")
    @GetMapping(value = "/listMasterProgress")
    @LoggerManage("学业进度:硕士生学业进度情况-扇形图")
    public JsonResult listMasterProgress(TeachingProcessREQ req) {
        return buildSuccJson(teachingProcessService.listMasterProgress(req));
    }

    @ApiOperation(value = "学习年限:本科生学习年限情况")
    @GetMapping(value = "/getUndergraduateSchoolingYears")
    @LoggerManage("学习年限:本科生学习年限情况")
    public JsonResult getUndergraduateSchoolingYears() {
        return buildSuccJson(teachingProcessService.getUndergraduateSchoolingYears());
    }

    @ApiOperation(value = "学习年限:硕士生学习年限情况")
    @GetMapping(value = "/getMasterSchoolingYears")
    @LoggerManage("学习年限:硕士生学习年限情况")
    public JsonResult getMasterSchoolingYears() {
        return buildSuccJson(teachingProcessService.getMasterSchoolingYears());
    }

    @ApiOperation(value = "学习年限:博士生学习年限情况")
    @GetMapping(value = "/getDoctorSchoolingYears")
    @LoggerManage("学习年限:博士生学习年限情况")
    public JsonResult getDoctorSchoolingYears() {
        return buildSuccJson(teachingProcessService.getDoctorSchoolingYears());
    }

    @ApiOperation(value = "学习年限:本科生学习年限超过4年人数")
    @GetMapping(value = "/listUndergraduateThanFourYears")
    @LoggerManage("学习年限:本科生学习年限超过4年人数")
    public JsonResult listUndergraduateThanFourYears() {
        return buildSuccJson(teachingProcessService.listUndergraduateThanFourYears());
    }

    @ApiOperation(value = "学习年限:硕士生学习年限延期/超期情况")
    @GetMapping(value = "/listMasterMoreThanYears")
    @LoggerManage("学习年限:硕士生学习年限延期/超期情况")
    public JsonResult listMasterMoreThanYears() {
        return buildSuccJson(teachingProcessService.listMasterMoreThanYears());
    }

    @ApiOperation(value = "学习年限:博士生学习年限延期/超期情况")
    @GetMapping(value = "/listDoctorMoreThanYears")
    @LoggerManage("学习年限:博士生学习年限延期/超期情况")
    public JsonResult listDoctorMoreThanYears() {
        return buildSuccJson(teachingProcessService.listDoctorMoreThanYears());
    }

    @ApiOperation(value = "学习年限:博士延期/超期详细信息")
    @GetMapping(value = "/listDoctorMoreThanYearsDetail")
    @LoggerManage("学习年限:博士延期/超期详细信息")
    public JsonResult listDoctorMoreThanYearsDetail(@Validated DoctorMoreThanYearsREQ req, BindingResult bindingResult) {
        return buildSuccJson(teachingProcessService.listDoctorMoreThanYearsDetail(req));
    }

    @ApiOperation(value = "学习年限:本科生各年级学生毕业率")
    @GetMapping(value = "/listUndergraduateRatioByGrade")
    @LoggerManage("学习年限:本科生各年级学生毕业率")
    public JsonResult listUndergraduateRatioByGrade() {
        return buildSuccJson(teachingProcessService.listUndergraduateRatioByGrade());
    }

    @ApiOperation(value = "学习年限:各学院毕业情况")
    @GetMapping(value = "/listUndergraduateRatioByAcademy")
    @LoggerManage("学习年限:各学院毕业情况")
    public JsonResult listUndergraduateRatioByAcademy(TeachingProcessREQ req) {
        return buildSuccJson(teachingProcessService.listUndergraduateRatioByAcademy(req));
    }

    @ApiOperation(value = "学习年限:博士毕业占比情况")
    @GetMapping(value = "/listDoctorRatioByAcademy")
    @LoggerManage("学习年限:博士毕业占比情况")
    public JsonResult listDoctorRatioByAcademy(TeachingProcessREQ req) {
        return buildSuccJson(teachingProcessService.listDoctorRatioByAcademy(req));
    }

    @ApiOperation(value = "选课情况:课程贡献率")
    @GetMapping(value = "/listCourseContribution")
    @LoggerManage("选课情况:课程贡献率")
    public JsonResult listCourseContribution(TeachingProcessREQ req) {
        return buildSuccJson(teachingProcessService.listCourseContribution(req));
    }

    @ApiOperation(value = "选课情况:课程开放度")
    @GetMapping(value = "/listCourseOpenness")
    @LoggerManage("选课情况:课程开放度")
    public JsonResult listCourseOpenness(TeachingProcessREQ req) {
        return buildSuccJson(teachingProcessService.listCourseOpenness(req));
    }

    @ApiOperation(value = "本科实践教学:国家级大学生创新创业训练计划项目")
    @GetMapping(value = "/listInnovativeTrainingProgram")
    @LoggerManage("本科实践教学:国家级大学生创新创业训练计划项目")
    public JsonResult listInnovativeTrainingProgram(TeachingProcessREQ req) {
        return buildSuccJson(teachingProcessService.listInnovativeTrainingProgram(req));
    }

    @ApiOperation(value = "本科实践教学:大创项目扇形图")
    @GetMapping(value = "/listInnovativeTrainingProgramSector")
    @LoggerManage("本科实践教学:大创项目扇形图")
    public JsonResult listInnovativeTrainingProgramSector(TeachingProcessREQ req) {
        return buildSuccJson(teachingProcessService.listInnovativeTrainingProgramSector(req));
    }

    @ApiOperation(value = "本科实践教学:“高峰体验计划”项目")
    @GetMapping(value = "/listPeakExperienceProgram")
    @LoggerManage("本科实践教学:“高峰体验计划”项目")
    public JsonResult listPeakExperienceProgram(TeachingProcessREQ req) {
        return buildSuccJson(teachingProcessService.listPeakExperienceProgram(req));
    }

    @ApiOperation(value = "本科毕设:选题来源情况")
    @GetMapping(value = "/listSelectedTopic")
    @LoggerManage("本科毕设:选题来源情况")
    public JsonResult listSelectedTopic(TeachingProcessREQ req) {
        return buildSuccJson(teachingProcessService.listSelectedTopic(req));
    }

    @ApiOperation(value = "本科毕设:跨专业选题情况")
    @GetMapping(value = "/listInterdisciplinaryTopic")
    @LoggerManage("本科毕设:跨专业选题情况")
    public JsonResult listInterdisciplinaryTopic(TeachingProcessREQ req) {
        return buildSuccJson(teachingProcessService.listInterdisciplinaryTopic(req));
    }

    @ApiOperation(value = "研究生论文:论文及答辩质量")
    @GetMapping(value = "/listThesisDefenseQuality")
    @LoggerManage("研究生论文:论文及答辩质量")
    public JsonResult listThesisDefenseQuality(TeachingProcessREQ req) {
        return buildSuccJson(teachingProcessService.listThesisDefenseQuality(req));
    }

    @ApiOperation(value = "研究生论文:优秀研究生论文")
    @GetMapping(value = "/listExcellentPostgraduateThesis")
    @LoggerManage("研究生论文:优秀研究生论文")
    public JsonResult listExcellentPostgraduateThesis(TeachingProcessREQ req) {
        return buildSuccJson(teachingProcessService.listExcellentPostgraduateThesis(req));
    }

    @ApiOperation(value = "研究生论文:学术论文成果分布")
    @GetMapping(value = "/listAcademicPaperAchievements")
    @LoggerManage("研究生论文:学术论文成果分布")
    public JsonResult listAcademicPaperAchievements(TeachingProcessREQ req) {
        return buildSuccJson(teachingProcessService.listAcademicPaperAchievements(req));
    }

    @ApiOperation(value = "研究生论文：论文送审优良比例(博士/硕士)")
    @GetMapping(value = "/masterThesisExcellent")
    @LoggerManage("研究生论文：论文送审优良比例(博士/硕士)")
    public JsonResult masterThesisExcellent(String annual,String studentType) {// annual 年份，studentType 学生类型
        return buildSuccJson(teachingProcessService.masterThesisExcellent(annual,studentType));
    }

    @ApiOperation(value = "研究生学位授予:学位授予情况")
    @GetMapping(value = "/listPostgraduateDegreeAward")
    @LoggerManage("研究生学位授予:学位授予情况")
    public JsonResult listPostgraduateDegreeAward(TeachingProcessREQ req) {
        return buildSuccJson(teachingProcessService.listPostgraduateDegreeAward(req));
    }

	@ApiOperation(value = "本科生/研究生评教：本科生/研究生学生评教")
	@GetMapping(value = "/undergraduateStuEva")
	@LoggerManage("本科生/研究生评教：本科生/研究生学生评教")
	public JsonResult undergraduateStuEva(String semesterYear,String studentType) {//semesterYear 学年,学生类型 本科生，研究生
		return buildSuccJson(teachingProcessService.undergraduateStuEva(semesterYear,studentType));
	}

	@ApiOperation(value = "本科生/研究生评教：本科生/研究生学院学生评价")
	@GetMapping(value = "/undergraduateAcaStuEva")
	@LoggerManage("本科生/研究生评教：本科生/研究生学院学生评价")
	public JsonResult undergraduateAcaStuEva(String semesterYear,String studentType) {//semesterYear 学年,学生类型 本科生，研究生
		return buildSuccJson(teachingProcessService.undergraduateAcaStuEva(semesterYear,studentType));
	}

	@ApiOperation(value = "研究生评教：学生评教箱线图")
	@GetMapping(value = "/academicAndScoreBoxLine")
	@LoggerManage("研究生评教：学生评教箱线图")
	public JsonResult academicAndScoreBoxLine(String semesterYear) {//semesterYear 学年
		return buildSuccJson(teachingProcessService.academicAndScoreBoxLine(semesterYear));
	}


}
