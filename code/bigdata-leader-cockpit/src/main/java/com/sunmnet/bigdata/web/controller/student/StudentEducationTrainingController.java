package com.sunmnet.bigdata.web.controller.student;

import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.common.request.BasePageRequest;
import com.sunmnet.bigdata.web.model.entity.student.AnomalyAcademyNumRequest;
import com.sunmnet.bigdata.web.model.entity.student.InternationExchangeRequest;
import com.sunmnet.bigdata.web.service.student.StudentEducationTrainingService;
import com.sunmnet.bigdata.web.service.student.StudentEnrollService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *功能描述 教育培养
 * @author lkg
 * @date 2019/4/17
 */
@RestController
@RequestMapping("/educationTraining")
@Api(tags = "学生-教育培养")
public class StudentEducationTrainingController extends BaseController {
	@Autowired
	private StudentEducationTrainingService studentEducationTrainingService;

	@ApiOperation(value = "国际交流：国际交流")
	@GetMapping(value = "/internationalExchange")
	@LoggerManage("国际交流：国际交流")
	public JsonResult internationalExchange(@Validated InternationExchangeRequest internationExchangeRequest,
			BindingResult bindingResult){
		return buildSuccJson(studentEducationTrainingService.internationalExchange(internationExchangeRequest));
	}

	@ApiOperation(value = "奖助学情况：奖助学资金分布")
	@GetMapping(value = "/annualScholarship")
	@LoggerManage("奖助学情况：奖助学资金分布")
	public JsonResult annualScholarship(){
		return buildSuccJson(studentEducationTrainingService.annualScholarship());
	}

	@ApiOperation(value = "奖助学情况：奖学金学院分布")
	@GetMapping(value = "/academyScholarship")
	@LoggerManage("奖助学情况：奖学金学院分布")
	public JsonResult academyScholarship(String annual){
		return buildSuccJson(studentEducationTrainingService.academyScholarship(annual));
	}

	@ApiOperation(value = "奖助学情况：奖学金情况")
	@GetMapping(value = "/scholarshipDetail")
	@LoggerManage("奖助学情况：奖学金情况")
	public JsonResult scholarshipDetail(String annual){
		return buildSuccJson(studentEducationTrainingService.scholarshipDetail(annual));
	}

	@ApiOperation(value = "奖助学情况：奖助学金受助学生去向类型")
	@GetMapping(value = "/whereaboutsType")
	@LoggerManage("奖助学情况：奖助学金受助学生去向类型")
	public JsonResult whereaboutsType(String annual){
		return buildSuccJson(studentEducationTrainingService.whereaboutsType(annual));
	}

	@ApiOperation(value = "奖助学情况：奖助学金受助学生去向详细类型")
	@GetMapping(value = "/whereaboutsDetailType")
	@LoggerManage("奖助学情况：奖助学金受助学生去向详细类型")
	public JsonResult whereaboutsDetailType(String annual){
		return buildSuccJson(studentEducationTrainingService.whereaboutsDetailType(annual));
	}

	@ApiOperation(value = "资助学生：奖学金受益学生类别")
	@GetMapping(value = "/scholarship")
	@LoggerManage("资助学生：奖学金受益学生类别")
	public JsonResult scholarship(String annual){
		return buildSuccJson(studentEducationTrainingService.scholarship(annual));
	}

	@ApiOperation(value = "资助学生：助学贷款受益学生类别")
	@GetMapping(value = "/studentLoans")
	@LoggerManage("资助学生：助学贷款受益学生类别")
	public JsonResult studentLoans(String annual){
		return buildSuccJson(studentEducationTrainingService.studentLoans(annual));
	}


	@ApiOperation(value = "资助学生：减免学费受益学生类别")
	@GetMapping(value = "/tuitionReduction")
	@LoggerManage("资助学生：减免学费受益学生类别")
	public JsonResult tuitionReduction(String annual){
		return buildSuccJson(studentEducationTrainingService.tuitionReduction(annual));
	}


	@ApiOperation(value = "资助学生：党员获得奖助学金情况")
	@GetMapping(value = "/aidFinanciallyParty")
	@LoggerManage("资助学生：党员获得奖助学金情况")
	public JsonResult aidFinanciallyParty(String annual){
		return buildSuccJson(studentEducationTrainingService.aidFinanciallyParty(annual));
	}

	@ApiOperation(value = "学生获奖：查看学生获奖详细信息分页")
	@GetMapping(value = "/awardDetailPage")
	@LoggerManage("学生获奖：查看学生获奖详细信息分页")
	public JsonResult awardDetailPage(@Validated BasePageRequest basePageRequest,
			BindingResult bindingResult){
		return buildSuccJson(studentEducationTrainingService.awardDetailPage(basePageRequest));
	}

	@ApiOperation(value = "学生获奖：本科/研究生获奖")
	@GetMapping(value = "/studentAward")
	@LoggerManage("学生获奖：本科/研究生获奖")
	public JsonResult studentAward(String achieveType){//获取人类型：BKS（本科生），YJS（研究生）
		return buildSuccJson(studentEducationTrainingService.studentAward(achieveType));
	}

	@ApiOperation(value = "学生获奖：本科/研究生学院获奖")
	@GetMapping(value = "/academyAward")
	@LoggerManage("学生获奖：本科/研究生学院获奖")
	public JsonResult academyAward(String achieveType){//获取人类型：BKS（本科生），YJS（研究生）
		return buildSuccJson(studentEducationTrainingService.academyAward(achieveType));
	}


	@ApiOperation(value = "学生发展：人才培养")
	@GetMapping(value = "/personnelTraining")
	@LoggerManage("学生发展：人才培养")
	public JsonResult personnelTraining(){
		return buildSuccJson(studentEducationTrainingService.personnelTraining());
	}

	@ApiOperation(value = "学生发展：学生论文发表情况")
	@GetMapping(value = "/publishPaper")
	@LoggerManage("学生发展：学生论文发表情况")
	public JsonResult publishPaper(){
		return buildSuccJson(studentEducationTrainingService.publishPaper());
	}

	@ApiOperation(value = "学生发展：学生申请专利情况")
	@GetMapping(value = "/applicationPatent")
	@LoggerManage("学生发展：学生申请专利情况")
	public JsonResult applicationPatent(){
		return buildSuccJson(studentEducationTrainingService.applicationPatent());
	}

	@ApiOperation(value = "学生发展：学生发表作品数")
	@GetMapping(value = "/applicationWriting")
	@LoggerManage("学生发展：学生发表作品数")
	public JsonResult applicationWriting(){
		return buildSuccJson(studentEducationTrainingService.applicationWriting());
	}

	@ApiOperation(value = "学生发展：学生社团情况")
	@GetMapping(value = "/association")
	@LoggerManage("学生发展：学生社团情况")
	public JsonResult association(){
		return buildSuccJson(studentEducationTrainingService.association());
	}

	@ApiOperation(value = "学生出国：各学院学生出国情况")
	@GetMapping(value = "/abroadInfo")
	@LoggerManage("学生出国：各学院学生出国情况")
	public JsonResult abroadInfo(){
		return buildSuccJson(studentEducationTrainingService.abroadInfo());
	}

}
