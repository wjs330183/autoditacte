package com.kefang.autoditacte.service;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.entity.ExerciseCourse;
import com.kefang.autoditacte.entity.Ware;
import com.kefang.autoditacte.param.ExerciseCourseParam;

import java.util.*;

/**
 * 描述： 服务实现层接口
 *
 * @author Json
 * @date 2018-05-23
 */
public interface ExerciseCourseService {


    /**
     * 单个保存
     *
     * @param courseName     课程名称
     * @param courseCode     课程编码（隐藏）
     * @param exerciseNumber 习题数量
     * @param status         状态：0/1：启用/未启用
     * @param remark         备注
     * @param operator       操作者编号
     */
    JsonData saveExerciseCourse(ExerciseCourseParam param);

    /**
     * 批量保存
     * @param exerciseCourseJson 对象集合 Json 字符串
     * @param operator 操作者编号
     */
//    JsonData saveExerciseCourseBatch(String exerciseCourseJson);

    /**
     * 根据id获取对象
     *
     * @param id 序号
     */
    JsonData getExerciseCourseById(String id);

    /**
     * 根据id删除对象
     *
     * @param id 序号
     */
    JsonData deleteExerciseCourseById(String id);


    /**
     * 更新对象
     *
     * @param id             序号
     * @param courseName     课程名称
     * @param courseCode     课程编码（隐藏）
     * @param exerciseNumber 习题数量
     * @param status         状态：0/1：启用/未启用
     * @param remark         备注
     * @param operator       操作者编号
     */
    JsonData updateExerciseCourse(ExerciseCourseParam param);

    ;


    /**
     * 查询ExerciseCourse
     */
    JsonData getExerciseCourse();

    /**
     * @return
     */
    JsonData getExerciseCourseByName(String courseName, TailPage<ExerciseCourse> pages);
}