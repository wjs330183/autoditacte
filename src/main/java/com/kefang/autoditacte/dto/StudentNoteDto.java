package com.kefang.autoditacte.dto;

import com.kefang.autoditacte.entity.StudentNote;
import lombok.*;
import org.springframework.beans.BeanUtils;


@Setter
@Getter
@NoArgsConstructor
public class StudentNoteDto extends StudentNote {
    private String courseName;
    public static StudentNoteDto adapt(StudentNote major){
        StudentNoteDto majorDto=new StudentNoteDto();
        BeanUtils.copyProperties(major,majorDto);
        return majorDto;
    }

    private String code;
    private String name;
    private String stationName;

}
