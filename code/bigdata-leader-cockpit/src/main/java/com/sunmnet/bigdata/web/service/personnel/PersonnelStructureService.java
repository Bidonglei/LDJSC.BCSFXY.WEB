package com.sunmnet.bigdata.web.service.personnel;

import com.sunmnet.bigdata.web.model.request.personnel.NewcomersREQ;
import com.sunmnet.bigdata.web.model.request.personnel.TeacherBoxREQ;
import com.sunmnet.bigdata.web.model.request.personnel.TeacherInfoREQ;
import com.sunmnet.bigdata.web.model.response.personnel.QueryStaffStructureResponse;

import java.util.List;
import java.util.Map;

/**
 * @author sunmnet-gf
 * @ClassName: ${type_name}
 * @Description: ${todo}
 * @date 2018/12/26/026
 * ${tags}
 */
public interface PersonnelStructureService {
    Object listCountInfo(TeacherInfoREQ teacherInfoREQ);
	/**
	 *功能描述 各单位人员编制结构
	 * @author lkg
	 * @date 2019/6/26
	 */
	List<Map> personBigType();
	/**
	 *功能描述 各单位年龄结构对比(事业编制)
	 * @author lkg
	 * @date 2019/6/26
	 */
	List<Map> personAgeType();
	/**
	 *功能描述 各单位男女比例(事业编制)
	 * @author lkg
	 * @date 2019/6/26
	 */
	List<Map> personSexType();
	/**
	 *功能描述 各单位职称情况(事业编制)
	 * @author lkg
	 * @date 2019/6/26
	 */
	List<Map> personJobTitleType();
	/**
	 *功能描述 各单位党员分布情况(事业编制)
	 * @author lkg
	 * @date 2019/6/26
	 */
	List<Map> personPartyType();
	/**
	 * @Description 人员结构扇形图
	 * @author linjl
	 * @date 2019/7/18
	 */
    Object listTeacherInfoByParam(TeacherInfoREQ teacherInfoREQ);

    Object distributionOfTitlesInEachCollege(TeacherInfoREQ teacherInfoREQ);

    Object listAcademicDistribution(TeacherInfoREQ teacherInfoREQ);

    Object listAcademicAge(TeacherInfoREQ teacherInfoREQ);

    List<Map> listTeacherInfoByName(TeacherBoxREQ teacherBoxREQ);

    List<Map> listTopTalentsInfoByName(TeacherBoxREQ teacherBoxREQ);
	/**
	 * @Description 人员结构:编制类别
	 * @author linjl
	 * @date 2019/7/18
	 */
	List<QueryStaffStructureResponse> staffStructure();
	/**
	 * @Description 人员结构:单位类型
	 * @author linjl
	 * @date 2019/7/18
	 */
	List<Map> listDepartmentTypeAll();

	Object distributionOfTitles();

	Object learningEdgeDistribution();

	List<Map> ageAndAcademicStructure();
	/**
	 *功能描述 年龄段与学科映射图
	 * @author lkg
	 * @date 2019/7/8
	 */
	List<Map> ageAndSubjectStructure();

	List<Map> academicAndAgeBoxLine();

	Map<String, Object> academicAndSubject();
	/**
	 *功能描述 各学院学科分布情况
	 * @author lkg
	 * @date 2019/6/24
	 */
	List<Map> academySubjectDis();
	/**
	 *功能描述 各学科支持学院情况
	 * @author lkg
	 * @date 2019/6/24
	 */
	List<Map> subjectAcademyDis();

//	Map<String, Object> subjectTopFive();
	/**
	 *功能描述 学科中 高端人才数量
	 * @author lkg
	 * @date 2019/6/26
	 */
	List<Map> subjectTalent();
	/**
	 *功能描述 学科中 高级职称占比
	 * @author lkg
	 * @date 2019/6/26
	 */
	List<Map> subjectHighTitle();
	/**
	 *功能描述 学科中 总人数
	 * @author lkg
	 * @date 2019/6/26
	 */
	List<Map> subjectAll();

    /**
     * @Description 新进人员统计图
     * @author linjl
     * @date 2019/4/16
     */
    Map<String, Object> listNewcomersAll(NewcomersREQ req);

    /**
     * @Description 本校学缘人员
     * @author linjl
     * @date 2019/4/16
     */
    List<Map<String,String>> listNewcomersInSchool(NewcomersREQ req);
    /**
     * @Description 非博士学历人员
     * @author linjl
     * @date 2019/4/16
     */
    List<Map<String,String>> listNewcomersNotDoctor(NewcomersREQ req);
    /**
     * @Description 海外学缘人员
     * @author linjl
     * @date 2019/4/16
     */
    List<Map<String,String>> listNewcomersOverseas(NewcomersREQ req);
}
