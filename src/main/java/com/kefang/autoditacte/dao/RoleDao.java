package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.entity.sysmanage.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统管理——管理员角色dao层
 */
@Mapper
public interface RoleDao {
    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 添加角色
     * @param record
     * @return
     */
    int insertSelective(Role record);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Role selectByPrimaryKey(String id);

    /**
     * 更新角色
     * @param record
     * @return
     */

    int updateByPrimaryKey(Role record);

    /**
     * 查询所有的角色
     * @return
     */
    List<Role> selectAll();

    /**
     * 根据名称查询角色名称
     * @param role
     * @return
     */
    Role selectExists(Role role);


}
