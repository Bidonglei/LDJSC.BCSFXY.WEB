/**
* AcademyAwards.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class AcademyAwards {
    @ApiModelProperty(value="年份")
    private String scienceYear;

    @ApiModelProperty(value="所属学院")
    private String academyName;

    @ApiModelProperty(value="获奖等级(省级,国家)")
    private String awardLevel;

    @ApiModelProperty(value="一等奖数量")
    private String firstAward;

    @ApiModelProperty(value="二等奖数量")
    private String secondAward;

    @ApiModelProperty(value="三等奖数量(国家无)")
    private String thirdAward;

    public String getScienceYear() {
        return scienceYear;
    }

    public void setScienceYear(String scienceYear) {
        this.scienceYear = scienceYear;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public String getAwardLevel() {
        return awardLevel;
    }

    public void setAwardLevel(String awardLevel) {
        this.awardLevel = awardLevel;
    }

    public String getFirstAward() {
        return firstAward;
    }

    public void setFirstAward(String firstAward) {
        this.firstAward = firstAward;
    }

    public String getSecondAward() {
        return secondAward;
    }

    public void setSecondAward(String secondAward) {
        this.secondAward = secondAward;
    }

    public String getThirdAward() {
        return thirdAward;
    }

    public void setThirdAward(String thirdAward) {
        this.thirdAward = thirdAward;
    }
}