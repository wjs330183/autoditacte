package com.kefang.autoditacte;

import com.alibaba.fastjson.JSONObject;
import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.dto.StudentDto;
import com.kefang.autoditacte.entity.Student;
import com.kefang.autoditacte.entity.StudentDetail;
import com.kefang.autoditacte.service.StudentDetailService;
import com.kefang.autoditacte.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {
    @Resource
    private StudentDetailService studentDetailService;
    @Resource
    private StudentService studentService;

    @Test
    public void getAllTset() {
        TailPage tailPage = new TailPage();
        tailPage.setPageNum(1);
        tailPage.setPageSize(10);
        JsonData allStudents = studentService.getAllStudents(null, null, null, tailPage);
        System.out.println(allStudents.getResultMsg() + JSONObject.toJSONString(allStudents));
//        JsonData studentDetailsByPage = studentDetailService.getStudentDetailsByPage(null, tailPage);
//        JsonData studentsByPage = studentService.getStudentsByPage(null, tailPage);
//        StudentDto studentDto = new StudentDto();
//        TailPage page = (TailPage) studentDetailsByPage.getResultData();
//        List items = page.getItems();
////        studentDto.setStudentDetail(items);
//        studentDto.setStudent((Student) studentsByPage.getResultData());
//        System.out.println(JSONObject.toJSONString(studentDto));
////        System.out.println(studentDetailsByPage.getResultMsg() + JSONObject.toJSONString(studentDetailsByPage));
////        System.out.println(studentsByPage.getResultMsg() + JSONObject.toJSONString(studentsByPage));

    }

    @Test
    public void test() {
        TailPage tailPage = new TailPage();
        tailPage.setPageNum(1);
        tailPage.setPageSize(10);
        JsonData students = studentService.getStudents(null, null, null, tailPage);
        System.out.println(JSONObject.toJSONString(students));

    }
}
