package com.kefang.autoditacte.entity.sysmanage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜单模块
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Module implements Serializable {
    /**
     *ID
     */
    private String id;
    /**
     *父级菜单(没有父级可以为0)
     */
    private String upid;
    /**
     *菜单名称
     */
    private String moduleName;
    /**
     * 状态
     */
    private Integer state;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 备注
     */
    private String note;

}
