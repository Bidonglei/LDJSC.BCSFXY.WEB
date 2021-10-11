package com.sunmnet.bigdata.systemManage.service;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRemoteTeacherListGroupRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryRemoteTeacherListRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryRemoteTeacherListGroupResponse;



@Service
public interface DiagnosisTeacherService{
	 /**
      * 根据筛选条件查询教职工信息
      * @author fr
      * @create 2018-06-23
      * @return
      */ 	 
 	 public BaseResponseInfo<PageResult> queryRemoteTeacherList(@RequestBody QueryRemoteTeacherListRequest queryRemoteTeacherListRequest);
 	 /**
      * 根据筛选条件查询教职工信息没有分页
      * @author wm
      * @create 2018-06-25
      * @return
      */ 	 
 	 public BaseResponseInfo<QueryRemoteTeacherListGroupResponse> queryRemoteTeacherListGroup(@RequestBody QueryRemoteTeacherListGroupRequest queryRemoteTeacherListGroupRequest);
 	 
}