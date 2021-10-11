package com.sunmnet.bigdata.web.model.request.teaching;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="TeachingProcessREQ")
public class TeachingProcessREQ {

    @ApiModelProperty(value="年份")
    private String annual;

    @ApiModelProperty(value="学院标识")
    private String academy;

    @ApiModelProperty(value="类型")
    private String type;

    @ApiModelProperty(value="学生类型：博士，硕士")
    private String studentType;

    public String getAnnual() {
        return annual;
    }

    public void setAnnual(String annual) {
        this.annual = annual;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getType() {
        return type;
    }

	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}

	public void setType(String type) {
        this.type = type;
    }
}
