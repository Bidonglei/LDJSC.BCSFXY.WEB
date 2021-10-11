package com.sunmnet.bigdata.web.model.request.teaching;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "教师队伍请求对象", description = "教师队伍请求参数")
public class TeachingTeamREQ
{
    @ApiModelProperty("学年")
    private String schoolYear;
    
    @ApiModelProperty("教师聘任类型(专任教师01  外聘教师02)")
    private String appointmentType;
    
    @ApiModelProperty("学历(本科01 硕士02)")
    private String education;
    
    public String getSchoolYear()
    {
        return schoolYear;
    }
    
    public void setSchoolYear(String schoolYear)
    {
        this.schoolYear = schoolYear;
    }
    
    public String getAppointmentType()
    {
        return appointmentType;
    }
    
    public void setAppointmentType(String appointmentType)
    {
        this.appointmentType = appointmentType;
    }
    
    public String getEducation()
    {
        return education;
    }
    
    public void setEducation(String education)
    {
        this.education = education;
    }
    
}
