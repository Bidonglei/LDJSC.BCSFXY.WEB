package com.sunmnet.bigdata.web.model.request.finance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="财务域CapitalVoucherREQ")
public class CapitalVoucherREQ {

    @ApiModelProperty(value="开始时间")
    private String beginTime;

    @ApiModelProperty(value="结束时间")
    private String endTime;

    @ApiModelProperty(value="交易金额")
    private String transactionAmount;

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
