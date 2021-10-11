/**
* RScrapyEsiPotentialSubject.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class ScrapyEsiPotentialSubject {
    @ApiModelProperty(value="学科名")
    private String subjectName;

    @ApiModelProperty(value="引用频次")
    private String referenceNumber;

    @ApiModelProperty(value="esi门槛值")
    private String thresholdValue;

    @ApiModelProperty(value="我校scie总被引频次")
    private String schoolReference;

    @ApiModelProperty(value="与esi绝对差距")
    private String absoluteGap;

    @ApiModelProperty(value="与esi相对差距")
    private String relativeGap;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getThresholdValue() {
        return thresholdValue;
    }

    public void setThresholdValue(String thresholdValue) {
        this.thresholdValue = thresholdValue;
    }

    public String getSchoolReference() {
        return schoolReference;
    }

    public void setSchoolReference(String schoolReference) {
        this.schoolReference = schoolReference;
    }

    public String getAbsoluteGap() {
        return absoluteGap;
    }

    public void setAbsoluteGap(String absoluteGap) {
        this.absoluteGap = absoluteGap;
    }

    public String getRelativeGap() {
        return relativeGap;
    }

    public void setRelativeGap(String relativeGap) {
        this.relativeGap = relativeGap;
    }
}