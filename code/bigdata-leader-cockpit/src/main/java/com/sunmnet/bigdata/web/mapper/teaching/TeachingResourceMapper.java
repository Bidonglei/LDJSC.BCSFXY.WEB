/**
 * TeacherInfoMapper.java
 * 三盟科技
 * @date 2018-08-27
*/
package com.sunmnet.bigdata.web.mapper.teaching;

import com.sunmnet.bigdata.common.request.BasePageRequest;
import com.sunmnet.bigdata.web.model.request.teaching.GraduateCourseREQ;
import com.sunmnet.bigdata.web.model.request.teaching.GraduateTeacherPageREQ;
import com.sunmnet.bigdata.web.model.request.teaching.TeachingTeamREQ;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *功能描述 教学资源
 * @author lkg
 * @date 2019/5/21
 * @param 
 * @return 
 */
public interface TeachingResourceMapper
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
     *功能描述 学院专任教师数量
     * @author lkg
     * @date 2019/5/22
     */
    int fullTeacherNum(@Param(value = "academyCode") String academyCode);
	/**
	 *功能描述 学院教师职称结构
	 * @author lkg
	 * @date 2019/5/22
	 */
	List<Map> titleNum(@Param(value = "academyCode") String academyCode);
	/**
	 *功能描述 学院学历结构
	 * @author lkg
	 * @date 2019/5/22
	 */
	List<Map> educationNum(@Param(value = "academyCode") String academyCode);
	/**
	 *功能描述 学院年龄结构
	 * @author lkg
	 * @date 2019/5/22
	 */
	List<Map> ageNum(@Param(value = "academyCode") String academyCode);
	/**
	 *功能描述 学缘结构
	 * @author lkg
	 * @date 2019/5/22
	 */
	List<Map> marginNum(@Param(value = "academyCode") String academyCode);

	/**
	 *功能描述 研究生导师分布情况
	 * @author lkg
	 * @date 2019/5/22
	 */
	List<Map> graduateTeaDis();
	/**
	 *功能描述 研究生职称结构
	 * @author lkg
	 * @date 2019/5/22
	 */
	List<Map> graduateJob(@Param(value = "academyCode") String academyCode);
	/**
	 *功能描述 研究生年龄结构
	 * @author lkg
	 * @date 2019/5/22
	 */
	List<Map> graduateAge(@Param(value = "academyCode") String academyCode);
	/**
	 *功能描述 研究生学历结构
	 * @author lkg
	 * @date 2019/5/22
	 */
	List<Map> graduateEducation(@Param(value = "academyCode") String academyCode);
	/**
	 *功能描述 研究生性别结构
	 * @author lkg
	 * @date 2019/5/22
	 */
	List<Map> graduateSex(@Param(value = "academyCode") String academyCode);
	/**
	 *功能描述 研究生导师指导学生情况
	 * @author lkg
	 * @date 2019/5/22
	 */
	List<Map> graduateTeacherPage(GraduateTeacherPageREQ graduateTeacherPageREQ);
	/**
	 * @Description 近三年导师指导学生人数情况
	 * @author linjl
	 * @date 2019/5/30
	 */
	List<Map> listTutorGuideStudent(@Param(value = "type") String type);
	/**
	 *功能描述 本科生专业分布（学院-专业）
	 * @author lkg
	 * @date 2019/5/22
	 */
	List<Map> undergraduateAcademyMajor();
	/**
	 *功能描述 本科生专业分布统计信息
	 * @author lkg
	 * @date 2019/7/18
	 */
	List<Map> underAcaMajSta();
	/**
	 *功能描述 本科生专业大类分布（专业大类-专业）
	 * @author lkg
	 * @date 2019/5/22
	 */
	List<Map> undergraduateLargeMajor();
	/**
	 *功能描述 本科生专业大类分布统计信息
	 * @author lkg
	 * @date 2019/7/18
	 */
	List<Map> underLarMajSta();
	/**
	 *功能描述 研究生学科分布（学院-学科）
	 * @author lkg
	 * @date 2019/5/22
	 */
	List<Map> graduateAcademySubject();
	/**
	 *功能描述 研究生学科分布统计信息
	 * @author lkg
	 * @date 2019/7/18
	 */
	List<Map> graduateAcaSubSta();
	/**
	 *功能描述 研究生学科分布（学院--专业）
	 * @author lkg
	 * @date 2019/5/22
	 */
	List<Map> graduateAcademyMajor();
	/**
	 *功能描述 研究生学科分布（学院-专业）统计信息
	 * @author lkg
	 * @date 2019/7/18
	 */
	List<Map> graduateAcaMajSta();

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
	List<Map> undergraduateOpenCourse(@Param(value = "annual") String annual);
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
	List<Map> undergraduateFicCouPage(BasePageRequest basePageRequest);
	/**
	 *功能描述 国家精品在线开放课程
	 * @author lkg
	 * @date 2019/5/23
	 */
	List<Map> undergraduateBouCouPage(BasePageRequest basePageRequest);
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
	List<Map> graduateCourseStr();
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
	 * @Description 研究生学院课程分类
	 * @author linjl
	 * @date 2019/9/16
	 */
	List<Map> graduateOneCourse(GraduateCourseREQ req);
	/**
	 * @Description 研究生课程结构-图例
	 * @author linjl
	 * @date 2019/9/16
	 */
	List<String> getGraduateCourseLegend(GraduateCourseREQ req);
}