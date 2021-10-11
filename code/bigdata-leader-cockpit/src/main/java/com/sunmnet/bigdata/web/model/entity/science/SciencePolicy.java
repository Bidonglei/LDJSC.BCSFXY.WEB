/**
* SciencePolicy.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="科研政策信息表")
public class SciencePolicy {
    @ApiModelProperty(value="校内/国家及省部级")
    private String webpageSource;

    @ApiModelProperty(value="主要标题")
    private String mainTitle;

    @ApiModelProperty(value="标题")
    private String title;

    @ApiModelProperty(value="发表时间")
    private String publicationTime;

    @ApiModelProperty(value="部门")
    private String department;

    @ApiModelProperty(value="url保存")
    private String url;

    public String getWebpageSource() {
        return webpageSource;
    }

    public void setWebpageSource(String webpageSource) {
        this.webpageSource = webpageSource;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(String publicationTime) {
        this.publicationTime = publicationTime;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}