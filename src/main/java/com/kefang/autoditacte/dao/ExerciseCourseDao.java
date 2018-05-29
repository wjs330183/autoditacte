package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.entity.ExerciseCourse;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.*;

/**
* 描述：
* @author Json
* @date 2018-05-23
*/
@Mapper
public interface ExerciseCourseDao {

    int save(@Param("entity")ExerciseCourse entity);

//    int saveBatch(@Param("entities")List<ExerciseCourse> entities);

    int update(@Param("entity")ExerciseCourse entity);

    ExerciseCourse getById (@Param("id")String id);

    int deleteById (String id);


    List<ExerciseCourse> getExerciseCourse ();

    List<ExerciseCourse> getExerciseCourseLimit (@Param("courseName") String courseName,
                                                 @Param("start") Integer start, @Param("length") Integer length);

    int getExerciseCount(@Param("courseName") String courseName);


}