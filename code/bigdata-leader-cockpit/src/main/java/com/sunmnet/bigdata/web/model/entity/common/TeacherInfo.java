/**
* CTeacherInfo.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.common;

import io.swagger.annotations.ApiModelProperty;

public class TeacherInfo {
    @ApiModelProperty(value="教工号")
    private String teacherNo;

    @ApiModelProperty(value="教职人员类别(专教,教辅等)")
    private String teacherType;

    @ApiModelProperty(value="学院代码")
    private String academyCode;

    @ApiModelProperty(value="学院名称")
    private String academyName;

    @ApiModelProperty(value="职称(初级,中级,正高级,副高级)")
    private String jobTitle;

    @ApiModelProperty(value="年龄")
    private String age;

    @ApiModelProperty(value="教师聘任类型(专任教师	外聘教师)")
    private String appointmentType;

    @ApiModelProperty(value="学历")
    private String education;

    @ApiModelProperty(value="入职日期")
    private String entryDate;

    @ApiModelProperty(value="离职日期")
    private String leaveDate;

    @ApiModelProperty(value="学缘(本校	外校境内	外校境外)")
    private String academyMargin;

    @ApiModelProperty(value="是否实验技术人员(教辅人员使用)")
    private String isExperimenter;

    @ApiModelProperty(value="是否专业带头人(教辅人员使用)")
    private String isProfessionalLeader;

    @ApiModelProperty(value="是否教学管理队伍")
    private String isManager;

    @ApiModelProperty(value="教学管理队伍类型(校级质量监控人员队伍 校级教学管理队伍 院系级教学管理队伍)")
    private String managerType;

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getTeacherType() {
        return teacherType;
    }

    public void setTeacherType(String teacherType) {
        this.teacherType = teacherType;
    }

    public String getAcademyCode() {
        return academyCode;
    }

    public void setAcademyCode(String academyCode) {
        this.academyCode = academyCode;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getAcademyMargin() {
        return academyMargin;
    }

    public void setAcademyMargin(String academyMargin) {
        this.academyMargin = academyMargin;
    }

    public String getIsExperimenter() {
        return isExperimenter;
    }

    public void setIsExperimenter(String isExperimenter) {
        this.isExperimenter = isExperimenter;
    }

    public String getIsProfessionalLeader() {
        return isProfessionalLeader;
    }

    public void setIsProfessionalLeader(String isProfessionalLeader) {
        this.isProfessionalLeader = isProfessionalLeader;
    }

    public String getIsManager() {
        return isManager;
    }

    public void setIsManager(String isManager) {
        this.isManager = isManager;
    }

    public String getManagerType() {
        return managerType;
    }

    public void setManagerType(String managerType) {
        this.managerType = managerType;
    }
}