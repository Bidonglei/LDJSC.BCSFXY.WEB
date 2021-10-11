package com.sunmnet.bigdata.web.service.science.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.sunmnet.bigdata.web.mapper.science.ScienceAwardsMapper;
import com.sunmnet.bigdata.web.model.request.science.NurturingPlanREQ;
import com.sunmnet.bigdata.web.model.request.science.ScienceAwardsREQ;
import com.sunmnet.bigdata.web.service.science.ScienceAwardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScienceAwardsServiceImpl implements ScienceAwardsService {

    @Autowired
    private ScienceAwardsMapper scienceAwardsMapper;

    @Override
    public List<Map<String, Object>> listIndicatorsCompleted(ScienceAwardsREQ req) {
        return scienceAwardsMapper.listIndicatorsCompleted(req);
    }

    @Override
    public List<Map<String, Object>> listUniversityNationalAwards(ScienceAwardsREQ req) {
        return scienceAwardsMapper.listUniversityNationalAwards(req);
    }

    @Override
    public Map<String, Object> listHistoryNationalAward() {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Map<String, Object>> historyAward = scienceAwardsMapper.listHistoryNationalAward();
        List<Map<String, Object>> historyByYear = scienceAwardsMapper.listHistoryNationalByYear();
        result.put("historyAward",historyAward);
        result.put("historyByYear",historyByYear);
        return result;
    }

    @Override
    public List<Map<String, Object>> listHistoryNationalByYear() {
        return scienceAwardsMapper.listHistoryNationalByYear();
    }

    @Override
    public List<Map<String, Object>> listNationalAwardInfo(ScienceAwardsREQ req) {
        return scienceAwardsMapper.listNationalAwardInfo(req);
    }

    @Override
    public Map<String, Object> listProvincialAwardInfo(ScienceAwardsREQ req) {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Map<String, Object>> provincialAward = scienceAwardsMapper.listProvincialAwardInfo(req);
        req.setAwardRank("一等奖");
        List<Map<String, Object>> provincialAwardOne = scienceAwardsMapper.listProvincialAwardInfo(req);
        result.put("provincialAward",provincialAward);
        result.put("provincialAwardOne",provincialAwardOne);
        return result;
    }

    @Override
    public List<Map<String, Object>> listProvincialAwardOne(ScienceAwardsREQ req) {
        req.setAwardRank("一等奖");
        return scienceAwardsMapper.listProvincialAwardInfo(req);
    }

    @Override
    public List<Map<String, Object>> listHistoryProvincialAward() {
        return scienceAwardsMapper.listHistoryProvincialAward();
    }

    @Override
    public List<Map<String, Object>> listProvincialAwardByAcademy(ScienceAwardsREQ req) {
        return scienceAwardsMapper.listProvincialAwardByAcademy(req);
    }

    @Override
    public List<Map<String, Object>> listAchievementsConversionByYear() {
        return scienceAwardsMapper.listAchievementsConversionByYear();
    }

    @Override
    public List<Map<String, Object>> listAchiConversionBydepart(ScienceAwardsREQ req) {
        return scienceAwardsMapper.listAchiConversionBydepart(req);
    }

    @Override
    public List<Map> listAcademyComplete() {
        return scienceAwardsMapper.listAcademyComplete();
    }

    @Override
    public List<Map> listChargeComplete(String departmentName) {
        return scienceAwardsMapper.listChargeComplete(departmentName);
    }

    @Override
    public List<Map> listNurturingPlanAndDeclare() {
        return scienceAwardsMapper.listNurturingPlanAndDeclare();
    }

    @Override
    public PageInfo<Map> listNurturingPlanCompletion(NurturingPlanREQ req) {
        if (StringUtil.isNotEmpty(req.getSort()) && StringUtil.isNotEmpty(req.getOrder())){
            PageHelper.orderBy(req.getSort()+" "+req.getOrder());
        }
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<Map> list = scienceAwardsMapper.listNurturingPlanCompletion(req);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Map<String,Object> listFiveYearNurturingPlan() {
        Map<String,Object> result = new HashMap<>();
        result.put("nurturingPlan",scienceAwardsMapper.listFiveYearNurturingPlan());
        result.put("legend",scienceAwardsMapper.listFiveYearLegend());
        return result;
    }

}
