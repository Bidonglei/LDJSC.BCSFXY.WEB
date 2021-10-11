package com.sunmnet.bigdata.web.mapper.student;

import com.sunmnet.bigdata.common.request.BasePageRequest;
import com.sunmnet.bigdata.web.model.entity.student.InternationExchangeRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentEducationTrainingMapper {

	/**
	 *功能描述 国际交流国家数目
	 * @author lkg
	 * @date 2019/4/17
	 */
	int interExchangeCountryTotal(InternationExchangeRequest internationExchangeRequest);
	/**
	 *功能描述 国际交流人次
	 * @author lkg
	 * @date 2019/4/17
	 */
	int interExchangeTime(InternationExchangeRequest internationExchangeRequest);
	/**
	 *功能描述 国际交流具体国家
	 * @author lkg
	 * @date 2019/4/17
	 */
	List<Map<String, String>> interExchangeCountry(InternationExchangeRequest internationExchangeRequest);
	/**
	 *功能描述 奖助学资金分布
	 * @author lkg
	 * @date 2019/4/18
	 */
	List<Map<String, String>> annualScholarship();
	/**
	 *功能描述 奖学金学院分布
	 * @author lkg
	 * @date 2019/4/18
	 */
	List<Map<String, String>> academyScholarship(@Param(value = "annual") String annual);
	/**
	 *功能描述 奖助学金培养层次详情
	 * @author lkg
	 * @date 2019/4/18
	 */
	List<Map<String, String>> scholarshipDetail(@Param(value = "annual") String annual);
	/**
	 *功能描述 奖助学金受助学生去向类型
	 * @author lkg
	 * @date 2019/4/18
	 */
	List<Map<String, String>> whereaboutsType(@Param(value = "annual") String annual);
	/**
	 *功能描述 奖助学金受助学生去向详细类型
	 * @author lkg
	 * @date 2019/4/18
	 */
	List<Map<String, String>> whereaboutsDetailType(@Param(value = "annual") String annual);
	/**
	 *功能描述 奖学金，助学贷款，减免学费受益学生类别
	 * @author lkg
	 * @date 2019/6/19
	 */
	List<Map<String, String>> profitStudent(@Param(value = "type") String type,@Param(value = "annual") String annual);
	/**
	 *功能描述 奖学金，助学贷款，减免学费受益学生总数
	 * @author lkg
	 * @date 2019/6/20
	 */
	int profitStudentTotal(@Param(value = "type") String type,@Param(value = "annual") String annual);
	/**
	 *功能描述 党员获得奖助学金情况
	 * @author lkg
	 * @date 2019/6/19
	 */
	List<Map<String, String>> aidFinanciallyParty(@Param(value = "annual") String annual);
	/**
	 *功能描述 学生获奖详情分页
	 * @author lkg
	 * @date 2019/6/19
	 */
	List<Map> awardDetailPage(BasePageRequest basePageRequest);
	/**
	 *功能描述 本科/研究生获奖
	 * @author lkg
	 * @date 2019/4/19
	 */
	List<Map<String, String>> studentAward(@Param(value = "achieveType") String achieveType);
	/**
	 * @Description 本科/研究生获奖-图例
	 * @author linjl
	 * @date 2019/9/16
	 */
	List<String> getStudentAwardLegend(@Param(value = "achieveType") String achieveType);
	/**
	 *功能描述 本科/研究生学院获奖总数
	 * @author lkg
	 * @date 2019/4/19
	 */
	List<Map<String, String>> academyAward(@Param(value = "achieveType") String achieveType);
	/**
	 * @Description 本科/研究生学院获奖总数-图例
	 * @author linjl
	 * @date 2019/9/16
	 */
	List<String> getAcademyAwardLegend(@Param(value = "achieveType") String achieveType);
	/**
	 *功能描述 人才培养
	 * @author lkg
	 * @date 2019/4/23
	 */
	List<Map<String, String>> personnelTraining();
	/**
	 *功能描述 学生论文发表情况
	 * @author lkg
	 * @date 2019/4/23
	 */
	List<Map<String, String>> publishPaper();
	/**
	 *功能描述 学生申请专利情况
	 * @author lkg
	 * @date 2019/4/23
	 */
	List<Map<String, String>> applicationPatent();
	/**
	 *功能描述 学生发表作品数
	 * @author lkg
	 * @date 2019/4/23
	 */
	List<Map<String, String>> applicationWriting();
	/**
	 *功能描述 学生社团情况
	 * @author lkg
	 * @date 2019/4/23
	 */
	List<Map<String, String>> association();
	/**
	 *功能描述 各学院学生出国情况
	 * @author lkg
	 * @date 2019/6/19
	 */
	List<Map<String, String>> abroadInfo();
}