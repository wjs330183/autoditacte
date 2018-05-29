package com.kefang.autoditacte.dto;

import com.kefang.autoditacte.entity.Student;
import com.kefang.autoditacte.entity.StudentDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Setter
@Getter
@NoArgsConstructor
public class StudentDto extends Student{

    private Student student;

    private StudentDetail studentDetail;

    public static StudentEvaluateDto adapt(Student major, StudentDetail major1) {
        StudentEvaluateDto majorDto = new StudentEvaluateDto();
        BeanUtils.copyProperties(major, majorDto);
        BeanUtils.copyProperties(major1, majorDto);
        return majorDto;
    }

    private String stationName;

    private String stationCode;

    private String siteName;

    private String siteCode;

    private String majorName;

    private String majorCode;
}
