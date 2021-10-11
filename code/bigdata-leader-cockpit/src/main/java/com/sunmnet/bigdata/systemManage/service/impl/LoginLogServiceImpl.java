package com.sunmnet.bigdata.systemManage.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.support.response.PageResult;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.AccountLoginHistoryInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.AccountLoginInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.OperateLogInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AccountLoginHistoryPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AccountLoginPageRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;
import com.sunmnet.bigdata.systemManage.dao.systemManage.AccountLoginHistoryInfoMapper;
import com.sunmnet.bigdata.systemManage.dao.systemManage.AccountLoginInfoMapper;
import com.sunmnet.bigdata.systemManage.dao.systemManage.OperateLogInfoMapper;
import com.sunmnet.bigdata.systemManage.service.LoginLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *功能描述 登陆日志
 * @author lkg
 * @date 2019/7/26
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {

	private Logger logger = LoggerFactory.getLogger(LoginLogServiceImpl.class);

	@Autowired
	private AccountLoginInfoMapper accountLoginInfoMapper;
	@Autowired
	private AccountLoginHistoryInfoMapper accountLoginHistoryInfoMapper;
	@Autowired
	private OperateLogInfoMapper operateLogInfoMapper;

	@Transactional
	@Override
	public int addLoginLog(AccountLoginInfo accountLoginInfo) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			AccountLoginInfo info = accountLoginInfoMapper.getAccountLoginInfoByAccount(accountLoginInfo);//判断是否登陆过
			if (info == null) {//没登陆过
				accountLoginInfo.setFirstLoginTime(df.format(new Date()));
				accountLoginInfo.setLastLoginTime(df.format(new Date()));
				accountLoginInfoMapper.insert(accountLoginInfo);
			} else {//登陆过
				accountLoginInfo.setLastLoginTime(df.format(new Date()));
				accountLoginInfoMapper.updateByAccount(accountLoginInfo);
			}
			//增加用户登陆历史
			AccountLoginHistoryInfo accountLoginHistoryInfo = new AccountLoginHistoryInfo();
			accountLoginHistoryInfo.setAccount(accountLoginInfo.getAccount());
			accountLoginHistoryInfo.setLoginTime(df.format(new Date()));
			accountLoginHistoryInfoMapper.insert(accountLoginHistoryInfo);

			//操作日志信息
			OperateLogInfo operateLogInfo = new OperateLogInfo();
			operateLogInfo.setAccount(accountLoginInfo.getAccount());
			operateLogInfo.setName(accountLoginInfo.getName());
			operateLogInfo.setType("登录系统");
			operateLogInfo.setOperateDescribe("登录系统");
			operateLogInfo.setOperateTime(df.format(new Date()));
			int i = operateLogInfoMapper.insert(operateLogInfo);
			return i;
		} catch (Exception e) {
			logger.error("登录时增加登录日志--异常",e);
			throw new RuntimeException();
		}
	}


	@Override
	public SystemManageResponseInfo<Object> accountLoginPage(AccountLoginPageRequest accountLoginPageRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			int pageNum = accountLoginPageRequest.getPageNum(); //  当前页
			int pageSize = accountLoginPageRequest.getPageSize();//  每页显示的记录数量
			PageHelper.startPage(pageNum, pageSize);
			List<AccountLoginInfo> list = accountLoginInfoMapper.selectAll();
			Page<AccountLoginInfo> count = (Page<AccountLoginInfo>) list;
			PageResult pageResult = new PageResult(list, count.getTotal(), pageNum, pageSize);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS, pageResult);
		} catch (Exception e) {
			logger.error("分页查询全部用户登陆信息列表--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	@Override
	public SystemManageResponseInfo<Object> accountLoginHistoryPage(
			AccountLoginHistoryPageRequest accountLoginHistoryPageRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			int pageNum = accountLoginHistoryPageRequest.getPageNum(); //  当前页
			int pageSize = accountLoginHistoryPageRequest.getPageSize();//  每页显示的记录数量
			PageHelper.startPage(pageNum, pageSize);
			List<AccountLoginHistoryInfo> list = accountLoginHistoryInfoMapper.getLoginHistoryByAccount(accountLoginHistoryPageRequest);
			Page<AccountLoginHistoryInfo> count = (Page<AccountLoginHistoryInfo>) list;
			PageResult pageResult = new PageResult(list, count.getTotal(), pageNum, pageSize);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS, pageResult);
		} catch (Exception e) {
			logger.error("分页查询用户登陆历史信息列表--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
}