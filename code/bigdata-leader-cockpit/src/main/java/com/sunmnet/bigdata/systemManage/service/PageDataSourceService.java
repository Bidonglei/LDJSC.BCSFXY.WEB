package com.sunmnet.bigdata.systemManage.service;

import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddIndexInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.IndexInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.UpdateDataSourceRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;


/**
 *功能描述  数据报告
 * @author lkg
 * @date 2019/8/28
 */
public interface PageDataSourceService {

	/**
	 *功能描述 获取数据报告
	 * @author lkg
	 * @date 2019/8/28
	 */
	SystemManageResponseInfo<Object> listDataSourceByPageCode(String pageCode);
	/**
	 *功能描述 修改数据报告
	 * @author lkg
	 * @date 2019/8/28
	 */
	SystemManageResponseInfo<Object> updateDataSource(UpdateDataSourceRequest updateDataSourceRequest);
	/**
	 *功能描述 删除数据报告
	 * @author lkg
	 * @date 2019/8/28
	 */
	SystemManageResponseInfo<Object> deleteDataSource(Long id);

}
