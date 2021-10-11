package com.sunmnet.bigdata.web.mapper.finance;

import com.sunmnet.bigdata.web.model.request.finance.CapitalVoucherREQ;
import com.sunmnet.bigdata.web.model.request.finance.FinanceREQ;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
/**
 * @Description 财务域
 * @author linjl
 * @date 2019/5/14
 */
public interface FinanceMapper {

    /**
     * @Description 资金余额情况表
     * @author linjl
     * @date 2019/5/14
     */
    List<Map<String, Object>> listCapitalBalance(FinanceREQ req);

    /**
     * @Description 资金变动凭证列表
     * @author linjl
     * @date 2019/5/14
     */
    List<Map<String, Object>> listCapitalVoucher(CapitalVoucherREQ req);

    /**
     * @Description 经费预算执行数值
     * @author linjl
     * @date 2019/5/14
     */
    Map<String, Object> getBudgetaryFunds(FinanceREQ req);

    /**
     * @Description 各项目类型预算执行分析
     * @author linjl
     * @date 2019/5/14
     */
    List<Map<String, Object>> listBudgetProjectTypeExecute(FinanceREQ req);

    /**
     * @Description 各责任单位预算执行分析
     * @author linjl
     * @date 2019/5/14
     */
    List<Map<String, Object>> listBudgetDepartmentExecute(FinanceREQ req);

    /**
     * @Description 预算概况
     * @author linjl
     * @date 2019/5/14
     */
    List<Map<String, Object>> listBudgetDepartmentInfo(FinanceREQ req);

    /**
     * @Description 执行情况
     * @author linjl
     * @date 2019/5/14
     */
    List<Map<String, Object>> listBudgetImplement(FinanceREQ req);

    /**
     * @Description 实时收支金额统计值
     * @author linjl
     * @date 2019/5/15
     */
    Map<String, Object> getRealIncomePayAmount(FinanceREQ req);
    /**
     * @Description 实时收支分析收入金额
     * @author linjl
     * @date 2019/5/15
     */
    List<Map<String, Object>> listRealIncomeAmount(FinanceREQ req);

    /**
     * @Description 实时收支分析支出金额
     * @author linjl
     * @date 2019/5/15
     */
    List<Map<String, Object>> listRealPayAmount(FinanceREQ req);

    /**
     * @Description 实时收支分析支出金额列表:总值
     * @author linjl
     * @date 2019/5/15
     */
    BigDecimal getSumRealPayAmount(FinanceREQ req);

    /**
     * @Description 近五年收支概况
     * @author linjl
     * @date 2019/5/15
     */
    List<Map<String, Object>> listIncomePayByFiveYear(FinanceREQ req);

    /**
     * @Description 历史收入结构
     * @author linjl
     * @date 2019/5/15
     */
    List<Map<String, Object>> listHistoryIncomeAmount(FinanceREQ req);

    /**
     * @Description 历史支出结构
     * @author linjl
     * @date 2019/5/15
     */
    List<Map<String, Object>> listHistoryPayAmount(FinanceREQ req);

}
