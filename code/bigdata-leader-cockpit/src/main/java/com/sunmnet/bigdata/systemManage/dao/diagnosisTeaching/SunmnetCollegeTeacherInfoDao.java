package com.sunmnet.bigdata.systemManage.dao.diagnosisTeaching;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetCollegeTeacherInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRemoteTeacherListRequest;

public interface SunmnetCollegeTeacherInfoDao {

	/**
     * 学院教职工信息服务间调
     * @author wm
     * @create 2018-06-22
     * @return
     */
    public SunmnetCollegeTeacherInfoEntity queryCollegeTeacherInfo(String teacherNo);
   
	/**
     * 根据筛选条件查询教职工信息
     * @author fr
     * @create 2018-06-23
     * @return
     */
	public List<SunmnetCollegeTeacherInfoEntity> queryRemoteTeacherList(
			QueryRemoteTeacherListRequest queryRemoteTeacherListRequest);
}