package com.sunmnet.bigdata.web.model.request.personnel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="TeacherInfoREQ")
public class TeacherInfoREQ {

    @ApiModelProperty(value="事业编制or非事业编制")
    private String isPlait;

    @ApiModelProperty(value="编制类型小类")
    private String typeOfPreparation;

    @ApiModelProperty(value="部门分类")
    private String departmentNameType;

    @ApiModelProperty(value="部门名称")
    private String departmentName;

    @ApiModelProperty(value="学缘(本校毕业/国内其他/境外学校)")
    private String employmentType;

    @ApiModelProperty(value="学院名")
    private String departmentType;

    public String getIsPlait() {
        return isPlait;
    }

    public void setIsPlait(String isPlait) {
        this.isPlait = isPlait;
    }

    public String getTypeOfPreparation() {
        return typeOfPreparation;
    }

    public void setTypeOfPreparation(String typeOfPreparation) {
        this.typeOfPreparation = typeOfPreparation;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType;
    }

    public String getDepartmentNameType() {
        return departmentNameType;
    }

    public void setDepartmentNameType(String departmentNameType) {
        this.departmentNameType = departmentNameType;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
