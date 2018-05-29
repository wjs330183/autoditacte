package com.kefang.autoditacte.controller;
import com.kefang.autoditacte.common.JsonData;
import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.dto.MajorDto;
import com.kefang.autoditacte.entity.Major;
import com.kefang.autoditacte.param.MajorParam;
import com.kefang.autoditacte.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping
public class MajorController {
    @Autowired
    private MajorService majorService;
    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(MajorController.class);

    @RequestMapping(value = {"/baseInfo/1/major"},method = RequestMethod.POST)
    @ResponseBody
    public JsonData save( @RequestBody MajorParam param,HttpServletRequest request){
        String token=request.getParameter("token");
        return  majorService.saveMajor(param,token);
    }

    @RequestMapping(value = {"/baseInfo/1/editMajor"},method = RequestMethod.POST)
    @ResponseBody
    public JsonData update( @RequestBody MajorParam majorParam,HttpServletRequest request){
        String token=request.getParameter("token");
        return majorService.updateMajor(majorParam,token);
    }

    @RequestMapping(value = {"/baseInfo/1/delete"},method = RequestMethod.POST)
    @ResponseBody
    public JsonData delete(@RequestParam("id") String id,HttpServletRequest request){
        return majorService.deleteMajorById(id);
    }
    //通过id获取
    @RequestMapping(value = {"/baseInfo/1/major"},method = RequestMethod.GET)
    @ResponseBody
    public JsonData getById(@RequestParam("id") String id,HttpServletRequest request){
        return majorService.getMajorById(id);
    }
    //分页
    @RequestMapping(value = {"/baseInfo/1/majorsPage"},method = RequestMethod.GET)
    @ResponseBody
    public TailPage<MajorDto> getMajorsByPage(@RequestParam(value = "majorName",required = false) String majorName,TailPage<Major> page,HttpServletRequest request) {
        try {
            String token=request.getParameter("token");
            return majorService.getMajorsByPage(majorName, page,token);
        } catch (UnsupportedEncodingException e) {
            return new TailPage<MajorDto>();
        }
    }

}
