package com.kefang.autoditacte.param;

import lombok.Getter;
import lombok.Setter;

/**
* 描述：
* @author Json
* @date 2018-05-28
*/
@Getter
@Setter
public class StudentNoteParam {

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