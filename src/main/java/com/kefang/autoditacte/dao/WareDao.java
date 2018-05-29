package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.entity.Ware;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.*;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-18
 */
@Mapper
public interface WareDao {

    int save(@Param("entity") Ware entity);

//    int saveBatch(@Param("entities")List<Ware> entities);

    int update(@Param("entity") Ware entity);

    List<Ware> getById(@Param("id") String id, @Param("page") Integer page, @Param("length") Integer length);

    int deleteById(String id);


    List<Ware> getWare();

    List<Ware> getWareLimit(@Param("courseName") String courseName,
                            @Param("start") Integer start, @Param("length") Integer length);

    List<Ware> getWareLimitById(@Param("id") String id,
                            @Param("start") Integer start, @Param("length") Integer length);

    int getWareCount(@Param("courseName") String courseName);

    int getWareCountById(@Param("id") String id);


}