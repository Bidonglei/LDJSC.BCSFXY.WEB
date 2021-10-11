package com.sunmnet.bigdata.systemManage.biz.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetDepartmentInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.SystemManageResultEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddDepartmentInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.DeleteDepartmentInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyDepartmentInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifyDepartmentStatusRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryDepartmentInfoPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryDepartmentInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryDepartmentDropdownResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryDepartmentInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;
import com.sunmnet.bigdata.systemManage.biz.DepartmentInfoBiz;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetDepartmentInfoDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetUserInfoDao;
import com.sunmnet.bigdata.systemManage.service.DepartmentInfoService;
import com.sunmnet.bigdata.systemManage.util.SystemManageConstants;

/**
 * 部门信息实现
 * @author wm
 * @create 2018-03-21
 */
@Service
public class DepartmentInfoBizImpl implements DepartmentInfoBiz {
	
	private Logger logger = LoggerFactory.getLogger(DepartmentInfoBizImpl.class);
	
	
	@Autowired
	private DepartmentInfoService departmentInfoService;
	@Autowired
	private SunmnetUserInfoDao sunmnetUserInfoDao;
	@Autowired
	private SunmnetDepartmentInfoDao sunmnetDepartmentInfoDao;
	
	/**
     * 部门信息下拉框选择
     * @author wm
     * @create 2018-03-23
     * @return
     */
	@Override
	public BaseResponseInfo<QueryDepartmentDropdownResponse> queryDepartmentDropdown() {
		SystemManageResponseInfo<QueryDepartmentDropdownResponse> responseInfo = new SystemManageResponseInfo<QueryDepartmentDropdownResponse>();
		try {
			responseInfo = departmentInfoService.queryDepartmentDropdown();
		} catch (Exception e) {
			logger.error("查询部门信息下拉框选择校验--异常", e);
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
	public BaseResponseInfo<PageResult> query(QueryDepartmentInfoPageRequest queryDepartmentInfoPageRequest) {
		SystemManageResponseInfo<PageResult> responseInfo = new SystemManageResponseInfo<PageResult>();
		try {
			//把时间处理成17位YYYYMMDDHHmmssSSS	
			String startTime = queryDepartmentInfoPageRequest.getBeginTime();//开始时间格式YYYYMMDDHHmmss
		    String endTime = queryDepartmentInfoPageRequest.getEndTime();//结束时间格式YYYYMMDDHHmmss
		    if(startTime!=null&&(!"".equals(startTime))&&endTime!=null&&(!"".equals(endTime))){
		    	//把时间处理成17位YYYYMMDDHHmmssSSS
				String startTimeNew = startTime+SystemManageConstants.TIME_ADD_ZORE;//开始时间格式YYYYMMDDHHmmss
			    String endTimeNew = endTime+SystemManageConstants.TIME_ADD_ZORE;//结束时间格式YYYYMMDDHHmmss
			    queryDepartmentInfoPageRequest.setBeginTime(startTimeNew);
			    queryDepartmentInfoPageRequest.setEndTime(endTimeNew);
		    }	
		    responseInfo = departmentInfoService.query(queryDepartmentInfoPageRequest);
		} catch (Exception e) {
			logger.error("分页查询部门信息校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
		
	}

	/**
     * 新增部门
     * @param addDepartmentInfoRequest
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	@Override
	public BaseResponseInfo<Object> add(AddDepartmentInfoRequest addDepartmentInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			//判断该部门名称是否存在
			String departmentName = addDepartmentInfoRequest.getDepartmentName();
			SunmnetDepartmentInfoEntity sunmnetDepartmentInfoEntity = sunmnetDepartmentInfoDao.getDepartmentInfoByName(departmentName);
			if(sunmnetDepartmentInfoEntity!=null){
				logger.info("新增部门--部门名称已经存在;部门名称："+departmentName);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.DEPARTMENTNAME_EXISTENCE);
				return responseInfo;
			}
			
			
			responseInfo = departmentInfoService.addDepartmentInfo(addDepartmentInfoRequest);
		} catch (Exception e) {
			logger.error("新增部门校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 删除部门信息
     * @param deleteDepartmentInfoRequest
     * @author zfb
     * @create 2018-04-05
     * @return
     */
	@Override
	public BaseResponseInfo<Object> deleteDepartmentInfo(DeleteDepartmentInfoRequest deleteDepartmentInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			String departmentNo = deleteDepartmentInfoRequest.getDepartmentNo();
			//1、//统计部门人数
			long userNum = sunmnetUserInfoDao.getDepartmentUserNum(departmentNo);
			
			if(0 < userNum){
				logger.info("删除部门信息--部门下有用户不允许删除;部门编号："+departmentNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.DEPARTMENT_HAVA_USER);
				return responseInfo;
			}			
			responseInfo = departmentInfoService.deleteDepartmentInfo(departmentNo);
		} catch (Exception e) {
			logger.error("删除部门信息校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 修改部门状态
     * @param modifyDepartmentStatusRequest
     * @author zfb
     * @create 2018-04-05
     * @return
     */
	@Override
	public BaseResponseInfo<Object> modifyDepartmentStatus(
			ModifyDepartmentStatusRequest modifyDepartmentStatusRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			String departmentNo = modifyDepartmentStatusRequest.getDepartmentNo();
			//1、判断部门是否存在
			SunmnetDepartmentInfoEntity sunmnetDepartmentInfoEntity = sunmnetDepartmentInfoDao.getDepartmentInfoByDepartmentNo(departmentNo);
			if(sunmnetDepartmentInfoEntity==null){
				logger.info("修改部门状态--部门信息不存在;部门编号："+departmentNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_DEPARTMENT);
				return responseInfo;
			}
			responseInfo = departmentInfoService.modifyDepartmentStatus(modifyDepartmentStatusRequest,sunmnetDepartmentInfoEntity);
		
		} catch (Exception e) {
			logger.error("修改部门状态-异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 查询部门详细信息
     * @param queryDepartmentInfoRequest
     * @author zfb
     * @create 2018-04-05
     * @return
     */
	@Override
	public BaseResponseInfo<QueryDepartmentInfoResponse> queryDepartmentInfo(
			QueryDepartmentInfoRequest queryDepartmentInfoRequest) {
		SystemManageResponseInfo<QueryDepartmentInfoResponse> responseInfo = new SystemManageResponseInfo<QueryDepartmentInfoResponse>();
		try {
			String departmentNo = queryDepartmentInfoRequest.getDepartmentNo();
			//1、判断部门是否存在
			SunmnetDepartmentInfoEntity sunmnetDepartmentInfoEntity = sunmnetDepartmentInfoDao.getDepartmentInfoByDepartmentNo(departmentNo);
			if(sunmnetDepartmentInfoEntity==null){
				logger.info("查看部门详情--部门不存在;部门编号："+departmentNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_DEPARTMENT);
				return responseInfo;
			}
			responseInfo = departmentInfoService.queryDepartmentInfoByDepartmentNo(sunmnetDepartmentInfoEntity);
		} catch (Exception e) {
			logger.error("查看部门详情校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 修改部门信息
     * @param modifyDepartmentInfoRequest
     * @author zfb
     * @create 2018-04-09
     * @return
     */
	@Override
	public BaseResponseInfo<Object> modifyDepartmentInfo(
			ModifyDepartmentInfoRequest modifyDepartmentInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			String departmentNo = modifyDepartmentInfoRequest.getDepartmentNo();
			//1、判断部门是否存在
			SunmnetDepartmentInfoEntity sunmnetDepartmentInfoEntity = sunmnetDepartmentInfoDao.getDepartmentInfoByDepartmentNo(departmentNo);
			if(sunmnetDepartmentInfoEntity==null){
				logger.info("修改部门信息--部门信息不存在;部门编号："+departmentNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_DEPARTMENT);
				return responseInfo;
			}
			responseInfo = departmentInfoService.modifyDepartmentInfo(modifyDepartmentInfoRequest,sunmnetDepartmentInfoEntity);
		
		} catch (Exception e) {
			logger.error("修改部门状态-异常", e);
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
	public BaseResponseInfo<Object> generationDepartmentInfoTeacher() {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			responseInfo = departmentInfoService.generationDepartmentInfoTeacher();
		} catch (Exception e) {
			logger.error("同步教职工部门信息-异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}


	
	
	
}
