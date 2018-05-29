package com.kefang.autoditacte.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.kefang.autoditacte.common.*;
import com.kefang.autoditacte.utils.CommonUtils;
import com.kefang.autoditacte.service.StudentEvaluateReportService;
import com.kefang.autoditacte.dao.StudentEvaluateReportDao;
import com.kefang.autoditacte.entity.StudentEvaluateReport;
import com.kefang.autoditacte.param.StudentEvaluateReportParam;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;

import com.kefang.autoditacte.service.StudentEvaluateReportService;

/**
* 描述：
* @author Json
* @date 2018-05-28
*/
@Service("studentEvaluateReportService")
public class StudentEvaluateReportServiceImpl implements StudentEvaluateReportService {

    private static Logger logger = LoggerFactory.getLogger(StudentEvaluateReportServiceImpl.class);

    @Resource
    private StudentEvaluateReportDao studentEvaluateReportDao;

    /**
    * 单个保存
    */
    @Override
    public JsonData saveStudentEvaluateReport(StudentEvaluateReportParam param){
        if(CommonUtils.isAnyEmpty()){
        return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try{
        StudentEvaluateReport studentEvaluateReport = StudentEvaluateReport.builder()
                    .id(param.getId())
                    .studentId(param.getStudentId())
                    .courseId(param.getCourseId())
                    .commonScore(param.getCommonScore())
                    .loginTimes(param.getLoginTimes())
                    .noteTimes(param.getNoteTimes())
                    .workTimes(param.getWorkTimes())
                    .examScore(param.getExamScore())
        .build();
            Date date= new Date();
            studentEvaluateReport.setCreateTime(date);
            studentEvaluateReport.setUpdateTime(date);
            count = studentEvaluateReportDao.save(studentEvaluateReport);
        } catch (Exception e){
            logger.error("saveStudentEvaluateReport error:{}", e.getMessage());
            return JsonData.fail("添加失败");
        }
        return JsonData.success(count,"添加成功");
    }




    /**
    * 根据id删除对象
    */
    @Override
    public JsonData deleteStudentEvaluateReportById(String id){
        if(CommonUtils.isEmpty(id)){
            return JsonData.fail("id is empty");
        }
        int count = 0;
        try{
        count = studentEvaluateReportDao.deleteById(id);
        } catch (Exception e){
            logger.error("deleteStudentEvaluateReportById error:{}", e.getMessage());
            return JsonData.fail("删除失败");
        }
        return JsonData.success(count,"删除成功");
    }



    /**
    * 更新对象
    */
    @Override
    public JsonData updateStudentEvaluateReport (StudentEvaluateReportParam param){
        if(CommonUtils.isAnyEmpty()){
        return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try{
            StudentEvaluateReport studentEvaluateReport = StudentEvaluateReport.builder()
                    .id(param.getId())
                    .studentId(param.getStudentId())
                    .courseId(param.getCourseId())
                    .commonScore(param.getCommonScore())
                    .loginTimes(param.getLoginTimes())
                    .noteTimes(param.getNoteTimes())
                    .workTimes(param.getWorkTimes())
                    .examScore(param.getExamScore())
            .build();
            Date date = new Date();
            studentEvaluateReport.setUpdateTime(date);
            count = studentEvaluateReportDao.update(studentEvaluateReport);
        } catch (Exception e){
            logger.error("updateStudentEvaluateReport error:{}", e.getMessage());
            return JsonData.fail("修改失败");
        }
        return JsonData.success(count,"修改成功");
    }


    /**
    * 分页模糊查询
    */
    @Override
    public JsonData getStudentEvaluateReportsByPage(String name, TailPage<StudentEvaluateReport> page) {
        try{
            Integer totalItemsCount=studentEvaluateReportDao.getTotalItemsCount(name);
            List<StudentEvaluateReport> studentEvaluateReportList=studentEvaluateReportDao.getStudentEvaluateReportsByPage(name,page);
                page.setItemsTotalCount(totalItemsCount);
                page.setItems(studentEvaluateReportList);

        } catch (Exception e){
            logger.error("getStudentEvaluateReport error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(page, "查询成功");
        }
}