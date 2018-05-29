package com.kefang.autoditacte.controller;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.entity.StudentNote;
import com.kefang.autoditacte.param.StudentNoteParam;
import com.kefang.autoditacte.service.StudentNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-28
 */
@Controller
public class StudentNoteController {
    @Autowired
    private StudentNoteService studentNoteService;

    @RequestMapping(value = {"/studentManager/7/studentNote"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData save(@RequestBody StudentNoteParam param) {
        return studentNoteService.saveStudentNote(param);
    }

    @RequestMapping(value = {"/studentManager/7/editStudentNote"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData update(@RequestBody StudentNoteParam param) {
        return studentNoteService.updateStudentNote(param);
    }

    @RequestMapping(value = {"/studentManager/7/delete"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData delete(@RequestParam("id") String id) {
        return studentNoteService.deleteStudentNoteById(id);
    }

    @RequestMapping(value = {"/studentManager/7/studentNotes"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getStudentNotesByName(@RequestParam(value = "name", required = false) String name, TailPage pages) {
        return studentNoteService.getStudentNotesByPage(name, pages);
    }

}