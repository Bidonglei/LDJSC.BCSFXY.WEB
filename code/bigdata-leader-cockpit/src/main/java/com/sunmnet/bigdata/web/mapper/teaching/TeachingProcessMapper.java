package com.sunmnet.bigdata.web.mapper.teaching;

import com.sunmnet.bigdata.common.request.BasePageRequest;
import com.sunmnet.bigdata.web.model.request.teaching.DoctorMoreThanYearsREQ;
import com.sunmnet.bigdata.web.model.request.teaching.TeachingProcessREQ;
import com.sunmnet.bigdata.web.model.response.teaching.DoctorMoreThanYearsRES;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description 教学域-教学过程
 * @author linjl
 * @date 2019/5/21
 */
public interface TeachingProcessMapper {

    /**
     * @Description 教授授课率:教授授课情况
     * @author linjl
     * @date 2019/5/21
     */
    List<Map<String, String>> listProfessorTeachingSituation(TeachingProcessREQ req);

    /**
     * @Description 教授授课率:副教授授课情况
     * @author linjl
     * @date 2019/5/21
     */
    List<Map<String, String>> listAssociateTeachingSituation(TeachingProcessREQ req);

    /**
     * @Description 教授授课率:教授授课学时情况
     * @author linjl
     * @date 2019/5/21
     */
    List<Map<String, Object>> listProfessorTeachingHours(TeachingProcessREQ req);

    /**
     * @Description 学业进度:本科生学业进度情况
     * @author linjl
     * @date 2019/5/21
     */
    List<Map<String, Object>> listUndergraduatesProgressCredit(TeachingProcessREQ req);

    /**
     * @Description 学业进度:本科生学业进度情况-扇形图
     * @author linjl
     * @date 2019/5/21
     */
    List<Map<String, Object>> listUndergraduatesProgress(TeachingProcessREQ req);

    /**
     * @Description 学业进度:硕士生学业进度情况
     * @author linjl
     * @date 2019/5/21
     */
    List<Map<String, Object>> listMasterProgressCredit(TeachingProcessREQ req);

    /**
     * @Description 学业进度:硕士生学业进度情况-扇形图
     * @author linjl
     * @date 2019/5/21
     */
    List<Map<String, Object>> listMasterProgress(TeachingProcessREQ req);
    /**
     *功能描述 超过学习年限人数
     * @author lkg
     * @date 2019/7/31
     */
    int getSchoolingYearsTotal(Map map);

