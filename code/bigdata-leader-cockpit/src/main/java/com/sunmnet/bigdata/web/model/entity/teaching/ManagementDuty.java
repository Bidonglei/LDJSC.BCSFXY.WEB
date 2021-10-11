/**
* TManagementDuty.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.teaching;

import io.swagger.annotations.ApiModelProperty;

public class ManagementDuty {
    @ApiModelProperty(value="培养层次")
    private String educationGradation;

    @ApiModelProperty(value="管理部门办公室")
    private String managementOffic;

    @ApiModelProperty(value="部门职责")
    private String departmentDuty;

    @ApiModelProperty(value="工作内容")
    private String managementContent;

    public String getEducationGradation() {
        return educationGradation;
    }

    public void setEducationGradation(String educationGradation) {
        this.educationGradation = educationGradation;
    }

    public String getManagementOffic() {
        return managementOffic;
    }

    public void setManagementOffic(String managementOffic) {
        this.managementOffic = managementOffic;
    }

    public String getDepartmentDuty() {
        return departmentDuty;
    }

    public void setDepartmentDuty(String departmentDuty) {
        this.departmentDuty = departmentDuty;
    }

    public String getManagementContent() {
        return managementContent;
    }

    public void setManagementContent(String managementContent) {
        this.managementContent = managementContent;
    }
}