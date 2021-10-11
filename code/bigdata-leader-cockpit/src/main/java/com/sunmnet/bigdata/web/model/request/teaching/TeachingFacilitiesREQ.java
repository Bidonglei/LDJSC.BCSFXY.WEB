package com.sunmnet.bigdata.web.model.request.teaching;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "教学资源-教学设施请求对象", description = "教学设施请求参数")
public class TeachingFacilitiesREQ
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
