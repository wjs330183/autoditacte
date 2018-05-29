package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.entity.StudentEvaluate;
import com.kefang.autoditacte.dao.StudentEvaluateDao;
import com.kefang.autoditacte.common.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.*;


/**
* 描述：
* @author Json
* @date 2018-05-28
*/
@Mapper
public interface StudentEvaluateDao {

    int save(@Param("entity") StudentEvaluate entity);

    int insertBatch(@Param("entities") List<StudentEvaluate> entities);

    int update(@Param("entity") StudentEvaluate entity);

    int deleteById(@Param("id") String id);

    List<StudentEvaluate> getStudentEvaluatesByPage(@Param("name") String name, @Param("page") TailPage<StudentEvaluate> page);

    Integer getTotalItemsCount(@Param("name") String name);

    Integer getTotalItemsCounts(@Param("year")String year, @Param("stage")String stage, @Param("courseName")String courseName,
                                @Param("stationName")String stationName, @Param("status")String status,
                                @Param("keyWord")String keyWord, @Param("page")TailPage<StudentEvaluate> page);

    List<StudentEvaluate> getAllEvaluates();
}