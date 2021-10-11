package com.sunmnet.bigdata.web.service.asset;

import java.util.List;
import java.util.Map;

/**
 *功能描述 固定资产
 * @author lkg
 * @date 2019/2/21
 */
public interface FixedAssetService {

	/**
	 *功能描述 各单位固定资产分布
	 * @author lkg
	 * @date 2019/2/21
	 */
	List<Map> listFixedAssetDistribute(String assetType);
}
