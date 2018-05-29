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
public class StudentNote extends BaseEntity {

    /**
    *
    */
    private String id;

    /**
    *课程Id
    */
    private String courseId;

    /**
    *学生id
    */
    private String studentId;

    /**
    *课件Id
    */
    private String wareId;

    /**
    *标记标题
    */
    private String title;

    /**
    *笔记内容
    */
    private String context;

    /**
    *前端显示状态 1 显示 0 不显示
    */
    private Boolean showStatus;

}