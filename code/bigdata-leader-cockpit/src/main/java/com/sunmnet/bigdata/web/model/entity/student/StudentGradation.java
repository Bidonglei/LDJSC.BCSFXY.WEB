/**
* SStudentGradation.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="学生毕业去向信息表")
public class StudentGradation {
    @ApiModelProperty(value="学号")
    private String studentNo;

    @ApiModelProperty(value="毕业年月")
    private String graduateYear;

    @ApiModelProperty(value="培养层次")
    private String educateGradation;

    @ApiModelProperty(value="毕业去向")
    private String graduateTo;

    @ApiModelProperty(value="是否就业")
    private String isJob;

    @ApiModelProperty(value="升学学校类型")
    private String upSchoolType;

    @ApiModelProperty(value="就业公司类型")
    private String companyType;

    @ApiModelProperty(value="所属单位地域")
    private String workingArea;

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(String graduateYear) {
        this.graduateYear = graduateYear;
    }

    public String getEducateGradation() {
        return educateGradation;
    }

    public void setEducateGradation(String educateGradation) {
        this.educateGradation = educateGradation;
    }

    public String getGraduateTo() {
        return graduateTo;
    }

    public void setGraduateTo(String graduateTo) {
        this.graduateTo = graduateTo;
    }

    public String getIsJob() {
        return isJob;
    }

    public void setIsJob(String isJob) {
        this.isJob = isJob;
    }

    public String getUpSchoolType() {
        return upSchoolType;
    }

    public void setUpSchoolType(String upSchoolType) {
        this.upSchoolType = upSchoolType;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getWorkingArea() {
        return workingArea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingArea = workingArea;
    }
}