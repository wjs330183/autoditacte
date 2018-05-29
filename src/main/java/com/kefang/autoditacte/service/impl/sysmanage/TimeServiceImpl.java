package com.kefang.autoditacte.service.impl.sysmanage;

import com.kefang.autoditacte.common.enums.ResultCode;
import com.kefang.autoditacte.exception.BusinessException;
import com.kefang.autoditacte.dao.TimeDao;
import com.kefang.autoditacte.entity.sysmanage.Time;
import com.kefang.autoditacte.service.sysmanage.TimeService;
import com.kefang.autoditacte.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 时间设置
 */
@Service("timeService")
public class TimeServiceImpl implements TimeService {
    static Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Resource
    private TimeDao timeDao;
    /**
     * 查询时间设置
     * @param id
     * @return
     */
    @Override
    public Time query(int id){
      return timeDao.selectByPrimaryKey(id);
    }

    /**
     * 新增时间设置
     * @param time
     */
    @Override
    public void insert(Time time)throws BusinessException {
        if(time==null){
            throw new BusinessException(ResultCode.PARAMETER_ERROR);
        }
        String id=UUID.randomUUID().toString();
        time.setId(id);
      int num=timeDao.insertSelective(time);
        if(num<=0){
            throw new BusinessException(ResultCode.INSERT_ERROR);
        }
    }

    /**
     * 更新时间设置
     * @param time
     */
    @Override
    public void update(Time time)throws BusinessException{
        if(CommonUtils.isBlank(time.getId())){
            throw new BusinessException(ResultCode.PARAMETER_ERROR);
        }
        int num= timeDao.updateByPrimaryKeySelective(time);
        if(num<=0){
            throw new BusinessException(ResultCode.UPDATE_ERROR);
        }
    }

    /**
     * 保存或者更新
     * @param time
     */
    @Override
    public void save(Time time)throws BusinessException{
        if(time==null){
            throw new BusinessException(ResultCode.PARAMETER_ERROR);
        }
        if(CommonUtils.isBlank(time.getId())){//新增
            this.insert(time);

        }else {//保存
            this.update(time);
        }
    }
}
