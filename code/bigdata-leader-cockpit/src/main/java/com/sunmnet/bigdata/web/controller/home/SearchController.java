package com.sunmnet.bigdata.web.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.web.model.request.home.SearchREQ;
import com.sunmnet.bigdata.web.service.home.SearchService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/home/search")
@Api(tags = "搜索框接口")
public class SearchController extends BaseController{

    @Autowired
    private SearchService searchService;
    
    @ApiOperation(value = "搜索框信息")
    @GetMapping(value = "/listSearchBox")
    @LoggerManage("搜索框信息")
    public JsonResult listSearchBox() {
        return buildSuccJson(searchService.listSearchBox());
    }
    
    @ApiOperation(value = "搜索框信息-专业")
    @PostMapping(value = "/listSearchBoxMajor")
    @LoggerManage("搜索框信息-专业")
    public JsonResult listSearchBoxMajor(SearchREQ searchREQ) {
        return buildSuccJson(searchService.listSearchBoxMajor(searchREQ));
    }
    
    @ApiOperation(value = "搜索框信息-班级")
    @PostMapping(value = "/listSearchBoxClass")
    @LoggerManage("搜索框信息-班级")
    public JsonResult listSearchBoxClass(SearchREQ searchREQ) {
        return buildSuccJson(searchService.listSearchBoxClass(searchREQ));
    }
}
