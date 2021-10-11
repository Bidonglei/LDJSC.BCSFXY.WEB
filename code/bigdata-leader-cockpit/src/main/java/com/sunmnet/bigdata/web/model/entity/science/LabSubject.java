/**
* LabSubject.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class LabSubject {
    @ApiModelProperty(value="实验室名称")
    private String labName;

    @ApiModelProperty(value="实验室类型对应学科(自然科学，农业科学等)")
    private String subjectName;

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}