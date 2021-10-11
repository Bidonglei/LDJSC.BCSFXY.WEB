package com.sunmnet.bigdata.web.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;

import com.sunmnet.bigdata.common.model.EchartsSeriesModel;
import com.sunmnet.bigdata.common.model.EchartsStackModel;
import com.sunmnet.bigdata.web.enums.EchartSeriesEnum;
import com.sunmnet.bigdata.web.enums.RadarIndicatorEnum;
import com.sunmnet.bigdata.web.enums.VerticalTableEnum;

/**  
* @ClassName: EchartsUtil  
* @Description: echarts图表数据处理
* @author lenovo  
* @date 2018年8月28日    
*/
public final class EchartsUtil
{
    
    private EchartsUtil()
    {
    }
    
    /**  
     * @Title: list2SeriesDatas  
     * @Description: 返回结果-横表 转换为柱状图数据，多系列数据
     * @param list-原始数据集合
     * @param xData-横坐标列
     * @param series--series数据集,每个图例对应得数据
     * @param @return
     * @return Map<String,Object>
     * @throws  
     */
    public static Map<String, Object> list2SeriesDatas(List<Map<String, String>> list, String xData,
        List<EchartsSeriesModel> series)
    {
        if (CollectionUtils.isEmpty(list))
        {
            return Collections.emptyMap();
        }
        Map<String, Object> chartData = new HashMap<String, Object>();
        // X轴数据集
        List<String> xaxis = new ArrayList<String>(list.size());
        for (Map<String, String> map : list)
        {
            // 坐标轴名称
            xaxis.add(map.get(xData));
            // 获取每个图例数据集合
            for (EchartsSeriesModel seriesModel : series)
            {
                seriesModel.addSeriesData(map.get(seriesModel.getColumnName()));
            }
        }
        chartData.put("xaxisData", xaxis);
        chartData.put("seriesData", series);
        return chartData;
    }
    
    /**  
    * @Title: list2SeriesData  
    * @Description: 返回结果-横表 转换为柱状图数据-单系列数据
    * @param list
    * @param xData
    * @param series
    * @return Map<String,Object>
    * @throws  
    */
    public static Map<String, Object> list2SeriesData(List<Map<String, String>> list, String xData,
        EchartsSeriesModel series)
    {
        if (CollectionUtils.isEmpty(list))
        {
            return Collections.emptyMap();
        }
        Map<String, Object> chartData = new HashMap<String, Object>();
        // X轴数据集
        List<String> xaxis = new ArrayList<String>(list.size());
        for (Map<String, String> map : list)
        {
            xaxis.add(map.get(xData));
            series.addSeriesData(map.get(series.getColumnName()));
        }
        List<EchartsSeriesModel> seriesData = new ArrayList<EchartsSeriesModel>(1);
        seriesData.add(series);
        chartData.put("xaxisData", xaxis);
        chartData.put("seriesData", seriesData);
        return chartData;
    }
    
    /**  
    * @Title: listMapToSeriesData  
    * @Description: 竖表数据集合转换为图表数据，单线/单柱状图数据
    * @param list
    * @param series
    * @return Map<String,Object>
    * @throws  
    */
    public static Map<String, Object> listMapToSeriesData(List<Map<String, String>> list, VerticalTableEnum series)
    {
        if (CollectionUtils.isEmpty(list))
        {
            return Collections.emptyMap();
        }
        Map<String, Object> chartData = new HashMap<String, Object>();
        List<String> xaxis = new ArrayList<String>(list.size());
        List<Object> yaxis = new ArrayList<Object>(list.size());
        for (Map<String, String> map : list)
        {
            xaxis.add(map.get(series.getXaxisCol()).toString());
            yaxis.add(map.get(series.getYaxisCol()));
        }
        chartData.put("xaxisData", xaxis);
        chartData.put("seriesData", yaxis);
        return chartData;
    }
    
    /**  
    * @Title: listMapToRaDarData  
    * @Description: List<Map> 横表数据转换为雷达图数据
    * @param list-横表数据集合
    * @param seriesCol -区分雷达系列的字段
    * @param mappers-每个轴名称、字段、最大值映射关系
    * @return Map<String,Object>
    * @throws  
    */
    public static Map<String, Object> listMapToRaDarData(List<Map<String, String>> list, String seriesCol,
        RadarIndicatorEnum[] mappers)
    {
        if (CollectionUtils.isEmpty(list))
        {
            return Collections.emptyMap();
        }
        
        // 处理雷达图折线图数据
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>(list.size());
        // 每一条折线图数据对象
        Map<String, Object> dataMap = null;
        // 折线图数据
        List<Object> value = null;
        for (Map<String, String> map : list)
        {
            dataMap = new HashMap<String, Object>(2);
            value = new ArrayList<Object>(mappers.length);
            for (RadarIndicatorEnum mapper : mappers)
            {
                value.add(map.get(mapper.getColumn()));
                // 判断各个维度的最大值max
                if (map.get(mapper.getColumn()) != null
                    && Double.parseDouble(map.get(mapper.getColumn())) > Double.parseDouble(mapper.getMax()))
                {
                    mapper.setMax(map.get(mapper.getColumn()));
                }
            }
            dataMap.put("value", value);
            // 折线图分类名称
            dataMap.put("name", map.get(seriesCol));
            data.add(dataMap);
        }
        // 存储indicator
        List<Map<String, String>> indicator = new ArrayList<Map<String, String>>(mappers.length);
        Map<String, String> indicatorMap = null;
        for (RadarIndicatorEnum mapper : mappers)
        {
            indicatorMap = new HashMap<String, String>(2);
            indicatorMap.put("name", mapper.getName());
            indicatorMap.put("max", mapper.getMax());
            indicator.add(indicatorMap);
        }
        Map<String, Object> radar = new HashMap<String, Object>(2);
        radar.put("indicator", indicator);
        radar.put("data", data);
        return radar;
    }
    
