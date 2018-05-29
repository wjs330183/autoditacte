package com.kefang.autoditacte.param;

import lombok.Getter;
import lombok.Setter;

/**
 * 描述：
 * @author Json
 * @date 2018-05-23
 */
@Getter
@Setter
public class WareParam {

    /**
     *ID
     */
    private String id;
    /**
     *课件课程id
     */
    private String wareCourseId;
    /**
     *课件名称
     */
    private String wareName;
    /**
     *课件编码
     */
    private String wareId;
    /**
     *所属课程
     */
    private String wareCourse;
    /**
     *讲师名字
     */
    private String teacherName;
    /**
     *课程url
     */
    private String playUrl;
    /**
     *封面url
     */
    private String imgUrl;
    /**
     *观看次数
     */
    private String playCount;
    /**
     *时长(秒)
     */
    private String time;
    /**
     *备注
     */
    private String remark;
    /**
     *状态:radio
     */
    private Integer status;


}