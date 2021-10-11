package com.sunmnet.bigdata.web.service.finance.impl;

import com.sunmnet.bigdata.web.mapper.finance.FinanceMapper;
import com.sunmnet.bigdata.web.model.request.finance.CapitalVoucherREQ;
import com.sunmnet.bigdata.web.model.request.finance.FinanceREQ;
import com.sunmnet.bigdata.web.service.finance.FinanceService;
import com.sunmnet.bigdata.web.util.CommonUtils;
import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FinanceServiceImpl implements FinanceService {

    @Autowired
    private FinanceMapper financeMapper;


    @Override
    public List<Map<String, Object>> listCapitalBalance(FinanceREQ req) {
        return financeMapper.listCapitalBalance(req);
    }

    @Override
    public List<Map<String, Object>> listCapitalVoucher(CapitalVoucherREQ req) {
        return financeMapper.listCapitalVoucher(req);
    }

    @Override
    public Map<String, Object> getBudgetaryFunds(FinanceREQ req) {
        return financeMapper.getBudgetaryFunds(req);
    }

    @Override
    public List<Map<String, Object>> listBudgetProjectTypeExecute(FinanceREQ req) {
        return financeMapper.listBudgetProjectTypeExecute(req);
    }

    @Override
    public List<Map<String, Object>> listBudgetDepartmentExecute(FinanceREQ req) {
        return financeMapper.listBudgetDepartmentExecute(req);
    }

    @Override
    public List<Map<String, Object>> listBudgetDepartmentInfo(FinanceREQ req) {
        return financeMapper.listBudgetDepartmentInfo(req);
    }

    @Override
    public List<Map<String, Object>> listBudgetImplement(FinanceREQ req) {
        return financeMapper.listBudgetImplement(req);
    }

    @Override
    public List<Map<String, Object>> listRealIncomeAmount(FinanceREQ req) {
        return financeMapper.listRealIncomeAmount(req);
    }

    @Override
    public List<Map<String, Object>> listRealPayAmount(FinanceREQ req) {
        return getNestingList(financeMapper.listRealPayAmount(req));
    }

    /**
     * @Description 将列表数据装换成嵌套list数据
     * @author linjl
     * @date 2019/5/15
     */
    private List<Map<String,Object>> getNestingList(List<Map<String,Object>> list){
        if(list == null){
            return null;
        }
        Map<String,Object> map1 = null;
        Map<String,Object> map2 = null;
        Map<String,Object> map3 = null;
        List<Map<String,Object>> mapList1 = null;
        List<Map<String,Object>> mapList2 = null;
        List<Map<String,Object>> result = new ArrayList<>();
        for (Map<String,Object> map : list) {
            //获取key对应值
            String one = (String) map.get("one");
            String two = (String) map.get("two");
            String three = (String) map.get("three");
            Object value = map.get("value");
            //判断key第一次出现
            if(map1 != null && map1.containsValue(one)) {
                //第一次之后加入相同的key的值
                if(two != null && three == null){
                    //判断第二层多个值,第三层没值
                    map2 = new HashMap<>();
                    map2.put("name", two);
                    map2.put("value", value);
                    mapList1.add(map2);
                }
                if(three != null){
                    //将第三层的值存入,并放入第二层
                    map3 = new HashMap<>();
                    map3.put("name", three);
                    map3.put("value", value);
                    mapList2.add(map3);
                    map2.put("list", mapList2);
                }
            }else {
                //第一次不存在则存入
                map1 = new HashMap<>();
                mapList1 = new ArrayList<>();
                map1.put("name", one);
                if(two == null){
                    map1.put("value", value);
                }else if(two != null && three == null){
                    //判断第二层多个值,第三层没值
                    map2 = new HashMap<>();
                    map2.put("name", two);
                    map2.put("value", value);
                    mapList1.add(map2);
                }else{
                    //判断第二层多个值,第三层有值
                    map2 = new HashMap<>();
                    mapList2 = new ArrayList<>();
                    map2.put("name", two);
                    map2.put("list", mapList2);
                    mapList1.add(map2);
                }
                if(three != null){
                    //将第三层的值存入,并放入第二层
                    map3 = new HashMap<>();
                    map3.put("name", three);
                    map3.put("value", value);
                    mapList2.add(map3);
                    map2.put("list", mapList2);
                }
                //将map装入list
                map1.put("list", mapList1);
                result.add(map1);
            }
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> listRealPayAmountlist(FinanceREQ req) {
        BigDecimal sumValue = financeMapper.getSumRealPayAmount(req);
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> tmpMap1 = null;
        Map<String, Object> tmpMap2 = null;
        BigDecimal tmpValue = null;
        String tmpOne = null;
        String tmpTwo = null;
        for (Map<String, Object> map : financeMapper.listRealPayAmount(req)) {
            String one = (String) map.get("one");
            String two = (String) map.get("two");
            BigDecimal value = CommonUtils.getBigDecimal(map.get("value"));
            //判断非空
            if(null == value) {
                map.put("ratio", new BigDecimal("0"));
            }else{
                map.put("ratio", value.divide(sumValue,4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP));
            }
            //判断一级标题第一次出现
            if (map.containsValue(tmpOne)) {
                if(null == tmpMap1){
                    tmpMap1 = new HashMap<>();
                }
                if(null == tmpMap2 && map.containsValue(tmpTwo)){
                    tmpMap2 = new HashMap<>();
                }else if(null != tmpMap2 && !map.containsValue(tmpTwo)){
                    //将二级标题的小计加入
                    tmpMap2.put("one", one);
                    tmpMap2.put("two", tmpTwo);
                    tmpMap2.put("three", "小计");
                    tmpMap2.put("value", tmpValue.setScale(2, BigDecimal.ROUND_HALF_UP));
                    tmpMap2.put("ratio", tmpValue.divide(sumValue,4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP));
                    result.add(tmpMap2);
                    tmpMap2 = null;
                }else if(!map.containsValue(tmpTwo)){
                    tmpTwo = two;
                }
                tmpValue = tmpValue.add(value);
                result.add(map);
            } else {
                if(null != tmpMap1){
                    //将一级标题的小计加入
                    tmpMap1.put("one", tmpOne);
                    tmpMap1.put("two", "小计");
                    tmpMap1.put("value", tmpValue.setScale(2, BigDecimal.ROUND_HALF_UP));
                    tmpMap1.put("ratio", tmpValue.divide(sumValue,4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP));
                    result.add(tmpMap1);
                    tmpMap1 = null;
                }
                tmpValue = value;
                tmpOne = one;
                result.add(map);
            }
        }
        result.add(Maps.newHashMap("sumValue",sumValue));
        return result;
    }

    @Override
    public List<Map<String, Object>> listIncomePayByFiveYear(FinanceREQ req) {
        return financeMapper.listIncomePayByFiveYear(req);
    }

    @Override
    public List<Map<String, Object>> listHistoryIncomeAmount(FinanceREQ req) {
        if(CommonUtils.getCurrentYear().equals(req.getYear())){
            req.setYear("1");
        }
        return financeMapper.listHistoryIncomeAmount(req);
    }

    @Override
    public List<Map<String, Object>> listHistoryPayAmount(FinanceREQ req) {
        if(CommonUtils.getCurrentYear().equals(req.getYear())){
            req.setYear("1");
        }
        return getNestingList(financeMapper.listHistoryPayAmount(req));
    }

    @Override
    public Map<String, Object> getRealIncomePayAmount(FinanceREQ req) {
        return financeMapper.getRealIncomePayAmount(req);
    }
}
