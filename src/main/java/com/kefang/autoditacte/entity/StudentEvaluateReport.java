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
public class StudentEvaluateReport extends BaseEntity {

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
    *平时成绩（函授站评分）
     *
    */
    private Double commonScore;

    /**
    *登陆次数（课程点击次数）
    */
    private Integer loginTimes;

    /**
    *提交笔记次数
    */
    private Integer noteTimes;

    /**
    *提交作业次数
    */
    private Integer workTimes;

    /**
    *综合测验成绩
    */
    private Double examScore;

}