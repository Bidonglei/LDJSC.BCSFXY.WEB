package com.sunmnet.bigdata.web.controller.student;

import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.web.model.entity.student.AnomalyAcademyNumRequest;
import com.sunmnet.bigdata.web.model.entity.student.MasterStructRequest;
import com.sunmnet.bigdata.web.service.student.StudentProfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 *功能描述
 * @author lkg
 * @date 2019/3/1
 */
@RestController
@RequestMapping("/studentProfile")
@Api(tags = "学生-学生概况")
public class StudentProfileController extends BaseController {
	@Autowired
	private StudentProfileService studentProfileService;



	@ApiOperation(value = "总体概况：在校生分布图")
	@GetMapping(value = "/studentDistribution")
	@LoggerManage("总体概况：在校生分布图")
	public JsonResult studentDistribution(){
		return buildSuccJson(studentProfileService.studentDistribution());
	}

	@ApiOperation(value = "总体概况：在校生学院分布图")
	@GetMapping(value = "/collegeDistribution")
	@LoggerManage("总体概况：在校生学院分布图")
	public JsonResult collegeDistribution(){
		return buildSuccJson(studentProfileService.collegeDistribution());
	}

	@ApiOperation(value = "总体概况：查看各学院对比情况")
	@GetMapping(value = "/academyStuDis")
	@LoggerManage("总体概况：查看各学院对比情况")
	public JsonResult academyStuDis(){
		return buildSuccJson(studentProfileService.academyStuDis());
	}

	@ApiOperation(value = "总体概况：在校生结构")
	@GetMapping(value = "/schoolStructure")
	@LoggerManage("总体概况：在校生结构")
	public JsonResult schoolStructure(){
		return buildSuccJson(studentProfileService.schoolStructure());
	}

	@ApiOperation(value = "本科生结构：本科生结构图")
	@GetMapping(value = "/undergraduateStructure")
	@LoggerManage("本科生结构：本科生结构图")
	public JsonResult undergraduateStructure(){
		return buildSuccJson(studentProfileService.undergraduateStructure());
	}

	@ApiOperation(value = "本科生结构：查看各学院学生结构比例 各学院年级结构对比")
	@GetMapping(value = "/undergraduateGrade")
	@LoggerManage("本科生结构：查看各学院学生结构比例 各学院年级结构对比")
	public JsonResult undergraduateGrade(){
		return buildSuccJson(studentProfileService.undergraduateGrade());
	}

	@ApiOperation(value = "本科生结构：查看各学院学生结构比例 各学院性别比例")
	@GetMapping(value = "/undergraduateSex")
	@LoggerManage("本科生结构：查看各学院学生结构比例 各学院性别比例")
	public JsonResult undergraduateSex(){
		return buildSuccJson(studentProfileService.undergraduateSex());
	}

	@ApiOperation(value = "本科生结构：查看各学院学生结构比例 各学院民族分布情况")
	@GetMapping(value = "/undergraduateNation")
	@LoggerManage("本科生结构：查看各学院学生结构比例 各学院民族分布情况")
	public JsonResult undergraduateNation(){
		return buildSuccJson(studentProfileService.undergraduateNation());
	}


	@ApiOperation(value = "本科生结构：查看各学院学生结构比例 各学院信仰分布情况")
	@GetMapping(value = "/undergraduateReligion")
	@LoggerManage("本科生结构：查看各学院学生结构比例 各学院信仰分布情况")
	public JsonResult undergraduateReligion(){
		return buildSuccJson(studentProfileService.undergraduateReligion());
	}

	@ApiOperation(value = "本科生结构：查看各学院学生结构比例 各学院本科专业数量")
	@GetMapping(value = "/undergraduateMajorNum")
	@LoggerManage("本科生结构：查看各学院学生结构比例 各学院本科专业数量")
	public JsonResult undergraduateMajorNum(){
		return buildSuccJson(studentProfileService.undergraduateMajorNum());
	}

