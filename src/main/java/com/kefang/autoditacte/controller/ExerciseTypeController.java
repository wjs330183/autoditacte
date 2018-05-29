package com.kefang.autoditacte.controller;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.entity.ExerciseCourse;
import com.kefang.autoditacte.entity.ExerciseType;
import com.kefang.autoditacte.param.ExerciseTypeParam;
import com.kefang.autoditacte.service.ExerciseTypeService;
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
public class ExerciseTypeController {
    @Autowired
    private ExerciseTypeService exerciseTypeService;

    @RequestMapping(value = {"/resourceManagement/3/exerciseType"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData save(@RequestBody ExerciseTypeParam param) {
        return exerciseTypeService.saveExerciseType(param);
    }

    @RequestMapping(value = {"/resourceManagement/3/editExerciseType"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData update(@RequestBody ExerciseTypeParam param) {
        return exerciseTypeService.updateExerciseType(param);
    }

    @RequestMapping(value = {"/resourceManagement/3/delete"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData delete(@RequestParam("id") String id) {
        return exerciseTypeService.deleteExerciseTypeById(id);
    }

    @RequestMapping(value = {"/resourceManagement/3/exerciseTypes"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getAll(TailPage<ExerciseCourse> pages) {
        Integer page = pages.getPageNum();
        Integer length = pages.getPageSize();
        return exerciseTypeService.getExerciseType(page, length);
    }

}