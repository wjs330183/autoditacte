package com.kefang.autoditacte.controller.sysmanage;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.enums.ResultCode;
import com.kefang.autoditacte.dto.ModuleDto;
import com.kefang.autoditacte.exception.BusinessException;
import com.kefang.autoditacte.service.sysmanage.ModuleService;
import com.kefang.autoditacte.service.sysmanage.PermissionService;
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
@Api(value = "Link Controller" ,tags="友情链接")
@Controller
public class PermissionController {
    static Logger logger = LoggerFactory.getLogger(PermissionController.class);
    @Resource
    private PermissionService permissionService;
    @Resource
    private ModuleService moduleService;

    /**
     * 显示所有的权限列表
     * @return
     */
    @ApiOperation(value="展示权限",tags={"显示所有的权限"})
    @RequestMapping(value = "sys/permission/show",method = RequestMethod.GET)
    @ResponseBody
    public JsonData<List<ModuleDto>> showAllPermission(){
        JsonData<List<ModuleDto>> result=new JsonData<>();
        List<ModuleDto> list=moduleService.queryAllModule();
        result.setResultData(list);
        return result;
    }

    /**
     * 修改用户权限
     * @param josnStr
     * @return
     */
    @ApiOperation(value="修改权限",tags={"设置权限"})
    @RequestMapping(value = "sys/permission/update",method = RequestMethod.POST)
    @ResponseBody
    public JsonData<String> updatePermission(String josnStr){
        JsonData<String> result=new JsonData<>();
        try {
            permissionService.setPermission(josnStr);
        }catch (BusinessException e){
            result.setResultCode(e.getCode());
            result.setResultData(e.getMessage());
            logger.error("actionService-updatePermission is fail",josnStr,e);

        }catch (Exception e){
            result.setResultCode(ResultCode.FAIL);
            result.setResultMsg(ResultCode.FAIL.getDesc());
            logger.error("PermissionController-updatePermission is fail",josnStr,e);
        }
       return result;
    }

}
