/**
* TeacherRelation.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.personnel;

import io.swagger.annotations.ApiModelProperty;

public class TeacherRelation {
    @ApiModelProperty(value="教工号")
    private String teacherNo;

    @ApiModelProperty(value="姓名")
    private String teacherName;

    @ApiModelProperty(value="关系类型")
    private String relationType;

    @ApiModelProperty(value="二级关系小类")
    private String secondRelation;

    @ApiModelProperty(value="单条详细信息")
    private String singleDetail;

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

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public String getSecondRelation() {
        return secondRelation;
    }

    public void setSecondRelation(String secondRelation) {
        this.secondRelation = secondRelation;
    }

    public String getSingleDetail() {
        return singleDetail;
    }

    public void setSingleDetail(String singleDetail) {
        this.singleDetail = singleDetail;
    }
}