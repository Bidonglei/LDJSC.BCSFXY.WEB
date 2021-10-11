/**
* SStudentInfoMapper.java
* 三盟科技
* @date 2018-08-27
*/
package com.sunmnet.bigdata.web.mapper.student;

import com.sunmnet.bigdata.web.model.request.student.GradationREQ;

import java.util.List;
import java.util.Map;

public interface StudentGraduationMapper {

	/**
	 * @Description 学院就业分析
	 * @author linjl
	 * @date 2019/3/1
	 */
	List<Map<String, String>> listAcademyGraduation(GradationREQ req);
	/**
	 * @Description 毕业生去向
	 * @author linjl
	 * @date 2019/3/1
	 */
	List<Map<String, String>> listStudentGraduateTo(GradationREQ req);
	/**
	 * @Description 就业行业分布情况
	 * @author linjl
	 * @date 2019/3/1
	 */
	List<Map<String, String>> listStudentCompanyType(GradationREQ req);
	/**
	 * @Description 签约单位地域分布
	 * @author linjl
	 * @date 2019/3/1
	 */
	List<Map<String, String>> listStudentWorkingArea(GradationREQ req);
	/**
	 * @Description 近五年毕业生就业趋势
	 * @author linjl
	 * @date 2019/5/8
	 */
	List<Map<String, String>> listGraduateToFiveYear();
}