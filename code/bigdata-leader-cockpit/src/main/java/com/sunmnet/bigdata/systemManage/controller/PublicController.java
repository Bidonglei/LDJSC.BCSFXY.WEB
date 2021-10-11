package com.sunmnet.bigdata.systemManage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.IsPublicRequest;
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
import com.sunmnet.bigdata.systemManage.biz.PublicBiz;
import com.sunmnet.bigdata.systemManage.common.exception.SystemManageException;
import com.sunmnet.bigdata.systemManage.common.log.LoggerManage;


/**
 * 系统公共接口
 * @author wm
 * @create 2018-06-26
 */
@RestController
@RequestMapping("/manage/public")
public class PublicController extends BaseController{
	
	@Autowired
	private PublicBiz publicBiz;
	
	/**
     * 查询教师职称下拉框
     * @author tkk
     * @create 2018-06-22
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryProfessionalTitle")
    @LoggerManage(description = "查询教师职称下拉框")
    public BaseResponseInfo<QueryProfessionalTitleResponse> queryProfessionalTitle(@Validated IsPublicRequest isPublicRequest,BindingResult bindingResult) {
		BaseResponseInfo<QueryProfessionalTitleResponse> responseInfo = new BaseResponseInfo<QueryProfessionalTitleResponse>();
		try {
			responseInfo = publicBiz.queryProfessionalTitle();
		} catch (Exception e) {
			logger.error("查询教师职称下拉框--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 查询教师学历下拉框
     * @author tkk
     * @create 2018-06-22
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryTeacherDegree")
    @LoggerManage(description = "查询教师学历下拉框")
    public BaseResponseInfo<QueryTeacherDegreeResponse> queryTeacherDegree(@Validated IsPublicRequest isPublicRequest,BindingResult bindingResult) {
		BaseResponseInfo<QueryTeacherDegreeResponse> responseInfo = new BaseResponseInfo<QueryTeacherDegreeResponse>();
		try {
			responseInfo = publicBiz.queryTeacherDegree();
		} catch (Exception e) {
			logger.error("查询教师学历下拉框--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	
	
	/**
     * 指标管理：查询学生八个系的下拉框
     * @author tkk
     * @create 2018-06-22
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryStudentDepartment")
    @LoggerManage(description = "查询学生八个系的下拉框")
    public BaseResponseInfo<QueryStudentDepartmentResponse> queryStudentDepartment(@Validated IsPublicRequest isPublicRequest,BindingResult bindingResult) {
		BaseResponseInfo<QueryStudentDepartmentResponse> responseInfo = new BaseResponseInfo<QueryStudentDepartmentResponse>();
		try {
			responseInfo = publicBiz.queryStudentDepartment();
		} catch (Exception e) {
			logger.error("查询学生八个系的下拉框--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 根据学生八个系的系编号查询对应的专业下拉框
     * @author tkk
     * @create 2018-06-22
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryMajorByDepartmentNo")
    @LoggerManage(description = "根据学生八个系的系编号查询对应的专业下拉框")
    public BaseResponseInfo<QueryMajorByDepartmentNoResponse> queryMajorByDepartmentNo(@Validated QueryMajorByDepartmentNoRequest queryMajorByDepartmentNoRequest,BindingResult bindingResult) {
		BaseResponseInfo<QueryMajorByDepartmentNoResponse> responseInfo = new BaseResponseInfo<QueryMajorByDepartmentNoResponse>();
		try {
			responseInfo = publicBiz.queryMajorByDepartmentNo(queryMajorByDepartmentNoRequest);
		} catch (Exception e) {
			logger.error("根据学生八个系的系编号查询对应的专业下拉框--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 根据学生专业编号查询对应的班级下拉框
     * @author tkk
     * @create 2018-06-22
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryClassByMajorNo")
    @LoggerManage(description = "根据学生专业编号查询对应的班级下拉框")
    public BaseResponseInfo<QueryClassByMajorNoResponse> queryClassByMajorNo(@Validated QueryClassByMajorNoRequest queryClassByMajorNoRequest,BindingResult bindingResult) {
		BaseResponseInfo<QueryClassByMajorNoResponse> responseInfo = new BaseResponseInfo<QueryClassByMajorNoResponse>();
		try {
			responseInfo = publicBiz.queryClassByMajorNo(queryClassByMajorNoRequest);
		} catch (Exception e) {
			logger.error("根据学生专业编号查询对应的班级下拉框--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	/**
     *  指标管理：查询学校的一级部门下拉框
     * @author tkk
     * @create 2018-06-22
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryFirstDept")
    @LoggerManage(description = " 指标管理：查询学校的一级部门下拉框")
    public BaseResponseInfo<QueryDeptResponse> queryFirstDept(@Validated IsPublicRequest isPublicRequest,BindingResult bindingResult) {
		BaseResponseInfo<QueryDeptResponse> responseInfo = new BaseResponseInfo<QueryDeptResponse>();
		try {
			responseInfo = publicBiz.queryFirstDept();
		} catch (Exception e) {
			logger.error(" 指标管理：查询学校的一级部门下拉框--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	/**
     *  指标管理：根据一级部门编号查询二级部门信息下拉框
     * @author tkk
     * @create 2018-06-22
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/querySecondDeptByFirstDeptNo")
    @LoggerManage(description = " 指标管理：根据一级部门编号查询二级部门信息下拉框")
    public BaseResponseInfo<QueryDeptResponse> querySecondDeptByFirstDeptNo(@Validated QuerySecondDeptByFirstDeptNoRequest querySecondDeptByFirstDeptNoRequest,BindingResult bindingResult) {
		BaseResponseInfo<QueryDeptResponse> responseInfo = new BaseResponseInfo<QueryDeptResponse>();
		try {
			responseInfo = publicBiz.querySecondDeptByFirstDeptNo(querySecondDeptByFirstDeptNoRequest);
		} catch (Exception e) {
			logger.error("指标管理：根据一级部门编号查询二级部门信息下拉框--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 根据筛选条件查询教职工信息
     * @author fr
     * @create 2018-06-23
     * @return
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryRemoteTeacherList")
    @LoggerManage(description = "根据筛选条件查询教职工信息")
	public BaseResponseInfo<PageResult> queryRemoteTeacherList(@Validated QueryRemoteTeacherListRequest queryRemoteTeacherListRequest,BindingResult bindingResult) {
		BaseResponseInfo<PageResult> responseInfo = new BaseResponseInfo<PageResult>();
		try {
			responseInfo = publicBiz.queryRemoteTeacherList(queryRemoteTeacherListRequest);
		} catch (Exception e) {
			logger.error("根据筛选条件查询教职工信息--异常",e);
			return SystemManageException.exception();
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
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryRemoteStudentList")
    @LoggerManage(description = "根据筛选条件查询学生信息列表")
	public BaseResponseInfo<PageResult> queryRemoteStudentList(@Validated QueryRemoteStudentListRequest queryRemoteStudentListRequest,BindingResult bindingResult) {
		BaseResponseInfo<PageResult> responseInfo = new BaseResponseInfo<PageResult>();
		try {
			responseInfo = publicBiz.queryRemoteStudentList(queryRemoteStudentListRequest);
		} catch (Exception e) {
			logger.error("根据筛选条件查询学生信息列表--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	/**
     * 用户管理关系下来框查询
     * @author zfb
     * @create 2018-09-17
     */
	@SuppressWarnings("unchecked")
	@RequestMapping("/queryDictDrpDown")
    @LoggerManage(description = "用户管理关系下来框查询")
    public BaseResponseInfo<QueryDictDropDownResponse> queryDictDrpDown(@Validated QueryDictDropDownRequest queryDictDropDownRequest,BindingResult bindingResult) {
		BaseResponseInfo<QueryDictDropDownResponse> responseInfo = new BaseResponseInfo<QueryDictDropDownResponse>();
		try {
			responseInfo = publicBiz.queryDictDrpDown(queryDictDropDownRequest);
		} catch (Exception e) {
			logger.error("用户管理关系下来框查询--异常",e);
			return SystemManageException.exception();
		}
		return responseInfo;
    }
	
	
}
