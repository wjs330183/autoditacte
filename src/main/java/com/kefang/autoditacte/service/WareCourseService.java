package com.kefang.autoditacte.service;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.entity.WareCourse;
import com.kefang.autoditacte.param.WareCourseParam;

import java.util.*;

/**
 * 描述： 服务实现层接口
 *
 * @author Json
 * @date 2018-05-22
 */
public interface WareCourseService {


    /**
     * 单个保存
     *
     * @param wareName    课程名称
     * @param wareCode    课程编码
     * @param wareTeacher 讲师
     * @param wareNumber  课件数量
     * @param status
     * @param update4ime
     * @param wareRemark  备注
     * @param operator    操作者编号
     */
    JsonData saveWareCourse(WareCourseParam param);

    /**
     * 批量保存
     * @param wareCourseJson 对象集合 Json 字符串
     * @param operator 操作者编号
     */
//    JsonData saveWareCourseBatch(String wareCourseJson);

    /**
     * 根据id获取对象
     *
     * @param id
     */
    JsonData getWareCourseById(String id);

    /**
     * 根据id删除对象
     *
     * @param id
     */
    JsonData deleteWareCourseById(String id);


    /**
     * 更新对象
     *
     * @param id
     * @param wareName    课程名称
     * @param wareCode    课程编码
     * @param wareTeacher 讲师
     * @param wareNumber  课件数量
     * @param status
     * @param update4ime
     * @param wareRemark  备注
     * @param operator    操作者编号
     */
    JsonData updateWareCourse(WareCourseParam param);

    ;


    /**
     * 查询WareCourse
     */
    JsonData getWareCourse();

    /**
     * 通过name查询
     *
     * @return
     */
    JsonData getWareCourseByName(String courseName, TailPage<WareCourse> pages);

    /**
     * 查询WareCourse,分页
     */
    JsonData getWareCourse(Integer page, Integer length);

    /**
     * 通过name查询id
     *
     * @return
     */
    JsonData getIdByName(String name);

    /**
     * 查询所有课程名字
     */
    JsonData getWareCourseName();

}