    /**  
    * @Title: listMapToRaDarData  
    * @Description: 两列竖表集合数据转换单条雷达图
    * @param list
    * @param tableEnum雷达轴和值的对应关系
    * @return Map<String,Object>
    * @throws  
    */
    public static Map<String, Object> listMapToRaDarData(List<Map<String, String>> list, VerticalTableEnum tableEnum)
    {
        if (CollectionUtils.isEmpty(list))
        {
            return Collections.emptyMap();
        }
        // 存储indicator
        List<Map<String, String>> indicator = new ArrayList<Map<String, String>>(list.size());
        List<String> value = new ArrayList<String>(list.size());
        Map<String, String> indicatorMap = null;
        String max = "0";
        for (Map<String, String> map : list)
        {
            indicatorMap = new HashMap<String, String>();
            // 设置轴名称
            indicatorMap.put("name", map.get(tableEnum.getXaxisCol()));
            indicator.add(indicatorMap);
            // 轴对应的数据
            String data = map.get(tableEnum.getYaxisCol());
            value.add(data);
            // 读取最大值
            if ((data != null) && (Double.parseDouble(data) > Double.parseDouble(max)))
            {
                max = data;
            }
        }
        // 取最大值作为所有轴的max，主要针对同一单位的
        for (Map<String, String> iMap : indicator)
        {
            iMap.put("max", max);
        }
        Map<String, Object> radarData = new HashMap<String, Object>(2);
        radarData.put("indicator", indicator);
        radarData.put("value", value);
        return radarData;
    }
    
    /**  
    * @Title: toStackBarData  
    * @Description: 多系列堆积图转换，
    * 将不同系列的数据按按照系列名称（柱子的名称）对数据就行分组后执行
    * @param map 分组后的存放各个柱子数据集合的map
    * @param enums 图例和取值的列对应关系
    * @param axisCol 坐标轴的列
    * @return Map<String,Object>
    * @throws  
    */
    public static Map<String, Object> toStackBarData(Map<String, List<Map<String, String>>> map,
        EchartSeriesEnum[] enums, String axisCol)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        Iterator<Entry<String, List<Map<String, String>>>> it = map.entrySet().iterator();
        // 所有柱子的数据集合
        List<EchartsStackModel> series = new ArrayList<EchartsStackModel>();
        // 坐标轴
        List<String> axis = new ArrayList<String>();
        // 取坐标轴集合的标志，只需一次后置为false
        boolean isNeed = true;
        // 遍历获取每个柱子数据集合
        while (it.hasNext())
        {
            Entry<String, List<Map<String, String>>> entry = it.next();
            // key作为数据集的stack
            String key = entry.getKey();
            // 遍历数据集合，组成每一个柱子的数据
            List<Map<String, String>> list = entry.getValue();
            // 利用enums 转换一个存放堆积图数据的对象集合
            List<EchartsStackModel> stacks = getStacks(enums, key);
            for (Map<String, String> map2 : list)
            {
                // 从每一行数据获取所有图例代表的数据
                for (EchartsStackModel stack : stacks)
                {
                    stack.addValue(map2.get(stack.getValueColumn()));
                }
                if (isNeed)
                {
                    axis.add(map2.get(axisCol));
                }
            }
            // 坐标轴取值后置为false，下次不再取值
            isNeed = false;
            // 完成一个系列所有柱子的图例数据
            series.addAll(stacks);
        }
        result.put("axis", axis);
        result.put("series", series);
        return result;
    }
    
    /**  
    * @Title: mapToSingleSeries  
    * @Description: 一行map数据转为一个柱状图或一折线图
    * @param map
    * @param enums 坐标轴和值得对应关系 顺序决定了坐标轴得顺序
    * @return Map<String,Object>
    * @throws  
    */
    public static Map<String, Object> mapToSingleSeries(Map<String, String> map, EchartSeriesEnum[] enums)
    {
        if (map == null || map.isEmpty())
        {
            return Collections.emptyMap();
        }
        Map<String, Object> result = new HashMap<String, Object>(2);
        List<String> xaxis = new ArrayList<String>();
        List<String> yaxis = new ArrayList<String>();
        for (EchartSeriesEnum ese : enums)
        {
            // 坐标轴名称
            xaxis.add(ese.getName());
            // 对应得值
            yaxis.add(map.get(ese.getColumnName()));
        }
        result.put("xaxisData", xaxis);
        result.put("seriesData", yaxis);
        return result;
    }
    
    /**  
    * @Title: getStacks  
    * @Description: 组装EchartsStackModel对象
    * @param enums
    * @param stack
    * @return List<EchartsStackModel>
    * @throws  
    */
    private static List<EchartsStackModel> getStacks(EchartSeriesEnum[] enums, String stack)
    {
        List<EchartsStackModel> list = new ArrayList<EchartsStackModel>(enums.length);
        for (EchartSeriesEnum echartSeriesEnum : enums)
        {
            EchartsStackModel model = new EchartsStackModel(echartSeriesEnum, stack);
            list.add(model);
        }
        return list;
    }
    
}
