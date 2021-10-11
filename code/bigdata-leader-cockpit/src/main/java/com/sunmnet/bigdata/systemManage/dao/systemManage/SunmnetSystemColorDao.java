package com.sunmnet.bigdata.systemManage.dao.systemManage;

import java.util.List;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemColorEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.model.QueryColorSetListModel;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.QueryColorSetListRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.SetSystemColorRequest;

public interface SunmnetSystemColorDao {

    public int deleteByPrimaryKey(Long id);

    public int insertSelective(SunmnetSystemColorEntity record);

    public SunmnetSystemColorEntity selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(SunmnetSystemColorEntity record);

    /**
     * 设置颜色
     * @param setSystemColor
     * @author zfb
     * @create 2019-01-21
     */
	public SunmnetSystemColorEntity querySunmnetSystemColor(
			SetSystemColorRequest setSystemColorRequest);

	/**
     * 查询颜色设置列表
     * @param queryColorSetList
     * @author zfb
     * @create 2019-01-21
     * @return
     */
	public List<QueryColorSetListModel> queryColorSetList(
			QueryColorSetListRequest queryColorSetListRequest);

}