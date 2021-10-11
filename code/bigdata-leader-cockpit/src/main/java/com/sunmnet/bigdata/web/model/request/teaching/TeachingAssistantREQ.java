package com.sunmnet.bigdata.web.model.request.teaching;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "教辅人员请求对象", description = "教辅人员请求参数")
public class TeachingAssistantREQ
{
    @ApiModelProperty("学年")
    private String schoolYear;
    
    public String getSchoolYear()
    {
        return schoolYear;
    }
    
    public void setSchoolYear(String schoolYear)
    {
        this.schoolYear = schoolYear;
    }
    
}
