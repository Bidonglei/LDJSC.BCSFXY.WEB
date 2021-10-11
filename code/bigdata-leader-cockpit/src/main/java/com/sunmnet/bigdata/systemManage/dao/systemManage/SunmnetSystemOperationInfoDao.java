package com.sunmnet.bigdata.systemManage.dao.systemManage;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemOperationInfoEntity;

public interface SunmnetSystemOperationInfoDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(SunmnetSystemOperationInfoEntity record);

    public SunmnetSystemOperationInfoEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(SunmnetSystemOperationInfoEntity record);

}