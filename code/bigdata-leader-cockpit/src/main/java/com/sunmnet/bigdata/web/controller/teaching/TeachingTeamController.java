package com.sunmnet.bigdata.web.controller.teaching;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.web.model.request.teaching.TeachingTeamREQ;
import com.sunmnet.bigdata.web.service.teaching.TeachingTeamService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**  
* @ClassName: TeachingTeamController  
* @Description: 师资力量-教师队伍
* @author lenovo  
* @date 2018年8月28日    
*/
@Api(value = "师资力量-教师队伍controller", tags = "师资力量-教师队伍接口")
@RestController
@RequestMapping("/teachingTeam")
public class TeachingTeamController extends BaseController
{
    @Autowired
    private TeachingTeamService teachingTeamService;

    
    @ApiOperation("各学院专任教师分布情况")
    @RequestMapping(value = "/getSankeyDistribution", method = {RequestMethod.POST})
    @LoggerManage("各学院专任教师分布情况")
    public JsonResult getTeachingTeanSankeyDistribution(TeachingTeamREQ req)
    {
        Map<String, List<Map<String, String>>> result = teachingTeamService.getTeachingTeanSankeyDistribution(req);
        return buildSuccJson(result);
    }

}
