package com.kefang.autoditacte.controller;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.entity.ExerciseCourse;
import com.kefang.autoditacte.param.ExerciseCourseParam;
import com.kefang.autoditacte.service.ExerciseCourseService;
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
@RequestMapping
public class ExerciseCourseController {
    @Autowired
    private ExerciseCourseService exerciseCourseService;

    @RequestMapping(value = {"/resourceManagement/4/exerciseCourse"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData save(@RequestBody ExerciseCourseParam param) {
        return exerciseCourseService.saveExerciseCourse(param);
    }

    @RequestMapping(value = {"/resourceManagement/4/editExerciseCourse"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData update(@RequestBody ExerciseCourseParam param) {
        return exerciseCourseService.updateExerciseCourse(param);
    }

    @RequestMapping(value = {"/resourceManagement/4/delete"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData delete(@RequestParam("id") String id) {
        return exerciseCourseService.deleteExerciseCourseById(id);
    }

    @RequestMapping(value = {"/resourceManagement/4/exerciseCourses"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getAll() {
        return exerciseCourseService.getExerciseCourse();
    }

    @RequestMapping(value = {"/resourceManagement/4/exerciseCourseByName"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getWareCourseByName(@RequestParam(value = "courseName", required = false) String courseName, TailPage<ExerciseCourse> pages) {

        return exerciseCourseService.getExerciseCourseByName(courseName, pages);
    }
}