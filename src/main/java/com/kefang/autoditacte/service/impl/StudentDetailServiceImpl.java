package com.kefang.autoditacte.service.impl;

import com.kefang.autoditacte.param.StudentParam;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.kefang.autoditacte.common.*;
import com.kefang.autoditacte.utils.CommonUtils;
import com.kefang.autoditacte.service.StudentDetailService;
import com.kefang.autoditacte.dao.StudentDetailDao;
import com.kefang.autoditacte.entity.StudentDetail;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-26
 */
@Service("studentDetailService")
public class StudentDetailServiceImpl implements StudentDetailService {

    private static Logger logger = LoggerFactory.getLogger(StudentDetailServiceImpl.class);

    @Resource
    private StudentDetailDao studentDetailDao;

    /**
     * 单个保存
     */
    @Override
    public JsonData saveStudentDetail(StudentParam param, String id) {
        if (CommonUtils.isAnyEmpty()) {
            return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try {
            StudentDetail studentDetail = StudentDetail.builder()
                    .studentId(param.getStudentId())
                    .cardImg(param.getCardImg())
                    .codeImg(param.getCodeImg())
                    .applyImg(param.getApplyImg())
                    .age(param.getAge())
                    .birthday(param.getBirthday())
                    .nation(param.getNation())
                    .zipCode(param.getZipCode())
                    .email(param.getEmail())
                    .graduateSchool(param.getGraduateSchool())
                    .graduateDate(param.getGraduateDate())
                    .schoolRollNo(param.getSchoolRollNo())
                    .diplomaNo(param.getDiplomaNo())
                    .studyKind(param.getStudyKind())
                    .collectiveCode(param.getCollectiveCode())
                    .yearCode(param.getYearCode())
                    .pigeonhole(param.getPigeonhole())
                    .address(param.getAddress())
                    .note(param.getNote())
                    .build();
            studentDetail.setId(id);
            Date date = new Date();
            studentDetail.setCreateTime(date);
            studentDetail.setUpdateTime(date);
            count = studentDetailDao.save(studentDetail);
        } catch (Exception e) {
            logger.error("saveStudentDetail error:{}", e.getMessage());
            return JsonData.fail("添加失败");
        }
        return JsonData.success(count, "添加成功");
    }


    /**
     * 根据id删除对象
     */
    @Override
    public JsonData deleteStudentDetailById(String id) {
        if (CommonUtils.isEmpty(id)) {
            return JsonData.fail("id is empty");
        }
        int count = 0;
        try {
            count = studentDetailDao.deleteById(id);
        } catch (Exception e) {
            logger.error("deleteStudentDetailById error:{}", e.getMessage());
            return JsonData.fail("删除失败");
        }
        return JsonData.success(count, "删除成功");
    }


    /**
     * 更新对象
     */
    @Override
    public JsonData updateStudentDetail(StudentParam param) {
        if (CommonUtils.isAnyEmpty()) {
            return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try {
            StudentDetail studentDetail = StudentDetail.builder()
                    .id(param.getId())
                    .studentId(param.getStudentId())
                    .cardImg(param.getCardImg())
                    .codeImg(param.getCodeImg())
                    .applyImg(param.getApplyImg())
                    .age(param.getAge())
                    .birthday(param.getBirthday())
                    .nation(param.getNation())
                    .zipCode(param.getZipCode())
                    .email(param.getEmail())
                    .graduateSchool(param.getGraduateSchool())
                    .graduateDate(param.getGraduateDate())
                    .schoolRollNo(param.getSchoolRollNo())
                    .diplomaNo(param.getDiplomaNo())
                    .studyKind(param.getStudyKind())
                    .collectiveCode(param.getCollectiveCode())
                    .yearCode(param.getYearCode())
                    .pigeonhole(param.getPigeonhole())
                    .address(param.getAddress())
                    .note(param.getNote())
                    .build();
            Date date = new Date();
            studentDetail.setUpdateTime(date);
            count = studentDetailDao.update(studentDetail);
        } catch (Exception e) {
            logger.error("updateStudentDetail error:{}", e.getMessage());
            return JsonData.fail("修改失败");
        }
        return JsonData.success(count, "修改成功");
    }


    /**
     * 分页模糊查询
     */
    @Override
    public JsonData getStudentDetailsByPage(String name, TailPage page) {
        try {
            Integer totalItemsCount = studentDetailDao.getTotalItemsCount(name);
            List<StudentDetail> studentDetailList = studentDetailDao.getStudentDetailsByPage(name, page);
            page.setItemsTotalCount(totalItemsCount);
            page.setItems(studentDetailList);

        } catch (Exception e) {
            logger.error("getStudentDetail error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(page, "查询成功");
    }

    @Override
    public StudentDetail getStudentDetailsById(String id) {
        StudentDetail studentDetail = new StudentDetail();
        try {
            studentDetail = studentDetailDao.getStudentDetailsById(id);
        } catch (Exception e) {
            logger.error("getStudentDetail error:{}", e.getMessage());
            return null;
        }
        return studentDetail;
    }
}