/**
* TTrainingInnovationArea.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.teaching;

import io.swagger.annotations.ApiModelProperty;

public class TrainingInnovationArea {
    @ApiModelProperty(value="设立时间")
    private String establishTime;

    @ApiModelProperty(value="名称")
    private String name;

    public String getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(String establishTime) {
        this.establishTime = establishTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}