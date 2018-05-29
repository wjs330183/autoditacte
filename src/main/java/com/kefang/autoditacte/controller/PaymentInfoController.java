package com.kefang.autoditacte.controller;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.common.enums.ResultCode;
import com.kefang.autoditacte.service.PaymentInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
public class PaymentInfoController {
    @Resource
    private PaymentInfoService paymentInfoService;
    @RequestMapping(value = {"paymentManagement/1/paymentsPage"})
    @ResponseBody
    public JsonData getPaymentInfoByPage(@RequestParam(value = "courseId",required = false) String courseId, @RequestParam(value = "stationId",required = false) String stationId, @RequestParam(value = "status",required = false) Integer status, @RequestParam(value = "keyWord",required = false) String keyWord, TailPage page){
        //try{
           return JsonData.success(paymentInfoService.getPaymentInfoByPage(courseId,stationId,status,keyWord,page),"查询成功");
        //}catch (Exception e){
        //    return JsonData.fail("查询失败");
        //}

    }
}
