package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.dto.MajorDto;
import com.kefang.autoditacte.entity.Major;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.*;

/**
* 描述：
* @author Json
* @date 2018-05-18
*/
@Mapper
public interface MajorDao {

    void save(@Param("entity")Major entity);

    //int saveBatch(@Param("entities")List<Major> entities);

    int update(@Param("entity")Major entity);

    Major getById (@Param("id")String id);

    Major getByName(@Param("name") String name,@Param("siteId") String siteId);

    Major getByCode(@Param("code") String code,@Param("siteId") String siteId);

    int deleteById (String id);

    List<Major> getMajors ();

    Integer getTotalItemsCount(@Param("majorName") String majorName,@Param("siteId") String siteId);

    List<Major> getMajorsByPage(@Param("majorName") String majorName,@Param("page") TailPage page,@Param("siteId") String siteId);

}