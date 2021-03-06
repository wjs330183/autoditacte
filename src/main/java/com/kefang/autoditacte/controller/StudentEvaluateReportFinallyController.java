package com.kefang.autoditacte.controller;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.service.StudentEvaluateReportFinallyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-28
 */
@Controller
public class StudentEvaluateReportFinallyController {
    @Autowired
    private StudentEvaluateReportFinallyService studentEvaluateReportFinallyService;

    @RequestMapping(value = {"/studentManager/2/studentEvaluateReportFinally"},method = RequestMethod.GET)
    @ResponseBody
    public JsonData save(@RequestParam(value = "startTime", required = false) String startTime,
                         @RequestParam(value = "endTime", required = false) String endTime,
                         @RequestParam(value = "courseId", required = false) String courseId,
                         @RequestParam(value = "stationId", required = false) String stationId,
                         @RequestParam(value = "status", required = false) String status,
                         @RequestParam(value = "keyWord", required = false) String keyWord,
                         TailPage page){
        return studentEvaluateReportFinallyService.getStudentEvaluateReportFinallys(startTime, endTime, courseId, stationId, status, keyWord, page);
    }
}
