package com.kefang.autoditacte.dto;

import com.kefang.autoditacte.entity.Course;
import com.kefang.autoditacte.entity.ExerciseCourse;
import com.kefang.autoditacte.entity.WareCourse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
@Getter
@Setter
public class CourseDto extends Course {
    private boolean matched;
    private WareCourse wareCourse;
    private ExerciseCourse exerciseCourse;
    public static CourseDto adapt(Course course){
        CourseDto courseDto=new CourseDto();
        BeanUtils.copyProperties(course,courseDto);
        return courseDto;
    }
}
