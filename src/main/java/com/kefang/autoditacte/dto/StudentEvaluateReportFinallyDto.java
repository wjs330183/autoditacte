package com.kefang.autoditacte.dto;

import com.kefang.autoditacte.entity.StudentEvaluateReportFinally;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class StudentEvaluateReportFinallyDto extends StudentEvaluateReportFinally {

    private StudentDto studentDto;

    public static StudentEvaluateReportFinallyDto adapt( StudentEvaluateReportFinally major) {
        StudentEvaluateReportFinallyDto majorDto = new StudentEvaluateReportFinallyDto();
        BeanUtils.copyProperties(major, majorDto);
        return majorDto;
    }
}
