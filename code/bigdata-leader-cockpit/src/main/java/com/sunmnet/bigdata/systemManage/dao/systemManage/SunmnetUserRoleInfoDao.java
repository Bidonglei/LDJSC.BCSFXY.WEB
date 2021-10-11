package com.sunmnet.bigdata.systemManage.dao.systemManage;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetUserRoleInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.BatchUserRoleModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryUserRoleInfoModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserRoleInfoRequest;

public interface SunmnetUserRoleInfoDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(SunmnetUserRoleInfoEntity record);

    public SunmnetUserRoleInfoEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(SunmnetUserRoleInfoEntity record);

	public List<SunmnetUserRoleInfoEntity> findUserRoleInfoByUserNo(String userNo);
	/**
     * 根据用户编号删除用户角色关联信息
     * @param userNo
     * @author  wm
     * @create 2018-04-07
     * @return
     */
	public int deleteRoleInfoByUserNo(String userNo);
	/**
     * 根据角色编号查询角色授权的人数
     * @param roleNo
     * @author wm
     * @create 2018-04-07
     * @return
     */
	public long findUserRoleInfoCount(String roleNo);

	/**
     * 根据用户编号查询角色信息
     * @param queryUserRoleInfoRequest
     * @author zfb
     * @create 2018-04-18
     * @return
     */
	public List<QueryUserRoleInfoModel> queryUserRoleInfo(
			QueryUserRoleInfoRequest queryUserRoleInfoRequest);
	
	/**
     * 用户批量授权角色--批量删除
     * @param List<BatchUserRoleModel> temp
     * @author wm
     * @create 2018-07-11
     * @return
     */
	public int deleteBatchRole(List<BatchUserRoleModel> temp);
	
	
	/**
     * 用户批量授权角色--批量入库
     * @param List<SunmnetUserRoleInfoEntity> temp
     * @author wm
     * @create 2018-07-11
     * @return
     */
	public int insertBatchRole(List<SunmnetUserRoleInfoEntity> temp);
    
    

}