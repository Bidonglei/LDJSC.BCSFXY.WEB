package com.sunmnet.bigdata.web.service.student.impl;

import com.github.pagehelper.StringUtil;
import com.sunmnet.bigdata.web.mapper.student.StudentEnrollMapper;
import com.sunmnet.bigdata.web.mapper.student.StudentProfileMapper;
import com.sunmnet.bigdata.web.service.student.StudentEnrollService;
import com.sunmnet.bigdata.web.service.student.StudentProfileService;
import com.sunmnet.bigdata.web.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *功能描述 招生分析
 * @author lkg
 * @date 2019/4/11
 */

@Service
public class StudentEnrollServiceImpl implements StudentEnrollService {

    @Autowired
    private StudentEnrollMapper studentEnrollMapper;

	@Override
	public List<Map<String, String>> undergraduateEnrollMajor(String year) {
		//获取最近招生年份
//		int year = studentEnrollMapper.maxAnnual();
		if(StringUtil.isEmpty(year)){
			year="2018";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("educateGradation","本科");
		map.put("educationType","留学生");//排除留学生
		map.put("year",year);//最近的招生时间
		List<Map<String, String>> resultInfo = studentEnrollMapper.undergraduateEnrollMajor(map);
		return resultInfo;
	}

	@Override
	public List<Map<String, String>> undergraduateEnrollAcademy(String year) {
		//获取最近招生年份
//		int year = studentEnrollMapper.maxAnnual();
		if(StringUtil.isEmpty(year)){
			year="2018";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("educateGradation","本科");
		map.put("educationType","留学生");//排除留学生
		map.put("year",year);//最近的招生时间
		List<Map<String, String>> resultInfo = studentEnrollMapper.undergraduateEnrollAcademy(map);
		return resultInfo;
	}

	@Override
	public List<Map<String, String>> undergraduateFiveEnroll() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("educateGradation","本科");
		List<Map<String, String>> resultInfo = studentEnrollMapper.undergraduateFiveEnroll(map);
		return resultInfo;
	}

	@Override
	public List<Map<String, String>> undergraduateOriginEnroll(String year) {
		//获取最近招生年份
//		int year = studentEnrollMapper.maxAnnual();
		if(StringUtil.isEmpty(year)){
			year="2018";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("educateGradation","本科");
		map.put("educationType","留学生");//排除留学生
		map.put("year",year);//最近的招生时间
		List<Map<String, String>> resultInfo = studentEnrollMapper.undergraduateOriginEnroll(map);
		return resultInfo;
	}

	@Override
	public Map sourceTypeDis(String year) {
		Map<Object, Object> resultInfo = new HashMap<>();
		//获取最近招生年份
//		int year = studentEnrollMapper.maxAnnual();
		if(StringUtil.isEmpty(year)){
			year="2018";
		}
		Map<String, Object> map = new HashMap<>();
		map.put("educateGradation","本科");
		map.put("educationType","留学生");//排除留学生
		map.put("year",year);//最近的招生时间
		List<Map<String, String>> provinceSourceType = studentEnrollMapper.provinceSourceType(map);//全国各省份生源类别
		List<Map<String, String>> sourceType = studentEnrollMapper.sourceType(map);//全国生源类别
		resultInfo.put("provinceSourceType",provinceSourceType);
		resultInfo.put("sourceType",sourceType);
		return resultInfo;
	}

	@Override
	public Map MiddleSchoolDis(String year) {
		Map<Object, Object> resultInfo = new HashMap<>();
		//获取最近招生年份
		if(StringUtil.isEmpty(year)){
			year="2018";
		}
//		int year = studentEnrollMapper.maxAnnual();
		Map<String, Object> map = new HashMap<>();
		map.put("educateGradation","本科");
		map.put("educationType","留学生");//排除留学生
		map.put("year",year);//最近的招生时间
		List<Map<String, String>> provinceMiddleSchool = studentEnrollMapper.provinceMiddleSchool(map);//全国各省份中学
		List<Map<String, String>> middleSchoolTopTen = studentEnrollMapper.middleSchoolTopTen(map);//全国中学TOP10
		resultInfo.put("provinceMiddleSchool",provinceMiddleSchool);
		resultInfo.put("middleSchoolTopTen",middleSchoolTopTen);
		return resultInfo;
	}

	@Override
	public Map<String,Object> masterStructure(String educateGradation,String year) {
		Map<String,Object> resultInfo = new HashMap<>();
		if(StringUtil.isEmpty(year)){
			year="2018";
		}
		//获取最近招生年份
//		int year = studentEnrollMapper.maxAnnual();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("educateGradation",educateGradation);
		map.put("educationType","留学生");//排除留学生
		map.put("year",year);//最近的招生时间
		int total = studentEnrollMapper.masterStructureTotal(map);//总人数
		List<Map<String, String>> list = studentEnrollMapper.masterStructure(map);
		resultInfo.put("total",total);
		resultInfo.put("list",list);
		return resultInfo;
	}

	@Override
	public List<Map<String, String>> masterFiveEnroll() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("educateGradation","本科");
		List<Map<String, String>> resultInfo = studentEnrollMapper.masterFiveEnroll(map);
		return resultInfo;
	}

	@Override
	public List<Map<String, String>> masterEnrollMajor(String type,String year) {
		//获取最近招生年份
		if(StringUtil.isEmpty(year)){
			year="2018";
		}
//		int year = studentEnrollMapper.maxAnnual();
		Map<String, Object> map = new HashMap<String, Object>();
		String educationDetailType = null;
		if ("XK".equals(type)){
			educationDetailType = "学术型";
		}else if ("ZY".equals(type)){
			educationDetailType = "专业型";
		}
		map.put("educationDetailType",educationDetailType);//区分是学科，还是专业
		map.put("educateGradation","本科");
		map.put("educationType","留学生");//排除留学生
		map.put("year",year);//最近的招生时间
		List<Map<String, String>> resultInfo = studentEnrollMapper.masterEnrollMajor(map);
		return resultInfo;
	}

	@Override
	public List<Map<String, String>> masterSourceAcademy(String educateGradation,String year) {
		//获取最近招生年份
		if(StringUtil.isEmpty(year)){
			year="2018";
		}
//		int year = studentEnrollMapper.maxAnnual();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("educateGradation",educateGradation);
		map.put("educationType","留学生");//排除留学生
		map.put("year",year);//最近的招生时间
		List<Map<String, String>> resultInfo = studentEnrollMapper.masterSourceAcademy(map);
		return resultInfo;
	}

	@Override
	public List<Map<String, String>> masterSourceMajor(String educateGradation,String year) {
		//获取最近招生年份
		if(StringUtil.isEmpty(year)){
			year="2018";
		}
//		int year = studentEnrollMapper.maxAnnual();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("educateGradation",educateGradation);
		map.put("educationType","留学生");//排除留学生
		map.put("year",year);//最近的招生时间
		List<Map<String, String>> resultInfo = studentEnrollMapper.masterSourceMajor(map);
		return resultInfo;
	}

	@Override
	public List<Map<String, String>> foreignEnrollDistribute(String year) {
		//获取最近招生年份
		if(StringUtil.isEmpty(year)){
			year="2018";
		}
//		int year = studentEnrollMapper.maxAnnual();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("educationType","留学生");
		map.put("year",year);//最近的招生时间
		List<Map<String, String>> resultInfo = studentEnrollMapper.foreignEnrollDistribute(map);
		return resultInfo;
	}

	@Override
	public List<Map<String, String>> undergraduateEnrollQuality(String enrollSubjectType,String year) {
		//获取最近招生年份
		if(StringUtil.isEmpty(year)){
			year="2018";
		}
//		int year = studentEnrollMapper.maxAnnual();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("educateGradation","本科");
		map.put("educationType","留学生");//排除留学生
		map.put("year",year);//最近的招生时间
		map.put("enrollSubjectType",enrollSubjectType);//招生学科类型 文史，理工
		List<Map<String, String>> resultInfo = studentEnrollMapper.undergraduateEnrollQuality(map);
		for (Map m : resultInfo) {
			String sort = (String)m.get("sort");
			CommonUtils.getFourDivsion(sort==null?null:sort.split(","),m);
			m.remove("sort");
		}
		return resultInfo;
	}

	@Override
	public List<Map<String, String>> undergraduateEnrollTrend(String province,String enrollSubjectType) {
		return studentEnrollMapper.undergraduateEnrollTrend(province,enrollSubjectType);
	}

	@Override
	public List<Map<String, String>> masterEnrollQuality(String year) {
		//获取最近招生年份
		if(StringUtil.isEmpty(year)){
			year="2018";
		}
//		int year = studentEnrollMapper.maxAnnual();
		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("educateGradation","硕士");
//		map.put("educationType","留学生");//排除留学生
		map.put("year",year);//最近的招生时间
		List<Map<String, String>> resultInfo = studentEnrollMapper.masterEnrollQuality(map);
		for (Map m : resultInfo) {
			Object typeList1 = m.get("list");
			List<Map> list = (List<Map>)m.get("list");
			for (Map s : list) {
				String sort = (String)s.get("sort");
				CommonUtils.getFourDivsion(sort==null?null:sort.split(","),s);
				s.remove("sort");
			}
		}
		return resultInfo;
	}
}
