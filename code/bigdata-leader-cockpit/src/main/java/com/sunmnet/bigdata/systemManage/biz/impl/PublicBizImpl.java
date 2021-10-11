package com.sunmnet.bigdata.systemManage.biz.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
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
import com.sunmnet.bigdata.systemManage.biz.PublicBiz;
import com.sunmnet.bigdata.systemManage.service.PublicService;

/**
 * 系统公共接口
 * @author wm
 * @create 2018-06-26
 */
@Service
public class PublicBizImpl implements PublicBiz {
	
	private Logger logger = LoggerFactory.getLogger(PublicBizImpl.class);
	
	@Autowired
	private PublicService publicService;
	
	/**
	 * 查询教师职称下拉框
	 * @auther tkk
	 * 2018年6月22日
	 */
	@Override
	public BaseResponseInfo<QueryProfessionalTitleResponse> queryProfessionalTitle() {
		SystemManageResponseInfo<QueryProfessionalTitleResponse> responseInfo = new SystemManageResponseInfo<QueryProfessionalTitleResponse>();
		try {
			responseInfo = publicService.queryProfessionalTitle();
		} catch (Exception e) {
			logger.error("查询教师职称下拉框--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 查询教师学历下拉框
     * @author tkk
     * @create 2018-06-22
     */
	@Override
	public BaseResponseInfo<QueryTeacherDegreeResponse> queryTeacherDegree() {
		SystemManageResponseInfo<QueryTeacherDegreeResponse> responseInfo = new SystemManageResponseInfo<QueryTeacherDegreeResponse>();
		try {
			responseInfo = publicService.queryTeacherDegree();
		} catch (Exception e) {
			logger.error("查询教师学历下拉框--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 指标管理：查询学生八个系的下拉框
     * @author tkk
     * @create 2018-06-22
     * @return
     */
	@Override
	public BaseResponseInfo<QueryStudentDepartmentResponse> queryStudentDepartment() {
		SystemManageResponseInfo<QueryStudentDepartmentResponse> responseInfo = new SystemManageResponseInfo<QueryStudentDepartmentResponse>();
		try {
			responseInfo = publicService.queryStudentDepartment();
		} catch (Exception e) {
			logger.error("查询学生八个系的下拉框--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 根据学生八个系的系编号查询对应的专业下拉框
     * @author tkk
     * @create 2018-06-22
     */
	@Override
	public BaseResponseInfo<QueryMajorByDepartmentNoResponse> queryMajorByDepartmentNo(
			QueryMajorByDepartmentNoRequest queryMajorByDepartmentNoRequest) {
		SystemManageResponseInfo<QueryMajorByDepartmentNoResponse> responseInfo = new SystemManageResponseInfo<QueryMajorByDepartmentNoResponse>();
		try {
			responseInfo = publicService.queryMajorByDepartmentNo(queryMajorByDepartmentNoRequest);
		} catch (Exception e) {
			logger.error("根据学生八个系的系编号查询对应的专业下拉框--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 服务间调用：根据学生专业编号查询对应的班级下拉框
     * @author tkk
     * @create 2018-06-22
     */
	@Override
	public BaseResponseInfo<QueryClassByMajorNoResponse> queryClassByMajorNo(
			QueryClassByMajorNoRequest queryClassByMajorNoRequest) {
		SystemManageResponseInfo<QueryClassByMajorNoResponse> responseInfo = new SystemManageResponseInfo<QueryClassByMajorNoResponse>();
		try {
			responseInfo = publicService.queryClassByMajorNo(queryClassByMajorNoRequest);
		} catch (Exception e) {
			logger.error("根据学生专业编号查询对应的班级下拉框--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 服务间调用 指标管理：查询学校的一级部门下拉框
     * @author tkk
     * @create 2018-06-22
     */
	@Override
	public BaseResponseInfo<QueryDeptResponse> queryFirstDept() {
		SystemManageResponseInfo<QueryDeptResponse> responseInfo = new SystemManageResponseInfo<QueryDeptResponse>();
		try {
			responseInfo = publicService.queryFirstDept();
		} catch (Exception e) {
			logger.error("查询学校的一级部门下拉框--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 服务间调用 指标管理：根据一级部门编号查询二级部门信息下拉框
     * @author tkk
     * @create 2018-06-22
     */
	@Override
	public BaseResponseInfo<QueryDeptResponse> querySecondDeptByFirstDeptNo(
			QuerySecondDeptByFirstDeptNoRequest querySecondDeptByFirstDeptNoRequest) {
		SystemManageResponseInfo<QueryDeptResponse> responseInfo = new SystemManageResponseInfo<QueryDeptResponse>();
		try {
			responseInfo = publicService.querySecondDeptByFirstDeptNo(querySecondDeptByFirstDeptNoRequest);
		} catch (Exception e) {
			logger.error("根据一级部门编号查询二级部门信息下拉框--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 根据筛选条件查询教职工信息
     * @author fr
     * @create 2018-06-23
     * @return
     */
	@Override
	public BaseResponseInfo<PageResult> queryRemoteTeacherList(
			QueryRemoteTeacherListRequest queryRemoteTeacherListRequest) {
		SystemManageResponseInfo<PageResult> responseInfo = new SystemManageResponseInfo<PageResult>();
		try {
			responseInfo = publicService.queryRemoteTeacherList(queryRemoteTeacherListRequest);
		} catch (Exception e) {
			logger.error("根据筛选条件查询教职工信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 根据筛选条件查询学生信息列表
     * @param queryStudentBasicInfoRequest
     * @author fr
     * @create 2018-06-23
     * @return
     */
	@Override
	public BaseResponseInfo<PageResult> queryRemoteStudentList(
			QueryRemoteStudentListRequest queryRemoteStudentListRequest) {
		SystemManageResponseInfo<PageResult> responseInfo = new SystemManageResponseInfo<PageResult>();
		try {
			responseInfo = publicService.queryRemoteStudentList(queryRemoteStudentListRequest);
		} catch (Exception e) {
			logger.error("根据筛选条件查询学生信息列表--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 查询数据字典下拉框
     * @author zfb
     * @create 2018-09-17
     */
	@Override
	public BaseResponseInfo<QueryDictDropDownResponse> queryDictDrpDown(QueryDictDropDownRequest queryDictDropDownRequest) {
		SystemManageResponseInfo<QueryDictDropDownResponse> responseInfo = new SystemManageResponseInfo<QueryDictDropDownResponse>();
		try {
			responseInfo = publicService.queryDictDrpDown(queryDictDropDownRequest);
		} catch (Exception e) {
			logger.error("查询数据字典下拉框--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	
	
	
}
