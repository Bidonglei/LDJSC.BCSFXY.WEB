package com.sunmnet.bigdata.systemManage.dao.systemManage;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.LookAnalysisInfo;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.MenuVisitRecordRequest;

import java.util.List;
import java.util.Map;

public interface LookAnalysisInfoMapper {
    int insert(LookAnalysisInfo record);

    List<LookAnalysisInfo> selectAll();
	/**
	 *功能描述 获取一级菜单访问统计
	 * @author lkg
	 * @date 2019/8/7
	 */
	List<Map> getOneStatistics(MenuVisitRecordRequest menuVisitRecordRequest);
	/**
	 *功能描述 获取二级菜单访问统计
	 * @author lkg
	 * @date 2019/8/7
	 */
	List<Map> getThreeStatistics(MenuVisitRecordRequest menuVisitRecordRequest);
}