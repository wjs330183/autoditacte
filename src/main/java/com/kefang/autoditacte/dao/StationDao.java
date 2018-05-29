package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.entity.Station;
import com.kefang.autoditacte.param.StationParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface StationDao {

    void save(Station station);
    Integer update(Station station);
    Integer deleteById(String id);
    Station getById(String id);
    Station getByName(String name);
    Station getByCode(String code);
    Integer getTotalItemsCount(@Param("stationName") String stationName);
    List<Station> getStationsByPage(@Param("stationName") String stationName, @Param("page") TailPage page);

}
