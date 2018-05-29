package com.kefang.autoditacte.controller;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.entity.Exercise;
import com.kefang.autoditacte.param.ExerciseParam;
import com.kefang.autoditacte.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-24
 */
@Controller
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;

    @RequestMapping(value = {"/resourceManagement/5/Exercise"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData save(@RequestBody ExerciseParam param) {
        return exerciseService.saveExercise(param);
    }

    @RequestMapping(value = {"/resourceManagement/5/editExercise"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData update(@RequestBody ExerciseParam param) {
        return exerciseService.updateExercise(param);
    }

    @RequestMapping(value = {"/resourceManagement/5/delete"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData delete(@RequestParam("id") String id) {
        return exerciseService.deleteExerciseById(id);
    }

    @RequestMapping(value = {"/resourceManagement/5/Exercises"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getExerciseByName(@RequestParam(value = "courseName", required = false) String courseName, TailPage<Exercise> pages) {

        return exerciseService.getExercise(courseName, pages);
    }

    @RequestMapping(value = {"/resourceManagement/5/ExercisesById"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getExerciseById(@RequestParam(value = "id", required = false) String id, TailPage<Exercise> pages) {

        return exerciseService.getExerciseById(id, pages);
    }

}