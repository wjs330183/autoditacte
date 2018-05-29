package com.kefang.autoditacte;

import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.param.ExerciseParam;
import com.kefang.autoditacte.service.ExerciseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExerciseTest {
    @Resource
    private ExerciseService exerciseService;

    @Test
    public void create(){
        ExerciseParam exerciseParam = new ExerciseParam();
        exerciseParam.setAnswer("12");
        exerciseParam.setCourseId("ads");
        exerciseParam.setExerciseCourse("asdas");
        exerciseParam.setExerciseId("sadsa");
        exerciseParam.setId("asd");
        exerciseParam.setName("sad");
        exerciseParam.setRemark("das");
        exerciseParam.setStatus(1);
        exerciseParam.setTypeId("asd");
        JsonData jsonData = exerciseService.saveExercise(exerciseParam);
        System.out.println(jsonData.getResultMsg() + jsonData.getResultData());
    }
}
