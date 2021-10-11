package com.sunmnet.bigdata.web.mapper.student;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentProfileMapper {

	/**
	 *功能描述 在校生分布图
	 * @author lkg
	 * @date 2019/3/1
	 */
	List<Map<String, String>> studentDistribution(@Param(value = "grade") int grade);
	/**
	 *功能描述 在校生学院分布
	 * @author lkg
	 * @date 2019/3/1
	 */
	List<Map<String, String>> collegeDistribution();
	/**
	 *功能描述 本科生学院分布人数
	 * @author lkg
	 * @date 2019/3/1
	 */
	List<Map<String, String>> undergraduateCollegeDist();
	/**
	 *功能描述 本科学院人数TOP5
	 * @author lkg
	 * @date 2019/3/1
	 */
	List<Map<String, String>> undergraduateCollegeTopFive();
	/**
	 *功能描述 本科专业人数TOP5
	 * @author lkg
	 * @date 2019/3/1
	 */
	List<Map<String, String>> undergraduateMajorTopFive();
	/**
	 *功能描述 本科、硕士、博士人数统计
	 * @author lkg
	 * @date 2019/4/17
	 */
	int studentTotal(Map map);

	/**
	 *功能描述 本科生学院下的专业
	 * @author lkg
	 * @date 2019/3/1
	 */
	 List<Map<String, String>> academyMajor(@Param("academyCode") String academyCode);
	 /**
	  *功能描述 本科生学院下的年级
	  * @author lkg
	  * @date 2019/3/1
	  */
	 List<Map<String, String>> academyAnnual(@Param("academyCode")String academyCode);
	 /**
	  *功能描述 本科生学院下的男女
	  * @author lkg
	  * @date 2019/3/1
	  */
	 List<Map<String, String>> academySex(@Param("academyCode")String academyCode);
	 /**
	  *功能描述 本科生学院下的少数民族
	  * @author lkg
	  * @date 2019/3/1
	  */
	 List<Map<String, String>> academyNation(@Param("academyCode")String academyCode);
	 /**
	  *功能描述 本科生学院下的宗教信仰
	  * @author lkg
	  * @date 2019/3/1
	  */
	 List<Map<String, String>> academyReligion(@Param("academyCode")String academyCode);
	 /**
	  *功能描述 在校生男女
	  * @author lkg
	  * @date 2019/7/8
	  */
	 List<Map<String, String>> schoolGender();
	/**
	 *功能描述 在校生民族
	 * @author lkg
	 * @date 2019/7/8
	 */
	 List<Map<String, String>> schoolNation();
	/**
	 *功能描述 在校生的宗教信仰
	 * @author lkg
	 * @date 2019/7/8
	 */
	 List<Map<String, String>> schoolReligion();
	/**
	 *功能描述 在校生的党员情况
	 * @author lkg
	 * @date 2019/7/8
	 */
	 List<Map<String, String>> schoolParty();
	/**
	 *功能描述 硕士/博士生类别
	 * @author lkg
	 * @date 2019/3/4
	 */
	List<Map<String, String>> masterCategory(@Param("educateGradation")String educateGradation);
	/**
	 *功能描述 硕士/博士学院分布
	 * @author lkg
	 * @date 2019/3/4
	 */
	List<Map<String, String>> masterAcademyDis(@Param("educateGradation")String educateGradation);
	/**
	 *功能描述 硕士/博士学科/专业结构
	 * @author lkg
	 * @date 2019/3/4
	 */
	List<Map<String, String>> masterMajorDis(@Param("educateGradation")String educateGradation,@Param("educationDetailType")String educationDetailType);
	/**
	 *功能描述 地域分布
	 * @author lkg
	 * @date 2019/3/4
	 */
	List<Map<String, String>> areaDistribute(@Param("educateGradation")String educateGradation);
	/**
	 *功能描述 在校生校区分布
	 * @author lkg
	 * @date 2019/6/21
	 */
	List<Map<String, String>> schoolDistribute();
	/**
	 *功能描述 foreignCategory
	 * @author lkg
	 * @date 2019/4/10
	 */
	List<Map> foreignCategory();
	/**
	 *功能描述 留学生人数统计
	 * @author lkg
	 * @date 2019/4/17
	 */
	int foreignTotal();
	/**
	 *功能描述 留学生世界区域分布
	 * @author lkg
	 * @date 2019/4/10
	 */
	List<Map> foreignArea();
	/**
	 *功能描述 留学生学院分布
	 * @author lkg
	 * @date 2019/4/10
	 */
	List<Map> foreignAcademyDistribute();
	/**
	 *功能描述 留学生分布
	 * @author lkg
	 * @date 2019/3/4
	 */
	List<Map<String, String>> foreignDistribute();
	/**
	 *功能描述 本科生/研究生学籍异常分析
	 * @author lkg
	 * @date 2019/4/11
	 */
	List<Map<String, String>> anomalyNum(@Param("educateGradation")String educateGradation);
	/**
	 *功能描述 本科生/研究生学籍异常总人数
	 * @author lkg
	 * @date 2019/4/17
	 */
	int anomalyTotal(@Param("educateGradation")String educateGradation);
	/**
	 *功能描述 本科生/研究生 学籍异常类型 学生学院分布-
	 * @author lkg
	 * @date 2019/4/11
	 */
	List<Map<String, String>> anomalyAcademyNum(@Param("educateGradation")String educateGradation);

	/**
	 *功能描述 心理危机类学生情况
	 * @author lkg
	 * @date 2019/7/29
	 */
	List<Map> psyCrisisSituation(@Param("semesterYear")String semesterYear);
	/**
	 *功能描述 心理危机类学生总数
	 * @author lkg
	 * @date 2019/7/30
	 */
	int psyCrisisSitTotal(@Param("semesterYear")String semesterYear);
	/**
	 *功能描述 心理危机学生学院分布
	 * @author lkg
	 * @date 2019/7/29
	 */
	List<Map> psyCrisisAcaDis(@Param("semesterYear")String semesterYear);
	/**
	 *功能描述 重点关注学生：本科生学业预警类型
	 * @author lkg
	 * @date 2019/6/27
	 */
	List<Map<String, String>> undergraduateWarnType(@Param("semesterYear")String semesterYear);
	/**
	 *功能描述 重点关注学生：学业学分预警学生学院分布
	 * @author lkg
	 * @date 2019/6/27
	 */
	List<Map<String, String>> undergraduateAcaWarn(@Param("semesterYear")String semesterYear);
	/**
	 *功能描述 重点关注学生：学业问题类学生总数
	 * @author lkg
	 * @date 2019/6/27
	 */
	int getAcademicQueSitNum(@Param("semesterYear")String semesterYear);
	/**
	 *功能描述 重点关注学生：学业问题类学生情况
	 * @author lkg
	 * @date 2019/6/27
	 */
	List<Map<String, String>> academicQueSit(@Param("semesterYear")String semesterYear);
	/**
	 *功能描述 重点关注学生：学业问题类学生学院分布
	 * @author lkg
	 * @date 2019/6/27
	 */
	List<Map<String, String>> academicQueAcaDis(@Param("semesterYear")String semesterYear);
	/**
	 *功能描述 重点关注学生：贫困生情况
	 * @author lkg
	 * @date 2019/7/29
	 */
	List<Map> poorSituation(@Param("semesterYear")String semesterYear);
	/**
	 *功能描述 重点关注学生：贫困生总数
	 * @author lkg
	 * @date 2019/7/30
	 */
	int poorSitTotal(@Param("semesterYear")String semesterYear);
	/**
	 *功能描述 重点关注学生：贫困生学院分布
	 * @author lkg
	 * @date 2019/7/29
	 */
	List<Map> poorAcaDis(@Param("semesterYear")String semesterYear);
	/**
	 *功能描述 重点关注学生：身体健康预警总数
	 * @author lkg
	 * @date 2019/7/30
	 */
	int healthWarTotal(@Param("semesterYear")String semesterYear);
	/**
	 *功能描述 重点关注学生：身体健康预警情况
	 * @author lkg
	 * @date 2019/7/29
	 */
	List<Map> healthWarning(@Param("semesterYear")String semesterYear);
	/**
	 *功能描述 学生党员概要
	 * @author lkg
	 * @date 2019/6/20
	 */
	List<Map> partyDistribute();
	/**
	 *功能描述 学生党员总数
	 * @author lkg
	 * @date 2019/6/20
	 */
	int partyTotal();
	/**
	 *功能描述 近五年学生党员人数变化
	 * @author lkg
	 * @date 2019/6/20
	 */
	List<Map> partyChange();
	/**
	 *功能描述 学生党员学院分布
	 * @author lkg
	 * @date 2019/6/20
	 */
	List<Map> partyAcademyDis();
	/**
	 *功能描述 各学院人数
	 * @author lkg
	 * @date 2019/6/21
	 */
	List<Map> academyStuDis();
	/**
	 *功能描述 各学院人数
	 * @author lkg
	 * @date 2019/6/23
	 */
	List<Map> academyNum(Map map);
	/**
	 *功能描述 各学院年级结构对比
	 * @author lkg
	 * @date 2019/6/23
	 */
	List<Map> getStudentGrade(Map map);
	/**
	 * @Description 各学院年级结构对比-图例
	 * @author linjl
	 * @date 2019/8/12
	 */
	List<String> getStudentGradeLegend();
	/**
	 *功能描述 各学院性别比例
	 * @author lkg
	 * @date 2019/6/23
	 */
	List<Map> getStudentSex(Map map);
	/**
	 *功能描述 各学院民族（汉族和少数民族两种）分布情况
	 * @author lkg
	 * @date 2019/6/23
	 */
	List<Map> getStudentBigNation(Map map);
	/**
	 *功能描述 各学院民族（所有民族）分布情况
	 * @author lkg
	 * @date 2019/6/23
	 */
	List<Map> getStudentSmallNation(Map map);
	/**
	 *功能描述 各学院宗教信仰（无宗教信仰和有宗教信仰两种）分布情况
	 * @author lkg
	 * @date 2019/6/23
	 */
	List<Map> getStudentBigReligion(Map map);
	/**
	 *功能描述 各学院宗教信仰（详细信仰）分布情况
	 * @author lkg
	 * @date 2019/6/23
	 */
	List<Map> getStudentSmallReligion(Map map);
	/**
	 *功能描述 各学院本科专业数量
	 * @author lkg
	 * @date 2019/6/23
	 */
	List<Map> academyMajorNum(Map map);
	/**
	 *功能描述 各学院本科专业详情
	 * @author lkg
	 * @date 2019/7/8
	 */
	List<Map> getAcademyMajorDetail(Map map);
	/**
	 *功能描述 各本科专业人数
	 * @author lkg
	 * @date 2019/6/23
	 */
	List<Map> majorPeopleNum(Map map);
}