package com.kefang.autoditacte.controller;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;

import com.kefang.autoditacte.entity.Course;

import com.kefang.autoditacte.exception.ParamException;
import com.kefang.autoditacte.param.CourseParam;
import com.kefang.autoditacte.service.CourseService;


import com.kefang.autoditacte.service.CourseWareCourseExerciseCourseService;
import com.kefang.autoditacte.service.ExerciseService;
import com.kefang.autoditacte.service.WareService;
import com.kefang.autoditacte.utils.CommonUtils;
import com.kefang.autoditacte.utils.ExcelFileUtils;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseWareCourseExerciseCourseService courseWareCourseExerciseCourseService;
    @Autowired
    private WareService wareService;
    @Autowired
    private ExerciseService exerciseService;
    private Logger logger = Logger.getLogger(CourseController.class);

    //添加
    @RequestMapping(value = {"/resourceManagement/6/save"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData save(@RequestBody CourseParam param,HttpServletRequest request) {
        try {
             courseService.saveCourse(param);
             return JsonData.success("添加成功");
        }catch (Exception e){
            logger.error(e.getMessage());
            return JsonData.fail(e.getMessage());
        }
    }

    //编辑
    @RequestMapping(value = {"/resourceManagement/6/update"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData update(@RequestBody CourseParam courseParam,HttpServletRequest request) {
        try {
            courseService.updateCourse(courseParam);
            return JsonData.success("编辑成功");
        }catch (Exception e){
            logger.error(e.getMessage());
            return JsonData.fail(e.getMessage());
        }
    }

    //删除
    @RequestMapping(value = {"/resourceManagement/6/delete"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData delete(@RequestParam("id") String id,HttpServletRequest request) {
        try {
             courseService.deleteCourseById(id);
             return JsonData.success("删除成功");
        }catch (Exception e){
            logger.error(e.getMessage());
            return JsonData.fail(e.getMessage());
        }
    }

    /*
    @RequestMapping(value = {"/baseInfo/2/courses","/resourceManagement/6/courses"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getAll(HttpServletRequest request) {
        return courseService.getCourses();
    }
    */


     @RequestMapping(value = {"/baseInfo/2/coursesPage"}, method = RequestMethod.GET)
    @ResponseBody
    public JsonData getCoursesByPage(@RequestParam(value = "courseName", required = false) String courseName, TailPage<Course> page,HttpServletRequest request) {
        try {
            page=courseService.getCoursesByPage(courseName, page);
            return JsonData.success(page,"查询成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return JsonData.fail("查询失败");
        }

    }
 /*
    @RequestMapping(value = {"/baseInfo/2/courseWaresPage","/resourceManagement/6/courseWaresPage"}, method = RequestMethod.GET)
    @ResponseBody
    public TailPage<Course> getCourseWaresByPage(@RequestParam(value = "courseName", required = false) String courseName, TailPage<Course> page) {
        try {
            return courseService.getCoursesByPage(courseName, page);
        } catch (UnsupportedEncodingException e) {
            return null;
        }

    }
    */


    @RequestMapping(value = {"/resourceManagement/6/download"}, method = RequestMethod.GET)
    public ResponseEntity<byte[]> downloadTemplate(HttpServletRequest request) throws Exception {
        String path = CommonUtils.FILE_PATH;
        String fileName = "template.xls";
        File file = new File(path + File.separator + fileName);
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名，解决中文名称乱码问题
        String downloadFileName = new String(fileName.getBytes("UTF-8"));
        //通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFileName);
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/resourceManagement/6/upload"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonData upload(@RequestParam(value = "excelFile") MultipartFile excelFile) {
        int dotPos=excelFile.getOriginalFilename().lastIndexOf(".");
        if(dotPos<0){
            return  JsonData.fail("文件格式不符");
        }
        String fileExt=excelFile.getOriginalFilename().substring(dotPos+1).toLowerCase();
        if(!ExcelFileUtils.isExcl(fileExt)){
            return  JsonData.fail("文件格式不符, 请直接下载填写模板");
        }
        try {
            InputStream is=excelFile.getInputStream();
            courseService.batchImport(is);
            return JsonData.success("上传成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return JsonData.fail(e.getMessage());
        }
    }
    //分页
    @RequestMapping(value = {"/resourceManagement/6/coursesPage"},method = RequestMethod.GET)
    @ResponseBody
    public JsonData getByPage(@RequestParam(value = "courseName",required = false) String courseName, TailPage page){
        try{
            page=courseService.getCourseDtosByPage(courseName,page);
            return JsonData.success(page,"查询成功");
        }catch (Exception e){
            logger.error(e.getMessage());
            return JsonData.fail(e.getMessage());
        }
    }
    //得到课程课件
    @RequestMapping(value = {"/resourceManagement/6/getCourseWareByPage"},method = RequestMethod.GET)
    @ResponseBody
    public JsonData getCourseWareByCourseId(@RequestParam("courseId") String courseId, TailPage page){
        String wareCourseId= null;
        try {
            wareCourseId = courseWareCourseExerciseCourseService.getWareCourseIdByCourseId(courseId);
        } catch (ParamException e) {
           return JsonData.fail(e.getMessage());
        }
        return   wareService.getWareById(wareCourseId,page);
    }
    //得到课程练习
    @RequestMapping(value = {"/resourceManagement/6/getCourseExerciseByPage"},method = RequestMethod.GET)
    @ResponseBody
    public JsonData getCourseExerciseByCourseId(@RequestParam("courseId") String courseId,TailPage page){
        String exerciseCourseId=null;
        try {
            exerciseCourseId=courseWareCourseExerciseCourseService.getExerciseCourseIdByCourseId(courseId);
        } catch (ParamException e) {
            return JsonData.fail(e.getMessage());
        }
        return  exerciseService.getExerciseByExerciseCourseId(exerciseCourseId,page);
    }



}
