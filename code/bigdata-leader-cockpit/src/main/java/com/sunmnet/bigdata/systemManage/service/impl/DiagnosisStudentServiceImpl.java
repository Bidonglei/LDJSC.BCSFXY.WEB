package com.sunmnet.bigdata.systemManage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunmnet.bigdata.systemManage.base.support.beanUtil.BeanUtils;
import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetStudentBasicInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryClassByMajorNoModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryDeptModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryMajorByDepartmentNoModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryStudentDepartmentModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.RemoteStudentListModel;
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
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;
import com.sunmnet.bigdata.systemManage.dao.diagnosisTeaching.SunmnetAcademyInfoDao;
import com.sunmnet.bigdata.systemManage.dao.diagnosisTeaching.SunmnetAcademyMajorInfoDao;
import com.sunmnet.bigdata.systemManage.dao.diagnosisTeaching.SunmnetClassInfoDao;
import com.sunmnet.bigdata.systemManage.dao.diagnosisTeaching.SunmnetStudentBasicInfoDao;
import com.sunmnet.bigdata.systemManage.service.DiagnosisStudentService;


@Service
public class DiagnosisStudentServiceImpl implements DiagnosisStudentService{
	protected Logger logger = LoggerFactory.getLogger(DiagnosisStudentServiceImpl.class);
	
