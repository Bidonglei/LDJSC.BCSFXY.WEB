package com.sunmnet.bigdata.systemManage.dao.diagnosisTeaching;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetAcademyInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryStudentDepartmentModel;

public interface SunmnetAcademyInfoDao {

    public int insertSelective(SunmnetAcademyInfoEntity record);

	/**
     * 查询学生八个系的下拉框
     * @author tkk
     * @create 2018-06-22
     */
	public List<QueryStudentDepartmentModel> queryStudentDepartment();
	
}