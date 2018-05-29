package com.kefang.autoditacte.entity;

import java.util.*;
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
public class Course extends BaseEntity {

    /**
    *ID
    */
    private String id;

    /**
    *课程名称
    */
    private String name;

    /**
    *课程封面:img
    */
    private String code;

    /**
    *课程简介
    */
    private String note;

    /**
    *状态:radio
    */
    private Integer status;
    /***
     * 价格
     */
    private Double price;
    /**
     * 售价
     */
    private Double soldPrice;


}