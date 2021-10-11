package com.sunmnet.bigdata.web.service.common.impl;

import com.sunmnet.bigdata.web.enums.SearchEnum;
import com.sunmnet.bigdata.web.mapper.common.DictionaryMapper;
import com.sunmnet.bigdata.web.service.common.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Auther: lkg
 * @Date: 2019/2/18 17:43
 */
@Service
public class DictionServiceImpl implements DictionaryService {

	@Autowired
	private DictionaryMapper dictionaryMapper;

	@Override
	public List<String> getDictList(String dictType) {
		return dictionaryMapper.getDictList(dictType);
	}

	@Override
	public Map<String,List<Map<String,String>>> listSearchBox() {
		/*Map<String, List<Map<String,String>>> map = new HashMap<>();
		//获取枚举
		SearchEnum[] enums = {SearchEnum.DEPARTMENT_TYPE_A, SearchEnum.DEPARTMENT_TYPE_B, SearchEnum.DEPARTMENT_TYPE_C,
				SearchEnum.DEPARTMENT_TYPE_D,SearchEnum.DEPARTMENT_TYPE_E,SearchEnum.DEPARTMENT_TYPE_F,SearchEnum.ACADEMY_NAME,
				SearchEnum.INTERNATIONAL_BOX_A,SearchEnum.INTERNATIONAL_BOX_B,
				SearchEnum.PERSONNEL_A,SearchEnum.PERSONNEL_B,SearchEnum.PERSONNEL_C,
				SearchEnum.PERSONNEL_D,SearchEnum.PERSONNEL_E,SearchEnum.PERSONNEL_F,SearchEnum.MANAGEMENT_STATUS,
				SearchEnum.ASSESSMENT_DATE,SearchEnum.ASSESSMENT_CONTINUE,SearchEnum.ASSET_TYPE,SearchEnum.EDUCATE_GRADATION,
				SearchEnum.PROJECT_TYPE,SearchEnum.FOUR_YEAR,SearchEnum.TEACHER_TYPE_SMALL,SearchEnum.NEWCOMERS,
				SearchEnum.SCIENCE_COMPANY,SearchEnum.SCIENCE_PROJECT_TYPE,SearchEnum.AMOUNT_LEVEL,SearchEnum.SCIENCE_STATUS,SearchEnum.THREE_YEAR,SearchEnum.SOURCE,SearchEnum.SCIENCE_COMPANY,
				SearchEnum.PROJECT_TIME,SearchEnum.EXPERT_TYPE,SearchEnum.TEAM_TYPE,SearchEnum.REGION,SearchEnum.PLATFORM_LEVEL,SearchEnum.SUBJECT,SearchEnum.COOPERATION_COUNTRY,
				SearchEnum.MAJOR_DIRECTION,SearchEnum.RESEARCH_DIRECTION,SearchEnum.COOPERATION_CONTINENT,SearchEnum.TRANSACTION_AMOUNT,
				SearchEnum.KYAWARD_YEAR,SearchEnum.KYAWARD_RANK,SearchEnum.KYAWARD_TYPE,SearchEnum.KYFIVE_YEAR,SearchEnum.THESIS_TYPE,SearchEnum.ONE_SUBJECT_TYPE,SearchEnum.EVALUATE_SEMESTER_YEAR,
				SearchEnum.STUDENT_YEAR,SearchEnum.XS_GRADUATION_YEAR,SearchEnum.XS_SCHOLARSHIP_YEAR,SearchEnum.PROJECT_SECOND_TYPE,SearchEnum.PROJECT_RESEARCH_CATEGORY,SearchEnum.PROJECT_CHANNEL_TYPE,
				SearchEnum.PROJECT_DEPARTMENT,SearchEnum.PROJECT_COMPANY_NAME,SearchEnum.STATUS,SearchEnum.WARN_SEMESTER_YEAR,
				SearchEnum.JX_SCHOOL_YEAR,SearchEnum.MASTER_COURSE,SearchEnum.POSTGRADUATE_DEGREE_AWARD,SearchEnum.THESIS_DEFENSE_QUALITY,
				//高校经费分页 相关下拉框
				SearchEnum.UNIVERSITY,SearchEnum.UNIVERSITY_CHANNEL,SearchEnum.UNIVERSITY_ANNUAL,SearchEnum.UNIVERSITY_STATUS,
				//科研项目人员分页 相关下拉框
				SearchEnum.PERSON_RESEARCH_DIRECTION,SearchEnum.ONE_SUBJECT,SearchEnum.COMPANY,
				//科研仪器共享中心 相关下拉框
				SearchEnum.SHARE_CENTER_NAME,SearchEnum.SHARE_ANNUAL,SearchEnum.SHARE_TYPE
		};
		String value;
		//遍历枚举作为参数传入
		for (SearchEnum oneEnum:enums) {
			value = oneEnum.getValue();
			map.put(value,dictionaryMapper.listSearchBox(value));
		}
		return map;*/
		Map<String, List<Map<String,String>>> result = new HashMap<>();
		List<Map> list = dictionaryMapper.listSearchBox();
		List<Map<String,String>> mapList = null;
		String judge = "";
		for (Map map : list) {
			//获取key对应值
			String type = (String) map.get("type");
			//判断key第一次出现
			if (judge.equals(type)) {
				map.remove("type");
				//将map装入list
				mapList.add(map);
				result.put(type,mapList);
			} else {
				//第一次不存在或第二个类型出现赋值
				judge = type;
				mapList = new ArrayList<>();
				map.remove("type");
				//将map装入list
				mapList.add(map);
				result.put(type,mapList);
			}
		}
		return result;
	}
}
