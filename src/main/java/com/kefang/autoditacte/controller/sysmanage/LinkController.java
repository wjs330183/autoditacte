package com.kefang.autoditacte.controller.sysmanage;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.enums.ResultCode;
import com.kefang.autoditacte.entity.sysmanage.Link;
import com.kefang.autoditacte.exception.BusinessException;
import com.kefang.autoditacte.service.sysmanage.LinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统管理——友情链接控制层
 */
@Api(value = "Link Controller" ,tags="友情链接")
@Controller
public class LinkController {
    static Logger logger = LoggerFactory.getLogger(LinkController.class);
    @Resource
    private LinkService linkService;

    /**
     * 查询所有友情链接
     * @return
     */
    @ApiOperation(value="链接列表",tags={"链接列表"},notes="不分页")
    @RequestMapping(value = "/sys/link/query",method = RequestMethod.GET)
    @ResponseBody
    public JsonData<List<Link>> queryAllLink(){
        JsonData<List<Link>> result=new JsonData<>();
        List<Link> links=linkService.queryAll();
        result.setResultData(links);
        return result;
    }

    /**
     * 编辑友情链接
     * @param link
     * @return
     */
    @ApiOperation(value="链接列表",tags={"编辑"},notes="id，链接url,logo url，链接名称不能为空")
    @RequestMapping(value = "/sys/link/edit",method = RequestMethod.POST)
    @ResponseBody
    public JsonData<String> editLink(Link link){
        JsonData<String> result=new JsonData<>();
        try {
            linkService.editLink(link);
        } catch (BusinessException e){
            result.setResultCode(ResultCode.UPDATE_ERROR);
            result.setResultMsg(e.getMessage());
            logger.error("linkService is fail",link.getId(),e);
        } catch (Exception e){
           result.setResultCode(ResultCode.FAIL);
           result.setResultMsg(ResultCode.FAIL.getDesc());
           logger.error("LinkController is error",link.getId(),e);
        }
        return result;

    }


}
