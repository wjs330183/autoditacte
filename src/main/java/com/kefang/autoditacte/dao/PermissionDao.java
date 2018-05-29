package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.entity.sysmanage.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统管理——用户权限设置
 */
@Mapper
public interface PermissionDao {
    /**
     * 根据角色查询用户所有权限
     * @param roleId
     * @return
     */
   List<Permission> selectPrem(String roleId);
    /**
     * 根据角色删除相应模块的权限
     * @param ids
     * @return
     */
    int delete(List<String> ids);

    /**
     * 批量新增权限
     * @param lists
     * @return
     */
    int batchInsert(List<Permission> lists);
}
