package com.sunmnet.bigdata.web.model.request.teaching;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TeachingAchievementREQ")
public class TeachingAchievementREQ {

    @ApiModelProperty(value="年份")
    private String annual;

    @ApiModelProperty(value="类型")
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
