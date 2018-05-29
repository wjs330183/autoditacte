package com.kefang.autoditacte.service.impl;

import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.emuns.IDPrefixAuthority;
import com.kefang.autoditacte.utils.SnowflakeIdWorkerUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.utils.CommonUtils;
import com.kefang.autoditacte.service.WareService;
import com.kefang.autoditacte.dao.WareDao;
import com.kefang.autoditacte.entity.Ware;
import com.kefang.autoditacte.param.WareParam;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;

import com.kefang.autoditacte.service.WareService;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-23
 */
@Service("wareService")
public class WareServiceImpl implements WareService {

    private static Logger logger = LoggerFactory.getLogger(WareServiceImpl.class);

    @Resource
    private WareDao wareDao;

    /**
     * 单个保存
     */
    @Override
    public JsonData saveWare(WareParam param) {
        if (CommonUtils.isAnyEmpty()) {
            return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try {
            Ware ware = Ware.builder()
                    .id(SnowflakeIdWorkerUtils.idGenerator(IDPrefixAuthority.MACHINE_ID.getCode(), IDPrefixAuthority.WARE_COURSE.getCode()))
                    .wareCourseId(param.getWareCourseId())
                    .wareName(param.getWareName())
                    .wareId(param.getWareId())
                    .wareCourse(param.getWareCourse())
                    .teacherName(param.getTeacherName())
                    .playUrl(param.getPlayUrl())
                    .imgUrl(param.getImgUrl())
                    .playCount(param.getPlayCount())
                    .time(param.getTime())
                    .remark(param.getRemark())
                    .status(param.getStatus())
                    .build();
            Date date = new Date();
            ware.setCreateTime(date);
            ware.setUpdateTime(date);
            count = wareDao.save(ware);
        } catch (Exception e) {
            logger.error("saveWare error:{}", e.getMessage());
            return JsonData.fail("添加失败");
        }
        return JsonData.success(count, "添加成功");
    }


//    /**
//     * 批量保存
//     */
//    @Override
//    JsonData saveWareBatch (String wareJson){
//        if(CommonUtils.isEmpty(wareJson)){
//            result.setCode("1");
//            result.setCode("1");
//            return result;
//        }
//        try{
//            List<Ware> wareList = CommonUtils.getListByJson(wareJson, Ware.class);
//
//            if (CommonUtils.isEmpty(wareList)) {
//                result.setCode("1");
//                result.setMessage("1");
//                return result;
//            }
//
//            // TODO : 前置代码
//            wareDao.saveBatch(wareList);
//            result.setData(True);
//
//            // TODO : 后置代码
//        } catch (Exception e){
//            logger.error("saveWareBatch error:{}", e.getMessage());
//            result.setCode("1");
//            result.setMessage("1");
//        }
//        return result;
//    }

    /**
     * 根据id获取对象
     */
    @Override
    public JsonData getWareById(String id, TailPage<Ware> pages) {
        Integer page = pages.getPageNum();
        Integer length = pages.getPageSize();
        if (CommonUtils.isEmpty(id)) {
            return JsonData.fail("id is empty");
        }
        List<Ware> wareList = null;
        try {
            Integer start = (page - 1) * length;
            wareList = wareDao.getWareLimitById(id, start, length);
            int count = wareDao.getWareCountById(id);
            pages.setItemsTotalCount(count);
            pages.setItems(wareList);
        } catch (Exception e) {
            logger.error("saveWareById error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(pages, "查询成功");
    }

    /**
     * 根据id删除对象
     */
    @Override
    public JsonData deleteWareById(String id) {
        if (CommonUtils.isEmpty(id)) {
            return JsonData.fail("id is empty");
        }
        int count = 0;
        try {
            count = wareDao.deleteById(id);
        } catch (Exception e) {
            logger.error("deleteWareById error:{}", e.getMessage());
            return JsonData.fail("删除失败");
        }
        return JsonData.success(count, "删除成功");
    }


    /**
     * 更新对象
     */
    @Override
    public JsonData updateWare(WareParam param) {
        if (CommonUtils.isAnyEmpty()) {
            return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try {
            Ware ware = Ware.builder()
                    .id(param.getId())
                    .wareCourseId(param.getWareCourseId())
                    .wareName(param.getWareName())
                    .wareId(param.getWareId())
                    .wareCourse(param.getWareCourse())
                    .teacherName(param.getTeacherName())
                    .playUrl(param.getPlayUrl())
                    .imgUrl(param.getImgUrl())
                    .playCount(param.getPlayCount())
                    .time(param.getTime())
                    .remark(param.getRemark())
                    .status(param.getStatus())
                    .build();
            Date date = new Date();
            ware.setUpdateTime(date);
            count = wareDao.update(ware);
        } catch (Exception e) {
            logger.error("updateWare error:{}", e.getMessage());
            return JsonData.fail("修改失败");
        }
        return JsonData.success(count, "修改成功");
    }


    /**
     * 查询所有
     */
    @Override
    public JsonData getWare() {
        List<Ware> wareList = null;
        try {
            wareList = wareDao.getWare();
        } catch (Exception e) {
            logger.error("getWare error:{}", e.getMessage());
            return JsonData.fail("修改失败");
        }
        return JsonData.success(wareList, "查询成功");
    }

    @Override
    public JsonData getWareByName(String courseName, TailPage<Ware> pages) {
        Integer page = pages.getPageNum();
        Integer length = pages.getPageSize();
        if (page == 0) {
            return JsonData.fail("页码不能为0");
        }
        List<Ware> wareCourseList = null;
        try {
            Integer start = (page - 1) * length;
            wareCourseList = wareDao.getWareLimit(courseName, start, length);
            int count = wareDao.getWareCount(courseName);
            pages.setItemsTotalCount(count);
            pages.setItems(wareCourseList);
        } catch (Exception e) {
            logger.error("getWareCourse error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(pages, "查询成功");
    }

}