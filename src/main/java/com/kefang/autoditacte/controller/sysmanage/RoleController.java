package com.kefang.autoditacte.controller.sysmanage;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.enums.ResultCode;
import com.kefang.autoditacte.entity.sysmanage.Role;
import com.kefang.autoditacte.exception.BusinessException;
import com.kefang.autoditacte.service.sysmanage.RoleService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统管理——用户角色控制层
 */
@Api(value = "Link Controller" ,tags="角色管理")
@Controller
public class RoleController {
    static Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Resource
    private RoleService roleService;

    /**
     * 查询所有的角色列表
     * @return
     */
    @RequestMapping(value = "/sys/role/query",method = RequestMethod.GET)
    @ResponseBody
    public JsonData<List<Role>> queryList(){
        JsonData<List<Role>> result=new JsonData<List<Role>>();
        List<Role> roles=roleService.queryList();
        result.setResultData(roles);
        return result;

    }

    /**
     * 编辑用户角色列表
     * @param role
     * @return
     */
    @RequestMapping(value = "/sys/role/edit",method = RequestMethod.POST)
    @ResponseBody
    public JsonData<String> edit(Role role){
        JsonData<String> result=new JsonData<>();
        try {
            roleService.edit(role);
        }catch (BusinessException e){
            result.setResultCode(e.getCode());
            result.setResultMsg(e.getMessage());
            logger.error("RoleService-edit is fail",role.getId(),role.getName(),e);

        }catch (Exception e){
            result.setResultCode(ResultCode.FAIL);
            result.setResultMsg(ResultCode.FAIL.getDesc());
            logger.error("RoleController-edit is fail",role.getId(),role.getName(),e);
        }
        return result;

    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    @RequestMapping(value = "/sys/role/delete",method = RequestMethod.POST)
    @ResponseBody
    public JsonData<String> delete(String id){
        JsonData<String> result=new JsonData<>();
        try {
            roleService.delete(id);
        }catch (BusinessException e){
            result.setResultCode(e.getCode());
            result.setResultMsg(e.getMessage());
            logger.error("RoleService-delete is fail",id,e);
        }catch (Exception e){
            result.setResultCode(ResultCode.FAIL);
            result.setResultMsg(ResultCode.FAIL.getDesc());
            logger.error("RoleController-edit is fail",id,e);
        }
        return result;

    }

    /**
     * 添加一个角色
     * @param role
     * @return
     */
    @RequestMapping(value = "/sys/role/add",method = RequestMethod.POST)
    @ResponseBody
    public JsonData<String> add(Role role){
        JsonData<String> result=new JsonData<>();
        try {
            roleService.insert(role);
        }catch (BusinessException e){
            result.setResultCode(e.getCode());
            result.setResultMsg(e.getMessage());
            logger.error("RoleService-add is fail",role.getName(),e);
        }catch (Exception e){
            result.setResultCode(ResultCode.FAIL);
            result.setResultMsg(ResultCode.FAIL.getDesc());
            logger.error("RoleController-edit is fail",role.getName(),e);
        }
        return result;

    }
}
