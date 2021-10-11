package com.sunmnet.bigdata.common.model;

import java.util.ArrayList;
import java.util.List;

import com.sunmnet.bigdata.web.enums.EchartSeriesEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("eharts series系列数据")
public class EchartsSeriesModel
{
    @ApiModelProperty("系列名称")
    private String name;
    
    @ApiModelProperty("取值的列")
    private String columnName;
    
    @ApiModelProperty("系列数据")
    private List<Object> data = new ArrayList<Object>();
    
    public String getName()
    {
        return name;
    }
    
    public EchartsSeriesModel(String name, String columnName)
    {
        this.name = name;
        this.columnName = columnName;
    }
    public EchartsSeriesModel(EchartSeriesEnum series)
    {
        this.name = series.getName();
        this.columnName = series.getColumnName();
    }
    
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getColumnName()
    {
        return columnName;
    }
    
    public void setColumnName(String columnName)
    {
        this.columnName = columnName;
    }
    
    public List<Object> getData()
    {
        return data;
    }
    
    public void setData(List<Object> data)
    {
        this.data = data;
    }
    
    public void addSeriesData(Object obj)
    {
        this.data.add(obj);
    }
}
