package com.sunmnet.bigdata.web.service.personnel.impl;

import com.sunmnet.bigdata.web.enums.SearchEnum;
import com.sunmnet.bigdata.web.mapper.personnel.TrainingEvaluationMapper;
import com.sunmnet.bigdata.web.model.request.personnel.AssessInfoTypeREQ;
import com.sunmnet.bigdata.web.model.request.personnel.AssessInfoREQ;
import com.sunmnet.bigdata.web.service.personnel.TrainingEvaluationService;
import com.sunmnet.bigdata.web.util.CodeUtil;
import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description 人员考核
 * @author linjl
 * @date 2019/2/19
 */
@Service
public class TrainingEvaluationServiceImpl implements TrainingEvaluationService {

    @Autowired
    private TrainingEvaluationMapper trainingEvaluationMapper;


	@Override
	public List<Map> listAssessInfoByName(AssessInfoREQ req) {
		return trainingEvaluationMapper.listAssessInfoByName(req);
	}

	@Override
	public List<Map<String, String>> getAssessmentTypeNum(AssessInfoTypeREQ req) {
        List<Map<String, String>> getAssessmentTypeNum = trainingEvaluationMapper.getAssessmentTypeNum(req);
        List<Map<String, String>> list = new ArrayList<>();
        //获取固定map
        Map<Integer, String> mapType = CodeUtil.getAssessmentType();
        //按固定顺序排序
        for (int i=1;i<=mapType.size();i++){
            for (Map<String, String> map : getAssessmentTypeNum) {
                if (mapType.get(i).equals(map.get("name"))){
                    list.add(map);
                }
            }
        }
		return list;
	}

	@Override
	public List<Map<String, List<String>>> getAssessmentDepartment() {
		List<Map<String, List<String>>> list = new ArrayList<Map<String, List<String>>>();
		//获取枚举
		SearchEnum[] enums = {SearchEnum.DEPARTMENT_TYPE_A, SearchEnum.DEPARTMENT_TYPE_B, SearchEnum.DEPARTMENT_TYPE_C,
				SearchEnum.DEPARTMENT_TYPE_D,SearchEnum.DEPARTMENT_TYPE_E,SearchEnum.DEPARTMENT_TYPE_F};
		String name;
		String value;
		//遍历枚举作为参数传入
		for (SearchEnum oneEnum:enums) {
			name = oneEnum.getName();
            value = oneEnum.getValue();
			list.add(Maps.newHashMap(value,trainingEvaluationMapper.getAssessmentDepartment(name)));
		}
		return list;
	}
}
