package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QuerySystemManageMenuInfoModel;


/**
 * @Description: 查询管理系统菜单返回参数
 * @author wm
 * @date 2018-04-06
 * @version 1.0
 */
public class QuerySystemMenuInfoResponse  extends BaseResponse{

	private static final long serialVersionUID = -8234734116380760781L;

	private List<QuerySystemManageMenuInfoModel> list;

	public List<QuerySystemManageMenuInfoModel> getList() {
		return list;
	}

	public void setList(List<QuerySystemManageMenuInfoModel> list) {
		this.list = list;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
