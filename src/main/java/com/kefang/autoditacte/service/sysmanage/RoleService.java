package com.kefang.autoditacte.service.sysmanage;

import com.kefang.autoditacte.exception.BusinessException;
import com.kefang.autoditacte.entity.sysmanage.Role;

import java.util.List;

/**
 * 系统管理——用户角色接口层
 */
public interface RoleService {
    /**
     * 查询所有角色
     * @return
     */
    List<Role> queryList();

    /**
     * 编号角色名称
     * @param role
     * @throws BusinessException
     */
    void edit(Role role) throws BusinessException;

    /**
     * 删除角色
     * @param id
     * @throws BusinessException
     */
    void delete(String id) throws BusinessException;

    /**
     * 新增角色
     * @param role
     * @throws BusinessException
     */
    void insert(Role role) throws  BusinessException;
}
