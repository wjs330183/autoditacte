package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.dto.StudentNoteDto;
import com.kefang.autoditacte.entity.StudentNote;
import com.kefang.autoditacte.dao.StudentNoteDao;
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
public interface StudentNoteDao {

    int save(@Param("entity") StudentNote entity);

    int insertBatch(@Param("entities") List<StudentNote> entities);

    int update(@Param("entity") StudentNote entity);

    int deleteById(@Param("id") String id);

    List getStudentNotesByPage(@Param("courseId") String courseId, @Param("page") TailPage page);

    Integer getTotalItemsCount(@Param("courseId") String courseId);
}