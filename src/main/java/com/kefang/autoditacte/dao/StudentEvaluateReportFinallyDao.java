package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.entity.StudentEvaluateReportFinally;
import com.kefang.autoditacte.dao.StudentEvaluateReportFinallyDao;
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
public interface StudentEvaluateReportFinallyDao {

    int save(@Param("entity") StudentEvaluateReportFinally entity);

    int insertBatch(@Param("entities") List<StudentEvaluateReportFinally> entities);

    int update(@Param("entity") StudentEvaluateReportFinally entity);

    int deleteById(@Param("id") String id);

    List<StudentEvaluateReportFinally> getStudentEvaluateReportFinallysByPage(@Param("name") String name, @Param("page") TailPage<StudentEvaluateReportFinally> page);

    Integer getTotalItemsCount(@Param("name") String name);
}