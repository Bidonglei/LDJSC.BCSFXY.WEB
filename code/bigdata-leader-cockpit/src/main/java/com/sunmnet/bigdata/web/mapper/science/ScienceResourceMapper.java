/**
 * ScienceProjectMapper.java
 * 三盟科技
 * @date 2018-08-27
*/
package com.sunmnet.bigdata.web.mapper.science;

import com.sunmnet.bigdata.web.model.request.science.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ScienceResourceMapper {

	/**
	 *功能描述 国家级科研专家分页
	 * @author lkg
	 * @date 2019/5/9
	 */
	List<Map> researchExpertPage(ResearchExpertPageREQ researchExpertPageREQ);
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
	List<Map> projectPersonPage(ProjectPersonPageREQ projectPersonPageREQ);
	/**
	 *功能描述 科研团队分页
	 * @author lkg
	 * @date 2019/5/10
	 */
	List<Map> scienceTeamPage(ScienceTeamPageREQ scienceTeamPageREQ);
	/**
	 *功能描述 团队基本信息
	 * @author lkg
	 * @date 2019/5/15
	 */
	Map getTeamInfo(@Param(value = "teamNo")String teamNo);
	/**
	 *功能描述 团队带头人信息
	 * @author lkg
	 * @date 2019/5/15
	 */
	Map getLeadPersonInfo(@Param(value = "teamNo")String teamNo);
	/**
	 *功能描述 团队核心人员
	 * @author lkg
	 * @date 2019/5/10
	 */
	List<Map> getCorePersonInfo(@Param(value = "teamNo")String teamNo);
	/**
	 *功能描述 团队依托平台
	 * @author lkg
	 * @date 2019/5/10
	 */
	List<Map> getPlatformInfo(@Param(value = "teamNo")String teamNo);
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
	List<Map> sciencePlatformInfo(SciencePlatformPageREQ sciencePlatformPageREQ);
	/**
	 *功能描述 国际合作基地分页
	 * @author lkg
	 * @date 2019/5/13
	 */
	List<Map> internationalCooBase(InternationalCooBasePageREQ internationalCooBasePageREQ);
	/**
	 *功能描述 科研仪器设备共享机时
	 * @author lkg
	 * @date 2019/5/13
	 */
	List<Map> equipmentShareTime(@Param("annual") String annual);
	/**
	 *功能描述 科研仪器设备共享收益
	 * @author lkg
	 * @date 2019/5/13
	 */
	List<Map> equipmentShareIncome(@Param("annual") String annual);
	/**
	 *功能描述 科研仪器共享中心分页
	 * @author lkg
	 * @date 2019/7/19
	 */
	List<Map> equipmentShareCenterPage(EquipmentShareCenterPageREQ equipmentShareCenterPageREQ);
}