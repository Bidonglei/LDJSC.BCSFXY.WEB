package com.sunmnet.bigdata.web.controller.asset;

import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.web.service.asset.FixedAssetService;
import com.sunmnet.bigdata.web.service.personnel.HighLevelTalentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fixedAsset")
@Api(tags="设备资产")
public class FixedAssetController extends BaseController
{
    @Autowired
    private FixedAssetService fixedAssetService;


	@ApiOperation(value = "固定资产： 各单位固定资产分布")
	@GetMapping(value = "/listFixedAssetDistribute")
	@LoggerManage("固定资产： 各单位固定资产分布")
	public JsonResult listFixedAssetDistribute(String assetType){
		return buildSuccJson(fixedAssetService.listFixedAssetDistribute(assetType));
	}


}
