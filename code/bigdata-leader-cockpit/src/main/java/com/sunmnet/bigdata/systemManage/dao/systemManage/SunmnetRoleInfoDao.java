package com.sunmnet.bigdata.systemManage.dao.systemManage;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetRoleInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryRoleDropdownModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRoleInfoPageRequest;

public interface SunmnetRoleInfoDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(SunmnetRoleInfoEntity record);

    public SunmnetRoleInfoEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(SunmnetRoleInfoEntity record);
	/**
     * 根据角色编号查询角色信息
     * @param roleNo
     * @author wm
     * @create 2018-04-07
     * @return
     */
	public SunmnetRoleInfoEntity getRoleInfoByRoleNo(String roleNo);
	/**
     * 根据角色编号修改角色名称和角色描述
     * @param modifyRoleInfoRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	public int updateRoleInfoByRoleNo(SunmnetRoleInfoEntity sunmnetRoleInfoEntity);
	/**
     * 分页查询角色信息列表
     * @param queryReleInfoPageRequest
     * @author wm
     * @create 2018-04-07
     * @return
     */
	public List<SunmnetRoleInfoEntity> findRoleInfo(QueryRoleInfoPageRequest queryReleInfoPageRequest);

	/**
     * 查询角色信息列表下拉框
     * @param queryRoleDropdown
     * @author zfb
     * @create 2018-04-11
     * @return
     */
	public List<QueryRoleDropdownModel> queryRoleDropdown();

}