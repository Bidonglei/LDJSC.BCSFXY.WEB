package com.sunmnet.bigdata.web.model.request.student;

import org.apache.commons.lang3.StringUtils;

import com.sunmnet.bigdata.web.enums.SeriesNameEnum;
import com.sunmnet.bigdata.web.util.CommonUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="EducateGradationREQ")
public class EducateGradationREQ {

	@ApiModelProperty(value="录取年份")
    private String enrollYear;
	
	@ApiModelProperty(value="培养层次")
    private String educateGradation;

	public String getEnrollYear() {
	    if(StringUtils.isBlank(enrollYear)) {
            return CommonUtils.getNowYear();
        }
		return enrollYear;
	}

	public void setEnrollYear(String enrollYear) {
		this.enrollYear = enrollYear;
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
