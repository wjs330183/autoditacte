package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.entity.WareCourse;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.*;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-22
 */
@Mapper
public interface WareCourseDao {

    int save(@Param("entity") WareCourse entity);

//    int saveBatch(@Param("entities")List<WareCourse> entities);

    int update(@Param("entity") WareCourse entity);

    WareCourse getById(@Param("id") String id);

    int deleteById(@Param("id") String id);


    List<WareCourse> getWareCourse();

    List<WareCourse> getWareCourseByName(@Param("courseName") String courseName,
                                         @Param("start") Integer start, @Param("length") Integer length);

    List<WareCourse> getWareCourseLimit(@Param("start") Integer start, @Param("length") Integer length);

    int getWareCourseCount(@Param("courseName") String courseName);

    List<String> getIdByName(@Param("name") String name);

    List<String> getWareCourseName();

}