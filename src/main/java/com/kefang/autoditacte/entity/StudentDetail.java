package com.kefang.autoditacte.entity;

import java.util.*;
import lombok.*;

/**
* 描述：
* @author Json
* @date 2018-05-26
*/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDetail extends BaseEntity {

    /**
    *ID
    */
    private String id;

    /**
    *
    */
    private String studentId;

    /**
    *身份证照片地址
    */
    private String cardImg;

    /**
    *准考证照片
    */
    private String codeImg;

    /**
    *报名照片
    */
    private String applyImg;

    /**
    *
    */
    private Integer age;

    /**
    *出生日期
    */
    private String birthday;

    /**
    *民族
    */
    private String nation;

    /**
    *邮编
    */
    private String zipCode;

    /**
    *Email
    */
    private String email;

    /**
    *毕业院校
    */
    private String graduateSchool;

    /**
    *毕业年份
    */
    private String graduateDate;

    /**
    *高校学籍号
    */
    private String schoolRollNo;

    /**
    *毕业证书编号
    */
    private String diplomaNo;

    /**
    *学习形式
    */
    private Integer studyKind;

    /**
    *集体代码
    */
    private String collectiveCode;

    /**
    *年度码
    */
    private String yearCode;

    /**
    *是否归档
    */
    private Boolean pigeonhole;

    /**
    *通讯地址
    */
    private String address;

    /**
    *备注
    */
    private String note;

}