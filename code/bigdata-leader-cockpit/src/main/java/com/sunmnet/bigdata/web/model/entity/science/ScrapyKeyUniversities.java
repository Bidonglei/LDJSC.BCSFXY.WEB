/**
* ScrapyKeyUniversities.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class ScrapyKeyUniversities {
    @ApiModelProperty(value="年份")
    private String scienceYear;

    @ApiModelProperty(value="高校名称")
    private String keyUniversities;

    @ApiModelProperty(value="科研项目总经费")
    private String scienceMoney;

    @ApiModelProperty(value="科研项目当年总数量")
    private String scienceNumber;

    @ApiModelProperty(value="当年师均科研经费")
    private String scienceAvgMoney;

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

    public String getScienceMoney() {
        return scienceMoney;
    }

    public void setScienceMoney(String scienceMoney) {
        this.scienceMoney = scienceMoney;
    }

    public String getScienceNumber() {
        return scienceNumber;
    }

    public void setScienceNumber(String scienceNumber) {
        this.scienceNumber = scienceNumber;
    }

    public String getScienceAvgMoney() {
        return scienceAvgMoney;
    }

    public void setScienceAvgMoney(String scienceAvgMoney) {
        this.scienceAvgMoney = scienceAvgMoney;
    }
}