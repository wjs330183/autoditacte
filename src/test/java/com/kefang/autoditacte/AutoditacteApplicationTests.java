package com.kefang.autoditacte;

import com.kefang.autoditacte.dao.CourseDao;
import com.kefang.autoditacte.dao.CourseWareCourseExerciseCourseDao;
import com.kefang.autoditacte.entity.CourseWareCourseExerciseCourse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AutoditacteApplicationTests {
	@Autowired
	private CourseWareCourseExerciseCourseDao courseWareCourseExerciseCourseDao;

	@Test
	public void contextLoads() {
		CourseWareCourseExerciseCourse courseWareCourseExerciseCourse=CourseWareCourseExerciseCourse.builder().courseId("1023f938-b523-4ef0-930a-6f6b6d9689ee")
				.exerciseCourseId("0180dc04-faa6-44f2-890c-d6b06d51b6db").wareCourseId("42c76bfa-a8c9-4383-b21c-91910958a566").build();

	}

}
