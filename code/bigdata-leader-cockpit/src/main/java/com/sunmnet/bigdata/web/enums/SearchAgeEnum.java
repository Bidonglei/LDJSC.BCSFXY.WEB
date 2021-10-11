package com.sunmnet.bigdata.web.enums;

public enum SearchAgeEnum {

    //搜索框文字对应
    AGE("年龄段","agefour",""),
    AGE_A("35岁及以下","0","35"),
    AGE_B("36岁-45岁","36","45"),
    AGE_C("46岁-55岁","46","55"),
    AGE_D("56岁及以上","56","200")
    ;
    
    private SearchAgeEnum(String name, String value, String valueTwo)
    {
        this.name = name;
        this.value = value;
        this.valueTwo = valueTwo;
    }

    private String name;

    private String value;
    
    private String valueTwo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueTwo()
    {
        return valueTwo;
    }

    public void setValueTwo(String valueTwo)
    {
        this.valueTwo = valueTwo;
    }
    
    
}
