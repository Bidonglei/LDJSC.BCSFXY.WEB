package com.sunmnet.bigdata.systemManage.dao.systemManage;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.OperateLogInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.OperateLogPageRequest;

import java.util.List;

public interface OperateLogInfoMapper {
    int insert(OperateLogInfo record);

    List<OperateLogInfo> selectAll(OperateLogPageRequest operateLogPageRequest);
}