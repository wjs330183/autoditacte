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
public class Student extends BaseEntity {

    /**
    *ID
    */
    private String id;

    /**
    *准考证号
    */
    private String code;

    /**
    *姓名
    */
    private String name;

    /**
    *
    */
    private String password;

    /**
    *证件类型： 0 身份证 1 港澳通行证 2 军官证
    */
    private Integer cardType;

    /**
    *证件号码
    */
    private String cardId;

    /**
    *家庭电话
    */
    private String phone;

    /**
    *科类
    */
    private String majorId;

    /**
    *助学机构id
    */
    private String stationId;

    /**
    *主考院校id
    */
    private String siteId;

    /**
    *是否刷身份证
    */
    private Boolean byCard;

    /**
    *备注
    */
    private String note;

    /**
    *审核状态： 0 待审核 1 通过 2 不通过
    */
    private Integer auditStatus;

    /**
    *是否隐藏
    */
    private Boolean hide;

    /**
    *状态: 0 禁用 1启用
    */
    private Boolean status;

}