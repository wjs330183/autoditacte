package com.kefang.autoditacte.service;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.entity.StudentEvaluateReport;
import com.kefang.autoditacte.param.StudentEvaluateReportParam;
import java.util.*;
import com.kefang.autoditacte.common.*;

/**
* 描述： 服务实现层接口
* @author Json
* @date 2018-05-28
*/
public interface StudentEvaluateReportService {


    /**
    * 单个保存
    * @param studentId 
	* @param courseId 
	* @param commonScore 平时成绩（函授站评分）
	* @param loginTimes 登陆次数（课程点击次数）
	* @param noteTimes 提交笔记次数
	* @param workTimes 提交作业次数
	* @param examScore 综合测验成绩
	
    * @param operator 操作者编号
    */
     JsonData saveStudentEvaluateReport(StudentEvaluateReportParam param);

    /**
    * 通过id删除StudentEvaluateReport
    */
     JsonData deleteStudentEvaluateReportById(String id);


    /**
    * 更新对象
    * @param id 
	* @param studentId 
	* @param courseId 
	* @param commonScore 平时成绩（函授站评分）
	* @param loginTimes 登陆次数（课程点击次数）
	* @param noteTimes 提交笔记次数
	* @param workTimes 提交作业次数
	* @param examScore 综合测验成绩
	
    * @param operator 操作者编号
    */
    JsonData updateStudentEvaluateReport(StudentEvaluateReportParam param);


    /**
    * 分页模糊查询StudentEvaluateReport
    */
    JsonData getStudentEvaluateReportsByPage(String name, TailPage<StudentEvaluateReport> page);

}