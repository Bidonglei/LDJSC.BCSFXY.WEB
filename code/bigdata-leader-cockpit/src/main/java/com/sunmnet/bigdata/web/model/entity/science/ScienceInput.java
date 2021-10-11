/**
* ScienceInput.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class ScienceInput {
    @ApiModelProperty(value="投入年份")
    private String scienceYear;

    @ApiModelProperty(value="所属学院")
    private String academyName;

    @ApiModelProperty(value="投入科研费用(平摊年度科研投入费用(基本条件建设+固定资产(含折旧率))")
    private String inputMoney;

    @ApiModelProperty(value="科研场地(面积)")
    private String acreage;

    @ApiModelProperty(value="科研场地水电暖费用(金额)")
    private String utilities;

    @ApiModelProperty(value="人力资源费用(金额+人数(标签显示))")
    private String humanResourcesCost;

    @ApiModelProperty(value="在读硕士和博士生(二年级以上人数)")
    private String studyingNumber;

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

    public String getInputMoney() {
        return inputMoney;
    }

    public void setInputMoney(String inputMoney) {
        this.inputMoney = inputMoney;
    }

    public String getAcreage() {
        return acreage;
    }

    public void setAcreage(String acreage) {
        this.acreage = acreage;
    }

    public String getUtilities() {
        return utilities;
    }

    public void setUtilities(String utilities) {
        this.utilities = utilities;
    }

    public String getHumanResourcesCost() {
        return humanResourcesCost;
    }

    public void setHumanResourcesCost(String humanResourcesCost) {
        this.humanResourcesCost = humanResourcesCost;
    }

    public String getStudyingNumber() {
        return studyingNumber;
    }

    public void setStudyingNumber(String studyingNumber) {
        this.studyingNumber = studyingNumber;
    }
}