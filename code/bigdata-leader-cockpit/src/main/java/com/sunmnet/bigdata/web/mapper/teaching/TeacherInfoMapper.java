/**
 * TeacherInfoMapper.java
 * 三盟科技
 * @date 2018-08-27
*/
package com.sunmnet.bigdata.web.mapper.teaching;

import java.util.List;
import java.util.Map;

import com.sunmnet.bigdata.web.model.request.teaching.TeachingTeamREQ;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: TeacherInfoMapper
* @Description: 人事、教师队伍
* @author lenovo
* @date 2018年8月28日
*/
public interface TeacherInfoMapper
{

    /**
    * @Title: getDistributionByAcademy
    * @Description: 师资力量-教师队伍-各学院专任教师分布情况
    * @param  req
    * @return List<Map>
    * @throws
    */
    List<Map<String, String>> getDistributionByAcademy(TeachingTeamREQ req);

    /**
    * @Title: listJobTitleOrderDesc
    * @Description: 师资力量-教师队伍-桑基图职称
    * @param  req
    * @return List<Map<String,String>>
    * @throws
    */
    List<Map<String, String>> listJobTitleOrderDesc(TeachingTeamREQ req);

    /**
    * @Title: listAppointmentType
    * @Description: 聘任类型统计
    * @param  req
    * @return List<Map<String,String>>
    * @throws  
    */ 
    List<Map<String,String>> listAppointmentType(TeachingTeamREQ req);

    /*** @Title: getTeacherStructuralAnalysis
    * @Description: 教师队伍学历结构
    * @param @param req
    * @param  columnName
    * @return List<Map<String,String>>
    * @throws
    */
    List<Map<String, String>> getEducationStructure(TeachingTeamREQ req);

    /**
    * @Title: getAcademyMarginStructure
    * @Description: 教师队伍学缘结构
    * @param  req
    * @return List<Map<String,String>>
    * @throws
    */
    List<Map<String, String>> getAcademyMarginStructure(TeachingTeamREQ req);

    /**
    * @Title: getAgeStructrue
    * @Description: 教师队伍-年龄结构
    * @param  req
    * @return List<Map<String,String>>
    * @throws
    */
    Map<String, String> getAgeStructrue(TeachingTeamREQ req);

    /**
    * @Title: getJopTitleDistribution
    * @Description: 职称分布
    * @param  req
    * @return List<Map<String,String>>
    * @throws
    */
    List<Map<String,String>> getJopTitleDistribution(TeachingTeamREQ req);

    /**
     * @Title: getStudentTeacherRatio
     * @Description: 各学院生师比
     * @param  req
     * @return List<Map<String,String>>
     * @throws
     */
    List<Map<String, String>> getStudentTeacherRatio(TeachingTeamREQ req);


    /**
     * 人事概括：实现查询教职人员类别分类
     * @return
     * @param departmentType
     */
    List<Map> listTeacherType(@Param("departmentType") String departmentType);

    /**
     * 人事概括：实现查询教职人员类别分类
     * @return
     * @param departmentType
     */
    List<Map> listTeacherTypeSchool(@Param("departmentType") String departmentType);

    /**
     * 人事概括：查询职称分布
     * @return
     * @param departmentType
     */
    List<Map> listTeacherJob(@Param("departmentType") String departmentType);

    /**
     * 人事概括：查询年龄分布
     * @return
     * @param departmentType
     */
    Map<String, String> listTeacherAge(@Param("departmentType") String departmentType);

    /**
     * 总人数和环比数
     * @param year
     * @return
     */
    Map<String,Object> selectTeacherTotal(@Param("year") String year);

    /**
     * 各部门人数
     * @return
     */
    List<Map> selectTeacherDepartmentTypeNum();
}