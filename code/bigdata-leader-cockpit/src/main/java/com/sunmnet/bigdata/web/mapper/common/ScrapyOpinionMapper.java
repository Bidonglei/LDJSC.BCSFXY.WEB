/**
* CScrapyOpinionMapper.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.mapper.common;

import java.util.List;

import com.sunmnet.bigdata.web.model.entity.common.ScrapyOpinion;
import com.sunmnet.bigdata.web.model.request.common.OpinionREQ;
import com.sunmnet.bigdata.web.model.request.common.ScrapyOpinionREQ;

public interface ScrapyOpinionMapper {
    /**
     * 舆情列表展示
     * <p>Title: listOpinion</p>
     * @param scrapyOpinionREQ
     * @return
     */
    List<ScrapyOpinion> listOpinion(ScrapyOpinionREQ scrapyOpinionREQ);
    /**
     * 舆情详细信息
     * <p>Title: getOneOpinion</p>
     * @param scrapyOpinionREQ
     * @return
     */
    ScrapyOpinion getScrapyOpinion(OpinionREQ opinionREQ);
    
}