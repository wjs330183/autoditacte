package com.kefang.autoditacte.service.sysmanage;


import com.kefang.autoditacte.exception.BusinessException;
import com.kefang.autoditacte.entity.sysmanage.Link;

import java.util.List;

/**
 * 系统管理——友情链接业务接口层
 */
public interface LinkService {
    /**
     *  查询所有的友情链接
     * @return
     */
    List<Link> queryAll();

    /**
     * 编辑某一个链接
     * @param link
     */
    void editLink(Link link) throws BusinessException;
}
