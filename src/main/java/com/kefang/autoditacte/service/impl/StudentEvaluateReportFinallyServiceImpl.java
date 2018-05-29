package com.kefang.autoditacte.service.impl;

import com.kefang.autoditacte.dao.StudentDao;
import com.kefang.autoditacte.dao.StudentEvaluateReportDao;
import com.kefang.autoditacte.dto.StudentEvaluateReportFinallyDto;
import com.kefang.autoditacte.entity.*;
import com.kefang.autoditacte.service.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.kefang.autoditacte.common.*;
import com.kefang.autoditacte.utils.CommonUtils;
import com.kefang.autoditacte.dao.StudentEvaluateReportFinallyDao;
import com.kefang.autoditacte.param.StudentEvaluateReportFinallyParam;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kefang.autoditacte.service.StudentEvaluateReportFinallyService;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-28
 */
@Service("studentEvaluateReportFinallyService")
public class StudentEvaluateReportFinallyServiceImpl implements StudentEvaluateReportFinallyService {

    private static Logger logger = LoggerFactory.getLogger(StudentEvaluateReportFinallyServiceImpl.class);

    @Resource
    private StudentEvaluateReportFinallyDao studentEvaluateReportFinallyDao;
    @Resource
    private StudentDao studentDao;

    @Resource
    private StudentDetailService studentDetailService;

    @Resource
    private SiteService siteService;

    @Resource
    private StationService stationService;

    @Resource
    private MajorService majorService;

    @Resource
    private StudentEvaluateReportDao studentEvaluateReportDao;
    /**
     * 单个保存
     */
    @Override
    public JsonData saveStudentEvaluateReportFinally(StudentEvaluateReportFinallyParam param) {
        if (CommonUtils.isAnyEmpty()) {
            return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try {
            StudentEvaluateReportFinally studentEvaluateReportFinally = StudentEvaluateReportFinally.builder()
                    .id(param.getId())
                    .studentEvaluateReportId(param.getStudentEvaluateReportId())
                    .courseScore(param.getCourseScore())
                    .workScore(param.getWorkScore())
                    .loginScore(param.getLoginScore())
                    .examScore(param.getExamScore())
                    .build();
            Date date = new Date();
            studentEvaluateReportFinally.setCreateTime(date);
            studentEvaluateReportFinally.setUpdateTime(date);
            count = studentEvaluateReportFinallyDao.save(studentEvaluateReportFinally);
        } catch (Exception e) {
            logger.error("saveStudentEvaluateReportFinally error:{}", e.getMessage());
            return JsonData.fail("添加失败");
        }
        return JsonData.success(count, "添加成功");
    }


    /**
     * 根据id删除对象
     */
    @Override
    public JsonData deleteStudentEvaluateReportFinallyById(String id) {
        if (CommonUtils.isEmpty(id)) {
            return JsonData.fail("id is empty");
        }
        int count = 0;
        try {
            count = studentEvaluateReportFinallyDao.deleteById(id);
        } catch (Exception e) {
            logger.error("deleteStudentEvaluateReportFinallyById error:{}", e.getMessage());
            return JsonData.fail("删除失败");
        }
        return JsonData.success(count, "删除成功");
    }


    /**
     * 更新对象
     */
    @Override
    public JsonData updateStudentEvaluateReportFinally(StudentEvaluateReportFinallyParam param) {
        if (CommonUtils.isAnyEmpty()) {
            return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try {
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
        } catch (Exception e) {
            logger.error("updateStudentEvaluateReportFinally error:{}", e.getMessage());
            return JsonData.fail("修改失败");
        }
        return JsonData.success(count, "修改成功");
    }


    /**
     * 分页模糊查询
     */
    @Override
    public JsonData getStudentEvaluateReportFinallysByPage(String name, TailPage<StudentEvaluateReportFinally> page) {
        try {
            Integer totalItemsCount = studentEvaluateReportFinallyDao.getTotalItemsCount(name);
            List<StudentEvaluateReportFinally> studentEvaluateReportFinallyList = studentEvaluateReportFinallyDao.getStudentEvaluateReportFinallysByPage(name, page);
            page.setItemsTotalCount(totalItemsCount);
            page.setItems(studentEvaluateReportFinallyList);

        } catch (Exception e) {
            logger.error("getStudentEvaluateReportFinally error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(page, "查询成功");
    }

    @Override
    public JsonData getStudentEvaluateReportFinallys(String startTime, String endTime, String courseId, String stationId, String status, String keyWord, TailPage page) {
        try {
            List<StudentEvaluateReportFinally> studentDtos = new ArrayList<>();
            List<Student> studentList = studentDao.getStudents(stationId, status, keyWord, page);
            Integer totalItemsCount = studentDao.getTotalItemsCounts(stationId, status, keyWord);
            for (Student resultDatum : studentList) {
                String id = resultDatum.getId();
                StudentEvaluateReportFinallyDto studentEvaluateReportFinallyDto = new StudentEvaluateReportFinallyDto();
                Station station = stationService.getStationById(resultDatum.getStationId());
                StudentEvaluateReport studentEvaluateReport = studentEvaluateReportDao.getStudentEvaluateReport(resultDatum.getId());
                StudentEvaluateReportFinally studentEvaluateReportFinally = null;
                if (studentEvaluateReport != null) {
                    studentEvaluateReportFinally = studentEvaluateReportFinallyDao.getStudentEvaluateReportFinallyByStudentEvaluateReportId(studentEvaluateReport.getId());
                    studentEvaluateReportFinallyDto.adapt(studentEvaluateReportFinally);
                }
                if (station != null) {
                    studentEvaluateReportFinallyDto.setStationName(station.getName());
                    studentEvaluateReportFinallyDto.setSiteCode(station.getCode());
                }
                Site site = siteService.getSiteById(resultDatum.getSiteId());
                if (site != null) {
                    studentEvaluateReportFinallyDto.setSiteName(site.getName());
                    studentEvaluateReportFinallyDto.setSiteCode(site.getSiteCode());
                }
                Major major = majorService.getMajor(resultDatum.getMajorId());
                if (major != null) {
                    studentEvaluateReportFinallyDto.setMajorCode(major.getCode());
                    studentEvaluateReportFinallyDto.setMajorName(major.getName());
                }
                studentDtos.add(studentEvaluateReportFinallyDto);
            }
            page.setItemsTotalCount(totalItemsCount);
            page.setItems(studentDtos);

        } catch (Exception e) {
            logger.error("getStudentEvaluateReportFinally error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(page, "查询成功");
    }
}