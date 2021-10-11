package com.sunmnet.bigdata.systemManage.dao.systemManage;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetDepartmentInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryDepartmentDropdownModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryDepartmentInfoPageRequest;

public interface SunmnetDepartmentInfoDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(SunmnetDepartmentInfoEntity record);
	
    public SunmnetDepartmentInfoEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(SunmnetDepartmentInfoEntity record);
    /**
     * 部门信息下拉框选择
     * @author wm
     * @create 2018-03-23
     * @return
     */
	public List<QueryDepartmentDropdownModel> queryDepartmentDropdown();

	/**
     * 根据部门编号删除部门信息
     * @param departmentNo
     * @author zfb
     * @create 2018-04-05
     * @return
     */
	public int deleteDepartmentInfoByDepartmentNo(String departmentNo);

	/**
     * 根据部门编号查询部门信息
     * @param departmentNo
     * @author zfb
     * @create 2018-04-05
     * @return
     */
	public SunmnetDepartmentInfoEntity getDepartmentInfoByDepartmentNo(
			String departmentNo);

	/**
     * 修改部门状态
     * @param sunmnetDepartmentInfoEntity
     * @author zfb
     * @create 2018-04-05
     * @return
     */
	public int updateDepartmentStatusByDepartmentNo(
			SunmnetDepartmentInfoEntity sunmnetDepartmentInfoEntity);

	/**
     * 分页查询部门信息
     * @param queryDepartmentInfoPageRequest
     * @author zfb
     * @create 2018-04-05
     * @return
     */
	public List<SunmnetDepartmentInfoEntity> findDepartmentInfo(
			QueryDepartmentInfoPageRequest queryDepartmentInfoPageRequest);

	/**
     * 修改部门信息
     * @param sunmnetDepartmentInfoEntity
     * @author zfb
     * @create 2018-04-09
     * @return
     */
	public int updateDepartmentInfoByDepartmentNo(SunmnetDepartmentInfoEntity sunmnetDepartmentInfoEntity);

	/**
     * 通过部门名称查修部门信息
     * @param addDepartmentInfoRequest
     * @author zfb
     * @create 2018-04-04
     * @return
     */
	public SunmnetDepartmentInfoEntity getDepartmentInfoByName(
			String departmentName);

}