package com.sunmnet.bigdata.web.service.teaching.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.sunmnet.bigdata.common.request.BasePageRequest;
import com.sunmnet.bigdata.web.mapper.teaching.TeacherInfoMapper;
import com.sunmnet.bigdata.web.mapper.teaching.TeachingResourceMapper;
import com.sunmnet.bigdata.web.model.request.teaching.GraduateCourseREQ;
import com.sunmnet.bigdata.web.model.request.teaching.GraduateTeacherPageREQ;
import com.sunmnet.bigdata.web.model.request.teaching.TeachingTeamREQ;
import com.sunmnet.bigdata.web.service.teaching.TeachingResourceService;
import com.sunmnet.bigdata.web.util.CommonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeachingResourceServiceImpl implements TeachingResourceService
{
    @Autowired
    private TeachingResourceMapper teachingResourceMapper;


	@Override
	public List<Map> teacherTrend() {
		return teachingResourceMapper.teacherTrend();
	}

	@Override
	public List<Map> academyTeachingSituation() {
		return teachingResourceMapper.academyTeachingSituation();
	}

	@Override
	public List<Map> academyTeacherType() {
		return teachingResourceMapper.academyTeacherType();
	}

	@Override
	public Map fullTeacherStruct(String academyCode) {
		Map result = new HashMap<>();
		int total = teachingResourceMapper.fullTeacherNum(academyCode);//学院总人数
		List<Map> title = teachingResourceMapper.titleNum(academyCode);//学院教师职称结构
		List<Map> education = teachingResourceMapper.educationNum(academyCode);//学院学历结构
		List<Map> age = teachingResourceMapper.ageNum(academyCode);//学院年龄结构
		List<Map> margin = teachingResourceMapper.marginNum(academyCode);//学缘结构
		result.put("total",total);
		result.put("title",title);
		result.put("education",education);
		result.put("age",age);
		result.put("margin",margin);
		return result;
	}

	@Override
	public List<Map> graduateTeaDis() {
		return teachingResourceMapper.graduateTeaDis();
	}

	@Override
	public Map graduateTeaStruct(String academyCode) {
		Map result = new HashMap<>();
		List<Map> job = teachingResourceMapper.graduateJob(academyCode);//研究生导师职称结构
		List<Map> age = teachingResourceMapper.graduateAge(academyCode);//研究生导师年龄结构
		List<Map> education = teachingResourceMapper.graduateEducation(academyCode);//研究生导师学历结构
		List<Map> sex = teachingResourceMapper.graduateSex(academyCode);//研究生导师性别结构
		result.put("job",job);
		result.put("age",age);
		result.put("education",education);
		result.put("sex",sex);
		return result;
	}

	@Override
	public PageInfo<Map> graduateTeacherPage(GraduateTeacherPageREQ graduateTeacherPageREQ) {
		if (StringUtil.isNotEmpty(graduateTeacherPageREQ.getSort()) && StringUtil.isNotEmpty(graduateTeacherPageREQ.getOrder())){
			PageHelper.orderBy(graduateTeacherPageREQ.getSort()+" "+graduateTeacherPageREQ.getOrder());
		}
		PageHelper.startPage(graduateTeacherPageREQ.getPageNum(), graduateTeacherPageREQ.getPageSize());
		List<Map> list = teachingResourceMapper.graduateTeacherPage(graduateTeacherPageREQ);
		PageInfo<Map> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public List<Map> listTutorGuideStudent(String type) {
		return teachingResourceMapper.listTutorGuideStudent(type);
	}

	@Override
	public Map undergraduateAcademyMajor() {
		Map result = new HashMap<>();
		List<Map> detailList = teachingResourceMapper.undergraduateAcademyMajor();
		List<Map> statisticList = teachingResourceMapper.underAcaMajSta();
		result.put("detailList",detailList);
		result.put("statisticList",statisticList);
		return result;
	}

	@Override
	public Map undergraduateLargeMajor() {
		Map result = new HashMap<>();
		List<Map> detailList = teachingResourceMapper.undergraduateLargeMajor();
		List<Map> statisticList = teachingResourceMapper.underLarMajSta();
		result.put("detailList",detailList);
		result.put("statisticList",statisticList);
		return result;
	}

	@Override
	public Map graduateAcademySubject() {
		Map result = new HashMap<>();
		List<Map> detailList = teachingResourceMapper.graduateAcademySubject();
		List<Map> statisticList = teachingResourceMapper.graduateAcaSubSta();
		result.put("detailList",detailList);
		result.put("statisticList",statisticList);
		return result;
	}

	@Override
	public Map graduateAcademyMajor() {
		Map result = new HashMap<>();
		List<Map> detailList = teachingResourceMapper.graduateAcademyMajor();
		List<Map> statisticList = teachingResourceMapper.graduateAcaMajSta();
		result.put("detailList",detailList);
		result.put("statisticList",statisticList);
		return result;
	}

	@Override
	public List<Map> undergraduateCourseStruct() {
		return teachingResourceMapper.undergraduateCourseStruct();
	}

	@Override
	public List<Map> undergraduateOpenCourse(String annual) {
		if(StringUtils.isBlank(annual)){
			annual = CommonUtils.getNowYear();
		}
		return teachingResourceMapper.undergraduateOpenCourse(annual);
	}

	@Override
	public List<Map> undergraduateQualityCourse() {
		return teachingResourceMapper.undergraduateQualityCourse();
	}

	@Override
	public PageInfo<Map> undergraduateFicCouPage(BasePageRequest basePageRequest) {
		PageHelper.startPage(basePageRequest.getPageNum(), basePageRequest.getPageSize());
		List<Map> list = teachingResourceMapper.undergraduateFicCouPage(basePageRequest);
		PageInfo<Map> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public PageInfo<Map> undergraduateBouCouPage(BasePageRequest basePageRequest) {
		PageHelper.startPage(basePageRequest.getPageNum(), basePageRequest.getPageSize());
		List<Map> list = teachingResourceMapper.undergraduateBouCouPage(basePageRequest);
		PageInfo<Map> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public List<Map> undergraduateOnlineCourse() {
		return teachingResourceMapper.undergraduateOnlineCourse();
	}

	@Override
	public List<Map> graduateLatestCouStr(GraduateCourseREQ req) {
		return teachingResourceMapper.graduateLatestCouStr(req);
	}

	@Override
	public Map<String,Object> graduateCourseStr() {
		Map<String,Object> result = new HashMap<>();
		result.put("graduateCourseStr",teachingResourceMapper.graduateCourseStr());
		result.put("legend",teachingResourceMapper.getGraduateCourseLegend(new GraduateCourseREQ()));
		return result;
	}

	@Override
	public List<Map> graduateTotalQualityCou() {
		return teachingResourceMapper.graduateTotalQualityCou();
	}

	@Override
	public List<Map> graduateQualityCourse() {
		return teachingResourceMapper.graduateQualityCourse();
	}

	@Override
	public Map<String,Object> graduateOneCourse(GraduateCourseREQ req) {
		Map<String,Object> result = new HashMap<>();
		if(null != req && req.getType().equals("master")){
			req.setType("doctor");
		}else if(null != req && req.getType().equals("doctor")){
			req.setType("master");
		}
		result.put("graduateOneCourse",teachingResourceMapper.graduateOneCourse(req));
		result.put("legend",teachingResourceMapper.getGraduateCourseLegend(req));
		return result;
	}
}
