package com.kefang.autoditacte.controller.sysmanage;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.enums.ResultCode;
import com.kefang.autoditacte.entity.sysmanage.Time;
import com.kefang.autoditacte.exception.BusinessException;
import com.kefang.autoditacte.service.sysmanage.TimeService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 系统设置——时间设置
 */
@Api(value = "TimeController" ,tags="测评时间设置")
@Controller
public class TimeController {
    static Logger logger = LoggerFactory.getLogger(TimeController.class);
    @Resource
    private TimeService timeService;

    /**
     * 系统测评时间设置
     * @param time
     * @return
     */
    @RequestMapping(value = "/sys/time/add",method = RequestMethod.POST)
    @ResponseBody
    public JsonData<String> add(Time time){
        JsonData<String> result=new JsonData<>()  ;
        try {
            timeService.save(time);

        }catch (BusinessException e){
            result.setResultCode(e.getCode());
            result.setResultMsg(e.getMessage());
         logger.error("timeService-add is fail",e);
        }catch (Exception e){
            result.setResultCode(ResultCode.FAIL);
            result.setResultMsg(ResultCode.FAIL.getDesc());
            logger.error("TimeController-add is fail",e);
        }
        return result;
    }
}
