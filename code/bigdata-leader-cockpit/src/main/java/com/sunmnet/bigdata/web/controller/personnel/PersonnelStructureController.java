package com.sunmnet.bigdata.web.controller.personnel;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.web.model.request.personnel.NewcomersREQ;
import com.sunmnet.bigdata.web.model.request.personnel.TeacherBoxREQ;
import com.sunmnet.bigdata.web.model.request.personnel.TeacherInfoREQ;
import com.sunmnet.bigdata.web.service.personnel.PersonnelStructureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/personnel")
@Api(tags="人事概况")
public class PersonnelStructureController extends BaseController
{
    @Autowired
    private PersonnelStructureService personnelStructureService;

    @ApiOperation(value = "人员结构：整体人员结构")
    @GetMapping(value = "/staffStructure")
    @LoggerManage("人员结构：整体人员结构")
    public JsonResult staffStructure(){
        return buildSuccJson(personnelStructureService.staffStructure());
    }

    @ApiOperation(value = "人员结构:单位类型")
    @GetMapping(value = "/listDepartmentTypeAll")
    @LoggerManage("人员结构:单位类型")
    public JsonResult listDepartmentTypeAll(){
        return buildSuccJson(personnelStructureService.listDepartmentTypeAll());
    }

    @ApiOperation(value = "人员结构：学院类人数，学院类平均年龄，学院类高级职称占比")
    @GetMapping(value = "/listCountInfo")
    @LoggerManage("人员结构：学院类人数，学院类平均年龄，学院类高级职称占比")
    public JsonResult listCountInfo(TeacherInfoREQ teacherInfoREQ){
        return buildSuccJson(personnelStructureService.listCountInfo(teacherInfoREQ));
    }

    @ApiOperation(value = "人员结构：查看各单位人员结构对比 各单位人员编制结构")
    @GetMapping(value = "/personBigType")
    @LoggerManage("人员结构：查看各单位人员结构对比 各单位人员编制结构")
    public JsonResult personBigType(){
        return buildSuccJson(personnelStructureService.personBigType());
    }

    @ApiOperation(value = "人员结构：查看各单位人员结构对比 各单位年龄结构对比(事业编制)")
    @GetMapping(value = "/personAgeType")
    @LoggerManage("人员结构：查看各单位人员结构对比 各单位年龄结构对比(事业编制)")
    public JsonResult personAgeType(){
        return buildSuccJson(personnelStructureService.personAgeType());
    }

    @ApiOperation(value = "人员结构：查看各单位人员结构对比 各单位男女比例(事业编制)")
    @GetMapping(value = "/personSexType")
    @LoggerManage("人员结构：查看各单位人员结构对比 各单位男女比例(事业编制)")
    public JsonResult personSexType(){
        return buildSuccJson(personnelStructureService.personSexType());
    }

    @ApiOperation(value = "人员结构：查看各单位人员结构对比 各单位职称情况(事业编制)")
    @GetMapping(value = "/personJobTitleType")
    @LoggerManage("人员结构：查看各单位人员结构对比 各单位职称情况(事业编制)")
    public JsonResult personJobTitleType(){
        return buildSuccJson(personnelStructureService.personJobTitleType());
    }

    @ApiOperation(value = "人员结构：查看各单位人员结构对比 各单位党员分布情况(事业编制)")
    @GetMapping(value = "/personPartyType")
    @LoggerManage("人员结构：查看各单位人员结构对比 各单位党员分布情况(事业编制)")
    public JsonResult personPartyType(){
        return buildSuccJson(personnelStructureService.personPartyType());
    }

    @ApiOperation(value = "人员结构：年龄,职称,学缘,学历,性别,政治面貌")
    @GetMapping(value = "/listTeacherInfoByParam")
    @LoggerManage("人员结构：年龄,职称,学缘,学历,性别,政治面貌")
    public JsonResult listTeacherInfoByParam(TeacherInfoREQ teacherInfoREQ){
        return buildSuccJson(personnelStructureService.listTeacherInfoByParam(teacherInfoREQ));
    }

