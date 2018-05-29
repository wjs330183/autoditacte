package com.kefang.autoditacte.controller;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.entity.Course;
import com.kefang.autoditacte.entity.WareCourse;
import com.kefang.autoditacte.param.WareCourseParam;
import com.kefang.autoditacte.service.WareCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-23
 */
@Controller
public class WareCourseController {
    @Autowired
    private WareCourseService wareCourseService;

    @RequestMapping(value = {"/resourceManagement/1/wareCourse"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData save(@RequestBody WareCourseParam param) {
        return wareCourseService.saveWareCourse(param);
    }

    @RequestMapping(value = {"/resourceManagement/1/editWareCourse"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData update(@RequestBody WareCourseParam param) {
        return wareCourseService.updateWareCourse(param);
    }

    @RequestMapping(value = {"/resourceManagement/1/delete"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData delete(@RequestParam("id") String id) {
        return wareCourseService.deleteWareCourseById(id);
    }

    @RequestMapping(value = {"/resourceManagement/1/wareCourses"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getAll() {
        return wareCourseService.getWareCourse();
    }

    @RequestMapping(value = {"/resourceManagement/1/wareCourseLimit"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getAllLimit(@RequestParam("page") Integer page, @RequestParam("length") Integer length) {
        return wareCourseService.getWareCourse(page, length);
    }

    @RequestMapping(value = {"/resourceManagement/1/wareCourseByName"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getWareCourseByName(@RequestParam(value = "courseName", required = false) String courseName, TailPage<WareCourse> pages) {

        return wareCourseService.getWareCourseByName(courseName, pages);
    }
    @RequestMapping(value = {"/resourceManagement/1/wareCourseName"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getWareCourseName() {
        return wareCourseService.getWareCourseName();
    }

}