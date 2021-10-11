package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.RemoteStudentListModel;


public class QueryRemoteStudentListGroupResponse extends BaseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1717789675964311422L;
    
	
	private List<RemoteStudentListModel> list;


	public List<RemoteStudentListModel> getList() {
		return list;
	}


	public void setList(List<RemoteStudentListModel> list) {
		this.list = list;
	}
	
	
}
