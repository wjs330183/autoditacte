package com.kefang.autoditacte.service.impl.sysmanage;

import com.kefang.autoditacte.common.enums.ResultCode;
import com.kefang.autoditacte.dao.AdminDao;
import com.kefang.autoditacte.entity.sysmanage.Admin;
import com.kefang.autoditacte.exception.BusinessException;
import com.kefang.autoditacte.service.sysmanage.AdminService;
import com.kefang.autoditacte.utils.CommonUtils;
import com.kefang.autoditacte.utils.PassWordUtil;
import com.kefang.autoditacte.utils.util.Querys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 系统管理——用户信息修改务实现层
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    static Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Resource
    private AdminDao adminDao;

    /**
     * 添加或者修改管理员
     * @param admin
     * @throws BusinessException
     */
    @Override
    public void updateUserInfo(Admin admin)throws BusinessException {
        //入参判断
        if(CommonUtils.isBlank(admin.getEmail())
                ||CommonUtils.isBlank(admin.getPhoto())
                ||CommonUtils.isBlank(admin.getPhone())
                ||CommonUtils.isBlank(admin.getPassWord())
                ||CommonUtils.isBlank(admin.getRoleId())
                ||CommonUtils.isBlank(admin.getStationId())
                ||CommonUtils.isBlank(admin.getUserName())){
            throw new BusinessException(ResultCode.PARAMETER_ERROR);
        }
     if(CommonUtils.isBlank(admin.getId())||"0".equals(admin.getId())){//保存
         String  id=UUID.randomUUID().toString();
         admin.setId(id);
         // 密码加密
         String salt = PassWordUtil.genSalt();
         String pass = PassWordUtil.encrypt(admin.getPassWord(), salt);
         admin.setPassWord(pass);
         Date date=new Date();
         admin.setCreateTime(date);
         admin.setUpdateTime(date);
         int insertNum=adminDao.insertSelective(admin);
         if(insertNum<=0){
             throw new BusinessException(ResultCode.INSERT_ERROR);
         }
     } else{//修改
     if(CommonUtils.isBlank(admin.getId())||"0".equals(admin.getId())){
         throw new BusinessException(ResultCode.PARAMETER_ERROR);
     }
     //TODO 查看用户名是否存在
     Admin existAdmin=adminDao.selectById(admin.getId());
     if(existAdmin==null){
         throw new BusinessException(ResultCode.ADMIN_NOT_EXISTS);
     }
     admin.setUpdateTime(new Date());
     int result=adminDao.update(admin);
     if(result<=0){
         throw new BusinessException(ResultCode.UPDATE_ERROR);
     }
     }
    }

    /**
     * 查询 所有的管理员有分页  每页显示15条
     * @param querys
     * @return
     */
    @Override
    public void queryList(Querys<Admin> querys){
        //查询管理员的总数
        int count=adminDao.queryCount();
        querys.setTotal(count);
        //查询所有
        List<Admin> admins=adminDao.queryList(querys);
        querys.setResults(admins);
    }

    /**
     * 删除该管理员
     * @param id
     */
    @Override
    public void delete(String id) throws BusinessException{
        if(CommonUtils.isBlank(id)){
            throw new BusinessException(ResultCode.PARAMETER_ERROR);
        }
        Admin admin=adminDao.selectById(id);
        if(admin==null){
            throw new BusinessException(ResultCode.ADMIN_NOT_EXISTS);
        }
        int result=adminDao.delete(id);
        if(result<=0){
            throw new BusinessException(ResultCode.FAIL);
        }

    }

}
