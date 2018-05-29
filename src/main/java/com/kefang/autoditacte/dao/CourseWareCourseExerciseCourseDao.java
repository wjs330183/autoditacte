package com.kefang.autoditacte.dao;


import com.kefang.autoditacte.entity.CourseWareCourseExerciseCourse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseWareCourseExerciseCourseDao {

    int deleteByPrimaryKey(String id);


    int insert(CourseWareCourseExerciseCourse record);


    int insertSelective(CourseWareCourseExerciseCourse record);


    CourseWareCourseExerciseCourse selectByPrimaryKey(String id);


    //int updateByPrimaryKeySelective(CourseWareCourseExerciseCourse record);
    //int updateByPrimaryKey(CourseWareCourseExerciseCourse record);

    CourseWareCourseExerciseCourse getByCourseId(String courseId);

    int deleteByCourseId(String courseId);

    String getWareCourseIdByCourseId(String courseId);
    String getExerciseCourseIdByCourseId(String courseId);

}