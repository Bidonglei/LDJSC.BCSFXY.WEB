package com.sunmnet.bigdata.web.service.student;

import com.sunmnet.bigdata.web.model.entity.student.MasterStructRequest;

import java.util.List;
import java.util.Map;

/**
 *功能描述 学生概况
 * @author lkg
 * @date 2019/3/5
 */
public interface StudentProfileService {




	/**
	 *功能描述 在校生分布图
	 * @author lkg
	 * @date 2019/3/1
	 */
	List<Map<String, String>> studentDistribution();
	/**
	 *功能描述 在校生学院分布
	 * @author lkg
	 * @date 2019/3/1
	 */
	List<Map<String, String>> collegeDistribution();
	/**
	 *功能描述 本科生结构
	 * @author lkg
	 * @date 2019/3/1
	 */
	Map<String, Object> undergraduateStructure();
	/**
	 *功能描述 本科生结构：专业结构，年级结构，性别结构
	 * @author lkg
	 * @date 2019/3/1
	 */
	Map<String, List<Map<String, String>>> undergraduateColDet(String academyCode);
	/**
	 *功能描述 硕士/博士生结构：研究生类别，学院分布，学科结构
	 * @author lkg
	 * @date 2019/3/4
	 */
	Map<String, Object> masterStruct(MasterStructRequest masterStructRequest);
	/**
	 *功能描述 地域分布
	 * @author lkg
	 * @date 2019/3/4
	 */
	List<Map<String, String>> areaDistribute(String type);
	/**
	 *功能描述 foreignCategory
	 * @author lkg
	 * @date 2019/4/10
	 */
	Map<String,Object> foreignCategory();
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
	Map<String,Object> anomalyNum(String educateGradation);
	/**
	 *功能描述 本科生/研究生 学籍异常类型 学生学院分布-
	 * @author lkg
	 * @date 2019/4/11
	 */
	List<Map<String, String>> anomalyAcademyNum(String educateGradation);
	/**
	 *功能描述 重点关注学生：心理危机类学生情况
	 * @author lkg
	 * @date 2019/7/29
	 */
	Map psyCrisisSituation(String semesterYear);
	/**
	 *功能描述 重点关注学生：心理危机学生学院分布
	 * @author lkg
	 * @date 2019/7/29
	 */
	List<Map> psyCrisisAcaDis(String semesterYear);
	/**
	 *功能描述 重点关注学生：本科生学业预警类型
	 * @author lkg
	 * @date 2019/6/27
	 */
	List<Map<String, String>> undergraduateWarnType(String semesterYear);
	/**
	 *功能描述 重点关注学生：学业学分预警学生学院分布
	 * @author lkg
	 * @date 2019/6/27
	 */
	List<Map<String, String>> undergraduateAcaWarn(String semesterYear);
	/**
	 *功能描述 重点关注学生：学业问题类学生情况
	 * @author lkg
	 * @date 2019/6/27
	 */
	Map<String, Object> academicQueSit(String semesterYear);
	/**
	 *功能描述 重点关注学生：学业问题类学生学院分布
	 * @author lkg
	 * @date 2019/6/27
	 */
	List<Map<String, String>> academicQueAcaDis(String semesterYear);
	/**
	 *功能描述 重点关注学生：贫困生情况
	 * @author lkg
	 * @date 2019/7/29
	 */
	Map poorSituation(String semesterYear);
	/**
	 *功能描述 重点关注学生：贫困生学院分布
	 * @author lkg
	 * @date 2019/7/29
	 */
	List<Map> poorAcaDis(String semesterYear);
	/**
	 *功能描述 重点关注学生：身体健康预警情况
	 * @author lkg
	 * @date 2019/7/29
	 */
	Map healthWarning(String semesterYear);
	/**
	 *功能描述 学生党员概要
	 * @author lkg
	 * @date 2019/6/20
	 */
	Map partyDistribute();
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
	 *功能描述 在校生结构
	 * @author lkg
	 * @date 2019/7/8
	 */
	Map schoolStructure();
	/**
	 *功能描述 本科生 各学院年级结构对比
	 * @author lkg
	 * @date 2019/6/23
	 */
	Map<String, Object> undergraduateGrade();
	/**
	 *功能描述  本科生 各学院性别比例
	 * @author lkg
	 * @date 2019/6/23
	 */
	List<Map> undergraduateSex();
	/**
	 *功能描述  本科生 各学院民族分布情况
	 * @author lkg
	 * @date 2019/6/23
	 */
	List<Map> undergraduateNation();
	/**
	 *功能描述  本科生 各学院信仰分布情况
	 * @author lkg
	 * @date 2019/6/23
	 */
	List<Map> undergraduateReligion();
	/**
	 *功能描述 各学院本科专业数量
	 * @author lkg
	 * @date 2019/6/23
	 */
	List<Map> undergraduateMajorNum();
	/**
	 *功能描述 各本科专业人数
	 * @author lkg
	 * @date 2019/6/23
	 */
	List<Map> undergraduatePeopleNum();
}
