/**
* SUndergraduateActivities.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.student;

import io.swagger.annotations.ApiModelProperty;

public class UndergraduateActivities {
    @ApiModelProperty(value="学年")
    private String schoolyear;

    @ApiModelProperty(value="文化活动类型")
    private String activitiesType;

    @ApiModelProperty(value="举行次数")
    private String activitiesNumber;

    public String getSchoolyear() {
        return schoolyear;
    }

    public void setSchoolyear(String schoolyear) {
        this.schoolyear = schoolyear;
    }

    public String getActivitiesType() {
        return activitiesType;
    }

    public void setActivitiesType(String activitiesType) {
        this.activitiesType = activitiesType;
    }

    public String getActivitiesNumber() {
        return activitiesNumber;
    }

    public void setActivitiesNumber(String activitiesNumber) {
        this.activitiesNumber = activitiesNumber;
    }
}