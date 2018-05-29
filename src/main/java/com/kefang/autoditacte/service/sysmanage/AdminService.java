package com.kefang.autoditacte.service.sysmanage;

import com.kefang.autoditacte.exception.BusinessException;
import com.kefang.autoditacte.utils.util.Querys;
import com.kefang.autoditacte.entity.sysmanage.Admin;

/**
 * 系统管理——用户信息业务接口层
 */
public interface AdminService {
    /**
     * 更新用户信息
     * @param admin
     * @return
     */
    public void updateUserInfo(Admin admin) throws BusinessException;

    /**
     * 查询所有的管理员
     * @param querys
     * @return
     */
    public void queryList(Querys<Admin> querys);

    /**
     * 删除管理员
     * @param id
     */
    public void delete(String id) throws BusinessException;


}