    @ApiOperation(value = "学院职称分布：各学院职称分布以及占比情况")
    @GetMapping(value = "/distributionOfTitlesInEachCollege")
    @LoggerManage("学院职称分布：各学院职称分布以及占比情况")
    public JsonResult distributionOfTitlesInEachCollege(TeacherInfoREQ teacherInfoREQ){
        return buildSuccJson(personnelStructureService.distributionOfTitlesInEachCollege(teacherInfoREQ));
    }

    @ApiOperation(value = "学院学缘分布：学缘分布情况")
    @GetMapping(value = "/listAcademicDistribution")
    @LoggerManage("学院学缘分布：学缘分布情况")
    public JsonResult listAcademicDistribution(TeacherInfoREQ teacherInfoREQ){
        return buildSuccJson(personnelStructureService.listAcademicDistribution(teacherInfoREQ));
    }

    @ApiOperation(value = "学院年龄分析：{学院}按年龄分布图")
    @GetMapping(value = "/listAcademicAge")
    @LoggerManage("学院年龄分析：{学院}按年龄分布图")
    public JsonResult listAcademicAge(TeacherInfoREQ teacherInfoREQ){
        return buildSuccJson(personnelStructureService.listAcademicAge(teacherInfoREQ));
    }

	@ApiOperation(value = "学院职称分布：职称分布扇形图和详情：职称分布以及占比情况")
	@GetMapping(value = "/distributionOfTitles")
	@LoggerManage("职称分布扇形图和详情：各学院职称分布以及占比情况")
	public JsonResult distributionOfTitles(){
		return buildSuccJson(personnelStructureService.distributionOfTitles());
	}

	@ApiOperation(value = "学院学缘分布：学院学缘详细分布情况")
	@GetMapping(value = "/learningEdgeDistribution")
	@LoggerManage("学院学缘分布：学院学缘详细分布情况")
	public JsonResult learningEdgeDistribution(){
		return buildSuccJson(personnelStructureService.learningEdgeDistribution());
	}

	@ApiOperation(value = "学院年龄分析：年龄段与学院映射图")
	@GetMapping(value = "/ageAndAcademicStructure")
	@LoggerManage("学院年龄分析：年龄段与学院映射图")
	public JsonResult ageAndAcademicStructure(){
		return buildSuccJson(personnelStructureService.ageAndAcademicStructure());
	}

	@ApiOperation(value = "学院年龄分析：年龄段与学科映射图")
	@GetMapping(value = "/ageAndSubjectStructure")
	@LoggerManage("学院年龄分析：年龄段与学科映射图")
	public JsonResult ageAndSubjectStructure(){
		return buildSuccJson(personnelStructureService.ageAndSubjectStructure());
	}

	@ApiOperation(value = "学院年龄分析：学院年龄箱线")
	@GetMapping(value = "/academicAndAgeBoxLine")
	@LoggerManage("学院年龄分析：学院年龄箱线")
	public JsonResult academicAndAgeBoxLine(){
		return buildSuccJson(personnelStructureService.academicAndAgeBoxLine());
	}

	@ApiOperation(value = "学科人事分析：学院教师与学科的对应关系图")
	@GetMapping(value = "/academicAndSubject")
	@LoggerManage("学科人事分析：学院教师与学科的对应关系图")
	public JsonResult academicAndSubject(){
		return buildSuccJson(personnelStructureService.academicAndSubject());
	}

	@ApiOperation(value = "学科人事分析：各学院学科分布情况")
	@GetMapping(value = "/academySubjectDis")
	@LoggerManage("学科人事分析：各学院学科分布情况")
	public JsonResult academySubjectDis(){
		return buildSuccJson(personnelStructureService.academySubjectDis());
	}

