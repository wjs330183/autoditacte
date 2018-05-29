package com.kefang.autoditacte.dto;

import com.kefang.autoditacte.entity.StudentEvaluateReportFinally;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
@Setter
@Getter
@NoArgsConstructor
public class StudentEvaluateReportFinallyDto extends StudentEvaluateReportFinally {


    public static StudentEvaluateReportFinallyDto adapt( StudentEvaluateReportFinally major) {
        StudentEvaluateReportFinallyDto majorDto = new StudentEvaluateReportFinallyDto();
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
