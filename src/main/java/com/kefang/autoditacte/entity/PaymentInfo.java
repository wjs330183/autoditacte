package com.kefang.autoditacte.entity;


import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfo extends BaseEntity{

    private String id;


    private String studentId;


    private String courseId;

    /**
     *支付订单id
     */
    private String paymentOrderId;
    /**
     * 缴费金额
     */
    private Double payedMoney;


}