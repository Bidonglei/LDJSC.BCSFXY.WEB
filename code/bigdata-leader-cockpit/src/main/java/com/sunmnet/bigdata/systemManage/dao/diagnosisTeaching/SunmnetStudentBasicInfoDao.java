package com.sunmnet.bigdata.systemManage.dao.diagnosisTeaching;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetStudentBasicInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRemoteStudentListRequest;

public interface SunmnetStudentBasicInfoDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(SunmnetStudentBasicInfoEntity record);

    public SunmnetStudentBasicInfoEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(SunmnetStudentBasicInfoEntity record);

    /**
     * 根据学号查询学生基本信息
     * @param studentNo
     * @author zfb
     * @create 2018-04-20
     * @return
     */
	public SunmnetStudentBasicInfoEntity getStudentBasicInfoByStudentNo(String studentNo);
//	 /**
//     * 根据学号查询除自己外本班学生基本信息
//     * @param bie
//     * @author fr
//     * @create 2018-04-21
//     * @return
//     */
//	public List<SunmnetStudentBasicInfoEntity> queryGradingByStuAndClassInfo(
//			SunmnetStudentBasicInfoEntity bie);
//
//	/**
//     * 查询学生同班级同学
//     * @param studentNo
//     * @author zfb
//     * @create 2018-04-22
//     * @return
//     */
//	public List<QueryStudentRalationNameModel> findRalationMember(
//			String studentNo);
//	/**
//     * 根据班级编号查询学生基本信息
//     * @param bie
//     * @author fr
//     * @create 2018-04-26
//     * @return
//     */
//	public List<SunmnetStudentBasicInfoEntity> queryGradingByClassInfo(
//			SunmnetStudentBasicInfoEntity bie);
//
//	/**
//     * 民族下拉框
//     * @author zfb
//     * @create 2018-04-27
//     * @return
//     */
//	public List<NationalDropdownBoxModel> queryNationalDropdown();
//
//	/**
//     * 生源地下拉框
//     * @author zfb
//     * @create 2018-04-27
//     * @return
//     */
//	public List<OriginNameDropdownBoxModel> queryOriginNameDropDown();
//	
//	/**
//	 * 查询学生所属年级
//	 *@auther tkk
//	 * 2018年4月27日
//	 */
//	public String findGrade(String studentNo);
//	/**
//	 * 根据条件查询学生列表
//	 *@auther fr
//	 * 2018年4月28日
//	 */
//	public List<SunmnetStudentBasicInfoEntity> queryStudentInfoByCon(
//			QueryStudentInfoByConRequest queryStudentInfoByConRequest);
//	
//	/**
//	 *查询所选群体的总人数
//	 *@auther tkk
//	 * 2018年4月28日
//	 */
//	public int queryChosetotalPersonCount(
//			ComprehensiveInfoRequest comprehensiveInfoRequest);
//
//	/**
//     * 政治面貌下拉框
//     * @author zfb
//     * @create 2018-04-28
//     * @return
//     */
//	public List<QueryPoliticalDropDownModel> queryPoliticalDropDown();
//
//	/**
//	 * 根据专业号 和 年级查询总人数
//	 *@auther tkk
//	 * 2018年5月1日
//	 */
//	public int getTotalCount(
//			SunmnetStudentBasicInfoEntity studentBasicInfoEntity);
//
//	/**
//     * 分页查询奖学金列表
//     * @param queryScholarshipPageRequest
//     * @author zfb
//     * @create 2018-05-19
//     * @return
//     */
//	public List<SunmnetStudentBasicInfoEntity> findScholarshipStudents(
//			QueryScholarshipPageRequest queryScholarshipPageRequest);
//	
//	/**
//	 * 根据班级编号或者指定学生姓名查询学生
//	 *@auther fr
//	 * 2018年5月19日
//	 */
//	public List<SunmnetStudentBasicInfoEntity> queryStuByClass(
//			GeneralQualityDetailListRequest generalQualityDetailListRequest);
//	/**
//	 * 根据班级查询学生信息
//	 * @auther tkk
//	 * 2018年5月20日
//	 */
//	public List<SunmnetStudentBasicInfoEntity> queryStudentByClassNo(
//			Map<String, String> mapp);
//
//	/**
//	 * 按照班级查询涉及缓补考清考的学生
//	 *@auther tkk
//	 * 2018年5月21日
//	 */
//	public List<SunmnetStudentBasicInfoEntity> queryStudentExamType(
//			QueryCourseScoreListRequest queryCourseScoreListRequest);
//	/**
//	 * 查询所传学年学校总人数
//	 *@auther fr
//	 * 2018年6月1日
//	 */
//	public Integer queryTotalStudentCount(String year);
//	/**
//	 * 查询该老师所带学生人数
//	 *@auther fr
//	 * 2018年6月4日
//	 */
//	public Integer queryTotalStudentCountByTeacher(String teacherNo);
	/**
     * 根据筛选条件查询学生信息列表
     * @param queryRemoteStudentListRequest
     * @author fr
     * @create 2018-06-23
     * @return
     */
	public List<SunmnetStudentBasicInfoEntity> queryRemoteStudentList(
			QueryRemoteStudentListRequest queryRemoteStudentListRequest);

}