package com.sunmnet.bigdata.web.controller.science;

import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.web.model.request.science.MonographInfoPageREQ;
import com.sunmnet.bigdata.web.model.request.science.ProjectDetailPageREQ;
import com.sunmnet.bigdata.web.service.science.AchievementPerformanceService;
import com.sunmnet.bigdata.web.service.science.ScienceInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/achievement")
@Api(tags="科研-成果绩效")
public class AchievementPerformanceController extends BaseController
{

    @Autowired
    private AchievementPerformanceService achievementPerformanceService;

    @ApiOperation(value = "ESI趋势与对比：近五年ESI综合排名及ESI论文数变化趋势")
    @GetMapping(value = "/esiRankingPapers")
    @LoggerManage("ESI趋势与对比：近五年ESI综合排名及ESI论文数变化趋势")
    public JsonResult esiRankingPapers(){
    	return buildSuccJson(achievementPerformanceService.esiRankingPapers());
    }

    @ApiOperation(value = "ESI趋势与对比：近五年ESI高被引论文/热点论文变化趋势")
    @GetMapping(value = "/esiCitedHotspot")
    @LoggerManage("ESI趋势与对比：近五年ESI高被引论文/热点论文变化趋势")
    public JsonResult esiCitedHotspot(){
    	return buildSuccJson(achievementPerformanceService.esiCitedHotspot());
    }

    @ApiOperation(value = "ESI趋势与对比：ESI学科各高校排名对比")
    @GetMapping(value = "/esiRankContrast")
    @LoggerManage("ESI趋势与对比：ESI学科各高校排名对比")
    public JsonResult esiRankContrast(){
    	return buildSuccJson(achievementPerformanceService.esiRankContrast());
    }

	@ApiOperation(value = "ESI学科：我校进入ESI的学科及排名")
	@GetMapping(value = "/esiSubjectRank")
	@LoggerManage("ESI学科：我校进入ESI的学科及排名")
	public JsonResult esiSubjectRank(){
		return buildSuccJson(achievementPerformanceService.esiSubjectRank());
	}

	@ApiOperation(value = "ESI学科：我校各学科ESI差距分析")
	@GetMapping(value = "/esiPotentialSubject")
	@LoggerManage("ESI学科：我校各学科ESI差距分析")
	public JsonResult esiPotentialSubject(){
		return buildSuccJson(achievementPerformanceService.esiPotentialSubject());
	}


	@ApiOperation(value = "专利：专利数量")
	@GetMapping(value = "/patentNum")
	@LoggerManage("专利：专利数量")
	public JsonResult patentNum(){
		return buildSuccJson(achievementPerformanceService.patentNum());
	}

	@ApiOperation(value = "专利：专利申请数/专利授权数/专利转化件数Top5")
	@GetMapping(value = "/patentTopFive")
	@LoggerManage("专利：专利申请数/专利授权数/专利转化件数Top5")
	public JsonResult patentTopFive(){
		return buildSuccJson(achievementPerformanceService.patentTopFive());
	}
	@ApiOperation(value = "专利：专利转让")
	@GetMapping(value = "/patentTransferAmount")
	@LoggerManage("专利：专利转让")
	public JsonResult patentTransferAmount(){
		return buildSuccJson(achievementPerformanceService.patentTransferAmount());
	}
	@ApiOperation(value = "专利：出售总金额/实际收入金额/专利转让合同数Top5")
	@GetMapping(value = "/patentTransferTopFive")
	@LoggerManage("专利：出售总金额/实际收入金额/专利转让合同数Top5")
	public JsonResult patentTransferTopFive(){
		return buildSuccJson(achievementPerformanceService.patentTransferTopFive());
	}

	@ApiOperation(value = "论文：发表论文数量")
	@GetMapping(value = "/publishThesis")
	@LoggerManage("论文：发表论文数量")
	public JsonResult publishThesis(String type){
		return buildSuccJson(achievementPerformanceService.publishThesis(type));
	}
	@ApiOperation(value = "论文：近五年SCI论文发表分区变化趋势")
	@GetMapping(value = "/thesisSCI")
	@LoggerManage("论文：近五年SCI论文发表分区变化趋势")
	public JsonResult thesisSCI(){
		return buildSuccJson(achievementPerformanceService.thesisSCI());
	}
	@ApiOperation(value = "论文：近五年SSCI论文发表趋势")
	@GetMapping(value = "/thesisSSCI")
	@LoggerManage("论文：近五年SSCI论文发表趋势")
	public JsonResult thesisSSCI(){
		return buildSuccJson(achievementPerformanceService.thesisSSCI());
	}

	@ApiOperation(value = "专著：专著分布")
	@GetMapping(value = "/monographDepNum")
	@LoggerManage("专著：专著分布")
	public JsonResult monographDepNum(){
		return buildSuccJson(achievementPerformanceService.monographDepNum());
	}
	@ApiOperation(value = "专著：专著数量TOP5科研机构")
	@GetMapping(value = "/monographDepTopFive")
	@LoggerManage("专著：专著数量TOP5科研机构")
	public JsonResult monographDepTopFive(){
		return buildSuccJson(achievementPerformanceService.monographDepTopFive());
	}
	@ApiOperation(value = "专著：专著详情")
	@GetMapping(value = "/monographInfo")
	@LoggerManage("专著：专著详情")
	public JsonResult monographInfo(@Validated MonographInfoPageREQ monographInfoPageREQ,
			BindingResult bindingResult){
		return buildSuccJson(achievementPerformanceService.monographInfo(monographInfoPageREQ));
	}
}