    /**
     * @Description 学习年限:本科生学习年限情况
     * @author linjl
     * @date 2019/5/22
     */
    List<Map<String, Object>> getUndergraduateSchoolingYears();
    /**
     * @Description 学习年限:硕士生学习年限情况
     * @author linjl
     * @date 2019/5/22
     */
    List<Map<String, Object>> getMasterSchoolingYears();
    /**
     * @Description 学习年限:博士生学习年限情况
     * @author linjl
     * @date 2019/5/22
     */
    List<Map<String, Object>> getDoctorSchoolingYears();
    /**
     * @Description 学习年限:本科生学习年限超过4年人数
     * @author linjl
     * @date 2019/5/22
     */
    List<Map<String, Object>> listUndergraduateThanFourYears();
    /**
     * @Description 学习年限:硕士生学习年限延期/超期情况
     * @author linjl
     * @date 2019/5/22
     */
    List<Map<String, Object>> listMasterMoreThanYears();
    /**
     * @Description 学习年限:博士生学习年限延期/超期情况
     * @author linjl
     * @date 2019/5/22
     */
    List<Map<String, Object>> listDoctorMoreThanYears();
    /**
     * @Description 学习年限:博士延期/超期详细信息
     * @author linjl
     * @date 2019/6/19
     */
    List<DoctorMoreThanYearsRES> listDoctorMoreThanYearsDetail(DoctorMoreThanYearsREQ req);
    /**
     * @Description 学习年限:本科生各年级学生毕业率
     * @author linjl
     * @date 2019/5/22
     */
    List<Map<String, Object>> listUndergraduateRatioByGrade();
    /**
     * @Description 学习年限:各学院毕业情况
     * @author linjl
     * @date 2019/5/22
     */
    List<Map<String, Object>> listUndergraduateRatioByAcademy(TeachingProcessREQ req);
    /**
     * @Description 学习年限:博士毕业占比情况
     * @author linjl
     * @date 2019/5/22
     */
    List<Map<String, Object>> listDoctorRatioByAcademy(TeachingProcessREQ req);
    /**
     * @Description 选课情况:课程贡献率
     * @author linjl
     * @date 2019/5/22
     */
    List<Map<String, Object>> listCourseContribution(TeachingProcessREQ req);
    /**
     * @Description 选课情况:课程开放度
     * @author linjl
     * @date 2019/5/22
     */
    List<Map<String, Object>> listCourseOpenness(TeachingProcessREQ req);
    /**
     * @Description 本科实践教学:国家级大学生创新创业训练计划项目
     * @author linjl
     * @date 2019/5/22
     */
    List<Map<String, Object>> listInnovativeTrainingProgram(TeachingProcessREQ req);
    /**
     * @Description 本科实践教学:大创项目扇形图
     * @author linjl
     * @date 2019/5/22
     */
    List<Map<String, Object>> listInnovativeTrainingProgramSector(TeachingProcessREQ req);
    /**
     * @Description 本科实践教学:“高峰体验计划”项目
     * @author linjl
     * @date 2019/5/22
     */
    List<Map<String, Object>> listPeakExperienceProgram(TeachingProcessREQ req);
    /**
     * @Description 本科毕设:选题来源情况
     * @author linjl
     * @date 2019/5/22
     */
    List<Map<String, Object>> listSelectedTopic(TeachingProcessREQ req);

    /**
     * @Description 本科毕设:跨专业选题情况
     * @author linjl
     * @date 2019/5/23
     */
    List<Map<String, Object>> listInterdisciplinaryTopic(TeachingProcessREQ req);

    /**
     * @Description 研究生论文:论文及答辩质量
     * @author linjl
     * @date 2019/5/23
     */
    List<Map<String, String>> listThesisDefenseQuality(TeachingProcessREQ req);
    /**
     *功能描述 总的论文及答辩质量
     * @author lkg
     * @date 2019/7/19
     */
    List<Map<String, String>> thesisDefenseQualityAll(TeachingProcessREQ req);

    /**
     * @Description 研究生论文:优秀研究生论文
     * @author linjl
     * @date 2019/5/23
     */
    List<Map<String, Object>> listExcellentPostgraduateThesis(TeachingProcessREQ req);

    /**
     * @Description 研究生论文:学术论文成果分布
     * @author linjl
     * @date 2019/5/23
     */
    List<Map<String, Object>> listAcademicPaperAchievements(TeachingProcessREQ req);
    /**
     *功能描述 研究生论文：论文送审优良比例(博士/硕士)
     * @author lkg
     * @date 2019/7/9
     */
    List<Map> masterThesisExcellent(@Param(value = "annual") String annual,@Param(value = "studentType") String studentType);

    /**
     * @Description 研究生学位授予:学位授予情况
     * @author linjl
     * @date 2019/5/23
     */
    List<Map<String, Object>> listPostgraduateDegreeAward(TeachingProcessREQ req);
    /**
     *功能描述 本科生/研究生评教：本科生学生评教
     * @author lkg
     * @date 2019/6/25
     */
    List<Map<String, Object>> undergraduateStuEva(@Param(value = "semesterYear") String semesterYear,@Param(value = "studentType") String studentType);
    /**
     *功能描述 本科生/研究生评教：本科生学院学生评价
     * @author lkg
     * @date 2019/6/25
     */
    List<Map<String, Object>> undergraduateAcaStuEva(@Param(value = "semesterYear") String semesterYear,@Param(value = "studentType") String studentType);
    /**
     *功能描述 研究生评教：学生评教箱线图
     * @author lkg
     * @date 2019/7/12
     */
    List<Map<String, Object>> academicAndScoreBoxLine(@Param(value = "semesterYear") String semesterYear);

}
