package com.kefang.autoditacte.entity.sysmanage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统管理——角色权限类
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Permission implements Serializable {
    /**
     * Id
     */
    private String id;
    /**
     *菜单id rel t_module
     */
    private String moduleId;
    /**
     *角色id rel t_role
     */
    private String roleId;

    /**
     * 创建时间
     */
    private Date create_time;
    /**
     *修改时间
     */
    private Date update_time;

}
