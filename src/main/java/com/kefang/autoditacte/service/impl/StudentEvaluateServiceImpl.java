package com.kefang.autoditacte.service.impl;

import com.kefang.autoditacte.dao.CourseDao;
import com.kefang.autoditacte.dao.StationDao;
import com.kefang.autoditacte.dao.StudentDao;
import com.kefang.autoditacte.dto.StudentDto;
import com.kefang.autoditacte.dto.StudentEvaluateDto;
import com.kefang.autoditacte.entity.Course;
import com.kefang.autoditacte.entity.Station;
import com.kefang.autoditacte.entity.Student;
import com.kefang.autoditacte.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.kefang.autoditacte.common.*;
import com.kefang.autoditacte.utils.CommonUtils;
import com.kefang.autoditacte.service.StudentEvaluateService;
import com.kefang.autoditacte.dao.StudentEvaluateDao;
import com.kefang.autoditacte.entity.StudentEvaluate;
import com.kefang.autoditacte.param.StudentEvaluateParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;

import com.kefang.autoditacte.service.StudentEvaluateService;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-28
 */
@Service("studentEvaluateService")
public class StudentEvaluateServiceImpl implements StudentEvaluateService {

    private static Logger logger = LoggerFactory.getLogger(StudentEvaluateServiceImpl.class);

    @Resource
    private StudentEvaluateDao studentEvaluateDao;

    @Resource
    private StudentDao studentDao;

    @Resource
    private CourseDao courseDao;

    @Resource
    private StationDao stationDao;

    /**
     * 单个保存
     */
    @Override
    public JsonData saveStudentEvaluate(StudentEvaluateParam param) {
        if (CommonUtils.isAnyEmpty()) {
            return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try {
            StudentEvaluate studentEvaluate = StudentEvaluate.builder()
                    .id(param.getId())
                    .studentId(param.getStudentId())
                    .courseId(param.getCourseId())
                    .applyStatus(param.getApplyStatus())
                    .applyTime(param.getApplyTime())
                    .build();
            Date date = new Date();
            studentEvaluate.setCreateTime(date);
            studentEvaluate.setUpdateTime(date);
            count = studentEvaluateDao.save(studentEvaluate);
        } catch (Exception e) {
            logger.error("saveStudentEvaluate error:{}", e.getMessage());
            return JsonData.fail("添加失败");
        }
        return JsonData.success(count, "添加成功");
    }


    /**
     * 根据id删除对象
     */
    @Override
    public JsonData deleteStudentEvaluateById(String id) {
        if (CommonUtils.isEmpty(id)) {
            return JsonData.fail("id is empty");
        }
        int count = 0;
        try {
            count = studentEvaluateDao.deleteById(id);
        } catch (Exception e) {
            logger.error("deleteStudentEvaluateById error:{}", e.getMessage());
            return JsonData.fail("删除失败");
        }
        return JsonData.success(count, "删除成功");
    }


    /**
     * 更新对象
     */
    @Override
    public JsonData updateStudentEvaluate(StudentEvaluateParam param) {
        if (CommonUtils.isAnyEmpty()) {
            return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try {
            StudentEvaluate studentEvaluate = StudentEvaluate.builder()
                    .id(param.getId())
                    .studentId(param.getStudentId())
                    .courseId(param.getCourseId())
                    .applyStatus(param.getApplyStatus())
                    .applyTime(param.getApplyTime())
                    .build();
            Date date = new Date();
            studentEvaluate.setUpdateTime(date);
            count = studentEvaluateDao.update(studentEvaluate);
        } catch (Exception e) {
            logger.error("updateStudentEvaluate error:{}", e.getMessage());
            return JsonData.fail("修改失败");
        }
        return JsonData.success(count, "修改成功");
    }


    /**
     * 分页模糊查询
     */
    @Override
    public JsonData getStudentEvaluatesByPage(String name, TailPage<StudentEvaluate> page) {
        try {
            Integer totalItemsCount = studentEvaluateDao.getTotalItemsCount(name);
            List<StudentEvaluate> studentEvaluateList = studentEvaluateDao.getStudentEvaluatesByPage(name, page);
            page.setItemsTotalCount(totalItemsCount);
            page.setItems(studentEvaluateList);

        } catch (Exception e) {
            logger.error("getStudentEvaluate error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(page, "查询成功");
    }

    @Override
    public JsonData getStudentEvaluates(String year, String stage, String courseName, String stationName, String status, String keyWord, TailPage<StudentEvaluate> page) {
        try {
            List<StudentEvaluate> studentEvaluateList = new ArrayList<>();
            List<StudentEvaluateDto> studentEvaluateDtos = new ArrayList<>();
            List<StudentEvaluateDto> studentEvaluateDtoList = new ArrayList<>();
            for (StudentEvaluate studentEvaluate : studentEvaluateList) {
                StudentEvaluateDto studentEvaluateDto = new StudentEvaluateDto();
                Student student = studentDao.getStudentById(studentEvaluate.getStudentId());
                Course course = courseDao.getById(studentEvaluate.getCourseId());
                Station station = stationDao.getById(student.getStationId());
                studentEvaluateDto.setCourseName(course.getName());
                studentEvaluateDto.setCardId(student.getCardId());
                studentEvaluateDto.setCardType(student.getCardType());
                studentEvaluateDto.setCode(student.getCode());
                studentEvaluateDto.setName(student.getName());
                studentEvaluateDto.setStationName(station.getName());
                studentEvaluateDto.adapt(studentEvaluate);
                studentEvaluateDtos.add(studentEvaluateDto);
            }
            for (StudentEvaluateDto studentEvaluateDto : studentEvaluateDtos) {
                int count = 0;
                if (year != null) {
                    Date createTime = studentEvaluateDto.getCreateTime();
                    String startYear = year + "-01-01 00:00:00";
                    String endYear = year + "-12-31 23:59:59";
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date startDate = sdf.parse(startYear);
                    Date endDate = sdf.parse(endYear);
                    if (createTime.before(endDate) && createTime.after(startDate)) {
                        studentEvaluateDtoList.add(studentEvaluateDto);
                    }
                }

                if (stage != null) {

                } else {
                    count = count + 1;
                }
                if (courseName != null) {
                    if (courseName == studentEvaluateDto.getCourseName()) {
                        count = count + 1;
                    }
                } else {
                    count = count + 1;
                }
                if (stationName != null) {
                    if (stationName == studentEvaluateDto.getStationName()) {
                        count = count + 1;
                    }
                } else {
                    count = count + 1;
                }


            }


        } catch (Exception e) {
            logger.error("getStudentEvaluate error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return null;
    }


    @Override
    public List<StudentEvaluate> getAllEvaluates() {
        return studentEvaluateDao.getAllEvaluates();
    }

}