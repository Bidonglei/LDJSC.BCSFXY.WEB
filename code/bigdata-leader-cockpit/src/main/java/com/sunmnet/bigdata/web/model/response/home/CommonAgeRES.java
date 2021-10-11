package com.sunmnet.bigdata.web.model.response.home;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "搜索框年龄段传值")
public class CommonAgeRES {

    @ApiModelProperty("map第一个值")
    private String name;
    
    @ApiModelProperty("map第二个值")
    private String value;
    
    @ApiModelProperty("map第二个值")
    private String valueTwo;

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

    public String getValueTwo()
    {
        return valueTwo;
    }

    public void setValueTwo(String valueTwo)
    {
        this.valueTwo = valueTwo;
    }
    
}
