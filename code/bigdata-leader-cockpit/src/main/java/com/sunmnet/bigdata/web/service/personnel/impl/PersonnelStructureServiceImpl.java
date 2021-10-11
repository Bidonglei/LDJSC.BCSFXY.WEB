package com.sunmnet.bigdata.web.service.personnel.impl;

import com.sunmnet.bigdata.web.enums.EchartSeriesEnum;
import com.sunmnet.bigdata.web.enums.SeriesNameEnum;
import com.sunmnet.bigdata.web.mapper.personnel.PersonnelStructureMapper;
import com.sunmnet.bigdata.web.model.request.personnel.NewcomersREQ;
import com.sunmnet.bigdata.web.model.request.personnel.TeacherBoxREQ;
import com.sunmnet.bigdata.web.model.request.personnel.TeacherInfoREQ;
import com.sunmnet.bigdata.web.model.response.personnel.QueryAcademyAndSubjectResponse;
import com.sunmnet.bigdata.web.model.response.personnel.QueryStaffStructureResponse;
import com.sunmnet.bigdata.web.service.personnel.PersonnelStructureService;
import com.sunmnet.bigdata.web.util.CommonUtils;
import com.sunmnet.bigdata.web.util.EchartsUtil;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunmnet-gf
 * @ClassName: ${type_name}
 * @Description: ${todo}
 * @date 2018/12/26/026
 * ${tags}
 */
@Service
public class PersonnelStructureServiceImpl implements PersonnelStructureService {

    @Autowired
    private PersonnelStructureMapper personnelStructureMapper;

    @Override
    public Object listCountInfo(TeacherInfoREQ teacherInfoREQ) {
        return personnelStructureMapper.listCountInfo(teacherInfoREQ);
    }

	@Override
	public List<Map> personBigType() {
		Map<String, Object> numMap = new HashMap<>();
		//人员结构：各单位人数
//		numMap.put("teacherTypeBig","事业编制");//人员大类别：事业编制，非事业编制
		List<Map> departmentNum = personnelStructureMapper.departmentNum(numMap);
		for (Map m:departmentNum){
			Map<String, Object> typeMap = new HashMap<>();
			typeMap.put("departmentName",m.get("departmentName"));
			typeMap.put("total",m.get("total"));
			List<Map> studentGrade = personnelStructureMapper.getPersonBigType(typeMap);//各单位人员编制结构
			m.put("list",studentGrade);
		}
		return departmentNum;
	}

	@Override
	public List<Map> personAgeType() {
		Map<String, Object> numMap = new HashMap<>();
		//人员结构：各单位人数
		numMap.put("teacherTypeBig","事业编制");//人员大类别：事业编制，非事业编制
		List<Map> departmentNum = personnelStructureMapper.departmentNum(numMap);
		for (Map m:departmentNum){
			Map<String, Object> ageMap = new HashMap<>();
			ageMap.put("teacherTypeBig","事业编制");//人员大类别：事业编制，非事业编制
			ageMap.put("departmentName",m.get("departmentName"));
			ageMap.put("total",m.get("total"));
			List<Map> studentGrade = personnelStructureMapper.getAgeType(ageMap);//各单位年龄结构对比(事业编制)
			m.put("list",studentGrade);
		}
		return departmentNum;
	}

/*	@Override
	public List<Map> personSexType() {
		Map<String, Object> numMap = new HashMap<>();
		//人员结构：各单位人数
		numMap.put("teacherTypeBig","事业编制");//人员大类别：事业编制，非事业编制
		List<Map> departmentNum = personnelStructureMapper.departmentNum(numMap);
		for (Map m:departmentNum){
			Map<String, Object> ageMap = new HashMap<>();
			ageMap.put("teacherTypeBig","事业编制");//人员大类别：事业编制，非事业编制
			ageMap.put("departmentName",m.get("departmentName"));
			ageMap.put("total",m.get("total"));
			List<Map> studentGrade = personnelStructureMapper.getSexType(ageMap);//各单位男女比例(事业编制)
			m.put("list",studentGrade);
		}
		return departmentNum;
	}*/
	@Override
	public List<Map> personSexType() {
		Map<String, Object> param = new HashMap<>();
		param.put("teacherTypeBig","事业编制");//人员大类别：事业编制，非事业编制
		List<Map> studentSex = personnelStructureMapper.getSexType(param);//获取学院本科生性别比例
		return studentSex;
	}

