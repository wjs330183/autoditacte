package com.kefang.autoditacte.service.sysmanage;

import com.kefang.autoditacte.exception.BusinessException;

/**
 * 系统管理——权限设置
 */
public interface PermissionService {
    /**
     * 设置角色权限
     * @param permissionJsonStr
     */
    public void setPermission(String permissionJsonStr) throws BusinessException;
}
