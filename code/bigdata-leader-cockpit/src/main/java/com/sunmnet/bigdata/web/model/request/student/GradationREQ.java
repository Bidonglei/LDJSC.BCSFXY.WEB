package com.sunmnet.bigdata.web.model.request.student;

import org.apache.commons.lang3.StringUtils;

import com.sunmnet.bigdata.web.enums.SeriesNameEnum;
import com.sunmnet.bigdata.web.util.CommonUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="GradationREQ")
public class GradationREQ {

    @ApiModelProperty(value="毕业年月")
    private String graduateYear;

    @ApiModelProperty(value="培养层次")
    private String educateGradation;

    @ApiModelProperty(value="学院代码")
    private String academyCode;

    public String getAcademyCode() {
        return academyCode;
    }

    public void setAcademyCode(String academyCode) {
        this.academyCode = academyCode;
    }

    public String getGraduateYear() {
        if(StringUtils.isBlank(graduateYear)) {
            return CommonUtils.getNowYear();
        }
        return graduateYear;
    }

    public void setGraduateYear(String graduateYear) {
        this.graduateYear = graduateYear;
    }

    public String getEducateGradation() {
        if(StringUtils.isBlank(educateGradation)) {
            return SeriesNameEnum.EDUCATE_GRADATION.getName();
        }
        return educateGradation;
    }

    public void setEducateGradation(String educateGradation) {
        this.educateGradation = educateGradation;
    }

    
}
