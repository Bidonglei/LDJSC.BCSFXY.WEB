/**
* LabLevelAssess.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class LabLevelAssess {
    @ApiModelProperty(value="年份")
    private String scienceYear;

    @ApiModelProperty(value="实验室级别(国家级/省部级)(重点/工程中心)4类")
    private String labLevel;

    @ApiModelProperty(value="实验室名称")
    private String labName;

    public String getScienceYear() {
        return scienceYear;
    }

    public void setScienceYear(String scienceYear) {
        this.scienceYear = scienceYear;
    }

    public String getLabLevel() {
        return labLevel;
    }

    public void setLabLevel(String labLevel) {
        this.labLevel = labLevel;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }
}