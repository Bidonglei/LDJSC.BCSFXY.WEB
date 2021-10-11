package com.sunmnet.bigdata.systemManage.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.AccountLoginHistoryInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.AccountLoginInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.LookAnalysisInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.OperateLogInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AccountLoginHistoryPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AccountLoginPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.MenuVisitRecordRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.OperateLogPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;
import com.sunmnet.bigdata.systemManage.dao.systemManage.AccountLoginHistoryInfoMapper;
import com.sunmnet.bigdata.systemManage.dao.systemManage.AccountLoginInfoMapper;
import com.sunmnet.bigdata.systemManage.dao.systemManage.LookAnalysisInfoMapper;
import com.sunmnet.bigdata.systemManage.dao.systemManage.OperateLogInfoMapper;
import com.sunmnet.bigdata.systemManage.service.LoginLogService;
import com.sunmnet.bigdata.systemManage.service.OperateLogService;
import com.sunmnet.bigdata.systemManage.util.SystemManageDateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *功能描述 操作日志
 * @author lkg
 * @date 2019/8/6
 */
@Service
public class OperateLogServiceImpl implements OperateLogService {

	private Logger logger = LoggerFactory.getLogger(OperateLogServiceImpl.class);

	@Autowired
	private OperateLogInfoMapper operateLogInfoMapper;
	@Autowired
	private LookAnalysisInfoMapper lookAnalysisInfoMapper;
	@Autowired
	private AccountLoginHistoryInfoMapper accountLoginHistoryInfoMapper;



	@Override
	@Transactional
	public SystemManageResponseInfo<Object> saveLookRecord(LookAnalysisInfo lookAnalysisInfo) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//增加查看分析记录
			lookAnalysisInfo.setTime(df.format(new Date()));
			int i = lookAnalysisInfoMapper.insert(lookAnalysisInfo);
			//增加操作日志信息记录
			StringBuilder describe = new StringBuilder();
			describe.append(lookAnalysisInfo.getOneMenu());
			describe.append("->");
			describe.append(lookAnalysisInfo.getTwoMenu());
			describe.append("->");
			describe.append(lookAnalysisInfo.getThreeMenu());

			OperateLogInfo operateLogInfo = new OperateLogInfo();
			operateLogInfo.setName(lookAnalysisInfo.getName());
			operateLogInfo.setAccount(lookAnalysisInfo.getAccount());
			operateLogInfo.setType("查看分析");
			operateLogInfo.setOperateTime(df.format(new Date()));
			operateLogInfo.setOneMenuCode(lookAnalysisInfo.getOneMenuCode());
			operateLogInfo.setOneMenu(lookAnalysisInfo.getOneMenu());
			operateLogInfo.setTwoMenuCode(lookAnalysisInfo.getTwoMenuCode());
			operateLogInfo.setTwoMenu(lookAnalysisInfo.getTwoMenu());
			operateLogInfo.setThreeMenuCode(lookAnalysisInfo.getThreeMenuCode());
			operateLogInfo.setThreeMenu(lookAnalysisInfo.getThreeMenu());
			operateLogInfo.setOperateDescribe(describe.toString());
			operateLogInfoMapper.insert(operateLogInfo);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS, i);
		} catch (Exception e) {
			logger.error("增加用户查看--异常", e);
			throw new RuntimeException();
		}
		return responseInfo;
	}

	@Override
	public SystemManageResponseInfo<Object> operateLogPage(OperateLogPageRequest operateLogPageRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			int pageNum = operateLogPageRequest.getPageNum(); //  当前页
			int pageSize = operateLogPageRequest.getPageSize();//  每页显示的记录数量
			PageHelper.startPage(pageNum, pageSize);
			List<OperateLogInfo> list = operateLogInfoMapper.selectAll(operateLogPageRequest);
			Page<OperateLogInfo> count = (Page<OperateLogInfo>) list;
			PageResult pageResult = new PageResult(list, count.getTotal(), pageNum, pageSize);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS, pageResult);
		} catch (Exception e) {
			logger.error("操作日志分页列表--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	@Override
	public SystemManageResponseInfo<Object> loginStatistics() {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			HashMap<String, Object> map = new HashMap<>();
			//今日访问
			String dayBegin = SystemManageDateUtil.dateToString(SystemManageDateUtil.getDayBegin());//当天日期
			Integer dayTime = accountLoginHistoryInfoMapper.getLoginPersonTime(dayBegin);//查询当天人次
			Integer dayNum = accountLoginHistoryInfoMapper.getLoginPersonNum(dayBegin);//查询当天人数

			//本周累计
			String dayWeek = SystemManageDateUtil.dateToString(SystemManageDateUtil.getBeginDayOfWeek());//当周日期
			Integer weekTime = accountLoginHistoryInfoMapper.getLoginPersonTime(dayWeek);//查询当周人次

			//本月累计
			String dayMonth = SystemManageDateUtil.dateToString(SystemManageDateUtil.getBeginDayOfMonth());//当月日期
			Integer monthTime = accountLoginHistoryInfoMapper.getLoginPersonTime(dayMonth);//查询当月人次

			//历史累计
			Integer allTime = accountLoginHistoryInfoMapper.getLoginPersonTime("");//历史累计

			map.put("dayTimeNum",dayTime + "/" +dayNum);
			map.put("weekTime",weekTime);
			map.put("monthTime",monthTime);
			map.put("allTime",allTime);

			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS, map);
		} catch (Exception e) {
			logger.error("登陆统计--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	@Override
	public SystemManageResponseInfo<Object> loginMonthStatistics() {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			Map<String, Object> map = new HashMap<>();
			Map<String, Object> dayMap = new LinkedHashMap<>();
			//当前年月
			String yearMonth = SystemManageDateUtil.getYearMonth();
			map.put("yearMonth",yearMonth);
			//当前月登陆人次
			List<String> dayList = SystemManageDateUtil.getDayListOfMonth();
			for (String day : dayList) {
				Integer time = accountLoginHistoryInfoMapper.getDayPersonTime(day);
				dayMap.put(day,time);
			}
			map.put("list",dayMap);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS, map);
		} catch (Exception e) {
			logger.error("系统本月访问人次--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	@Override
	public SystemManageResponseInfo<Object> menuVisitRecord(MenuVisitRecordRequest menuVisitRecordRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			List<Map> list = null;
			if (StringUtil.isEmpty(menuVisitRecordRequest.getOneMenu())){
				list = lookAnalysisInfoMapper.getOneStatistics(menuVisitRecordRequest);
			}else {
				list = lookAnalysisInfoMapper.getThreeStatistics(menuVisitRecordRequest);
			}
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS, list);
		} catch (Exception e) {
			logger.error("各模块访问情况--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

}