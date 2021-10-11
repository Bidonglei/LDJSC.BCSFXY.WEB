package com.sunmnet.bigdata.web.model.request.student;

import io.swagger.annotations.ApiModelProperty;

public class MajorNameTwoREQ extends AcademyNameOneREQ{

	@ApiModelProperty(value="学院名称")
    private String academyName;

	public String getAcademyName() {
		return academyName;
	}

	public void setAcademyName(String academyName) {
		this.academyName = academyName;
	}
	
}
