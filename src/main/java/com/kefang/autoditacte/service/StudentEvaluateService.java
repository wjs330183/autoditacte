package com.kefang.autoditacte.service;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.entity.StudentEvaluate;
import com.kefang.autoditacte.param.StudentEvaluateParam;

import java.util.*;

import com.kefang.autoditacte.common.*;

/**
 * 描述： 服务实现层接口
 *
 * @author Json
 * @date 2018-05-28
 */
public interface StudentEvaluateService {


    /**
     * 单个保存
     *
     * @param studentId
     * @param courseId
     * @param applyStatus 审核状态 0 未审核 1 通过 2不通过
     * @param applyTime   通过时间
     * @param operator    操作者编号
     */
    JsonData saveStudentEvaluate(StudentEvaluateParam param);

    /**
     * 通过id删除StudentEvaluate
     */
    JsonData deleteStudentEvaluateById(String id);


    /**
     * 更新对象
     *
     * @param id
     * @param studentId
     * @param courseId
     * @param applyStatus 审核状态 0 未审核 1 通过 2不通过
     * @param applyTime   通过时间
     * @param operator    操作者编号
     */
    JsonData updateStudentEvaluate(StudentEvaluateParam param);


    /**
     * 分页模糊查询StudentEvaluate
     */
    JsonData getStudentEvaluatesByPage(String name, TailPage<StudentEvaluate> page);


    JsonData getStudentEvaluates(String year, String stage, String courseName, String stationName, String status, String keyWord, TailPage<StudentEvaluate> page);

    List<StudentEvaluate> getAllEvaluates();


}