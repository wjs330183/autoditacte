package com.kefang.autoditacte.service.impl.sysmanage;

import com.kefang.autoditacte.common.enums.ResultCode;
import com.kefang.autoditacte.dao.RoleDao;
import com.kefang.autoditacte.entity.sysmanage.Role;
import com.kefang.autoditacte.exception.BusinessException;
import com.kefang.autoditacte.service.sysmanage.RoleService;
import com.kefang.autoditacte.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 系统管理——用户角色管理
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    static Logger logger = LoggerFactory.getLogger(LinkServiceImpl.class);
    @Resource
    private RoleDao roleDao;
    /**
     * 查询所有角色
     * @return
     */
    @Override
    public List<Role> queryList(){
        return roleDao.selectAll();

    }

    /**
     * 编号角色名称
     * @param role
     * @throws BusinessException
     */
    @Override
    public void edit(Role role) throws BusinessException{
     if(CommonUtils.isBlank(role.getId())
       ||CommonUtils.isBlank(role.getName())
       ||CommonUtils.isBlank(role.getSiteId())){
         throw new BusinessException(ResultCode.PARAMETER_ERROR);
     }
     //查询所要编辑的用户角色是否存在
        Role roleOpt=roleDao.selectByPrimaryKey(role.getId());
     if(roleOpt==null){
         throw new BusinessException(ResultCode.ROLE_NOT_EXISTS);
     }
     role.setUpdateTime(new Date());
     int result=roleDao.updateByPrimaryKey(role);
     if(result<=0){
         throw new BusinessException(ResultCode.UPDATE_ERROR);
     }
    }

    /**
     * 删除角色
     * @param id
     * @throws BusinessException
     */
    @Override
    public void delete(String id) throws BusinessException{
        if(CommonUtils.isBlank(id)){
            throw new BusinessException(ResultCode.PARAMETER_ERROR);
        }
        //查询所要编辑的用户角色是否存在
        Role roleOpt=roleDao.selectByPrimaryKey(id);
        if(roleOpt==null){
            throw new BusinessException(ResultCode.ROLE_NOT_EXISTS);
        }
        int result=roleDao.deleteByPrimaryKey(id);
        if(result<=0){
            throw new BusinessException(ResultCode.DELETE_ERROR);
        }
    }

    /**
     * 新增角色
     * @param role
     * @throws BusinessException
     */
    @Override
    public void insert(Role role) throws  BusinessException{
        if(CommonUtils.isBlank(role.getId())
                ||CommonUtils.isBlank(role.getName())
                ||CommonUtils.isBlank(role.getSiteId())){
            throw new BusinessException(ResultCode.PARAMETER_ERROR);
        }
        //查询所添加的用户角色是否存在
        Role roleOpt=roleDao.selectExists(role);
        if(roleOpt!=null){
            throw new BusinessException(ResultCode.ROLE_NAME_REPET);
        }
        Date date=new Date();
        role.setCreateTime(date);
        role.setUpdateTime(date);
        int result=roleDao.insertSelective(role);
        if(result<=0){
            throw new BusinessException(ResultCode.INSERT_ERROR);
        }
    }
}
