package com.kefang.autoditacte.service.impl;

import com.kefang.autoditacte.common.Page;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.emuns.IDPrefixAuthority;
import com.kefang.autoditacte.utils.SnowflakeIdWorkerUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.utils.CommonUtils;
import com.kefang.autoditacte.service.WareCourseService;
import com.kefang.autoditacte.dao.WareCourseDao;
import com.kefang.autoditacte.entity.WareCourse;
import com.kefang.autoditacte.param.WareCourseParam;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;

import com.kefang.autoditacte.service.WareCourseService;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-22
 */
@Service("wareCourseService")
public class WareCourseServiceImpl implements WareCourseService {

    private static Logger logger = LoggerFactory.getLogger(WareCourseServiceImpl.class);

    @Resource
    private WareCourseDao wareCourseDao;

    /**
     * 单个保存
     */
    @Override
    public JsonData saveWareCourse(WareCourseParam param) {
        if (CommonUtils.isAnyEmpty()) {
            return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try {
            WareCourse wareCourse = WareCourse.builder()
                    .id(SnowflakeIdWorkerUtils.idGenerator(IDPrefixAuthority.MACHINE_ID.getCode(),IDPrefixAuthority.COURSE_WARE.getCode()))
                    .courseName(param.getCourseName())
                    .wareCode(param.getWareCode())
                    .wareTeacher(param.getWareTeacher())
                    .wareNumber(param.getWareNumber())
                    .status(param.getStatus())
                    .wareRemark(param.getWareRemark())
                    .build();
            Date date = new Date();
            wareCourse.setCreateTime(date);
            wareCourse.setUpdateTime(date);
            count = wareCourseDao.save(wareCourse);
        } catch (Exception e) {
            logger.error("saveWareCourse error:{}", e.getMessage());
            return JsonData.fail("添加失败");
        }
        return JsonData.success(count, "添加成功");
    }


//    /**
//    * 批量保存
//    */
//    @Override
//    DataResult<Boolean> saveWareCourseBatch (String wareCourseJson){
//        if(CommonUtils.isEmpty(wareCourseJson)){
//            result.setCode("1");
//            result.setCode("1");
//            return result;
//        }
//        try{
//            List<WareCourse> wareCourseList = CommonUtils.getListByJson(wareCourseJson, WareCourse.class);
//
//            if (CommonUtils.isEmpty(wareCourseList)) {
//                result.setCode("1");
//                result.setMessage("1");
//                return result;
//            }
//
//            // TODO : 前置代码
//            wareCourseDao.saveBatch(wareCourseList);
//            result.setData(True);
//
//            // TODO : 后置代码
//        } catch (Exception e){
//            logger.error("saveWareCourseBatch error:{}", e.getMessage());
//            result.setCode("1");
//            result.setMessage("1");
//        }
//        return result;
//    }

    /**
     * 根据id获取对象
     */
    @Override
    public JsonData getWareCourseById(String id) {
        if (CommonUtils.isEmpty(id)) {
            return JsonData.fail("id is empty");
        }
        WareCourse wareCourse = null;
        try {
            wareCourse = wareCourseDao.getById(id);
        } catch (Exception e) {
            logger.error("saveWareCourseById error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(wareCourse, "查询成功");
    }

    /**
     * 根据id删除对象
     */
    @Override
    public JsonData deleteWareCourseById(String id) {
        if (CommonUtils.isEmpty(id)) {
            return JsonData.fail("id is empty");
        }
        int count = 0;
        try {
            count = wareCourseDao.deleteById(id);
        } catch (Exception e) {
            logger.error("deleteWareCourseById error:{}", e.getMessage());
            return JsonData.fail("删除失败");
        }
        return JsonData.success(count, "删除成功");
    }


    /**
     * 更新对象
     */
    @Override
    public JsonData updateWareCourse(WareCourseParam param) {
        if (CommonUtils.isAnyEmpty()) {
            return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try {
            WareCourse wareCourse = WareCourse.builder()
                    .id(param.getId())
                    .courseName(param.getCourseName())
                    .wareCode(param.getWareCode())
                    .wareTeacher(param.getWareTeacher())
                    .wareNumber(param.getWareNumber())
                    .status(param.getStatus())
                    .wareRemark(param.getWareRemark())
                    .build();
            Date date = new Date();
            wareCourse.setUpdateTime(date);
            count = wareCourseDao.update(wareCourse);
        } catch (Exception e) {
            logger.error("updateWareCourse error:{}", e.getMessage());
            return JsonData.fail("修改失败");
        }
        return JsonData.success(count, "修改成功");
    }


    /**
     * 查询所有
     */
    @Override
    public JsonData getWareCourse() {
        List<WareCourse> wareCourseList = null;
        try {
            wareCourseList = wareCourseDao.getWareCourse();
        } catch (Exception e) {
            logger.error("getWareCourse error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(wareCourseList, "查询成功");
    }

    @Override
    public JsonData getWareCourseByName(String courseName, TailPage<WareCourse> pages) {
        Integer page = pages.getPageNum();
        Integer length = pages.getPageSize();
        if (page == 0) {
            return JsonData.fail("页码不能为0");
        }
        List<WareCourse> wareCourseList = null;
        try {
            Integer start = (page - 1) * length;
            wareCourseList = wareCourseDao.getWareCourseByName(courseName, start, length);
            int count = wareCourseDao.getWareCourseCount(courseName);
            pages.setItemsTotalCount(count);
            pages.setItems(wareCourseList);
        } catch (Exception e) {
            logger.error("getWareCourse error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(pages, "查询成功");
    }

    @Override
    public JsonData getWareCourse(Integer page, Integer length) {
        if (page == 0) {
            return JsonData.fail("页码不能为0");
        }
        List<WareCourse> wareCourseList = null;
        try {
            Integer start = (page - 1) * length;
            wareCourseList = wareCourseDao.getWareCourseLimit(start, length);
        } catch (Exception e) {
            logger.error("getWareCourse error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(wareCourseList, "查询成功");
    }

    @Override
    public JsonData getIdByName(String name) {
        if (CommonUtils.isEmpty(name)) {
            return JsonData.fail("名字不能为空");
        }
        List idList = new ArrayList();
        try {
            idList = wareCourseDao.getIdByName(name);
        } catch (Exception e) {
            logger.error("getWareCourse error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(idList, "查询成功");
    }

    @Override
    public JsonData getWareCourseName() {
        List nameList = new ArrayList();
        try {
            nameList = wareCourseDao.getWareCourseName();
        } catch (Exception e) {
            logger.error("getWareCourse error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(nameList, "查询成功");
    }

}