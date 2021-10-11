package com.sunmnet.bigdata.web.service.asset.impl;

import com.github.pagehelper.StringUtil;
import com.sunmnet.bigdata.web.mapper.asset.FixedAssetMapper;
import com.sunmnet.bigdata.web.mapper.personnel.HighLevelTalentMapper;
import com.sunmnet.bigdata.web.service.asset.FixedAssetService;
import com.sunmnet.bigdata.web.service.personnel.HighLevelTalentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *功能描述 固定资产
 * @author lkg
 * @date 2019/2/21
 */
@Service
public class FixedAssetServiceImpl implements FixedAssetService {

	@Autowired
	private FixedAssetMapper fixedAssetMapper;

	@Override
	public List<Map> listFixedAssetDistribute(String assetType) {
		List<Map> mapList= null;
		if (StringUtil.isNotEmpty(assetType)) {
			mapList = fixedAssetMapper.listFixedAssetDistribute(assetType);//传递资产类型
		}else {
			mapList = fixedAssetMapper.listFixedAssetDisDep();//不传递资产类型 （前段号处理）
		}
		return mapList;
	}

}
