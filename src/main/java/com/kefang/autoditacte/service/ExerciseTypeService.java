package com.kefang.autoditacte.service;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.entity.ExerciseType;
import com.kefang.autoditacte.param.ExerciseTypeParam;

import java.util.*;

/**
 * 描述： 服务实现层接口
 *
 * @author Json
 * @date 2018-05-23
 */
public interface ExerciseTypeService {


    /**
     * 单个保存
     *
     * @param exerciseName 习题类型
     * @param exerciseKind 答题方式
     * @param remark       备注
     * @param status       状态：0/1：启用/未启用
     * @param operator     操作者编号
     */
    JsonData saveExerciseType(ExerciseTypeParam param);

    /**
     * 批量保存
     * @param exerciseTypeJson 对象集合 Json 字符串
     * @param operator 操作者编号
     */
//    JsonData saveExerciseTypeBatch(String exerciseTypeJson);

    /**
     * 根据id获取对象
     *
     * @param id 序号
     */
    JsonData getExerciseTypeById(String id);

    /**
     * 根据id删除对象
     *
     * @param id 序号
     */
    JsonData deleteExerciseTypeById(String id);


    /**
     * 更新对象
     *
     * @param id           序号
     * @param exerciseName 习题类型
     * @param exerciseKind 答题方式
     * @param remark       备注
     * @param status       状态：0/1：启用/未启用
     * @param operator     操作者编号
     */
    JsonData updateExerciseType(ExerciseTypeParam param);

    ;


    /**
     * 查询ExerciseType
     */
    JsonData getExerciseType(Integer page, Integer length);

}