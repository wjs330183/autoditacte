package com.kefang.autoditacte.service.impl;

import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.emuns.IDPrefixAuthority;
import com.kefang.autoditacte.utils.SnowflakeIdWorkerUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.utils.CommonUtils;
import com.kefang.autoditacte.service.ExerciseCourseService;
import com.kefang.autoditacte.dao.ExerciseCourseDao;
import com.kefang.autoditacte.entity.ExerciseCourse;
import com.kefang.autoditacte.param.ExerciseCourseParam;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;

import com.kefang.autoditacte.service.ExerciseCourseService;

/**
* 描述：
* @author Json
* @date 2018-05-23
*/
@Service("exerciseCourseService")
public class ExerciseCourseServiceImpl implements ExerciseCourseService {

    private static Logger logger = LoggerFactory.getLogger(ExerciseCourseServiceImpl.class);

    @Resource
    private ExerciseCourseDao exerciseCourseDao;

    /**
    * 单个保存
    */
    @Override
    public JsonData saveExerciseCourse(ExerciseCourseParam param){
        if(CommonUtils.isAnyEmpty()){
        return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try{
        ExerciseCourse exerciseCourse = ExerciseCourse.builder()
                    .id(SnowflakeIdWorkerUtils.idGenerator(IDPrefixAuthority.MACHINE_ID.getCode(),IDPrefixAuthority.EXERCISE_COURSE.getCode()))
                    .courseName(param.getCourseName())
                    .courseCode(param.getCourseCode())
                    .exerciseNumber(param.getExerciseNumber())
                    .status(param.getStatus())
                    .remark(param.getRemark())
        .build();
            Date date= new Date();
            exerciseCourse.setCreateTime(date);
            exerciseCourse.setUpdateTime(date);
            count = exerciseCourseDao.save(exerciseCourse);
        } catch (Exception e){
            logger.error("saveExerciseCourse error:{}", e.getMessage());
            return JsonData.fail("添加失败");
        }
        return JsonData.success(count,"添加成功");
    }


//    /**
//    * 批量保存
//    */
//    @Override
//    JsonData saveExerciseCourseBatch (String exerciseCourseJson){
//        if(CommonUtils.isEmpty(exerciseCourseJson)){
//            result.setCode("1");
//            result.setCode("1");
//            return result;
//        }
//        try{
//            List<ExerciseCourse> exerciseCourseList = CommonUtils.getListByJson(exerciseCourseJson, ExerciseCourse.class);
//
//            if (CommonUtils.isEmpty(exerciseCourseList)) {
//                result.setCode("1");
//                result.setMessage("1");
//                return result;
//            }
//
//            // TODO : 前置代码
//            exerciseCourseDao.saveBatch(exerciseCourseList);
//            result.setData(True);
//
//            // TODO : 后置代码
//        } catch (Exception e){
//            logger.error("saveExerciseCourseBatch error:{}", e.getMessage());
//            result.setCode("1");
//            result.setMessage("1");
//        }
//        return result;
//    }

    /**
    * 根据id获取对象
    */
    @Override
    public JsonData getExerciseCourseById (String id){
        if(CommonUtils.isEmpty(id)){
            return JsonData.fail("id is empty");
        }
        ExerciseCourse exerciseCourse = null;
        try{
            exerciseCourse = exerciseCourseDao.getById(id);
        } catch (Exception e){
            logger.error("saveExerciseCourseById error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(exerciseCourse,"查询成功");
    }

    /**
    * 根据id删除对象
    */
    @Override
    public JsonData deleteExerciseCourseById(String id){
        if(CommonUtils.isEmpty(id)){
            return JsonData.fail("id is empty");
        }
        int count = 0;
        try{
        count = exerciseCourseDao.deleteById(id);
        } catch (Exception e){
            logger.error("deleteExerciseCourseById error:{}", e.getMessage());
            return JsonData.fail("删除失败");
        }
        return JsonData.success(count,"删除成功");
    }



    /**
    * 更新对象
    */
    @Override
    public JsonData updateExerciseCourse (ExerciseCourseParam param){
        if(CommonUtils.isAnyEmpty()){
        return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try{
            ExerciseCourse exerciseCourse = ExerciseCourse.builder()
                    .id(param.getId())
                    .courseName(param.getCourseName())
                    .courseCode(param.getCourseCode())
                    .exerciseNumber(param.getExerciseNumber())
                    .status(param.getStatus())
                    .remark(param.getRemark())
            .build();
            Date date = new Date();
            exerciseCourse.setCreateTime(date);
            exerciseCourse.setUpdateTime(date);
            count = exerciseCourseDao.update(exerciseCourse);
        } catch (Exception e){
            logger.error("updateExerciseCourse error:{}", e.getMessage());
            return JsonData.fail("修改失败");
        }
        return JsonData.success(count,"修改成功");
    }



    /**
    * 查询所有
    */
    @Override
    public JsonData getExerciseCourse (){
        List<ExerciseCourse> exerciseCourseList = null;
        try{
            exerciseCourseList = exerciseCourseDao.getExerciseCourse();
        } catch (Exception e){
            logger.error("getExerciseCourse error:{}", e.getMessage());
            return JsonData.fail("修改失败");
        }
        return JsonData.success(exerciseCourseList,"查询成功");
    }

    @Override
    public JsonData getExerciseCourseByName(String courseName, TailPage<ExerciseCourse> pages) {
        Integer page = pages.getPageNum();
        Integer length = pages.getPageSize();
        if (page == 0) {
            return JsonData.fail("页码不能为0");
        }
        List<ExerciseCourse> wareCourseList = null;
        try {
            Integer start = (page - 1) * length;
            wareCourseList = exerciseCourseDao.getExerciseCourseLimit(courseName, start, length);
            pages.setItems(wareCourseList);
            pages.setItemsTotalCount(exerciseCourseDao.getExerciseCount(courseName));
        } catch (Exception e) {
            logger.error("getWareCourse error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(pages, "查询成功");
    }

}