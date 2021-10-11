package com.sunmnet.bigdata.web.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

import com.sunmnet.bigdata.common.model.EchartsSeriesModel;
import com.sunmnet.bigdata.web.enums.EchartSeriesEnum;

/**
 * 工具类
 * <p>Title: LinUtils</p>
 * @author linjianlin  
 * @date 2018年9月2日
 */
public final class CommonUtils {

    private CommonUtils() {
        
    }

    /**
     * @Description Object转BigDecimal类型
     * @param value 要转的object类型
     * @return 转成的BigDecimal类型数据
     * @author linjl
     * @date 2019/5/16
     */
    public static BigDecimal getBigDecimal(Object value) {
        BigDecimal ret = null;
        if (value != null) {
            if (value instanceof BigDecimal) {
                ret = (BigDecimal) value;
            } else if (value instanceof String) {
                ret = new BigDecimal((String) value);
            } else if (value instanceof BigInteger) {
                ret = new BigDecimal((BigInteger) value);
            } else if (value instanceof Number) {
                ret = new BigDecimal(((Number) value).doubleValue());
            } else {
                throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass() + " into a BigDecimal.");
            }
        }
        return ret;
    }
    
    /**
     * 获取当前时间的年份
     * @return
     */
    public static String getCurrentYear() {
        //获取当前时间
        Calendar c = Calendar.getInstance();
        //获取年,月
        int year = c.get(Calendar.YEAR);
        return year+"";
    }

    /**
     * 判断月份获取当前时间的年份
     * <p>Title: getNowYear</p>
     * @return
     */
    public static String getNowYear() {
        //获取当前时间
        Calendar c = Calendar.getInstance();
        //获取年,月
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        //判断当前时间大于8月则返回当前年,否则返回去年
        if(month>7){
            return year+"";
        }
        return year-1+"";
    }

    /**
     * 将ENUM集合装换成List<EchartsSeriesModel>
     * <p>Title: enumsToSeries</p>
     * @param enums
     * @return
     */
    public static List<EchartsSeriesModel> enumsToSeries(EchartSeriesEnum[] enums) {
        List<EchartsSeriesModel> series = new ArrayList<EchartsSeriesModel>(enums.length);
        //循环取出enum
        for (EchartSeriesEnum echartSeriesEnum : enums) {
            //将enum存入封装好的model中放入list
            series.add(new EchartsSeriesModel(echartSeriesEnum));
        }
        return series;
    }

    /**
     * @Description 根据字符串数组获取上四分位数,中位数和下四分位数
     * @author linjl
     * @date 2019/3/20
     */
    public static void getFourDivsion(String[] param,Map map) {
        // 转成BigDecimal类型，避免失去精度
        BigDecimal[] datas = new BigDecimal[param.length];
        for (int i = 0; i < param.length; i++) {
            datas[i] = new BigDecimal(param[i]);
        }
        if (param == null || param.length == 1){
            map.put("oneFourth",datas[0]);
            map.put("half",datas[0]);
            map.put("threeFourths",datas[0]);
            return;
        }
        if (param == null || param.length == 2){
            map.put("oneFourth",datas[0]);
            map.put("half",(datas[0].add(datas[1])).divide(new BigDecimal("2")));
            map.put("threeFourths",datas[1]);
            return;
        }
        int len = datas.length+1;// 数组长度
        Arrays.sort(datas);    // 数组排序，从小到大
        BigDecimal q1 = null;  // 第一四分位
        BigDecimal q2 = null;  // 第二四分位
        BigDecimal q3 = null;  // 第三四分位
        int index = 0; // 记录下标
        BigDecimal index1 = new BigDecimal(len).divide(new BigDecimal("4")); // (n+1)/4
        BigDecimal index3 = new BigDecimal(len).multiply(new BigDecimal("0.75")); // (n+1)*3/4
        BigDecimal dValue = null; // 小数部分
        if (len % 2 == 0) { // 奇数
            if(len%4 == 0){
                q1 = datas[index1.intValue()-1];
                q3 = datas[index3.intValue()-1];
            }else{
                index = index1.intValue();
                q1 = datas[index-1].add(datas[index]).divide(new BigDecimal("2"));
                index = index3.intValue();
                q3 = datas[index-1].add(datas[index]).divide(new BigDecimal("2"));
            }
            //中位数
            q2 = datas[len/2-1];
        } else { // 偶数
            //前四分位数:前一位*小数+后一位*(1-小数)
            index = index1.intValue(); // 取整数
            dValue = index1.subtract(new BigDecimal(index)); // 计算小数
            q1 = datas[index-1].multiply(BigDecimal.ONE.subtract(dValue)).add(datas[index].multiply(dValue));
            //中位数
            q2 = datas[len/2-1].add(datas[len/2]).divide(new BigDecimal("2"));
            //后四分位数:前一位*小数+后一位*(1-小数)
            index = index3.intValue();
            dValue = index3.subtract(new BigDecimal(index)); // 计算小数
            q3 = datas[index-1].multiply(BigDecimal.ONE.subtract(dValue)).add(datas[index].multiply(dValue));
        }
        // 保留两位小数（四舍五入）
        map.put("oneFourth",q1.setScale(2, BigDecimal.ROUND_HALF_UP));
        map.put("half",q2.setScale(2, BigDecimal.ROUND_HALF_UP));
        map.put("threeFourths",q3.setScale(2, BigDecimal.ROUND_HALF_UP));
    }

}
