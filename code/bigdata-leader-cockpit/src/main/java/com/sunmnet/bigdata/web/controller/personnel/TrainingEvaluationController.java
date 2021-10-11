package com.sunmnet.bigdata.web.controller.personnel;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.web.model.request.personnel.AssessInfoTypeREQ;
import com.sunmnet.bigdata.web.model.request.personnel.AssessInfoREQ;
import com.sunmnet.bigdata.web.service.personnel.TrainingEvaluationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/trainingEvaluation")
@Api(tags="人员考核")
public class TrainingEvaluationController extends BaseController
{
    @Autowired
    private TrainingEvaluationService trainingEvaluationService;

    @ApiOperation(value = "培养考核：人事考核-列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", dataType = "int", required = true, value = "pageNum", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", required = true, value = "pageSize", defaultValue = "10")
    })
    @GetMapping(value = "/listAssessInfoByName")
    @LoggerManage("按照各种条件查询列表")
    public JsonResult listAssessInfoByName(@ModelAttribute AssessInfoREQ req, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        final List<Map> list = trainingEvaluationService.listAssessInfoByName(req);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return buildSuccJson(pageInfo);
    }

    @ApiOperation(value = "考核年度")
    @GetMapping(value = "/getAssessmentTypeNum")
    @LoggerManage("考核年度")
    public JsonResult getAssessmentTypeNum(@ModelAttribute AssessInfoTypeREQ req){
        return buildSuccJson(trainingEvaluationService.getAssessmentTypeNum(req));
    }

    @ApiOperation(value = "考核年度-下拉框(无用)")
    @PostMapping(value = "/getAssessmentDepartment")
    @LoggerManage("考核年度-下拉框")
    public JsonResult getAssessmentDepartment(){
        return buildSuccJson(trainingEvaluationService.getAssessmentDepartment());
    }


}