	@ApiOperation(value = "本科生结构：查看各学院学生结构比例 各本科专业人数")
	@GetMapping(value = "/undergraduatePeopleNum")
	@LoggerManage("本科生结构：查看各学院学生结构比例 各本科专业人数")
	public JsonResult undergraduatePeopleNum(){
		return buildSuccJson(studentProfileService.undergraduatePeopleNum());
	}

	@ApiOperation(value = "本科生结构：年级结构，性别结构，少数民族，宗教信仰")
	@GetMapping(value = "/undergraduateColDet")
	@LoggerManage("本科生结构：年级结构，性别结构，少数民族，宗教信仰")
	public JsonResult undergraduateColDet(String academyCode) {
		return buildSuccJson(studentProfileService.undergraduateColDet(academyCode));
	}

	@ApiOperation(value = "硕士/博士生结构：研究生类别，学院分布，学科结构")
	@GetMapping(value = "/masterStruct")
	@LoggerManage("硕士/博士生结构：研究生类别，学院分布，学科结构")
	public JsonResult masterStruct(@Validated MasterStructRequest masterStructRequest,BindingResult bindingResult) {
		return buildSuccJson(studentProfileService.masterStruct(masterStructRequest));
	}

	@ApiOperation(value = "地域分析：本科生，在校生，在校生校区分布")
	@GetMapping(value = "/areaDistribute")
	@LoggerManage("地域分析：本科生，在校生，在校生校区分布")
	public JsonResult areaDistribute(String educateGradation) {
		return buildSuccJson(studentProfileService.areaDistribute(educateGradation));//填BKS是本科生，填ZXS是在校生，填XQFB是在校生校区分布
	}

	@ApiOperation(value = "留学生结构：留学生类别")
	@GetMapping(value = "/foreignCategory")
	@LoggerManage("留学生结构：留学生类别")
	public JsonResult foreignCategory() {
		return buildSuccJson(studentProfileService.foreignCategory());
	}

	@ApiOperation(value = "留学生结构：留学生世界区域分布")
	@GetMapping(value = "/foreignArea")
	@LoggerManage("留学生结构：留学生世界区域分布")
	public JsonResult foreignArea() {
		return buildSuccJson(studentProfileService.foreignArea());
	}

	@ApiOperation(value = "留学生结构：留学生学院分布")
	@GetMapping(value = "/foreignAcademyDistribute")
	@LoggerManage("留学生结构：留学生学院分布")
	public JsonResult foreignAcademyDistribute() {
		return buildSuccJson(studentProfileService.foreignAcademyDistribute());
	}

	@ApiOperation(value = "留学生分布：留学生分布")
	@GetMapping(value = "/foreignDistribute")
	@LoggerManage("留学生分布：留学生分布")
	public JsonResult foreignDistribute() {
		return buildSuccJson(studentProfileService.foreignDistribute());
	}

	@ApiOperation(value = "学籍状况：本科生/研究生学籍异常分析")
	@GetMapping(value = "/anomalyNum")
	@LoggerManage("学籍状况：本科生/研究生学籍异常分析")
	public JsonResult anomalyNum(String educateGradation) {
		return buildSuccJson(studentProfileService.anomalyNum(educateGradation));
	}

	@ApiOperation(value = "学籍状况：本科生/研究生 学籍异常类型 学生学院分布")
	@GetMapping(value = "/anomalyAcademyNum")
	@LoggerManage("学籍状况：本科生/研究生 学籍异常类型 学生学院分布")
	public JsonResult anomalyAcademyNum(@Validated AnomalyAcademyNumRequest anomalyAcademyNumRequest,BindingResult bindingResult) {
		return buildSuccJson(studentProfileService.anomalyAcademyNum(anomalyAcademyNumRequest.getEducateGradation()));
	}

