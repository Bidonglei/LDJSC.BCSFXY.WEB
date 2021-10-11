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
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetCollegeTeacherInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.EducationEnums;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.IsCollegeCertificateEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.IsCoreTeacherEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.IsDoubleProfessionallyEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.IsJobCertificateEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.IsMajorLeaderEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.IsQuitEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.ManagerTypeEnums;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.ProfessionalTitleEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.RemoteTeacherListModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRemoteTeacherListGroupRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRemoteTeacherListRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryRemoteTeacherListGroupResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;
import com.sunmnet.bigdata.systemManage.dao.diagnosisTeaching.SunmnetCollegeTeacherInfoDao;
import com.sunmnet.bigdata.systemManage.service.DiagnosisTeacherService;


@Service
public class DiagnosisTeaherServiceImpl implements DiagnosisTeacherService{
	protected Logger logger = LoggerFactory.getLogger(DiagnosisTeaherServiceImpl.class);
	
	@Autowired
	private SunmnetCollegeTeacherInfoDao sunmnetCollegeTeacherInfoDao;


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
			int pageNum = queryRemoteTeacherListRequest.getPageNum(); //  当前页
			int pageSize = queryRemoteTeacherListRequest.getPageSize();//  每页显示的记录数量
			PageHelper.startPage(pageNum, pageSize);
			List<SunmnetCollegeTeacherInfoEntity> list= sunmnetCollegeTeacherInfoDao.queryRemoteTeacherList(queryRemoteTeacherListRequest);
			Page<SunmnetCollegeTeacherInfoEntity> count = (Page<SunmnetCollegeTeacherInfoEntity>)list;
			List<RemoteTeacherListModel> teacherList = new ArrayList<RemoteTeacherListModel>();
			if(list!=null && list.size()>0){
				for(SunmnetCollegeTeacherInfoEntity entity:list){
					RemoteTeacherListModel model = new RemoteTeacherListModel();
					BeanUtils.copyProperties(entity, model);
					EducationEnums education = entity.getEducation();
					if(education!=null){
						model.setEducationStr(education.getMessage());
					}
					EducationEnums degree = entity.getDegree();
					if(education!=null){
						model.setDegreeStr(degree.getMessage());
					}
					ProfessionalTitleEnum professionalTitle = entity.getProfessionalTitle();
					if(professionalTitle!=null){
						model.setProfessionalTitleStr(professionalTitle.getMsg());
					}
					IsDoubleProfessionallyEnum isDoubleProfessionally = entity.getIsDoubleProfessionally();
					if(isDoubleProfessionally!=null){
						model.setIsDoubleProfessionallyStr(isDoubleProfessionally.getMsg());	
					}
					IsCoreTeacherEnum isCoreTeacher = entity.getIsCoreTeacher();
					if(isCoreTeacher!=null){
						model.setIsCoreTeacherStr(isCoreTeacher.getMsg());
					}
					IsMajorLeaderEnum isMajorLeader = entity.getIsMajorLeader();
					if(isMajorLeader!=null){
						model.setIsMajorLeaderStr(isMajorLeader.getMsg());
					}
					IsCollegeCertificateEnum isCollegeCertificate = entity.getIsCollegeCertificate();
					if(isCollegeCertificate!=null){
						model.setIsCollegeCertificateStr(isCollegeCertificate.getMsg());
					}
					IsJobCertificateEnum isJobCertificate = entity.getIsJobCertificate();
					if(isJobCertificate!=null){
						model.setIsJobCertificateStr(isJobCertificate.getMsg());
					}
					ManagerTypeEnums managerType = entity.getManagerType();
					if(managerType!=null){
						model.setManagerTypeStr(managerType.getMessage());
					}
					IsQuitEnum isQuit = entity.getIsQuit();
					if(isQuit!=null){
						model.setIsQuitStr(isQuit.getMsg());
					}
					teacherList.add(model);
				}
			}
			PageResult pageResult = new PageResult(teacherList, count.getTotal(), pageNum, pageSize);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,pageResult);
		} catch (Exception e) {
			logger.error("根据筛选条件查询教职工信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}	 
	 
	 /**
     * 根据筛选条件查询教职工信息没有分页
     * @author wm
     * @create 2018-06-25
     * @return
     */
	 public BaseResponseInfo<QueryRemoteTeacherListGroupResponse> queryRemoteTeacherListGroup( QueryRemoteTeacherListGroupRequest queryRemoteTeacherListGroupRequest){
		 SystemManageResponseInfo<QueryRemoteTeacherListGroupResponse> responseInfo = new SystemManageResponseInfo<QueryRemoteTeacherListGroupResponse>();		
			try {
				QueryRemoteTeacherListRequest queryRemoteTeacherListRequest = new QueryRemoteTeacherListRequest();
				BeanUtils.copyProperties(queryRemoteTeacherListGroupRequest, queryRemoteTeacherListRequest);
				List<SunmnetCollegeTeacherInfoEntity> list= sunmnetCollegeTeacherInfoDao.queryRemoteTeacherList(queryRemoteTeacherListRequest);
				List<RemoteTeacherListModel> teacherList = new ArrayList<RemoteTeacherListModel>();
				if(list!=null && list.size()>0){
					for(SunmnetCollegeTeacherInfoEntity entity:list){
						RemoteTeacherListModel model = new RemoteTeacherListModel();
						BeanUtils.copyProperties(entity, model);
						EducationEnums education = entity.getEducation();
						if(education!=null){
							model.setEducationStr(education.getMessage());
						}
						EducationEnums degree = entity.getDegree();
						if(education!=null){
							model.setDegreeStr(degree.getMessage());
						}
						ProfessionalTitleEnum professionalTitle = entity.getProfessionalTitle();
						if(professionalTitle!=null){
							model.setProfessionalTitleStr(professionalTitle.getMsg());
						}
						IsDoubleProfessionallyEnum isDoubleProfessionally = entity.getIsDoubleProfessionally();
						if(isDoubleProfessionally!=null){
							model.setIsDoubleProfessionallyStr(isDoubleProfessionally.getMsg());	
						}
						IsCoreTeacherEnum isCoreTeacher = entity.getIsCoreTeacher();
						if(isCoreTeacher!=null){
							model.setIsCoreTeacherStr(isCoreTeacher.getMsg());
						}
						IsMajorLeaderEnum isMajorLeader = entity.getIsMajorLeader();
						if(isMajorLeader!=null){
							model.setIsMajorLeaderStr(isMajorLeader.getMsg());
						}
						IsCollegeCertificateEnum isCollegeCertificate = entity.getIsCollegeCertificate();
						if(isCollegeCertificate!=null){
							model.setIsCollegeCertificateStr(isCollegeCertificate.getMsg());
						}
						IsJobCertificateEnum isJobCertificate = entity.getIsJobCertificate();
						if(isJobCertificate!=null){
							model.setIsJobCertificateStr(isJobCertificate.getMsg());
						}
						ManagerTypeEnums managerType = entity.getManagerType();
						if(managerType!=null){
							model.setManagerTypeStr(managerType.getMessage());
						}
						IsQuitEnum isQuit = entity.getIsQuit();
						if(isQuit!=null){
							model.setIsQuitStr(isQuit.getMsg());
						}
						teacherList.add(model);
					}
				}
				QueryRemoteTeacherListGroupResponse queryRemoteTeacherListGroupResponse = new QueryRemoteTeacherListGroupResponse();
				queryRemoteTeacherListGroupResponse.setTeacherList(teacherList);
				responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,queryRemoteTeacherListGroupResponse);
			}catch (Exception e) {
				logger.error("根据筛选条件查询教职工信息没有分页--异常", e);
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
			}
			return responseInfo;
	 } 
	 
	 


}