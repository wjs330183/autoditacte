package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.entity.Course;

import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.*;

/**
* 描述：
* @author Json
* @date 2018-05-18
*/
@Mapper
public interface CourseDao {

    Integer save(@Param("entity")Course entity);

    int insertBatch(@Param("entities")List  entities);

    int update(@Param("entity")Course entity);

    Course getById (@Param("id")String id);

    Course getByName(String name);


    int deleteById (String id);

    List<Course>  getCourses();

    Integer getTotalItemsCount(@Param("courseName") String courseName);

    List<Course> getCoursesByPage(@Param("courseName") String courseName,@Param("page") TailPage<Course> page);




}