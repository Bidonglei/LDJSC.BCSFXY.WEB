package com.sunmnet.bigdata.web.service.science.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.sunmnet.bigdata.common.exception.BusinessException;
import com.sunmnet.bigdata.web.mapper.science.ScienceProjectMapper;
import com.sunmnet.bigdata.web.mapper.science.ScienceResourceMapper;
import com.sunmnet.bigdata.web.model.request.science.*;
import com.sunmnet.bigdata.web.service.science.ScienceResourceService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class ScienceResourceServiceImpl implements ScienceResourceService {

    @Autowired
    private ScienceResourceMapper scienceResourceMapper;



	@Override
	public PageInfo<Map> researchExpertPage(ResearchExpertPageREQ researchExpertPageREQ) {
		PageHelper.startPage(researchExpertPageREQ.getPageNum(), researchExpertPageREQ.getPageSize());
		List<Map> list = scienceResourceMapper.researchExpertPage(researchExpertPageREQ);
		PageInfo<Map> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public List<Map> researchTitleDis() {
		return scienceResourceMapper.researchTitleDis();
	}

	@Override
	public List<Map> researchEducationDis() {
		return scienceResourceMapper.researchEducationDis();
	}

	@Override
	public PageInfo<Map> projectPersonPage(ProjectPersonPageREQ projectPersonPageREQ) {
		PageHelper.startPage(projectPersonPageREQ.getPageNum(), projectPersonPageREQ.getPageSize());
		List<Map> list = scienceResourceMapper.projectPersonPage(projectPersonPageREQ);
		PageInfo<Map> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public PageInfo<Map> scienceTeamPage(ScienceTeamPageREQ scienceTeamPageREQ) {
		PageHelper.startPage(scienceTeamPageREQ.getPageNum(), scienceTeamPageREQ.getPageSize());
		List<Map> list = scienceResourceMapper.scienceTeamPage(scienceTeamPageREQ);
		PageInfo<Map> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public Map getTeamDetails(String teamNo) {
		Map map = new HashedMap();
		Map team = scienceResourceMapper.getTeamInfo(teamNo);//团队基本信息
		Map leadPerson = scienceResourceMapper.getLeadPersonInfo(teamNo);//团队带头人信息
		List<Map> corePerson = scienceResourceMapper.getCorePersonInfo(teamNo);//团队核心人员
		List<Map> platform = scienceResourceMapper.getPlatformInfo(teamNo);//团队依托载
		map.put("team",team);
		map.put("leadPerson",leadPerson);
		map.put("corePerson",corePerson);
		map.put("platform",platform);
		return map;
	}

	@Override
	public List<Map> companyPlatformAmount() {
		return scienceResourceMapper.companyPlatformAmount();
	}

	@Override
	public List<Map> subjectPlatformAmount() {
		return scienceResourceMapper.subjectPlatformAmount();
	}

	@Override
	public PageInfo<Map> sciencePlatformInfo(SciencePlatformPageREQ sciencePlatformPageREQ) {
		PageHelper.startPage(sciencePlatformPageREQ.getPageNum(), sciencePlatformPageREQ.getPageSize());
		List<Map> list = scienceResourceMapper.sciencePlatformInfo(sciencePlatformPageREQ);
		PageInfo<Map> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public PageInfo<Map> internationalCooBase(InternationalCooBasePageREQ internationalCooBasePageREQ) {
		PageHelper.startPage(internationalCooBasePageREQ.getPageNum(), internationalCooBasePageREQ.getPageSize());
		List<Map> list = scienceResourceMapper.internationalCooBase(internationalCooBasePageREQ);
		PageInfo<Map> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public List<Map> equipmentShareTime(String annual) {
		List<Map> result = scienceResourceMapper.equipmentShareTime(annual);
		result.removeAll(Collections.singleton(null));//去除聚合函数引起的null多一行数据问题
		return result;
	}

	@Override
	public List<Map> equipmentShareIncome(String annual) {
		List<Map> result = scienceResourceMapper.equipmentShareIncome(annual);
		result.removeAll(Collections.singleton(null));//去除聚合函数引起的null多一行数据问题
		return result;
	}

	@Override
	public PageInfo<Map> equipmentShareCenterPage(EquipmentShareCenterPageREQ equipmentShareCenterPageREQ) {
		if (StringUtil.isNotEmpty(equipmentShareCenterPageREQ.getSort()) && StringUtil.isNotEmpty(equipmentShareCenterPageREQ.getOrder())){
			PageHelper.orderBy(equipmentShareCenterPageREQ.getSort()+" "+equipmentShareCenterPageREQ.getOrder());
		}
		PageHelper.startPage(equipmentShareCenterPageREQ.getPageNum(), equipmentShareCenterPageREQ.getPageSize());
		List<Map> list = scienceResourceMapper.equipmentShareCenterPage(equipmentShareCenterPageREQ);
		PageInfo<Map> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
}
