package com.kefang.autoditacte.dto;

import com.kefang.autoditacte.entity.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Setter
@Getter
@NoArgsConstructor
public class PaymentInfoDto extends PaymentInfo {
    /**
     * 学生
     */
    private Student student;
    /**
     * 助学机构
     */
    private Station station;
    /**
     * 课程
     */
    private Course course;
    public static PaymentInfoDto adapt(PaymentInfo paymentInfo){
        PaymentInfoDto paymentInfoDto=new PaymentInfoDto();
        BeanUtils.copyProperties(paymentInfo,paymentInfoDto);
        return paymentInfoDto;
    }

}
