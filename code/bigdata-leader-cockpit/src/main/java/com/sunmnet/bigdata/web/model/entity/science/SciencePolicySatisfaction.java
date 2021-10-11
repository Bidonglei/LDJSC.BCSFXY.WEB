/**
* SciencePolicySatisfaction.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class SciencePolicySatisfaction {
    @ApiModelProperty(value="政策类型(管理,财务,人事,奖励)")
    private String policyType;

    @ApiModelProperty(value="政策满意度(百分比/统计)")
    private String policySatisfaction;

    @ApiModelProperty(value="反馈人数")
    private String personNumber;

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getPolicySatisfaction() {
        return policySatisfaction;
    }

    public void setPolicySatisfaction(String policySatisfaction) {
        this.policySatisfaction = policySatisfaction;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
    }
}