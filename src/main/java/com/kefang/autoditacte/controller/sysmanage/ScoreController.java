package com.kefang.autoditacte.controller.sysmanage;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.enums.ResultCode;
import com.kefang.autoditacte.entity.sysmanage.Score;
import com.kefang.autoditacte.exception.BusinessException;
import com.kefang.autoditacte.service.sysmanage.ScoreService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 系统管理——分数设置
 */
@Api(value = "score Controller" ,tags="学习设置")
@Controller
public class ScoreController {
    static Logger logger = LoggerFactory.getLogger(ScoreController.class);
    @Resource
    private ScoreService scoreService;



    @RequestMapping(value = "/sys/score/add",method = RequestMethod.POST)
    @ResponseBody
    public JsonData<String> add(Score score){
        JsonData<String> result=new JsonData<>();
        try {
            scoreService.add(score);
        }catch (BusinessException e){
            result.setResultCode(e.getCode());
            result.setResultMsg(e.getMessage());
            logger.error("scoreService-add is fail",e);
        } catch (Exception e){
            result.setResultCode(ResultCode.FAIL);
            result.setResultMsg(ResultCode.FAIL.getDesc());
            logger.error("ScoreController-add is fail",e);
        }
        return result;

    }
}
