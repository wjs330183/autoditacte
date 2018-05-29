package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.entity.sysmanage.Score;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 */
@Mapper
public interface ScoreDao {
    int deleteByPrimaryKey(String id);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);

}
