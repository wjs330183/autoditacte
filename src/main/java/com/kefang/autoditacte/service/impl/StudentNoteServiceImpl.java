package com.kefang.autoditacte.service.impl;

import com.kefang.autoditacte.dto.StudentNoteDto;
import com.kefang.autoditacte.entity.Course;
import com.kefang.autoditacte.param.CourseParam;
import com.kefang.autoditacte.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.kefang.autoditacte.common.*;
import com.kefang.autoditacte.utils.CommonUtils;
import com.kefang.autoditacte.service.StudentNoteService;
import com.kefang.autoditacte.dao.StudentNoteDao;
import com.kefang.autoditacte.entity.StudentNote;
import com.kefang.autoditacte.param.StudentNoteParam;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;

import com.kefang.autoditacte.service.StudentNoteService;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-28
 */
@Service("studentNoteService")
public class StudentNoteServiceImpl implements StudentNoteService {

    private static Logger logger = LoggerFactory.getLogger(StudentNoteServiceImpl.class);

    @Resource
    private StudentNoteDao studentNoteDao;

    @Resource
    private CourseService courseService;

    /**
     * 单个保存
     */
    @Override
    public JsonData saveStudentNote(StudentNoteParam param) {
        if (CommonUtils.isAnyEmpty()) {
            return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try {
            StudentNote studentNote = StudentNote.builder()
                    .id(param.getId())
                    .courseId(param.getCourseId())
                    .studentId(param.getStudentId())
                    .wareId(param.getWareId())
                    .title(param.getTitle())
                    .context(param.getContext())
                    .showStatus(param.getShowStatus())
                    .build();
            Date date = new Date();
            studentNote.setCreateTime(date);
            studentNote.setUpdateTime(date);
            count = studentNoteDao.save(studentNote);
        } catch (Exception e) {
            logger.error("saveStudentNote error:{}", e.getMessage());
            return JsonData.fail("添加失败");
        }
        return JsonData.success(count, "添加成功");
    }


    /**
     * 根据id删除对象
     */
    @Override
    public JsonData deleteStudentNoteById(String id) {
        if (CommonUtils.isEmpty(id)) {
            return JsonData.fail("id is empty");
        }
        int count = 0;
        try {
            count = studentNoteDao.deleteById(id);
        } catch (Exception e) {
            logger.error("deleteStudentNoteById error:{}", e.getMessage());
            return JsonData.fail("删除失败");
        }
        return JsonData.success(count, "删除成功");
    }


    /**
     * 更新对象
     */
    @Override
    public JsonData updateStudentNote(StudentNoteParam param) {
        if (CommonUtils.isAnyEmpty()) {
            return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try {
            StudentNote studentNote = StudentNote.builder()
                    .id(param.getId())
                    .courseId(param.getCourseId())
                    .studentId(param.getStudentId())
                    .wareId(param.getWareId())
                    .title(param.getTitle())
                    .context(param.getContext())
                    .showStatus(param.getShowStatus())
                    .build();
            Date date = new Date();
            studentNote.setUpdateTime(date);
            count = studentNoteDao.update(studentNote);
        } catch (Exception e) {
            logger.error("updateStudentNote error:{}", e.getMessage());
            return JsonData.fail("修改失败");
        }
        return JsonData.success(count, "修改成功");
    }


    /**
     * 分页模糊查询
     */
    @Override
    public JsonData getStudentNotesByPage(String courseId, TailPage page) {
        try {
            Integer totalItemsCount = studentNoteDao.getTotalItemsCount(courseId);
            List<StudentNote> studentNoteList = studentNoteDao.getStudentNotesByPage(courseId, page);
            List<StudentNoteDto> studentNoteDtoList = new ArrayList<>();
            for (StudentNote studentNote : studentNoteList) {
               StudentNoteDto studentNoteDto=StudentNoteDto.adapt(studentNote);
               studentNoteDtoList.add(studentNoteDto);
            }
            for (StudentNoteDto studentNoteDto : studentNoteDtoList) {
                Course data =  courseService.getCourseById(studentNoteDto.getCourseId());
                if (data != null) {
                    studentNoteDto.setCourseName(data.getName());
                }
            }
            page.setItemsTotalCount(totalItemsCount);
            page.setItems(studentNoteDtoList);

        } catch (Exception e) {
            logger.error("getStudentNote error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(page, "查询成功");
    }
}