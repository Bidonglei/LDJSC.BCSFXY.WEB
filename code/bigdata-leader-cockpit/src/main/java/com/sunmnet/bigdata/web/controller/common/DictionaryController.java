package com.sunmnet.bigdata.web.controller.common;

import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.web.service.common.DictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Auther: lkg
 * @Date: 2019/2/18 17:29
 */
@RestController
@RequestMapping("/common")
@Api(tags="字典项")
public class DictionaryController extends BaseController {

	@Autowired
	private DictionaryService dictionaryService;

	@ApiOperation(value = "通过字典类型查询字典项")
	@GetMapping(value = "/getDictList")
	@LoggerManage("通过字典类型查询字典项")
	public JsonResult getDictList(String dictType){
		return buildSuccJson(dictionaryService.getDictList(dictType));
	}

	@ApiOperation(value = "总搜索框接口")
	@GetMapping(value = "/listSearchBox")
	@LoggerManage("总搜索框接口")
	public JsonResult listSearchBox(){
		return buildSuccJson(dictionaryService.listSearchBox());
	}
}
