/**
* SubjectStatistics.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class SubjectStatistics {
    @ApiModelProperty(value="学科分类")
    private String subjectType;

    @ApiModelProperty(value="学科分类对应数量")
    private String subjectNumber;

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public String getSubjectNumber() {
        return subjectNumber;
    }

    public void setSubjectNumber(String subjectNumber) {
        this.subjectNumber = subjectNumber;
    }
}