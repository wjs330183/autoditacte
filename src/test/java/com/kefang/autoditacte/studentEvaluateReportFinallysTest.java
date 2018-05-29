package com.kefang.autoditacte;

import com.alibaba.fastjson.JSONObject;
import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.service.StudentEvaluateReportFinallyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class studentEvaluateReportFinallysTest {

    @Resource
    private StudentEvaluateReportFinallyService studentEvaluateReportFinallyService;

    @Test
    public void getALl() {
        TailPage tailPage = new TailPage();
        tailPage.setPageNum(1);
        tailPage.setPageSize(10);
        JsonData studentEvaluateReportFinallyServiceStudentEvaluateReportFinallys = studentEvaluateReportFinallyService.getStudentEvaluateReportFinallys(null, null, null, null, null, null, tailPage);
        System.out.println(JSONObject.toJSONString(studentEvaluateReportFinallyServiceStudentEvaluateReportFinallys));
    }

}
