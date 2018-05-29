package com.kefang.autoditacte.service.impl;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.enums.ResultCode;
import com.kefang.autoditacte.dao.CourseWareCourseExerciseCourseDao;
import com.kefang.autoditacte.entity.CourseWareCourseExerciseCourse;
import com.kefang.autoditacte.exception.ParamException;
import com.kefang.autoditacte.param.CourseWareCourseExerciseCourseParam;
import com.kefang.autoditacte.service.CourseService;
import com.kefang.autoditacte.service.CourseWareCourseExerciseCourseService;
import com.kefang.autoditacte.service.ExerciseCourseService;
import com.kefang.autoditacte.service.WareCourseService;
import com.kefang.autoditacte.utils.CommonUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@Service("courseWareCourseExerciseCourseService")
public class CourseWareCourseExerciseCourseServiceImpl implements CourseWareCourseExerciseCourseService {
    @Resource
    private CourseWareCourseExerciseCourseDao courseWareCourseExerciseCourseDao;
    @Resource
    private CourseService courseService;
    @Resource
    private ExerciseCourseService exerciseCourseService;
    @Resource
    private WareCourseService wareCourseService;
    @Override
    public Integer save(CourseWareCourseExerciseCourseParam param) throws Exception {
        String id=UUID.randomUUID().toString();
        if(CommonUtils.isAnyEmpty(param.getCourseId(),param.getExerciseCourseId(),param.getWareCourseId())){
           throw new ParamException(ResultCode.getDesc(2000));
        }
            CourseWareCourseExerciseCourse courseWareCourseExerciseCourse = CourseWareCourseExerciseCourse.builder().id(id).courseId(param.getCourseId())
                    .exerciseCourseId(param.getExerciseCourseId())
                    .note(param.getNote())
                    .wareCourseId(param.getWareCourseId()).build();
            Date date = new Date();
            courseWareCourseExerciseCourse.setCreateTime(date);
            courseWareCourseExerciseCourse.setUpdateTime(date);
            Integer count = courseWareCourseExerciseCourseDao.insertSelective(courseWareCourseExerciseCourse);
            if (count == 1) {
                return count;
            } else {
                throw new Exception(ResultCode.INSERT_ERROR.getDesc());
            }
        }

    @Override
    public Integer update(CourseWareCourseExerciseCourseParam param) throws Exception {
        if(CommonUtils.isAnyEmpty(param.getCourseId(),param.getWareCourseId(),param.getExerciseCourseId())){
            throw new ParamException(ResultCode.getDesc(2000));
        }
            String id=UUID.randomUUID().toString();
            courseWareCourseExerciseCourseDao.deleteByCourseId(param.getCourseId());
            CourseWareCourseExerciseCourse courseWareCourseExerciseCourse=CourseWareCourseExerciseCourse.builder().id(id)
                    .courseId(param.getCourseId())
                    .wareCourseId(param.getWareCourseId())
                    .exerciseCourseId(param.getExerciseCourseId())
                    .note(param.getNote())
                    .build();
            Date date=new Date();
            courseWareCourseExerciseCourse.setUpdateTime(date);
            courseWareCourseExerciseCourse.setCreateTime(date);
            Integer count=courseWareCourseExerciseCourseDao.insertSelective(courseWareCourseExerciseCourse);
            return count;
    }

    @Override
    public Integer deleteByCourseId(String courseId) throws ParamException {
        if(CommonUtils.isEmpty(courseId)){
            throw new ParamException(ResultCode.getDesc(2000));
        }
        Integer count =courseWareCourseExerciseCourseDao.deleteByPrimaryKey(courseId);
        return count;
    }

    @Override
    public String getWareCourseIdByCourseId(String courseId) throws ParamException {
        if(CommonUtils.isEmpty(courseId)){
            throw new ParamException(ResultCode.getDesc(2000));
        }
        return courseWareCourseExerciseCourseDao.getWareCourseIdByCourseId(courseId);
    }

    @Override
    public String getExerciseCourseIdByCourseId(String courseId) throws ParamException {
        if(CommonUtils.isEmpty(courseId)){
            throw new ParamException(ResultCode.getDesc(2000));
        }
        return courseWareCourseExerciseCourseDao.getExerciseCourseIdByCourseId(courseId);
    }

    public CourseWareCourseExerciseCourse getByCourseId(String courseId) throws ParamException {

        if(CommonUtils.isEmpty(courseId)) {
            throw new ParamException(ResultCode.PARAMETER_ERROR.getDesc());
        }
        CourseWareCourseExerciseCourse courseWareCourseExerciseCourse=courseWareCourseExerciseCourseDao.getByCourseId(courseId);
        return courseWareCourseExerciseCourse;
    }
   /*
    public JsonData getCoursesByPage(String courseName, TailPage page){

        List<CourseDto> courseDtoList=new ArrayList<>();
        try {
            List<Course> courseList=courseService.getCoursesByPage(courseName,page).getItems();
            for(Course course:courseList){
                CourseDto courseDto=CourseDto.adapt(course);
                CourseWareCourseExerciseCourse courseWareCourseExerciseCourse = courseWareCourseExerciseCourseDao.getByCourseId(course.getId());
                if(courseWareCourseExerciseCourse==null){
                    courseDto.setMatched(false);
                }
                ExerciseCourse exerciseCourse=(ExerciseCourse) exerciseCourseService.getExerciseCourseById(courseWareCourseExerciseCourse.getId()).getResultData();
                WareCourse wareCourse=(WareCourse) wareCourseService.getWareCourseById(courseWareCourseExerciseCourse.getWareCourseId()).getResultData();
                courseDto.setExerciseCourse(exerciseCourse);
                courseDto.setWareCourse(wareCourse);
                courseDto.setMatched(true);
                courseDtoList.add(courseDto);
            }
            page.setItems(courseDtoList);
            return JsonData.success(page,"查询成功");
        } catch (UnsupportedEncodingException e) {
            return JsonData.fail("查询失败");
        }
    }
    */
}
