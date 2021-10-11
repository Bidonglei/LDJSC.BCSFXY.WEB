package com.sunmnet.bigdata.systemManage.dao.systemManage;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemAdminMenuInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.AdminMenuInfoRoleModel;

public interface SunmnetSystemAdminMenuInfoDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(SunmnetSystemAdminMenuInfoEntity record);

    public SunmnetSystemAdminMenuInfoEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(SunmnetSystemAdminMenuInfoEntity record);
    /**
     * 根据管理员编号查询管理员授权的菜单
     * @param adminNo
     * @author wm
     * @create 2018-04-04
     * @return
     */
	public List<SunmnetSystemAdminMenuInfoEntity> findSystemAdminMenuInfoByAdminNo(String adminNo);
	/**
     * 根据管理员编号删除管理员菜单权限
     * @param adminNo
     * @author wm
     * @create 2018-04-07
     * @return
     */
	public int deleteAdminMenuByAdminNo(String adminNo);
	 /**
     * 根据管理员编号查询管理员授权的菜单Url
     * @param adminNo
     * @author wm
     * @create 2018-04-09
     * @return
     */
	public List<AdminMenuInfoRoleModel> findSystemAdminMenuUrlByAdminNo(String adminNo);

}