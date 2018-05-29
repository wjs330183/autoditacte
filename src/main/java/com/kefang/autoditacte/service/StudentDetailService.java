package com.kefang.autoditacte.service;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.entity.StudentDetail;

import com.kefang.autoditacte.common.*;
import com.kefang.autoditacte.param.StudentParam;

import java.util.List;

/**
 * 描述： 服务实现层接口
 *
 * @author Json
 * @date 2018-05-26
 */
public interface StudentDetailService {


    /**
     * 单个保存
     *
     * @param studentId
     * @param cardImg        身份证照片地址
     * @param codeImg        准考证照片
     * @param applyImg       报名照片
     * @param age
     * @param birthday       出生日期
     * @param nation         民族
     * @param zipCode        邮编
     * @param email          Email
     * @param graduateSchool 毕业院校
     * @param graduateDate   毕业年份
     * @param schoolRollNo   高校学籍号
     * @param diplomaNo      毕业证书编号
     * @param studyKind      学习形式
     * @param collectiveCode 集体代码
     * @param yearCode       年度码
     * @param isPigeonhole   是否归档
     * @param address        通讯地址
     * @param note           备注
     * @param operator       操作者编号
     */
    JsonData saveStudentDetail(StudentParam param, String id);

    /**
     * 通过id删除StudentDetail
     */
    JsonData deleteStudentDetailById(String id);


    /**
     * 更新对象
     *
     * @param id             ID
     * @param studentId
     * @param cardImg        身份证照片地址
     * @param codeImg        准考证照片
     * @param applyImg       报名照片
     * @param age
     * @param birthday       出生日期
     * @param nation         民族
     * @param zipCode        邮编
     * @param email          Email
     * @param graduateSchool 毕业院校
     * @param graduateDate   毕业年份
     * @param schoolRollNo   高校学籍号
     * @param diplomaNo      毕业证书编号
     * @param studyKind      学习形式
     * @param collectiveCode 集体代码
     * @param yearCode       年度码
     * @param isPigeonhole   是否归档
     * @param address        通讯地址
     * @param note           备注
     * @param operator       操作者编号
     */
    JsonData updateStudentDetail(StudentParam param);


    /**
     * 分页模糊查询StudentDetail
     */
    JsonData getStudentDetailsByPage(String name, TailPage page);

    /**
     * id查询所有
     */
    StudentDetail getStudentDetailsById(String id);

}