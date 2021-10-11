package com.sunmnet.bigdata.web.service.personnel;

import java.util.List;
import java.util.Map;

/**
 *功能描述
 * @author lkg
 * @date 2019/2/19
 */
public interface HighLevelTalentService {

	/**
	 *功能描述 高层次人才单位分布
	 * @author lkg
	 * @date 2019/2/19
	 */
	List<Map> talentCollegeDistribute();
	/**
	 *功能描述 高层次人才学科分布
	 * @author lkg
	 * @date 2019/2/19
	 */
	List<Map> talentSubjectDistribute();
	/**
	 *功能描述 引进分析：人才引进源（学院）
	 * @author lkg
	 * @date 2019/7/9
	 */
	List<Map> introduceAcademicStr();
	/**
	 *功能描述 引进分析：人才引进源（学科）
	 * @author lkg
	 * @date 2019/7/9
	 */
	List<Map> introduceSubjectStr();
	/**
	 * @Description 引进分析：学院历年引进人才分析
	 * @author linjl
	 * @date 2019/8/8
	 */
	Map<String,Object> listIntroduceTalent();
}
