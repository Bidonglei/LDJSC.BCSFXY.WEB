package com.sunmnet.bigdata.systemManage.dao.diagnosisTeaching;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetClassInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryClassByMajorNoModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryDeptModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryClassByMajorNoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QuerySecondDeptByFirstDeptNoRequest;


public interface SunmnetClassInfoDao {

    public int deleteByPrimaryKey(String code);

    public int insertSelective(SunmnetClassInfoEntity record);

    public SunmnetClassInfoEntity selectByPrimaryKey(String code);

    public int updateByPrimaryKeySelective(SunmnetClassInfoEntity record);
	/**
     * 服务间调用 指标管理：根据学生专业编号查询对应的班级下拉框
     * @author tkk
     * @create 2018-06-22
     */
	public List<QueryClassByMajorNoModel> queryClassByMajorNo(
			QueryClassByMajorNoRequest queryClassByMajorNoRequest);

	/**
	 * 查询学校的一级部门下拉框
	 * @auther tkk
	 * 2018年6月23日
	 */
	public List<QueryDeptModel> queryFirstDept();

	/**
     * 服务间调用 指标管理：根据一级部门编号查询二级部门信息下拉框
     * @author tkk
     * @create 2018-06-22
     */
	public List<QueryDeptModel> querySecondDeptByFirstDeptNo(
			QuerySecondDeptByFirstDeptNoRequest querySecondDeptByFirstDeptNoRequest);
	/**
     * 查询二级部门信息
     * @author wm
     * @create 2018-06-28
     * @return
     */
	public List<QueryDeptModel> querySecondDept();

}