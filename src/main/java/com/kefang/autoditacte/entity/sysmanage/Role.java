package com.kefang.autoditacte.entity.sysmanage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统管理——角色管理
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Role implements Serializable {
    /**
     * ID
     */
    private String id;
    /**
     *角色名称
     */
    private String name;
    /**
     *学校Id rel t_site
     */
    private String siteId;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     *更新时间
     */
    private Date updateTime;
    /**
     *备注
     */
    private String note;
    /**
     * 开关状态
     */
    private boolean state;
    /**
     * 删除状态
     */
    private boolean isDel;

}
