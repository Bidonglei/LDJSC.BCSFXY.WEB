/**
* ResourcesEquipmentFunds.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.common;

import io.swagger.annotations.ApiModelProperty;

public class ResourcesEquipmentFunds {
    @ApiModelProperty(value="统计年份")
    private String countYear;

    @ApiModelProperty(value="设备资产总值")
    private String equipmentFunds;

    @ApiModelProperty(value="当年新增")
    private String newYearFunds;

    public String getCountYear() {
        return countYear;
    }

    public void setCountYear(String countYear) {
        this.countYear = countYear;
    }

    public String getEquipmentFunds() {
        return equipmentFunds;
    }

    public void setEquipmentFunds(String equipmentFunds) {
        this.equipmentFunds = equipmentFunds;
    }

    public String getNewYearFunds() {
        return newYearFunds;
    }

    public void setNewYearFunds(String newYearFunds) {
        this.newYearFunds = newYearFunds;
    }
}