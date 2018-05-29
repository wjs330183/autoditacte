package com.kefang.autoditacte.dto;

import com.kefang.autoditacte.entity.StudentEvaluate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Setter
@Getter
@NoArgsConstructor
public class StudentEvaluateDto extends StudentEvaluate {

    private String courseName;

    public static StudentEvaluateDto adapt(StudentEvaluate major) {
        StudentEvaluateDto majorDto = new StudentEvaluateDto();
        BeanUtils.copyProperties(major, majorDto);
        return majorDto;
    }
    /**
     *准考证号
     */
    private String code;

    /**
     *姓名
     */
    private String name;
    /**
     *证件类型： 0 身份证 1 港澳通行证 2 军官证
     */
    private Integer cardType;

    /**
     *证件号码
     */
    private String cardId;

    private String stationName;

    private String stationCode;

    private String siteName;

    private String siteCode;

    private String majorName;

    private String majorCode;

}
