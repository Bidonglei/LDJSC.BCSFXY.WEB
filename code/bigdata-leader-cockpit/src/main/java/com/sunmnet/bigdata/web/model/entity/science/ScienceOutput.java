/**
* RScienceOutput.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class ScienceOutput {
    @ApiModelProperty(value="产出年份")
    private String scienceYear;

    @ApiModelProperty(value="所属学院")
    private String academyName;

    @ApiModelProperty(value="论文(核心期刊数量(含高被引论文))")
    private String oftenReferenceThesis;

    @ApiModelProperty(value="获奖(显示国家级/省部级奖项数)")
    private String awardNumber;

    @ApiModelProperty(value="专利及软件著作权(数量)")
    private String patentsNumber;

    @ApiModelProperty(value="专著(数量)")
    private String monographNumber;

    @ApiModelProperty(value="年度硕士/博士人才培养(年度毕业硕士/博士生数量)")
    private String talentTraining;

    @ApiModelProperty(value="年度结算科研收益(项目结算学校收益)")
    private String scienceProceeds;

    @ApiModelProperty(value="自主研发新型仪器设备(数量)")
    private String equipmentNumber;

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

    public String getOftenReferenceThesis() {
        return oftenReferenceThesis;
    }

    public void setOftenReferenceThesis(String oftenReferenceThesis) {
        this.oftenReferenceThesis = oftenReferenceThesis;
    }

    public String getAwardNumber() {
        return awardNumber;
    }

    public void setAwardNumber(String awardNumber) {
        this.awardNumber = awardNumber;
    }

    public String getPatentsNumber() {
        return patentsNumber;
    }

    public void setPatentsNumber(String patentsNumber) {
        this.patentsNumber = patentsNumber;
    }

    public String getMonographNumber() {
        return monographNumber;
    }

    public void setMonographNumber(String monographNumber) {
        this.monographNumber = monographNumber;
    }

    public String getTalentTraining() {
        return talentTraining;
    }

    public void setTalentTraining(String talentTraining) {
        this.talentTraining = talentTraining;
    }

    public String getScienceProceeds() {
        return scienceProceeds;
    }

    public void setScienceProceeds(String scienceProceeds) {
        this.scienceProceeds = scienceProceeds;
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }
}