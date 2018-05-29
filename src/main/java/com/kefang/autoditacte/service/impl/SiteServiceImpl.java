package com.kefang.autoditacte.service.impl;

import com.kefang.autoditacte.dao.SiteDao;
import com.kefang.autoditacte.emuns.IDPrefixAuthority;
import com.kefang.autoditacte.utils.SnowflakeIdWorkerUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.kefang.autoditacte.common.*;
import com.kefang.autoditacte.utils.CommonUtils;
import com.kefang.autoditacte.service.SiteService;
import com.kefang.autoditacte.entity.Site;
import com.kefang.autoditacte.param.SiteParam;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-26
 */
@Service("siteService")
public class SiteServiceImpl implements SiteService {

    private static Logger logger = LoggerFactory.getLogger(SiteServiceImpl.class);

    @Resource
    private SiteDao siteDao;

    /**
     * 单个保存
     */
    @Override
    public JsonData saveSite(SiteParam param) {
        if (CommonUtils.isAnyEmpty()) {
            return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try {
            Site site = Site.builder()
                    .id(SnowflakeIdWorkerUtils.idGenerator(IDPrefixAuthority.MACHINE_ID.getCode(), IDPrefixAuthority.SCHOOL_MANAGEMENT.getCode()))
                    .name(param.getName())
                    .siteUrl(param.getSiteUrl())
                    .siteCode(param.getSiteCode())
                    .note(param.getNote())
                    .status(param.getStatus())
                    .build();
            Date date = new Date();
            site.setCreateTime(date);
            site.setUpdateTime(date);
            count = siteDao.save(site);
        } catch (Exception e) {
            logger.error("saveSite error:{}", e.getMessage());
            return JsonData.fail("添加失败");
        }
        return JsonData.success(count, "添加成功");
    }


    /**
     * 根据id删除对象
     */
    @Override
    public JsonData deleteSiteById(String id) {
        if (CommonUtils.isEmpty(id)) {
            return JsonData.fail("id is empty");
        }
        int count = 0;
        try {
            count = siteDao.deleteById(id);
        } catch (Exception e) {
            logger.error("deleteSiteById error:{}", e.getMessage());
            return JsonData.fail("删除失败");
        }
        return JsonData.success(count, "删除成功");
    }


    /**
     * 更新对象
     */
    @Override
    public JsonData updateSite(SiteParam param) {
        if (CommonUtils.isAnyEmpty()) {
            return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try {
            Site site = Site.builder()
                    .id(param.getId())
                    .name(param.getName())
                    .siteUrl(param.getSiteUrl())
                    .siteCode(param.getSiteCode())
                    .note(param.getNote())
                    .status(param.getStatus())
                    .build();
            Date date = new Date();
            site.setUpdateTime(date);
            count = siteDao.update(site);
        } catch (Exception e) {
            logger.error("updateSite error:{}", e.getMessage());
            return JsonData.fail("修改失败");
        }
        return JsonData.success(count, "修改成功");
    }


    /**
     * 分页模糊查询
     */
    @Override
    public JsonData getSitesByPage(String name, TailPage<Site> page) {
        try {
            Integer totalItemsCount = siteDao.getTotalItemsCount(name);
            List<Site> siteList = siteDao.getSitesByPage(name, page);
            page.setItemsTotalCount(totalItemsCount);
            page.setItems(siteList);
        } catch (Exception e) {
            logger.error("getSite error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(page, "查询成功");
    }

    @Override
    public Site getSiteById(String id) {
        Site site = new Site();

        try {
            site = siteDao.getSiteById(id);
        } catch (Exception e) {
            logger.error("getSite error:{}", e.getMessage());
            return null;
        }
        return site;
    }
}