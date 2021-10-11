package com.sunmnet.bigdata.web.model.request.teaching;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "GraduateCourseREQ")
public class GraduateCourseREQ {

    @ApiModelProperty("研究生课程年")
    private String annual;
    
    @ApiModelProperty("研究生课程学生类型")
    private String type;

    public String getAnnual() {
        return annual;
    }

    public void setAnnual(String annual) {
        this.annual = annual;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
