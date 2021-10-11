package com.sunmnet.bigdata.systemManage.service;

import com.sunmnet.bigdata.systemManage.base.support.request.BasePageRequest;
import com.sunmnet.bigdata.systemManage.base.support.response.BaseResponseInfo;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.AccountLoginHistoryInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.AccountLoginInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.*;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;


/**
 *功能描述 登陆日志
 * @author lkg
 * @date 2019/7/26
 */
public interface LoginLogService {


	/**
	 *功能描述 登录时增加登录日志
	 * @author lkg
	 * @date 2019/7/26
	 */
	int addLoginLog(AccountLoginInfo accountLoginInfo);
	/**
	 *功能描述 分页查询全部用户登陆信息列表
	 * @author lkg
	 * @date 2019/7/26
	 */
	SystemManageResponseInfo<Object> accountLoginPage(
			AccountLoginPageRequest accountLoginPageRequest);

	/**
	 *功能描述 分页查询用户登陆历史信息列表
	 * @author lkg
	 * @date 2019/7/26
	 */
	SystemManageResponseInfo<Object> accountLoginHistoryPage(
			AccountLoginHistoryPageRequest accountLoginHistoryPageRequest);
}
