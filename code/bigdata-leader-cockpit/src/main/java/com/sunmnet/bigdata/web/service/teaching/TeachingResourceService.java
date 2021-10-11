package com.sunmnet.bigdata.web.service.teaching;

import com.github.pagehelper.PageInfo;
import com.sunmnet.bigdata.common.request.BasePageRequest;
import com.sunmnet.bigdata.web.model.request.teaching.GraduateCourseREQ;
import com.sunmnet.bigdata.web.model.request.teaching.GraduateTeacherPageREQ;

import java.util.List;
import java.util.Map;

/**
 *功能描述 教学资源
 * @author lkg
 * @date 2019/5/21
 */
public interface TeachingResourceService
{
	/**
	 *功能描述 师资趋势
	 * @author lkg
	 * @date 2019/5/21
	 */
	List<Map> teacherTrend();
	/**
	 *功能描述
	 * @author lkg
	 * @date 2019/5/21
	 */
	List<Map> academyTeachingSituation();
	/**
	 *功能描述 各学院聘用老师类型
	 * @author lkg
	 * @date 2019/6/23
	 */
	List<Map> academyTeacherType();
	/**
	 *功能描述 专任教师结构分析
	 * @author lkg
	 * @date 2019/5/22
	 */
	Map fullTeacherStruct(String academyCode);
	/**
	 *功能描述 研究生导师分布情况
	 * @author lkg
	 * @date 2019/5/22
	 */
	List<Map> graduateTeaDis();
	/**
	 *功能描述 研究生导师结构分析
	 * @author lkg
	 * @date 2019/5/22
	 */
	Map graduateTeaStruct(String academyCode);
	/**
	 *功能描述 研究生导师指导学生情况
	 * @author lkg
	 * @date 2019/5/22
	 */
	PageInfo<Map> graduateTeacherPage(GraduateTeacherPageREQ graduateTeacherPageREQ);
	/**
	 * @Description 近三年导师指导学生人数情况
	 * @author linjl
	 * @date 2019/5/30
	 */
	List<Map> listTutorGuideStudent(String type);
	/**
	 *功能描述 本科生专业分布（学院-专业）
	 * @author lkg
	 * @date 2019/5/22
	 */
	Map undergraduateAcademyMajor();
	/**
	 *功能描述 本科生专业大类分布（专业大类-专业）
	 * @author lkg
	 * @date 2019/5/22
	 */
	Map undergraduateLargeMajor();
	/**
	 *功能描述 研究生学科分布（学院-学科）
	 * @author lkg
	 * @date 2019/5/22
	 */
	Map graduateAcademySubject();
	/**
	 *功能描述 研究生学科分布（学院--专业）
	 * @author lkg
	 * @date 2019/5/22
	 */
	Map graduateAcademyMajor();

	/**
	 *功能描述 本科课程结构分布
	 * @author lkg
	 * @date 2019/5/23
	 */
	List<Map> undergraduateCourseStruct();
	/**
	 *功能描述 全校开设课程
	 * @author lkg
	 * @date 2019/5/23
	 */
	List<Map> undergraduateOpenCourse(String annual);
	/**
	 *功能描述 优质课程资源建设
	 * @author lkg
	 * @date 2019/5/23
	 */
	List<Map> undergraduateQualityCourse();
	/**
	 *功能描述 国家虚拟仿真实验教学项目
	 * @author lkg
	 * @date 2019/5/23
	 */
	PageInfo<Map> undergraduateFicCouPage(BasePageRequest basePageRequest);
	/**
	 *功能描述 国家精品在线开放课程
	 * @author lkg
	 * @date 2019/5/23
	 */
	PageInfo<Map> undergraduateBouCouPage(BasePageRequest basePageRequest);
	/**
	 *功能描述 在线开放课程表
	 * @author lkg
	 * @date 2019/5/23
	 */
	List<Map> undergraduateOnlineCourse();
	/**
	 *功能描述 最近研究生课程结构分布
	 * @author lkg
	 * @date 2019/5/23
	 */
	List<Map> graduateLatestCouStr(GraduateCourseREQ req);
	/**
	 *功能描述 历年研究生课程结构分布
	 * @author lkg
	 * @date 2019/5/23
	 */
	Map<String,Object> graduateCourseStr();
	/**
	 *功能描述 研究生累计优质课程
	 * @author lkg
	 * @date 2019/5/23
	 */
	List<Map> graduateTotalQualityCou();
	/**
	 *功能描述 历年研究生优质课程
	 * @author lkg
	 * @date 2019/5/23
	 */
	List<Map> graduateQualityCourse();
	/**
	 *功能描述 一级学科分类
	 * @author lkg
	 * @date 2019/5/23
	 */
	Map<String,Object> graduateOneCourse(GraduateCourseREQ req);
}
