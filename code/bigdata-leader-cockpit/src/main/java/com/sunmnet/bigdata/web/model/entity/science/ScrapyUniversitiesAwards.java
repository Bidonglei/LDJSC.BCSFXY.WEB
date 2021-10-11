/**
* ScrapyUniversitiesAwards.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class ScrapyUniversitiesAwards {
    @ApiModelProperty(value="年份")
    private String scienceYear;

    @ApiModelProperty(value="高校名称")
    private String keyUniversities;

    @ApiModelProperty(value="省部级一等奖数量")
    private String provincialFirstAward;

    @ApiModelProperty(value="省部级二等奖数量")
    private String provincialSecondAward;

    @ApiModelProperty(value="省部级三等奖数量")
    private String provincialThirdAward;

    @ApiModelProperty(value="国家级一等奖数量")
    private String nationalFirstAward;

    @ApiModelProperty(value="国家级二等奖数量")
    private String nationalSecondAward;

    public String getScienceYear() {
        return scienceYear;
    }

    public void setScienceYear(String scienceYear) {
        this.scienceYear = scienceYear;
    }

    public String getKeyUniversities() {
        return keyUniversities;
    }

    public void setKeyUniversities(String keyUniversities) {
        this.keyUniversities = keyUniversities;
    }

    public String getProvincialFirstAward() {
        return provincialFirstAward;
    }

    public void setProvincialFirstAward(String provincialFirstAward) {
        this.provincialFirstAward = provincialFirstAward;
    }

    public String getProvincialSecondAward() {
        return provincialSecondAward;
    }

    public void setProvincialSecondAward(String provincialSecondAward) {
        this.provincialSecondAward = provincialSecondAward;
    }

    public String getProvincialThirdAward() {
        return provincialThirdAward;
    }

    public void setProvincialThirdAward(String provincialThirdAward) {
        this.provincialThirdAward = provincialThirdAward;
    }

    public String getNationalFirstAward() {
        return nationalFirstAward;
    }

    public void setNationalFirstAward(String nationalFirstAward) {
        this.nationalFirstAward = nationalFirstAward;
    }

    public String getNationalSecondAward() {
        return nationalSecondAward;
    }

    public void setNationalSecondAward(String nationalSecondAward) {
        this.nationalSecondAward = nationalSecondAward;
    }
}