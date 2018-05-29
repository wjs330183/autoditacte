package com.kefang.autoditacte.param;

import lombok.Getter;
import lombok.Setter;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-26
 */
@Getter
@Setter
public class StudentParam {

    /**
     * ID
     */
    private String id;
    /**
     * 准考证号
     */
    private String code;
    /**
     * 姓名
     */
    private String name;
    /**
     *
     */
    private String password;
    /**
     * 证件类型： 0 身份证 1 港澳通行证 2 军官证
     */
    private Integer cardType;
    /**
     * 证件号码
     */
    private String cardId;
    /**
     * 家庭电话
     */
    private String phone;
    /**
     * 科类
     */
    private String majorId;
    /**
     * 助学机构id
     */
    private String stationId;
    /**
     * 主考院校id
     */
    private String siteId;
    /**
     * 是否刷身份证
     */
    private Boolean byCard;
    /**
     * 备注
     */
    private String note;
    /**
     * 审核状态： 0 待审核 1 通过 2 不通过
     */
    private Integer auditStatus;
    /**
     * 是否隐藏
     */
    private Boolean hide;
    /**
     * 状态: 0 禁用 1启用
     */
    private Boolean status;

    /**
     *
     */
    private String studentId;
    /**
     * 身份证照片地址
     */
    private String cardImg;
    /**
     * 准考证照片
     */
    private String codeImg;
    /**
     * 报名照片
     */
    private String applyImg;
    /**
     *
     */
    private Integer age;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 民族
     */
    private String nation;
    /**
     * 邮编
     */
    private String zipCode;
    /**
     * Email
     */
    private String email;
    /**
     * 毕业院校
     */
    private String graduateSchool;
    /**
     * 毕业年份
     */
    private String graduateDate;
    /**
     * 高校学籍号
     */
    private String schoolRollNo;
    /**
     * 毕业证书编号
     */
    private String diplomaNo;
    /**
     * 学习形式
     */
    private Integer studyKind;
    /**
     * 集体代码
     */
    private String collectiveCode;
    /**
     * 年度码
     */
    private String yearCode;
    /**
     * 是否归档
     */
    private Boolean pigeonhole;
    /**
     * 通讯地址
     */
    private String address;



}