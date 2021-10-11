/**
* ThesisPublish.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class ThesisPublish {
    @ApiModelProperty(value="年份")
    private String scienceYear;

    @ApiModelProperty(value="sci/ssci数量")
    private String scienceCitationIndex;

    @ApiModelProperty(value="ei数量")
    private String engineeringIndex;

    @ApiModelProperty(value="cpci数量")
    private String peripheralComponent;

    @ApiModelProperty(value="1/10期刊数量")
    private String periodicals;

    @ApiModelProperty(value="表现不俗数量")
    private String wellThesis;

    @ApiModelProperty(value="国际合作论文数量")
    private String internationalCooperation;

    public String getScienceYear() {
        return scienceYear;
    }

    public void setScienceYear(String scienceYear) {
        this.scienceYear = scienceYear;
    }

    public String getScienceCitationIndex() {
        return scienceCitationIndex;
    }

    public void setScienceCitationIndex(String scienceCitationIndex) {
        this.scienceCitationIndex = scienceCitationIndex;
    }

    public String getEngineeringIndex() {
        return engineeringIndex;
    }

    public void setEngineeringIndex(String engineeringIndex) {
        this.engineeringIndex = engineeringIndex;
    }

    public String getPeripheralComponent() {
        return peripheralComponent;
    }

    public void setPeripheralComponent(String peripheralComponent) {
        this.peripheralComponent = peripheralComponent;
    }

    public String getPeriodicals() {
        return periodicals;
    }

    public void setPeriodicals(String periodicals) {
        this.periodicals = periodicals;
    }

    public String getWellThesis() {
        return wellThesis;
    }

    public void setWellThesis(String wellThesis) {
        this.wellThesis = wellThesis;
    }

    public String getInternationalCooperation() {
        return internationalCooperation;
    }

    public void setInternationalCooperation(String internationalCooperation) {
        this.internationalCooperation = internationalCooperation;
    }
}