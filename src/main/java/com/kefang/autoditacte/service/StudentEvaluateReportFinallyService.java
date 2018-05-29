package com.kefang.autoditacte.service;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.entity.StudentEvaluateReportFinally;
import com.kefang.autoditacte.param.StudentEvaluateReportFinallyParam;

import java.util.*;

import com.kefang.autoditacte.common.*;

/**
 * 描述： 服务实现层接口
 *
 * @author Json
 * @date 2018-05-28
 */
public interface StudentEvaluateReportFinallyService {


	/**
	 * 单个保存
	 *
	 * @param studentEvaluateReportId
	 * @param courseScore             课程学习成绩
	 * @param workScore               平时作业成绩
	 * @param loginScore              学习表现成绩（网络）
	 * @param examScore               综合测验成绩
	 * @param operator                操作者编号
	 */
	JsonData saveStudentEvaluateReportFinally(StudentEvaluateReportFinallyParam param);

	/**
	 * 通过id删除StudentEvaluateReportFinally
	 */
	JsonData deleteStudentEvaluateReportFinallyById(String id);


	/**
	 * 更新对象
	 *
	 * @param id
	 * @param studentEvaluateReportId
	 * @param courseScore             课程学习成绩
	 * @param workScore               平时作业成绩
	 * @param loginScore              学习表现成绩（网络）
	 * @param examScore               综合测验成绩
	 * @param operator                操作者编号
	 */
	JsonData updateStudentEvaluateReportFinally(StudentEvaluateReportFinallyParam param);


	/**
	 * 分页模糊查询StudentEvaluateReportFinally
	 */
	JsonData getStudentEvaluateReportFinallysByPage(String name, TailPage<StudentEvaluateReportFinally> page);

	JsonData getStudentEvaluateReportFinallys(String startTime, String endTime, String courseId, String stationId, String status, String keyWord, TailPage page);


}