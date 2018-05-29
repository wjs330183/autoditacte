package com.kefang.autoditacte.controller;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.entity.Ware;
import com.kefang.autoditacte.param.WareParam;
import com.kefang.autoditacte.service.WareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class WareController {
    //Resource management
    @Autowired
    private WareService wareService;

    @RequestMapping(value = {"/resourceManagement/2/ware"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData save(@RequestBody WareParam param) {
        return wareService.saveWare(param);
    }

    @RequestMapping(value = {"/resourceManagement/2/editWare"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData update(@RequestBody WareParam param) {
        return wareService.updateWare(param);
    }

    @RequestMapping(value = {"/resourceManagement/2/delete"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData delete(@RequestParam("id") String id) {
        return wareService.deleteWareById(id);
    }

    @RequestMapping(value = {"/resourceManagement/2/wares"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getAll() {
        return wareService.getWare();
    }

    @RequestMapping(value = {"/resourceManagement/2/wareByName"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getWareByName(@RequestParam(value = "courseName", required = false) String courseName, TailPage<Ware> pages) {

        return wareService.getWareByName(courseName, pages);
    }

    @RequestMapping(value = {"/resourceManagement/2/wareById"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getWareById(@RequestParam(value = "id", required = true) String id, TailPage<Ware> pages) {

        return wareService.getWareById(id, pages);
    }

}
