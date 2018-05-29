package com.kefang.autoditacte.service.impl;

import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.common.enums.ResultCode;

import com.kefang.autoditacte.dto.CourseDto;
import com.kefang.autoditacte.entity.*;
import com.kefang.autoditacte.exception.ParamException;
import com.kefang.autoditacte.param.CourseWareCourseExerciseCourseParam;
import com.kefang.autoditacte.service.*;
import com.kefang.autoditacte.utils.ExcelFileUtils;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


import com.kefang.autoditacte.utils.CommonUtils;
import com.kefang.autoditacte.dao.CourseDao;
import com.kefang.autoditacte.param.CourseParam;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.regex.Pattern;

import org.springframework.transaction.annotation.Transactional;


/**
* 描述：
* @author Json
* @date 2018-05-18
*/
@Service("courseService")
public class CourseServiceImpl implements CourseService {

   private static Logger logger = Logger.getLogger(CourseServiceImpl.class);
    @Resource
    private CourseDao courseDao;
    @Resource
    private CourseWareCourseExerciseCourseService courseWareCourseExerciseCourseService;
    @Resource
    private WareCourseService wareCourseService;
    @Resource
    private ExerciseCourseService exerciseCourseService;

    /**
    * 单个保存
    */
    @Override
    @Transactional
    public String saveCourse(CourseParam param) throws Exception {
        if(CommonUtils.isAnyEmpty(param.getName(),param.getCode())){
            throw new ParamException("参数为空");
        }
            String  id=UUID.randomUUID().toString();
            if(courseDao.getByName(param.getName())!=null){
                throw new ParamException("课程已存在");
            }
            if(!CommonUtils.isAnyEmpty(param.getWareCourseId(),param.getExerciseCourseId())){
                CourseWareCourseExerciseCourseParam courseWareCourseExerciseCourseParam=new CourseWareCourseExerciseCourseParam();
                courseWareCourseExerciseCourseParam.setCourseId(id);
                courseWareCourseExerciseCourseParam.setExerciseCourseId(param.getExerciseCourseId());
                courseWareCourseExerciseCourseParam.setWareCourseId(param.getWareCourseId());
                courseWareCourseExerciseCourseService.save(courseWareCourseExerciseCourseParam);
            }

        Course course = Course.builder().id(id)
                    .name(param.getName())
                    .code(param.getCode())
                    .note(param.getNote())
                    .price(param.getPrice())
                    .soldPrice(param.getSoldPrice())
                    .status(param.getStatus()).build();
        Date date=new Date();
        course.setUpdateTime(date);
        course.setCreateTime(date);
        courseDao.save(course);
        return id;

    }


    /**
    * 批量保存

    @Override
    DataResult<Boolean> saveCourseBatch (String courseJson){
        if(CommonUtils.isEmpty(courseJson)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            List<Course> courseList = CommonUtils.getListByJson(courseJson, Course.class);

            if (CommonUtils.isEmpty(courseList)) {
                result.setCode("1");
                result.setMessage("1");
                return result;
            }

            // TODO : 前置代码
            courseDao.saveBatch(courseList);
            result.setData(True);

            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveCourseBatch error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
        }
        return result;
    }

    /**
    * 根据id获取对象
    */
    @Override
    public CourseDto getCourseById (String id) throws ParamException {
        if(CommonUtils.isEmpty(id)){
            throw new ParamException(ResultCode.getDesc(2000));
        }
        Course course = courseDao.getById(id);
        String courseId=course.getId();
        String wareCourseId=courseWareCourseExerciseCourseService.getWareCourseIdByCourseId(courseId);
        String exerciseCourseId=courseWareCourseExerciseCourseService.getExerciseCourseIdByCourseId(courseId);
        if(CommonUtils.isAnyEmpty(wareCourseId,exerciseCourseId)){
            CourseDto courseDto=CourseDto.adapt(course);
            courseDto.setMatched(false);
            return courseDto;
        }
        WareCourse wareCourse= (WareCourse) wareCourseService.getWareCourseById(wareCourseId).getResultData();
        ExerciseCourse exerciseCourse= (ExerciseCourse) exerciseCourseService.getExerciseCourseById(exerciseCourseId).getResultData();
        CourseDto courseDto=CourseDto.adapt(course);
        courseDto.setWareCourse(wareCourse);
        courseDto.setExerciseCourse(exerciseCourse);
        courseDto.setMatched(true);
        return courseDto;
    }

    /**
    * 根据id删除对象
    */
    @Override
    @Transactional
    public Integer deleteCourseById(String id) throws Exception {
        if(CommonUtils.isEmpty(id)){
           throw new ParamException(ResultCode.getDesc(2000));
        }
        Integer count=courseDao.deleteById(id);
        Integer count1=courseWareCourseExerciseCourseService.deleteByCourseId(id);
        if(count!=count1){
            throw new Exception(ResultCode.DELETE_ERROR.getDesc());
        }
        return count;

    }



