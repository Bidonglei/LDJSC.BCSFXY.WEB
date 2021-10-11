package com.sunmnet.bigdata.web.controller.student;

import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.web.model.request.student.GradationREQ;
import com.sunmnet.bigdata.web.service.student.StudentGraduationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@Api(tags = "学生-就业分析")
public class StudentGraduationController extends BaseController {

	@Autowired
	private StudentGraduationService studentGraduationService;

	@ApiOperation(value = "学院就业分析")
	@GetMapping(value = "/listAcademyGraduation")
	@LoggerManage("学院就业分析")
	public JsonResult listAcademyGraduation(GradationREQ req) {
		return buildSuccJson(studentGraduationService.listAcademyGraduation(req));
	}

	@ApiOperation(value = "毕业生去向")
	@GetMapping(value = "/listStudentGraduateTo")
	@LoggerManage("毕业生去向")
	public JsonResult listStudentGraduateTo(GradationREQ req) {
		return buildSuccJson(studentGraduationService.listStudentGraduateTo(req));
	}

	@ApiOperation(value = "就业行业分布情况")
	@GetMapping(value = "/listStudentCompanyType")
	@LoggerManage("就业行业分布情况")
	public JsonResult listStudentCompanyType(GradationREQ req) {
		return buildSuccJson(studentGraduationService.listStudentCompanyType(req));
	}

	@ApiOperation(value = "签约单位地域分布")
	@GetMapping(value = "/listStudentWorkingArea")
	@LoggerManage("签约单位地域分布")
	public JsonResult listStudentWorkingArea(GradationREQ req) {
		return buildSuccJson(studentGraduationService.listStudentWorkingArea(req));
	}

	@ApiOperation(value = "近五年毕业生就业趋势")
	@GetMapping(value = "/listGraduateToFiveYear")
	@LoggerManage("近五年毕业生就业趋势")
	public JsonResult listGraduateToFiveYear() {
		return buildSuccJson(studentGraduationService.listGraduateToFiveYear());
	}
}