	@Override
	public List<Map> personJobTitleType() {
		Map<String, Object> numMap = new HashMap<>();
		//人员结构：各单位人数
		numMap.put("teacherTypeBig","事业编制");//人员大类别：事业编制，非事业编制
		List<Map> departmentNum = personnelStructureMapper.departmentNum(numMap);
		for (Map m:departmentNum){
			Map<String, Object> titleMap = new HashMap<>();
			titleMap.put("teacherTypeBig","事业编制");//人员大类别：事业编制，非事业编制
			titleMap.put("departmentName",m.get("departmentName"));
			titleMap.put("total",m.get("total"));
			List<Map> studentGrade = personnelStructureMapper.getJobTitleType(titleMap);//各单位职称情况(事业编制)
			m.put("list",studentGrade);
		}
		return departmentNum;
	}

	@Override
	public List<Map> personPartyType() {
		Map<String, Object> numMap = new HashMap<>();
		//人员结构：各单位人数
		numMap.put("teacherTypeBig","事业编制");//人员大类别：事业编制，非事业编制
		List<Map> departmentNum = personnelStructureMapper.departmentNum(numMap);
		for (Map m:departmentNum){
			Map<String, Object> partyMap = new HashMap<>();
			partyMap.put("teacherTypeBig","事业编制");//人员大类别：事业编制，非事业编制
			partyMap.put("departmentName",m.get("departmentName"));
			partyMap.put("total",m.get("total"));
			List<Map> studentGrade = personnelStructureMapper.getPartyType(partyMap);//各单位党员分布情况(事业编制)
			m.put("list",studentGrade);
		}
		return departmentNum;
	}

	@Override
    public Object listTeacherInfoByParam(TeacherInfoREQ teacherInfoREQ) {

        //年龄
		List<Map> ageMap = personnelStructureMapper.listAge(teacherInfoREQ);
        //职称
		List<Map<String,String>> jobMap = personnelStructureMapper.listJobTitle(teacherInfoREQ);
		int jobTitleNum = 0;
		for (Map map : jobMap) {
			if(map.get("jobTitle").equals("正高")){
				jobTitleNum += Integer.parseInt(map.get("num").toString());
			}else if(map.get("jobTitle").equals("副高")){
				jobTitleNum += Integer.parseInt(map.get("num").toString());
			}
		}
        //学缘
        List<Map<String,String>> learningMap = personnelStructureMapper.listLearningEdge(teacherInfoREQ);
		int marginNum = 0;
		for (Map map : learningMap) {
			if(map.get("academyMargin").equals("境外学校")){
				marginNum = Integer.parseInt(map.get("num").toString());
				break;
			}
		}
        //学历
        List<Map<String,String>> education = personnelStructureMapper.listEducation(teacherInfoREQ);
		int educationNum = 0;
		for (Map map : education) {
			if(map.get("education").equals("博士研究生毕业")){
				educationNum += Integer.parseInt(map.get("num").toString());
			}else if(map.get("education").equals("硕士研究生毕业")){
				educationNum += Integer.parseInt(map.get("num").toString());
			}
		}
        //男女比例
        List<Map<String,String>> listTeacherGender = personnelStructureMapper.listTeacherGender(teacherInfoREQ);
		int genderManNum = 0;
		int genderWomanNum = 0;
		for (Map map : listTeacherGender) {
			if(map.get("name").equals("男")){
				genderManNum = Integer.parseInt(map.get("num").toString());
			}else if(map.get("name").equals("女")){
				genderWomanNum = Integer.parseInt(map.get("num").toString());
			}
		}
        //政治面貌
        List<Map<String,String>> listPoliticalStatus = personnelStructureMapper.listPoliticalStatus(teacherInfoREQ);
		int partyNum = 0;
		for (Map map : listPoliticalStatus) {
			if(map.get("name").equals("中共党员")){
				partyNum += Integer.parseInt(map.get("num").toString());
			}else if(map.get("name").equals("中共预备党员")){
				partyNum += Integer.parseInt(map.get("num").toString());
			}
		}
        //岗位
//        List<Map> postMap = personnelStructureMapper.listPost(teacherInfoREQ);
        //薪资
//        List<Map> salaryMap = personnelStructureMapper.listSalary(teacherInfoREQ);

        Map map = new HashedMap();
            map.put("age",ageMap);
            map.put("job",jobMap);
            map.put("learning",learningMap);
            map.put("education",education);
            map.put("listTeacherGender",listTeacherGender);
            map.put("listPoliticalStatus",listPoliticalStatus);
//            map.put("post",postMap);
//            map.put("salary",salaryMap);
            map.put("jobTitleNum",jobTitleNum);
            map.put("educationNum",educationNum);
			map.put("marginNum",marginNum);
            map.put("genderNum",new BigDecimal(genderManNum).divide(new BigDecimal(genderWomanNum),2,BigDecimal.ROUND_HALF_UP)+":1");
			map.put("partyNum",partyNum);
		return map;
    }

    @Override
    public Object distributionOfTitlesInEachCollege(TeacherInfoREQ teacherInfoREQ) {
        List<Map> mapList = personnelStructureMapper.distributionOfTitlesInEachCollege(teacherInfoREQ);
        return mapList;
    }

