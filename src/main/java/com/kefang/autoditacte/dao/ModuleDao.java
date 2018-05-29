package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.dto.ModuleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 权限操作接口
 */
@Mapper
public interface ModuleDao {
    /**
     * 查询所有模块下的所有操作
     * @return
     */
    List<ModuleDto> selectAllAction();
}
