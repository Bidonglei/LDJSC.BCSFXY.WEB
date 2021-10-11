package com.sunmnet.bigdata.web.service.science;

import com.github.pagehelper.PageInfo;
import com.sunmnet.bigdata.web.model.request.science.*;

import java.util.List;
import java.util.Map;

public interface ScienceResourceService {

	/**
	 *功能描述 国家级科研专家分页
	 * @author lkg
	 * @date 2019/5/9
	 */
	PageInfo<Map> researchExpertPage(ResearchExpertPageREQ researchExpertPageREQ);
	/**
	 *功能描述 科研职称分布
	 * @author lkg
	 * @date 2019/5/9
	 */
	List<Map> researchTitleDis();
	/**
	 *功能描述 科研学历分布
	 * @author lkg
	 * @date 2019/5/9
	 */
	List<Map> researchEducationDis();
	/**
	 *功能描述 科研项目人员分页
	 * @author lkg
	 * @date 2019/7/19
	 */
	PageInfo<Map> projectPersonPage(ProjectPersonPageREQ projectPersonPageREQ);
	/**
	 *功能描述 科研团队分页
	 * @author lkg
	 * @date 2019/5/10
	 */
	PageInfo<Map> scienceTeamPage(ScienceTeamPageREQ scienceTeamPageREQ);
	/**
	 *功能描述 每个团队详情
	 * @author lkg
	 * @date 2019/5/10
	 */
	Map getTeamDetails(String teamNo);
	/**
	 *功能描述 科研单位科研平台数量
	 * @author lkg
	 * @date 2019/5/13
	 */
	List<Map> companyPlatformAmount();
	/**
	 *功能描述 学科科研平台数量
	 * @author lkg
	 * @date 2019/5/13
	 */
	List<Map> subjectPlatformAmount();
	/**
	 *功能描述 各单位科研平台分页
	 * @author lkg
	 * @date 2019/5/13
	 */
	PageInfo<Map> sciencePlatformInfo(SciencePlatformPageREQ sciencePlatformPageREQ);
	/**
	 *功能描述 国际合作基地分页
	 * @author lkg
	 * @date 2019/5/13
	 */
	PageInfo<Map> internationalCooBase(InternationalCooBasePageREQ internationalCooBasePageREQ);
	/**
	 *功能描述 科研仪器设备共享机时
	 * @author lkg
	 * @date 2019/5/13
	 */
	List<Map> equipmentShareTime(String annual);
	/**
	 *功能描述 科研仪器设备共享收益
	 * @author lkg
	 * @date 2019/5/13
	 */
	List<Map> equipmentShareIncome(String annual);
	/**
	 *功能描述 科研仪器共享中心分页
	 * @author lkg
	 * @date 2019/7/19
	 */
	PageInfo<Map> equipmentShareCenterPage(EquipmentShareCenterPageREQ equipmentShareCenterPageREQ);
}
