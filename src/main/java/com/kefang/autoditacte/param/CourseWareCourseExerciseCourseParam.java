package com.kefang.autoditacte.param;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseWareCourseExerciseCourseParam{
    /**
     * 课程id
     */
    private String courseId;
    /**
     * 课件课程id
     */
    private String wareCourseId;
    /**
     * 习题课程id
     */
    private String exerciseCourseId;

    private String note;
}
