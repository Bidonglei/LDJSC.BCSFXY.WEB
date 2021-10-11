package com.sunmnet.bigdata.systemManage.service;

import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryClassByMajorNoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryDictDropDownRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryMajorByDepartmentNoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRemoteStudentListRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRemoteTeacherListRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QuerySecondDeptByFirstDeptNoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryClassByMajorNoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryDeptResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryDictDropDownResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryMajorByDepartmentNoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryProfessionalTitleResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryStudentDepartmentResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryTeacherDegreeResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;


/**
 * 系统公共接口
 * @author wm
 * @create 2018-06-26
 */
public interface PublicService {
	
	/**
	 * 查询教师职称下拉框
	 * @auther tkk
	 * 2018年6月22日
	 */
	SystemManageResponseInfo<QueryProfessionalTitleResponse> queryProfessionalTitle();
	/**
     * 查询教师学历下拉框
     * @author tkk
     * @create 2018-06-22
     */
	SystemManageResponseInfo<QueryTeacherDegreeResponse> queryTeacherDegree();
	
	/**
     * 指标管理：查询学生八个系的下拉框
     * @author tkk
     * @create 2018-06-22
     * @return
     */
	SystemManageResponseInfo<QueryStudentDepartmentResponse> queryStudentDepartment();
	/**
     * 根据学生八个系的系编号查询对应的专业下拉框
     * @author tkk
     * @create 2018-06-22
     */
	SystemManageResponseInfo<QueryMajorByDepartmentNoResponse> queryMajorByDepartmentNo(
			QueryMajorByDepartmentNoRequest queryMajorByDepartmentNoRequest);
	/**
     * 服务间调用：根据学生专业编号查询对应的班级下拉框
     * @author tkk
     * @create 2018-06-22
     */
	SystemManageResponseInfo<QueryClassByMajorNoResponse> queryClassByMajorNo(
			QueryClassByMajorNoRequest queryClassByMajorNoRequest);
	/**
	 *@auther tkk
	 * 2018年6月23日
	 */
	SystemManageResponseInfo<QueryDeptResponse> queryFirstDept();
	/**
     * 服务间调用 指标管理：根据一级部门编号查询二级部门信息下拉框
     * @author tkk
     * @create 2018-06-22
     */
	SystemManageResponseInfo<QueryDeptResponse> querySecondDeptByFirstDeptNo(
			QuerySecondDeptByFirstDeptNoRequest querySecondDeptByFirstDeptNoRequest);
	/**
     * 根据筛选条件查询教职工信息
     * @author fr
     * @create 2018-06-23
     * @return
     */
	SystemManageResponseInfo<PageResult> queryRemoteTeacherList(
			QueryRemoteTeacherListRequest queryRemoteTeacherListRequest);
	
	/**
     * 根据筛选条件查询学生信息列表
     * @param queryStudentBasicInfoRequest
     * @author fr
     * @create 2018-06-23
     * @return
     */
	SystemManageResponseInfo<PageResult> queryRemoteStudentList(
			QueryRemoteStudentListRequest queryRemoteStudentListRequest);
	
	/**
     * 查询数据字典下拉框
     * @author zfb
     * @create 2018-09-17
     */
	SystemManageResponseInfo<QueryDictDropDownResponse> queryDictDrpDown(QueryDictDropDownRequest queryDictDropDownRequest);

	
	
}
