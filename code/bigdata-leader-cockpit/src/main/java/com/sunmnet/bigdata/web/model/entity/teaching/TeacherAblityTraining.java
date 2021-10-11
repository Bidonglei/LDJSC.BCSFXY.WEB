/**
* TTeacherAblityTraining.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.teaching;

import io.swagger.annotations.ApiModelProperty;

public class TeacherAblityTraining {
    @ApiModelProperty(value="学年")
    private String schoolYear;

    @ApiModelProperty(value="培养类型(读博士人数/境内进修人数/境外进修人数/参与教改立项课题(校级以上)人次数)")
    private String trainingType;

    @ApiModelProperty(value="人数")
    private String persionTime;

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    public String getPersionTime() {
        return persionTime;
    }

    public void setPersionTime(String persionTime) {
        this.persionTime = persionTime;
    }
}