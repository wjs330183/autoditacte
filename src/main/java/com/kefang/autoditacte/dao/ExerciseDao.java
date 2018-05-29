package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.entity.Exercise;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.*;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-18
 */
@Mapper
public interface ExerciseDao {

    int save(@Param("entity") Exercise entity);

//    int saveBatch(@Param("entities")List    entities);

    int update(@Param("entity") Exercise entity);

    Exercise getById(@Param("id") String id);

    int deleteById(String id);

    List getExercise(@Param("courseName") String courseName,
                     @Param("start") Integer start, @Param("length") Integer length);

    int getExerciseCount(@Param("courseName") String courseName);

    List getExerciseById(@Param("id") String id,
                     @Param("start") Integer start, @Param("length") Integer length);

    int getExerciseCountById(@Param("id") String id);

}