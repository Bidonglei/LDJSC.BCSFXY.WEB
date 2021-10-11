/**
* SubjectTypeList.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class SubjectTypeList {
    @ApiModelProperty(value="学科分类(一流学科,国家重点(培育)学科)")
    private String subjectType;

    @ApiModelProperty(value="对应学科名单")
    private String subjectName;

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}