	@ApiOperation(value = "学科人事分析：各学科支持学院情况")
	@GetMapping(value = "/subjectAcademyDis")
	@LoggerManage("学科人事分析：各学科支持学院情况")
	public JsonResult subjectAcademyDis(){
		return buildSuccJson(personnelStructureService.subjectAcademyDis());
	}

//	@ApiOperation(value = "学科人事分析：学科Top5")
//	@GetMapping(value = "/subjectTopFive")
//	@LoggerManage("学科人事分析：学科Top5")
//	public JsonResult subjectTopFive(){
//		return buildSuccJson(personnelStructureService.subjectTopFive());
//	}

	@ApiOperation(value = "学科人事分析：学科中高端人才数量")
	@GetMapping(value = "/subjectTalent")
	@LoggerManage("学科人事分析：学科中高端人才数量")
	public JsonResult subjectTalent(){
		return buildSuccJson(personnelStructureService.subjectTalent());
	}

	@ApiOperation(value = "学科人事分析：学科中高级职称占比")
	@GetMapping(value = "/subjectHighTitle")
	@LoggerManage("学科人事分析：学科中高级职称占比")
	public JsonResult subjectHighTitle(){
		return buildSuccJson(personnelStructureService.subjectHighTitle());
	}

	@ApiOperation(value = "学科人事分析：学科中总人数")
	@GetMapping(value = "/subjectAll")
	@LoggerManage("学科人事分析：学科中总人数")
	public JsonResult subjectAll(){
		return buildSuccJson(personnelStructureService.subjectAll());
	}



    @ApiOperation(value = "人员列表：人员信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", dataType = "int", required = true, value = "pageNum", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", required = true, value = "pageSize", defaultValue = "10")
    })
    @GetMapping(value = "/listTeacherInfoByName")
    @LoggerManage("按照各种条件查询列表")
    public JsonResult listTeacherInfoByName(@ModelAttribute TeacherBoxREQ teacherBoxREQ, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        final List<Map> list = personnelStructureService.listTeacherInfoByName(teacherBoxREQ);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return buildSuccJson(pageInfo);
    }


    @ApiOperation(value = "高层次人才：人才列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", dataType = "int", required = true, value = "pageNum", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", required = true, value = "pageSize", defaultValue = "10")
    })
    @GetMapping(value = "/listTopTalentsInfoByName")
    @LoggerManage("按照各种条件查询列表")
    public JsonResult listTopTalentsInfoByName(@ModelAttribute TeacherBoxREQ teacherBoxREQ, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        final List<Map> list = personnelStructureService.listTopTalentsInfoByName(teacherBoxREQ);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return buildSuccJson(pageInfo);
    }

    @ApiOperation(value = "新进人员统计图")
    @GetMapping(value = "/listNewcomersAll")
    @LoggerManage("新进人员统计图")
    public JsonResult listNewcomersAll(NewcomersREQ req){
        return buildSuccJson(personnelStructureService.listNewcomersAll(req));
    }

    @ApiOperation(value = "本校学缘人员")
    @GetMapping(value = "/listNewcomersInSchool")
    @LoggerManage("本校学缘人员")
    public JsonResult listNewcomersInSchool(NewcomersREQ req){
        return buildSuccJson(personnelStructureService.listNewcomersInSchool(req));
    }

    @ApiOperation(value = "非博士学历人员")
    @GetMapping(value = "/listNewcomersNotDoctor")
    @LoggerManage("非博士学历人员")
    public JsonResult listNewcomersNotDoctor(NewcomersREQ req){
        return buildSuccJson(personnelStructureService.listNewcomersNotDoctor(req));
    }

    @ApiOperation(value = "海外学缘人员")
    @GetMapping(value = "/listNewcomersOverseas")
    @LoggerManage("海外学缘人员")
    public JsonResult listNewcomersOverseas(NewcomersREQ req){
        return buildSuccJson(personnelStructureService.listNewcomersOverseas(req));
    }
}
