package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.entity.StudentEvaluateReport;
import com.kefang.autoditacte.dao.StudentEvaluateReportDao;
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
public interface StudentEvaluateReportDao {

    int save(@Param("entity") StudentEvaluateReport entity);

    int insertBatch(@Param("entities") List<StudentEvaluateReport> entities);

    int update(@Param("entity") StudentEvaluateReport entity);

    int deleteById(@Param("id") String id);

    List<StudentEvaluateReport> getStudentEvaluateReportsByPage(@Param("name") String name, @Param("page") TailPage<StudentEvaluateReport> page);

    Integer getTotalItemsCount(@Param("name") String name);

    StudentEvaluateReport getStudentEvaluateReport(String studentId);


}