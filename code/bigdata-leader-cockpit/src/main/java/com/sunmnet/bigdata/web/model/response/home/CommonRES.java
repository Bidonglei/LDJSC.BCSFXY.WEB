package com.sunmnet.bigdata.web.model.response.home;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CommonRES")
public class CommonRES {

    @ApiModelProperty("map第一个值")
    private String name;
    
    @ApiModelProperty("map第二个值")
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
