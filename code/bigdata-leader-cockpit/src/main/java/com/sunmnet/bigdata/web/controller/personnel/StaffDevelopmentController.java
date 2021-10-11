package com.sunmnet.bigdata.web.controller.personnel;

import com.sunmnet.bigdata.common.annotation.LoggerManage;
import com.sunmnet.bigdata.common.bean.JsonResult;
import com.sunmnet.bigdata.common.controller.BaseController;
import com.sunmnet.bigdata.web.model.request.personnel.StaffDevelopmentREQ;
import com.sunmnet.bigdata.web.service.personnel.StaffDevelopmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staffDevelopment")
@Api(tags="人员发展")
public class StaffDevelopmentController extends BaseController
{
    @Autowired
    private StaffDevelopmentService staffDevelopmentService;

    @ApiOperation(value = "国际交流地图")
    @GetMapping(value = "/listInternationalCountry")
    @LoggerManage("国际交流地图")
    public JsonResult listInternationalCountry(@ModelAttribute StaffDevelopmentREQ req){
        return buildSuccJson(staffDevelopmentService.listInternationalCountry(req));
    }

    @ApiOperation(value = "国际交流-4个数据")
    @GetMapping(value = "/getInternationalFourNum")
    @LoggerManage("国际交流-4个数据")
    public JsonResult getInternationalFourNum(@ModelAttribute StaffDevelopmentREQ req){
        return buildSuccJson(staffDevelopmentService.getInternationalFourNum(req));
    }

    @ApiOperation(value = "国际交流-下拉框(无用)")
    @GetMapping(value = "/getInternationalBox")
    @LoggerManage("国际交流-下拉框")
    public JsonResult getInternationalBox(){
        return buildSuccJson(staffDevelopmentService.getInternationalBox());
    }

    @ApiOperation(value = "学术交流目的国家")
    @GetMapping(value = "/listCountryNameNumber")
    @LoggerManage("学术交流目的国家")
    public JsonResult listCountryNameNumber(String abroadYear){
        return buildSuccJson(staffDevelopmentService.listCountryNameNumber(abroadYear));
    }

    @ApiOperation(value = "学术交流学院参与人数")
    @GetMapping(value = "/listAcademyNameNumber")
    @LoggerManage("学术交流学院参与人数")
    public JsonResult listAcademyNameNumber(String abroadYear){
        return buildSuccJson(staffDevelopmentService.listAcademyNameNumber(abroadYear));
    }


}
