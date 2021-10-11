package com.sunmnet.bigdata.web.service.student.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.sunmnet.bigdata.common.request.BasePageRequest;
import com.sunmnet.bigdata.web.mapper.student.StudentEducationTrainingMapper;
import com.sunmnet.bigdata.web.model.entity.student.InternationExchangeRequest;
import com.sunmnet.bigdata.web.model.request.teaching.GraduateCourseREQ;
import com.sunmnet.bigdata.web.service.student.StudentEducationTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *功能描述 教育培养
 * @author lkg
 * @date 2019/4/17
 */

@Service
public class StudentEducationTrainingServiceImpl implements StudentEducationTrainingService {

    @Autowired
    private StudentEducationTrainingMapper studentEducationTrainingMapper;

	@Override
	public Map<String,Object> internationalExchange(
			InternationExchangeRequest internationExchangeRequest) {
		Map<String,Object> map = new HashMap<>();
		//国际交流国家数目
		int countryTotal = studentEducationTrainingMapper.interExchangeCountryTotal(internationExchangeRequest);
		//国际交流人次
		int exchangeTime = studentEducationTrainingMapper.interExchangeTime(internationExchangeRequest);
		//国际交流具体国家
		List<Map<String, String>> countryList = studentEducationTrainingMapper.interExchangeCountry(internationExchangeRequest);
		map.put("countryTotal",countryTotal);
		map.put("exchangeTime",exchangeTime);
		map.put("countryList",countryList);
		return map;
	}

	@Override
	public List<Map<String, String>> annualScholarship() {
		return studentEducationTrainingMapper.annualScholarship();
	}

	@Override
	public List<Map<String, String>> academyScholarship(String annual) {
		return studentEducationTrainingMapper.academyScholarship(annual);
	}

	@Override
	public List<Map<String, String>> scholarshipDetail(String annual) {
		return studentEducationTrainingMapper.scholarshipDetail(annual);
	}

	@Override
	public List<Map<String, String>> whereaboutsType(String annual) {
		return studentEducationTrainingMapper.whereaboutsType(annual);
	}

	@Override
	public List<Map<String, String>> whereaboutsDetailType(String annual) {
		return studentEducationTrainingMapper.whereaboutsDetailType(annual);
	}

	@Override
	public Map<String, Object> scholarship(String annual) {
		if(StringUtil.isEmpty(annual)){
			annual="2018";
		}
		Map<String, Object> resultInfo = new HashMap<>();
		List<Map<String, String>> list = studentEducationTrainingMapper.profitStudent("奖学金",annual);
		int total = studentEducationTrainingMapper.profitStudentTotal("奖学金",annual);
		resultInfo.put("list",list);
		resultInfo.put("total",total);
		return resultInfo;
	}

	@Override
	public Map<String, Object> studentLoans(String annual) {
		if(StringUtil.isEmpty(annual)){
			annual="2018";
		}
		Map<String, Object> resultInfo = new HashMap<>();
		List<Map<String, String>> list = studentEducationTrainingMapper.profitStudent("助学贷款",annual);
		int total = studentEducationTrainingMapper.profitStudentTotal("助学贷款",annual);
		resultInfo.put("list",list);
		resultInfo.put("total",total);
		return resultInfo;
	}

	@Override
	public Map<String, Object> tuitionReduction(String annual) {
		if(StringUtil.isEmpty(annual)){
			annual="2018";
		}
		Map<String, Object> resultInfo = new HashMap<>();
		List<Map<String, String>> list = studentEducationTrainingMapper.profitStudent("减免学费",annual);
		int total = studentEducationTrainingMapper.profitStudentTotal("减免学费",annual);
		resultInfo.put("list",list);
		resultInfo.put("total",total);
		return resultInfo;
	}

	@Override
	public List<Map<String, String>> aidFinanciallyParty(String annual) {
		if(StringUtil.isEmpty(annual)){
			annual="2018";
		}
		return studentEducationTrainingMapper.aidFinanciallyParty(annual);
	}

	@Override
	public PageInfo<Map> awardDetailPage(BasePageRequest basePageRequest) {
		if (StringUtil.isNotEmpty(basePageRequest.getSort()) && StringUtil.isNotEmpty(basePageRequest.getOrder())){
			PageHelper.orderBy(basePageRequest.getSort()+" "+basePageRequest.getOrder());
		}
		PageHelper.startPage(basePageRequest.getPageNum(), basePageRequest.getPageSize());
		List<Map> list = studentEducationTrainingMapper.awardDetailPage(basePageRequest);
		PageInfo<Map> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public Map<String,Object> studentAward(String achieveType) {
		Map<String,Object> result = new HashMap<>();
		result.put("studentAward",studentEducationTrainingMapper.studentAward(achieveType));
		result.put("legend",studentEducationTrainingMapper.getStudentAwardLegend(achieveType));
		return result;
	}

	@Override
	public Map<String,Object> academyAward(String achieveType) {
		Map<String,Object> result = new HashMap<>();
		result.put("academyAward",studentEducationTrainingMapper.academyAward(achieveType));
		result.put("legend",studentEducationTrainingMapper.getAcademyAwardLegend(achieveType));
		return result;
	}

	@Override
	public List<Map<String, String>> personnelTraining() {
		return studentEducationTrainingMapper.personnelTraining();
	}

	@Override
	public List<Map<String, String>> publishPaper() {
		return studentEducationTrainingMapper.publishPaper();
	}

	@Override
	public List<Map<String, String>> applicationPatent() {
		return studentEducationTrainingMapper.applicationPatent();
	}

	@Override
	public List<Map<String, String>> applicationWriting() {
		return studentEducationTrainingMapper.applicationWriting();
	}

	@Override
	public List<Map<String, String>> association() {
		return studentEducationTrainingMapper.association();
	}

	@Override
	public List<Map<String, String>> abroadInfo() {
		return studentEducationTrainingMapper.abroadInfo();
	}
}
