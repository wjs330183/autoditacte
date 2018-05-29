package com.kefang.autoditacte.service;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.dto.MajorDto;
import com.kefang.autoditacte.entity.Major;
import com.kefang.autoditacte.param.MajorParam;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
* 描述： 服务实现层接口
* @author Json
* @date 2018-05-18
*/
public interface MajorService {


    /**
    * 单个保存
    * @param code 专业代码
	* @param name 专业名称
	* @param note 备注
	* @param status 状态:radio
    * @param operator 操作者编号
    */
     JsonData saveMajor(MajorParam param,String token);

    /**
    * 批量保存
    * @param majorJson 对象集合 Json 字符串
    * @param operator 操作者编号
    */
    //JsonData  saveMajorBatch(String majorJson);

    /**
    * 根据id获取对象
    * @param id ID
    */
    JsonData getMajorById (String id);

    /**
    * 根据id删除对象
    * @param id ID
    */
    JsonData deleteMajorById(String id);



    /**
    * 更新对象
    * @param id ID
	* @param code 专业代码
	* @param name 专业名称
	* @param note 备注
	* @param status 状态:radio
	
    * @param operator 操作者编号
    */
    JsonData updateMajor(MajorParam param,String token);

    /**
    *查询Major
    */
    JsonData getMajors();

    TailPage<MajorDto> getMajorsByPage(String majorName, TailPage page,String token) throws UnsupportedEncodingException;

    Major getMajor(String id);


}