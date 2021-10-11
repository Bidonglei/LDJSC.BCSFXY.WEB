/**
* ResourcesEquipment.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.common;

import io.swagger.annotations.ApiModelProperty;

public class ResourcesEquipment {
    @ApiModelProperty(value="统计年份")
    private String countYear;

    @ApiModelProperty(value="实验室类型(基础实验室,专业实验室,实训场所等)")
    private String labType;

    @ApiModelProperty(value="拥有实验室数量")
    private String labNumber;

    @ApiModelProperty(value="实验室面积")
    private String labAcreage;

    @ApiModelProperty(value="承担实验室课程门数")
    private String courseNumber;

    @ApiModelProperty(value="设备台套数")
    private String equipmentNumber;

    public String getCountYear() {
        return countYear;
    }

    public void setCountYear(String countYear) {
        this.countYear = countYear;
    }

    public String getLabType() {
        return labType;
    }

    public void setLabType(String labType) {
        this.labType = labType;
    }

    public String getLabNumber() {
        return labNumber;
    }

    public void setLabNumber(String labNumber) {
        this.labNumber = labNumber;
    }

    public String getLabAcreage() {
        return labAcreage;
    }

    public void setLabAcreage(String labAcreage) {
        this.labAcreage = labAcreage;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }
}