package com.sunmnet.bigdata.web.service.teaching.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.sunmnet.bigdata.common.request.BasePageRequest;
import com.sunmnet.bigdata.web.enums.EchartSeriesEnum;
import com.sunmnet.bigdata.web.enums.SeriesNameEnum;
import com.sunmnet.bigdata.web.mapper.teaching.TeachingProcessMapper;
import com.sunmnet.bigdata.web.model.request.teaching.DoctorMoreThanYearsREQ;
import com.sunmnet.bigdata.web.model.request.teaching.TeachingProcessREQ;
import com.sunmnet.bigdata.web.model.response.teaching.DoctorMoreThanYearsRES;
import com.sunmnet.bigdata.web.service.teaching.TeachingProcessService;
import com.sunmnet.bigdata.web.util.CommonUtils;
import com.sunmnet.bigdata.web.util.EchartsUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeachingProcessServiceImpl implements TeachingProcessService {
    
    @Autowired
    private TeachingProcessMapper teachingProcessMapper;
    
    @Override
    public Map<String, Object> listProfessorTeachingSituation(TeachingProcessREQ req) {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Map<String, String>> list = null;
        if(StringUtil.isEmpty(req.getAnnual())){
        	req.setAnnual("2018-2019-春");
		}
        if(null != req.getType() && req.getType().equals("教授")){
            //获得list对象
            list = teachingProcessMapper.listProfessorTeachingSituation(req);
            //获取enum数组-坐标各个名称
            EchartSeriesEnum[] enums = {EchartSeriesEnum.PROFESSOR_CLASSRATE_A,EchartSeriesEnum.PROFESSOR_CLASSRATE_B,
                    EchartSeriesEnum.PROFESSOR_CLASSRATE_G
            };
            result.put("chartData", EchartsUtil.list2SeriesDatas(list, SeriesNameEnum.NAME.getName(), CommonUtils.enumsToSeries(enums)));
        }else{
            //获得list对象
            list = teachingProcessMapper.listAssociateTeachingSituation(req);
            //获取enum数组-坐标各个名称
            EchartSeriesEnum[] enums = {EchartSeriesEnum.PROFESSOR_CLASSRATE_C,EchartSeriesEnum.PROFESSOR_CLASSRATE_D,
                    EchartSeriesEnum.PROFESSOR_CLASSRATE_H
            };
            result.put("chartData", EchartsUtil.list2SeriesDatas(list, SeriesNameEnum.NAME.getName(), CommonUtils.enumsToSeries(enums)));
        }
        //调用转换数据格式方法
        return result;
    }

    @Override
    public List<Map<String, Object>> listProfessorTeachingHours(TeachingProcessREQ req) {
		if(StringUtil.isEmpty(req.getAnnual())){
			req.setAnnual("2018-2019-春");
		}
        return teachingProcessMapper.listProfessorTeachingHours(req);
    }

    @Override
    public List<Map<String, Object>> listUndergraduatesProgressCredit(TeachingProcessREQ req) {
        return teachingProcessMapper.listUndergraduatesProgressCredit(req);
    }

    @Override
    public List<Map<String, Object>> listUndergraduatesProgress(TeachingProcessREQ req) {
        return teachingProcessMapper.listUndergraduatesProgress(req);
    }

    @Override
    public List<Map<String, Object>> listMasterProgressCredit(TeachingProcessREQ req) {
        return teachingProcessMapper.listMasterProgressCredit(req);
    }

    @Override
    public List<Map<String, Object>> listMasterProgress(TeachingProcessREQ req) {
        return teachingProcessMapper.listMasterProgress(req);
    }

    @Override
    public Map<String, Object> getUndergraduateSchoolingYears() {
		Map<String, Object> resultInfo = new HashMap<>();
		//超过学习年限人数
		Map<String, Object> map = new HashMap<>();
		map.put("year",4);//超过四年
		map.put("educateGradation","本科");//本科生
		int total = teachingProcessMapper.getSchoolingYearsTotal(map);
		//学习年限情况
		List<Map<String, Object>> list = teachingProcessMapper.getUndergraduateSchoolingYears();
		resultInfo.put("total",total);
		resultInfo.put("list",list);
		return resultInfo;
    }

    @Override
    public Map<String, Object> getMasterSchoolingYears() {
		Map<String, Object> resultInfo = new HashMap<>();
		//超过学习年限人数
		Map<String, Object> map = new HashMap<>();
		map.put("year",3);//超过三年
		map.put("educateGradation","硕士");//硕士生
		int total = teachingProcessMapper.getSchoolingYearsTotal(map);
		//学习年限情况
		List<Map<String, Object>> list = teachingProcessMapper.getMasterSchoolingYears();
		resultInfo.put("total",total);
		resultInfo.put("list",list);
		return resultInfo;
    }

    @Override
    public Map<String, Object> getDoctorSchoolingYears() {
		Map<String, Object> resultInfo = new HashMap<>();
		//超过学习年限人数
		Map<String, Object> map = new HashMap<>();
		map.put("year",4);//超过四年
		map.put("educateGradation","博士");//博士生
		int total = teachingProcessMapper.getSchoolingYearsTotal(map);
		//学习年限情况
		List<Map<String, Object>> list = teachingProcessMapper.getDoctorSchoolingYears();
		resultInfo.put("total",total);
		resultInfo.put("list",list);
		return resultInfo;
    }

    @Override
    public List<Map<String, Object>> listUndergraduateThanFourYears() {
        return teachingProcessMapper.listUndergraduateThanFourYears();
    }

    @Override
    public List<Map<String, Object>> listMasterMoreThanYears() {
        return teachingProcessMapper.listMasterMoreThanYears();
    }

    @Override
    public List<Map<String, Object>> listDoctorMoreThanYears() {
        return teachingProcessMapper.listDoctorMoreThanYears();
    }

    @Override
    public List<Map<String, Object>> listUndergraduateRatioByGrade() {
        return teachingProcessMapper.listUndergraduateRatioByGrade();
    }

    @Override
    public List<Map<String, Object>> listUndergraduateRatioByAcademy(TeachingProcessREQ req) {
        return teachingProcessMapper.listUndergraduateRatioByAcademy(req);
    }

    @Override
    public List<Map<String, Object>> listDoctorRatioByAcademy(TeachingProcessREQ req) {
        req.setAnnual(CommonUtils.getNowYear());
        return teachingProcessMapper.listDoctorRatioByAcademy(req);
    }

    @Override
    public List<Map<String, Object>> listCourseContribution(TeachingProcessREQ req) {
        if(StringUtils.isBlank(req.getAnnual())){
            req.setAnnual(CommonUtils.getNowYear());
        }
        return teachingProcessMapper.listCourseContribution(req);
    }

    @Override
    public List<Map<String, Object>> listCourseOpenness(TeachingProcessREQ req) {
        if(StringUtils.isBlank(req.getAnnual())){
            req.setAnnual(CommonUtils.getNowYear());
        }
        return teachingProcessMapper.listCourseOpenness(req);
    }

    @Override
    public List<Map<String, Object>> listInnovativeTrainingProgram(TeachingProcessREQ req) {
        if(StringUtils.isBlank(req.getAnnual())){
            req.setAnnual("2018");
        }
        return teachingProcessMapper.listInnovativeTrainingProgram(req);
    }

    @Override
    public List<Map<String, Object>> listInnovativeTrainingProgramSector(TeachingProcessREQ req) {
        if(StringUtils.isBlank(req.getAnnual())){
            req.setAnnual("2018");
        }
        return teachingProcessMapper.listInnovativeTrainingProgramSector(req);
    }

    @Override
    public List<Map<String, Object>> listPeakExperienceProgram(TeachingProcessREQ req) {
        if(StringUtils.isBlank(req.getAnnual())){
            req.setAnnual("2018");
        }
        return teachingProcessMapper.listPeakExperienceProgram(req);
    }

    @Override
    public List<Map<String, Object>> listSelectedTopic(TeachingProcessREQ req) {
        if(StringUtils.isBlank(req.getAnnual())){
            req.setAnnual(CommonUtils.getCurrentYear());
        }
        return teachingProcessMapper.listSelectedTopic(req);
    }

    @Override
    public List<Map<String, Object>> listInterdisciplinaryTopic(TeachingProcessREQ req) {
        if(StringUtils.isBlank(req.getAnnual())){
            req.setAnnual(CommonUtils.getCurrentYear());
        }
        return teachingProcessMapper.listInterdisciplinaryTopic(req);
    }

    @Override
    public Map<String, Object> listThesisDefenseQuality(TeachingProcessREQ req) {
        if(StringUtils.isBlank(req.getAnnual())){
            req.setAnnual(CommonUtils.getCurrentYear());
        }
        Map<String, Object> result = new HashMap<String, Object>();
        //获得list对象
        List<Map<String, String>> listThesisDefenseQuality = teachingProcessMapper.listThesisDefenseQuality(req);
        //获取enum数组-坐标各个名称EchartSeriesEnum.THESIS_DEFENSE_QUALITY_D,
        EchartSeriesEnum[] enums = {EchartSeriesEnum.THESIS_DEFENSE_QUALITY_A,EchartSeriesEnum.THESIS_DEFENSE_QUALITY_B,
                EchartSeriesEnum.THESIS_DEFENSE_QUALITY_C,
                EchartSeriesEnum.THESIS_DEFENSE_QUALITY_E,EchartSeriesEnum.THESIS_DEFENSE_QUALITY_F,
                EchartSeriesEnum.THESIS_DEFENSE_QUALITY_G
        };
		//总的论文及答辩质量
		List<Map<String, String>> allData = teachingProcessMapper.thesisDefenseQualityAll(req);
		//调用转换数据格式方法
		result.put("chartData", EchartsUtil.list2SeriesDatas(listThesisDefenseQuality, SeriesNameEnum.NAME.getName(), CommonUtils.enumsToSeries(enums)));
		result.put("allData",allData);
		return result;
    }

    @Override
    public List<Map<String, Object>> listExcellentPostgraduateThesis(TeachingProcessREQ req) {
        if(StringUtils.isBlank(req.getAnnual())){
            req.setAnnual(CommonUtils.getCurrentYear());
        }
        //return getNestingList(teachingProcessMapper.listExcellentPostgraduateThesis(req));
        return teachingProcessMapper.listExcellentPostgraduateThesis(req);
    }

    /**
     * @Description 将列表数据装换成嵌套list数据
     * @author linjl
     * @date 2019/5/15
     */
    private List<Map<String,Object>> getNestingList(List<Map<String,Object>> list){
        if(list == null){
            return null;
        }
        Map<String,Object> map1 = null;
        Map<String,Object> map2 = null;
        Map<String,Object> map3 = null;
        List<Map<String,Object>> mapList1 = null;
        List<Map<String,Object>> mapList2 = null;
        List<Map<String,Object>> result = new ArrayList<>();
        for (Map<String,Object> map : list) {
            //获取key对应值
            String one = (String) map.get("one");
            String two = (String) map.get("two");
            String three = (String) map.get("three");
            Object value = map.get("value");
            //判断key第一次出现
            if(map1 != null && map1.containsValue(one)) {
                //第一次之后加入相同的key的值
                if(two != null && three == null){
                    //判断第二层多个值,第三层没值
                    map2 = new HashMap<>();
                    map2.put("name", two);
                    map2.put("value", value);
                    mapList1.add(map2);
                }
                if(three != null){
                    //将第三层的值存入,并放入第二层
                    map3 = new HashMap<>();
                    map3.put("name", three);
                    map3.put("value", value);
                    mapList2.add(map3);
                    map2.put("list", mapList2);
                }
            }else {
                //第一次不存在则存入
                map1 = new HashMap<>();
                mapList1 = new ArrayList<>();
                map1.put("name", one);
                if(two == null){
                    map1.put("value", value);
                }else if(two != null && three == null){
                    //判断第二层多个值,第三层没值
                    map2 = new HashMap<>();
                    map2.put("name", two);
                    map2.put("value", value);
                    mapList1.add(map2);
                }else{
                    //判断第二层多个值,第三层有值
                    map2 = new HashMap<>();
                    mapList2 = new ArrayList<>();
                    map2.put("name", two);
                    map2.put("list", mapList2);
                    mapList1.add(map2);
                }
                if(three != null){
                    //将第三层的值存入,并放入第二层
                    map3 = new HashMap<>();
                    map3.put("name", three);
                    map3.put("value", value);
                    mapList2.add(map3);
                    map2.put("list", mapList2);
                }
                //将map装入list
                map1.put("list", mapList1);
                result.add(map1);
            }
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> listAcademicPaperAchievements(TeachingProcessREQ req) {
        req.setAnnual(CommonUtils.getNowYear());
        return teachingProcessMapper.listAcademicPaperAchievements(req);
    }

	@Override
	public List<Map> masterThesisExcellent(String annual, String studentType) {
		return teachingProcessMapper.masterThesisExcellent(annual,studentType);
	}

	@Override
    public List<Map<String, Object>> listPostgraduateDegreeAward(TeachingProcessREQ req) {
        if(StringUtils.isBlank(req.getAnnual())){
            req.setAnnual(CommonUtils.getNowYear());
        }
        return teachingProcessMapper.listPostgraduateDegreeAward(req);
    }

	@Override
	public List<Map<String, Object>> undergraduateStuEva(String semesterYear,String studentType) {
		return teachingProcessMapper.undergraduateStuEva(semesterYear,studentType);
	}

	@Override
	public List<Map<String, Object>> undergraduateAcaStuEva(String semesterYear,String studentType) {
		return teachingProcessMapper.undergraduateAcaStuEva(semesterYear,studentType);
	}

	@Override
	public List<Map<String, Object>> academicAndScoreBoxLine(String semesterYear) {
		List<Map<String, Object>> list = teachingProcessMapper.academicAndScoreBoxLine(semesterYear);
		for (Map map : list) {
			//上四分位数，中位数，下四分位数
			String stringScore = (String)map.get("stringScore");
			CommonUtils.getFourDivsion(stringScore.split(","),map);
			map.remove("stringScore");
		}
		return list;
	}

	@Override
    public PageInfo<DoctorMoreThanYearsRES> listDoctorMoreThanYearsDetail(DoctorMoreThanYearsREQ req) {
        if (StringUtil.isNotEmpty(req.getSort()) && StringUtil.isNotEmpty(req.getOrder())){
            PageHelper.orderBy(req.getSort()+" "+req.getOrder());
        }
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<DoctorMoreThanYearsRES> list = teachingProcessMapper.listDoctorMoreThanYearsDetail(req);
        PageInfo<DoctorMoreThanYearsRES> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
