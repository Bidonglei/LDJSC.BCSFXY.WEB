package com.sunmnet.bigdata.web.model.request.teaching;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "教学资源-专业", description = "教学资源-专业请求参数")
public class TeachingResourceMajorREQ
{
    @ApiModelProperty("学年")
    private String schoolYear;
    
    @ApiModelProperty("专业类别(省部级优势专业01 国家特色专业02 国家综合改革试点专业03)")
    private String majorCategory;
    
    public String getSchoolYear()
    {
        return schoolYear;
    }
    
    public void setSchoolYear(String schoolYear)
    {
        this.schoolYear = schoolYear;
    }
    
    public String getMajorCategory()
    {
        return majorCategory;
    }
    
    public void setMajorCategory(String majorCategory)
    {
        this.majorCategory = majorCategory;
    }
    
}
