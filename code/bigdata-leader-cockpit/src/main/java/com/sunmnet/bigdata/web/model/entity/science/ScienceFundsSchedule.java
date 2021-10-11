/**
* ScienceFundsSchedule.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class ScienceFundsSchedule {
    @ApiModelProperty(value="研发所属学院")
    private String academyName;

    @ApiModelProperty(value="经费来源(4个类型)")
    private String fundingSource;

    @ApiModelProperty(value="科研经费合同金额")
    private String contractFunds;

    @ApiModelProperty(value="科研经费执行金额")
    private String performFunds;

    @ApiModelProperty(value="科研经费实际到款金额")
    private String actualFunds;

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public String getFundingSource() {
        return fundingSource;
    }

    public void setFundingSource(String fundingSource) {
        this.fundingSource = fundingSource;
    }

    public String getContractFunds() {
        return contractFunds;
    }

    public void setContractFunds(String contractFunds) {
        this.contractFunds = contractFunds;
    }

    public String getPerformFunds() {
        return performFunds;
    }

    public void setPerformFunds(String performFunds) {
        this.performFunds = performFunds;
    }

    public String getActualFunds() {
        return actualFunds;
    }

    public void setActualFunds(String actualFunds) {
        this.actualFunds = actualFunds;
    }
}