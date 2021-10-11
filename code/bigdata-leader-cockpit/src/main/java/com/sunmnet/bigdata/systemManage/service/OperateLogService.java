package com.sunmnet.bigdata.systemManage.service;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.LookAnalysisInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.MenuVisitRecordRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.OperateLogPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;


/**
 *功能描述 操作日志信息
 * @author lkg
 * @date 2019/8/5
 */
public interface OperateLogService {


	/**
	 *功能描述 增加用户查看
	 * @author lkg
	 * @date 2019/8/5
	 */
	SystemManageResponseInfo<Object> saveLookRecord(LookAnalysisInfo lookAnalysisInfo);
	/**
	 *功能描述 操作日志分页列表
	 * @author lkg
	 * @date 2019/8/6
	 */
	SystemManageResponseInfo<Object> operateLogPage(
			OperateLogPageRequest operateLogPageRequest);
	/**
	 *功能描述 登陆统计
	 * @author lkg
	 * @date 2019/8/6
	 */
	SystemManageResponseInfo<Object> loginStatistics();
	/**
	 *功能描述 系统本月访问人次
	 * @author lkg
	 * @date 2019/8/7
	 */
	SystemManageResponseInfo<Object> loginMonthStatistics();
	/**
	 *功能描述 各模块访问情况
	 * @author lkg
	 * @date 2019/8/7
	 */
	SystemManageResponseInfo<Object> menuVisitRecord(MenuVisitRecordRequest menuVisitRecordRequest);

}
