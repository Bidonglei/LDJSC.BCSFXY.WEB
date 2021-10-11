package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryColorSetListModel;

/**
 * 查询颜色设置列表
 * @param queryColorSetList
 * @author zfb
 * @create 2019-01-21
 * @return
 */
public class QueryColorSetListResponse extends BaseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7227422998157214011L;
	
	private List<QueryColorSetListModel> list;

	public List<QueryColorSetListModel> getList() {
		return list;
	}

	public void setList(List<QueryColorSetListModel> list) {
		this.list = list;
	}
	
	
	

}
