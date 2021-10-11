package com.sunmnet.bigdata.systemManage.biz.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemDictInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.SystemManageResultEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddDictInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.DeleteDictInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryDictInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryDictPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.UpdateDictInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryDictInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;
import com.sunmnet.bigdata.systemManage.biz.DictInfoBiz;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetSystemDictInfoDao;
import com.sunmnet.bigdata.systemManage.service.DictInfoService;

/**
 * 字典管理
 * @author fr
 * @create 2018-09-17
 */
@Service
public class DictInfoBizImpl implements DictInfoBiz {
	
	private Logger logger = LoggerFactory.getLogger(DictInfoBizImpl.class);
	@Autowired
	private SunmnetSystemDictInfoDao sunmnetSystemDictInfoDao;

	
	@Autowired
	private DictInfoService dictInfoService;

	/**
     * 分页查询数据字典列表
     * @param queryDictPageRequest
     * @author zfb
     * @create 2018-09-17
     * @return
     */	
	@Override
	public BaseResponseInfo<PageResult> queryDictPageRequest(
			QueryDictPageRequest queryDictPageRequest) {
		SystemManageResponseInfo<PageResult> responseInfo = new SystemManageResponseInfo<PageResult>();
		try {
		    responseInfo = dictInfoService.queryDictPageRequest(queryDictPageRequest);
		} catch (Exception e) {
			logger.error("分页查询数据字典列表--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 新增字典
     * @param 
     * @author fr
     * @create 2018-09-17
     * @return
     */
	@Override
	public BaseResponseInfo<Object> addDictInfo(
			AddDictInfoRequest addDictInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			//1、查询字典标识号是否存在
			String dictType = addDictInfoRequest.getDictType();
			List<SunmnetSystemDictInfoEntity> queryDataDictionaryInfo = sunmnetSystemDictInfoDao.queryDataDictionaryInfo(dictType);
			if( queryDataDictionaryInfo.size() > 0){
				logger.info("数据字典标识号已经存在，数据字典标识为："+dictType);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.DICTTYPE_EXIST);
				return responseInfo;
			}
			responseInfo = dictInfoService.addDictInfo(addDictInfoRequest);
		} catch (Exception e) {
			logger.error("添加字典--异常", e);
			if(SystemManageResultEnum.DICTIONARIES_KEY_EXIST.getCode().equals(e.getMessage())){
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.DICTIONARIES_KEY_EXIST);
				throw  e;
			}else{
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
			}
		}
		return responseInfo;
	}

	/**
     * 修改字典
     * @param 
     * @author fr
     * @create 2018-09-17
     * @return
     */
	@Override
	public BaseResponseInfo<Object> updateDictInfo(
			UpdateDictInfoRequest updateDictInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			//1、查询数据字典标识号是否存在
			String dictType = updateDictInfoRequest.getDictType();
			List<SunmnetSystemDictInfoEntity> queryDataDictionaryInfo = sunmnetSystemDictInfoDao.queryDataDictionaryInfo(dictType);
			if( queryDataDictionaryInfo.size()==0){
				logger.info("修改的数据字典标识号不存在，数据字典标识为："+dictType);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_DICTTYPE);
				return responseInfo;
			}
			responseInfo = dictInfoService.updateDictInfo(updateDictInfoRequest);
		} catch (Exception e) {
			logger.error("修改数据字典--异常", e);
			if(SystemManageResultEnum.DICTIONARIES_KEY_EXIST.getCode().equals(e.getMessage())){
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.DICTIONARIES_KEY_EXIST);
				throw e;
			}else{
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
			}
		}
		return responseInfo;
	}
	/**
     * 删除字典信息
     * @param 
     * @author fr
     * @create 2018-09-17
     * @return
     */
	@Override
	public BaseResponseInfo<Object> deleteDictInfo(
			DeleteDictInfoRequest deleteDictInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			//1、查询数据字典标识号是否存在
			String dictType = deleteDictInfoRequest.getDictType();
			List<SunmnetSystemDictInfoEntity> queryDataDictionaryInfo = sunmnetSystemDictInfoDao.queryDataDictionaryInfo(dictType);
			if( queryDataDictionaryInfo.size()==0){
				logger.info("删除数据字典标识号不存在，数据字典标识为："+dictType);
				responseInfo.setSystemManageResponseInfo(SystemManageResultEnum.NO_DICTTYPE);
				return responseInfo;
			}
			responseInfo = dictInfoService.deleteDictInfo(deleteDictInfoRequest);
		} catch (Exception e) {
			logger.error("根据字典标识删除数据字典--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
	/**
     * 查看字典详情
     * @param 
     * @author fr
     * @create 2018-09-17
     * @return
     */
	@Override
	public BaseResponseInfo<QueryDictInfoResponse> queryDictInfo(
			QueryDictInfoRequest queryDictInfoRequest) {
		SystemManageResponseInfo<QueryDictInfoResponse> responseInfo = new SystemManageResponseInfo<QueryDictInfoResponse>();
		try {
			responseInfo = dictInfoService.queryDictInfo(queryDictInfoRequest);
		
		} catch (Exception e) {
			logger.error("查看字典详情-异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
}
