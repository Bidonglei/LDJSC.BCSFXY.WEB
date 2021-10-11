/**
* ScrapyEsiSubjectRank.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.model.entity.science;

import io.swagger.annotations.ApiModelProperty;

public class ScrapyEsiSubjectRank {
    @ApiModelProperty(value="国内排名")
    private String nationalRanking;

    @ApiModelProperty(value="学校名称")
    private String keyUniversities;

    @ApiModelProperty(value="上次排名")
    private String lastRankings;

    @ApiModelProperty(value="最新排名")
    private String latestRankings;

    @ApiModelProperty(value="排名增长")
    private String rankingRise;

    @ApiModelProperty(value="学科数")
    private String subjectNumber;

    @ApiModelProperty(value="论文总数")
    private String thesisNumber;

    @ApiModelProperty(value="引用次数")
    private String referenceNumber;

    @ApiModelProperty(value="每篇平均引用次数")
    private String avgReferenceNumber;

    @ApiModelProperty(value="高被引用论文数")
    private String oftenReferenceNumber;

    public String getNationalRanking() {
        return nationalRanking;
    }

    public void setNationalRanking(String nationalRanking) {
        this.nationalRanking = nationalRanking;
    }

    public String getKeyUniversities() {
        return keyUniversities;
    }

    public void setKeyUniversities(String keyUniversities) {
        this.keyUniversities = keyUniversities;
    }

    public String getLastRankings() {
        return lastRankings;
    }

    public void setLastRankings(String lastRankings) {
        this.lastRankings = lastRankings;
    }

    public String getLatestRankings() {
        return latestRankings;
    }

    public void setLatestRankings(String latestRankings) {
        this.latestRankings = latestRankings;
    }

    public String getRankingRise() {
        return rankingRise;
    }

    public void setRankingRise(String rankingRise) {
        this.rankingRise = rankingRise;
    }

    public String getSubjectNumber() {
        return subjectNumber;
    }

    public void setSubjectNumber(String subjectNumber) {
        this.subjectNumber = subjectNumber;
    }

    public String getThesisNumber() {
        return thesisNumber;
    }

    public void setThesisNumber(String thesisNumber) {
        this.thesisNumber = thesisNumber;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getAvgReferenceNumber() {
        return avgReferenceNumber;
    }

    public void setAvgReferenceNumber(String avgReferenceNumber) {
        this.avgReferenceNumber = avgReferenceNumber;
    }

    public String getOftenReferenceNumber() {
        return oftenReferenceNumber;
    }

    public void setOftenReferenceNumber(String oftenReferenceNumber) {
        this.oftenReferenceNumber = oftenReferenceNumber;
    }
}