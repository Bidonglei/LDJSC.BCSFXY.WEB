package com.sunmnet.bigdata.web.service.science;

import com.github.pagehelper.PageInfo;
import com.sunmnet.bigdata.web.model.request.science.ProjectDetailPageREQ;
import com.sunmnet.bigdata.web.model.request.science.ScienceProjectInfoPageREQ;
import com.sunmnet.bigdata.web.model.request.science.UniversityAmountPageREQ;
import com.sunmnet.bigdata.web.model.response.science.ProjectTypeResponse;

import java.util.List;
import java.util.Map;

public interface ScienceInfoService {
    /**
     * 科研项目分布：查询纵向科研项目分布
     * @param year
     * @return
     */
    Map listScienceProByYear(String year);


	//上面的代码是之前的代码
	/**
	 *功能描述 科研项目分布
	 * @author lkg
	 * @date 2019/4/28
	 */
	List<Map> scienceProjectDis();
	/**
	 *功能描述 科研项目分页
	 * @author lkg
	 * @date 2019/6/27
	 */
	PageInfo<Map> scienceProjectPage(ScienceProjectInfoPageREQ scienceProjectInfoPageREQ);
	/**
	 *功能描述 总经费\纵向\横向经费排行榜
	 * @author lkg
	 * @date 2019/4/28
	 */
	List<Map> companyAmountRank(String projectType,String annual);
	/**
	 *功能描述 本年新增/纵向经费排行榜
	 * @author lkg
	 * @date 2019/4/28
	 */
	List<Map> latestAmountRank(String projectType,String annual);
	/**
	 *功能描述 师均科研经费表
	 * @author lkg
	 * @date 2019/7/18
	 */
	List<Map> scientificTeacherAvg(String annual);
	/**
	 *功能描述 近三年全校科研经费
	 * @author lkg
	 * @date 2019/4/28
	 */
	List<Map> threeYearAmount();
	/**
	 *功能描述 各单位科研经费
	 * @author lkg
	 * @date 2019/4/28
	 */
	List<Map> projectTypeRank(String annual);
	/**
	 *功能描述 项目研究类别
	 * @author lkg
	 * @date 2019/4/29
	 */
	List<Map> researchCategoryDist(String annual);
	/**
	 *功能描述 各单位资金执行率滞后项目数量
	 * @author lkg
	 * @date 2019/4/29
	 */
	List<Map> projectDelayDist();
	/**
	 *功能描述 高校科研经费
	 * @author lkg
	 * @date 2019/4/29
	 */
	List<Map> universityAmount(String annual);
	/**
	 *功能描述 高校经费分页
	 * @author lkg
	 * @date 2019/7/19
	 */
	PageInfo<Map> universityAmountPage(UniversityAmountPageREQ universityAmountPageREQ);
	/**
	 *功能描述 纵向项目来源
	 * @author lkg
	 * @date 2019/5/7
	 */
	List<Map> verticalProSource(String annual,String source);
	/**
	 *功能描述 纵向项目类型排行
	 * @author lkg
	 * @date 2019/5/7
	 */
	Map<String,Object> verticalProChannel(String annual);
	/**
	 *功能描述 各单位纵向/横向项项目类别统计
	 * @author lkg
	 * @date 2019/5/8
	 */
	List<Map> secondTypeStatistics(String projectType,String annual);
	/**
	 *功能描述 项目详情分页
	 * @author lkg
	 * @date 2019/5/8
	 */
	PageInfo<Map> projectDetailPage(ProjectDetailPageREQ projectDetailPageREQ);

	/**
	 *功能描述 千万级项目查询
	 * @author lkg
	 * @date 2019/5/10
	 */
	List<Map> bigProjectDis(String projectType,String amount,String status);

}
