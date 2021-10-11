package com.sunmnet.bigdata.web.model.response.teaching;

import com.sunmnet.bigdata.common.request.BasePageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "DoctorMoreThanYearsRES")
public class DoctorMoreThanYearsRES extends BasePageRequest
{
    @ApiModelProperty("学号")
    private String studentNo;

    @ApiModelProperty("姓名")
    private String studentName;

    @ApiModelProperty("学院")
    private String academyShort;

    @ApiModelProperty("入学时间")
    private String enrollDate;

    @ApiModelProperty("学业时长")
    private String schoolingYears;

    @ApiModelProperty("导师工号")
    private String teacherNo;

    @ApiModelProperty("导师姓名")
    private String teacherName;

    @ApiModelProperty("学籍状态")
    private String anomalyType;

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAcademyShort() {
        return academyShort;
    }

    public void setAcademyShort(String academyShort) {
        this.academyShort = academyShort;
    }

    public String getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(String enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getSchoolingYears() {
        return schoolingYears;
    }

    public void setSchoolingYears(String schoolingYears) {
        this.schoolingYears = schoolingYears;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getAnomalyType() {
        return anomalyType;
    }

    public void setAnomalyType(String anomalyType) {
        this.anomalyType = anomalyType;
    }
}
