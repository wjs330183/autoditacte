package com.kefang.autoditacte.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.kefang.autoditacte.common.*;
import com.kefang.autoditacte.utils.CommonUtils;
import com.kefang.autoditacte.service.StudentEvaluateReportFinallyService;
import com.kefang.autoditacte.dao.StudentEvaluateReportFinallyDao;
import com.kefang.autoditacte.entity.StudentEvaluateReportFinally;
import com.kefang.autoditacte.param.StudentEvaluateReportFinallyParam;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;

import com.kefang.autoditacte.service.StudentEvaluateReportFinallyService;

/**
* 描述：
* @author Json
* @date 2018-05-28
*/
@Service("studentEvaluateReportFinallyService")
public class StudentEvaluateReportFinallyServiceImpl implements StudentEvaluateReportFinallyService {

    private static Logger logger = LoggerFactory.getLogger(StudentEvaluateReportFinallyServiceImpl.class);

    @Resource
    private StudentEvaluateReportFinallyDao studentEvaluateReportFinallyDao;

    /**
    * 单个保存
    */
    @Override
    public JsonData saveStudentEvaluateReportFinally(StudentEvaluateReportFinallyParam param){
        if(CommonUtils.isAnyEmpty()){
        return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try{
        StudentEvaluateReportFinally studentEvaluateReportFinally = StudentEvaluateReportFinally.builder()
                    .id(param.getId())
                    .studentEvaluateReportId(param.getStudentEvaluateReportId())
                    .courseScore(param.getCourseScore())
                    .workScore(param.getWorkScore())
                    .loginScore(param.getLoginScore())
                    .examScore(param.getExamScore())
        .build();
            Date date= new Date();
            studentEvaluateReportFinally.setCreateTime(date);
            studentEvaluateReportFinally.setUpdateTime(date);
            count = studentEvaluateReportFinallyDao.save(studentEvaluateReportFinally);
        } catch (Exception e){
            logger.error("saveStudentEvaluateReportFinally error:{}", e.getMessage());
            return JsonData.fail("添加失败");
        }
        return JsonData.success(count,"添加成功");
    }




    /**
    * 根据id删除对象
    */
    @Override
    public JsonData deleteStudentEvaluateReportFinallyById(String id){
        if(CommonUtils.isEmpty(id)){
            return JsonData.fail("id is empty");
        }
        int count = 0;
        try{
        count = studentEvaluateReportFinallyDao.deleteById(id);
        } catch (Exception e){
            logger.error("deleteStudentEvaluateReportFinallyById error:{}", e.getMessage());
            return JsonData.fail("删除失败");
        }
        return JsonData.success(count,"删除成功");
    }



    /**
    * 更新对象
    */
    @Override
    public JsonData updateStudentEvaluateReportFinally (StudentEvaluateReportFinallyParam param){
        if(CommonUtils.isAnyEmpty()){
        return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try{
            StudentEvaluateReportFinally studentEvaluateReportFinally = StudentEvaluateReportFinally.builder()
                    .id(param.getId())
                    .studentEvaluateReportId(param.getStudentEvaluateReportId())
                    .courseScore(param.getCourseScore())
                    .workScore(param.getWorkScore())
                    .loginScore(param.getLoginScore())
                    .examScore(param.getExamScore())
            .build();
            Date date = new Date();
            studentEvaluateReportFinally.setUpdateTime(date);
            count = studentEvaluateReportFinallyDao.update(studentEvaluateReportFinally);
        } catch (Exception e){
            logger.error("updateStudentEvaluateReportFinally error:{}", e.getMessage());
            return JsonData.fail("修改失败");
        }
        return JsonData.success(count,"修改成功");
    }


    /**
    * 分页模糊查询
    */
    @Override
    public JsonData getStudentEvaluateReportFinallysByPage(String name, TailPage<StudentEvaluateReportFinally> page) {
        try{
            Integer totalItemsCount=studentEvaluateReportFinallyDao.getTotalItemsCount(name);
            List<StudentEvaluateReportFinally> studentEvaluateReportFinallyList=studentEvaluateReportFinallyDao.getStudentEvaluateReportFinallysByPage(name,page);
                page.setItemsTotalCount(totalItemsCount);
                page.setItems(studentEvaluateReportFinallyList);

        } catch (Exception e){
            logger.error("getStudentEvaluateReportFinally error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(page, "查询成功");
        }
}