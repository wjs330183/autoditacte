package com.kefang.autoditacte.controller;

import com.alibaba.fastjson.JSONObject;
import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.dto.StudentDto;
import com.kefang.autoditacte.entity.Student;
import com.kefang.autoditacte.entity.StudentDetail;
import com.kefang.autoditacte.param.StudentParam;
import com.kefang.autoditacte.service.StudentDetailService;
import com.kefang.autoditacte.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-26
 */
@Controller
public class StudentDetailController {
    @Autowired
    private StudentDetailService studentDetailService;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = {"/studentManager/4/student"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData save(@RequestBody StudentParam param) {
        return studentService.saveAllStudent(param);
    }

    @RequestMapping(value = {"/studentManager/4/editStudent"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData update(@RequestBody StudentParam param) {
        StudentDto studentDto = new StudentDto();
        studentDto.setStudent((Student) studentService.updateStudent(param).getResultData());
        studentDto.setStudentDetail((StudentDetail) studentDetailService.updateStudentDetail(param).getResultData());
        return JsonData.success(studentDto, "success");
    }

    @RequestMapping(value = {"/studentManager/4/delete"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData delete(@RequestParam("id") String id) {
        studentService.deleteStudentById(id);
        studentDetailService.deleteStudentDetailById(id);
        return JsonData.success(1, "success");
    }

    @RequestMapping(value = {"/studentManager/4/students"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getStudentDetailsByName(@RequestParam(value = "status", required = false) String status, @RequestParam(value = "keyWord", required = false) String keyWord, TailPage page) {
        return studentService.getAllStudents(null, status, keyWord, page);
    }

}