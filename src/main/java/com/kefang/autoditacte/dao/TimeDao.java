package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.entity.sysmanage.Time;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统管理——时间设置
 */
@Mapper
public interface TimeDao {
    int deleteByPrimaryKey(String id);

    int insert(Time record);

    int insertSelective(Time record);

    Time selectByPrimaryKey(int year);

    int updateByPrimaryKeySelective(Time record);

    int updateByPrimaryKey(Time record);
}


