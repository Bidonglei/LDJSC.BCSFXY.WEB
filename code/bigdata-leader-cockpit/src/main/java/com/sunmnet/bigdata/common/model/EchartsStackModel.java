package com.sunmnet.bigdata.common.model;

import java.util.ArrayList;
import java.util.List;

import com.sunmnet.bigdata.web.enums.EchartSeriesEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("echart堆积图series数据")
public class EchartsStackModel
{
    @ApiModelProperty("堆积图数据项(图例)")
    private String name;
    
    @ApiModelProperty("堆积图柱子总称")
    private String stack;
    
    @ApiModelProperty("取值的列")
    private String valueColumn;
    
    @ApiModelProperty("数据集合")
    private List<Object> data = new ArrayList<Object>();
    
    public EchartsStackModel(EchartSeriesEnum seriesEnum)
    {
        this.name = seriesEnum.getName();
        this.valueColumn = seriesEnum.getColumnName();
    }
    
    public EchartsStackModel(EchartSeriesEnum seriesEnum, String stack)
    {
        this.name = seriesEnum.getName();
        this.valueColumn = seriesEnum.getColumnName();
        this.stack = stack;
    }
    
    public EchartsStackModel(String name, String nameColumn)
    {
        this.name = name;
        this.valueColumn = nameColumn;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getStack()
    {
        return stack;
    }
    
    public void setStack(String stack)
    {
        this.stack = stack;
    }
    
    public String getValueColumn()
    {
        return valueColumn;
    }
    
    public void setValueColumn(String valueColumn)
    {
        this.valueColumn = valueColumn;
    }
    
    public List<Object> getData()
    {
        return data;
    }
    
    public void setData(List<Object> data)
    {
        this.data = data;
    }
    
    public void addValue(Object obj)
    {
        this.data.add(obj);
    }
}
