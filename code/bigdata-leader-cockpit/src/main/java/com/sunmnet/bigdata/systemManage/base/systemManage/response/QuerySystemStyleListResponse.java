package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QuerySystemStyleListModel;

/**
 * 查询系统风格设置列表
 * @param querySystemStyleList
 * @author zfb
 * @create 2019-01-21
 * @return
 */
public class QuerySystemStyleListResponse extends BaseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4020818941730871656L;
	
	private List<QuerySystemStyleListModel> list;

	public List<QuerySystemStyleListModel> getList() {
		return list;
	}

	public void setList(List<QuerySystemStyleListModel> list) {
		this.list = list;
	}
	
	

}
