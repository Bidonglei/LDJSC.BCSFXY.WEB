package com.sunmnet.bigdata.web.controller.teaching;

import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.common.request.BasePageRequest;
import com.sunmnet.bigdata.web.model.request.science.InternationalCooBasePageREQ;
import com.sunmnet.bigdata.web.model.request.science.ResearchExpertPageREQ;
import com.sunmnet.bigdata.web.model.request.science.SciencePlatformPageREQ;
import com.sunmnet.bigdata.web.model.request.science.ScienceTeamPageREQ;
import com.sunmnet.bigdata.web.model.request.teaching.GraduateCourseREQ;
import com.sunmnet.bigdata.web.model.request.teaching.GraduateTeacherPageREQ;
import com.sunmnet.bigdata.web.service.science.ScienceResourceService;
import com.sunmnet.bigdata.web.service.teaching.TeachingResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/teachingResource")
@Api(tags="教学-教学资源")
public class TeachingResourceController extends BaseController
{

    @Autowired
    private TeachingResourceService teachingResourceService;

	@ApiOperation(value = "师资趋势：师资趋势")
	@GetMapping(value = "/teacherTrend")
	@LoggerManage("师资趋势：师资趋势")
	public JsonResult teacherTrend(){
		return buildSuccJson(teachingResourceService.teacherTrend());
	}

	@ApiOperation(value = "师资分析：教学单位师资情况")
	@GetMapping(value = "/academyTeachingSituation")
	@LoggerManage("师资分析：教学单位师资情况")
	public JsonResult academyTeachingSituation(){
		return buildSuccJson(teachingResourceService.academyTeachingSituation());
	}

	@ApiOperation(value = "师资分析：各学院聘用老师类型 专任教师 外聘教师")
	@GetMapping(value = "/academyTeacherType")
	@LoggerManage("师资分析：各学院聘用老师类型 专任教师 外聘教师")
	public JsonResult academyTeacherType(){
		return buildSuccJson(teachingResourceService.academyTeacherType());
	}