    /**
    * 更新对象
    */
    @Override
    @Transactional
    public Integer updateCourse (CourseParam param) throws Exception {
        if(CommonUtils.isAnyEmpty(param.getId(),param.getCode(),param.getName())){
            throw new ParamException(ResultCode.getDesc(2000));
        }
        if(courseDao.getById(param.getId())==null){
            throw new ParamException(ResultCode.getDesc(2000));
        }
        if(!CommonUtils.isAnyEmpty(param.getExerciseCourseId(),param.getWareCourseId())){
            CourseWareCourseExerciseCourseParam courseWareCourseExerciseCourseParam=new CourseWareCourseExerciseCourseParam();
            courseWareCourseExerciseCourseParam.setWareCourseId(param.getWareCourseId());
            courseWareCourseExerciseCourseParam.setExerciseCourseId(param.getExerciseCourseId());
            courseWareCourseExerciseCourseParam.setCourseId(param.getId());
            courseWareCourseExerciseCourseService.update(courseWareCourseExerciseCourseParam);
        }
            Course course = Course.builder()
                .id(param.getId())
                .name(param.getName())
                .code(param.getCode())
                .note(param.getNote())
                .price(param.getPrice())
                    .soldPrice(param.getSoldPrice())
                    .status(param.getStatus()).build();
            Date date = new Date();
            course.setUpdateTime(date);
            Integer count=courseDao.update(course);
            if(count!=1){
                throw new Exception(ResultCode.UPDATE_ERROR.getDesc());
            }
            return count;
    }



    /**
    * 查询所有

    @Override
    public JsonData getCourses (){
        List<Course> courseList = null;
        try{
            courseList = courseDao.getCourses();
        } catch (Exception e){
            logger.error("getCourse error:{"+e.getMessage()+"}");
            return JsonData.fail("查询失败");
        }
        return JsonData.success(courseList,"查询成功");
    }
     */
    /**
     * 分页
     * */

    @Override
    public TailPage<Course> getCourseDtosByPage(String courseName, TailPage page) throws ParamException {
        Integer totalItemsCount=courseDao.getTotalItemsCount(courseName);
        List<Course> courseList=courseDao.getCoursesByPage(courseName,page);
        List<CourseDto> courseDtoList=new ArrayList<>();
        for(Course course:courseList){
            CourseDto courseDto=CourseDto.adapt(course);
            String courseId=course.getId();
            String wareCourseId=courseWareCourseExerciseCourseService.getWareCourseIdByCourseId(courseId);
            String exerciseCourseId=courseWareCourseExerciseCourseService.getExerciseCourseIdByCourseId(courseId);
            if(CommonUtils.isAnyEmpty(wareCourseId,exerciseCourseId)){
                courseDto.setMatched(false);
                courseDtoList.add(courseDto);
            }else{
                WareCourse wareCourse = (WareCourse) wareCourseService.getWareCourseById(wareCourseId).getResultData();
                ExerciseCourse exerciseCourse = (ExerciseCourse) exerciseCourseService.getExerciseCourseById(exerciseCourseId).getResultData();
                courseDto.setExerciseCourse(exerciseCourse);
                courseDto.setWareCourse(wareCourse);
                courseDto.setMatched(true);
                courseDtoList.add(courseDto);
            }
        }
        page.setItems(courseDtoList);
        return page;
    }
    @Override
    public TailPage<Course> getCoursesByPage(String courseName, TailPage<Course> page) throws UnsupportedEncodingException {
        Integer totalItemsCount=courseDao.getTotalItemsCount(courseName);
        List<Course> courseList=courseDao.getCoursesByPage(courseName,page);
        page.setItemsTotalCount(totalItemsCount);
        page.setItems(courseList);
        return page;
    }

    /**
     * 从excel读取,批量插入
     * */
    @Override
    @Transactional
    public Integer batchImport(InputStream is) throws ParamException {
        ExcelFileUtils excelFileUtils=new ExcelFileUtils();
        List<Map<String,String>> data=excelFileUtils.readExcel(is);
        List<Course> courseList=new ArrayList<>();
        for(Map m:data){
            String id=UUID.randomUUID().toString();
            //正则判断是否为浮点数
            Pattern pattern = Pattern.compile("[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*");
            String price=(String)m.get("课程定价（元）");
            String soldPrice=(String)m.get("课程售价（元）");
            //如不是小数，在结尾加上.0
            if(!price.contains(".")){
                price=price+".0";
            }
            if(!price.contains(".")){
                soldPrice=soldPrice+".0";
            }
            if(!pattern.matcher(price).matches()||!pattern.matcher(soldPrice).matches()){
                throw new ParamException(ResultCode.PARAMETER_ERROR.getDesc()+",售价应为数字");
            }
            Course course=Course.builder().id(id).status(1).code((String)m.get("课程编码")).name((String)m.get("课程名称")).note((String)m.get("备注"))
                    .soldPrice(Double.parseDouble(soldPrice))
                    .price(Double.parseDouble(price)).build();
            if(courseDao.getByName(course.getName())!=null||CommonUtils.isEmpty(course.getName())){
                course=null;
                continue;
            }
            Date date=new Date();
            course.setCreateTime(date);
            course.setUpdateTime(date);
            courseList.add(course);
        }
        if(CommonUtils.isNotEmpty(courseList)){
            return 0;
        }
        Integer count=courseDao.insertBatch(courseList);
        return count;
    }


}