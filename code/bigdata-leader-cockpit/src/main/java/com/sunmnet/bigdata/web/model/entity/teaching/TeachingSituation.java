/**
* TTeachingSituation.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.teaching;

import io.swagger.annotations.ApiModelProperty;

public class TeachingSituation {
    @ApiModelProperty(value="学年")
    private String schoolYear;

    @ApiModelProperty(value="在校教授总人数(人数)")
    private String professorTotal;

    @ApiModelProperty(value="上课教授人数")
    private String lecturePro;

    @ApiModelProperty(value="上课教授占比")
    private String proportionPro;

    @ApiModelProperty(value="在校副教授总人数(人数)")
    private String associateProNum;

    @ApiModelProperty(value="上课副教授人数")
    private String lectureAssociatePro;

    @ApiModelProperty(value="上课副教授占比")
    private String proportionAssociatePro;

    @ApiModelProperty(value="教授平均上课学时数")
    private String proClassHour;

    @ApiModelProperty(value="副教授平均上课学时数")
    private String associateProClassHour;

    @ApiModelProperty(value="教授平均上课率")
    private String proClassRate;

    @ApiModelProperty(value="副教授平均上课率")
    private String associateProClassRate;

    @ApiModelProperty(value="教授授课次数")
    private String proLectureNum;

    @ApiModelProperty(value="副教授授课次数")
    private String associateProLectureNum;

    @ApiModelProperty(value="所属学院")
    private String academyName;

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getProfessorTotal() {
        return professorTotal;
    }

    public void setProfessorTotal(String professorTotal) {
        this.professorTotal = professorTotal;
    }

    public String getLecturePro() {
        return lecturePro;
    }

    public void setLecturePro(String lecturePro) {
        this.lecturePro = lecturePro;
    }

    public String getProportionPro() {
        return proportionPro;
    }

    public void setProportionPro(String proportionPro) {
        this.proportionPro = proportionPro;
    }

    public String getAssociateProNum() {
        return associateProNum;
    }

    public void setAssociateProNum(String associateProNum) {
        this.associateProNum = associateProNum;
    }

    public String getLectureAssociatePro() {
        return lectureAssociatePro;
    }

    public void setLectureAssociatePro(String lectureAssociatePro) {
        this.lectureAssociatePro = lectureAssociatePro;
    }

    public String getProportionAssociatePro() {
        return proportionAssociatePro;
    }

    public void setProportionAssociatePro(String proportionAssociatePro) {
        this.proportionAssociatePro = proportionAssociatePro;
    }

    public String getProClassHour() {
        return proClassHour;
    }

    public void setProClassHour(String proClassHour) {
        this.proClassHour = proClassHour;
    }

    public String getAssociateProClassHour() {
        return associateProClassHour;
    }

    public void setAssociateProClassHour(String associateProClassHour) {
        this.associateProClassHour = associateProClassHour;
    }

    public String getProClassRate() {
        return proClassRate;
    }

    public void setProClassRate(String proClassRate) {
        this.proClassRate = proClassRate;
    }

    public String getAssociateProClassRate() {
        return associateProClassRate;
    }

    public void setAssociateProClassRate(String associateProClassRate) {
        this.associateProClassRate = associateProClassRate;
    }

    public String getProLectureNum() {
        return proLectureNum;
    }

    public void setProLectureNum(String proLectureNum) {
        this.proLectureNum = proLectureNum;
    }

    public String getAssociateProLectureNum() {
        return associateProLectureNum;
    }

    public void setAssociateProLectureNum(String associateProLectureNum) {
        this.associateProLectureNum = associateProLectureNum;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }
}