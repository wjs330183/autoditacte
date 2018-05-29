package com.kefang.autoditacte.dao;


import com.kefang.autoditacte.entity.sysmanage.Link;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


/**
 * 友情链接dao接口层
 */
@Mapper
public interface LinkDao {
    /**
     *查询所有友情链接
     * @return
     */

    List<Link> selectAll();

    /**
     * 根据id去编辑链接
     * @param id
     * @return
     */
    int updateById(Link link) ;
}
