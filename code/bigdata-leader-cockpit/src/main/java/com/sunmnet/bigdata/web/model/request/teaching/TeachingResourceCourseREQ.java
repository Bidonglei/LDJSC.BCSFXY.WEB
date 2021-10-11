package com.sunmnet.bigdata.web.model.request.teaching;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "教学资源-课程", description = "教学资源课程请求参数")
public class TeachingResourceCourseREQ
{
    @ApiModelProperty("学年")
    private String schoolYear;
    
    @ApiModelProperty("培养层次(本科生课程01 研究生课程02)")
    private String educationGradation;
    
    public String getSchoolYear()
    {
        return schoolYear;
    }
    
    public void setSchoolYear(String schoolYear)
    {
        this.schoolYear = schoolYear;
    }
    
    public String getEducationGradation()
    {
        return educationGradation;
    }
    
    public void setEducationGradation(String educationGradation)
    {
        this.educationGradation = educationGradation;
    }
    
}
