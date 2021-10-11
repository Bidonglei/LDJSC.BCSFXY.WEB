package com.sunmnet.bigdata.systemManage.dao.systemManage;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.AccountLoginHistoryInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AccountLoginHistoryPageRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountLoginHistoryInfoMapper {
    int insert(AccountLoginHistoryInfo record);

    List<AccountLoginHistoryInfo> selectAll();

    List<AccountLoginHistoryInfo> getLoginHistoryByAccount(AccountLoginHistoryPageRequest accountLoginHistoryPageRequest);
	/**
	 *功能描述 查询登陆人数
	 * @author lkg
	 * @date 2019/8/6
	 */
	Integer getLoginPersonNum (@Param(value = "date") String date);
	/**
	 *功能描述 查询登陆人次
	 * @author lkg
	 * @date 2019/8/6
	 */
	Integer getLoginPersonTime (@Param(value = "date") String date);
	/**
	 *功能描述 查询每天的登陆人次
	 * @author lkg
	 * @date 2019/8/7
	 */
	Integer getDayPersonTime (@Param(value = "date") String date);
}