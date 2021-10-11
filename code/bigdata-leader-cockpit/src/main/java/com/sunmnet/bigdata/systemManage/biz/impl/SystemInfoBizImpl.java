package com.sunmnet.bigdata.systemManage.biz.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sunmnet.bigdata.systemManage.base.support.beanUtil.BeanUtils;
import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetMenuInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemStyleEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.SystemManageResultEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddSystemInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.DeleteImgRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.DeleteSystemInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifySystemInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryColorSetListRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QuerySystemInfoPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QuerySystemInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QuerySystemStyleListRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.SetSystemColorRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.UploadImgStatusRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.UploadSystemImgRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryColorSetListResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QuerySystemDropdownResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QuerySystemInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QuerySystemStyleListResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;
import com.sunmnet.bigdata.systemManage.biz.SystemInfoBiz;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetDepartmentInfoDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetMenuInfoDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetSystemInfoDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetSystemStyleDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetUserInfoDao;
import com.sunmnet.bigdata.systemManage.service.SystemInfoService;

/**
 * 系统信息实现
 * @author wm
 * @create 2018-03-21
 */
@Service
public class SystemInfoBizImpl implements SystemInfoBiz {
	
	private Logger logger = LoggerFactory.getLogger(SystemInfoBizImpl.class);
	
	
	@Autowired
	private SystemInfoService systemInfoService;
	@Autowired
	private SunmnetSystemInfoDao sunmnetSystemInfoDao;
	@Autowired
	private SunmnetDepartmentInfoDao sunmnetDepartmentInfoDao;
	@Autowired
	private SunmnetMenuInfoDao sunmnetMenuInfoDao;
	@Autowired
	private SunmnetUserInfoDao sunmnetUserInfoDao;
	@Autowired
	private SunmnetSystemStyleDao sunmnetSystemStyleDao;
	
	
	/**
     * 新增系统
     * @param addSystemInfoRequest
     * @author wm
     * @create 2018-03-21
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> add(AddSystemInfoRequest addSystemInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			String systemNo = addSystemInfoRequest.getSystemNo();
			SunmnetSystemInfoEntity sunmnetSystemInfoEntity = sunmnetSystemInfoDao.getSystemInfoBySystemNo(systemNo);
			if(sunmnetSystemInfoEntity!=null){
				logger.info("新增系统--系统编号已经存在;系统编号："+systemNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.SYSTEM_NO_EXIST);
				return responseInfo;
			}
			responseInfo = systemInfoService.add(addSystemInfoRequest);
		
		} catch (Exception e) {
			logger.error("新增系统校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 修改系统信息
     * @param modifySystemInfoRequest
     * @author wm
     * @create 2018-03-21
     * @return
     */
	@Override
	public BaseResponseInfo<Object> modify(ModifySystemInfoRequest modifySystemInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			String systemNo = modifySystemInfoRequest.getSystemNo();
			SunmnetSystemInfoEntity sunmnetSystemInfoEntity = sunmnetSystemInfoDao.getSystemInfoBySystemNo(systemNo);
			if(sunmnetSystemInfoEntity==null){
				logger.info("新增系统--系统信息不存在;系统编号："+systemNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_SYSTEM_NO);
				return responseInfo;
			}
			responseInfo = systemInfoService.modify(modifySystemInfoRequest,sunmnetSystemInfoEntity);
		
		} catch (Exception e) {
			logger.error("新增系统校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 分页查询系统信息
     * @param queryUserInfoPageRequest
     * @author wm
     * @create 2018-03-21
     * @return
     */
	@Override
	public BaseResponseInfo<PageResult> query(QuerySystemInfoPageRequest queryUserInfoPageRequest) {
		SystemManageResponseInfo<PageResult> responseInfo = new SystemManageResponseInfo<PageResult>();
		try {
			responseInfo = systemInfoService.query(queryUserInfoPageRequest);
		} catch (Exception e) {
			logger.error("分页查询系统信息校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 查询系统信息下拉框选择
     * @author wm
     * @create 2018-03-23
     * @return
     */
	@Override
	public BaseResponseInfo<QuerySystemDropdownResponse> querySystemDropdown() {
		SystemManageResponseInfo<QuerySystemDropdownResponse> responseInfo = new SystemManageResponseInfo<QuerySystemDropdownResponse>();
		try {
			responseInfo = systemInfoService.querySystemDropdown();
		} catch (Exception e) {
			logger.error("查询系统信息下拉框选择校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 查询具体系统信息
     * @author wm
     * @create 2018-03-23
     * @return
     */
	@Override
	public BaseResponseInfo<QuerySystemInfoResponse> querySystemInfo(QuerySystemInfoRequest querySystemInfoRequest) {
		SystemManageResponseInfo<QuerySystemInfoResponse> responseInfo = new SystemManageResponseInfo<QuerySystemInfoResponse>();
		try {
			String systemNo = querySystemInfoRequest.getSystemNo();
			SunmnetSystemInfoEntity sunmnetSystemInfoEntity = sunmnetSystemInfoDao.getSystemInfoBySystemNo(systemNo);
			if(sunmnetSystemInfoEntity==null){
				logger.info("查询具体系统信息--系统信息不存在;系统编号："+systemNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_SYSTEM_NO);
				return responseInfo;
			}
			responseInfo = systemInfoService.querySystemInfo(sunmnetSystemInfoEntity);
		} catch (Exception e) {
			logger.error("查询具体系统信息校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 删除系统信息
     * @param deleteSystemInfoRequest
     * @author wm
     * @create 2018-03-30
     * @return
     */
	@Override
	public BaseResponseInfo<Object> deleteSystemInfo(DeleteSystemInfoRequest deleteSystemInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			String systemNo = deleteSystemInfoRequest.getSystemNo();
			//1、判断系统是否存在
			SunmnetSystemInfoEntity sunmnetSystemInfoEntity = sunmnetSystemInfoDao.getSystemInfoBySystemNo(systemNo);
			if(sunmnetSystemInfoEntity==null){
				logger.info("删除系统信息--系统信息不存在;系统编号："+systemNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_SYSTEM_NO);
				return responseInfo;
			}
			//2、判断系统下没有菜单
			List<SunmnetMenuInfoEntity> menuList = sunmnetMenuInfoDao.findMenuInfoBySystemNo(systemNo);
			if(menuList.size()>0){
				logger.info("删除系统信息--系统下有菜单;系统编号："+systemNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.SYSTEM_HAVE_MENU);
				return responseInfo;
			}
			responseInfo = systemInfoService.deleteSystemInfo(systemNo);
		} catch (Exception e) {
			logger.error("删除系统信息校验--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 系统风格图片上传
     * @param uploadTargetStandardFile
     * @author zfb
     * @create 2019-01-21
     */
	@Override
	public BaseResponseInfo<Object> uploadSystemImg(
			UploadSystemImgRequest uploadSystemImgRequest, MultipartFile file) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			String systemNo = uploadSystemImgRequest.getSystemNo();
			
			//1、判断系统是否存在
			SunmnetSystemInfoEntity sunmnetSystemInfoEntity = sunmnetSystemInfoDao.getSystemInfoBySystemNo(systemNo);
			if(sunmnetSystemInfoEntity==null){
				logger.info("系统风格图片上传--系统信息不存在;系统编号："+systemNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_SYSTEM_NO);
				return responseInfo;
			}
			
			//判断文件是否存在
			if (file.isEmpty())
			{
				logger.info("系统风格图片上传--文件不能为空!");
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.SYSTEM_FILE_IS_NULL);
				return responseInfo; 
			}
			
			responseInfo = systemInfoService.uploadSystemImg(uploadSystemImgRequest, file);
		} catch (Exception e) {
			logger.error("系统风格图片上传--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 图片应用修改图片状态
     * @param uploadImgStatus
     * @author zfb
     * @create 2019-01-21
     */
	@Override
	public BaseResponseInfo<Object> uploadImgStatus(
			UploadImgStatusRequest uploadImgStatusRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			String systemNo = uploadImgStatusRequest.getSystemNo();
			SunmnetSystemInfoEntity sunmnetSystemInfoEntity = sunmnetSystemInfoDao.getSystemInfoBySystemNo(systemNo);
			if(sunmnetSystemInfoEntity==null){
				logger.info("图片应用修改图片状态--系统信息不存在;系统编号："+systemNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_SYSTEM_NO);
				return responseInfo;
			}
			
			SunmnetSystemStyleEntity styleEntity = sunmnetSystemStyleDao.queryEntityByRequest(uploadImgStatusRequest);
			if(styleEntity==null){
				logger.info("图片应用修改图片状态--图片信息不存在;文件编号："+uploadImgStatusRequest.getImgNo());
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.IMG_NOT_EXISTS);
				return responseInfo;
			}
			
			responseInfo = systemInfoService.uploadImgStatus(styleEntity);
		
		} catch (Exception e) {
			logger.error("图片应用修改图片状态--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 删除图片
     * @param deleteImg
     * @author zfb
     * @create 2019-01-21
     */
	@Override
	public BaseResponseInfo<Object> deleteImg(DeleteImgRequest deleteImgRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			String systemNo = deleteImgRequest.getSystemNo();
			SunmnetSystemInfoEntity sunmnetSystemInfoEntity = sunmnetSystemInfoDao.getSystemInfoBySystemNo(systemNo);
			if(sunmnetSystemInfoEntity==null){
				logger.info("删除图片--系统信息不存在;系统编号："+systemNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_SYSTEM_NO);
				return responseInfo;
			}
			UploadImgStatusRequest uploadImgStatusRequest = new UploadImgStatusRequest();
			BeanUtils.copyProperties(deleteImgRequest, uploadImgStatusRequest);
			SunmnetSystemStyleEntity styleEntity = sunmnetSystemStyleDao.queryEntityByRequest(uploadImgStatusRequest);
			if(styleEntity==null){
				logger.info("删除图片--图片信息不存在;文件编号："+deleteImgRequest.getImgNo());
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.IMG_NOT_EXISTS);
				return responseInfo;
			}
			
			responseInfo = systemInfoService.deleteImg(styleEntity);
		
		} catch (Exception e) {
			logger.error("删除图片--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 查询系统风格设置列表
     * @param querySystemStyleList
     * @author zfb
     * @create 2019-01-21
     * @return
     */
	@Override
	public BaseResponseInfo<QuerySystemStyleListResponse> querySystemStyleList(
			QuerySystemStyleListRequest querySystemStyleListRequest) {
		SystemManageResponseInfo<QuerySystemStyleListResponse> responseInfo = new SystemManageResponseInfo<QuerySystemStyleListResponse>();
		try {
			String systemNo = querySystemStyleListRequest.getSystemNo();
			SunmnetSystemInfoEntity sunmnetSystemInfoEntity = sunmnetSystemInfoDao.getSystemInfoBySystemNo(systemNo);
			if(sunmnetSystemInfoEntity==null){
				logger.info("查询系统风格设置列表--系统信息不存在;系统编号："+systemNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_SYSTEM_NO);
				return responseInfo;
			}
			responseInfo = systemInfoService.querySystemStyleList(querySystemStyleListRequest);
		} catch (Exception e) {
			logger.error("查询系统风格设置列表--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 设置颜色
     * @param setSystemColor
     * @author zfb
     * @create 2019-01-21
     */
	@Override
	public BaseResponseInfo<Object> setSystemColor(
			SetSystemColorRequest setSystemColorRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			String systemNo = setSystemColorRequest.getSystemNo();
			SunmnetSystemInfoEntity sunmnetSystemInfoEntity = sunmnetSystemInfoDao.getSystemInfoBySystemNo(systemNo);
			if(sunmnetSystemInfoEntity==null){
				logger.info("设置颜色--系统信息不存在;系统编号："+systemNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_SYSTEM_NO);
				return responseInfo;
			}
			
			responseInfo = systemInfoService.setSystemColor(setSystemColorRequest);		
		} catch (Exception e) {
			logger.error("设置颜色--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	/**
     * 查询颜色设置列表
     * @param queryColorSetList
     * @author zfb
     * @create 2019-01-21
     * @return
     */
	@Override
	public BaseResponseInfo<QueryColorSetListResponse> queryColorSetList(
			QueryColorSetListRequest queryColorSetListRequest) {
		SystemManageResponseInfo<QueryColorSetListResponse> responseInfo = new SystemManageResponseInfo<QueryColorSetListResponse>();
		try {
			String systemNo = queryColorSetListRequest.getSystemNo();
			SunmnetSystemInfoEntity sunmnetSystemInfoEntity = sunmnetSystemInfoDao.getSystemInfoBySystemNo(systemNo);
			if(sunmnetSystemInfoEntity==null){
				logger.info("查询颜色设置列表--系统信息不存在;系统编号："+systemNo);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_SYSTEM_NO);
				return responseInfo;
			}
			responseInfo = systemInfoService.queryColorSetList(queryColorSetListRequest);
		} catch (Exception e) {
			logger.error("查询颜色设置列表--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	
	
	
	
}
