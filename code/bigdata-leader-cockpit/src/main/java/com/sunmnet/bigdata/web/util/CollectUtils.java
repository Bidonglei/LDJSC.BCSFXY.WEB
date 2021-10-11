package com.sunmnet.bigdata.web.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

/**  
* @ClassName: CollectUtils  
* @Description: TODO
* @author lenovo  
* @date 2018年9月3日    
*/
public final class CollectUtils
{
    private CollectUtils()
    {
    }
    
    /**  
    * @Title: map2List  
    * @Description: 返回结果map转list
    * @param map
    * @return List<Map<String,Object>>
    * @throws  
    */
    public static List<Map<String, Object>> map2List(Map<?, ?> map)
    {
        List<Map<String, Object>> result = new ArrayList<>();
        Iterator<?> it = map.entrySet().iterator();
        while (it.hasNext())
        {
            Entry<?, ?> entry = (Entry<?, ?>)it.next();
            Map<String, Object> m = new HashMap<String, Object>();
            m.put("name", entry.getKey());
            m.put("value", entry.getValue());
            result.add(m);
        }
        return result;
    }
    
    /**  
    * @Title: map2List  
    * @Description: map转换为固定键的List<Map<>> 横表转竖表list
    * @param map
    * @param nameKey  存放键的key
    * @param valueKey 存放值得key
    * @return List<Map<String,Object>>
    * @throws  
    */
    public static List<Map<String, Object>> map2List(Map<?, ?> map, final String nameKey, final String valueKey)
    {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        Iterator<?> it = map.entrySet().iterator();
        while (it.hasNext())
        {
            Entry<?, ?> entry = (Entry<?, ?>)it.next();
            Map<String, Object> m = new HashMap<String, Object>();
            m.put(nameKey, entry.getKey());
            m.put(valueKey, entry.getValue());
            result.add(m);
        }
        return result;
    }
    
    /**  
    * @Title: map2ListByCode  
    * @Description: 返回结果集对应码表转换名称
    * @param map
    * @param code
    * @return List<Map<String,String>>
    * @throws  
    */
    public static List<Map<String, String>> map2ListByCode(Map<?, ?> map, Map<?, ?> code)
    {
        List<Map<String, String>> result = new ArrayList<>();
        Iterator<?> it = map.entrySet().iterator();
        while (it.hasNext())
        {
            Entry<?, ?> entry = (Entry<?, ?>)it.next();
            Map<String, String> m = new HashMap<String, String>();
            m.put("name", code.get(entry.getKey()).toString());
            m.put("value", entry.getValue().toString());
            result.add(m);
        }
        return result;
    }
    
    /**  
    * @Title: replaceColumnByCode  
    * @Description: 用码表的值替换map中的code码
    * @param list
    * @param replaceColumn
    * @param code
    * @return void
    * @throws  
    */
    public static void replaceColumnByCode(List<Map<String, String>> list, String replaceColumn, Map<?, ?> code)
    {
        Iterator<Map<String, String>> it = list.iterator();
        while (it.hasNext())
        {
            Map<String, String> map = it.next();
            String curCode = map.get(replaceColumn);
            map.put(replaceColumn, code.get(curCode).toString());
        }
    }
    
    /**  
    * @Title: sortListMapByOrder  
    * @Description: 根据key对List<map>按照排序方式进行排序
    * @param list
    * @param sortKey 排序的key
    * @param sortOrder 排序方式,默认升序  desc/asc
    * @return List<Map<String,Object>>
    * @throws  
    */
    public static void sortListMapByOrder(List<Map<String, Object>> list, String sortKey, String sortOrder)
    {
        String order = StringUtils.isBlank(sortOrder) ? "ASC" : sortOrder.toUpperCase();
        Collections.sort(list, new MapComparator(sortKey, order));
    }
    
    /**  
    * @ClassName: MapComparator  
    * @Description: 对map按照key和排序方式进行排序
    * @author lenovo  
    * @date 2018年9月3日    
    */
    private static class MapComparator implements Comparator<Map<String, Object>>
    {
        
        private String sortKey;
        
        private String order;
        
        private MapComparator(String sortKey, String order)
        {
            this.sortKey = sortKey;
            this.order = order;
        }
        
        @Override
        public int compare(Map<String, Object> o1, Map<String, Object> o2)
        {
            String value1 = o1.get(sortKey).toString();
            String value2 = o2.get(sortKey).toString();
            if (value1 != null && value2 != null)
            {
                switch (order)
                {
                    case "ASC":
                    {
                        return value1.compareTo(value2);
                    }
                    case "DESC":
                    {
                        return value2.compareTo(value1);
                    }
                    default:
                        break;
                }
            }
            return 0;
        }
        
    }
    
}
