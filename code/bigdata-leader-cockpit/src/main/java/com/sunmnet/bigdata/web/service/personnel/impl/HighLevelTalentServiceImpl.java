package com.sunmnet.bigdata.web.service.personnel.impl;

import com.sunmnet.bigdata.web.mapper.personnel.HighLevelTalentMapper;
import com.sunmnet.bigdata.web.service.personnel.HighLevelTalentService;
import com.sunmnet.bigdata.web.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *功能描述
 * @author lkg
 * @date 2019/2/19
 */
@Service
public class HighLevelTalentServiceImpl implements HighLevelTalentService {

    @Autowired
    private HighLevelTalentMapper highLevelTalentMapper;


	@Override
	public List<Map> talentCollegeDistribute() {
		List<Map> mapList = highLevelTalentMapper.talentCollegeDistribute();
		return mapList;
	}

	@Override
	public List<Map> talentSubjectDistribute() {
		List<Map> mapList = highLevelTalentMapper.talentSubjectDistribute();
		return mapList;
	}

	@Override
	public List<Map> introduceAcademicStr() {
		List<Map> mapList = highLevelTalentMapper.introduceAcademicStr();
		return mapList;
	}

	@Override
	public List<Map> introduceSubjectStr() {
		List<Map> mapList = highLevelTalentMapper.introduceSubjectStr();
		return mapList;
	}

	@Override
	public Map<String,Object> listIntroduceTalent() {
		Map<String,Object> mapResult = new HashMap<>();
		List<Map> result = highLevelTalentMapper.listIntroduceTalent();
		int min = 0;
		for (Map map:result) {
			Object introduceDate = map.get("introduceDate");
			Object teacher = map.get("list");
			List<String> list = new ArrayList<>();
			if(null != teacher){
				Collections.addAll(list, ((String)teacher).split(","));
			}
			map.put("list",list);
			if(null != introduceDate && !introduceDate.equals("")){
				int value = Integer.parseInt((String)introduceDate);
				if(value < min || min == 0){
					min = value;
				}
			}
		}
		int now = Integer.parseInt(CommonUtils.getCurrentYear());
		int[] arr = new int[now-min+1];
		for (int j=min,k=0; j <= now; j++,k++) {
			arr[k] = j;
		}
		mapResult.put("list",result);
		mapResult.put("yearList",arr);
		return mapResult;
	}
}
