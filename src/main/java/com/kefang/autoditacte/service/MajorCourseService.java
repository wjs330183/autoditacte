package com.kefang.autoditacte.service;

import com.kefang.autoditacte.common.JsonData;

import java.util.List;

public interface MajorCourseService {
    JsonData batchSave(String majorId, List<String> courseIdList);
    JsonData update(String majorId,List<String> courseIdList);
    JsonData delete(String majorId);
    List<String> getCourseIdListByMajorId(String majorId);
}
