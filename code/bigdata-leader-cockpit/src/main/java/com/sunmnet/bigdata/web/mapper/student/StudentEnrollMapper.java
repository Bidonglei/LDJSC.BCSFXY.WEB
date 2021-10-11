package com.sunmnet.bigdata.web.mapper.student;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentEnrollMapper {

	/**
	 *功能描述 获取最近的录取年份
	 * @author lkg
	 * @date 2019/4/11
	 */
	int maxAnnual();
	/**
	 *功能描述 本科生各专业招生
	 * @author lkg
	 * @date 2019/4/11
	 */
	List<Map<String, String>> undergraduateEnrollMajor(Map map);
	/**
	 *功能描述 本科生各学院招生
	 * @author lkg
	 * @date 2019/4/11
	 */
	List<Map<String, String>> undergraduateEnrollAcademy(Map map);
	/**
	 *功能描述 近五年本科生招生
	 * @author lkg
	 * @date 2019/4/11
	 */
	List<Map<String, String>> undergraduateFiveEnroll(Map map);
	/**
	 *功能描述 本科生招生生源
	 * @author lkg
	 * @date 2019/4/11
	 */
	List<Map<String, String>> undergraduateOriginEnroll(Map map);
	/**
	 *功能描述 全国各省份生源类别
	 * @author lkg
	 * @date 2019/5/28
	 */
	List<Map<String, String>> provinceSourceType(Map map);
	/**
	 *功能描述 全国生源类别
	 * @author lkg
	 * @date 2019/5/28
	 */
	List<Map<String, String>> sourceType(Map map);
	/**
	 *功能描述 全国各省份中学
	 * @author lkg
	 * @date 2019/5/28
	 */
	List<Map<String, String>> provinceMiddleSchool(Map map);
	/**
	 *功能描述 全国中学TOP10
	 * @author lkg
	 * @date 2019/5/28
	 */
	List<Map<String, String>> middleSchoolTopTen(Map map);
	/**
	 *功能描述 硕士/博士生招生人数
	 * @author lkg
	 * @date 2019/4/18
	 */
	int masterStructureTotal(Map map);
	/**
	 *功能描述 硕士/博士生招生结构
	 * @author lkg
	 * @date 2019/4/12
	 */
	List<Map<String, String>> masterStructure(Map map);
	/**
	 *功能描述 研究生近五年招生趋势
	 * @author lkg
	 * @date 2019/4/12
	 */
	List<Map<String, String>> masterFiveEnroll(Map map);
	/**
	 *功能描述 各学科招生情况
	 * @author lkg
	 * @date 2019/4/12
	 */
	List<Map<String, String>> masterEnrollMajor(Map map);
	/**
	 *功能描述 硕士学源分析(学院)
	 * @author lkg
	 * @date 2019/4/15
	 */
	List<Map<String, String>> masterSourceAcademy(Map map);
	/**
	 *功能描述 硕士学源分析(学科)
	 * @author lkg
	 * @date 2019/4/15
	 */
	List<Map<String, String>> masterSourceMajor(Map map);
	/**
	 *功能描述 留学生招生分布
	 * @author lkg
	 * @date 2019/4/15
	 */
	List<Map<String, String>> foreignEnrollDistribute(Map map);
	/**
	 *功能描述 本科生招生质量
	 * @author lkg
	 * @date 2019/4/16
	 */
	List<Map<String, String>> undergraduateEnrollQuality(Map map);
	/**
	 *功能描述 招生趋势
	 * @author lkg
	 * @date 2019/4/26
	 */
	List<Map<String, String>> undergraduateEnrollTrend(@Param(value = "province") String province,@Param(value = "enrollSubjectType") String enrollSubjectType);
	/**
	 *功能描述 硕士生招生质量
	 * @author lkg
	 * @date 2019/4/16
	 */
	List<Map<String, String>> masterEnrollQuality(Map map);
}