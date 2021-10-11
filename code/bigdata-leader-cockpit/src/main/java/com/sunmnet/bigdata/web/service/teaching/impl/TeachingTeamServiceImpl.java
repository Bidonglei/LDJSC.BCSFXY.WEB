package com.sunmnet.bigdata.web.service.teaching.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sunmnet.bigdata.web.mapper.teaching.TeacherInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunmnet.bigdata.web.model.request.teaching.TeachingTeamREQ;
import com.sunmnet.bigdata.web.service.teaching.TeachingTeamService;

@Service
public class TeachingTeamServiceImpl implements TeachingTeamService
{
    @Autowired
    private TeacherInfoMapper mapper;
    
    /**  
    * @Title: getTeachingTeanSankeyDistribution  
    * @Description: 师资力量-教师队伍-各学院专任教师分布情况桑基图
    * @param req
    * @return Map<String,List<Map<String,String>>>
    * @throws  
    */
    @Override
    public Map<String, List<Map<String, String>>> getTeachingTeanSankeyDistribution(TeachingTeamREQ req)
    {
        List<Map<String, String>> data = mapper.listJobTitleOrderDesc(req);
        List<Map<String, String>> links = mapper.getDistributionByAcademy(req);
        Map<String, List<Map<String, String>>> result = new HashMap<String, List<Map<String, String>>>(2);
        result.put("data", data);
        result.put("links", links);
        // 聘任类型统计
        List<Map<String, String>> appointments = mapper.listAppointmentType(req);
        result.put("appointments", appointments);
        return result;
    }

}
