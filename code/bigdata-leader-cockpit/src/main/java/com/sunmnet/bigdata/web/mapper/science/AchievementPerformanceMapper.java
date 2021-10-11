/**
 * ScienceProjectMapper.java
 * 三盟科技
 * @date 2018-08-27
*/
package com.sunmnet.bigdata.web.mapper.science;

import com.sunmnet.bigdata.web.model.request.science.MonographInfoPageREQ;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AchievementPerformanceMapper {

	/**
	 *功能描述 近五年ESI综合排名及ESI论文数变化趋势
	 * @author lkg
	 * @date 2019/5/16
	 */
	List<Map> esiRankingPapers();
	/**
	 *功能描述 近五年ESI高被引论文/热点论文变化趋势
	 * @author lkg
	 * @date 2019/5/16
	 */
	List<Map> esiCitedHotspot();
	/**
	 *功能描述 ESI学科各高校排名对比
	 * @author lkg
	 * @date 2019/5/16
	 */
	List<Map> esiRankContrast();
	/**
	 *功能描述 我校进入ESI的学科及排名
	 * @author lkg
	 * @date 2019/5/16
	 */
	List<Map> esiSubjectRank();
	/**
	 *功能描述 我校各学科ESI差距分析
	 * @author lkg
	 * @date 2019/5/16
	 */
	List<Map> esiPotentialSubject();
	/**
	 *功能描述 科研机构专利数量
	 * @author lkg
	 * @date 2019/5/16
	 */
	List<Map> patentNum();
	/**
	 *功能描述 专利申请数TOP5
	 * @author lkg
	 * @date 2019/5/16
	 */
	List<Map> applyNum();
	/**
	 *功能描述 专利授权数TOP5
	 * @author lkg
	 * @date 2019/5/16
	 */
	List<Map> grantNum();
	/**
	 *功能描述 专利转化件数TOP5
	 * @author lkg
	 * @date 2019/5/16
	 */
	List<Map> inventNum();
	/**
	 *功能描述 科研机构专利转让信息
	 * @author lkg
	 * @date 2019/5/16
	 */
	List<Map> patentTransferAmount();
	/**
	 *功能描述 出售总金额TOP5
	 * @author lkg
	 * @date 2019/5/16
	 */
	List<Map> sellAmount();
	/**
	 *功能描述 实际收入金额TOP5
	 * @author lkg
	 * @date 2019/5/16
	 */
	List<Map> realAmount();
	/**
	 *功能描述 专利转让合同数TOP5
	 * @author lkg
	 * @date 2019/5/16
	 */
	List<Map> contractNum();
	/**
	 *功能描述 发表论文数量
	 * @author lkg
	 * @date 2019/5/17
	 */
	List<Map> publishThesis(@Param(value = "type")String type);
	/**
	 *功能描述 thesisSCI
	 * @author lkg
	 * @date 2019/5/17
	 */
	List<Map> thesisSCI();
	/**
	 *功能描述 近五年SSCI论文发表
	 * @author lkg
	 * @date 2019/5/17
	 */
	List<Map> thesisSSCI();
	/**
	 *功能描述 专著分布
	 * @author lkg
	 * @date 2019/5/17
	 */
	List<Map> monographDepNum();
	/**
	 *功能描述 专著数量TOP5科研机构
	 * @author lkg
	 * @date 2019/5/17
	 */
	List<Map> monographDepTopFive();
	/**
	 *功能描述 专著详情
	 * @author lkg
	 * @date 2019/5/17
	 */
	List<Map> monographInfo(MonographInfoPageREQ monographInfoPageREQ);
}