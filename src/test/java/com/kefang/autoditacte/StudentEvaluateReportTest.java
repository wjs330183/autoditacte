package com.kefang.autoditacte;

import com.alibaba.fastjson.JSONObject;
import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.dao.StudentEvaluateDao;
import com.kefang.autoditacte.entity.StudentEvaluate;
import com.kefang.autoditacte.service.StudentEvaluateReportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentEvaluateReportTest {
    @Resource
    private StudentEvaluateReportService studentEvaluateReportService;

    @Resource
    private StudentEvaluateDao studentEvaluateDao;
    @Test
    public void getAllTest() {
        TailPage tailPage = new TailPage();
        tailPage.setPageNum(1);
        tailPage.setPageSize(10);
        JsonData studentEvaluateReportsByPage = studentEvaluateReportService.getStudentEvaluateReportsByPage(null, tailPage);
        System.out.println(studentEvaluateReportsByPage.getResultMsg() + JSONObject.toJSONString(studentEvaluateReportsByPage));
    }
    @Test
    public void daoTest() {
//        StudentEvaluate byStudentId = studentEvaluateDao.getByStudentId(null, null);
//        System.out.println(JSONObject.toJSONString(byStudentId));
    }
}
