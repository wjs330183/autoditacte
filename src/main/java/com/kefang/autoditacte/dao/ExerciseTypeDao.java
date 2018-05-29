package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.entity.ExerciseType;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-23
 */
@Mapper
public interface ExerciseTypeDao {

    int save(@Param("entity") ExerciseType entity);

//    int saveBatch(@Param("entities")List<ExerciseType> entities);

    int update(@Param("entity") ExerciseType entity);

    ExerciseType getById(@Param("id") String id);

    int deleteById(String id);


    List<ExerciseType> getExerciseType(@Param("start") Integer start, @Param("length") Integer length);


}