package com.sunmnet.bigdata.web.model.request.teaching;

import org.apache.commons.lang3.StringUtils;

import com.sunmnet.bigdata.web.util.CommonUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="TeachingEvaluationREQ")
public class TeachingEvaluationREQ {

    @ApiModelProperty(value="管理职责类型")
    private String educationGradation;

    @ApiModelProperty(value="评教类型(专家评教 学生评教 同行评教)")
    private String evaluationType;
    
    @ApiModelProperty(value="学年")
    private String schoolyear;
    
    public String getSchoolyear() {
        if(StringUtils.isBlank(schoolyear)) {
            String year = CommonUtils.getNowYear();
            return (Integer.parseInt(year)-1)+"-"+year;
        }
        return schoolyear;
    }

    public void setSchoolyear(String schoolyear) {
        this.schoolyear = schoolyear;
    }


    public String getEducationGradation() {
        return educationGradation;
    }

    public void setEducationGradation(String educationGradation) {
        this.educationGradation = educationGradation;
    }

    public String getEvaluationType() {
        return evaluationType;
    }

    public void setEvaluationType(String evaluationType) {
        this.evaluationType = evaluationType;
    }
    
}
