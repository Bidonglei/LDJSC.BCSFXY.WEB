package com.sunmnet.bigdata.systemManage.dao.systemManage;

import java.util.List;
import java.util.Map;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemDictInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryDictDropDownModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryDictDropDownRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryDictPageRequest;

public interface SunmnetSystemDictInfoDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(SunmnetSystemDictInfoEntity record);

    public SunmnetSystemDictInfoEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(SunmnetSystemDictInfoEntity record);

    /**
     * 查询数据字典下拉框
     * @author zfb
     * @create 2018-09-17
     */
	public List<QueryDictDropDownModel> queryDictDrpDown(QueryDictDropDownRequest queryDictDropDownRequest);

	/**
     * 分页查询数据字典列表
     * @param queryDictPageRequest
     * @author zfb
     * @create 2018-09-17
     * @return
     */	
	public List<SunmnetSystemDictInfoEntity> queryDictPageRequest(
			QueryDictPageRequest queryDictPageRequest);
	/**
     * 新增字典
     * @param 
     * @author fr
     * @create 2018-09-17
     * @return
     */
	public List<SunmnetSystemDictInfoEntity> queryDataDictionaryInfo(
			String dictType);
	/**
     * 按照字典标识和数据字典key值查询
     * @param 
     * @author fr
     * @create 2018-09-17
     * @return
     */
	public List<SunmnetSystemDictInfoEntity> queryDataDictKey(
			Map<String, String> map);
	/**
     * 按照字典标识删除字典
     * @param 
     * @author fr
     * @create 2018-09-17
     * @return
     */
	public int deleteDataDictionaryByDictType(String dictType);

}