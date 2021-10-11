package com.sunmnet.bigdata.systemManage.dao.systemManage;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetUserInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryUserPageModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserInfoBeathRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryUserInfoPageRequest;

public interface SunmnetUserInfoDao {


    public int insertSelective(SunmnetUserInfoEntity record);

    /**
     * 根据用户编号查询用户信息
     * @param userNo
     * @author wm
     * @create 2018-03-20
     * @return
     */
	public SunmnetUserInfoEntity getUserInfoByUserNo(String userNo);
	/**
     * 根据手机号查询用户信息
     * @param userMobile
     * @author wm
     * @create 2018-03-30
     * @return
     */
	public SunmnetUserInfoEntity getUserInfoByUserMobile(String userMobile);

	/**
     * 根据用户编号删除用户信息
     * @param userNo
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	public int deleteUserInfoByUserNo(String userNo);

	/**
     * 根据用户编号修改用户状态
     * @param sunmnetUserInfoEntity
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	public int updateUserStatusByUserNo(SunmnetUserInfoEntity sunmnetUserInfoEntity);

	/**
     * 重置用户密码
     * @param sunmnetUserInfoEntity
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	public int updateUserPasswordByUserNo(SunmnetUserInfoEntity sunmnetUserInfoEntity);
	
	/**
     * 查询用户信息
     * @param queryUserInfoPageRequest
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	public List<QueryUserPageModel> findUserInfo(QueryUserInfoPageRequest queryUserInfoPageRequest);
	
	/**
     * 根据部门编号查询部门人数
     * @param departmentNo
     * @author zfb
     * @create 2018-03-28
     * @return
     */
	public long getDepartmentUserNum(String departmentNo);

	/**
     * 修改用户信息
     * @param sunmnetUserInfoEntity
     * @author zfb
     * @create 2018-04-09
     * @return
     */
	public int updateUserInfoByUserNo(SunmnetUserInfoEntity sunmnetUserInfoEntity);
	
	/**
     * 根据关联编号查询用户信息
     * @param sunmnetUserInfoEntity
     * @author wm
     * @create 2018-04-28
     * @return
     */
	public SunmnetUserInfoEntity getUserInfoByrRelationNo(String relationNo);
	
	/**
     * 用户信息批量入库
     * @param List<SunmnetUserInfoEntity>
     * @author wm
     * @create 2018-06-27
     * @return
     */
	public int insertBatchUserInfo(List<SunmnetUserInfoEntity> temp);

	/**
     * 查询用户批量授权信息
     * @param queryUserInfoBeathRequest
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	public List<QueryUserPageModel> findUserInfoBeath(
			QueryUserInfoBeathRequest queryUserInfoBeathRequest);
}