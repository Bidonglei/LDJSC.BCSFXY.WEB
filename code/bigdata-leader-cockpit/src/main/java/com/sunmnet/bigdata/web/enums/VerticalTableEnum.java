package com.sunmnet.bigdata.web.enums;

/**  
* @ClassName: VerticalTableEnum  
* @Description: 竖表数据集合转换为图表数据，单线/单柱状图数据,X-Y轴对应关系
* @author lenovo  
* @date 2018年9月1日    
*/
public enum VerticalTableEnum
{
    // 实验技术人员-职称
    ASSISTANT_TITLE("job_title", "assistant_num"),
    // 教学设施-教学科研辅助用房情况
    TEACHING_FACILITIES_HOUSING("house_name", "house_area"),
    // 教学资源-教学设施-图书情况
    TEACHING_FACILITIES_BOOK("book_type", "number");
    
    // 柱状图/曲线图的X轴或雷达图的每个轴
    private String xaxisCol;
    
    // X轴对应的值
    private String yaxisCol;
    
    private VerticalTableEnum(String xaxisCol, String yaxisCol)
    {
        this.xaxisCol = xaxisCol;
        this.yaxisCol = yaxisCol;
    }
    
    public String getXaxisCol()
    {
        return xaxisCol;
    }
    
    public void setXaxisCol(String xaxisCol)
    {
        this.xaxisCol = xaxisCol;
    }
    
    public String getYaxisCol()
    {
        return yaxisCol;
    }
    
    public void setYaxisCol(String yaxisCol)
    {
        this.yaxisCol = yaxisCol;
    }
    
}
