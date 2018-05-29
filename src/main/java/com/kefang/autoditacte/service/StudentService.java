package com.kefang.autoditacte.service;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.dto.StudentDto;
import com.kefang.autoditacte.entity.Student;
import com.kefang.autoditacte.param.StudentParam;

import java.util.*;

import com.kefang.autoditacte.common.*;
import springfox.documentation.spring.web.json.Json;

/**
 * 描述： 服务实现层接口
 *
 * @author Json
 * @date 2018-05-26
 */
public interface StudentService {


    /**
     * 单个保存
     *
     * @param code        准考证号
     * @param name        姓名
     * @param password
     * @param cardType    证件类型： 0 身份证 1 港澳通行证 2 军官证
     * @param cardId      证件号码
     * @param phone       家庭电话
     * @param majorId     科类
     * @param stationId   助学机构id
     * @param siteId      主考院校id
     * @param byCard      是否刷身份证
     * @param createTime  创建时间
     * @param updateTime  更新时间
     * @param note        备注
     * @param auditStatus 审核状态： 0 待审核 1 通过 2 不通过
     * @param hide        是否隐藏
     * @param status      状态: 0 禁用 1启用
     * @param operator    操作者编号
     */
    JsonData saveStudent(StudentParam param);

    /**
     * 通过id删除Student
     */
    JsonData deleteStudentById(String id);


    /**
     * 更新对象
     *
     * @param id          ID
     * @param code        准考证号
     * @param name        姓名
     * @param password
     * @param cardType    证件类型： 0 身份证 1 港澳通行证 2 军官证
     * @param cardId      证件号码
     * @param phone       家庭电话
     * @param majorId     科类
     * @param stationId   助学机构id
     * @param siteId      主考院校id
     * @param byCard      是否刷身份证
     * @param createTime  创建时间
     * @param updateTime  更新时间
     * @param note        备注
     * @param auditStatus 审核状态： 0 待审核 1 通过 2 不通过
     * @param hide        是否隐藏
     * @param status      状态: 0 禁用 1启用
     * @param operator    操作者编号
     */
    JsonData updateStudent(StudentParam param);


    /**
     * 分页模糊查询Student
     */
    JsonData getStudentsByPage(String name, TailPage page);

    JsonData getStudents(String stationId, String status, String keyWord, TailPage page);

    JsonData getAllStudents(String stationId, String status, String keyWord, TailPage page);

    JsonData saveAllStudent(StudentParam param);
}