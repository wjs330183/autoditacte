package com.kefang.autoditacte.param;

import lombok.Getter;
import lombok.Setter;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-28
 */
@Getter
@Setter
public class StudentEvaluateReportFinallyParam {

    /**
     *
     */
    private String id;
    /**
     *
     */
    private String studentEvaluateReportId;
    /**
     * 课程学习成绩
     */
    private Double courseScore;
    /**
     * 平时作业成绩
     */
    private Double workScore;
    /**
     * 学习表现成绩（网络）
     */
    private Double loginScore;
    /**
     * 综合测验成绩
     */
    private Double examScore;


}