package com.sunmnet.bigdata.web.mapper.teaching;

import com.sunmnet.bigdata.web.model.request.teaching.TeachingAchievementREQ;

import java.util.List;
import java.util.Map;

/**
 * @Description 教学-教学成果
 * @author linjl
 * @date 2019/5/23
 */
public interface TeachingAchievementMapper {

    /**
     * @Description 教材建设:规划教材
     * @author linjl
     * @date 2019/5/24
     */
    List<Map<String,Object>> getPlanningTextbook();

    /**
     * @Description 教材建设:历年规划教材情况
     * @author linjl
     * @date 2019/5/24
     */
    List<Map<String,Object>> listPlanningTextbookByAnnual();

    /**
     * @Description 教材建设:教材选优情况
     * @author linjl
     * @date 2019/5/24
     */
    List<Map<String,Object>> getExcellentTeachingMaterial();

    /**
     * @Description 教材建设:教材选新情况
     * @author linjl
     * @date 2019/5/24
     */
    List<Map<String,Object>> getTextbooksSelection();

    /**
     * @Description 教材建设:优秀教材
     * @author linjl
     * @date 2019/5/24
     */
    List<Map<String,Object>> listExcellentTeachingMaterial();

    /**
     * @Description 教材建设:专著情况
     * @author linjl
     * @date 2019/5/24
     */
    List<Map<String,Object>> listAchievementsMonographs();

    /**
     * @Description 本科生教改:教育教学研究与改革项目数量分析
     * @author linjl
     * @date 2019/5/24
     */
    List<Map<String,Object>> getReformProjectNumber();

    /**
     * @Description 本科生教改:教育教学研究与改革项目经费分析
     * @author linjl
     * @date 2019/5/24
     */
    List<Map<String,Object>> getReformProjectAmount();

    /**
     * @Description 本科生教改:各学院教改情况
     * @author linjl
     * @date 2019/5/24
     */
    List<Map<String,Object>> listReformProjectAnnual(TeachingAchievementREQ req);

    /**
     * @Description 研究生教改:校级学位与研究生教育研究基金等教改项目-数量
     * @author linjl
     * @date 2019/5/24
     */
    List<Map<String,Object>> getEducationalProjectNumber();

    /**
     * @Description 研究生教改:校级学位与研究生教育研究基金等教改项目-金额
     * @author linjl
     * @date 2019/5/24
     */
    List<Map<String,Object>> getEducationalProjectAmount();

    /**
     * @Description 研究生教改:各学院教改情况
     * @author linjl
     * @date 2019/5/24
     */
    List<Map<String,String>> listEducationalProjectAnnual(TeachingAchievementREQ req);

    /**
     * @Description 教学成果奖:获奖累计值统计
     * @author linjl
     * @date 2019/5/24
     */
    List<Map<String,Object>> getTeachingAchievementAward(TeachingAchievementREQ req);

    /**
     * @Description 教学成果奖:各学院获奖分布
     * @author linjl
     * @date 2019/5/24
     */
    List<Map<String,String>> listTeachingAchievementAward(TeachingAchievementREQ req);

    /**
     * @Description 研究生创新:研究生创新教育
     * @author linjl
     * @date 2019/5/24
     */
    List<Map<String,String>> listPostgraduateInnovationYear();

    /**
     * @Description 研究生创新:各学院研究生创新教育
     * @author linjl
     * @date 2019/5/24
     */
    List<Map<String,String>> listPostgraduateInnovationAcademy();
}
