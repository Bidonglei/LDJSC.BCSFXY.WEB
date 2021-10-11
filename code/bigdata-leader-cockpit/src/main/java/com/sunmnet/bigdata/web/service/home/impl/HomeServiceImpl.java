package com.sunmnet.bigdata.web.service.home.impl;

import com.sunmnet.bigdata.web.mapper.home.HomeMapper;
import com.sunmnet.bigdata.web.service.home.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeMapper homeMapper;

    @Override
    public List<Map<String, Object>> listIndexHomePage() {
        List<Map<String, Object>> result = homeMapper.listIndexHomePage();
        boolean judge = false;
        List<Map<String, Object>> list = null;
        Map<String, Object> mapNew = null;
        for (int i = 0; i < result.size(); i++) {
            Map<String, Object> map = result.get(i);
            Object rollingMark = map.get("rollingMark");
            if(null != rollingMark && (int)rollingMark == 1){
                if(!judge){
                    mapNew = new HashMap<>();
                    list = new ArrayList<>();
                }
                list.add(map);
                mapNew.put("leftRight",map.get("leftRight"));
                result.remove(i);
                i -= 1;
                judge = true;
            }else if(judge){
                mapNew.put("list",list);
                result.add(i,mapNew);
                i += 1;
                judge = false;
            }
        }
        return result;
    }
}
