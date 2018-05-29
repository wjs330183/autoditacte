package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.entity.MajorCourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MajorCourseDao {
    int save(MajorCourse majorCourse);
    int deleteByMajorId(String majorId);
    List<String> getCourseIdListByMajorId(String majorId);
}
