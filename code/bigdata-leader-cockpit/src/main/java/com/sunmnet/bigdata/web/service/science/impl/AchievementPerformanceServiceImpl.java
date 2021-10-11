package com.sunmnet.bigdata.web.service.science.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.sunmnet.bigdata.common.exception.BusinessException;
import com.sunmnet.bigdata.web.mapper.science.AchievementPerformanceMapper;
import com.sunmnet.bigdata.web.mapper.science.ScienceProjectMapper;
import com.sunmnet.bigdata.web.model.request.science.MonographInfoPageREQ;
import com.sunmnet.bigdata.web.model.request.science.ProjectDetailPageREQ;
import com.sunmnet.bigdata.web.service.science.AchievementPerformanceService;
import com.sunmnet.bigdata.web.service.science.ScienceInfoService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AchievementPerformanceServiceImpl implements AchievementPerformanceService {

    @Autowired
    private AchievementPerformanceMapper achievementPerformanceMapper;


	@Override
	public List<Map> esiRankingPapers() {
		return achievementPerformanceMapper.esiRankingPapers();
	}

	@Override
	public List<Map> esiCitedHotspot() {
		return achievementPerformanceMapper.esiCitedHotspot();
	}

	@Override
	public List<Map> esiRankContrast() {
		return achievementPerformanceMapper.esiRankContrast();
	}

	@Override
	public List<Map> esiSubjectRank() {
		return achievementPerformanceMapper.esiSubjectRank();
	}

	@Override
	public List<Map> esiPotentialSubject() {
		return achievementPerformanceMapper.esiPotentialSubject();
	}

	@Override
	public List<Map> patentNum() {
		return achievementPerformanceMapper.patentNum();
	}

	@Override
	public Map patentTopFive() {
		Map result = new HashedMap();
		List<Map> apply = achievementPerformanceMapper.applyNum();//专利申请数TOP5
		List<Map> grant = achievementPerformanceMapper.grantNum();//专利授权数TOP5
		List<Map> invent = achievementPerformanceMapper.inventNum();//专利转化件数TOP5
		result.put("apply",apply);
		result.put("grant",grant);
		result.put("invent",invent);
		return result;
	}

	@Override
	public List<Map> patentTransferAmount() {
		return achievementPerformanceMapper.patentTransferAmount();
	}

	@Override
	public Map patentTransferTopFive() {
		Map result = new HashedMap();
		List<Map> sell = achievementPerformanceMapper.sellAmount();//出售总金额TOP5
		List<Map> real = achievementPerformanceMapper.realAmount();//实际收入金额TOP5
		List<Map> contract = achievementPerformanceMapper.contractNum();//专利转让合同数TOP5
		result.put("sell",sell);
		result.put("real",real);
		result.put("contract",contract);
		return result;
	}

	@Override
	public List<Map> publishThesis(String type) {
		return achievementPerformanceMapper.publishThesis(type);
	}

	@Override
	public List<Map> thesisSCI() {
		return achievementPerformanceMapper.thesisSCI();
	}

	@Override
	public List<Map> thesisSSCI() {
		return achievementPerformanceMapper.thesisSSCI();
	}

	@Override
	public List<Map> monographDepNum() {
		return achievementPerformanceMapper.monographDepNum();
	}

	@Override
	public List<Map> monographDepTopFive() {
		return achievementPerformanceMapper.monographDepTopFive();
	}

	@Override
	public PageInfo<Map> monographInfo(MonographInfoPageREQ monographInfoPageREQ) {
		PageHelper.startPage(monographInfoPageREQ.getPageNum(), monographInfoPageREQ.getPageSize());
		List<Map> list = achievementPerformanceMapper.monographInfo(monographInfoPageREQ);
		PageInfo<Map> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
}
