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
public class StudentEvaluateReportParam {

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
     * 平时成绩（函授站评分）
     */
    private Double commonScore;
    /**
     * 登陆次数（课程点击次数）
     */
    private Integer loginTimes;
    /**
     * 提交笔记次数
     */
    private Integer noteTimes;
    /**
     * 提交作业次数
     */
    private Integer workTimes;
    /**
     * 综合测验成绩
     */
    private Double examScore;


}