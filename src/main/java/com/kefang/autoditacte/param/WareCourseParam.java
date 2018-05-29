package com.kefang.autoditacte.param;

import lombok.Getter;
import lombok.Setter;

/**
 * 描述：
 * @author Json
 * @date 2018-05-22
 */
@Getter
@Setter
public class WareCourseParam {

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