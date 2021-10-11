/**
* TopTalents.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.personnel;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class TopTalents {
    @ApiModelProperty(value="教工号")
    private String teacherNo;

    @ApiModelProperty(value="姓名")
    private String teacherName;

    @ApiModelProperty(value="性别")
    private String gender;

    @ApiModelProperty(value="年龄")
    private String age;

    @ApiModelProperty(value = "按照年龄段查询数据--》开始年龄-为空表示无限小")
    private Integer startAge;
    @ApiModelProperty(value = "按照年龄段查询数据--》结束年龄-为空表示无限大")
    private Integer endAge;

    @ApiModelProperty(value="出生日期")
    private String birthday;

    @ApiModelProperty(value="学位")
    private String degree;

    @ApiModelProperty(value="职称")
    private String jobTitle;

    @ApiModelProperty(value="高端人才类型")
    private String topTalentsType;

    @ApiModelProperty(value="学院名称")
    private String academyName;

    @ApiModelProperty(value="学科名称")
    private String subjectName;

    @ApiModelProperty(value="获得称号时间")
    private String entryDate;

    @ApiModelProperty(value="电子邮件")
    private String email;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getTopTalentsType() {
        return topTalentsType;
    }

    public void setTopTalentsType(String topTalentsType) {
        this.topTalentsType = topTalentsType;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getEmail() {
        return email;
    }

    public Integer getStartAge() {
        return startAge;
    }

    public void setStartAge(Integer startAge) {
        this.startAge = startAge;
    }

    public Integer getEndAge() {
        return endAge;
    }

    public void setEndAge(Integer endAge) {
        this.endAge = endAge;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}