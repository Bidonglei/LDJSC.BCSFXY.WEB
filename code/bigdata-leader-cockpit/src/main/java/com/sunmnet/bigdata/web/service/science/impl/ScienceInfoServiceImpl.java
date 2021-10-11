package com.sunmnet.bigdata.web.service.science.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.sunmnet.bigdata.common.exception.BusinessException;
import com.sunmnet.bigdata.web.mapper.science.ScienceProjectMapper;
import com.sunmnet.bigdata.web.model.request.science.ProjectDetailPageREQ;
import com.sunmnet.bigdata.web.model.request.science.ScienceProjectInfoPageREQ;
import com.sunmnet.bigdata.web.model.request.science.UniversityAmountPageREQ;
import com.sunmnet.bigdata.web.service.science.ScienceInfoService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScienceInfoServiceImpl implements ScienceInfoService {

    @Autowired
    private ScienceProjectMapper scienceProjectMapper;

    @Override
    public Map listScienceProByYear(String year) {
        if (StringUtil.isEmpty(year)) {
            throw new BusinessException("年份不能为空");
        }
        Map<String, List<Map>> scienceMap = new HashedMap();
        //查询一级-项目分类
        List<Map> oneMap = scienceProjectMapper.listOneType(year);
        //查询二级-承担项目学院
        for (Map oneObj : oneMap) {
            String proType = oneObj.get("name").toString();
            List<Map> twoList = scienceProjectMapper.listTwoName(year, proType);
            oneObj.put("children", twoList);
            for (Map twoObj : twoList) {
                String proAcademy = twoObj.get("name").toString();
                List<Map> teamList = scienceProjectMapper.listThreeTeam(year, proType, proAcademy);
                twoObj.put("children", teamList);
            }
        }
        //查询三级-承担项目团队(系)
        scienceMap.put("data", oneMap);
        return scienceMap;
    }

	@Override
	public List<Map> scienceProjectDis() {
		return scienceProjectMapper.scienceProjectDis();
	}

	@Override
	public PageInfo<Map> scienceProjectPage(ScienceProjectInfoPageREQ scienceProjectInfoPageREQ) {
		if (StringUtil.isNotEmpty(scienceProjectInfoPageREQ.getSort()) && StringUtil.isNotEmpty(scienceProjectInfoPageREQ.getOrder())){
			PageHelper.orderBy(scienceProjectInfoPageREQ.getSort()+" "+scienceProjectInfoPageREQ.getOrder());
		}
		PageHelper.startPage(scienceProjectInfoPageREQ.getPageNum(), scienceProjectInfoPageREQ.getPageSize());
		List<Map> list = scienceProjectMapper.scienceProjectInfo(scienceProjectInfoPageREQ);
		PageInfo<Map> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public List<Map> companyAmountRank(String projectType,String annual) {
		return scienceProjectMapper.companyAmountRank(projectType,annual);
	}

	@Override
	public List<Map> latestAmountRank(String projectType,String annual) {
		return scienceProjectMapper.latestAmountRank(projectType,annual);
	}

	@Override
	public List<Map> scientificTeacherAvg(String annual) {
		return scienceProjectMapper.scientificTeacherAvg(annual);
	}

	@Override
	public List<Map> threeYearAmount() {
		return scienceProjectMapper.threeYearAmount();
	}

	@Override
	public List<Map> projectTypeRank(String annual) {
		return scienceProjectMapper.projectTypeRank(annual);
	}

	@Override
	public List<Map> researchCategoryDist(String annual) {
		return scienceProjectMapper.researchCategoryDist(annual);
	}

	@Override
	public List<Map> projectDelayDist() {
		return scienceProjectMapper.projectDelayDist();
	}

	@Override
	public List<Map> universityAmount(String annual) {
		return scienceProjectMapper.universityAmount(annual);
	}

	@Override
	public PageInfo<Map> universityAmountPage(UniversityAmountPageREQ universityAmountPageREQ) {
		if (StringUtil.isNotEmpty(universityAmountPageREQ.getSort()) && StringUtil.isNotEmpty(universityAmountPageREQ.getOrder())){
			PageHelper.orderBy(universityAmountPageREQ.getSort()+" "+universityAmountPageREQ.getOrder());
		}
		PageHelper.startPage(universityAmountPageREQ.getPageNum(), universityAmountPageREQ.getPageSize());
		List<Map> list = scienceProjectMapper.universityAmountPage(universityAmountPageREQ);
		PageInfo<Map> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public List<Map> verticalProSource(String annual, String source) {
		List<Map> maps=null;
		//QD查询渠道，BM查询部门
    	if ("QD".equals(source)){
			maps = scienceProjectMapper.channelTypeAmount(annual);
		}else if ("BM".equals(source)){
			maps = scienceProjectMapper.departmentAmount(annual);
		}
		return maps;
	}

	@Override
	public Map<String,Object> verticalProChannel(String annual) {
		Map<String,Object> result = new HashMap<>();
		result.put("verticalProChannel",scienceProjectMapper.verticalProChannel(annual));
		result.put("legend",scienceProjectMapper.getChannelTypeLegend(annual));
		return result;
	}

	@Override
	public List<Map> secondTypeStatistics(String projectType, String annual) {
		return scienceProjectMapper.secondTypeStatistics(projectType,annual);
	}

	@Override
	public PageInfo<Map> projectDetailPage(ProjectDetailPageREQ projectDetailPageREQ) {
		if (StringUtil.isNotEmpty(projectDetailPageREQ.getSort()) && StringUtil.isNotEmpty(projectDetailPageREQ.getOrder())){
			PageHelper.orderBy(projectDetailPageREQ.getSort()+" "+projectDetailPageREQ.getOrder());
		}
    	PageHelper.startPage(projectDetailPageREQ.getPageNum(), projectDetailPageREQ.getPageSize());
		List<Map> list = scienceProjectMapper.projectDetailPage(projectDetailPageREQ);
		PageInfo<Map> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public List<Map> bigProjectDis(String projectType, String amount, String status) {
		return scienceProjectMapper.bigProjectDis(projectType,amount,status);
	}


}
