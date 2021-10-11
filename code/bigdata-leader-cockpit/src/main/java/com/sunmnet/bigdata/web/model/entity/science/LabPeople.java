/**
* LabPeople.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class LabPeople {
    @ApiModelProperty(value="实验室名称")
    private String labName;

    @ApiModelProperty(value="人员标识")
    private String personId;

    @ApiModelProperty(value="人员类型")
    private String personnelType;

    @ApiModelProperty(value="职称")
    private String jobTitle;

    @ApiModelProperty(value="学位")
    private String degree;

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonnelType() {
        return personnelType;
    }

    public void setPersonnelType(String personnelType) {
        this.personnelType = personnelType;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}