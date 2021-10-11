/**
* SStudentEnroll.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="学生招生表")
public class StudentEnroll {
    @ApiModelProperty(value="学号")
    private String studentNo;

    @ApiModelProperty(value="录取年份")
    private String enrollYear;

    @ApiModelProperty(value="生源地")
    private String origin;

    @ApiModelProperty(value="高考成绩")
    private String entranceScore;

    @ApiModelProperty(value="科类名称")
    private String studyName;

    @ApiModelProperty(value="培养层次")
    private String educateGradation;

    @ApiModelProperty(value="来源学校")
    private String fromSchool;

    @ApiModelProperty(value="来源学校类型")
    private String fromSchoolType;

    @ApiModelProperty(value="录取专业")
    private String enrollMajor;

    @ApiModelProperty(value="性别")
    private String gender;

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getEnrollYear() {
        return enrollYear;
    }

    public void setEnrollYear(String enrollYear) {
        this.enrollYear = enrollYear;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getEntranceScore() {
        return entranceScore;
    }

    public void setEntranceScore(String entranceScore) {
        this.entranceScore = entranceScore;
    }

    public String getStudyName() {
        return studyName;
    }

    public void setStudyName(String studyName) {
        this.studyName = studyName;
    }

    public String getEducateGradation() {
        return educateGradation;
    }

    public void setEducateGradation(String educateGradation) {
        this.educateGradation = educateGradation;
    }

    public String getFromSchool() {
        return fromSchool;
    }

    public void setFromSchool(String fromSchool) {
        this.fromSchool = fromSchool;
    }

    public String getFromSchoolType() {
        return fromSchoolType;
    }

    public void setFromSchoolType(String fromSchoolType) {
        this.fromSchoolType = fromSchoolType;
    }

    public String getEnrollMajor() {
        return enrollMajor;
    }

    public void setEnrollMajor(String enrollMajor) {
        this.enrollMajor = enrollMajor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}