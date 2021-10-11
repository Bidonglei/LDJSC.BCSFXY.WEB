package com.sunmnet.bigdata.web.mapper.asset;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *功能描述 固定资产
 * @author lkg
 * @date 2019/2/21
 */
public interface FixedAssetMapper {
	/**
	 *功能描述 各单位固定资产分布
	 * @author lkg
	 * @date 2019/2/21
	 */
	List<Map> listFixedAssetDistribute(@Param(value = "assetType") String assetType);
	/**
	 *功能描述 各部门的资产分布
	 * @author lkg
	 * @date 2019/3/5
	 */
	List<Map> listFixedAssetDisDep();
}
