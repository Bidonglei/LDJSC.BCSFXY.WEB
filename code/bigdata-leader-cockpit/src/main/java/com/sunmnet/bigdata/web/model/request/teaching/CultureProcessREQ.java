package com.sunmnet.bigdata.web.model.request.teaching;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "培养过程请求对象", description = "培养过程请求参数")
public class CultureProcessREQ
{
    @ApiModelProperty("入学年级")
    private String grade;
    
    @ApiModelProperty("学历(本科01 硕士02)")
    private String education;
    
    @ApiModelProperty("专业")
    private String majorName;
    
    public String getGrade()
    {
        return grade;
    }
    
    public void setGrade(String grade)
    {
        this.grade = grade;
    }
    
    public String getEducation()
    {
        return education;
    }
    
    public void setEducation(String education)
    {
        this.education = education;
    }
    
    public String getMajorName()
    {
        return majorName;
    }
    
    public void setMajorName(String majorName)
    {
        this.majorName = majorName;
    }
    
}
