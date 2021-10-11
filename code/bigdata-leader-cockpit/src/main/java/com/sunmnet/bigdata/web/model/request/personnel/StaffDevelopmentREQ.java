package com.sunmnet.bigdata.web.model.request.personnel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="StaffDevelopmentREQ")
public class StaffDevelopmentREQ {

    @ApiModelProperty(value="出国时间")
    private String abroadYear;
    @ApiModelProperty(value="近几年:1 or 2 or 3")
    private String recentYear;
    @ApiModelProperty(value="国际交流类型")
    private String abroadType;

    public String getAbroadYear() {
        return abroadYear;
    }

    public void setAbroadYear(String abroadYear) {
        this.abroadYear = abroadYear;
    }

    public String getRecentYear() {
        return recentYear;
    }

    public void setRecentYear(String recentYear) {
        this.recentYear = recentYear;
    }

    public String getAbroadType() {
        return abroadType;
    }

    public void setAbroadType(String abroadType) {
        this.abroadType = abroadType;
    }
}
