package com.sunmnet.bigdata.systemManage.dao.systemManage;

import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetPageDataSource;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SunmnetPageDataSourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SunmnetPageDataSource record);

    int insertSelective(SunmnetPageDataSource record);

    SunmnetPageDataSource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SunmnetPageDataSource record);

    int updateByPrimaryKey(SunmnetPageDataSource record);

	/**
	 *功能描述 获取数据报告
	 * @author lkg
	 * @date 2019/8/28
	 */
	List<Map> listDataSourceByPageCode(@Param(value = "pageCode") String pageCode);
}