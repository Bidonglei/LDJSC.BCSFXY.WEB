package com.sunmnet.bigdata.web.service.teaching.impl;

import com.sunmnet.bigdata.web.enums.EchartSeriesEnum;
import com.sunmnet.bigdata.web.enums.SeriesNameEnum;
import com.sunmnet.bigdata.web.mapper.teaching.TeachingAchievementMapper;
import com.sunmnet.bigdata.web.model.request.teaching.TeachingAchievementREQ;
import com.sunmnet.bigdata.web.service.teaching.TeachingAchievementService;
import com.sunmnet.bigdata.web.util.CommonUtils;
import com.sunmnet.bigdata.web.util.EchartsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linjl
 * @Description 教学-教学成果
 * @date 2019/5/23
 */
@Service
public class TeachingAchievementServiceImpl implements TeachingAchievementService {

    @Autowired
    private TeachingAchievementMapper teachingAchievementMapper;

    @Override
    public List<Map<String, Object>> getPlanningTextbook() {
        return teachingAchievementMapper.getPlanningTextbook();
    }

    @Override
    public List<Map<String, Object>> listPlanningTextbookByAnnual() {
        return teachingAchievementMapper.listPlanningTextbookByAnnual();
    }

    @Override
    public List<Map<String, Object>> getExcellentTeachingMaterial() {
        return teachingAchievementMapper.getExcellentTeachingMaterial();
    }

    @Override
    public List<Map<String, Object>> getTextbooksSelection() {
        return teachingAchievementMapper.getTextbooksSelection();
    }

    @Override
    public List<Map<String, Object>> listExcellentTeachingMaterial() {
        return teachingAchievementMapper.listExcellentTeachingMaterial();
    }

    @Override
    public List<Map<String, Object>> listAchievementsMonographs() {
        return teachingAchievementMapper.listAchievementsMonographs();
    }

    @Override
    public List<Map<String, Object>> getReformProjectNumber() {
        return teachingAchievementMapper.getReformProjectNumber();
    }

    @Override
    public List<Map<String, Object>> getReformProjectAmount() {
        return teachingAchievementMapper.getReformProjectAmount();
    }

    @Override
    public List<Map<String, Object>> listReformProjectAnnual(TeachingAchievementREQ req) {
        return teachingAchievementMapper.listReformProjectAnnual(req);
    }

    @Override
    public List<Map<String, Object>> getEducationalProjectNumber() {
        return teachingAchievementMapper.getEducationalProjectNumber();
    }

    @Override
    public List<Map<String, Object>> getEducationalProjectAmount() {
        return teachingAchievementMapper.getEducationalProjectAmount();
    }

    @Override
    public Map<String, Object> listEducationalProjectAnnual(TeachingAchievementREQ req) {
        Map<String, Object> result = new HashMap<String, Object>();
        //获得list对象
        List<Map<String, String>> list = teachingAchievementMapper.listEducationalProjectAnnual(req);
        //获取enum数组-坐标各个名称
        EchartSeriesEnum[] enums = {EchartSeriesEnum.EDUCATIONAL_PROJECT_A,
                EchartSeriesEnum.EDUCATIONAL_PROJECT_B};
        //调用转换数据格式方法
        result.put("chartData", EchartsUtil.list2SeriesDatas(list, SeriesNameEnum.NAME.getName(), CommonUtils.enumsToSeries(enums)));
        return result;
    }

    @Override
    public List<Map<String, Object>> getTeachingAchievementAward(TeachingAchievementREQ req) {
        return teachingAchievementMapper.getTeachingAchievementAward(req);
    }

    @Override
    public Map<String, Object> listTeachingAchievementAward(TeachingAchievementREQ req) {
//        req.setAnnual(CommonUtils.getCurrentYear());
        Map<String, Object> result = new HashMap<String, Object>();
        //获得list对象
        List<Map<String, String>> list = teachingAchievementMapper.listTeachingAchievementAward(req);
        //获取enum数组-坐标各个名称
        EchartSeriesEnum[] enums = {EchartSeriesEnum.ACHIEVEMENT_LEVEL_A, EchartSeriesEnum.ACHIEVEMENT_LEVEL_B,
                EchartSeriesEnum.ACHIEVEMENT_LEVEL_C, EchartSeriesEnum.ACHIEVEMENT_LEVEL_D,
                EchartSeriesEnum.ACHIEVEMENT_LEVEL_E, EchartSeriesEnum.ACHIEVEMENT_LEVEL_F,
                EchartSeriesEnum.ACHIEVEMENT_LEVEL_G, EchartSeriesEnum.ACHIEVEMENT_LEVEL_H
        };
        //调用转换数据格式方法
        result.put("chartData", EchartsUtil.list2SeriesDatas(list, SeriesNameEnum.NAME.getName(), CommonUtils.enumsToSeries(enums)));
        return result;
    }

    @Override
    public Map<String, Object> listPostgraduateInnovationYear() {
        Map<String, Object> result = new HashMap<String, Object>();
        //获得list对象
        List<Map<String, String>> list = teachingAchievementMapper.listPostgraduateInnovationYear();
        //获取enum数组-坐标各个名称
        EchartSeriesEnum[] enums = {EchartSeriesEnum.INNOVATION_TYPE_A, EchartSeriesEnum.INNOVATION_TYPE_B,
                EchartSeriesEnum.INNOVATION_TYPE_C, EchartSeriesEnum.INNOVATION_TYPE_D
        };
        //调用转换数据格式方法
        result.put("chartData", EchartsUtil.list2SeriesDatas(list, SeriesNameEnum.NAME.getName(), CommonUtils.enumsToSeries(enums)));
        return result;
    }

    @Override
    public Map<String, Object> listPostgraduateInnovationAcademy() {
        Map<String, Object> result = new HashMap<String, Object>();
        //获得list对象
        List<Map<String, String>> list = teachingAchievementMapper.listPostgraduateInnovationAcademy();
        //获取enum数组-坐标各个名称
        EchartSeriesEnum[] enums = {EchartSeriesEnum.INNOVATION_TYPE_A, EchartSeriesEnum.INNOVATION_TYPE_B,
                EchartSeriesEnum.INNOVATION_TYPE_C, EchartSeriesEnum.INNOVATION_TYPE_D
        };
        //调用转换数据格式方法
        result.put("chartData", EchartsUtil.list2SeriesDatas(list, SeriesNameEnum.NAME.getName(), CommonUtils.enumsToSeries(enums)));
        return result;
    }
}
