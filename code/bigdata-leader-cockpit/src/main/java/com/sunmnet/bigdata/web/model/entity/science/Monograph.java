/**
* RMonograph.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class Monograph {
    @ApiModelProperty(value="作者")
    private String author;

    @ApiModelProperty(value="专著名称")
    private String monographName;

    @ApiModelProperty(value="所在学院")
    private String academyName;

    @ApiModelProperty(value="出版时间")
    private String publicationTime;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMonographName() {
        return monographName;
    }

    public void setMonographName(String monographName) {
        this.monographName = monographName;
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