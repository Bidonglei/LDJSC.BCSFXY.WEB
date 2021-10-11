package com.sunmnet.bigdata.systemManage.dao.systemManage;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.AccountLoginInfo;

import java.util.List;

public interface AccountLoginInfoMapper {
    int insert(AccountLoginInfo record);

    List<AccountLoginInfo> selectAll();

    int updateByPrimaryKey(AccountLoginInfo record);

    int updateByAccount(AccountLoginInfo record);

	AccountLoginInfo getAccountLoginInfoByAccount(AccountLoginInfo record);
}