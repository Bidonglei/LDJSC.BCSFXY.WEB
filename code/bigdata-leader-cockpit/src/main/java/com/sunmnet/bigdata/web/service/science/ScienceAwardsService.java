package com.sunmnet.bigdata.web.service.science;

import com.github.pagehelper.PageInfo;
import com.sunmnet.bigdata.web.model.request.science.NurturingPlanREQ;
import com.sunmnet.bigdata.web.model.request.science.ScienceAwardsREQ;

import java.util.List;
import java.util.Map;

/**
 * @Description 科研域-成果绩效-获奖
 * @author linjl
 * @date 2019/5/16
 */
public interface ScienceAwardsService {

    /**
     * @Description 各学院国家奖任务指标及完成数量
     * @author linjl
     * @date 2019/5/17
     */
    List<Map<String, Object>> listIndicatorsCompleted(ScienceAwardsREQ req);

    /**
     * @Description 国家级奖项高校对比/列表
     * @author linjl
     * @date 2019/5/17
     */
    List<Map<String, Object>> listUniversityNationalAwards(ScienceAwardsREQ req);

    /**
     * @Description 国家奖-历史获奖
     * @author linjl
     * @date 2019/5/24
     */
    Map<String, Object> listHistoryNationalAward();

    /**
     * @Description 国家奖-历史获奖-柱图
     * @author linjl
     * @date 2019/5/17
     */
    List<Map<String, Object>> listHistoryNationalByYear();

    /**
     * @Description 国家奖列表
     * @author linjl
     * @date 2019/5/17
     */
    List<Map<String, Object>> listNationalAwardInfo(ScienceAwardsREQ req);

    /**
     * @Description 省部级奖及社会奖-总体情况
     * @author linjl
     * @date 2019/5/24
     */
    Map<String, Object> listProvincialAwardInfo(ScienceAwardsREQ req);

    /**
     * @Description 省部级奖及社会奖-总体情况(一等奖)
     * @author linjl
     * @date 2019/5/17
     */
    List<Map<String, Object>> listProvincialAwardOne(ScienceAwardsREQ req);

    /**
     * @Description 省部级奖及社会奖-历史获奖
     * @author linjl
     * @date 2019/5/17
     */
    List<Map<String, Object>> listHistoryProvincialAward();

    /**
     * @Description 省部级奖及社会奖-学院获奖分布
     * @author linjl
     * @date 2019/5/17
     */
    List<Map<String, Object>> listProvincialAwardByAcademy(ScienceAwardsREQ req);

    /**
     * @Description 近五年成果转化趋势
     * @author linjl
     * @date 2019/5/17
     */
    List<Map<String, Object>> listAchievementsConversionByYear();

    /**
     * @Description 成果转化分布
     * @author linjl
     * @date 2019/5/17
     */
    List<Map<String, Object>> listAchiConversionBydepart(ScienceAwardsREQ req);

    /**
     *功能描述 各学院培育项目当年完成度
     * @author lkg
     * @date 2019/6/27
     */
    List<Map> listAcademyComplete();

    /**
     *功能描述 当年各项目培育完成度
     * @author lkg
     * @date 2019/6/27
     */
    List<Map> listChargeComplete(String departmentName);

    /**
     * @Description 国家奖五年培育计划及完成情况
     * @author linjl
     * @date 2019/8/8
     */
    List<Map> listNurturingPlanAndDeclare();

    /**
     * @Description 国家奖五年培育计划及完成情况清单
     * @author linjl
     * @date 2019/8/8
     */
    PageInfo<Map> listNurturingPlanCompletion(NurturingPlanREQ req);

    /**
     * @Description 国家奖各学院五年规划情况
     * @author linjl
     * @date 2019/8/8
     */
    Map<String,Object> listFiveYearNurturingPlan();

}
