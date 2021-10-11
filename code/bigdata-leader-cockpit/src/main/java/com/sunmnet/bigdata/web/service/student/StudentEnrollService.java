package com.sunmnet.bigdata.web.service.student;

import java.util.List;
import java.util.Map;

/**
 *功能描述 招生分析
 * @author lkg
 * @date 2019/4/11
 */
public interface StudentEnrollService {

	/**
	 *功能描述 本科生各专业招生
	 * @author lkg
	 * @date 2019/4/11
	 */
	List<Map<String, String>> undergraduateEnrollMajor(String year);
	/**
	 *功能描述 本科生各学院招生
	 * @author lkg
	 * @date 2019/4/11
	 */
	List<Map<String, String>> undergraduateEnrollAcademy(String year);
	/**
	 *功能描述 近五年本科生招生
	 * @author lkg
	 * @date 2019/4/11
	 */
	List<Map<String, String>> undergraduateFiveEnroll();
	/**
	 *功能描述 本科生招生生源（生源地分布）
	 * @author lkg
	 * @date 2019/4/11
	 */
	List<Map<String, String>> undergraduateOriginEnroll(String year);
	/**
	 *功能描述 生源类别分布
	 * @author lkg
	 * @date 2019/5/28
	 */
	Map sourceTypeDis(String year);
	/**
	 *功能描述 生源中学分布
	 * @author lkg
	 * @date 2019/5/28
	 */
	Map MiddleSchoolDis(String year);
	/**
	 *功能描述 硕士/博士生招生结构
	 * @author lkg
	 * @date 2019/4/12
	 */
	Map<String,Object> masterStructure(String educateGradation,String year);
	/**
	 *功能描述 研究生近五年招生趋势
	 * @author lkg
	 * @date 2019/4/12
	 */
	List<Map<String, String>> masterFiveEnroll();
	/**
	 *功能描述 各学科招生情况
	 * @author lkg
	 * @date 2019/4/12
	 */
	List<Map<String, String>> masterEnrollMajor(String type,String year);
	/**
	 *功能描述 硕士学源分析(学院)
	 * @author lkg
	 * @date 2019/4/15
	 */
	List<Map<String, String>> masterSourceAcademy(String educateGradation,String year);
	/**
	 *功能描述 硕士学源分析(学科)
	 * @author lkg
	 * @date 2019/4/15
	 */
	List<Map<String, String>> masterSourceMajor(String educateGradation,String year);
	/**
	 *功能描述 留学生招生分布
	 * @author lkg
	 * @date 2019/4/15
	 */
	List<Map<String, String>> foreignEnrollDistribute(String year);
	/**
	 *功能描述 本科生招生质量
	 * @author lkg
	 * @date 2019/4/16
	 */
	List<Map<String, String>> undergraduateEnrollQuality(String enrollSubjectType,String year);
	/**
	 *功能描述 本科生招生趋势
	 * @author lkg
	 * @date 2019/4/26
	 */
	List<Map<String, String>> undergraduateEnrollTrend(String province,String enrollSubjectType);
	/**
	 *功能描述 硕士生招生质量
	 * @author lkg
	 * @date 2019/4/16
	 */
	List<Map<String, String>> masterEnrollQuality(String year);
}
