package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.RemoteTeacherListModel;

/**
 * 根据筛选条件查询教职工信息没有分页
 * @author wm
 * @create 2018-05-25
 */
public class QueryRemoteTeacherListGroupResponse extends BaseResponse{
	private static final long serialVersionUID = -5996393620186998276L;
	
	private List<RemoteTeacherListModel> teacherList;

	public List<RemoteTeacherListModel> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<RemoteTeacherListModel> teacherList) {
		this.teacherList = teacherList;
	}
}
