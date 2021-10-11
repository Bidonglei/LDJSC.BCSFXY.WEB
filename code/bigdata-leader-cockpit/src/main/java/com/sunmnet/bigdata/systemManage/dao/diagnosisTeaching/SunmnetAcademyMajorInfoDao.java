package com.sunmnet.bigdata.systemManage.dao.diagnosisTeaching;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetAcademyMajorInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryMajorByDepartmentNoModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryMajorByDepartmentNoRequest;

public interface SunmnetAcademyMajorInfoDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(SunmnetAcademyMajorInfoEntity record);

    public SunmnetAcademyMajorInfoEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(SunmnetAcademyMajorInfoEntity record);
   
	
	/**
     * 服务间调用 指标管理：根据学生八个系的系编号查询对应的专业下拉框
     * @author tkk
     * @create 2018-06-22
     * @return
     */
	public List<QueryMajorByDepartmentNoModel> queryMajorByDepartmentNono(
			QueryMajorByDepartmentNoRequest queryMajorByDepartmentNoRequest);
	
}