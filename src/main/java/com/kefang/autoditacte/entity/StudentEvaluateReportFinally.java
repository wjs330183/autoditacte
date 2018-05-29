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
public class StudentEvaluateReportFinally extends BaseEntity {

    /**
    *
    */
    private String id;

    /**
    *
    */
    private String studentEvaluateReportId;

    /**
    *课程学习成绩
    */
    private Double courseScore;

    /**
    *平时作业成绩
    */
    private Double workScore;

    /**
    *学习表现成绩（网络）
    */
    private Double loginScore;

    /**
    *综合测验成绩
    */
    private Double examScore;

}