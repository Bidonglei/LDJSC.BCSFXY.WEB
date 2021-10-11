package com.sunmnet.bigdata.systemManage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sunmnet.bigdata.systemManage.dao.systemManage.PageDataSourceDao;
import com.sunmnet.bigdata.systemManage.base.support.request.PageDataSourceREQ;
import com.sunmnet.bigdata.web.model.request.home.OpinionInfoREQ;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunmnet.bigdata.systemManage.base.support.beanUtil.BeanUtils;
import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.support.util.DateUtil;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemDictInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.enums.SystemManageResultEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.DictKeyValueModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryDictPageModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddDictInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.DeleteDictInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryDictInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryDictPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.UpdateDictInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryDictInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetSystemDictInfoDao;
import com.sunmnet.bigdata.systemManage.service.DictInfoService;

/**
 * 字典管理
 * @author fr
 * @create 2018-09-17
 */
@Service
public class DictInfoServiceImpl implements DictInfoService {
	
	private Logger logger = LoggerFactory.getLogger(DictInfoServiceImpl.class);
	
	@Autowired
	private SunmnetSystemDictInfoDao sunmnetSystemDictInfoDao;

	@Autowired
	private PageDataSourceDao pageDataSourceDao;

	/**
     * 分页查询数据字典列表
     * @param queryDictPageRequest
     * @author zfb
     * @create 2018-09-17
     * @return
     */	
	@Override
	public SystemManageResponseInfo<PageResult> queryDictPageRequest(
			QueryDictPageRequest queryDictPageRequest) {
		SystemManageResponseInfo<PageResult> responseInfo = new SystemManageResponseInfo<PageResult>();
		try {
			int pageNum = queryDictPageRequest.getPageNum(); //  当前页
			int pageSize = queryDictPageRequest.getPageSize();//  每页显示的记录数量
			PageHelper.startPage(pageNum, pageSize);
			List<SunmnetSystemDictInfoEntity> list = sunmnetSystemDictInfoDao.queryDictPageRequest(queryDictPageRequest);
			Page<SunmnetSystemDictInfoEntity> count = (Page<SunmnetSystemDictInfoEntity>)list;
			List<QueryDictPageModel> listData = new ArrayList<QueryDictPageModel>(); 
			for(SunmnetSystemDictInfoEntity sunmnetSystemDictInfoEntity : list){
				QueryDictPageModel model = new QueryDictPageModel();
				BeanUtils.copyProperties(sunmnetSystemDictInfoEntity, model);
				listData.add(model);
			}			
			PageResult pageResult = new PageResult(listData, count.getTotal(), pageNum, pageSize);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,pageResult);
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
	public SystemManageResponseInfo<Object> addDictInfo(
			AddDictInfoRequest addDictInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			String dictType = addDictInfoRequest.getDictType();
			String dictName = addDictInfoRequest.getDictName();
			String keyValueStr = addDictInfoRequest.getKeyValueStr();
			String[] split = keyValueStr.split(",");
			for (String s : split) {
				String[] keyValue = s.split(":");
				String key = keyValue[0];
				String value = keyValue[1];
				//按照字典标识和数据字典key值查询数据库有没有此key
				Map<String,String> map = new HashMap<String, String>();
				map.put("dictType", dictType);
				map.put("dictkey", key);
				List<SunmnetSystemDictInfoEntity> keyEntity = sunmnetSystemDictInfoDao.queryDataDictKey(map);
				if(keyEntity!=null && keyEntity.size()>0){
					logger.info("添加数据字典,该key重复--保存信息失败;详情："+"字典标识："+dictType+"字典key："+key);
					throw new RuntimeException(SystemManageResultEnum.DICTIONARIES_KEY_EXIST.getCode());
				}
				SunmnetSystemDictInfoEntity entity = new SunmnetSystemDictInfoEntity();
				entity.setDictType(dictType);
				entity.setDictName(dictName);
				if(StringUtils.isNotBlank(addDictInfoRequest.getDictDescribe())){
					entity.setDictDescribe(addDictInfoRequest.getDictDescribe());
				}
				entity.setDictKey(key);
				entity.setDictValue(value);
				entity.setCreateTime(DateUtil.getTimeDate());//创建时间  格式：YYYYMMDDHHmmssSSS
				int count = sunmnetSystemDictInfoDao.insertSelective(entity);
				if(count!=1){
					logger.info("添加字典--保存信息失败;详情："+entity.toString());
					responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
					return responseInfo;
				}
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		} catch (Exception e) {
			logger.error("添加字典--异常", e);
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
     * 修改字典
     * @param 
     * @author fr
     * @create 2018-09-17
     * @return
     */
	@Override
	public SystemManageResponseInfo<Object> updateDictInfo(
			UpdateDictInfoRequest updateDictInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			String dictType = updateDictInfoRequest.getDictType();
			String dictName = updateDictInfoRequest.getDictName();
			String keyValueStr = updateDictInfoRequest.getKeyValueStr();
			String createTime = null;
			List<SunmnetSystemDictInfoEntity> queryDataDictionaryInfo = sunmnetSystemDictInfoDao.queryDataDictionaryInfo(dictType);
			for (SunmnetSystemDictInfoEntity entity : queryDataDictionaryInfo) {
				createTime = entity.getCreateTime();
				break;
			}
			//先删除后修改
			int count = sunmnetSystemDictInfoDao.deleteDataDictionaryByDictType(dictType);
			if(count < 1){
				logger.info("删除字典失败;详情："+dictType);
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
			}
			String[] split = keyValueStr.split(",");
			for (String s : split) {
				String[] keyValue = s.split(":");
				String key = keyValue[0];
				String value = keyValue[1];
				//按照字典标识和数据字典key值查询数据库有没有此key
				Map<String,String> map = new HashMap<String, String>();
				map.put("dictType", dictType);
				map.put("dictkey", key);
				List<SunmnetSystemDictInfoEntity> keyEntity = sunmnetSystemDictInfoDao.queryDataDictKey(map);
				if(keyEntity!=null && keyEntity.size()>0){
					logger.info("修改数据字典,该key重复--保存信息失败;详情："+"字典标识："+dictType+"字典key："+key);
					throw new RuntimeException(SystemManageResultEnum.DICTIONARIES_KEY_EXIST.getCode());
				}
				SunmnetSystemDictInfoEntity entity = new SunmnetSystemDictInfoEntity();
				entity.setDictType(dictType);
				entity.setDictName(dictName);
				if(StringUtils.isNotBlank(updateDictInfoRequest.getDictDescribe())){
					entity.setDictDescribe(updateDictInfoRequest.getDictDescribe());
				}
				entity.setDictKey(key);
				entity.setDictValue(value);
				entity.setCreateTime(createTime);//创建时间  格式：YYYYMMDDHHmmss
				int count1 = sunmnetSystemDictInfoDao.insertSelective(entity);
				if(count1!=1){
					logger.info("修改字典--修改信息失败;详情："+entity.toString());
					responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
					return responseInfo;
				}
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
		}catch (Exception e) {
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
	public SystemManageResponseInfo<Object> deleteDictInfo(
			DeleteDictInfoRequest deleteDictInfoRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			String dictType = deleteDictInfoRequest.getDictType();
			int count = sunmnetSystemDictInfoDao.deleteDataDictionaryByDictType(dictType);
			if(count < 1){
				logger.info("删除数据字典失败;详情："+dictType);
				responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
				return responseInfo;
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS);
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
	public SystemManageResponseInfo<QueryDictInfoResponse> queryDictInfo(
			QueryDictInfoRequest queryDictInfoRequest) {
		SystemManageResponseInfo<QueryDictInfoResponse> responseInfo = new SystemManageResponseInfo<QueryDictInfoResponse>();
		try {
			String dictType = queryDictInfoRequest.getDictType();
			QueryDictInfoResponse response = new QueryDictInfoResponse();
			List<DictKeyValueModel> resultlist = new ArrayList<DictKeyValueModel>();
			List<SunmnetSystemDictInfoEntity> list = sunmnetSystemDictInfoDao.queryDataDictionaryInfo(dictType);
			for (SunmnetSystemDictInfoEntity entity : list) {
				if(response.getDictType()==null){
					response.setDictType(entity.getDictType());
				}
				if(response.getDictName()==null){
					response.setDictName(entity.getDictName());
				}
				if(response.getDictDescribe()==null){
					response.setDictDescribe(entity.getDictDescribe());
				}
				DictKeyValueModel model = new DictKeyValueModel();
				model.setDictKey(entity.getDictKey());
				model.setDictValue(entity.getDictValue());
				resultlist.add(model);
			}
			response.setList(resultlist);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,response);
		} catch (Exception e) {
			logger.error("根据字典标识查询数据字典详情--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	@Override
	public int savePageDataSource(OpinionInfoREQ req) {
		if(StringUtils.isBlank(req.getOpinionContent())){
			return 0;
		}
		PageDataSourceREQ request = new PageDataSourceREQ();
		String[] location = req.getOpinionLocation().split("/");
		String[] content = req.getOpinionContent().split("/");
		request.setPageName(location[2]);
		request.setChartName(content[0]);
		request.setDataType(content[1]);
		request.setDataSynchronize(content[4]);
		request.setDataStatus(content[3]);
		request.setDataQuestion(content[2]);
		request.setDataSort(pageDataSourceDao.getDataSortByName(request));
		return pageDataSourceDao.savePageDataSource(request);
	}
}
