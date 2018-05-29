package com.kefang.autoditacte.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 用于接收用户的权限设置类
 */
@Setter
@Getter
public class PermissionDto implements Serializable {

    /**
     *  菜单和操作的moduleIds
     */
    private String moduleIds;
    /**
     * 角色id
     */
    private String roleId;

}
