package com.sunmnet.bigdata.web.model.request.student;

import org.apache.commons.lang3.StringUtils;

import com.sunmnet.bigdata.web.enums.SeriesNameEnum;
import com.sunmnet.bigdata.web.util.CommonUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="UndergraduateREQ")
public class UndergraduateREQ {

	@ApiModelProperty(value="录取年份")
    private String enrollYear;
	
	@ApiModelProperty(value="科类名称")
    private String studyName;

	public String getEnrollYear() {
	    if(StringUtils.isBlank(enrollYear)) {
            return CommonUtils.getNowYear();
        }
		return enrollYear;
	}

	public void setEnrollYear(String enrollYear) {
		this.enrollYear = enrollYear;
	}

	public String getStudyName() {
	    if(StringUtils.isBlank(studyName)) {
            return SeriesNameEnum.STUDY_NAME.getName();
        }
		return studyName;
	}

	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}
	
}
