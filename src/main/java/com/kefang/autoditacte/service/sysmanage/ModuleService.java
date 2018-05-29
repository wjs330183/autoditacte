package com.kefang.autoditacte.service.sysmanage;

import com.kefang.autoditacte.dto.ModuleDto;

import java.util.List;

/**
 * 系统管理——权限管理的业务接口
 */
public interface ModuleService {
    /**
     * 查询所有模块（1，2，3级）
     * @return
     */
    List<ModuleDto> queryAllModule();
}
