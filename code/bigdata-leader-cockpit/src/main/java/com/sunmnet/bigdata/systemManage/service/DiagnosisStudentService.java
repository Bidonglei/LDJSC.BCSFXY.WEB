package com.sunmnet.bigdata.systemManage.service;


import org.springframework.web.bind.annotation.RequestBody;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryClassByMajorNoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryMajorByDepartmentNoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRemoteStudentListGroupRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRemoteStudentListRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QuerySecondDeptByFirstDeptNoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryClassByMajorNoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryDeptResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryMajorByDepartmentNoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryRemoteStudentListGroupResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryStudentDepartmentResponse;




public interface DiagnosisStudentService{

	
    /**
     * 服务间调用：查询学生八个系的下拉框
     * @author tkk
     * @create 2018-06-22
     */	 
	 public BaseResponseInfo<QueryStudentDepartmentResponse> queryStudentDepartment();	
	 /**
     * 服务间调用：根据学生八个系的系编号查询对应的专业下拉框
     * @author tkk
     * @create 2018-06-22
     */	
	 public BaseResponseInfo<QueryMajorByDepartmentNoResponse> queryMajorByDepartmentNo(@RequestBody QueryMajorByDepartmentNoRequest queryMajorByDepartmentNoRequest);
    /**
     * 服务间调用：根据学生专业编号查询对应的班级下拉框
     * @author tkk
     * @create 2018-06-22
     */	
	 public BaseResponseInfo<QueryClassByMajorNoResponse> queryClassByMajorNo(@RequestBody QueryClassByMajorNoRequest queryClassByMajorNoRequest);
	 /**
     * 服务间调用：查询学校的一级部门下拉框
     * @author tkk
     * @create 2018-06-23
     */	 
	 public BaseResponseInfo<QueryDeptResponse> queryFirstDept();
	 /**
     * 服务间调用：根据一级部门编号查询二级部门信息下拉框
     * @author tkk
     * @create 2018-06-23
     */	 
	 public BaseResponseInfo<QueryDeptResponse> querySecondDeptByFirstDeptNo(@RequestBody QuerySecondDeptByFirstDeptNoRequest querySecondDeptByFirstDeptNoRequest);
			
	 /**
     * 根据筛选条件查询学生信息列表
     * @param queryStudentBasicInfoRequest
     * @author fr
     * @create 2018-06-23
     * @return
     */	 
	 public BaseResponseInfo<PageResult> queryRemoteStudentList(@RequestBody  QueryRemoteStudentListRequest queryRemoteStudentListRequest);
						
	 /**
      * 根据筛选条件查询学生信息没有分页
      * @author fr
      * @create 2018-06-25
      * @return
      */ 	 
 	 public BaseResponseInfo<QueryRemoteStudentListGroupResponse> queryRemoteStudentListGroup(@RequestBody QueryRemoteStudentListGroupRequest queryRemoteStudentListGroupRequest);	
 	/**
      * 查询二级部门信息
      * @author wm
      * @create 2018-06-28
      * @return
      */ 
    public BaseResponseInfo<QueryDeptResponse> querySecondDept() ;
}