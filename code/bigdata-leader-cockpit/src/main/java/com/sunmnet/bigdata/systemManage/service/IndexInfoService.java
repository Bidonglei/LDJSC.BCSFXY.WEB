package com.sunmnet.bigdata.systemManage.service;

import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetUserInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.*;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.response.QueryUserRoleInfoResponse;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;


/**
 *功能描述  指标相关
 * @author lkg
 * @date 2019/5/30
 */
public interface IndexInfoService {

	/**
	 *功能描述 通过组件编号获取指标
	 * @author lkg
	 * @date 2019/5/30
	 */
	SystemManageResponseInfo<Object> indexInfo(IndexInfoRequest indexInfoRequest);

	SystemManageResponseInfo<Object> addIndexInfo(AddIndexInfoRequest addIndexInfoRequest);

	/**
	 * @Description 获取四级功能点
	 * @author linjl
	 * @date 2019/6/22
	 */
	SystemManageResponseInfo<Object> listPageFunctional(IndexInfoRequest indexInfoRequest);
	/**
	 *功能描述 搜索四级功能点
	 * @author lkg
	 * @date 2019/6/25
	 */
	SystemManageResponseInfo<Object> searchMenu (String content);
	/**
	 *功能描述 获取数据报告
	 * @author lkg
	 * @date 2019/7/10
	 */
	SystemManageResponseInfo<Object> pageDataSource(String menuNo);

}
