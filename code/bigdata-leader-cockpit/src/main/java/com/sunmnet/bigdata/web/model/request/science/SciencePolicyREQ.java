package com.sunmnet.bigdata.web.model.request.science;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="SciencePolicyREQ")
public class SciencePolicyREQ {

    @ApiModelProperty(value="校内/国家及省部级")
    private String webpageSource;

    public String getWebpageSource() {
        return webpageSource;
    }

    public void setWebpageSource(String webpageSource) {
        this.webpageSource = webpageSource;
    }
    
}
