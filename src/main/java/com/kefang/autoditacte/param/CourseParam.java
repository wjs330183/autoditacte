package com.kefang.autoditacte.param;

import lombok.Getter;
import lombok.Setter;
    /**
     * 描述：
     * @author Json
     * @date 2018-05-18
     */
    @Getter
    @Setter
    public class CourseParam {
        private String id;
        /**
         *课程名称
         */
        private String name;

        /**
         *课程封面:img
         */
        private String code;

        /**
         *课程简介
         */
        private String note;
        /***
         * 状态
         */
        private Integer status;
        /***
         * 价格
         */
        private Double price;
        /**
         * 售价
         */
        private Double soldPrice;
        /**
         * 课件课程id
         */
        private String wareCourseId;
        /**
         * 习题课程id
         */
        private String exerciseCourseId;



    }
