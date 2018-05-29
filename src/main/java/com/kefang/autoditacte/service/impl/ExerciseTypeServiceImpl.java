package com.kefang.autoditacte.service.impl;

import com.kefang.autoditacte.emuns.IDPrefixAuthority;
import com.kefang.autoditacte.utils.SnowflakeIdWorkerUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.utils.CommonUtils;
import com.kefang.autoditacte.service.ExerciseTypeService;
import com.kefang.autoditacte.dao.ExerciseTypeDao;
import com.kefang.autoditacte.entity.ExerciseType;
import com.kefang.autoditacte.param.ExerciseTypeParam;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;

import com.kefang.autoditacte.service.ExerciseTypeService;

/**
* 描述：
* @author Json
* @date 2018-05-23
*/
@Service("exerciseTypeService")
public class ExerciseTypeServiceImpl implements ExerciseTypeService {

    private static Logger logger = LoggerFactory.getLogger(ExerciseTypeServiceImpl.class);

    @Resource
    private ExerciseTypeDao exerciseTypeDao;

    /**
    * 单个保存
    */
    @Override
    public JsonData saveExerciseType(ExerciseTypeParam param){
        if(CommonUtils.isAnyEmpty()){
        return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try{
        ExerciseType exerciseType = ExerciseType.builder()
                    .id(SnowflakeIdWorkerUtils.idGenerator(IDPrefixAuthority.MACHINE_ID.getCode(),IDPrefixAuthority.EXERCISE_TYPE.getCode()))
                    .exerciseName(param.getExerciseName())
                    .exerciseKind(param.getExerciseKind())
                    .remark(param.getRemark())
                    .status(param.getStatus())
        .build();
            Date date= new Date();
            exerciseType.setCreateTime(date);
            exerciseType.setUpdateTime(date);
            count = exerciseTypeDao.save(exerciseType);
        } catch (Exception e){
            logger.error("saveExerciseType error:{}", e.getMessage());
            return JsonData.fail("添加失败");
        }
        return JsonData.success(count,"添加成功");
    }

//
//    /**
//    * 批量保存
//    */
//    @Override
//    JsonData saveExerciseTypeBatch (String exerciseTypeJson){
//        if(CommonUtils.isEmpty(exerciseTypeJson)){
//            result.setCode("1");
//            result.setCode("1");
//            return result;
//        }
//        try{
//            List<ExerciseType> exerciseTypeList = CommonUtils.getListByJson(exerciseTypeJson, ExerciseType.class);
//
//            if (CommonUtils.isEmpty(exerciseTypeList)) {
//                result.setCode("1");
//                result.setMessage("1");
//                return result;
//            }
//
//            // TODO : 前置代码
//            exerciseTypeDao.saveBatch(exerciseTypeList);
//            result.setData(True);
//
//            // TODO : 后置代码
//        } catch (Exception e){
//            logger.error("saveExerciseTypeBatch error:{}", e.getMessage());
//            result.setCode("1");
//            result.setMessage("1");
//        }
//        return result;
//    }

    /**
    * 根据id获取对象
    */
    @Override
    public JsonData getExerciseTypeById (String id){
        if(CommonUtils.isEmpty(id)){
            return JsonData.fail("id is empty");
        }
        ExerciseType exerciseType = null;
        try{
            exerciseType = exerciseTypeDao.getById(id);
        } catch (Exception e){
            logger.error("saveExerciseTypeById error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(exerciseType,"查询成功");
    }

    /**
    * 根据id删除对象
    */
    @Override
    public JsonData deleteExerciseTypeById(String id){
        if(CommonUtils.isEmpty(id)){
            return JsonData.fail("id is empty");
        }
        int count = 0;
        try{
        count = exerciseTypeDao.deleteById(id);
        } catch (Exception e){
            logger.error("deleteExerciseTypeById error:{}", e.getMessage());
            return JsonData.fail("删除失败");
        }
        return JsonData.success(count,"删除成功");
    }



    /**
    * 更新对象
    */
    @Override
    public JsonData updateExerciseType (ExerciseTypeParam param){
        if(CommonUtils.isAnyEmpty()){
        return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try{
            ExerciseType exerciseType = ExerciseType.builder()
                    .id(param.getId())
                    .exerciseName(param.getExerciseName())
                    .exerciseKind(param.getExerciseKind())
                    .remark(param.getRemark())
                    .status(param.getStatus())
            .build();
            Date date = new Date();
            exerciseType.setCreateTime(date);
            exerciseType.setUpdateTime(date);
            count = exerciseTypeDao.update(exerciseType);
        } catch (Exception e){
            logger.error("updateExerciseType error:{}", e.getMessage());
            return JsonData.fail("修改失败");
        }
        return JsonData.success(count,"修改成功");
    }



    /**
    * 查询所有
    */
    @Override
    public JsonData getExerciseType (Integer page, Integer length){
        List<ExerciseType> exerciseTypeList = null;
        try{
            Integer start = (page - 1) * length;
            exerciseTypeList = exerciseTypeDao.getExerciseType(start, length);
        } catch (Exception e){
            logger.error("getExerciseType error:{}", e.getMessage());
            return JsonData.fail("修改失败");
        }
        return JsonData.success(exerciseTypeList,"查询成功");
    }

}