	@ApiOperation(value = "师资分析：专任教师结构分析")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "academyCode", dataType = "string", required = false, value = "学院编号", defaultValue = "06090")
	})
	@GetMapping(value = "/fullTeacherStruct")
	@LoggerManage("师资分析：专任教师结构分析")
	public JsonResult fullTeacherStruct(String academyCode){
		return buildSuccJson(teachingResourceService.fullTeacherStruct(academyCode));
	}

	@ApiOperation(value = "研究生导师：研究生导师分布情况")
	@GetMapping(value = "/graduateTeaDis")
	@LoggerManage("师资分析：研究生导师分布情况")
	public JsonResult graduateTeaDis(){
		return buildSuccJson(teachingResourceService.graduateTeaDis());
	}

	@ApiOperation(value = "研究生导师：研究生导师结构分析")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "academyCode", dataType = "string", required = true, value = "学院编号", defaultValue = "06090")
	})
	@GetMapping(value = "/graduateTeaStruct")
	@LoggerManage("研究生导师：研究生导师结构分析")
	public JsonResult graduateTeaStruct(String academyCode){
		return buildSuccJson(teachingResourceService.graduateTeaStruct(academyCode));
	}

	@ApiOperation(value = "研究生导师：研究生导师指导学生情况分页")
	@GetMapping(value = "/graduateTeacherPage")
	@LoggerManage("研究生导师：研究生导师指导学生情况分页")
	public JsonResult graduateTeacherPage(@Validated GraduateTeacherPageREQ graduateTeacherPageREQ,
			BindingResult bindingResult){
		return buildSuccJson(teachingResourceService.graduateTeacherPage(graduateTeacherPageREQ));
	}

	@ApiOperation(value = "研究生导师：近三年导师指导学生人数情况")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "type", dataType = "string", required = true, value = "学生类型", defaultValue = "硕士")
	})
	@GetMapping(value = "/listTutorGuideStudent")
	@LoggerManage("研究生导师：近三年导师指导学生人数情况")
	public JsonResult listTutorGuideStudent(String type){
		return buildSuccJson(teachingResourceService.listTutorGuideStudent(type));
	}


	@ApiOperation(value = "本科生专业（类）：专业分布（学院--专业）")
	@GetMapping(value = "/undergraduateAcademyMajor")
	@LoggerManage("本科生专业（类）：专业分布（学院--专业）")
	public JsonResult undergraduateAcademyMajor(){
		return buildSuccJson(teachingResourceService.undergraduateAcademyMajor());
	}

	@ApiOperation(value = "本科生专业（类）：专业大类分布（专业大类--专业）")
	@GetMapping(value = "/undergraduateLargeMajor")
	@LoggerManage("本科生专业（类）：专业大类分布（专业大类--专业）")
	public JsonResult undergraduateLargeMajor(){
		return buildSuccJson(teachingResourceService.undergraduateLargeMajor());
	}

	@ApiOperation(value = "研究生学科专业：研究生学科分布（学院--学科）")
	@GetMapping(value = "/graduateAcademySubject")
	@LoggerManage("研究生学科专业：研究生学科分布（学院--学科）")
	public JsonResult graduateAcademySubject(){
		return buildSuccJson(teachingResourceService.graduateAcademySubject());
	}

	@ApiOperation(value = "研究生学科专业：研究生学科分布（学院--专业）")
	@GetMapping(value = "/graduateAcademyMajor")
	@LoggerManage("研究生学科专业：研究生学科分布（学院--专业）")
	public JsonResult graduateAcademyMajor(){
		return buildSuccJson(teachingResourceService.graduateAcademyMajor());
	}

	@ApiOperation(value = "本科课程：本科课程结构分布")
	@GetMapping(value = "/undergraduateCourseStruct")
	@LoggerManage("本科课程：本科课程结构分布")
	public JsonResult undergraduateCourseStruct(){
		return buildSuccJson(teachingResourceService.undergraduateCourseStruct());
	}

	@ApiOperation(value = "本科课程：全校开设课程")
	@GetMapping(value = "/undergraduateOpenCourse")
	@LoggerManage("本科课程：全校开设课程")
	public JsonResult undergraduateOpenCourse(String annual){
		return buildSuccJson(teachingResourceService.undergraduateOpenCourse(annual));
	}

	@ApiOperation(value = "本科课程：优质课程资源建设")
	@GetMapping(value = "/undergraduateQualityCourse")
	@LoggerManage("本科课程：优质课程资源建设")
	public JsonResult undergraduateQualityCourse(){
		return buildSuccJson(teachingResourceService.undergraduateQualityCourse());
	}

	@ApiOperation(value = "本科课程：国家虚拟仿真实验教学项目分页")
	@GetMapping(value = "/undergraduateFicCouPage")
	@LoggerManage("本科课程：国家虚拟仿真实验教学项目分页")
	public JsonResult undergraduateFicCouPage(@Validated BasePageRequest basePageRequest,
			BindingResult bindingResult){
		return buildSuccJson(teachingResourceService.undergraduateFicCouPage(basePageRequest));
	}

	@ApiOperation(value = "本科课程：国家精品在线开放课程分页")
	@GetMapping(value = "/undergraduateBouCouPage")
	@LoggerManage("本科课程：国家精品在线开放课程分页")
	public JsonResult undergraduateBouCouPage(@Validated BasePageRequest basePageRequest,
			BindingResult bindingResult){
		return buildSuccJson(teachingResourceService.undergraduateBouCouPage(basePageRequest));
	}

	@ApiOperation(value = "本科课程：在线开放课程表")
	@GetMapping(value = "/undergraduateOnlineCourse")
	@LoggerManage("本科课程：在线开放课程表")
	public JsonResult undergraduateOnlineCourse(){
		return buildSuccJson(teachingResourceService.undergraduateOnlineCourse());
	}

	@ApiOperation(value = "研究生课程：研究生课程结构分布")
	@GetMapping(value = "/graduateLatestCouStr")
	@LoggerManage("研究生课程：研究生课程结构分布")
	public JsonResult graduateLatestCouStr(GraduateCourseREQ req){
		return buildSuccJson(teachingResourceService.graduateLatestCouStr(req));
	}

	@ApiOperation(value = "研究生课程：研究生开设课程趋势")
	@GetMapping(value = "/graduateCourseStr")
	@LoggerManage("研究生课程：研究生开设课程趋势")
	public JsonResult graduateCourseStr(){
		return buildSuccJson(teachingResourceService.graduateCourseStr());
	}

	@ApiOperation(value = "研究生课程：优质课程资源建设(校级)")
	@GetMapping(value = "/graduateTotalQualityCou")
	@LoggerManage("研究生课程：优质课程资源建设(校级)")
	public JsonResult graduateTotalQualityCou(){
		return buildSuccJson(teachingResourceService.graduateTotalQualityCou());
	}

	@ApiOperation(value = "研究生课程：优质课程资源趋势(校级)")
	@GetMapping(value = "/graduateQualityCourse")
	@LoggerManage("研究生课程：优质课程资源趋势(校级)")
	public JsonResult graduateQualityCourse(){
		return buildSuccJson(teachingResourceService.graduateQualityCourse());
	}

	@ApiOperation(value = "研究生课程：研究生学院课程分类")
	@GetMapping(value = "/graduateOneCourse")
	@LoggerManage("研究生课程：研究生学院课程分类")
	public JsonResult graduateOneCourse(GraduateCourseREQ req){
		return buildSuccJson(teachingResourceService.graduateOneCourse(req));
	}
}
