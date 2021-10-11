/**
* SDynamicAchievement.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.student;

import io.swagger.annotations.ApiModelProperty;

public class DynamicAchievement {
    @ApiModelProperty(value="标题")
    private String title;

    @ApiModelProperty(value="图片")
    private String image;

    @ApiModelProperty(value="图片状态")
    private String imageStatus;

    @ApiModelProperty(value="内容")
    private String detailedContent;

    @ApiModelProperty(value="发布时间")
    private String publicationTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageStatus() {
        return imageStatus;
    }

    public void setImageStatus(String imageStatus) {
        this.imageStatus = imageStatus;
    }

    public String getDetailedContent() {
        return detailedContent;
    }

    public void setDetailedContent(String detailedContent) {
        this.detailedContent = detailedContent;
    }

    public String getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(String publicationTime) {
        this.publicationTime = publicationTime;
    }
}