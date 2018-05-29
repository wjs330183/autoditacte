package com.kefang.autoditacte.service;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.entity.Exercise;
import com.kefang.autoditacte.param.ExerciseParam;

/**
 * 描述： 服务实现层接口
 * @author Json
 * @date 2018-05-22
 */
public interface ExerciseService {


	/**
	 * 单个保存
	 * @param typeId 习题类型
	 * @param exerciseId 习题编码
	 * @param name 题目
	 * @param exerciseCourse 站点Id
	 * @param remark 备注
	 * @param status 状态:radio

	 * @param operator 操作者编号
	 */
	JsonData saveExercise(ExerciseParam param);

	/**
	 * 批量保存
	 * @param exerciseJson 对象集合 Json 字符串
	 * @param operator 操作者编号
	 */
//	JsonData saveExerciseBatch(String exerciseJson);

	/**
	 * 根据id获取对象
	 * @param id ID
	 */
	JsonData getExerciseById (String id);

	/**
	 * 根据id删除对象
	 * @param id ID
	 */
	JsonData deleteExerciseById(String id);



	/**
	 * 更新对象
	 * @param id ID
	 * @param typeId 习题类型
	 * @param exerciseId 习题编码
	 * @param name 题目
	 * @param exerciseCourse 站点Id
	 * @param remark 备注
	 * @param status 状态:radio

	 * @param operator 操作者编号
	 */
	JsonData updateExercise(ExerciseParam param);


	/**
	 *查询Exercise
	 */
	JsonData getExercise (String courseName, TailPage<Exercise> pages);

	/**
	 * 通过id查询习题
	 */
	JsonData getExerciseById(String id, TailPage<Exercise> pages);

}