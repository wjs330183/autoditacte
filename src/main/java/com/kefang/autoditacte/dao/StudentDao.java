package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.entity.Student;
import com.kefang.autoditacte.dao.StudentDao;
import com.kefang.autoditacte.common.*;

import com.kefang.autoditacte.entity.StudentEvaluate;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;


/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-26
 */
@Mapper
public interface StudentDao {

    int save(@Param("entity") Student entity);

    int insertBatch(@Param("entities") List<Student> entities);

    int update(@Param("entity") Student entity);

    int deleteById(@Param("id") String id);

    List<Student> getStudentsByPage(@Param("name") String name, @Param("page") TailPage<Student> page);

    List<Student> getStudents(@Param("stationId") String stationId, @Param("status") String status, @Param("keyWord") String keyWord, @Param("page") TailPage<Student> page);

    Integer getTotalItemsCount(@Param("name") String name);

    Integer getTotalItemsCounts(@Param("stationId") String stationId, @Param("status") String status, @Param("keyWord") String keyWord);

    Student getStudentById(String id);

}