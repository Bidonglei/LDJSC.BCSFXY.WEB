/**
* Patents.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class Patents {
    @ApiModelProperty(value="年份")
    private String scienceYear;

    @ApiModelProperty(value="申请/授权")
    private String submitType;

    @ApiModelProperty(value="发明专利")
    private String inventPatent;

    @ApiModelProperty(value="其他专利")
    private String otherPatent;

    @ApiModelProperty(value="计算机软件著作权")
    private String computerCopyright;

    public String getScienceYear() {
        return scienceYear;
    }

    public void setScienceYear(String scienceYear) {
        this.scienceYear = scienceYear;
    }

    public String getSubmitType() {
        return submitType;
    }

    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }

    public String getInventPatent() {
        return inventPatent;
    }

    public void setInventPatent(String inventPatent) {
        this.inventPatent = inventPatent;
    }

    public String getOtherPatent() {
        return otherPatent;
    }

    public void setOtherPatent(String otherPatent) {
        this.otherPatent = otherPatent;
    }

    public String getComputerCopyright() {
        return computerCopyright;
    }

    public void setComputerCopyright(String computerCopyright) {
        this.computerCopyright = computerCopyright;
    }
}