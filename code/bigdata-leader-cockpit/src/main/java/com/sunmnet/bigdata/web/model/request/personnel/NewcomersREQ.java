package com.sunmnet.bigdata.web.model.request.personnel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="NewcomersREQ")
public class NewcomersREQ {

    @ApiModelProperty(value="近几月/年,1代表一个季度")
    private String recentTime;

    @ApiModelProperty(value="学院名称")
    private String departmentName;

    @ApiModelProperty(value="编制类型")
    private String teacherTypeSmall;

    public String getRecentTime() {
        return recentTime;
    }

    public void setRecentTime(String recentTime) {
        this.recentTime = recentTime;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getTeacherTypeSmall() {
        return teacherTypeSmall;
    }

    public void setTeacherTypeSmall(String teacherTypeSmall) {
        this.teacherTypeSmall = teacherTypeSmall;
    }
}
