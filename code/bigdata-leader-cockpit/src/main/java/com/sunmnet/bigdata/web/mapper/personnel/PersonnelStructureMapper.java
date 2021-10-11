package com.sunmnet.bigdata.web.mapper.personnel;

import com.sunmnet.bigdata.web.model.request.personnel.NewcomersREQ;
import com.sunmnet.bigdata.web.model.request.personnel.TeacherBoxREQ;
import com.sunmnet.bigdata.web.model.request.personnel.TeacherInfoREQ;
import com.sunmnet.bigdata.web.model.response.personnel.QueryAcademyAndSubjectResponse;
import com.sunmnet.bigdata.web.model.response.personnel.QueryStaffStructureResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author sunmnet-gf
 * @ClassName: ${type_name}
 * @Description: ${todo}
 * @date 2018/12/26/026
 * ${tags}
 */
public interface PersonnelStructureMapper {
    Map listCountInfo(TeacherInfoREQ teacherInfoREQ);
	/**
	 *功能描述 人员结构：各单位人数
	 * @author lkg
	 * @date 2019/6/26
	 */
	List<Map> departmentNum(Map map);
	/**
	 *功能描述 人员结构：各单位人员编制结构
	 * @author lkg
	 * @date 2019/6/26
	 */
	List<Map> getPersonBigType(Map map);
	/**
	 *功能描述 人员结构：各单位年龄结构对比(事业编制)
	 * @author lkg
	 * @date 2019/6/26
	 */
	List<Map> getAgeType(Map map);
	/**
	 *功能描述 人员结构：各单位男女比例(事业编制)
	 * @author lkg
	 * @date 2019/6/26
	 */
	List<Map> getSexType(Map map);
	/**
	 *功能描述 人员结构：各单位职称情况(事业编制)
	 * @author lkg
	 * @date 2019/6/26
	 */
	List<Map> getJobTitleType(Map map);
	/**
	 *功能描述 人员结构：各单位党员分布情况(事业编制)
	 * @author lkg
	 * @date 2019/6/26
	 */
	List<Map> getPartyType(Map map);
	/**
	 * @Description 人员结构扇形:年龄
	 * @author linjl
	 * @date 2019/7/18
	 */
	List<Map> listAge(TeacherInfoREQ teacherInfoREQ);
	/**
	 * @Description 人员结构扇形:职称
	 * @author linjl
	 * @date 2019/7/18
	 */
	List<Map<String,String>> listJobTitle(TeacherInfoREQ teacherInfoREQ);
	/**
	 * @Description 人员结构扇形:学缘
	 * @author linjl
	 * @date 2019/7/18
	 */
    List<Map<String,String>> listLearningEdge(TeacherInfoREQ teacherInfoREQ);
	/**
	 * @Description 人员结构扇形:学历
	 * @author linjl
	 * @date 2019/7/18
	 */
    List<Map<String,String>> listEducation(TeacherInfoREQ teacherInfoREQ);
	/**
	 * @Description 人员结构扇形:男女比例
	 * @author linjl
	 * @date 2019/7/18
	 */
    List<Map<String,String>> listTeacherGender(TeacherInfoREQ teacherInfoREQ);
	/**
	 * @Description 人员结构扇形:政治面貌
	 * @author linjl
	 * @date 2019/7/18
	 */
    List<Map<String,String>> listPoliticalStatus(TeacherInfoREQ teacherInfoREQ);

    List<Map> distributionOfTitlesInEachCollege(TeacherInfoREQ teacherInfoREQ);

    List<Map> listAcademicDistribution(TeacherInfoREQ teacherInfoREQ);

    List<Map> listAcademicAge(TeacherInfoREQ teacherInfoREQ);

    List<Map> listTeacherInfoByName(TeacherBoxREQ teacherBoxREQ);

    List<Map> listTopTalentsInfoByName(TeacherBoxREQ teacherBoxREQ);
	/**
	 * @Description 人员结构扇形:岗位结构
	 * @author linjl
	 * @date 2019/7/18
	 */
    List<Map> listPost(TeacherInfoREQ teacherInfoREQ);
	/**
	 * @Description 人员结构扇形:薪级
	 * @author linjl
	 * @date 2019/7/18
	 */
    List<Map> listSalary(TeacherInfoREQ teacherInfoREQ);
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

	Map distributionOfTitles(@Param(value = "academyName") String academyName);

	Map learningEdgeDistribution(@Param(value = "academyName") String academyName);

	List<Map> ageAndAcademicStructure();
	/**
	 *功能描述 年龄段与学科映射图
	 * @author lkg
	 * @date 2019/7/8
	 */
	List<Map> ageAndSubjectStructure();

	List<Map> academicAndAgeBoxLine();
	/**
	 *功能描述 大于58学院人数
	 * @author lkg
	 * @date 2019/6/24
	 */
	int academicBigAgeNum(@Param(value = "academyName") String academyName);
	/**
	 *功能描述 大于58人数占比
	 * @author lkg
	 * @date 2019/6/24
	 */
	double academicBigAgeRate(@Param(value = "academyName") String academyName,@Param(value = "num") int num);

	List<QueryAcademyAndSubjectResponse> academicAndSubject();

	List<Map> getSubjectNum();
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

	List<Map> subjectTalentList();

	List<Map> subjectHighTitleList();

	List<Map> subjectAllList();

	/**
	 * @Description 新进人员统计图
	 * @author linjl
	 * @date 2019/4/16
	 */
	List<Map<String,String>> listNewcomersAll(NewcomersREQ req);

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