	@ApiOperation(value = "重点关注学生：心理危机类学生情况")
	@GetMapping(value = "/psyCrisisSituation")
	@LoggerManage("重点关注学生：心理危机类学生情况")
	public JsonResult psyCrisisSituation(String semesterYear) {
		return buildSuccJson(studentProfileService.psyCrisisSituation(semesterYear));
	}

	@ApiOperation(value = "重点关注学生：心理危机学生学院分布")
	@GetMapping(value = "/psyCrisisAcaDis")
	@LoggerManage("重点关注学生：心理危机学生学院分布")
	public JsonResult psyCrisisAcaDis(String semesterYear) {
		return buildSuccJson(studentProfileService.psyCrisisAcaDis(semesterYear));
	}

	@ApiOperation(value = "重点关注学生：贫困生情况")
	@GetMapping(value = "/poorSituation")
	@LoggerManage("重点关注学生：贫困生情况")
	public JsonResult poorSituation(String semesterYear) {
		return buildSuccJson(studentProfileService.poorSituation(semesterYear));
	}

	@ApiOperation(value = "重点关注学生：贫困生学院分布")
	@GetMapping(value = "/poorAcaDis")
	@LoggerManage("重点关注学生：贫困生学院分布")
	public JsonResult poorAcaDis(String semesterYear) {
		return buildSuccJson(studentProfileService.poorAcaDis(semesterYear));
	}

	@ApiOperation(value = "重点关注学生：身体健康预警情况")
	@GetMapping(value = "/healthWarning")
	@LoggerManage("重点关注学生：身体健康预警情况")
	public JsonResult healthWarning(String semesterYear) {
		return buildSuccJson(studentProfileService.healthWarning(semesterYear));
	}

	@ApiOperation(value = "重点关注学生：本科生学业预警(无用)")
	@GetMapping(value = "/undergraduateWarnType")
	@LoggerManage("重点关注学生：本科生学业预警")
	public JsonResult undergraduateWarnType(String semesterYear) {
		return buildSuccJson(studentProfileService.undergraduateWarnType(semesterYear));
	}

	@ApiOperation(value = "重点关注学生：学业学分预警学生学院分布(无用)")
	@GetMapping(value = "/undergraduateAcaWarn")
	@LoggerManage("重点关注学生：学业学分预警学生学院分布")
	public JsonResult undergraduateAcaWarn(String semesterYear) {
		return buildSuccJson(studentProfileService.undergraduateAcaWarn(semesterYear));
	}

	@ApiOperation(value = "重点关注学生：学业问题类学生情况")
	@GetMapping(value = "/academicQueSit")
	@LoggerManage("重点关注学生：学业问题类学生情况")
	public JsonResult academicQueSit(String semesterYear) {
		return buildSuccJson(studentProfileService.academicQueSit(semesterYear));
	}

	@ApiOperation(value = "重点关注学生：学业问题类学生学院分布")
	@GetMapping(value = "/academicQueAcaDis")
	@LoggerManage("重点关注学生：学业问题类学生学院分布")
	public JsonResult academicQueAcaDis(String semesterYear) {
		return buildSuccJson(studentProfileService.academicQueAcaDis(semesterYear));
	}


	@ApiOperation(value = "党员情况：学生党员概况")
	@GetMapping(value = "/partyDistribute")
	@LoggerManage("党员情况：学生党员概况")
	public JsonResult partyDistribute() {
		return buildSuccJson(studentProfileService.partyDistribute());
	}

	@ApiOperation(value = "党员情况：近五年学生党员人数变化")
	@GetMapping(value = "/partyChange")
	@LoggerManage("党员情况：近五年学生党员人数变化")
	public JsonResult partyChange() {
		return buildSuccJson(studentProfileService.partyChange());
	}

	@ApiOperation(value = "党员情况：学生党员学院分布")
	@GetMapping(value = "/partyAcademyDis")
	@LoggerManage("党员情况：学生党员学院分布")
	public JsonResult partyAcademyDis() {
		return buildSuccJson(studentProfileService.partyAcademyDis());
	}
}
