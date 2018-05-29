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
public class ExerciseType extends BaseEntity {

    /**
    *序号
    */
    private String id;

    /**
    *习题类型
    */
    private String exerciseName;

    /**
    *答题方式
    */
    private String exerciseKind;

    /**
    *备注
    */
    private String remark;

    /**
    *状态：0/1：启用/未启用
    */
    private Integer status;

}