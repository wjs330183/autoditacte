package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.entity.StudentDetail;
import com.kefang.autoditacte.dao.StudentDetailDao;
import com.kefang.autoditacte.common.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.*;


/**
* 描述：
* @author Json
* @date 2018-05-26
*/
@Mapper
public interface StudentDetailDao {

    int save(@Param("entity") StudentDetail entity);

    int insertBatch(@Param("entities") List<StudentDetail> entities);

    int update(@Param("entity") StudentDetail entity);

    int deleteById(@Param("id") String id);

    List<StudentDetail> getStudentDetailsByPage(@Param("name") String name, @Param("page") TailPage<StudentDetail> page);

    Integer getTotalItemsCount(@Param("name") String name);

    StudentDetail getStudentDetailsById(@Param("id") String id);
}