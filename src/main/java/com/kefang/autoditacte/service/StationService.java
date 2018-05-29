package com.kefang.autoditacte.service;

import com.kefang.autoditacte.common.JsonData;

import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.entity.Station;
import com.kefang.autoditacte.param.StationParam;

import java.io.UnsupportedEncodingException;


public interface StationService {
    JsonData save(StationParam param);

    JsonData update(StationParam param);
    JsonData delete(String id);

    JsonData getById(String id);

    TailPage<Station> getStationsByPage(String stationName, TailPage<Station> page) throws UnsupportedEncodingException;

    Station getStationById(String id);

}
