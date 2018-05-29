package com.kefang.autoditacte.param;

import lombok.Getter;
import lombok.Setter;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-24
 */
@Getter
@Setter
public class ExerciseParam {

    /**
     * ID
     */
    private String id;
    /**
     * 习题类型
     */
    private String typeId;
    /**
     * 习题编码
     */
    private String exerciseId;
    /**
     * 题目
     */
    private String name;
    /**
     * 所属课程
     */
    private String exerciseCourse;
    /**
     * 课程id
     */
    private String courseId;
    /**
     * 备注
     */
    private String remark;
    /**
     * 答案
     */
    private String answer;
    /**
     * 状态:radio
     */
    private Integer status;


}