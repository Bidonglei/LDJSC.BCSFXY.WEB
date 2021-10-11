package com.sunmnet.bigdata.web.service.home.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunmnet.bigdata.web.enums.SearchAgeEnum;
import com.sunmnet.bigdata.web.enums.SearchEnum;
import com.sunmnet.bigdata.web.mapper.home.SearchMapper;
import com.sunmnet.bigdata.web.model.request.home.SearchREQ;
import com.sunmnet.bigdata.web.model.response.home.CommonAgeRES;
import com.sunmnet.bigdata.web.model.response.home.CommonRES;
import com.sunmnet.bigdata.web.service.home.SearchService;

/**
 * 搜索框信息
 * <p>Title: SearchServiceImpl</p>
 * @author linjianlin  
 * @date 2018年9月7日
 */
@Service
public class SearchServiceImpl implements SearchService
{
    
    @Autowired
    private SearchMapper searchMapper;
    
    /**
     * 搜索框信息
     * <p>Title: listSearchBox</p>
     * @return
     */
    @Override
    public Map<String, Object> listSearchBox()
    {
        Map<String, Object> result = new HashMap<>();
        // 数据库取年和院校
        List<CommonRES> academy = searchMapper.listSearchBoxAcademy();
        List<CommonRES> yearList = searchMapper.listSearchBoxYear();
        List<CommonRES> schoolyearList = new ArrayList<>();
        // 处理前段显示
        for (CommonRES commonRES : yearList)
        {
            CommonRES common = new CommonRES();
            String school = commonRES.getName() + "-" + (Integer.parseInt(commonRES.getName()) + 1);
            common.setName(school + SearchEnum.SCHOOL_YEAR.getName());
            common.setValue(school);
            schoolyearList.add(common);
        }
        // 存入固定值
        // 放入学位4种
        SearchEnum[] degreeFour = {SearchEnum.UNDERGRADUATE, SearchEnum.MASTER, SearchEnum.DOCTOR, SearchEnum.ABROAD};
        // 放入学位3种
        SearchEnum[] degreeThree = {SearchEnum.UNDERGRADUATE, SearchEnum.MASTER, SearchEnum.DOCTOR};
        // 放入学位2种
        SearchEnum[] degreeTwo = {SearchEnum.UNDERGRADUATE, SearchEnum.MASTER};
        // 放入性别
        SearchEnum[] gender = {SearchEnum.GENDER_A, SearchEnum.GENDER_B};
        // 教师队伍-教师类别
        SearchEnum[] appointment = {SearchEnum.TEACHER_FULLTIME, SearchEnum.TEACHER_EXTERNAL};
        // 教学资源专业-专业类别
        SearchEnum[] majorCategory =
            {SearchEnum.MAJOR_PROVINCIAL, SearchEnum.MAJOR_NATIONAL_SPECIALTY, SearchEnum.MAJOR_NATIONAL_REFORM};
        // 高端人才类型
        SearchEnum[] talentType = {SearchEnum.TALENT_A, SearchEnum.TALENT_B};
        //年龄段搜索框
        SearchAgeEnum[] agefour = {SearchAgeEnum.AGE_A,SearchAgeEnum.AGE_B,SearchAgeEnum.AGE_C,
            SearchAgeEnum.AGE_D};
        
        result.put(SearchEnum.SCHOOL_YEAR.getValue(), schoolyearList);
        result.put(SearchEnum.GRADUATE_YEAR.getValue(), listToList(yearList, SearchEnum.GRADUATE_YEAR.getName()));
        result.put(SearchEnum.YEAR.getValue(), listToList(yearList, SearchEnum.YEAR.getName()));
        result.put(SearchEnum.DEGREE_FOUR.getValue(), newListCommonRES(degreeFour));
        result.put(SearchEnum.DEGREE_THREE.getValue(), newListCommonRES(degreeThree));
        result.put(SearchEnum.DEGREE_TWO.getValue(), newListCommonRES(degreeTwo));
        result.put(SearchEnum.GENDER.getValue(), newListCommonRES(gender));
        result.put(SearchEnum.ACADEMY.getName(), academy);
        result.put(SearchEnum.APPOINTMENT_TYPE.getValue(), newListCommonRES(appointment));
        result.put(SearchEnum.MAJOR_CATEGORY.getValue(), newListCommonRES(majorCategory));
        result.put(SearchEnum.TALENT.getValue(), newListCommonRES(talentType));
        result.put(SearchAgeEnum.AGE.getValue(), newListCommonAgeRES(agefour));
        return result;
    }
    
    /**
     * 手动添加搜索框内容
     * <p>Title: newListCommonRES</p>
     * @param searchEnums
     * @return
     */
    private final List<CommonRES> newListCommonRES(SearchEnum[] searchEnums)
    {
        List<CommonRES> list = new ArrayList<>();
        for (SearchEnum searchEnum : searchEnums)
        {
            CommonRES commonRES = new CommonRES();
            commonRES.setName(searchEnum.getName());
            commonRES.setValue(searchEnum.getValue());
            list.add(commonRES);
        }
        return list;
    }
    
    /**
     * 手动添加年龄段搜索框内容
     * newListCommonAgeRES
     * @param SearchAgeEnum
     * @return
     */
    private final List<CommonAgeRES> newListCommonAgeRES(SearchAgeEnum[] enums)
    {
        List<CommonAgeRES> list = new ArrayList<>();
        for (SearchAgeEnum searchAgeEnum : enums)
        {
            CommonAgeRES commonAgeRES = new CommonAgeRES();
            commonAgeRES.setName(searchAgeEnum.getName());
            commonAgeRES.setValue(searchAgeEnum.getValue());
            commonAgeRES.setValueTwo(searchAgeEnum.getValueTwo());
            list.add(commonAgeRES);
        }
        return list;
    }
    /**
     * 处理前段显示
     * <p>Title: listToList</p>
     * @param list
     * @param name
     * @return
     */
    private final List<CommonRES> listToList(List<CommonRES> list, String name)
    {
        List<CommonRES> result = new ArrayList<>();
        // 循环改变一个值
        for (CommonRES commonRES : list)
        {
            CommonRES common = new CommonRES();
            common.setName(commonRES.getName() + name);
            common.setValue(commonRES.getValue());
            result.add(common);
        }
        return result;
    }
    
    /**
     * 搜索框信息-专业
     * <p>Title: listSearchBoxMajor</p>
     * @param searchREQ
     * @return
     */
    @Override
    public List<CommonRES> listSearchBoxMajor(SearchREQ searchREQ)
    {
        return searchMapper.listSearchBoxMajor(searchREQ);
    }
    
    /**
     * 搜索框信息-班级
     * <p>Title: listSearchBoxClass</p>
     * @param searchREQ
     * @return
     */
    @Override
    public List<CommonRES> listSearchBoxClass(SearchREQ searchREQ)
    {
        return searchMapper.listSearchBoxClass(searchREQ);
    }
    
}
