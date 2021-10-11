package com.sunmnet.bigdata.web.model.request.personnel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="AssessInfoTypeREQ")
public class AssessInfoTypeREQ {

    @ApiModelProperty(value="部门类别")
    private String departmentType;
    @ApiModelProperty(value="部门名称")
    private String departmentName ;
    @ApiModelProperty(value="考核年份")
    private String assessmentDate ;

    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(String assessmentDate) {
        this.assessmentDate = assessmentDate;
    }
}
