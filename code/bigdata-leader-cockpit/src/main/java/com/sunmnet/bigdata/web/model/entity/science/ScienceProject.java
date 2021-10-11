/**
* ScienceProject.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class ScienceProject {
    @ApiModelProperty(value="年份")
    private String scienceYear;

    @ApiModelProperty(value="项目分类(军工科研,重大专项,条件保障,国家基金委)")
    private String projectType;

    @ApiModelProperty(value="承担项目学院")
    private String academyName;

    @ApiModelProperty(value="承担项目团队(系)(学院下级)")
    private String projectTeam;

    @ApiModelProperty(value="承担项目总金额")
    private String projectMoney;

    @ApiModelProperty(value="承担项目数量")
    private String projectNumber;

    public String getScienceYear() {
        return scienceYear;
    }

    public void setScienceYear(String scienceYear) {
        this.scienceYear = scienceYear;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public String getProjectTeam() {
        return projectTeam;
    }

    public void setProjectTeam(String projectTeam) {
        this.projectTeam = projectTeam;
    }

    public String getProjectMoney() {
        return projectMoney;
    }

    public void setProjectMoney(String projectMoney) {
        this.projectMoney = projectMoney;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }
}