    @Override
    public Object listAcademicDistribution(TeacherInfoREQ teacherInfoREQ) {
        List<Map> mapList = personnelStructureMapper.listAcademicDistribution(teacherInfoREQ);
        return mapList;
    }

    @Override
    public Object listAcademicAge(TeacherInfoREQ teacherInfoREQ) {
        List<Map> mapList = personnelStructureMapper.listAcademicAge(teacherInfoREQ);
        return mapList;
    }

    @Override
    public List<Map> listTeacherInfoByName(TeacherBoxREQ teacherBoxREQ) {
        List<Map> mapList = personnelStructureMapper.listTeacherInfoByName(teacherBoxREQ);
        return mapList;
    }

    @Override
    public List<Map> listTopTalentsInfoByName(TeacherBoxREQ teacherBoxREQ) {
        List<Map> mapList = personnelStructureMapper.listTopTalentsInfoByName(teacherBoxREQ);
        return mapList;
    }

	@Override
	public List<QueryStaffStructureResponse> staffStructure() {
		return personnelStructureMapper.staffStructure();
	}

	@Override
	public List<Map> listDepartmentTypeAll() {
		return personnelStructureMapper.listDepartmentTypeAll();
	}

	private String convertMsg(float actual,float avgVal) {
    	String zgzbMsg = "";
		if (actual > avgVal){
			zgzbMsg = "高于全部学院平均值";
		}else if (actual == avgVal){
			zgzbMsg = "等于全部学院平均值";
		}else {
			zgzbMsg = "低于全部学院平均值";
		}
		return zgzbMsg;
	}

	@Override
	public Object distributionOfTitles() {
		//之后修改为全部
    	//全部事业 全学校单位正高、副高、中级、初级平均值
		Map allTitle = personnelStructureMapper.distributionOfTitles("");
/*		float zgzbAll = Float.parseFloat(allTitle.get("zgzb").toString());//全学院高级职称
		float fgzbAll = Float.parseFloat(allTitle.get("fgzb").toString());//全学院副高级职称
		float zjzbAll = Float.parseFloat(allTitle.get("zjzb").toString());//全学院中级职称
		float cjzbAll = Float.parseFloat(allTitle.get("cjzb").toString());//全学院初级职称
		//单个学院正高、副高、中级、初级值
		Map signalTitleAll = personnelStructureMapper.distributionOfTitles(academyName);
		float zgzb = Float.parseFloat(signalTitleAll.get("zgzb").toString());//高级职称
		float fgzb = Float.parseFloat(signalTitleAll.get("fgzb").toString());//副高级职称
		float zjzb = Float.parseFloat(signalTitleAll.get("zjzb").toString());//中级职称
		float cjzb = Float.parseFloat(signalTitleAll.get("cjzb").toString());//初级职称

		String zgzbMsg = convertMsg(zgzb,zgzbAll);//高级职称消息
		String fgzbMsg = convertMsg(fgzb,fgzbAll);//副高级职称消息
		String zjzbMsg = convertMsg(zjzb,zjzbAll);//中级职称消息
		String cjzbMsg = convertMsg(cjzb,cjzbAll);//初级职称消息

		signalTitleAll.put("zgzbMsg",zgzbMsg);
		signalTitleAll.put("fgzbMsg",fgzbMsg);
		signalTitleAll.put("zjzbMsg",zjzbMsg);
		signalTitleAll.put("cjzbMsg",cjzbMsg);*/
		return allTitle;
	}

	@Override
	public Object learningEdgeDistribution() {
		//之后修改为全部
		//全部事业 全学校单位本校、境外、国内、其他平均值
		Map allLearningEdge = personnelStructureMapper.learningEdgeDistribution("");
/*		float bxzbAll = Float.parseFloat(allLearningEdge.get("bxzb").toString());//全学院本校
		float jwzbAll = Float.parseFloat(allLearningEdge.get("jwzb").toString());//全学院境外
		float gnzbAll = Float.parseFloat(allLearningEdge.get("gnzb").toString());//全学院国内
		float qtzbAll = Float.parseFloat(allLearningEdge.get("qtzb").toString());//全学院其他
		//单个学院本校、境外、国内、其他值
		Map signalLearningEdgeAll = personnelStructureMapper.learningEdgeDistribution(academyName);
		float bxzb = Float.parseFloat(signalLearningEdgeAll.get("bxzb").toString());//本校
		float jwzb = Float.parseFloat(signalLearningEdgeAll.get("jwzb").toString());//境外
		float gnzb = Float.parseFloat(signalLearningEdgeAll.get("gnzb").toString());//国内
		float qtzb = Float.parseFloat(signalLearningEdgeAll.get("qtzb").toString());//其他

		String bxzbMsg = convertMsg(bxzb,bxzbAll);//本校
		String jwzbMsg = convertMsg(jwzb,jwzbAll);//境外
		String gnzbMsg = convertMsg(gnzb,gnzbAll);//国内
		String qtzbMsg = convertMsg(qtzb,qtzbAll);//其他

		signalLearningEdgeAll.put("bxzbMsg",bxzbMsg);
		signalLearningEdgeAll.put("jwzbMsg",jwzbMsg);
		signalLearningEdgeAll.put("gnzbMsg",gnzbMsg);
		signalLearningEdgeAll.put("qtzbMsg",qtzbMsg);*/
		return allLearningEdge;
	}

