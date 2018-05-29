package com.kefang.autoditacte.controller;


import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.entity.Station;
import com.kefang.autoditacte.param.StationParam;
import com.kefang.autoditacte.service.StationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
public class StationController {
    @Autowired
    private StationService stationService;
    private Logger logger = Logger.getLogger(StationController.class);
    //增加
    @RequestMapping(value = "/baseInfo/3/station",method = RequestMethod.POST)
    public JsonData save(@RequestBody StationParam param){
        try{
            return stationService.save(param);
        }catch (Exception e){
            logger.error(e.getMessage());
            return JsonData.fail("添加失败");
        }
    }
    //编辑
    @RequestMapping(value = "/baseInfo/3/editStation",method = RequestMethod.POST)
    public JsonData update(@RequestBody StationParam param){
        try{
            return stationService.update(param);
        }catch (Exception e){
            logger.error(e.getMessage());
            return JsonData.fail("编辑失败");
        }
    }
    //删除
    @RequestMapping(value = "/baseInfo/3/delete",method = RequestMethod.POST)
    public JsonData delete(@RequestParam("id") String id){
        try{
            return stationService.delete(id);
        }catch (Exception e){
            logger.error(e.getMessage());
            return JsonData.fail("删除失败");
        }
    }
    //根据id查找
    @RequestMapping(value = "/baseInfo/3/station",method = RequestMethod.GET)
    public JsonData getById(@RequestParam("id") String id){
        try{
            return stationService.getById(id);
        }catch (Exception e){
            logger.error(e.getMessage());
            return JsonData.fail("查找失败");
        }
    }
    //分页
    @RequestMapping(value = "/baseInfo/3/stationsPage",method = RequestMethod.GET)
    public TailPage<Station> getStationsByPage(@RequestParam(value = "stationName",required = false) String stationName, TailPage page){
        try {
            return stationService.getStationsByPage(stationName,page);
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
            return null;
        }
    }


}
