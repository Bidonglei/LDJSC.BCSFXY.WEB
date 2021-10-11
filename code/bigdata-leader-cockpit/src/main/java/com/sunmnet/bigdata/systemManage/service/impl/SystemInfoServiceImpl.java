package com.sunmnet.bigdata.systemManage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunmnet.bigdata.systemManage.base.support.beanUtil.BeanUtils;
import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.support.util.DateUtil;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemColorEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemStyleEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.SystemStatusEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryColorSetListModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QuerySystemDropdownModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QuerySystemPageModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QuerySystemStyleListModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.SystemImgModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddSystemInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.ModifySystemInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryColorSetListRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QuerySystemInfoPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QuerySystemStyleListRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.SetSystemColorRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.UploadSystemImgRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryColorSetListResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QuerySystemDropdownResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QuerySystemInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QuerySystemStyleListResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;
import com.sunmnet.bigdata.systemManage.common.fastdfs.FastDFSClientWrapper;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetSystemColorDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetSystemInfoDao;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetSystemStyleDao;
import com.sunmnet.bigdata.systemManage.service.SystemInfoService;
import com.sunmnet.bigdata.systemManage.util.SequenceUtil;
import com.sunmnet.bigdata.systemManage.util.SystemManageConstants;

/**
 * 系统信息
 * @author wm
 * @create 2018-03-21
 */
@Service
public class SystemInfoServiceImpl implements SystemInfoService {
	
