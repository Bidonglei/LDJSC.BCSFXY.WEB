package com.sunmnet.bigdata.web.model.request.personnel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="TeacherBoxREQ")
public class TeacherBoxREQ {

    @ApiModelProperty(value="教师姓名")
    private String teacherName;

    @ApiModelProperty(value="部门名称")
    private String departmentName;

    @ApiModelProperty(value="职务")
    private String job;

    @ApiModelProperty(value="职称等级")
    private String jobTitle;

    @ApiModelProperty(value="学历")
    private String education;

    @ApiModelProperty(value="政治面貌")
    private String politicalStatus;

    @ApiModelProperty(value="人才称号")
    private String topTalentsName;

    @ApiModelProperty(value="是否展示电话")
    private String realPhone;

    public String getTopTalentsName() {
        return topTalentsName;
    }

    public void setTopTalentsName(String topTalentsName) {
        this.topTalentsName = topTalentsName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getRealPhone() {
        return realPhone;
    }

    public void setRealPhone(String realPhone) {
        this.realPhone = realPhone;
    }
}
