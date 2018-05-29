package com.kefang.autoditacte.service;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.entity.StudentNote;
import com.kefang.autoditacte.param.StudentNoteParam;
import java.util.*;
import com.kefang.autoditacte.common.*;

/**
* 描述： 服务实现层接口
* @author Json
* @date 2018-05-28
*/
public interface StudentNoteService {


    /**
    * 单个保存
    * @param courseId 课程Id
	* @param studentId 学生id
	* @param wareId 课件Id
	* @param title 标记标题
	* @param context 笔记内容
	* @param showStatus 前端显示状态 1 显示 0 不显示
	
    * @param operator 操作者编号
    */
     JsonData saveStudentNote(StudentNoteParam param);

    /**
    * 通过id删除StudentNote
    */
     JsonData deleteStudentNoteById(String id);


    /**
    * 更新对象
    * @param id 
	* @param courseId 课程Id
	* @param studentId 学生id
	* @param wareId 课件Id
	* @param title 标记标题
	* @param context 笔记内容
	* @param showStatus 前端显示状态 1 显示 0 不显示
	
    * @param operator 操作者编号
    */
    JsonData updateStudentNote(StudentNoteParam param);


    /**
    * 分页模糊查询StudentNote
    */
    JsonData getStudentNotesByPage(String courseId, TailPage<StudentNote> page);

}