	private Logger logger = LoggerFactory.getLogger(SystemInfoServiceImpl.class);
	@Autowired
	private SunmnetSystemInfoDao sunmnetSystemInfoDao;
	@Autowired
	private FastDFSClientWrapper fastDFSClientWrapper;
	@Autowired
	private SunmnetSystemStyleDao sunmnetSystemStyleDao;
	@Autowired
	private SunmnetSystemColorDao sunmnetSystemColorDao;
	
	
	
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
			SunmnetSystemInfoEntity sunmnetSystemInfoEntity = new SunmnetSystemInfoEntity();
			sunmnetSystemInfoEntity.setSystemNo(addSystemInfoRequest.getSystemNo());//系统编号  唯一标识
			sunmnetSystemInfoEntity.setSystemName(addSystemInfoRequest.getSystemName()); //系统名称
		    sunmnetSystemInfoEntity.setSystemStatus(SystemStatusEnum.NORMAL);//系统状态    正常 NORMAL,  锁定 LOCK
		    sunmnetSystemInfoEntity.setSystemDescribe(addSystemInfoRequest.getSystemDescribe());//系统描述
		    sunmnetSystemInfoEntity.setIsWarn(addSystemInfoRequest.getIsWarn());
		    sunmnetSystemInfoEntity.setSystemUrl(addSystemInfoRequest.getSystemUrl());//系统url
		    sunmnetSystemInfoEntity.setCreateTime(DateUtil.getDateAndTimes());//创建时间  格式：YYYYMMDDHHmmssSSS
			int count = sunmnetSystemInfoDao.insertSelective(sunmnetSystemInfoEntity);
			if(count!=1){
				logger.info("新增系统--保存信息失败;详情："+sunmnetSystemInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("新增系统--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 修改系统信息
     * @param modifySystemInfoRequest
     * @param sunmnetSystemInfoEntity
     * @author wm
     * @create 2018-03-21
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> modify(ModifySystemInfoRequest modifySystemInfoRequest,
			SunmnetSystemInfoEntity sunmnetSystemInfoEntity) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			sunmnetSystemInfoEntity.setSystemName(modifySystemInfoRequest.getSystemName()); //系统名称
		    sunmnetSystemInfoEntity.setSystemStatus(modifySystemInfoRequest.getSystemStatus());//系统状态    正常 NORMAL,  锁定 LOCK
		    sunmnetSystemInfoEntity.setSystemDescribe(modifySystemInfoRequest.getSystemDescribe());//系统描述
		    sunmnetSystemInfoEntity.setSystemUrl(modifySystemInfoRequest.getSystemUrl());
		    sunmnetSystemInfoEntity.setIsWarn(modifySystemInfoRequest.getIsWarn());
		    sunmnetSystemInfoEntity.setLastModifyTime(DateUtil.getDateAndTimes());//最后修改时间  格式：YYYYMMDDHHmmssSSS
			int count = sunmnetSystemInfoDao.updateByPrimaryKeySelective(sunmnetSystemInfoEntity);
			if(count!=1){
				logger.info("修改系统信息--修改信息失败;详情："+sunmnetSystemInfoEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("修改系统信息--异常", e);
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
	public SystemManageResponseInfo<PageResult> query(QuerySystemInfoPageRequest queryUserInfoPageRequest) {
		SystemManageResponseInfo<PageResult> responseInfo = new SystemManageResponseInfo<PageResult>();		
		try {
			int pageNum = queryUserInfoPageRequest.getPageNum(); //  当前页
			int pageSize = queryUserInfoPageRequest.getPageSize();//  每页显示的记录数量
			PageHelper.startPage(pageNum, pageSize);
			List<SunmnetSystemInfoEntity> list = sunmnetSystemInfoDao.findSystemInfo(queryUserInfoPageRequest);
			Page<SunmnetSystemInfoEntity> count = (Page<SunmnetSystemInfoEntity>)list;
			List<QuerySystemPageModel> listData = new ArrayList<QuerySystemPageModel>(); 
			for(SunmnetSystemInfoEntity sunmnetSystemInfoEntity : list){
				QuerySystemPageModel querySystemPageModel = new QuerySystemPageModel();
				querySystemPageModel.setSystemNo(sunmnetSystemInfoEntity.getSystemNo());//系统编号  唯一标识
				querySystemPageModel.setSystemName(sunmnetSystemInfoEntity.getSystemName());
				querySystemPageModel.setSystemStatus(sunmnetSystemInfoEntity.getSystemStatus());//系统状态    正常 NORMAL,  锁定 LOCK
				querySystemPageModel.setSystemStatusStr(sunmnetSystemInfoEntity.getSystemStatus().getMsg());//系统状态    正常 NORMAL,  锁定 LOCK
				querySystemPageModel.setIsWarn(sunmnetSystemInfoEntity.getIsWarn());
				querySystemPageModel.setIsWarnStr(sunmnetSystemInfoEntity.getIsWarn().getMsg());
				querySystemPageModel.setSystemDescribe(sunmnetSystemInfoEntity.getSystemDescribe());//系统描述
				querySystemPageModel.setSystemUrl(sunmnetSystemInfoEntity.getSystemUrl());
				String createTime = sunmnetSystemInfoEntity.getCreateTime();
				if(!("").equals(createTime)&&createTime!=null){
					querySystemPageModel.setCreateTime(DateUtil.formartStringDate(DateUtil.dateandtime,DateUtil.simple,createTime));//创建时间  格式：YYYYMMDDHHmmssSSS
				}
				String lastModifyTime = sunmnetSystemInfoEntity.getLastModifyTime();
				if(!("").equals(lastModifyTime)&&lastModifyTime!=null){
					querySystemPageModel.setLastModifyTime(DateUtil.formartStringDate(DateUtil.dateandtime,DateUtil.simple,lastModifyTime));//最后修改时间  格式：YYYYMMDDHHmmssSSS
				}
				listData.add(querySystemPageModel);
			}
			
			PageResult pageResult = new PageResult(listData, count.getTotal(), pageNum, pageSize);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,pageResult);
		} catch (Exception e) {
			logger.error("分页查询系统信息--异常", e);
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
	public SystemManageResponseInfo<QuerySystemDropdownResponse> querySystemDropdown() {
		SystemManageResponseInfo<QuerySystemDropdownResponse> responseInfo = new SystemManageResponseInfo<QuerySystemDropdownResponse>();		
		try {
			List<QuerySystemDropdownModel> list = sunmnetSystemInfoDao.findSystemInfoDropdown();
			QuerySystemDropdownResponse querySystemDropdownResponse = new QuerySystemDropdownResponse();
			querySystemDropdownResponse.setList(list);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,querySystemDropdownResponse);
		} catch (Exception e) {
			logger.error("查询系统信息下拉框选择--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 查询具体系统信息
     * @param sunmnetSystemInfoEntity
     * @author wm
     * @create 2018-03-23
     * @return
     */
	@Override
	public SystemManageResponseInfo<QuerySystemInfoResponse> querySystemInfo(SunmnetSystemInfoEntity sunmnetSystemInfoEntity) {
		SystemManageResponseInfo<QuerySystemInfoResponse> responseInfo = new SystemManageResponseInfo<QuerySystemInfoResponse>();		
		try {
			QuerySystemInfoResponse querySystemInfoModel = new QuerySystemInfoResponse();
			querySystemInfoModel.setSystemNo(sunmnetSystemInfoEntity.getSystemNo());//系统编号
			querySystemInfoModel.setSystemName(sunmnetSystemInfoEntity.getSystemName());//系统名称
			querySystemInfoModel.setSystemStatus(sunmnetSystemInfoEntity.getSystemStatus());//系统状态    正常 NORMAL,  锁定 LOCK
			querySystemInfoModel.setSystemStatusStr(sunmnetSystemInfoEntity.getSystemStatus().getMsg());//系统状态    正常 NORMAL,  锁定 LOCK
			querySystemInfoModel.setSystemDescribe(sunmnetSystemInfoEntity.getSystemDescribe());  //系统描述
			querySystemInfoModel.setSystemUrl(sunmnetSystemInfoEntity.getSystemUrl());
			querySystemInfoModel.setIsWarn(sunmnetSystemInfoEntity.getIsWarn());
			querySystemInfoModel.setIsWarnStr(sunmnetSystemInfoEntity.getIsWarn().getMsg());
			String createTime = sunmnetSystemInfoEntity.getCreateTime();
			if(!("").equals(createTime)&&createTime!=null){
				querySystemInfoModel.setCreateTime(DateUtil.formartStringDate(DateUtil.dateandtime,DateUtil.simple,createTime));//创建时间  格式：YYYYMMDDHHmmssSSS
			}
			String lastModifyTime = sunmnetSystemInfoEntity.getLastModifyTime();
			if(!("").equals(lastModifyTime)&&lastModifyTime!=null){
				querySystemInfoModel.setLastModifyTime(DateUtil.formartStringDate(DateUtil.dateandtime,DateUtil.simple,lastModifyTime));//最后修改时间  格式：YYYYMMDDHHmmssSSS
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,querySystemInfoModel);
		} catch (Exception e) {
			logger.error("查询具体系统信息--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	
	/**
     * 删除系统信息
     * @param systemNo
     * @author wm
     * @create 2018-03-30
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> deleteSystemInfo(String systemNo) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			int count = sunmnetSystemInfoDao.deleteSystemInfoBySystemNo(systemNo);
			if(count!=1){
				logger.info("删除系统信息--删除信息失败;系统编号："+systemNo);
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("删除系统信息--异常", e);
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
	public SystemManageResponseInfo<Object> uploadSystemImg(
			UploadSystemImgRequest uploadSystemImgRequest, MultipartFile file) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {			
			byte[] bytes = file.getBytes();
			String imgName = file.getOriginalFilename();
			String fileType = imgName.substring(imgName.lastIndexOf("."),imgName.length());
			
			
			String imgUrl = fastDFSClientWrapper.uploadFile(bytes, bytes.length,fileType);
			SunmnetSystemStyleEntity sunmnetSystemStyleEntity = new SunmnetSystemStyleEntity();
			BeanUtils.copyProperties(uploadSystemImgRequest, sunmnetSystemStyleEntity);
			sunmnetSystemStyleEntity.setImgName(imgName);
			sunmnetSystemStyleEntity.setImgNo(SequenceUtil.getImgNo());
			sunmnetSystemStyleEntity.setImgUrl(imgUrl);
			String nowTime = DateUtil.getTimeDate();
			sunmnetSystemStyleEntity.setCreateTime(nowTime);
			sunmnetSystemStyleEntity.setApplyStatus("WYY");
			sunmnetSystemStyleEntity.setFileStatus("NORMAL");
			
			int count = sunmnetSystemStyleDao.insertSelective(sunmnetSystemStyleEntity);
			if(count!=1){
				logger.info("系统风格图片上传--系统风格图片上传失败;详情："+sunmnetSystemStyleEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;	
			}
			
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
			
		}catch (Exception e) {
			logger.error("uploadTargetStandardFileRequest--异常", e);
			throw new RuntimeException();
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
	public SystemManageResponseInfo<Object> uploadImgStatus(
			SunmnetSystemStyleEntity styleEntity) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			//先把当前系统该位置的所有图片都设置为未应用
			int count = sunmnetSystemStyleDao.updateApplyStatus(styleEntity);
			if(count<0){
				logger.info("图片应用修改图片状态--图片应用修改所有图片为未应用失败;详情："+styleEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			
			styleEntity.setApplyStatus("YYY");
		    styleEntity.setLastModifyTime(DateUtil.getDateAndTimes());//最后修改时间  格式：YYYYMMDDHHmmssSSS
			int count1 = sunmnetSystemStyleDao.updateByPrimaryKeySelective(styleEntity);
			if(count1!=1){
				logger.info("图片应用修改图片状态--图片应用修改图片状态失败;详情："+styleEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
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
	public SystemManageResponseInfo<Object> deleteImg(
			SunmnetSystemStyleEntity styleEntity) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			styleEntity.setFileStatus("DELETE");
		    styleEntity.setLastModifyTime(DateUtil.getDateAndTimes());//最后修改时间  格式：YYYYMMDDHHmmssSSS
			int count = sunmnetSystemStyleDao.updateByPrimaryKeySelective(styleEntity);
			if(count!=1){
				logger.info("删除图片--删除图片失败;详情："+styleEntity.toString());
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
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
	public SystemManageResponseInfo<QuerySystemStyleListResponse> querySystemStyleList(
			QuerySystemStyleListRequest querySystemStyleListRequest) {
		SystemManageResponseInfo<QuerySystemStyleListResponse> responseInfo = new SystemManageResponseInfo<QuerySystemStyleListResponse>();		
		try {
			QuerySystemStyleListResponse querySystemStyleListResponse = new QuerySystemStyleListResponse();
			List<QuerySystemStyleListModel> modelList = new ArrayList<QuerySystemStyleListModel>();
			modelList = sunmnetSystemStyleDao.querySystemStyleType(querySystemStyleListRequest);
			List<SystemImgModel> allList = new ArrayList<SystemImgModel>();
			allList = sunmnetSystemStyleDao.querySystemStyleList(querySystemStyleListRequest);
			
			for(SystemImgModel allModel : allList)
			{
				allModel.setImgUrl(SystemManageConstants.FASTDFS_AGENT_URL+allModel.getImgUrl());
							}
			for(QuerySystemStyleListModel model : modelList)
			{
				List<SystemImgModel> imgList  = new ArrayList<SystemImgModel>();
				for(SystemImgModel allModel : allList)
				{
					if(allModel.getSetPosition().equals(model.getSetPosition()))
					{
						imgList.add(allModel);
					}
				}
				model.setList(imgList);
			}
			querySystemStyleListResponse.setList(modelList);
			
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,querySystemStyleListResponse);
		} catch (Exception e) {
			logger.error("查查询系统风格设置列表--异常", e);
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
	public SystemManageResponseInfo<Object> setSystemColor(
			SetSystemColorRequest setSystemColorRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();		
		try {
			SunmnetSystemColorEntity  entity = sunmnetSystemColorDao.querySunmnetSystemColor(setSystemColorRequest);
			if(null == entity)
			{
				entity = new SunmnetSystemColorEntity();
				BeanUtils.copyProperties(setSystemColorRequest, entity);
				entity.setCreateTime(DateUtil.getDateAndTimes());
				int count = sunmnetSystemColorDao.insertSelective(entity);
				if(count!=1){
					logger.info("设置颜色--新增信息失败;详情："+entity.toString());
					responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
					return responseInfo;
				}
			}
			else
			{
				entity.setColorName(setSystemColorRequest.getColorName());
				int updateCount = sunmnetSystemColorDao.updateByPrimaryKeySelective(entity);
				if(updateCount!=1){
					logger.info("设置颜色--设置颜色失败;详情："+entity.toString());
					responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
					return responseInfo;
				}
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
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
	public SystemManageResponseInfo<QueryColorSetListResponse> queryColorSetList(
			QueryColorSetListRequest queryColorSetListRequest) {
		SystemManageResponseInfo<QueryColorSetListResponse> responseInfo = new SystemManageResponseInfo<QueryColorSetListResponse>();		
		try {
			QueryColorSetListResponse queryColorSetListResponse = new QueryColorSetListResponse();
			List<QueryColorSetListModel> modelList = new ArrayList<QueryColorSetListModel>();
			modelList = sunmnetSystemColorDao.queryColorSetList(queryColorSetListRequest);
			
			queryColorSetListResponse.setList(modelList);
			
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,queryColorSetListResponse);
		} catch (Exception e) {
			logger.error("查询颜色设置列表--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	
}
