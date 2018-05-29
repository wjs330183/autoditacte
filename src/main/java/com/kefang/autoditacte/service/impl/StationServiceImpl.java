package com.kefang.autoditacte.service.impl;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.dao.StationDao;
import com.kefang.autoditacte.entity.Course;
import com.kefang.autoditacte.entity.Station;
import com.kefang.autoditacte.param.StationParam;
import com.kefang.autoditacte.service.StationService;
import com.kefang.autoditacte.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.jar.JarEntry;

@Service("StationService")
public class StationServiceImpl implements StationService {
    @Autowired
    private StationDao stationDao;

    @Override
    public JsonData save(StationParam param) {
        if (CommonUtils.isAnyEmpty(param.getName(), param.getCode())) {
            return JsonData.fail("param is empty");
        }
        if (stationDao.getByName(param.getName()) != null || stationDao.getByCode(param.getCode()) != null) {
            return JsonData.fail("助学机构已存在");
        }
        String id = UUID.randomUUID().toString();
        Station station = Station.builder().code(param.getCode()).name(param.getName()).note(param.getNote())
                .status(param.getStatus()).id(id).build();
        Date date = new Date();
        station.setCreateTime(date);
        station.setUpdateTime(date);
        stationDao.save(station);
        return JsonData.success("增加成功");
    }

    @Override
    public JsonData update(StationParam param) {
        if (CommonUtils.isAnyEmpty(param.getName(), param.getCode())) {
            return JsonData.fail("param is empty");
        }
        if (!stationDao.getByName(param.getName()).getId().equals(param.getId()) || !stationDao.getByCode(param.getCode()).getId().equals(param.getId())) {
            return JsonData.fail("助学机构已存在");
        }
        Station station = Station.builder().id(param.getId()).name(param.getName()).code(param.getCode()).note(param.getNote())
                .status(param.getStatus()).build();
        Date date = new Date();
        station.setUpdateTime(date);
        stationDao.update(station);
        return JsonData.success("更新成功");
    }

    @Override
    public JsonData delete(String id) {
        stationDao.deleteById(id);
        return JsonData.success("删除成功");
    }

    @Override
    public JsonData getById(String id) {
        Station station = stationDao.getById(id);
        return JsonData.success(station, "查询成功");
    }


    @Override
    public TailPage<Station> getStationsByPage(String stationName, TailPage<Station> page) throws UnsupportedEncodingException {

        String str = null;
        if (CommonUtils.isNotEmpty(stationName)) {
            byte[] bytes = stationName.getBytes();
            str = new String(bytes, "utf8");
        }
        Integer totalItemsCount = stationDao.getTotalItemsCount(str);
        page.setItemsTotalCount(totalItemsCount);
        List<Station> stationList = stationDao.getStationsByPage(str, page);
        page.setItems(stationList);
        return page;
    }

    @Override
    public Station getStationById(String id) {
        Station station = stationDao.getById(id);
        return station;
    }

}
