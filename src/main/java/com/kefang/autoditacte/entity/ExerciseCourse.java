package com.kefang.autoditacte.entity;

import java.util.*;
import lombok.*;

/**
* 描述：
* @author Json
* @date 2018-05-23
*/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseCourse extends BaseEntity {

    /**
    *序号
    */
    private String id;

    /**
    *课程名称
    */
    private String courseName;

    /**
    *课程编码（隐藏）
    */
    private String courseCode;

    /**
    *习题数量
    */
    private String exerciseNumber;

    /**
    *状态：0/1：启用/未启用
    */
    private Integer status;

    /**
    *备注
    */
    private String remark;

}