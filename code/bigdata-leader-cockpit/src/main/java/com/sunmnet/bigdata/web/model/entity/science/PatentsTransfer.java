/**
* RPatentsTransfer.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class PatentsTransfer {
    @ApiModelProperty(value="年份")
    private String scienceYear;

    @ApiModelProperty(value="专利出售总金额")
    private String sellMoney;

    @ApiModelProperty(value="当年实际收入金额")
    private String realIncome;

    @ApiModelProperty(value="专利出售合同数")
    private String contractNumber;

    public String getScienceYear() {
        return scienceYear;
    }

    public void setScienceYear(String scienceYear) {
        this.scienceYear = scienceYear;
    }

    public String getSellMoney() {
        return sellMoney;
    }

    public void setSellMoney(String sellMoney) {
        this.sellMoney = sellMoney;
    }

    public String getRealIncome() {
        return realIncome;
    }

    public void setRealIncome(String realIncome) {
        this.realIncome = realIncome;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }
}