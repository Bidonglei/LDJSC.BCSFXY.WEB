package com.sunmnet.bigdata.systemManage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.support.util.DateUtil;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetDepartmentInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.DepartmentStatusEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryDepartmentDropdownModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryDepartmentPageModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryDeptModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddDepartmentInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyDepartmentInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyDepartmentStatusRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryDepartmentInfoPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryDepartmentDropdownResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryDepartmentInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryDeptResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetDepartmentInfoDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetUserInfoDao;
import com.sunmnet.bigdata.systemManage.service.DepartmentInfoService;
import com.sunmnet.bigdata.systemManage.service.DiagnosisStudentService;
import com.sunmnet.bigdata.systemManage.util.MethodUtil;
import com.sunmnet.bigdata.systemManage.util.SequenceUtil;

/**
 * 部门信息实现
 * @author wm
 * @create 2018-03-21
 */
@Service
public class DepartmentInfoServiceImpl implements DepartmentInfoService {
	
	private Logger logger = LoggerFactory.getLogger(DepartmentInfoServiceImpl.class);
	@Autowired
	private SunmnetDepartmentInfoDao sunmnetDepartmentInfoDao;
	@Autowired
	private SunmnetUserInfoDao sunmnetUserInfoDao;
	@Autowired
	private DiagnosisStudentService diagnosisStudentRemote;
	
