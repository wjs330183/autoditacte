package com.kefang.autoditacte;

import com.alibaba.fastjson.JSONObject;
import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.service.StudentNoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteTest {
    @Resource
    private StudentNoteService studentNoteService;

    @Test
    public void getAllTest() {
        TailPage page = new TailPage();
        ((TailPage) page).setPageNum(1);
        ((TailPage) page).setPageSize(10);
        JsonData studentNotesByPage = studentNoteService.getStudentNotesByPage(null, page);
        System.out.println(studentNotesByPage.getResultMsg()+ JSONObject.toJSON(studentNotesByPage));
    }
}
