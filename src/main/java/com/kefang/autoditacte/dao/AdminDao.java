package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.utils.util.Querys;
import com.kefang.autoditacte.entity.sysmanage.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 个人信息 d ao接口层
 */
@Mapper
public interface AdminDao {
    /**
     * 更新个人信息
     */
    int update(Admin admin);

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    int insertSelective(Admin admin);

    /**
     * 查询管理员的总数量
     * @return
     */
    int queryCount();

    /**
     * 查询所有的管理员
     * @return
     */
    List<Admin> queryList(Querys<Admin> querys);

    /**
     * 编辑管理员信息
     * @param admin
     * @return
     */
    int updateByPrimaryKeySelective(Admin admin);

    /**
     * 根据id删除管理员
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 查询管理员是否存在
     * @param id
     * @return
     */
    Admin selectById(String id);

}
