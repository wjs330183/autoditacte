package com.kefang.autoditacte.service;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.exception.ParamException;
import com.kefang.autoditacte.param.CourseWareCourseExerciseCourseParam;



public interface CourseWareCourseExerciseCourseService {

    Integer save(CourseWareCourseExerciseCourseParam param) throws Exception;

    Integer update(CourseWareCourseExerciseCourseParam param) throws Exception;

    Integer deleteByCourseId(String courseId) throws ParamException;

    String getWareCourseIdByCourseId(String courseId) throws ParamException;

    String getExerciseCourseIdByCourseId(String courseId) throws ParamException;



   // JsonData<CourseWareCourseExerciseCourse> getByCourseId(String courseId);
   // JsonData getCoursesByPage(String courseName, TailPage page);






}
