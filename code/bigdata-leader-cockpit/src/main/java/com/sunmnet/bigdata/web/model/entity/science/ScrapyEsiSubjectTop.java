/**
* ScrapyEsiSubjectTop.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class ScrapyEsiSubjectTop {
    @ApiModelProperty(value="学科名称")
    private String subjectName;

    @ApiModelProperty(value="上榜学校数量")
    private String rankingNumber;

    @ApiModelProperty(value="西工大排名名次")
    private String rankings;

    @ApiModelProperty(value="排名变动位次(较去年)分正负")
    private String rankingChange;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getRankingNumber() {
        return rankingNumber;
    }

    public void setRankingNumber(String rankingNumber) {
        this.rankingNumber = rankingNumber;
    }

    public String getRankings() {
        return rankings;
    }

    public void setRankings(String rankings) {
        this.rankings = rankings;
    }

    public String getRankingChange() {
        return rankingChange;
    }

    public void setRankingChange(String rankingChange) {
        this.rankingChange = rankingChange;
    }
}