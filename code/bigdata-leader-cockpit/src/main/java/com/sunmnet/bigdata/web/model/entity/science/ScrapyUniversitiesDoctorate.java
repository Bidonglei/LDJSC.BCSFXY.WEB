/**
* ScrapyUniversitiesDoctorate.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class ScrapyUniversitiesDoctorate {
    @ApiModelProperty(value="年份")
    private String scienceYear;

    @ApiModelProperty(value="学校名")
    private String keyUniversities;

    @ApiModelProperty(value="对应师均博士学位授予数")
    private String avgDoctorateNumber;

    public String getScienceYear() {
        return scienceYear;
    }

    public void setScienceYear(String scienceYear) {
        this.scienceYear = scienceYear;
    }

    public String getKeyUniversities() {
        return keyUniversities;
    }

    public void setKeyUniversities(String keyUniversities) {
        this.keyUniversities = keyUniversities;
    }

    public String getAvgDoctorateNumber() {
        return avgDoctorateNumber;
    }

    public void setAvgDoctorateNumber(String avgDoctorateNumber) {
        this.avgDoctorateNumber = avgDoctorateNumber;
    }
}