	/**
     * 部门信息下拉框选择
     * @author wm
     * @create 2018-03-23
     * @return
     */
	@Override
	public SystemManageResponseInfo<QueryDepartmentDropdownResponse> queryDepartmentDropdown() {
		SystemManageResponseInfo<QueryDepartmentDropdownResponse> responseInfo = new SystemManageResponseInfo<QueryDepartmentDropdownResponse>();		
		try {
			List<QueryDepartmentDropdownModel> list = sunmnetDepartmentInfoDao.queryDepartmentDropdown();
			QueryDepartmentDropdownResponse queryDepartmentDropdownResponse = new QueryDepartmentDropdownResponse();
			queryDepartmentDropdownResponse.setList(list);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,queryDepartmentDropdownResponse);
		} catch (Exception e) {
			logger.error("部门信息下拉框选择--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 分页查询部门信息
     * @param queryDepartmentInfoPageRequest
     * @author wth
     * @create 2018-03-27
     * @return
     */
	@Override
	public SystemManageResponseInfo<PageResult> query(QueryDepartmentInfoPageRequest queryDepartmentInfoPageRequest) {
		SystemManageResponseInfo<PageResult> responseInfo = new SystemManageResponseInfo<PageResult>();
		try {
			int pageNum = queryDepartmentInfoPageRequest.getPageNum(); //  当前页
			int pageSize = queryDepartmentInfoPageRequest.getPageSize();//  每页显示的记录数量
			PageHelper.startPage(pageNum, pageSize);
			List<SunmnetDepartmentInfoEntity> list = sunmnetDepartmentInfoDao.findDepartmentInfo(queryDepartmentInfoPageRequest);
			Page<SunmnetDepartmentInfoEntity> count = (Page<SunmnetDepartmentInfoEntity>)list;
			List<QueryDepartmentPageModel> listData = new ArrayList<QueryDepartmentPageModel>(); 
			for(SunmnetDepartmentInfoEntity sunmnetDepartmentInfoEntity : list){
				QueryDepartmentPageModel queryDepartmentPageModel = new QueryDepartmentPageModel();
				String departmentNo = sunmnetDepartmentInfoEntity.getDepartmentNo();
				queryDepartmentPageModel.setDepartmentNo(departmentNo);//部门编号  唯一标识
				queryDepartmentPageModel.setDepartmentName(sunmnetDepartmentInfoEntity.getDepartmentName());
				//统计部门人数
				long userNum = sunmnetUserInfoDao.getDepartmentUserNum(departmentNo);
				queryDepartmentPageModel.setNum(userNum);
				queryDepartmentPageModel.setDepartmentDescribe(sunmnetDepartmentInfoEntity.getDepartmentDescribe());
				queryDepartmentPageModel.setDepartmentStatus(sunmnetDepartmentInfoEntity.getDepartmentStatus());
				queryDepartmentPageModel.setDepartmentStatusStr(sunmnetDepartmentInfoEntity.getDepartmentStatus().getMsg());
				String createTime = sunmnetDepartmentInfoEntity.getCreateTime();
				if(!("").equals(createTime)&&createTime!=null){
					queryDepartmentPageModel.setCreateTime(DateUtil.formartStringDate(DateUtil.dateandtime,DateUtil.simple,createTime));//创建时间  格式：YYYYMMDDHHmmssSSS
				}
				String lastModifyTime = sunmnetDepartmentInfoEntity.getLastModifyTime();
				if(!("").equals(lastModifyTime)&&lastModifyTime!=null){
					queryDepartmentPageModel.setLastModifyTime(DateUtil.formartStringDate(DateUtil.dateandtime,DateUtil.simple,lastModifyTime));//最后修改时间  格式：YYYYMMDDHHmmssSSS
				}
				listData.add(queryDepartmentPageModel);
			}
			
			PageResult pageResult = new PageResult(listData, count.getTotal(), pageNum, pageSize);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,pageResult);
		} catch (Exception e) {
			logger.error("分页查询部门信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
		

	}

	/**
     * 增加部门
     * @param addDepartmentInfo
     * @author zfb
     * @create 2018-03-27
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> addDepartmentInfo(AddDepartmentInfoRequest addDepartmentInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			SunmnetDepartmentInfoEntity sunmnetDepartmentInfoEntity = new SunmnetDepartmentInfoEntity();
			sunmnetDepartmentInfoEntity.setDepartmentNo(SequenceUtil.getDepartmentNo());
			sunmnetDepartmentInfoEntity.setDepartmentName(addDepartmentInfoRequest.getDepartmentName());
			sunmnetDepartmentInfoEntity.setDepartmentDescribe(addDepartmentInfoRequest.getDepartmentDescribe());
			sunmnetDepartmentInfoEntity.setDepartmentStatus(DepartmentStatusEnum.NORMAL);			
			String nowTime = DateUtil.getDateAndTimes();
			sunmnetDepartmentInfoEntity.setCreateTime(nowTime);//创建时间  格式：YYYYMMDDHHmmssSSS
		    int count = sunmnetDepartmentInfoDao.insertSelective(sunmnetDepartmentInfoEntity);
			if(count!=1){
				logger.info("新增部门--保存信息失败;详情："+sunmnetDepartmentInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("新增部门--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 删除部门信息
     * @param departmentNo
     * @author zfb
     * @create 2018-04-05
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> deleteDepartmentInfo(String departmentNo) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			int count = sunmnetDepartmentInfoDao.deleteDepartmentInfoByDepartmentNo(departmentNo);
			if(count!=1){
				logger.info("删除部门信息--删除部门信息失败;部门编号："+departmentNo);
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("删除部门信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 修改部门状态
     * @param departmentNo
     * @author zfb
     * @create 2018-04-05
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> modifyDepartmentStatus(
			ModifyDepartmentStatusRequest modifyDepartmentStatusRequest,
			SunmnetDepartmentInfoEntity sunmnetDepartmentInfoEntity) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {			
			sunmnetDepartmentInfoEntity.setDepartmentStatus(modifyDepartmentStatusRequest.getDepartmentStatus()); //部门状态
			sunmnetDepartmentInfoEntity.setLastModifyTime(DateUtil.getDateAndTimes());//最后修改时间  格式：YYYYMMDDHHmmssSSS
			int count = sunmnetDepartmentInfoDao.updateDepartmentStatusByDepartmentNo(sunmnetDepartmentInfoEntity);
			if(count!=1){
				logger.info("修改部门状态--修改部门状态失败;详情："+sunmnetDepartmentInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("修改部门状态--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 查看部门详情
     * @param sunmnetDepartmentInfoEntity
     * @author zfb
     * @create 2018-04-05
     * @return
     */
	@Override
	public SystemManageResponseInfo<QueryDepartmentInfoResponse> queryDepartmentInfoByDepartmentNo(
			SunmnetDepartmentInfoEntity sunmnetDepartmentInfoEntity) {
		SystemManageResponseInfo<QueryDepartmentInfoResponse> responseInfo = new SystemManageResponseInfo<QueryDepartmentInfoResponse>();		
		try {
			QueryDepartmentInfoResponse queryDepartmentInfoResponse = new QueryDepartmentInfoResponse();
			//统计部门人数
			String departmentNo = sunmnetDepartmentInfoEntity.getDepartmentNo();
			long userNum = sunmnetUserInfoDao.getDepartmentUserNum(departmentNo);
			queryDepartmentInfoResponse.setNum(userNum);
			queryDepartmentInfoResponse.setDepartmentNo(departmentNo);
			queryDepartmentInfoResponse.setDepartmentName(sunmnetDepartmentInfoEntity.getDepartmentName());
			queryDepartmentInfoResponse.setDepartmentDescribe(sunmnetDepartmentInfoEntity.getDepartmentDescribe());
			queryDepartmentInfoResponse.setDepartmentStatus(sunmnetDepartmentInfoEntity.getDepartmentStatus());
			queryDepartmentInfoResponse.setDepartmentStatusStr(sunmnetDepartmentInfoEntity.getDepartmentStatus().getMsg());
	    	  
		    String createTime = sunmnetDepartmentInfoEntity.getCreateTime();
			if(!("").equals(createTime)&&createTime!=null){
				queryDepartmentInfoResponse.setCreateTime(DateUtil.formartStringDate(DateUtil.dateandtime,DateUtil.simple,createTime));//创建时间  格式：YYYYMMDDHHmmssSSS
			}
			String lastModifyTime = sunmnetDepartmentInfoEntity.getLastModifyTime();
			if(!("").equals(lastModifyTime)&&lastModifyTime!=null){
				queryDepartmentInfoResponse.setLastModifyTime(DateUtil.formartStringDate(DateUtil.dateandtime,DateUtil.simple,lastModifyTime));//最后修改时间  格式：YYYYMMDDHHmmssSSS
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,queryDepartmentInfoResponse);
		} catch (Exception e) {
			logger.error("查看部门详情--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 修改部门信息
     * @param modifyDepartmentInfoRequest
     * @param sunmnetDepartmentInfoEntity
     * @author zfb
     * @create 2018-04-09
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> modifyDepartmentInfo(
			ModifyDepartmentInfoRequest modifyDepartmentInfoRequest,
			SunmnetDepartmentInfoEntity sunmnetDepartmentInfoEntity) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {			
			sunmnetDepartmentInfoEntity.setDepartmentName(modifyDepartmentInfoRequest.getDepartmentName()); //部门名称
			sunmnetDepartmentInfoEntity.setDepartmentDescribe(modifyDepartmentInfoRequest.getDepartmentDescribe());
			sunmnetDepartmentInfoEntity.setLastModifyTime(DateUtil.getDateAndTimes());//最后修改时间  格式：YYYYMMDDHHmmssSSS
			int count = sunmnetDepartmentInfoDao.updateDepartmentInfoByDepartmentNo(sunmnetDepartmentInfoEntity);
			if(count!=1){
				logger.info("修改部门信息--修改部门信息失败;详情："+sunmnetDepartmentInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("修改部门信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 同步教职工部门信息
     * @param 
     * @author wm
     * @create 2018-06-28
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> generationDepartmentInfoTeacher() {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {		
			//服务间调用查询要分组的教职工信息进行保存
			BaseResponseInfo<QueryDeptResponse> response = diagnosisStudentRemote.querySecondDept();
			if(response!=null){
				logger.info("同步教职工部门信息--服务间调用返回信息:"+response.toString());
				if(!MethodUtil.isSucceed(response)){
					logger.info("同步教职工部门信息--服务间调用返回失败,详情:"+response.toString());
				}else{
					QueryDeptResponse queryDeptResponse = response.getData();
					List<QueryDeptModel> list = queryDeptResponse.getList(); 
					for(QueryDeptModel queryDeptModel :list){
						SunmnetDepartmentInfoEntity sunmnetDepartmentInfoEntity = new SunmnetDepartmentInfoEntity();
						String departmentNo = queryDeptModel.getDeptCode();
						sunmnetDepartmentInfoEntity.setDepartmentNo(departmentNo);
						sunmnetDepartmentInfoEntity.setDepartmentName(queryDeptModel.getDeptName());
						sunmnetDepartmentInfoEntity.setDepartmentDescribe(queryDeptModel.getDeptName());
						sunmnetDepartmentInfoEntity.setDepartmentStatus(DepartmentStatusEnum.NORMAL);			
						String nowTime = DateUtil.getDateAndTimes();
						sunmnetDepartmentInfoEntity.setCreateTime(nowTime);//创建时间  格式：YYYYMMDDHHmmssSSS
						SunmnetDepartmentInfoEntity sunmnetDepartmentInfoEntityCheck =sunmnetDepartmentInfoDao.getDepartmentInfoByDepartmentNo(departmentNo);
						if(sunmnetDepartmentInfoEntityCheck==null){
							int count = sunmnetDepartmentInfoDao.insertSelective(sunmnetDepartmentInfoEntity);
							if(count!=1){
								logger.info("同步教职工部门信息--保存信息失败;详情："+sunmnetDepartmentInfoEntity.toString());
							}
						}else{
							sunmnetDepartmentInfoEntity.setLastModifyTime(nowTime);
							int count = sunmnetDepartmentInfoDao.updateDepartmentInfoByDepartmentNo(sunmnetDepartmentInfoEntity);
							if(count!=1){
								logger.info("同步教职工部门信息--修改信息失败;详情："+sunmnetDepartmentInfoEntity.toString());
							}
							
						}
						
						
					}
				}
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("同步教职工部门信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	
}
