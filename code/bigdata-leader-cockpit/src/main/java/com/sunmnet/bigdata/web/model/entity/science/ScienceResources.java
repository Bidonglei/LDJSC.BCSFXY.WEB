/**
* ScienceResources.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class ScienceResources {
    @ApiModelProperty(value="年份")
    private String scienceYear;

    @ApiModelProperty(value="研发所属学院")
    private String academyName;

    @ApiModelProperty(value="占用面积")
    private String acreage;

    @ApiModelProperty(value="年投入条件建设资金")
    private String yearsFundsIn;

    @ApiModelProperty(value="固定资产总额")
    private String fixedAssets;

    @ApiModelProperty(value="年均水电费用")
    private String utilities;

    @ApiModelProperty(value="重点实验室")
    private String keyLab;

    @ApiModelProperty(value="研究所")
    private String researchLab;

    @ApiModelProperty(value="研究中心")
    private String researchCenter;

    @ApiModelProperty(value="平台")
    private String platform;

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

    public String getAcreage() {
        return acreage;
    }

    public void setAcreage(String acreage) {
        this.acreage = acreage;
    }

    public String getYearsFundsIn() {
        return yearsFundsIn;
    }

    public void setYearsFundsIn(String yearsFundsIn) {
        this.yearsFundsIn = yearsFundsIn;
    }

    public String getFixedAssets() {
        return fixedAssets;
    }

    public void setFixedAssets(String fixedAssets) {
        this.fixedAssets = fixedAssets;
    }

    public String getUtilities() {
        return utilities;
    }

    public void setUtilities(String utilities) {
        this.utilities = utilities;
    }

    public String getKeyLab() {
        return keyLab;
    }

    public void setKeyLab(String keyLab) {
        this.keyLab = keyLab;
    }

    public String getResearchLab() {
        return researchLab;
    }

    public void setResearchLab(String researchLab) {
        this.researchLab = researchLab;
    }

    public String getResearchCenter() {
        return researchCenter;
    }

    public void setResearchCenter(String researchCenter) {
        this.researchCenter = researchCenter;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}