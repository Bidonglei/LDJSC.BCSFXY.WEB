package com.sunmnet.bigdata.systemManage.base.systemManage.response;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.MenuInfoModel;

/**
 * @Description:查询所有菜单信息返回参数
 * @author zfb
 * @date 2018-04-12
 * @version 1.0
 */
public class QueryMenuInfoResponse  extends BaseResponse{

	private static final long serialVersionUID = 6161951461459406659L;
	
	private List<MenuInfoModel> list;

	public List<MenuInfoModel> getList() {
		return list;
	}

	public void setList(List<MenuInfoModel> list) {
		this.list = list;
	}

}
