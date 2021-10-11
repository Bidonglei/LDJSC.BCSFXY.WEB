package com.sunmnet.bigdata.systemManage.service.impl;

import com.sunmnet.bigdata.systemManage.base.support.enums.BaseResultEnum;
import com.sunmnet.bigdata.systemManage.base.systemManage.entity.SunmnetPageDataSource;
import com.sunmnet.bigdata.systemManage.base.systemManage.request.UpdateDataSourceRequest;
import com.sunmnet.bigdata.systemManage.base.systemManage.responseInfo.SystemManageResponseInfo;
import com.sunmnet.bigdata.systemManage.dao.systemManage.SunmnetPageDataSourceMapper;
import com.sunmnet.bigdata.systemManage.service.PageDataSourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *功能描述 数据报告
 * @author lkg
 * @date 2019/8/28
 */
@Service
public class PageDataSourceServiceImpl implements PageDataSourceService {

	private Logger logger = LoggerFactory.getLogger(PageDataSourceServiceImpl.class);
	
	@Autowired
	private SunmnetPageDataSourceMapper sunmnetPageDataSourceMapper;


	@Override
	public SystemManageResponseInfo<Object> listDataSourceByPageCode(String pageCode) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			List<Map> list = sunmnetPageDataSourceMapper.listDataSourceByPageCode(pageCode);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,list);
		} catch (Exception e) {
			logger.error("数据报告维护 获取数据报告--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	@Override
	public SystemManageResponseInfo<Object> updateDataSource(UpdateDataSourceRequest updateDataSourceRequest) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			SunmnetPageDataSource sunmnetPageDataSource = new SunmnetPageDataSource();
			sunmnetPageDataSource.setId(updateDataSourceRequest.getId());
			sunmnetPageDataSource.setChartName(updateDataSourceRequest.getChartName());
			sunmnetPageDataSource.setDataType(updateDataSourceRequest.getDataType());
			sunmnetPageDataSource.setDataSynchronize(updateDataSourceRequest.getDataSynchronize());
			sunmnetPageDataSource.setDataQuestion(updateDataSourceRequest.getDataQuestion());
			int i = sunmnetPageDataSourceMapper.updateByPrimaryKeySelective(sunmnetPageDataSource);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,i);
		} catch (Exception e) {
			logger.error("数据报告维护 修改数据报告--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}

	@Override
	public SystemManageResponseInfo<Object> deleteDataSource(Long id) {
		SystemManageResponseInfo<Object> responseInfo = new SystemManageResponseInfo<Object>();
		try {
			int i = sunmnetPageDataSourceMapper.deleteByPrimaryKey(id);
			responseInfo.setBaseResponseInfo(BaseResultEnum.SUCCESS,i);
		} catch (Exception e) {
			logger.error("数据报告维护 删除数据报告--异常", e);
			responseInfo.setBaseResponseInfo(BaseResultEnum.FAIL);
		}
		return responseInfo;
	}
}
