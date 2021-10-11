/**
* ScienceBase.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class ScienceBase {
    @ApiModelProperty(value="年份")
    private String scienceYear;

    @ApiModelProperty(value="实验室名称")
    private String labName;

    @ApiModelProperty(value="固定资产投入")
    private String fixedAssetsIn;

    @ApiModelProperty(value="科研用房面积")
    private String organizationAcreage;

    @ApiModelProperty(value="科研仪器设备数量")
    private String equipmentNumber;

    @ApiModelProperty(value="仪器设备价值")
    private String equipmentValue;

    @ApiModelProperty(value="科研设施")
    private String researchFacilities;

    @ApiModelProperty(value="投资总额")
    private String grossAssets;

    public String getScienceYear() {
        return scienceYear;
    }

    public void setScienceYear(String scienceYear) {
        this.scienceYear = scienceYear;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getFixedAssetsIn() {
        return fixedAssetsIn;
    }

    public void setFixedAssetsIn(String fixedAssetsIn) {
        this.fixedAssetsIn = fixedAssetsIn;
    }

    public String getOrganizationAcreage() {
        return organizationAcreage;
    }

    public void setOrganizationAcreage(String organizationAcreage) {
        this.organizationAcreage = organizationAcreage;
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public String getEquipmentValue() {
        return equipmentValue;
    }

    public void setEquipmentValue(String equipmentValue) {
        this.equipmentValue = equipmentValue;
    }

    public String getResearchFacilities() {
        return researchFacilities;
    }

    public void setResearchFacilities(String researchFacilities) {
        this.researchFacilities = researchFacilities;
    }

    public String getGrossAssets() {
        return grossAssets;
    }

    public void setGrossAssets(String grossAssets) {
        this.grossAssets = grossAssets;
    }
}