package com.sunmnet.bigdata.web.model.request.common;

import io.swagger.annotations.ApiModelProperty;

public class OpinionREQ {

    @ApiModelProperty(value="舆情唯一标示")
    private Integer opinionId;

    public Integer getOpinionId() {
        return opinionId;
    }

    public void setOpinionId(Integer opinionId) {
        this.opinionId = opinionId;
    }
    
}
