package com.kefang.autoditacte.controller;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.entity.StudentEvaluate;
import com.kefang.autoditacte.param.StudentEvaluateParam;
import com.kefang.autoditacte.service.StudentEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 描述：
 * @author Json
 * @date 2018-05-28
 */
@Controller
public class StudentEvaluateController {
    @Autowired
    private StudentEvaluateService studentEvaluateService;

    @RequestMapping(value = {"/studentManager/1/studentEvaluate"},method = RequestMethod.POST)
    @ResponseBody
    public JsonData save(@RequestBody StudentEvaluateParam param){
        return studentEvaluateService.saveStudentEvaluate(param);
    }
    @RequestMapping(value = {"/studentManager/1/editStudentEvaluate"},method = RequestMethod.POST)
    @ResponseBody
    public JsonData update(@RequestBody StudentEvaluateParam param){
        return studentEvaluateService.updateStudentEvaluate(param);
    }
    @RequestMapping(value = {"/studentManager/1/delete"},method = RequestMethod.POST)
    @ResponseBody
    public JsonData delete(@RequestParam("id") String id){
        return studentEvaluateService.deleteStudentEvaluateById(id);
    }
    @RequestMapping(value = {"/studentManager/1/studentEvaluates"},method = RequestMethod.GET)
    @ResponseBody
    public  JsonData getStudentEvaluatesByName(@RequestParam(value = "year", required = false) String year,
                                               @RequestParam(value = "stage", required = false)String stage,
                                               @RequestParam(value = "courseId", required = false)String courseId,
                                               @RequestParam(value = "site_id", required = false)String site_id,
                                               @RequestParam(value = "status", required = false)String status,
                                               @RequestParam(value = "keyWord", required = false)String keyWord,
                                               TailPage page) {
        return studentEvaluateService.getStudentEvaluates(year, stage, courseId, site_id,status, keyWord, page);
    }

}