package com.sunmnet.bigdata.web.model.request.home;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SearchREQ")
public class SearchREQ {

    @ApiModelProperty("年份")
    private String year;
    
    @ApiModelProperty("专业")
    private String major;
    
    @ApiModelProperty("学院")
    private String academy;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }
    
    
}
