package com.kefang.autoditacte.entity;

import java.util.*;
import lombok.*;

/**
* 描述：
* @author Json
* @date 2018-05-28
*/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentEvaluate extends BaseEntity {

    /**
    *
    */
    private String id;

    /**
    *
    */
    private String studentId;

    /**
    *
    */
    private String courseId;

    /**
    *审核状态 0 未审核 1 通过 2不通过
    */
    private Integer applyStatus;

    /**
    *通过时间
    */
    private Date applyTime;

}