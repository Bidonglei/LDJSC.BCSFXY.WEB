package com.sunmnet.bigdata.systemManage.dao.systemManage;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetRoleMenuInfoEntity;

public interface SunmnetRoleMenuInfoDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(SunmnetRoleMenuInfoEntity record);

    public SunmnetRoleMenuInfoEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(SunmnetRoleMenuInfoEntity record);
    /**
     * 根据菜单编号查询菜单授权给角色的数
     * @param menuNo
     * @author wm
     * @create 2018-04-08
     * @return
     */
	public long getRoleMenuCountByMenuNo(String menuNo);
	/**
     * 根据角色编号查询角色拥有的菜单、功能点编号集合
     * @param menuNo
     * @author wm
     * @create 2018-04-08
     * @return
     */
	public List<String> getRoleMenuCountByRoleNo(String roleNo);
	/**
     * 根据角色编号删除原有的已经授权了菜单功能点
     * @param roleNo
     * @author wm
     * @create 2018-04-08
     * @return
     */
	public long deleteRoleMenuInfoByRoleNo(String roleNo);

}