package com.sunmnet.bigdata.web.controller.student;

import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.web.model.entity.student.AnomalyAcademyNumRequest;
import com.sunmnet.bigdata.web.model.entity.student.MasterStructRequest;
import com.sunmnet.bigdata.web.service.student.StudentEnrollService;
import com.sunmnet.bigdata.web.service.student.StudentProfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *功能描述 招生分析
 * @author lkg
 * @date 2019/4/11
 */
@RestController
@RequestMapping("/enroll")
@Api(tags = "学生-招生分析")
public class StudentEnrollController extends BaseController {
	@Autowired
	private StudentEnrollService studentEnrollService;


	@ApiOperation(value = "本科生招生：各专业招生情况")
	@GetMapping(value = "/undergraduateEnrollMajor")
	@LoggerManage("本科生招生：各专业招生情况")
	public JsonResult undergraduateEnrollMajor(String year){
		return buildSuccJson(studentEnrollService.undergraduateEnrollMajor(year));
	}

	@ApiOperation(value = "本科生招生：各学院招生情况")
	@GetMapping(value = "/undergraduateEnrollAcademy")
	@LoggerManage("本科生招生：各学院招生情况")
	public JsonResult undergraduateEnrollAcademy(String year){
		return buildSuccJson(studentEnrollService.undergraduateEnrollAcademy(year));
	}

	@ApiOperation(value = "本科生招生：近五年本科生招生分析")
	@GetMapping(value = "/undergraduateFiveEnroll")
	@LoggerManage("本科生招生：近五年本科生招生分析")
	public JsonResult undergraduateFiveEnroll(){
		return buildSuccJson(studentEnrollService.undergraduateFiveEnroll());
	}

	@ApiOperation(value = "本科生生源：本科生生源(生源地分布)")
	@GetMapping(value = "/undergraduateOriginEnroll")
	@LoggerManage("本科生生源：本科生生源(生源地分布)")
	public JsonResult undergraduateOriginEnroll(String year){
		return buildSuccJson(studentEnrollService.undergraduateOriginEnroll(year));
	}

	@ApiOperation(value = "本科生生源：生源类别分布")
	@GetMapping(value = "/sourceTypeDis")
	@LoggerManage("本科生生源：生源类别分布")
	public JsonResult sourceTypeDis(String year){
		return buildSuccJson(studentEnrollService.sourceTypeDis(year));
	}

	@ApiOperation(value = "本科生生源：生源中学分布")
	@GetMapping(value = "/MiddleSchoolDis")
	@LoggerManage("本科生生源：生源中学分布")
	public JsonResult MiddleSchoolDis(String year){
		return buildSuccJson(studentEnrollService.MiddleSchoolDis(year));
	}

	@ApiOperation(value = "研究生招生：硕士/博士生招生结构")
	@GetMapping(value = "/masterStructure")
	@LoggerManage("研究生招生：硕士/博士生招生结构")
	public JsonResult masterStructure(String educateGradation,String year){//入参：硕士 博士
		return buildSuccJson(studentEnrollService.masterStructure(educateGradation,year));
	}

	@ApiOperation(value = "研究生招生：研究生近五年招生趋势")
	@GetMapping(value = "/masterFiveEnroll")
	@LoggerManage("研究生招生：研究生近五年招生趋势")
	public JsonResult masterFiveEnroll(){
		return buildSuccJson(studentEnrollService.masterFiveEnroll());
	}

	@ApiOperation(value = "研究生招生：各学科/专业招生情况")
	@GetMapping(value = "/masterEnrollMajor")
	@LoggerManage("研究生招生：各学科/专业招生情况")
	public JsonResult masterEnrollMajor(String type,String year){
		return buildSuccJson(studentEnrollService.masterEnrollMajor(type,year));
	}

	@ApiOperation(value = "研究生生源：硕士学源分析(学院)")
	@GetMapping(value = "/masterSourceAcademy")
	@LoggerManage("研究生生源：硕士学源分析(学院)")
	public JsonResult masterSourceAcademy(String educateGradation,String year){
		return buildSuccJson(studentEnrollService.masterSourceAcademy(educateGradation,year));
	}

	@ApiOperation(value = "研究生生源：硕士学源分析(学科)")
	@GetMapping(value = "/masterSourceMajor")
	@LoggerManage("研究生生源：硕士学源分析(学科)")
	public JsonResult masterSourceMajor(String educateGradation,String year){
		return buildSuccJson(studentEnrollService.masterSourceMajor(educateGradation,year));
	}

	@ApiOperation(value = "留学生招生：留学生招生")
	@GetMapping(value = "/foreignEnrollDistribute")
	@LoggerManage("留学生招生：留学生招生")
	public JsonResult foreignEnrollDistribute(String year){
		return buildSuccJson(studentEnrollService.foreignEnrollDistribute(year));
	}

	@ApiOperation(value = "招生质量：本科生招生质量")
	@GetMapping(value = "/undergraduateEnrollQuality")
	@LoggerManage("招生质量：本科生招生质量")
	public JsonResult undergraduateEnrollQuality(String enrollSubjectType,String year){//enrollSubjectType 招生学科类型 文史，理工
		return buildSuccJson(studentEnrollService.undergraduateEnrollQuality(enrollSubjectType,year));
	}

	@ApiOperation(value = "招生质量：本科生招生趋势")
	@GetMapping(value = "/undergraduateEnrollTrend")
	@LoggerManage("招生质量：本科生招生趋势")
	public JsonResult undergraduateEnrollTrend(String province,String enrollSubjectType){//province 省份名称，enrollSubjectType招生学科类型 文史，理工
		return buildSuccJson(studentEnrollService.undergraduateEnrollTrend(province,enrollSubjectType));
	}

	@ApiOperation(value = "招生质量：硕士生招生质量")
	@GetMapping(value = "/masterEnrollQuality")
	@LoggerManage("招生质量：硕士生招生质量")
	public JsonResult masterEnrollQuality(String year){
		return buildSuccJson(studentEnrollService.masterEnrollQuality(year));
	}

}
