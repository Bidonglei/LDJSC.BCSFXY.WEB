/**
* RMonograph.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.request.science;

import io.swagger.annotations.ApiModelProperty;

public class RMonographREQ {

    @ApiModelProperty(value="出版时间")
    private String publicationTime;

    @ApiModelProperty(value="专著数量")
    private String monographNum;

    @ApiModelProperty(value="所在学院")
    private String academyName;

    public String getMonographNum() {
        return monographNum;
    }

    public void setMonographNum(String monographNum) {
        this.monographNum = monographNum;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public String getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(String publicationTime) {
        this.publicationTime = publicationTime;
    }
}