package com.sunmnet.bigdata.web.service.personnel.impl;

import com.sunmnet.bigdata.web.enums.SearchEnum;
import com.sunmnet.bigdata.web.mapper.personnel.StaffDevelopmentMapper;
import com.sunmnet.bigdata.web.model.request.personnel.AssessInfoREQ;
import com.sunmnet.bigdata.web.model.request.personnel.AssessInfoTypeREQ;
import com.sunmnet.bigdata.web.model.request.personnel.StaffDevelopmentREQ;
import com.sunmnet.bigdata.web.service.personnel.StaffDevelopmentService;
import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 人员发展
 * @author linjl
 * @date 2019/2/19
 */
@Service
public class StaffDevelopmentServiceImpl implements StaffDevelopmentService {

    @Autowired
    private StaffDevelopmentMapper staffDevelopmentMapper;

    @Override
    public List<Map<String, String>> listInternationalCountry(StaffDevelopmentREQ req) {
        return staffDevelopmentMapper.listInternationalCountry(req);
    }

    @Override
    public Map<String, String> getInternationalFourNum(StaffDevelopmentREQ req) {
        return staffDevelopmentMapper.getInternationalFourNum(req);
    }

    @Override
    public Map<String,List<Map<String, String>>> getInternationalBox() {
        Map<String,List<Map<String, String>>> map = new HashMap<>();
        //获取字典传参
        String abroadType = SearchEnum.INTERNATIONAL_BOX_A.getValue();
        String recentYear = SearchEnum.INTERNATIONAL_BOX_B.getValue();
        map.put(abroadType,staffDevelopmentMapper.getInternationalBox(abroadType));
        map.put(recentYear,staffDevelopmentMapper.getInternationalBox(recentYear));
        return map;
    }

    @Override
    public List<Map<String, String>> listCountryNameNumber(String abroadYear) {
        return staffDevelopmentMapper.listCountryNameNumber(abroadYear);
    }

    @Override
    public List<Map<String, String>> listAcademyNameNumber(String abroadYear) {
        return staffDevelopmentMapper.listAcademyNameNumber(abroadYear);
    }
}
