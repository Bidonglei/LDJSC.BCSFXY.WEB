package com.sunmnet.bigdata.systemManage.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.DegreeEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.ProfessionalTitleEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryClassByMajorNoModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryDeptModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryDictDropDownModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryMajorByDepartmentNoModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryStudentDepartmentModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryTeacherDropDownModel;
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
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetSystemDictInfoDao;
import com.sunmnet.bigdata.systemManage.service.DiagnosisStudentService;
import com.sunmnet.bigdata.systemManage.service.DiagnosisTeacherService;
import com.sunmnet.bigdata.systemManage.service.PublicService;
import com.sunmnet.bigdata.systemManage.util.MethodUtil;
/**
 * 系统公共接口
 * @author wm
 * @create 2018-06-26
 */
@Service
public class PublicServiceImpl implements PublicService{
	
	
	private Logger logger = LoggerFactory.getLogger(PublicServiceImpl.class);
	@Autowired
	private DiagnosisStudentService diagnosisStudentRemote;
	@Autowired
	private DiagnosisTeacherService diagnosisTeacherRemote;
	@Autowired
	private SunmnetSystemDictInfoDao sunmnetSystemDictInfoDao;
	
	
	/**
	 * 查询教师职称下拉框
	 * @auther tkk
	 * 2018年6月22日
	 */
	@Override
	public SystemManageResponseInfo<QueryProfessionalTitleResponse> queryProfessionalTitle() {
		SystemManageResponseInfo<QueryProfessionalTitleResponse> responseInfo = new SystemManageResponseInfo<QueryProfessionalTitleResponse>();
		try {
			List<QueryTeacherDropDownModel> professionalTypeList = ProfessionalTitleEnum.getProfessionalTypeList();
			QueryProfessionalTitleResponse response = new QueryProfessionalTitleResponse();
			response.setProfessionalTypeList(professionalTypeList);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,response);
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
	public SystemManageResponseInfo<QueryTeacherDegreeResponse> queryTeacherDegree() {
		SystemManageResponseInfo<QueryTeacherDegreeResponse> responseInfo = new SystemManageResponseInfo<QueryTeacherDegreeResponse>();
		try {
			List<QueryTeacherDropDownModel> degreeTypeList = DegreeEnum.getProfessionalTypeList();			
			
			QueryTeacherDegreeResponse response = new QueryTeacherDegreeResponse();
			response.setTeacherDegreeList(degreeTypeList);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,response);
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
	public SystemManageResponseInfo<QueryStudentDepartmentResponse> queryStudentDepartment() {
		SystemManageResponseInfo<QueryStudentDepartmentResponse> responseInfo = new SystemManageResponseInfo<QueryStudentDepartmentResponse>();
		try {
			BaseResponseInfo<QueryStudentDepartmentResponse> queryStudentDepartment = diagnosisStudentRemote.queryStudentDepartment();
			QueryStudentDepartmentResponse response = new QueryStudentDepartmentResponse();
			if(queryStudentDepartment != null && queryStudentDepartment.getData() != null){
				List<QueryStudentDepartmentModel> list = queryStudentDepartment.getData().getList();
				response.setList(list);
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,response);
		} catch (Exception e) {
			logger.error("指标管理：查询学生八个系的下拉框--异常", e);
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
	public SystemManageResponseInfo<QueryMajorByDepartmentNoResponse> queryMajorByDepartmentNo(
			QueryMajorByDepartmentNoRequest queryMajorByDepartmentNoRequest) {
		SystemManageResponseInfo<QueryMajorByDepartmentNoResponse> responseInfo = new SystemManageResponseInfo<QueryMajorByDepartmentNoResponse>();
		try {
			QueryMajorByDepartmentNoResponse response = new QueryMajorByDepartmentNoResponse();
		    BaseResponseInfo<QueryMajorByDepartmentNoResponse> queryMajorByDepartmentNo = diagnosisStudentRemote.queryMajorByDepartmentNo(queryMajorByDepartmentNoRequest);
			if(queryMajorByDepartmentNo != null && queryMajorByDepartmentNo.getData() != null){
				List<QueryMajorByDepartmentNoModel> list = queryMajorByDepartmentNo.getData().getList();
				response.setList(list);
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,response);
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
	public SystemManageResponseInfo<QueryClassByMajorNoResponse> queryClassByMajorNo(
			QueryClassByMajorNoRequest queryClassByMajorNoRequest) {
		SystemManageResponseInfo<QueryClassByMajorNoResponse> responseInfo = new SystemManageResponseInfo<QueryClassByMajorNoResponse>();
		try {
			QueryClassByMajorNoResponse response = new QueryClassByMajorNoResponse();
		    BaseResponseInfo<QueryClassByMajorNoResponse> queryClassByMajorNo = diagnosisStudentRemote.queryClassByMajorNo(queryClassByMajorNoRequest);
			if(queryClassByMajorNo != null && queryClassByMajorNo.getData() != null){
				List<QueryClassByMajorNoModel> list = queryClassByMajorNo.getData().getList();
				response.setList(list);
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,response);
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
	public SystemManageResponseInfo<QueryDeptResponse> queryFirstDept() {
		SystemManageResponseInfo<QueryDeptResponse> responseInfo = new SystemManageResponseInfo<QueryDeptResponse>();
		try {
			QueryDeptResponse response = new QueryDeptResponse();
		    BaseResponseInfo<QueryDeptResponse> queryFirstDept = diagnosisStudentRemote.queryFirstDept();
			if(queryFirstDept != null && queryFirstDept.getData() != null){
				 List<QueryDeptModel> list = queryFirstDept.getData().getList();
				response.setList(list);
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,response);
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
	public SystemManageResponseInfo<QueryDeptResponse> querySecondDeptByFirstDeptNo(
			QuerySecondDeptByFirstDeptNoRequest querySecondDeptByFirstDeptNoRequest) {
		SystemManageResponseInfo<QueryDeptResponse> responseInfo = new SystemManageResponseInfo<QueryDeptResponse>();
		try {
			QueryDeptResponse response = new QueryDeptResponse();
		    BaseResponseInfo<QueryDeptResponse> querySecondDeptByFirstDeptNo = diagnosisStudentRemote.querySecondDeptByFirstDeptNo(querySecondDeptByFirstDeptNoRequest);
			if(querySecondDeptByFirstDeptNo != null && querySecondDeptByFirstDeptNo.getData() != null){
				 List<QueryDeptModel> list = querySecondDeptByFirstDeptNo.getData().getList();
				response.setList(list);
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,response);
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
	public SystemManageResponseInfo<PageResult> queryRemoteTeacherList(
			QueryRemoteTeacherListRequest queryRemoteTeacherListRequest) {
		SystemManageResponseInfo<PageResult> responseInfo = new SystemManageResponseInfo<PageResult>();		
		try {
			BaseResponseInfo<PageResult> response = diagnosisTeacherRemote.queryRemoteTeacherList(queryRemoteTeacherListRequest);
			if(response==null){
				logger.info("根据筛选条件查询教职工信息--服务间调用返回为空");
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			logger.info("根据筛选条件查询教职工信息--服务间调用返回信息:"+response.toString());
			if(!MethodUtil.isSucceed(response)){
				logger.info("根据筛选条件查询教职工信息--服务间调用返回失败,详情:"+response.toString());
				responseInfo.setCode(response.getCode());
				responseInfo.setMessage(response.getMessage());
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,response.getData());
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
	public SystemManageResponseInfo<PageResult> queryRemoteStudentList(
			QueryRemoteStudentListRequest queryRemoteStudentListRequest) {
		SystemManageResponseInfo<PageResult> responseInfo = new SystemManageResponseInfo<PageResult>();		
		try {
			BaseResponseInfo<PageResult> response = diagnosisStudentRemote.queryRemoteStudentList(queryRemoteStudentListRequest);
			if(response==null){
				logger.info("根据筛选条件查询学生信息--服务间调用返回为空");
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			logger.info("根据筛选条件查询学生信息--服务间调用返回信息:"+response.toString());
			if(!MethodUtil.isSucceed(response)){
				logger.info("根据筛选条件查询学生信息--服务间调用返回失败,详情:"+response.toString());
				responseInfo.setCode(response.getCode());
				responseInfo.setMessage(response.getMessage());
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,response.getData());
		} catch (Exception e) {
			logger.error("根据筛选条件查询学生信息--异常", e);
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
	public SystemManageResponseInfo<QueryDictDropDownResponse> queryDictDrpDown(QueryDictDropDownRequest queryDictDropDownRequest) {
		SystemManageResponseInfo<QueryDictDropDownResponse> responseInfo = new SystemManageResponseInfo<QueryDictDropDownResponse>();
		try {
			QueryDictDropDownResponse response = new QueryDictDropDownResponse();
//			String dictType = queryDictDropDownRequest.getDictType();
			List<QueryDictDropDownModel> modelList = sunmnetSystemDictInfoDao.queryDictDrpDown(queryDictDropDownRequest);
			response.setList(modelList);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,response);
		} catch (Exception e) {
			logger.error("查询数据字典下拉框--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

}
