package com.kefang.autoditacte.service;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.dto.MajorDto;
import com.kefang.autoditacte.entity.Course;
import com.kefang.autoditacte.entity.Major;
import com.kefang.autoditacte.exception.ParamException;
import com.kefang.autoditacte.param.CourseParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
* 描述： 服务实现层接口
* @author Json
* @date 2018-05-18
*/
public interface CourseService {


    /**
    * 单个保存
    * @param name 课程名称
	* @param code 课程封面:img
	* @param note 课程简介
	* @param status 状态:radio
	
    * @param operator 操作者编号
    */
     String saveCourse(CourseParam param) throws Exception;

    /**
    * 批量保存
    * @param courseJson 对象集合 Json 字符串
    * @param operator 操作者编号
    */
    //JsonData<Integer> saveCourseBatch(String courseJson);

    /**
    * 根据id获取对象
    * @param id ID
    */
    Course getCourseById (String id) throws ParamException;

    /**
    * 根据id删除对象
    * @param id ID
    */
    Integer deleteCourseById(String id) throws Exception;



    /**
    * 更新对象
    * @param id ID
	* @param name 课程名称
	* @param code 课程封面:img
	* @param note 课程简介
	* @param status 状态:radio
	
    * @param operator 操作者编号
    */
    Integer updateCourse(CourseParam param) throws Exception;


    /**
    *查询Course
    */
    //JsonData getCourses ();
    TailPage<Course> getCourseDtosByPage(String courseName, TailPage<Course> page) throws ParamException;

    TailPage<Course> getCoursesByPage(String courseName, TailPage<Course> page) throws UnsupportedEncodingException, ParamException;
    //TailPage<Course> getCourseWaresByPage(String courseName, TailPage<Course> page) throws UnsupportedEncodingException;


    Integer batchImport(InputStream is) throws IOException, ParamException;

    //JsonData getExercises(String id);



}