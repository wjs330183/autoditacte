package com.kefang.autoditacte.controller.sysmanage;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.enums.ResultCode;
import com.kefang.autoditacte.entity.sysmanage.Admin;
import com.kefang.autoditacte.exception.BusinessException;
import com.kefang.autoditacte.service.sysmanage.AdminService;
import com.kefang.autoditacte.utils.util.Querys;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 系统管理——用户信息控制层
 */
@Api(value = "Admin Controller" ,tags="管理员设置")
@Controller
public class AdminController {
    static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Resource
    private AdminService adminService;

    /**
     * 修改或者添加管理员
     * @param admin
     * @return
     */
    @ApiOperation(value="编辑管理员",tags={"编辑"},notes="用户名，电话，密码，图像，所属函授站不能为空")
    @RequestMapping(value = "sys/admin/edit",method = RequestMethod.POST)
    @ResponseBody
    public JsonData<String> updateUserInfo(Admin admin){
        JsonData<String> result=new JsonData<>();
        try{
            adminService.updateUserInfo(admin);
        }catch (BusinessException e){
         result.setResultCode(e.getCode());
         result.setResultMsg(e.getMessage());
         logger.error("AdminService-edit is fail",admin.getId(),e);
        }catch (Exception e){
         result.setResultCode(ResultCode.FAIL);
         result.setResultMsg(ResultCode.FAIL.getDesc());
         logger.error("AdminController is fail",admin.getId(),e);
        }
        return result;

    }

    /**
     * 查询所有管理员列表有分页 一页15条
     * @return
     */
    @ApiOperation(value="编辑管理员",tags={"管理员列表"},notes="有分页")
    @RequestMapping(value = "sys/admin/search",method = RequestMethod.GET)
    @ResponseBody
    public JsonData<Querys<Admin>> search(HttpServletRequest request, Querys<Admin> query){
        JsonData<Querys<Admin>> result=new JsonData<>();
      //设置分页
     query.setPages(request);
     //查询结果
     adminService.queryList(query);
     result.setResultData(query);
     return result;
    }

    /**
     * 删除管理员
     * @param id
     * @return
     */
    @ApiOperation(value="编辑管理员",tags={"删除"},notes="删除要付入id")
    @RequestMapping(value = "sys/admin/delete",method = RequestMethod.GET)
    @ResponseBody
    public JsonData<String> delete(String id){
        JsonData<String> result=new JsonData<>();
      try {
          adminService.delete(id);
      }catch (BusinessException e){
          result.setResultCode(e.getCode());
          result.setResultMsg(e.getMessage());
          logger.error("AdminService-delete is fail",id,e);
      }catch (Exception e){
          result.setResultCode(ResultCode.FAIL);
          result.setResultMsg(ResultCode.FAIL.getDesc());
          logger.error("AdminController is fail",id,e);
      }
      return result;
    }
}
