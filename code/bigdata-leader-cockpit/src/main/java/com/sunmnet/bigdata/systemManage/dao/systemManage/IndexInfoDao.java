package com.sunmnet.bigdata.systemManage.dao.systemManage;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetSystemOperationInfoEntity;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.AddIndexInfoRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.IndexInfoRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IndexInfoDao {

	/**
	 *功能描述 页面指标值
	 * @author lkg
	 * @date 2019/5/29
	 */
    List<Map> indexInfo(IndexInfoRequest indexInfoRequest);
    /**
     *功能描述 页面历史指标值
     * @author lkg
     * @date 2019/5/29
     */
    List<Map> historyIndexInfo(IndexInfoRequest indexInfoRequest);

    int insertSelective(AddIndexInfoRequest addIndexInfoRequest);
	/**
	 * @Description 获取四级功能点
	 * @author linjl
	 * @date 2019/6/22
	 */
	List<Map> listPageFunctional(IndexInfoRequest indexInfoRequest);
	/**
	 *功能描述 搜索四级功能点
	 * @author lkg
	 * @date 2019/6/25
	 */
	List<Map> searchFunctional(@Param(value = "content") String content);
	/**
	 *功能描述 获取目录父级菜单
	 * @author lkg
	 * @date 2019/6/25
	 */
	Map getParentMenu(@Param(value = "menuNo") String menuNo);
	/**
	 *功能描述 获取数据报告
	 * @author lkg
	 * @date 2019/7/10
	 */
	List<Map> pageDataSource(@Param(value = "menuNo") String menuNo);
}