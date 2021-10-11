package com.sunmnet.bigdata.web.controller.home;

import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.web.model.request.student.PageREQ;
import com.sunmnet.bigdata.web.service.home.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@Api(tags = "首页大屏")
public class HomeController extends BaseController {

    @Autowired
    private HomeService homeService;

    @ApiOperation(value = "首页大屏指标接口")
    @GetMapping(value = "/listIndexHomePage")
    @LoggerManage("首页大屏指标接口")
    public JsonResult listIndexHomePage() {
        return buildSuccJson(homeService.listIndexHomePage());
    }

}
