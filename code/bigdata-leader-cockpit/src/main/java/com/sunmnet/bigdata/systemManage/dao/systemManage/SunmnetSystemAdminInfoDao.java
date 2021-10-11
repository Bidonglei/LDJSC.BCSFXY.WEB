package com.sunmnet.bigdata.systemManage.dao.systemManage;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemAdminInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QuerySystemAdminInfoPageRequest;

public interface SunmnetSystemAdminInfoDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(SunmnetSystemAdminInfoEntity record);

    public SunmnetSystemAdminInfoEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(SunmnetSystemAdminInfoEntity record);
    /**
     * 根据管理员手机号查询管理员信息
     * @param adminMobile
     * @author wm
     * @create 2018-04-04
     * @return
     */
	public SunmnetSystemAdminInfoEntity getSystemAdminInfoByAdminMobile(String adminMobile);
	/**
     * 根据管理员编号查询管理员信息
     * @param adminNo
     * @author wm
     * @create 2018-04-04
     * @return
     */
	public SunmnetSystemAdminInfoEntity getSystemAdminInfoByAdminNo(String adminNo);
	/**
     * 根据管理员编号删除管理员信息
     * @param adminNo
     * @author wm
     * @create 2018-04-04
     * @return
     */
	public int deleteSystemAdminInfoByAdminNo(String adminNo);
	/**
     * 根据管理员编号修改管理员状态
     * @param sunmnetSystemAdminInfoEntity
     * @author wm
     * @create 2018-04-04
     * @return
     */
	public int updateSystemAdminStatusByAdminNo(SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity);
	/**
     * 查询管理员信息列表
     * @param querySystemAdminInfoPageRequest
     * @author wm
     * @create 2018-04-04
     * @return
     */
	public List<SunmnetSystemAdminInfoEntity> findSystemAdminInfo(QuerySystemAdminInfoPageRequest querySystemAdminInfoPageRequest);
	/**
     * 根据管理员编号修改管理员密码
     * @param sunmnetSystemAdminInfoEntity
     * @author wm
     * @create 2018-04-06
     * @return
     */
	public int updateSystemAdminPasswordByAdminNo(SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity);
	/**
     * 修改管理员信息
     * @param sunmnetSystemAdminInfoEntity
     * @author wm
     * @create 2018-04-09
     * @return
     */
	public int updateSystemAdminInfoByAdminNo(SunmnetSystemAdminInfoEntity sunmnetSystemAdminInfoEntity);

}