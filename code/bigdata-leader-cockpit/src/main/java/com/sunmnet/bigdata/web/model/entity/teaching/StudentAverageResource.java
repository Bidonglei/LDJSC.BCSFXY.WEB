/**
* TStudentAverageResource.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.teaching;

import io.swagger.annotations.ApiModelProperty;

public class StudentAverageResource {
    @ApiModelProperty(value="学年")
    private String schoolYear;

    @ApiModelProperty(value="生均实验室面积")
    private String avgLaboratoryArea;

    @ApiModelProperty(value="生均教学行政用房面积")
    private String avgTeachingArea;

    @ApiModelProperty(value="生均图书")
    private String avgBooks;

    @ApiModelProperty(value="生均教学,科研仪器设备")
    private String avgEquipment;

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getAvgLaboratoryArea() {
        return avgLaboratoryArea;
    }

    public void setAvgLaboratoryArea(String avgLaboratoryArea) {
        this.avgLaboratoryArea = avgLaboratoryArea;
    }

    public String getAvgTeachingArea() {
        return avgTeachingArea;
    }

    public void setAvgTeachingArea(String avgTeachingArea) {
        this.avgTeachingArea = avgTeachingArea;
    }

    public String getAvgBooks() {
        return avgBooks;
    }

    public void setAvgBooks(String avgBooks) {
        this.avgBooks = avgBooks;
    }

    public String getAvgEquipment() {
        return avgEquipment;
    }

    public void setAvgEquipment(String avgEquipment) {
        this.avgEquipment = avgEquipment;
    }
}