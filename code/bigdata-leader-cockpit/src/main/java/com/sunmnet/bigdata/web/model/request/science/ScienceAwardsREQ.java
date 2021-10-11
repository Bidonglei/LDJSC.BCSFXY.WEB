package com.sunmnet.bigdata.web.model.request.science;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="ScienceAwardsREQ")
public class ScienceAwardsREQ {

    @ApiModelProperty(value="年份")
    private String year;

    @ApiModelProperty(value="奖项等级")
    private String awardRank;

    @ApiModelProperty(value="获奖类型")
    private String awardType;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAwardRank() {
        return awardRank;
    }

    public void setAwardRank(String awardRank) {
        this.awardRank = awardRank;
    }

    public String getAwardType() {
        return awardType;
    }

    public void setAwardType(String awardType) {
        this.awardType = awardType;
    }
}
