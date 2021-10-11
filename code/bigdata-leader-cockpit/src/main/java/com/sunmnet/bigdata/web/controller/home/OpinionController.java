package com.sunmnet.bigdata.web.controller.home;

import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.systemManage.service.DictInfoService;
import com.sunmnet.bigdata.web.model.request.home.OperateInfoPageRequest;
import com.sunmnet.bigdata.web.model.request.home.OpinionInfoREQ;
import com.sunmnet.bigdata.web.model.request.home.UpdateOpinionInfoREQ;
import com.sunmnet.bigdata.web.model.request.student.PageREQ;
import com.sunmnet.bigdata.web.service.home.OpinionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/opinion")
@Api(tags = "提交意见接口")
public class OpinionController extends BaseController {

    @Autowired
    private OpinionService opinionService;

    @ApiOperation(value = "提交意见列表展示")
    @RequestMapping(value = "/listOpinionInfo")
    @LoggerManage("提交意见列表展示")
    public JsonResult listOpinionInfo(@Validated OperateInfoPageRequest operateInfoPageRequest, BindingResult bindingResult) {
        return buildSuccJson(opinionService.listOpinionInfo(operateInfoPageRequest));
    }

	@ApiOperation(value = "提交意见添加")
	@RequestMapping(value = "/saveOpinionInfo")
	@LoggerManage("提交意见添加")
	public JsonResult saveOpinionInfo(OpinionInfoREQ opinionInfoREQ) {
		return buildSuccJson(opinionService.saveOpinionInfo(opinionInfoREQ));
	}

	@ApiOperation(value = "修改反馈意见")
	@RequestMapping(value = "/updateOpinionInfo")
	@LoggerManage("修改反馈意见")
	public JsonResult updateOpinionInfoById(@Validated UpdateOpinionInfoREQ updateOpinionInfoREQ, BindingResult bindingResult) {
		return buildSuccJson(opinionService.updateOpinionInfoById(updateOpinionInfoREQ));
	}
}
