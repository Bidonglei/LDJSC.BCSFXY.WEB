package com.sunmnet.bigdata.web.service.student.impl;

import com.sunmnet.bigdata.web.mapper.student.StudentProfileMapper;
import com.sunmnet.bigdata.web.model.entity.student.MasterStructRequest;
import com.sunmnet.bigdata.web.service.student.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *功能描述 学生概况
 * @author lkg
 * @date 2019/3/1
 */

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    @Autowired
    private StudentProfileMapper studentProfileMapper;



	@Override
	public List<Map<String, String>> studentDistribution() {
		//如果当前月份小于9月份，硕士年份取去年的，否则取今年的
		Calendar cal = Calendar.getInstance();
		int grade = 0;
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		if (month < 9){
			grade = year -1;
		}else {
			grade = year;
		}
		return studentProfileMapper.studentDistribution(grade);
	}

	@Override
	public List<Map<String, String>> collegeDistribution() {
		return studentProfileMapper.collegeDistribution();
	}

	@Override
	public Map<String, Object> undergraduateStructure() {
		Map<String, Object> structMap = new HashMap<>();
		Map<String, Object> map = new HashMap<>();
		//(包括留学生)
		//本科生人数
		map.put("educateGradation","本科");
		//map.put("educationType","留学生");
		int total = studentProfileMapper.studentTotal(map);
		//本科生学院分布人数
		List<Map<String, String>> collegeDist = studentProfileMapper.undergraduateCollegeDist();
		//本科学院人数TOP5
		List<Map<String, String>> collegeTopFive = studentProfileMapper.undergraduateCollegeTopFive();
		//本科专业人数TOP5
		List<Map<String, String>> majorTopFive = studentProfileMapper.undergraduateMajorTopFive();
		structMap.put("total",total);
		structMap.put("collegeDist",collegeDist);
		structMap.put("collegeTopFive",collegeTopFive);
		structMap.put("majorTopFive",majorTopFive);
		return structMap;
	}

	/**
	 *功能描述
	 * @author lkg
	 * @date 2019/3/1
	 */
	@Override
	public Map<String, List<Map<String, String>>> undergraduateColDet(String academyCode) {
		Map<String, List<Map<String, String>>> map = new HashMap<String, List<Map<String, String>>>();
		//(包括留学生)
		//本科生学院下的专业
		List<Map<String, String>> academyMajor = studentProfileMapper.academyMajor(academyCode);
		//本科生学院下的年级
		List<Map<String, String>> academyAnnual = studentProfileMapper.academyAnnual(academyCode);
		//本科生学院下的男女
		List<Map<String, String>> academySex = studentProfileMapper.academySex(academyCode);
		//本科生学院下的少数民族
		List<Map<String, String>> academyNation = studentProfileMapper.academyNation(academyCode);
		//本科生学院下的宗教信仰
		List<Map<String, String>> academyReligion = studentProfileMapper.academyReligion(academyCode);
		map.put("majorList",academyMajor);
		map.put("annualList",academyAnnual);
		map.put("sexList",academySex);
		map.put("nationList",academyNation);
		map.put("religionList",academyReligion);
		return map;
	}

	@Override
	public Map<String, Object> masterStruct(MasterStructRequest masterStructRequest) {
		Map<String, Object> structMap = new HashMap<>();
		Map<String, Object> map = new HashMap<>();
		//硕士/博士生人数(包括留学生)
		map.put("educateGradation",masterStructRequest.getEducateGradation());
		int total = studentProfileMapper.studentTotal(map);
		//硕士/博士生类别
		List<Map<String, String>> categoryList = studentProfileMapper.masterCategory(masterStructRequest.getEducateGradation());
		//硕士/博士学院分布
		List<Map<String, String>> academyList = studentProfileMapper.masterAcademyDis(masterStructRequest.getEducateGradation());
		//硕士/博士学科/专业结构
		String type = masterStructRequest.getType();
		String educationDetailType = null;
		if ("XK".equals(type)){
			educationDetailType = "学术型";
		}else if ("ZY".equals(type)){
			educationDetailType = "专业型";
		}
		List<Map<String, String>> majorList = studentProfileMapper.masterMajorDis(masterStructRequest.getEducateGradation(),educationDetailType);
		structMap.put("total",total);
		structMap.put("categoryList",categoryList);
		structMap.put("academyList",academyList);
		structMap.put("majorList",majorList);
		return structMap;
	}

	@Override
	public List<Map<String, String>> areaDistribute(String type) {
		List<Map<String, String>> list = null;
		if ("BKS".equals(type)){//本科生
			list =studentProfileMapper.areaDistribute("本科");
		}else if ("ZXS".equals(type)){//在校生
			list =studentProfileMapper.areaDistribute(null);
		}else if ("XQFB".equals(type)){//校区分布
			list =studentProfileMapper.schoolDistribute();
		}
		return list;
	}

	@Override
	public Map<String,Object> foreignCategory() {
		Map<String, Object> resultInfo = new HashMap<>();
		//留学生人数
		int total = studentProfileMapper.foreignTotal();
		//留学生类别
		List<Map> list = studentProfileMapper.foreignCategory();
		resultInfo.put("total",total);
		resultInfo.put("list",list);
		return resultInfo;
	}

	@Override
	public List<Map> foreignArea() {
		return studentProfileMapper.foreignArea();
	}

	@Override
	public List<Map> foreignAcademyDistribute() {
		return studentProfileMapper.foreignAcademyDistribute();
	}

	@Override
	public List<Map<String, String>> foreignDistribute() {
		return studentProfileMapper.foreignDistribute();
	}

	@Override
	public Map<String,Object> anomalyNum(String educateGradation) {
		Map<String, Object> resultInfo = new HashMap<>();
		//本科/研究生人数
		int total = studentProfileMapper.anomalyTotal(educateGradation);
		//本科/研究生学籍异常
		List<Map<String, String>> list = studentProfileMapper.anomalyNum(educateGradation);
		resultInfo.put("total",total);
		resultInfo.put("list",list);
		return resultInfo;
	}

	@Override
	public List<Map<String, String>> anomalyAcademyNum(String educateGradation) {
		return studentProfileMapper.anomalyAcademyNum(educateGradation);
	}

	@Override
	public Map psyCrisisSituation(String semesterYear) {
		Map<String, Object> resultInfo = new HashMap<>();
		//心理危机类学生总数
		int total = studentProfileMapper.psyCrisisSitTotal(semesterYear);
		//心理危机类学生情况
		List<Map> list = studentProfileMapper.psyCrisisSituation(semesterYear);
		resultInfo.put("total",total);
		resultInfo.put("list",list);
		return resultInfo;
	}

	@Override
	public List<Map> psyCrisisAcaDis(String semesterYear) {
		return studentProfileMapper.psyCrisisAcaDis(semesterYear);
	}

	@Override
	public List<Map<String, String>> undergraduateWarnType(String semesterYear) {
		return studentProfileMapper.undergraduateWarnType(semesterYear);
	}

	@Override
	public List<Map<String, String>> undergraduateAcaWarn(String semesterYear) {
		return studentProfileMapper.undergraduateAcaWarn(semesterYear);
	}

	@Override
	public Map<String, Object> academicQueSit(String semesterYear) {
		Map<String, Object> result = new HashMap<>();
		//总数
		result.put("total",studentProfileMapper.getAcademicQueSitNum(semesterYear));
		result.put("list",studentProfileMapper.academicQueSit(semesterYear));
		return result;
	}

	@Override
	public List<Map<String, String>> academicQueAcaDis(String semesterYear) {
		return studentProfileMapper.academicQueAcaDis(semesterYear);
	}

	@Override
	public Map poorSituation(String semesterYear) {
		Map<String, Object> resultInfo = new HashMap<>();
		//贫困生总数
		int total = studentProfileMapper.poorSitTotal(semesterYear);
		//贫困生情况
		List<Map> list = studentProfileMapper.poorSituation(semesterYear);
		resultInfo.put("total",total);
		resultInfo.put("list",list);
		return resultInfo;
	}

	@Override
	public List<Map> poorAcaDis(String semesterYear) {
		return studentProfileMapper.poorAcaDis(semesterYear);
	}

	@Override
	public Map healthWarning(String semesterYear) {
		Map<String, Object> resultInfo = new HashMap<>();
		//身体健康预警总数
		int total = studentProfileMapper.healthWarTotal(semesterYear);
		//身体健康预警情况
		List<Map> list = studentProfileMapper.healthWarning(semesterYear);
		resultInfo.put("total",total);
		resultInfo.put("list",list);
		return resultInfo;
	}

	@Override
	public Map partyDistribute() {
		Map<String, Object> resultInfo = new HashMap<>();
		//学生党员总数
		int total = studentProfileMapper.partyTotal();
		//学生党员概要
		List<Map> list = studentProfileMapper.partyDistribute();
		resultInfo.put("total",total);
		resultInfo.put("list",list);
		return resultInfo;
	}

	@Override
	public List<Map> partyChange() {
		return studentProfileMapper.partyChange();
	}

	@Override
	public List<Map> partyAcademyDis() {
		return studentProfileMapper.partyAcademyDis();
	}

	@Override
	public List<Map> academyStuDis() {
		return studentProfileMapper.academyStuDis();
	}

	@Override
	public Map schoolStructure() {
		Map map = new HashMap<>();
		//(包括留学生)
		//在校生男女
		List<Map<String, String>> gender = studentProfileMapper.schoolGender();
		//在校生民族
		List<Map<String, String>> nation = studentProfileMapper.schoolNation();
		//在校生的宗教信仰
		List<Map<String, String>> religion = studentProfileMapper.schoolReligion();
		//在校生的党员情况
		List<Map<String, String>> party = studentProfileMapper.schoolParty();
		map.put("gender",gender);
		map.put("nation",nation);
		map.put("religion",religion);
		map.put("party",party);
		return map;
	}

	@Override
	public Map<String, Object> undergraduateGrade() {
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> numMap = new HashMap<>();
		//本科生 各学院总人数人数
		numMap.put("educateGradation","本科");
		List<Map> academyNum = studentProfileMapper.academyNum(numMap);
		for (Map m:academyNum){
			Map<String, Object> gradeMap = new HashMap<>();
			gradeMap.put("educateGradation","本科");
			gradeMap.put("academyCode",m.get("academyCode"));
			gradeMap.put("total",m.get("total"));
			List<Map> studentGrade = studentProfileMapper.getStudentGrade(gradeMap);//获取学院本科生年级结构
			m.put("list",studentGrade);
		}
		result.put("studentGrade",academyNum);
		result.put("legend",studentProfileMapper.getStudentGradeLegend());
		return result;
	}

