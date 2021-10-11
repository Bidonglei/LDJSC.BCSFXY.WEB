/**
 * ScienceProjectMapper.java
 * 三盟科技
 * @date 2018-08-27
*/
package com.sunmnet.bigdata.web.mapper.science;

import com.sunmnet.bigdata.web.model.entity.science.ScienceProject;
import com.sunmnet.bigdata.web.model.request.science.ProjectDetailPageREQ;
import com.sunmnet.bigdata.web.model.request.science.ScienceProjectInfoPageREQ;
import com.sunmnet.bigdata.web.model.request.science.UniversityAmountPageREQ;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ScienceProjectMapper {
    /**
     * 
     * @mbg.generated 2018-08-27
     */
    List<ScienceProject> listAll();

    /**
     * 一级类型
     * @param year
     * @return
     */
    List<Map> listOneType(@Param("year") String year);

    /**
     * 二级类型
     * @param year
     * @param proType
     * @return
     */
    List<Map> listTwoName(@Param("year") String year, @Param("proType") String proType);

    /**
     * 三级类型
     * @param year
     * @param proType
     * @param proAcademy
     * @return
     */
    List<Map> listThreeTeam(@Param("year") String year, @Param("proType") String proType, @Param("proAcademy") String proAcademy);

    /**
     * 科研项目分布：查询项目数量经费
     * @param year
     * @return
     */
    Map listProMoney(@Param("year") String year);

    /**
     * 科研项目分布：查询项目排行
     * @param year
     * @return
     */
    List<Map> listTop(@Param("year") String year);

    /**
     * 科研项目分布：查询横向科研项目分布
     * @param year
     * @return
     */
    List<Map> listPieScienceProByYear(@Param("year") String year);


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
	List<Map> scienceProjectInfo(ScienceProjectInfoPageREQ scienceProjectInfoPageREQ);
	/**
	 *功能描述 总经费\纵向\横向经费排行榜
	 * @author lkg
	 * @date 2019/4/28
	 */
	List<Map> companyAmountRank(@Param("projectType") String projectType,@Param("annual") String annual);
	/**
	 *功能描述 本年新增经费排行榜
	 * @author lkg
	 * @date 2019/4/28
	 */
	List<Map> latestAmountRank(@Param("projectType") String projectType,@Param("annual") String annual);
	/**
	 *功能描述 师均科研经费表
	 * @author lkg
	 * @date 2019/7/18
	 */
	List<Map> scientificTeacherAvg(@Param("annual") String annual);
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
	List<Map> projectTypeRank(@Param("annual") String annual);
	/**
	 *功能描述 项目研究类别
	 * @author lkg
	 * @date 2019/4/29
	 */
	List<Map> researchCategoryDist(@Param("annual") String annual);
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
	List<Map> universityAmount(@Param("annual") String annual);
	/**
	 *功能描述 高校经费分页
	 * @author lkg
	 * @date 2019/7/19
	 */
	List<Map> universityAmountPage(UniversityAmountPageREQ universityAmountPageREQ);
	/**
	 *功能描述 纵向渠道类型金额
	 * @author lkg
	 * @date 2019/5/7
	 */
	List<Map> channelTypeAmount(@Param("annual") String annual);
	/**
	 *功能描述 纵向部门金额
	 * @author lkg
	 * @date 2019/5/7
	 */
	List<Map> departmentAmount(@Param("annual") String annual);
	/**
	 *功能描述 纵向项目类型排行
	 * @author lkg
	 * @date 2019/5/7
	 */
	List<Map> verticalProChannel(@Param("annual") String annual);
	/**
	 * @Description 纵向项目类型排名-图例
	 * @author linjl
	 * @date 2019/8/15
	 */
	List<String> getChannelTypeLegend(@Param("annual") String annual);
	/**
	 *功能描述 各单位纵向/横向项项目类别统计
	 * @author lkg
	 * @date 2019/5/8
	 */
	List<Map> secondTypeStatistics(@Param("projectType") String projectType,@Param("annual") String annual);
	/**
	 *功能描述 项目详情分页
	 * @author lkg
	 * @date 2019/5/8
	 */
	List<Map> projectDetailPage(ProjectDetailPageREQ projectDetailPageREQ);
	/**
	 *功能描述 千万级项目查询
	 * @author lkg
	 * @date 2019/5/10
	 */
	List<Map> bigProjectDis(@Param("projectType") String projectType,@Param("amount") String amount,@Param("status") String status);
}