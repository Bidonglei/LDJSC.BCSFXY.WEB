package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryUserRoleInfoModel;

/**
 * 根据用户编号查询角色信息
 * @author zfb
 * @create 2018-04-18
 * @return
 */
public class QueryUserRoleInfoResponse   extends BaseResponse {

	private static final long serialVersionUID = 7027010180940765560L;
	private List<QueryUserRoleInfoModel> list;
	public List<QueryUserRoleInfoModel> getList() {
		return list;
	}
	public void setList(List<QueryUserRoleInfoModel> list) {
		this.list = list;
	}

}
