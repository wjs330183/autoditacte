package com.kefang.autoditacte.service.impl;
import com.kefang.autoditacte.entity.sysmanage.Admin;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.dao.CourseDao;
import com.kefang.autoditacte.dto.MajorDto;
import com.kefang.autoditacte.entity.Course;
import com.kefang.autoditacte.service.MajorCourseService;

import org.apache.log4j.Logger;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.utils.CommonUtils;
import com.kefang.autoditacte.service.MajorService;
import com.kefang.autoditacte.dao.MajorDao;
import com.kefang.autoditacte.entity.Major;
import com.kefang.autoditacte.param.MajorParam;
import java.io.UnsupportedEncodingException;
import java.util.*;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
* 描述：
* @author Json
* @date 2018-05-18
*/
@Service("majorService")
public class MajorServiceImpl implements MajorService {

    private static Logger logger = Logger.getLogger(MajorServiceImpl.class);
    @Resource
    private MajorDao majorDao;
    @Resource
    private MajorCourseService majorCourseService;
    @Resource
    private CourseDao courseDao;
    @Resource
    private RedisTemplate redisTemplate;

    /**
    * 单个保存
    */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public JsonData saveMajor( MajorParam param,String token){
            if(CommonUtils.isAnyEmpty(param.getCode(),param.getName())){
                return JsonData.fail("parameter is empty");
        }
       /* Admin admin=null;
        if(redisTemplate.hasKey(token)){
                admin= (Admin) redisTemplate.opsForValue().get(token);
        }
        if(majorDao.getByName(param.getName(),admin.getSiteId())!=null||majorDao.getByCode(param.getCode(),admin.getSiteId())!=null){
                return JsonData.fail("专业已存在");
        }*/
        String siteId="1030";

        String id = UUID.randomUUID().toString();
        try{
            Major major = Major.builder()
                    .id(id)
                    .code(param.getCode())
                    .name(param.getName())
                    .note(param.getNote())
                    //.siteId(admin.getSiteId())
                    .siteId(siteId)
                    .status(param.getStatus()).build();
            Date date=new Date();
            major.setUpdateTime(date);
            major.setCreateTime(date);
            majorDao.save(major);
            List<String> courseIdList=param.getCourseIdList();
            majorCourseService.batchSave(id,courseIdList);
            return JsonData.success(id,"添加成功");
        } catch (Exception e){
            logger.error("saveMajor error:{"+e.getMessage()+"}");
            return JsonData.fail("添加失败");
        }

    }


    /**
    * 批量保存

    @Override
    DataResult<Boolean> saveMajorBatch (String majorJson){
        if(CommonUtils.isEmpty(majorJson)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            List<Major> majorList = CommonUtils.getListByJson(majorJson, Major.class);

            if (CommonUtils.isEmpty(majorList)) {
                result.setCode("1");
                result.setMessage("1");
                return result;
            }

            // TODO : 前置代码
            majorDao.saveBatch(majorList);
            result.setData(True);

            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveMajorBatch error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
        }
        return result;
    }*/

    /**
    * 根据id获取对象
    */
    @Override
    public JsonData getMajorById (String id){
        if(CommonUtils.isEmpty(id)){
            return JsonData.fail("id is empty");
        }
        try{
            Major major = majorDao.getById(id);
            MajorDto majorDto=MajorDto.adapt(major);
            List<String> courseIdList=majorCourseService.getCourseIdListByMajorId(id);
            List<Course> courseList=new ArrayList<>();
            majorDto.setCourseIdList(courseIdList);
            return JsonData.success(majorDto,"查询成功");
        } catch (Exception e){
            logger.error("getMajorById error:{"+e.getMessage()+"}");
            return JsonData.fail("查询失败");
        }
    }

    /**
    * 根据id删除对象
    */
    @Override
    public JsonData deleteMajorById(String majorId){
        if(CommonUtils.isEmpty(majorId)){
            return JsonData.fail("id is empty");
        }
        try{
            majorDao.deleteById(majorId);
            majorCourseService.delete(majorId);
        } catch (Exception e){
            logger.error("deleteMajorById error:{"+e.getMessage()+"}");
            return JsonData.fail("删除失败");
        }
        return JsonData.success("删除成功");
    }



    /**
    * 更新对象
    */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public JsonData updateMajor (MajorParam param,String token){
        if(CommonUtils.isAnyEmpty(param.getCode(),param.getName())){
        return JsonData.fail("parameter is empty");
        }
       /* Admin admin=null;
        if(redisTemplate.hasKey(token)){
            admin= (Admin) redisTemplate.opsForValue().get(token);
        }*/
        try{
            String siteId="1030";
            Major major = Major.builder()
                    .id(param.getId())
                    .code(param.getCode())
                    .name(param.getName())
                    .note(param.getNote())
                    //.siteId(admin.getSiteId())
                    .siteId(siteId)
                    .status(param.getStatus()).build();
            Date date = new Date();
            major.setUpdateTime(date);
            majorDao.update(major);
            List<String> courseIdList=param.getCourseIdList();
            majorCourseService.update(major.getId(),courseIdList);
        } catch (Exception e){
            logger.error("updateMajor error:{"+e.getMessage()+"}");
            return JsonData.fail("修改失败");
        }
        return JsonData.success("修改成功");
    }

    /**
    * 查询所有
    */
    @Override
    public JsonData getMajors(){
        try{
            List<Major> majorList = new ArrayList<>();
            majorList = majorDao.getMajors();
            List<MajorDto> majorDtoList=new ArrayList<>();
            for(Major major:majorList){
                List courseIdList=new ArrayList();
                courseIdList=majorCourseService.getCourseIdListByMajorId(major.getId());
                MajorDto majorDto=MajorDto.adapt(major);
                majorDto.setCourseIdList(courseIdList);
                majorDtoList.add(majorDto);
            }
            return JsonData.success(majorDtoList,"查询成功");
        } catch (Exception e){
            logger.error("getMajor error:{"+e.getMessage()+"}");
            return JsonData.fail("修改失败");
        }
    }
    /**
     * 分页
     * */
    public TailPage<MajorDto> getMajorsByPage(String majorName,TailPage page,String token) throws UnsupportedEncodingException {
       /* Admin admin=null;
        if(redisTemplate.hasKey(token)){
            admin= (Admin) redisTemplate.opsForValue().get(token);
        }*/
        String siteId="1030";
        Integer totalItemsCount=majorDao.getTotalItemsCount(majorName,siteId);
        List<Major> majorList=majorDao.getMajorsByPage(majorName,page,siteId);
        List<MajorDto> majorDtoList=new ArrayList<>();
        if(!CommonUtils.isEmpty(majorList)) {
            for (Major major : majorList) {
                MajorDto majorDto=MajorDto.adapt(major);
                List<String> courseIdList=majorCourseService.getCourseIdListByMajorId(major.getId());
                List<Course> courseList=new ArrayList<>();
                majorDto.setCourseIdList(courseIdList);
                majorDtoList.add(majorDto);
            }
        }
        page.setItemsTotalCount(totalItemsCount);
        page.setItems(majorDtoList);
        return page;
    }

    @Override
    public Major getMajor(String id) {
        return majorDao.getById(id);
    }
}
