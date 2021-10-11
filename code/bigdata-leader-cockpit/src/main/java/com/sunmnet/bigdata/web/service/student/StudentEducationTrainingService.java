package com.sunmnet.bigdata.web.service.student;

import com.github.pagehelper.PageInfo;
import com.sunmnet.bigdata.common.request.BasePageRequest;
import com.sunmnet.bigdata.web.model.entity.student.InternationExchangeRequest;

import java.util.List;
import java.util.Map;

/**
 *功能描述 教育培养
 * @author lkg
 * @date 2019/4/17
 */
public interface StudentEducationTrainingService {

	/**
	 *功能描述 国际交流
	 * @author lkg
	 * @date 2019/4/17
	 */
	Map<String,Object> internationalExchange(InternationExchangeRequest internationExchangeRequest);
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
	List<Map<String, String>> academyScholarship(String annual);
	/**
	 *功能描述 奖助学金培养层次详情
	 * @author lkg
	 * @date 2019/4/18
	 */
	List<Map<String, String>> scholarshipDetail(String annual);
	/**
	 *功能描述 奖助学金受助学生去向类型
	 * @author lkg
	 * @date 2019/4/18
	 */
	List<Map<String, String>> whereaboutsType(String annual);
	/**
	 *功能描述 奖助学金受助学生去向详细类型
	 * @author lkg
	 * @date 2019/4/18
	 */
	List<Map<String, String>> whereaboutsDetailType(String annual);
	/**
	 *功能描述 奖学金受益学生类别
	 * @author lkg
	 * @date 2019/6/19
	 */
	Map<String, Object> scholarship(String annual);
	/**
	 *功能描述 助学贷款受益学生类别
	 * @author lkg
	 * @date 2019/6/19
	 */
	Map<String, Object> studentLoans(String annual);
	/**
	 *功能描述 减免学费受益学生类别
	 * @author lkg
	 * @date 2019/6/19
	 */
	Map<String, Object> tuitionReduction(String annual);
	/**
	 *功能描述 党员获得奖助学金情况
	 * @author lkg
	 * @date 2019/6/19
	 */
	List<Map<String, String>> aidFinanciallyParty(String annual);
	/**
	 *功能描述 学生获奖详情分页
	 * @author lkg
	 * @date 2019/6/19
	 */
	PageInfo<Map> awardDetailPage(BasePageRequest basePageRequest);
	/**
	 *功能描述 本科/研究生获奖
	 * @author lkg
	 * @date 2019/4/19
	 */
	Map<String,Object> studentAward(String achieveType);
	/**
	 *功能描述 本科/研究生学院获奖总数
	 * @author lkg
	 * @date 2019/4/19
	 */
	Map<String,Object> academyAward(String achieveType);
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
