package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.entity.Site;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.*;

/**
* 描述：
* @author Json
* @date 2018-05-26
*/
@Mapper
public interface SiteDao {

    int save(@Param("entity") Site entity);

    int insertBatch(@Param("entities") List<Site> entities);

    int update(@Param("entity") Site entity);

    int deleteById(@Param("id") String id);

    List<Site> getSitesByPage(@Param("name") String name, @Param("page") TailPage<Site> page);

    Integer getTotalItemsCount(@Param("name") String name);

    Site getSiteById(String id);
}