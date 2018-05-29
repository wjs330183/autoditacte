package com.kefang.autoditacte.service.impl.sysmanage;

import com.alibaba.fastjson.JSON;
import com.kefang.autoditacte.common.enums.ResultCode;
import com.kefang.autoditacte.dao.PermissionDao;
import com.kefang.autoditacte.dto.PermissionDto;
import com.kefang.autoditacte.entity.sysmanage.Permission;
import com.kefang.autoditacte.exception.BusinessException;
import com.kefang.autoditacte.service.sysmanage.PermissionService;
import com.kefang.autoditacte.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


@Service("permissionService")
public class PermissionServiceImpl implements PermissionService{
    static Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Resource
    private PermissionDao permissionDao;
    /**
     * 修改设置角色权限
     * @param permissionJsonStr
     */
    @Override
    public void setPermission(String permissionJsonStr)throws BusinessException {
      //TODO 判断用户是否有权限进行设置
      //解析json字符串
        if(CommonUtils.isBlank(permissionJsonStr)){
            throw new BusinessException(ResultCode.PARAMETER_ERROR);
        }
        List<PermissionDto> permissionDtoList = JSON.parseArray(permissionJsonStr, PermissionDto.class);
        if(permissionDtoList==null || permissionDtoList.isEmpty()){
          return;
      }
      List<String> moduleIds= new ArrayList<String>();
      List<Permission> perList=new ArrayList<>();
      Permission pms=null;
      String roleId=null;//角色id
        Date date=new Date();
        String id=null;//主键
      for(PermissionDto permission : permissionDtoList) {
          //split actionsIds
          String ids = permission.getModuleIds();
          roleId = permission.getRoleId();
          if (CommonUtils.isNotBlank(ids)) {
              String[] idArray = ids.split(",");
              moduleIds = Arrays.asList(idArray);
              for (String moduleId : moduleIds) {
                  pms = new Permission();
                  id=UUID.randomUUID().toString();
                  pms.setId(id);
                  pms.setModuleId(moduleId);
                  pms.setRoleId(roleId);
                  pms.setCreate_time(date);
                  pms.setUpdate_time(date);
                  perList.add(pms);
              }
          }
          }
          //先删除要设置角色的相应模块的权限
          if (perList == null || perList.isEmpty()) {
              return;
          }
          //查询出用户所有权限
          List<Permission> permiList=permissionDao.selectPrem(roleId);
          //过滤出要修改模块的权限
          List<String>  mid=new ArrayList<>();
          for(Permission per :permiList){
              mid.add(per.getId());
          }
          if(mid!=null && !mid.isEmpty()){
              int num = permissionDao.delete(mid);
              if (num <= 0 || num < perList.size()) {
                  throw new BusinessException(ResultCode.UPDATE_ERROR);
              }
          }

          //批量新增权限
          int inNum = permissionDao.batchInsert(perList);
          if (inNum <= 0 || inNum < perList.size()) {
              throw new BusinessException(ResultCode.UPDATE_ERROR);
          }

    }

}