	@Override
	public List<Map> ageAndAcademicStructure() {
		List<Map> mapList = personnelStructureMapper.ageAndAcademicStructure();
		return mapList;
	}

	@Override
	public List<Map> ageAndSubjectStructure() {
		List<Map> mapList = personnelStructureMapper.ageAndSubjectStructure();
		return mapList;
	}

	@Override
	public List<Map> academicAndAgeBoxLine() {
		List<Map> list = personnelStructureMapper.academicAndAgeBoxLine();
		for (Map map : list) {
			//上四分位数，中位数，下四分位数
			String stringAge = (String)map.get("stringAge");
			CommonUtils.getFourDivsion(stringAge.split(","),map);
			map.remove("stringAge");
			//大于58岁学院预警
			String academyName = (String)map.get("academyName");//学院名称
			int num = personnelStructureMapper.academicBigAgeNum(academyName);//获取学院大于58岁的的人数
			double rate = personnelStructureMapper.academicBigAgeRate(academyName, num);
			if (rate>8){//大于58岁的人数大于5人并且超过8%则标红
				map.put("isRed",1);
			}else {
				map.put("isRed",0);
			}
		}
		return list;
	}

	@Override
	public Map<String, Object> academicAndSubject() {
    	//学院与学科关系，学院的人数
		List<QueryAcademyAndSubjectResponse> list = personnelStructureMapper.academicAndSubject();
		//学科的人数
		List<Map> subjectNum = personnelStructureMapper.getSubjectNum();

		Map<String, Object> resultMap = new HashMap<>();

		resultMap.put("academic",list);
		resultMap.put("subject",subjectNum);

		return resultMap;
	}

	@Override
	public List<Map> academySubjectDis() {
		return personnelStructureMapper.academySubjectDis();
	}

	@Override
	public List<Map> subjectAcademyDis() {
		return personnelStructureMapper.subjectAcademyDis();
	}

/*	@Override
	public Map<String, Object> subjectTopFive() {
		//学科中 高端人才数量前五
		List<Map> talentList = personnelStructureMapper.subjectTalentList();
		//学科中 高级职称占比前五
		List<Map> highTitleList = personnelStructureMapper.subjectHighTitleList();
		//学科中 总人数前五
		List<Map> subjectAllList = personnelStructureMapper.subjectAllList();

		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("talentList",talentList);
		resultMap.put("highTitleList",highTitleList);
		resultMap.put("subjectAllList",subjectAllList);

		return resultMap;
	}*/

	@Override
	public List<Map> subjectTalent() {
		return personnelStructureMapper.subjectTalentList();
	}

	@Override
	public List<Map> subjectHighTitle() {
		return personnelStructureMapper.subjectHighTitleList();
	}

	@Override
	public List<Map> subjectAll() {
		return personnelStructureMapper.subjectAllList();
	}

	@Override
	public Map<String, Object> listNewcomersAll(NewcomersREQ req) {
		Map<String, Object> result = new HashMap<String, Object>();
		//获得list对象
		List<Map<String, String>> listWorkingArea = personnelStructureMapper.listNewcomersAll(req);
		//获取enum数组-坐标各个名称
		EchartSeriesEnum[] enums = {EchartSeriesEnum.NEWCOMERS_A,EchartSeriesEnum.NEWCOMERS_B,
                EchartSeriesEnum.NEWCOMERS_C,EchartSeriesEnum.NEWCOMERS_D
		};
		//调用转换数据格式方法
		result.put("chartData", EchartsUtil.list2SeriesDatas(listWorkingArea, SeriesNameEnum.NAME.getName(), CommonUtils.enumsToSeries(enums)));
		return result;
	}

	@Override
	public List<Map<String, String>> listNewcomersInSchool(NewcomersREQ req) {
		return personnelStructureMapper.listNewcomersInSchool(req);
	}

	@Override
	public List<Map<String, String>> listNewcomersNotDoctor(NewcomersREQ req) {
		return personnelStructureMapper.listNewcomersNotDoctor(req);
	}

	@Override
	public List<Map<String, String>> listNewcomersOverseas(NewcomersREQ req) {
		return personnelStructureMapper.listNewcomersOverseas(req);
	}
}
