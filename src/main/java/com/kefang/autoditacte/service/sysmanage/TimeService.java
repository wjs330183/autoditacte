package com.kefang.autoditacte.service.sysmanage;

import com.kefang.autoditacte.exception.BusinessException;
import com.kefang.autoditacte.entity.sysmanage.Time;

public interface TimeService {
    /**
     * 查询时间设置
     * @param year
     * @return
     */
  Time query(int year);

    /**
     * 新增时间设置
     * @param time
     */
  void insert(Time time) throws BusinessException;

    /**
     * 更新时间设置
     * @param time
     */
  void update(Time time)throws BusinessException;

    /**
     * 新增或更新
     * @param time
     * @throws BusinessException
     */
    void save(Time time)throws BusinessException;
}
