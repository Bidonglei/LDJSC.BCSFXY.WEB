package com.sunmnet.bigdata.systemManage.dao.systemManage;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QuerySystemDropdownModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QuerySystemInfoPageRequest;

public interface SunmnetSystemInfoDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(SunmnetSystemInfoEntity record);

    public SunmnetSystemInfoEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(SunmnetSystemInfoEntity record);
    /**
     * 根据系统编号查询系统信息
     * @param systemNo
     * @author wm
     * @create 2018-03-21
     * @return
     */
	public SunmnetSystemInfoEntity getSystemInfoBySystemNo(String systemNo);
	/**
     * 查询系统信息
     * @author wm
     * @create 2018-03-21
     * @return
     */
	public List<SunmnetSystemInfoEntity> findSystemInfo(QuerySystemInfoPageRequest queryUserInfoPageRequest);
	/**
     * 查询系统信息下拉框选择
     * @author wm
     * @create 2018-03-23
     * @return
     */
	public List<QuerySystemDropdownModel> findSystemInfoDropdown();
	/**
     * 根据系统编号删除系统信息
     * @param systemNo
     * @author wm
     * @create 2018-03-30
     * @return
     */
	public int deleteSystemInfoBySystemNo(String systemNo);
	/**
     * 查询所有系统信息
     * @author wm
     * @create 2018-04-08
     * @return
     */
	public List<SunmnetSystemInfoEntity> findSystemInfoAll(String systemNo);
}