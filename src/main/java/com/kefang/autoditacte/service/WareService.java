package com.kefang.autoditacte.service;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.entity.Ware;
import com.kefang.autoditacte.param.WareParam;

import java.util.*;

/**
 * 描述： 服务实现层接口
 *
 * @author Json
 * @date 2018-05-18
 */
public interface WareService {


    /**
     * 单个保存
     *
     * @param name         课件名称
     * @param teacherName  讲师名字
     * @param teacherIntro 讲师简介
     * @param code
     * @param logo         封面:img
     * @param playCount    观看次数
     * @param star         课件评分
     * @param time         时长(秒)
     * @param sourceHD     播放地址:wareView
     * @param order        顺序号
     * @param createTime   创建时间
     * @param updateTime   更新时间
     * @param note         备注
     * @param status       状态:radio
     * @param operator     操作者编号
     */
    JsonData saveWare(WareParam param);

    /**
     * 批量保存
     * @param wareJson 对象集合 Json 字符串
     * @param operator 操作者编号
     */
//    JsonData  saveWareBatch(String wareJson);

    /**
     * 根据id获取对象
     *
     * @param id ID
     */
    JsonData getWareById(String id, TailPage<Ware> pages);

    /**
     * 根据id删除对象
     *
     * @param id ID
     */
    JsonData deleteWareById(String id);


    /**
     * 更新对象
     *
     * @param id           ID
     * @param name         课件名称
     * @param teacherName  讲师名字
     * @param teacherIntro 讲师简介
     * @param code
     * @param logo         封面:img
     * @param playCount    观看次数
     * @param star         课件评分
     * @param time         时长(秒)
     * @param sourceHD     播放地址:wareView
     * @param order        顺序号
     * @param createTime   创建时间
     * @param updateTime   更新时间
     * @param note         备注
     * @param status       状态:radio
     * @param operator     操作者编号
     */
    JsonData updateWare(WareParam param);

    ;


    /**
     * 查询Ware
     */
    JsonData getWare();

    /**
     * 查询Ware(包含通过名字进行模糊查询)
     */
    JsonData getWareByName(String courseName, TailPage<Ware> pages);

}