//	@Override
//	public List<Map> undergraduateSex() {
//		Map<String, Object> numMap = new HashMap<>();
//		//本科生 各学院总人数人数
//		numMap.put("educateGradation","本科");
//		List<Map> academyNum = studentProfileMapper.academyNum(numMap);
//		for (Map m:academyNum){
//			Map<String, Object> gradeMap = new HashMap<>();
//			gradeMap.put("educateGradation","本科");
//			gradeMap.put("academyCode",m.get("academyCode"));
//			gradeMap.put("total",m.get("total"));
//			List<Map> studentSex = studentProfileMapper.getStudentSex(gradeMap);//获取学院本科生性别比例
//			m.put("list",studentSex);
//		}
//		return academyNum;
//	}

	@Override
	public List<Map> undergraduateSex() {
		Map<String, Object> sexMap = new HashMap<>();
		sexMap.put("educateGradation","本科");
		List<Map> studentSex = studentProfileMapper.getStudentSex(sexMap);//获取学院本科生性别比例
		return studentSex;
	}


	@Override
	public List<Map> undergraduateNation() {
		Map<String, Object> numMap = new HashMap<>();
		//本科生 各学院总人数人数
		numMap.put("educateGradation","本科");
		List<Map> academyNum = studentProfileMapper.academyNum(numMap);
		for (Map m:academyNum){
			Map<String, Object> nationMap = new HashMap<>();
			nationMap.put("educateGradation","本科");
			nationMap.put("academyCode",m.get("academyCode"));
			nationMap.put("total",m.get("total"));
			List<Map> studentBigNation = studentProfileMapper.getStudentBigNation(nationMap);//获取各学院民族（汉族和少数民族两种）
			List<Map> studentSmallNation = studentProfileMapper.getStudentSmallNation(nationMap);//获取各学院民族（所有民族）
			m.put("bigNationList",studentBigNation);
			m.put("smallNationList",studentSmallNation);
		}
		return academyNum;
	}

	@Override
	public List<Map> undergraduateReligion() {
		Map<String, Object> numMap = new HashMap<>();
		//本科生 各学院总人数人数
		numMap.put("educateGradation","本科");
		List<Map> academyNum = studentProfileMapper.academyNum(numMap);
		for (Map m:academyNum){
			Map<String, Object> religionMap = new HashMap<>();
			religionMap.put("educateGradation","本科");
			religionMap.put("academyCode",m.get("academyCode"));
			religionMap.put("total",m.get("total"));
			List<Map> studentBigReligion = studentProfileMapper.getStudentBigReligion(religionMap);//获取各学院宗教信仰（无宗教信仰和有宗教信仰两种）
			List<Map> studentSmallReligion = studentProfileMapper.getStudentSmallReligion(religionMap);//获取各学院宗教信仰（详细信仰）
			m.put("bigReligionList",studentBigReligion);
			m.put("smallReligionList",studentSmallReligion);
		}
		return academyNum;
	}

	@Override
	public List<Map> undergraduateMajorNum() {
		Map<String, Object> map = new HashMap<>();
		//本科生 各学院专业数
		map.put("educateGradation","本科");
		List<Map> majorNumList = studentProfileMapper.academyMajorNum(map);
		for (Map m:majorNumList){
			Map<String, Object> MajorDetailMap = new HashMap<>();
			MajorDetailMap.put("educateGradation","本科");
			MajorDetailMap.put("academyCode",m.get("academyCode"));
			List<Map> list = studentProfileMapper.getAcademyMajorDetail(MajorDetailMap);//各学院本科专业详情
			m.put("list",list);
		}
		return majorNumList;
	}

	@Override
	public List<Map> undergraduatePeopleNum() {
		Map<String, Object> map = new HashMap<>();
		map.put("educateGradation","本科");
		List<Map> peopleNumList = studentProfileMapper.majorPeopleNum(map);
		return peopleNumList;
	}
}
