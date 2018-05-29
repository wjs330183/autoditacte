package com.kefang.autoditacte.entity;


import lombok.*;

/**
* 描述：
* @author Json
* @date 2018-05-18
*/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Major extends BaseEntity {

    /**
    *ID
    */
    private String id;

    /**
    *专业代码
    */
    private String code;

    /**
    *专业名称
    */
    private String name;
    /**
     *所属学校
    */
    private String siteId;

    /**
    *备注
    */
    private String note;

    /**
    *状态:radio
    */
    private Integer status;


}