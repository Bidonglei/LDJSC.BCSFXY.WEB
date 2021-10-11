package com.sunmnet.bigdata.web.model.request.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="SafeInfoREQ")
public class SafeInfoREQ {

    @ApiModelProperty(value="安全信息唯一标示")
    private Integer safeId;

    public Integer getSafeId() {
        return safeId;
    }

    public void setSafeId(Integer safeId) {
        this.safeId = safeId;
    }
    
    
}
