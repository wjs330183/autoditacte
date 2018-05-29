package com.kefang.autoditacte.service;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.entity.Site;
import com.kefang.autoditacte.param.SiteParam;
import java.util.*;
import com.kefang.autoditacte.common.*;

/**
* 描述： 服务实现层接口
* @author Json
* @date 2018-05-26
*/
public interface SiteService {


    /**
    * 单个保存
    * @param name 学校名称
	* @param siteUrl 域名前缀
	* @param siteCode 学校代码
	* @param note 备注
	* @param status 是否启用:radio
	
    * @param operator 操作者编号
    */
     JsonData saveSite(SiteParam param);

    /**
    * 通过id删除Site
    */
     JsonData deleteSiteById(String id);


    /**
    * 更新对象
    * @param id ID
	* @param name 学校名称
	* @param siteUrl 域名前缀
	* @param siteCode 学校代码
	* @param note 备注
	* @param status 是否启用:radio
	
    * @param operator 操作者编号
    */
    JsonData updateSite(SiteParam param);


    /**
    * 分页模糊查询Site
    */
    JsonData getSitesByPage(String name, TailPage<Site> page);


	Site getSiteById(String id);




}