	@Autowired
	private SunmnetAcademyInfoDao sunmnetAcademyInfoDao;
	@Autowired
	private SunmnetAcademyMajorInfoDao sunmnetAcademyMajorInfoDao;
	@Autowired
	private SunmnetClassInfoDao sunmnetClassInfoDao;
	@Autowired
	private SunmnetStudentBasicInfoDao sunmnetStudentBasicInfoDao;

	
	    /**
	     * 服务间调用  指标管理：查询学生八个系的下拉框
	     * @author tkk
	     * @create 2018-06-22
	     * @return
	     */
		@Override
		public BaseResponseInfo<QueryStudentDepartmentResponse> queryStudentDepartment() {
			SystemManageResponseInfo<QueryStudentDepartmentResponse> responseInfo = new SystemManageResponseInfo<QueryStudentDepartmentResponse>();		
			try {
				List<QueryStudentDepartmentModel> list = sunmnetAcademyInfoDao.queryStudentDepartment();
				QueryStudentDepartmentResponse response = new QueryStudentDepartmentResponse();
				response.setList(list);
				responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,response);
			} catch (Exception e) {
				logger.error("查询学生八个系的下拉框--异常", e);
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
			}
			return responseInfo;
		}
	    /**
	     * 服务间调用 指标管理：根据学生八个系的系编号查询对应的专业下拉框
	     * @author tkk
	     * @create 2018-06-22
	     * @return
	     */
		@Override
		 public BaseResponseInfo<QueryMajorByDepartmentNoResponse> queryMajorByDepartmentNo(QueryMajorByDepartmentNoRequest queryMajorByDepartmentNoRequest){
			SystemManageResponseInfo<QueryMajorByDepartmentNoResponse> responseInfo = new SystemManageResponseInfo<QueryMajorByDepartmentNoResponse>();		
				try {
					List<QueryMajorByDepartmentNoModel> list = sunmnetAcademyMajorInfoDao.queryMajorByDepartmentNono(queryMajorByDepartmentNoRequest);
					QueryMajorByDepartmentNoResponse response = new QueryMajorByDepartmentNoResponse();
					response.setList(list);
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
		public BaseResponseInfo<QueryClassByMajorNoResponse> queryClassByMajorNo(
				QueryClassByMajorNoRequest queryClassByMajorNoRequest) {
			SystemManageResponseInfo<QueryClassByMajorNoResponse> responseInfo = new SystemManageResponseInfo<QueryClassByMajorNoResponse>();		
			try {
				List<QueryClassByMajorNoModel> list = sunmnetClassInfoDao.queryClassByMajorNo(queryClassByMajorNoRequest);
				QueryClassByMajorNoResponse response = new QueryClassByMajorNoResponse();
				response.setList(list);
				responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,response);
			} catch (Exception e) {
				logger.error("根据学生专业编号查询对应的班级下拉框--异常", e);
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
			}
			return responseInfo;
		}
		 /**
	     * 服务间调用：查询学校的一级部门下拉框
	     * @author tkk
	     * @create 2018-06-23
	     */
		@Override
		public BaseResponseInfo<QueryDeptResponse> queryFirstDept() {
			SystemManageResponseInfo<QueryDeptResponse> responseInfo = new SystemManageResponseInfo<QueryDeptResponse>();		
			try {
				List<QueryDeptModel> list = sunmnetClassInfoDao.queryFirstDept();
				QueryDeptResponse response = new QueryDeptResponse();
				response.setList(list);
				responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,response);
			} catch (Exception e) {
				logger.error("查询学校的一级部门下拉框--异常", e);
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
			}
			return responseInfo;
		}
		 /**
	     * 服务间调用：根据一级部门编号查询二级部门信息下拉框
	     * @author tkk
	     * @create 2018-06-23
	     */
		@Override
		public BaseResponseInfo<QueryDeptResponse> querySecondDeptByFirstDeptNo(
				QuerySecondDeptByFirstDeptNoRequest querySecondDeptByFirstDeptNoRequest) {
			SystemManageResponseInfo<QueryDeptResponse> responseInfo = new SystemManageResponseInfo<QueryDeptResponse>();		
			try {
				List<QueryDeptModel> list = sunmnetClassInfoDao.querySecondDeptByFirstDeptNo(querySecondDeptByFirstDeptNoRequest);
				QueryDeptResponse response = new QueryDeptResponse();
				response.setList(list);
				responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,response);
			} catch (Exception e) {
				logger.error("根据一级部门编号查询二级部门信息下拉框--异常", e);
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
				int pageNum = queryRemoteStudentListRequest.getPageNum(); //  当前页
				int pageSize = queryRemoteStudentListRequest.getPageSize();//  每页显示的记录数量
				PageHelper.startPage(pageNum, pageSize);
				List<SunmnetStudentBasicInfoEntity> list= sunmnetStudentBasicInfoDao.queryRemoteStudentList(queryRemoteStudentListRequest);
				Page<SunmnetStudentBasicInfoEntity> count = (Page<SunmnetStudentBasicInfoEntity>)list;
				List<RemoteStudentListModel> studentList = new ArrayList<RemoteStudentListModel>();
				if(list!=null && list.size()>0){
					for(SunmnetStudentBasicInfoEntity entity:list){
						RemoteStudentListModel model = new RemoteStudentListModel();
						BeanUtils.copyProperties(entity, model);
						model.setUserMail(entity.getQqNumber()+"@qq.com");
						model.setUserMobile(entity.getTelephone());
						studentList.add(model);
					}
				}
				PageResult pageResult = new PageResult(studentList, count.getTotal(), pageNum, pageSize);
				responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,pageResult);
			} catch (Exception e) {
				logger.error("根据筛选条件查询学生信息--异常", e);
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
			}
			return responseInfo;
		}
		/**
	     * 根据筛选条件查询学生信息没有分页
	     * @param queryStudentBasicInfoRequest
	     * @author fr
	     * @create 2018-06-23
	     * @return
	     */
		@Override
		 public BaseResponseInfo<QueryRemoteStudentListGroupResponse> queryRemoteStudentListGroup( QueryRemoteStudentListGroupRequest queryRemoteStudentListGroupRequest){
			SystemManageResponseInfo<QueryRemoteStudentListGroupResponse> responseInfo = new SystemManageResponseInfo<QueryRemoteStudentListGroupResponse>();		
			try {
				QueryRemoteStudentListRequest queryRemoteStudentListRequest = new QueryRemoteStudentListRequest();
				BeanUtils.copyProperties(queryRemoteStudentListGroupRequest, queryRemoteStudentListRequest);
				List<SunmnetStudentBasicInfoEntity> list= sunmnetStudentBasicInfoDao.queryRemoteStudentList(queryRemoteStudentListRequest);
				List<RemoteStudentListModel> studentsList = new ArrayList<RemoteStudentListModel>();
				if(list!=null && list.size()>0){
					for(SunmnetStudentBasicInfoEntity entity:list){
						RemoteStudentListModel model = new RemoteStudentListModel();
						BeanUtils.copyProperties(entity, model);
						model.setUserMail(entity.getQqNumber()+"@qq.com");
						model.setUserMobile(entity.getTelephone());
						studentsList.add(model);
					}
				}
				QueryRemoteStudentListGroupResponse queryRemoteStudentListGroupResponse = new QueryRemoteStudentListGroupResponse();
				queryRemoteStudentListGroupResponse.setList(studentsList);
				responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,queryRemoteStudentListGroupResponse);
			}catch (Exception e) {
				logger.error("根据筛选条件查询学生信息没有分页--异常", e);
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
			}
			return responseInfo;
		}
		/**
	      * 查询二级部门信息
	      * @author wm
	      * @create 2018-06-28
	      * @return
	      */
		@Override
		public BaseResponseInfo<QueryDeptResponse> querySecondDept() {
			SystemManageResponseInfo<QueryDeptResponse> responseInfo = new SystemManageResponseInfo<QueryDeptResponse>();		
			try {
				List<QueryDeptModel> list = sunmnetClassInfoDao.querySecondDept();
				QueryDeptResponse response = new QueryDeptResponse();
				response.setList(list);
				responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,response);
			} catch (Exception e) {
				logger.error("查询二级部门信息--异常", e);
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
			}
			return responseInfo;
		}

}