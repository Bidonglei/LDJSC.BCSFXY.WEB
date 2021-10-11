package com.sunmnet.bigdata.web.util;

import java.util.HashMap;
import java.util.Map;

/**  
* @ClassName: CodeUtil  
* @Description: 码表配置
* @author lenovo  
* @date 2018年8月28日    
*/
public final class CodeUtil
{
    private CodeUtil()
    {
        
    }
    
    public static Map<String, String> getAgeRangeCode()
    {
        Map<String, String> map = new HashMap<String, String>(5);
        map.put("1", "35岁及以下");
        map.put("2", "36-45岁");
        map.put("3", "46-55岁");
        map.put("4", "56岁及以上");
        return map;
    }

    public static Map<String, String> getAgeRangeCodePerson()
    {
        Map<String, String> map = new HashMap<>(5);
        map.put("1", "35岁及以下");
        map.put("2", "36-45岁");
        map.put("3", "46-55岁");
        map.put("4", "56岁及以上");
        return map;
    }

    public static Map<Integer, String> getAssessmentType()
    {
        Map<Integer, String> map = new HashMap<>(5);
        map.put(1, "优秀");
        map.put(2, "称职");
        map.put(3, "基本称职");
        map.put(4, "不称职");
        return map;
    }



}
