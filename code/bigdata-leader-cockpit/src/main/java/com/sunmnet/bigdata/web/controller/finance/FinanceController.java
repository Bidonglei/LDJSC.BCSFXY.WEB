package com.sunmnet.bigdata.web.controller.finance;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.web.model.request.finance.CapitalVoucherREQ;
import com.sunmnet.bigdata.web.model.request.finance.FinanceREQ;
import com.sunmnet.bigdata.web.service.finance.FinanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/finance")
@Api(tags = "财务域")
public class FinanceController extends BaseController {

    @Autowired
    private FinanceService financeService;

    @ApiOperation(value = "资金余额情况表")
    @GetMapping(value = "/listCapitalBalance")
    @LoggerManage("资金余额情况表")
    public JsonResult listCapitalBalance(FinanceREQ req) {
        return buildSuccJson(financeService.listCapitalBalance(req));
    }

    @ApiOperation(value = "资金变动凭证列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", dataType = "int", required = true, value = "pageNum", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", required = true, value = "pageSize", defaultValue = "10")
    })
    @GetMapping(value = "/listCapitalVoucher")
    @LoggerManage("资金变动凭证列表")
    public JsonResult listCapitalVoucher(@ModelAttribute CapitalVoucherREQ req, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        final List<Map<String,Object>> list = financeService.listCapitalVoucher(req);
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(list);
        return buildSuccJson(pageInfo);
    }

    @ApiOperation(value = "经费预算执行数值")
    @GetMapping(value = "/getBudgetaryFunds")
    @LoggerManage("经费预算执行数值")
    public JsonResult getBudgetaryFunds(FinanceREQ req) {
        return buildSuccJson(financeService.getBudgetaryFunds(req));
    }

    @ApiOperation(value = "各项目类型预算执行分析")
    @GetMapping(value = "/listBudgetProjectTypeExecute")
    @LoggerManage("各项目类型预算执行分析")
    public JsonResult listBudgetProjectTypeExecute(FinanceREQ req) {
        return buildSuccJson(financeService.listBudgetProjectTypeExecute(req));
    }

    @ApiOperation(value = "各责任单位预算执行分析")
    @GetMapping(value = "/listBudgetDepartmentExecute")
    @LoggerManage("各责任单位预算执行分析")
    public JsonResult listBudgetDepartmentExecute(FinanceREQ req) {
        return buildSuccJson(financeService.listBudgetDepartmentExecute(req));
    }

    @ApiOperation(value = "预算概况")
    @GetMapping(value = "/listBudgetDepartmentInfo")
    @LoggerManage("预算概况")
    public JsonResult listBudgetDepartmentInfo(FinanceREQ req) {
        return buildSuccJson(financeService.listBudgetDepartmentInfo(req));
    }

    @ApiOperation(value = "执行情况")
    @GetMapping(value = "/listBudgetImplement")
    @LoggerManage("执行情况")
    public JsonResult listBudgetImplement(FinanceREQ req) {
        return buildSuccJson(financeService.listBudgetImplement(req));
    }

    @ApiOperation(value = "实时收支分析收入金额")
    @GetMapping(value = "/listRealIncomeAmount")
    @LoggerManage("实时收支分析收入金额")
    public JsonResult listRealIncomeAmount(FinanceREQ req) {
        return buildSuccJson(financeService.listRealIncomeAmount(req));
    }

    @ApiOperation(value = "实时收支分析支出金额")
    @GetMapping(value = "/listRealPayAmount")
    @LoggerManage("实时收支分析支出金额")
    public JsonResult listRealPayAmount(FinanceREQ req) {
        return buildSuccJson(financeService.listRealPayAmount(req));
    }

    @ApiOperation(value = "实时收支分析支出金额列表")
    @GetMapping(value = "/listRealPayAmountlist")
    @LoggerManage("实时收支分析支出金额列表")
    public JsonResult listRealPayAmountlist(FinanceREQ req) {
        return buildSuccJson(financeService.listRealPayAmountlist(req));
    }

    @ApiOperation(value = "近五年收支概况")
    @GetMapping(value = "/listIncomePayByFiveYear")
    @LoggerManage("近五年收支概况")
    public JsonResult listIncomePayByFiveYear(FinanceREQ req) {
        return buildSuccJson(financeService.listIncomePayByFiveYear(req));
    }

    @ApiOperation(value = "历史收入结构")
    @GetMapping(value = "/listHistoryIncomeAmount")
    @LoggerManage("历史收入结构")
    public JsonResult listHistoryIncomeAmount(FinanceREQ req) {
        return buildSuccJson(financeService.listHistoryIncomeAmount(req));
    }

    @ApiOperation(value = "历史支出结构")
    @GetMapping(value = "/listHistoryPayAmount")
    @LoggerManage("历史支出结构")
    public JsonResult listHistoryPayAmount(FinanceREQ req) {
        return buildSuccJson(financeService.listHistoryPayAmount(req));
    }

    @ApiOperation(value = "实时收支金额统计值")
    @GetMapping(value = "/getRealIncomePayAmount")
    @LoggerManage("实时收支金额统计值")
    public JsonResult getRealIncomePayAmount(FinanceREQ req) {
        return buildSuccJson(financeService.getRealIncomePayAmount(req));
    }

}
