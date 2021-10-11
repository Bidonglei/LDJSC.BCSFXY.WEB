package com.sunmnet.bigdata.web.service.student.impl;


import com.sunmnet.bigdata.web.enums.EchartSeriesEnum;
import com.sunmnet.bigdata.web.enums.SeriesNameEnum;
import com.sunmnet.bigdata.web.mapper.student.StudentGraduationMapper;
import com.sunmnet.bigdata.web.model.request.student.GradationREQ;
import com.sunmnet.bigdata.web.service.student.StudentGraduationService;
import com.sunmnet.bigdata.web.util.CommonUtils;
import com.sunmnet.bigdata.web.util.EchartsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentGraduationServiceImpl implements StudentGraduationService {

	@Autowired
	private StudentGraduationMapper studentGraduationMapper;


	@Override
	public Map<String, Object> listAcademyGraduation(GradationREQ req) {
		Map<String, Object> result = new HashMap<String, Object>();
		//获得list对象
		List<Map<String, String>> listWorkingArea = studentGraduationMapper.listAcademyGraduation(req);
		//获取enum数组-坐标各个名称
		EchartSeriesEnum[] enums = {EchartSeriesEnum.GRADUATE_TO_A,EchartSeriesEnum.GRADUATE_TO_B,
				EchartSeriesEnum.GRADUATE_TO_C,EchartSeriesEnum.GRADUATE_TO_D,
				EchartSeriesEnum.GRADUATE_TO_E,EchartSeriesEnum.GRADUATE_TO_F
		};
		//调用转换数据格式方法
		result.put("chartData", EchartsUtil.list2SeriesDatas(listWorkingArea, SeriesNameEnum.NAME.getName(), CommonUtils.enumsToSeries(enums)));
		return result;
	}

	@Override
	public List<Map<String, String>> listStudentGraduateTo(GradationREQ req) {
		return studentGraduationMapper.listStudentGraduateTo(req);
	}

	@Override
	public List<Map<String, String>> listStudentCompanyType(GradationREQ req) {
		return studentGraduationMapper.listStudentCompanyType(req);
	}

	@Override
	public List<Map<String, String>> listStudentWorkingArea(GradationREQ req) {
		return studentGraduationMapper.listStudentWorkingArea(req);
	}

	@Override
	public List<Map<String, String>> listGraduateToFiveYear() {
		return studentGraduationMapper.listGraduateToFiveYear();
	}
}
