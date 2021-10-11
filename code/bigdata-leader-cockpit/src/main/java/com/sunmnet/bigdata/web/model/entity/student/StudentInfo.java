/**
* SStudentInfo.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="学生基本信息表")
public class StudentInfo {
    @ApiModelProperty(value="学号")
    private String studentNo;

    @ApiModelProperty(value="姓名")
    private String studentName;

    @ApiModelProperty(value="性别")
    private String gender;

    @ApiModelProperty(value="入学日期")
    private String enrollDate;

    @ApiModelProperty(value="年级")
    private String grade;

    @ApiModelProperty(value="培养层次")
    private String educateGradation;

    @ApiModelProperty(value="培养方式(留学生等)")
    private String educationType;

    @ApiModelProperty(value="省份(留学生国家)")
    private String province;

    @ApiModelProperty(value="学院代码")
    private String academyCode;

    @ApiModelProperty(value="学院简称")
    private String academyShort;

    @ApiModelProperty(value="学院名称")
    private String academyName;

    @ApiModelProperty(value="专业/学科代码")
    private String majorCode;

    @ApiModelProperty(value="专业/学科名称")
    private String majorName;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(String enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEducateGradation() {
        return educateGradation;
    }

    public void setEducateGradation(String educateGradation) {
        this.educateGradation = educateGradation;
    }

    public String getEducationType() {
        return educationType;
    }

    public void setEducationType(String educationType) {
        this.educationType = educationType;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

	public String getAcademyCode() {
		return academyCode;
	}

	public void setAcademyCode(String academyCode) {
		this.academyCode = academyCode;
	}

	public String getAcademyShort() {
		return academyShort;
	}

	public void setAcademyShort(String academyShort) {
		this.academyShort = academyShort;
	}

	public String getMajorCode() {
		return majorCode;
	}

	public void setMajorCode(String majorCode) {
		this.majorCode = majorCode;
	}
}