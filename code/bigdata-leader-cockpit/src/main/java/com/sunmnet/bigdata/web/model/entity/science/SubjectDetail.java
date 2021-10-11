/**
* RSubjectDetail.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubjectDetail {
    @ApiModelProperty(value="学年")
    private String schoolyear;

    @ApiModelProperty(value="所属学院")
    private String academyName;

    @ApiModelProperty(value="博士后流动站数量")
    private String postdoctoralStation;

    @ApiModelProperty(value="硕士学位授权一级学科点数量")
    private String masterFirstSubject;

    @ApiModelProperty(value="硕士学位授权二级学科点数量")
    private String masterSecondSubject;

    @ApiModelProperty(value="博士学位授权一级学科点数量")
    private String doctorateFirstSubject;

    @ApiModelProperty(value="博士学位授权二级学科点数量")
    private String doctorateSecondSubject;

    @ApiModelProperty(value="本科专业数")
    private String undergraduateMajor;

    @ApiModelProperty(value="重点学科数")
    private String keySubject;

    public String getSchoolyear() {
        return schoolyear;
    }

    public void setSchoolyear(String schoolyear) {
        this.schoolyear = schoolyear;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public String getPostdoctoralStation() {
        return postdoctoralStation;
    }

    public void setPostdoctoralStation(String postdoctoralStation) {
        this.postdoctoralStation = postdoctoralStation;
    }

    public String getMasterFirstSubject() {
        return masterFirstSubject;
    }

    public void setMasterFirstSubject(String masterFirstSubject) {
        this.masterFirstSubject = masterFirstSubject;
    }

    public String getMasterSecondSubject() {
        return masterSecondSubject;
    }

    public void setMasterSecondSubject(String masterSecondSubject) {
        this.masterSecondSubject = masterSecondSubject;
    }

    public String getDoctorateFirstSubject() {
        return doctorateFirstSubject;
    }

    public void setDoctorateFirstSubject(String doctorateFirstSubject) {
        this.doctorateFirstSubject = doctorateFirstSubject;
    }

    public String getDoctorateSecondSubject() {
        return doctorateSecondSubject;
    }

    public void setDoctorateSecondSubject(String doctorateSecondSubject) {
        this.doctorateSecondSubject = doctorateSecondSubject;
    }

    public String getUndergraduateMajor() {
        return undergraduateMajor;
    }

    public void setUndergraduateMajor(String undergraduateMajor) {
        this.undergraduateMajor = undergraduateMajor;
    }

    public String getKeySubject() {
        return keySubject;
    }

    public void setKeySubject(String keySubject) {
        this.keySubject = keySubject;
    }
}