/**
* TalentTraining.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class TalentTraining {
    @ApiModelProperty(value="年份")
    private String scienceYear;

    @ApiModelProperty(value="所属学院")
    private String academyName;

    @ApiModelProperty(value="培养层次(硕士,博士)")
    private String educateGradation;

    @ApiModelProperty(value="对应数量")
    private String personNumber;

    public String getScienceYear() {
        return scienceYear;
    }

    public void setScienceYear(String scienceYear) {
        this.scienceYear = scienceYear;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public String getEducateGradation() {
        return educateGradation;
    }

    public void setEducateGradation(String educateGradation) {
        this.educateGradation = educateGradation;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
    }
}