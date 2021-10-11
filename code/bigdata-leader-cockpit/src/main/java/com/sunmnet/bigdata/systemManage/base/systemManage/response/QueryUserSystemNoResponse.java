package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryUserSystemNoModel;

/**
 * @Description:查询用户拥有的系统权限返回参数
 * @author wm
 * @date 2018-07-31
 * @version 1.0
 */
public class QueryUserSystemNoResponse extends BaseResponse{

	private static final long serialVersionUID = 7413149613704413786L;
	//系统编号集合
	
	private List<QueryUserSystemNoModel> systemList;

	public List<QueryUserSystemNoModel> getSystemList() {
		return systemList;
	}

	public void setSystemList(List<QueryUserSystemNoModel> systemList) {
		this.systemList = systemList;
	}
}
