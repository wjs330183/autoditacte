package com.kefang.autoditacte.controller;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.entity.Site;
import com.kefang.autoditacte.param.SiteParam;
import com.kefang.autoditacte.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-26
 */
@Controller
public class SiteController {
    @Autowired
    private SiteService siteService;

    @RequestMapping(value = {"/resourceManagement/7/site"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData save(@RequestBody SiteParam param) {
        return siteService.saveSite(param);
    }

    @RequestMapping(value = {"/resourceManagement/7/editSite"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData update(@RequestBody SiteParam param) {
        return siteService.updateSite(param);
    }

    @RequestMapping(value = {"/resourceManagement/7/deletes"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData delete(@RequestParam("id") String id) {
        return siteService.deleteSiteById(id);
    }

    @RequestMapping(value = {"/resourceManagement/7/sites"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getSitesByName(@RequestParam(value = "name", required = false) String name, TailPage<Site> pages) {
        return siteService.getSitesByPage(name, pages);
    }

}