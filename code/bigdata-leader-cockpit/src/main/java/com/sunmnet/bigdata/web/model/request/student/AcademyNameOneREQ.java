package com.sunmnet.bigdata.web.model.request.student;

import org.apache.commons.lang3.StringUtils;

import com.sunmnet.bigdata.web.enums.SeriesNameEnum;
import com.sunmnet.bigdata.web.util.CommonUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="AcademyNameOneREQ")
public class AcademyNameOneREQ {

	@ApiModelProperty(value="年份")
	private String grade;
	
	@ApiModelProperty(value="培养层次")
	private String educateGradation;
	
	@ApiModelProperty(value="生源地")
    private String origin;
	
	@ApiModelProperty(value="学年")
    private String schoolyear;

    @ApiModelProperty(value="留学生类型")
    private String educationType;
    
	public String getEducationType() {
        return educationType;
    }

    public void setEducationType(String educationType) {
        this.educationType = educationType;
    }

    public String getSchoolyear() {
	    if(StringUtils.isBlank(schoolyear)) {
            return CommonUtils.getNowYear();
        }
        return schoolyear.substring(0,4);
    }

    public void setSchoolyear(String schoolyear) {
        this.schoolyear = schoolyear;
    }

    public String getGrade() {
	    if(StringUtils.isBlank(grade)) {
            return CommonUtils.getNowYear();
        }
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getEducateGradation() {
	    if(StringUtils.isBlank(educateGradation) && StringUtils.isBlank(educationType)) {
	        return SeriesNameEnum.EDUCATE_GRADATION.getName();
	    }
		return educateGradation;
	}

	public void setEducateGradation(String educateGradation) {
		this.educateGradation = educateGradation;
	}

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
	

}
