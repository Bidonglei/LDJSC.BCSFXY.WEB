package com.sunmnet.bigdata.web.service.teaching;

import java.util.List;
import java.util.Map;

import com.sunmnet.bigdata.web.model.request.teaching.TeachingTeamREQ;

/**  
* @ClassName: TeachingTeamService  
* @Description: TODO
* @author lenovo  
* @date 2018年8月30日    
*/
public interface TeachingTeamService
{
    /**  
    * @Title: getTeachingTeanSankeyDistribution  
    * @Description: 师资力量-教师队伍-各学院专任教师分布情况桑基图
    * @param req
    * @return Map<String,List<Map<String,String>>>
    * @throws  
    */
    Map<String, List<Map<String, String>>> getTeachingTeanSankeyDistribution(TeachingTeamREQ req);


}
