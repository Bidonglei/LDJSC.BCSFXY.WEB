/**
* RLabLevelStatistics.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class LabLevelStatistics {
    @ApiModelProperty(value="年份")
    private String scienceYear;

    @ApiModelProperty(value="国家级重点实验室数量")
    private String nationalKeyLab;

    @ApiModelProperty(value="省部级重点实验室数量")
    private String provincialKeyLab;

    @ApiModelProperty(value="国家级工程中心数量")
    private String nationalEngineeringCenters;

    @ApiModelProperty(value="省部级工程中心数量")
    private String provincialEngineeringCenters;

    public String getScienceYear() {
        return scienceYear;
    }

    public void setScienceYear(String scienceYear) {
        this.scienceYear = scienceYear;
    }

    public String getNationalKeyLab() {
        return nationalKeyLab;
    }

    public void setNationalKeyLab(String nationalKeyLab) {
        this.nationalKeyLab = nationalKeyLab;
    }

    public String getProvincialKeyLab() {
        return provincialKeyLab;
    }

    public void setProvincialKeyLab(String provincialKeyLab) {
        this.provincialKeyLab = provincialKeyLab;
    }

    public String getNationalEngineeringCenters() {
        return nationalEngineeringCenters;
    }

    public void setNationalEngineeringCenters(String nationalEngineeringCenters) {
        this.nationalEngineeringCenters = nationalEngineeringCenters;
    }

    public String getProvincialEngineeringCenters() {
        return provincialEngineeringCenters;
    }

    public void setProvincialEngineeringCenters(String provincialEngineeringCenters) {
        this.provincialEngineeringCenters = provincialEngineeringCenters;
    }
}