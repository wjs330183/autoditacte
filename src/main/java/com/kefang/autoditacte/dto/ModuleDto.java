package com.kefang.autoditacte.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 模块的操作模型
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class ModuleDto implements Serializable {
    /**
     * 模块id
     */
    private String moduleId;
    /**
     * 父模块id
     */
    private String parentModuleId;
    /**
     * 模块名称
     */
    private String moduleName;

    /**
     * 操作名称
     */
    private String actionName;
    /**
     * 操作url
     */
    private String actionUrl;
    /**
     * 菜单等级
     */
    private int level;
    /**
     * 所有子模块
     */
    List<ModuleDto> childs=new ArrayList<>();


}
