package com.kefang.autoditacte.entity;

import java.util.*;
import lombok.*;

/**
 * 描述：
 * @author Json
 * @date 2018-05-22
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WareCourse extends BaseEntity {

    /**
     *
     */
    private String id;

    /**
     *课程名称
     */
    private String courseName;

    /**
     *课程编码
     */
    private String wareCode;

    /**
     *讲师
     */
    private String wareTeacher;

    /**
     *课件数量
     */
    private String wareNumber;

    /**
     *
     */
    private Integer status;

    /**
     *备注
     */
    private String wareRemark;

}