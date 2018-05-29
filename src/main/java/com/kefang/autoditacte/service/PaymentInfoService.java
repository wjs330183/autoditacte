package com.kefang.autoditacte.service;

import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.dto.PaymentInfoDto;
import com.kefang.autoditacte.entity.PaymentInfo;

import java.util.List;

public interface PaymentInfoService {
    TailPage<PaymentInfoDto> getPaymentInfoByPage(String courseId, String stationId, String s, String keyWord, TailPage page);
}
