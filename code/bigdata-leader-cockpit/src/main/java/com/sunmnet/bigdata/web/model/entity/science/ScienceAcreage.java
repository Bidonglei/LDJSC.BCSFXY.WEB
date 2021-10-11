/**
* ScienceAcreage.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScienceAcreage {
    @ApiModelProperty(value="年份")
    private String scienceYear;

    @ApiModelProperty(value="研发所属学院")
    private String academyName;

    @ApiModelProperty(value="科研面积")
    private String scienceAcreage;

    @ApiModelProperty(value="办公面积")
    private String workAcreage;

    @ApiModelProperty(value="教学面积")
    private String teachingAcreage;

    @ApiModelProperty(value="科研面积含人数")
    private String sciencePeople;

    @ApiModelProperty(value="办公面积含人数")
    private String workPeople;

    @ApiModelProperty(value="教学面积含人数")
    private String teachingPeople;

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

    public String getScienceAcreage() {
        return scienceAcreage;
    }

    public void setScienceAcreage(String scienceAcreage) {
        this.scienceAcreage = scienceAcreage;
    }

    public String getWorkAcreage() {
        return workAcreage;
    }

    public void setWorkAcreage(String workAcreage) {
        this.workAcreage = workAcreage;
    }

    public String getTeachingAcreage() {
        return teachingAcreage;
    }

    public void setTeachingAcreage(String teachingAcreage) {
        this.teachingAcreage = teachingAcreage;
    }

    public String getSciencePeople() {
        return sciencePeople;
    }

    public void setSciencePeople(String sciencePeople) {
        this.sciencePeople = sciencePeople;
    }

    public String getWorkPeople() {
        return workPeople;
    }

    public void setWorkPeople(String workPeople) {
        this.workPeople = workPeople;
    }

    public String getTeachingPeople() {
        return teachingPeople;
    }

    public void setTeachingPeople(String teachingPeople) {
        this.teachingPeople = teachingPeople;
    }
}