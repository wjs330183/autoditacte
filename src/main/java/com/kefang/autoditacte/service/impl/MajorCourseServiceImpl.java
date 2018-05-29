package com.kefang.autoditacte.service.impl;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.dao.MajorCourseDao;
import com.kefang.autoditacte.entity.MajorCourse;
import com.kefang.autoditacte.service.MajorCourseService;
import com.kefang.autoditacte.utils.CommonUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
/**
 * 专业--课程 关系表
 * */

@Service
public class MajorCourseServiceImpl implements MajorCourseService {
    private static Logger logger = Logger.getLogger(MajorCourseServiceImpl.class);

    @Resource
    private MajorCourseDao majorCourseDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public JsonData batchSave(String majorId, List<String> courseIdList) {
        try {
            if (CommonUtils.isEmpty(majorId)) {
                return JsonData.fail("param is empty");
            }
            if (!CommonUtils.isEmpty(courseIdList)) {
                List<MajorCourse> majorCourseList = new ArrayList<>();
                majorCourseDao.deleteByMajorId(majorId);
                for (String courseId : courseIdList) {
                    String id = UUID.randomUUID().toString();
                    Date date = new Date();
                    MajorCourse majorCourse = MajorCourse.builder().id(id).courseId(courseId).majorId(majorId).build();
                    majorCourse.setCreateTime(date);
                    majorCourseList.add(majorCourse);
                    majorCourseDao.save(majorCourse);
                }
            }
            return JsonData.success("添加成功");
        }catch (Exception e){
            logger.error(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return JsonData.fail("添加失败");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public JsonData update(String majorId, List<String> courseIdList) {
        try {

            if (CommonUtils.isEmpty(majorId)) {
                return JsonData.fail("param is empty");
            }
            majorCourseDao.deleteByMajorId(majorId);
            if (!CommonUtils.isEmpty(courseIdList)) {
                for (String courseId : courseIdList) {
                    Date date = new Date();
                    MajorCourse majorCourse = MajorCourse.builder().majorId(majorId).courseId(courseId).build();
                    majorCourse.setCreateTime(date);
                    majorCourseDao.save(majorCourse);
                }
            }
            return JsonData.success("更新成功");
        }catch (Exception e){
            logger.error(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return JsonData.fail("更新失败");
        }
    }

    @Override
    public JsonData delete(String majorId) {
        if (CommonUtils.isEmpty(majorId)) {
            return JsonData.fail("param is empty");
        }
        try {
            majorCourseDao.deleteByMajorId(majorId);
            return JsonData.success("删除成功");
        } catch (Exception e) {
            logger.error("delete MajorCourse error:"+e.getMessage()+"}");
            return JsonData.fail("删除失败");
        }
    }

    public List<String> getCourseIdListByMajorId(String majorId) {
        if (CommonUtils.isEmpty(majorId)) {
            return new ArrayList<>();
        }
        try {
                List<String> courseIdList = majorCourseDao.getCourseIdListByMajorId(majorId);
                return courseIdList;
        } catch (Exception e) {
            logger.error("select MajorCourse error:{"+ e.getMessage()+"}");
            return new ArrayList<>();
        }
    }
}
