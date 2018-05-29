package com.kefang.autoditacte.service.impl;

import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.emuns.IDPrefixAuthority;
import com.kefang.autoditacte.service.WareCourseService;
import com.kefang.autoditacte.utils.SnowflakeIdWorkerUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.utils.CommonUtils;
import com.kefang.autoditacte.service.ExerciseService;
import com.kefang.autoditacte.dao.ExerciseDao;
import com.kefang.autoditacte.entity.Exercise;
import com.kefang.autoditacte.param.ExerciseParam;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-24
 */
@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {

    private static Logger logger = LoggerFactory.getLogger(ExerciseServiceImpl.class);

    @Resource
    private ExerciseDao exerciseDao;

    @Resource
    private WareCourseService wareCourseService;

    /**
     * 单个保存
     */
    @Override
    public JsonData saveExercise(ExerciseParam param) {
        if (CommonUtils.isAnyEmpty()) {
            return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try {
            Exercise exercise = Exercise.builder()
                    .id(SnowflakeIdWorkerUtils.idGenerator(IDPrefixAuthority.MACHINE_ID.getCode(), IDPrefixAuthority.COURSE_EXERCISE.getCode()))
                    .typeId(param.getTypeId())
                    .exerciseId(param.getExerciseId())
                    .name(param.getName())
                    .exerciseCourse(param.getExerciseCourse())
                    .exerciseId(param.getCourseId())
                    .remark(param.getRemark())
                    .answer(param.getAnswer())
                    .status(param.getStatus())
                    .build();
            Date date = new Date();
            exercise.setCreateTime(date);
            exercise.setUpdateTime(date);
            count = exerciseDao.save(exercise);
        } catch (Exception e) {
            logger.error("saveExercise error:{}", e.getMessage());
            return JsonData.fail("添加失败");
        }
        return JsonData.success(count, "添加成功");
    }


//    /**
//     * 批量保存
//     */
//    @Override
//    JsonData saveExerciseBatch (String exerciseJson){
//        if(CommonUtils.isEmpty(exerciseJson)){
//            result.setCode("1");
//            result.setCode("1");
//            return result;
//        }
//        try{
//            List<Exercise> exerciseList = CommonUtils.getListByJson(exerciseJson, Exercise.class);
//
//            if (CommonUtils.isEmpty(exerciseList)) {
//                result.setCode("1");
//                result.setMessage("1");
//                return result;
//            }
//
//            // TODO : 前置代码
//            exerciseDao.saveBatch(exerciseList);
//            result.setData(True);
//
//            // TODO : 后置代码
//        } catch (Exception e){
//            logger.error("saveExerciseBatch error:{}", e.getMessage());
//            result.setCode("1");
//            result.setMessage("1");
//        }
//        return result;
//    }

    /**
     * 根据id获取对象
     */
    @Override
    public JsonData getExerciseById(String id) {
        if (CommonUtils.isEmpty(id)) {
            return JsonData.fail("id is empty");
        }
        Exercise exercise = null;
        try {
            exercise = exerciseDao.getById(id);
        } catch (Exception e) {
            logger.error("saveExerciseById error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(exercise, "查询成功");
    }

    /**
     * 根据id删除对象
     */
    @Override
    public JsonData deleteExerciseById(String id) {
        if (CommonUtils.isEmpty(id)) {
            return JsonData.fail("id is empty");
        }
        int count = 0;
        try {
            count = exerciseDao.deleteById(id);
        } catch (Exception e) {
            logger.error("deleteExerciseById error:{}", e.getMessage());
            return JsonData.fail("删除失败");
        }
        return JsonData.success(count, "删除成功");
    }


    /**
     * 更新对象
     */
    @Override
    public JsonData updateExercise(ExerciseParam param) {
        if (CommonUtils.isAnyEmpty()) {
            return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try {
            Exercise exercise = Exercise.builder()
                    .id(param.getId())
                    .typeId(param.getTypeId())
                    .exerciseId(param.getExerciseId())
                    .name(param.getName())
                    .exerciseCourse(param.getExerciseCourse())
                    .exerciseId(param.getCourseId())
                    .remark(param.getRemark())
                    .answer(param.getAnswer())
                    .status(param.getStatus())
                    .build();
            Date date = new Date();
            exercise.setCreateTime(date);
            exercise.setUpdateTime(date);
            count = exerciseDao.update(exercise);
        } catch (Exception e) {
            logger.error("updateExercise error:{}", e.getMessage());
            return JsonData.fail("修改失败");
        }
        return JsonData.success(count, "修改成功");
    }


    /**
     * 查询所有
     */
    @Override
    public JsonData getExercise(String courseName, TailPage<Exercise> pages) {
        Integer page = pages.getPageNum();
        Integer length = pages.getPageSize();
        List<Exercise> exerciseList = null;
        try {
            Integer start = (page - 1) * length;
            exerciseList = exerciseDao.getExercise(courseName, start, length);
            int count = exerciseDao.getExerciseCount(courseName);
            pages.setItemsTotalCount(count);
            pages.setItems(exerciseList);
        } catch (Exception e) {
            logger.error("getExercise error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(pages, "查询成功");
    }

    @Override
    public JsonData getExerciseById(String id, TailPage<Exercise> pages) {
        Integer page = pages.getPageNum();
        Integer length = pages.getPageSize();
        List<Exercise> exerciseList = null;
        try {
            Integer start = (page - 1) * length;
            exerciseList = exerciseDao.getExerciseById(id, start, length);
            int count = exerciseDao.getExerciseCountById(id);
            pages.setItemsTotalCount(count);
            pages.setItems(exerciseList);
        } catch (Exception e) {
            logger.error("getExercise error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(pages, "查询成功");

    }

}