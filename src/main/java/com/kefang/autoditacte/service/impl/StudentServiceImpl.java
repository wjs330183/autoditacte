package com.kefang.autoditacte.service.impl;

import com.kefang.autoditacte.dto.StudentDto;
import com.kefang.autoditacte.emuns.IDPrefixAuthority;
import com.kefang.autoditacte.entity.*;
import com.kefang.autoditacte.service.*;
import com.kefang.autoditacte.utils.SnowflakeIdWorkerUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.kefang.autoditacte.common.*;
import com.kefang.autoditacte.utils.CommonUtils;
import com.kefang.autoditacte.dao.StudentDao;
import com.kefang.autoditacte.param.StudentParam;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-26
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    private static Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Resource
    private StudentDao studentDao;

    @Resource
    private StudentDetailService studentDetailService;

    @Resource
    private SiteService siteService;

    @Resource
    private StationService stationService;

    @Resource
    private MajorService majorService;

    /**
     * 单个保存
     */
    @Override
    public JsonData saveStudent(StudentParam param) {
        if (CommonUtils.isAnyEmpty()) {
            return JsonData.fail("parameter is empty");
        }
        String id = null;
        try {
            Student student = Student.builder()
                    .id(SnowflakeIdWorkerUtils.idGenerator(IDPrefixAuthority.MACHINE_ID.getCode(), IDPrefixAuthority.STUDENT_DETAIL.getCode()))
                    .code(param.getCode())
                    .name(param.getName())
                    .password(param.getPassword())
                    .cardType(param.getCardType())
                    .cardId(param.getCardId())
                    .phone(param.getPhone())
                    .majorId(param.getMajorId())
                    .stationId(param.getStationId())
                    .siteId(param.getSiteId())
                    .byCard(param.getByCard())
                    .note(param.getNote())
                    .auditStatus(param.getAuditStatus())
                    .hide(param.getHide())
                    .status(param.getStatus())
                    .build();
            Date date = new Date();
            student.setCreateTime(date);
            student.setUpdateTime(date);
            studentDao.save(student);
            id = student.getId();
        } catch (Exception e) {
            logger.error("saveStudent error:{}", e.getMessage());
            return JsonData.fail("添加失败");
        }
        return JsonData.success(id, "添加成功");
    }


    /**
     * 根据id删除对象
     */
    @Override
    public JsonData deleteStudentById(String id) {
        if (CommonUtils.isEmpty(id)) {
            return JsonData.fail("id is empty");
        }
        int count = 0;
        try {
            count = studentDao.deleteById(id);
        } catch (Exception e) {
            logger.error("deleteStudentById error:{}", e.getMessage());
            return JsonData.fail("删除失败");
        }
        return JsonData.success(count, "删除成功");
    }


    /**
     * 更新对象
     */
    @Override
    public JsonData updateStudent(StudentParam param) {
        if (CommonUtils.isAnyEmpty()) {
            return JsonData.fail("parameter is empty");
        }
        int count = 0;
        try {
            Student student = Student.builder()
                    .id(param.getId())
                    .code(param.getCode())
                    .name(param.getName())
                    .password(param.getPassword())
                    .cardType(param.getCardType())
                    .cardId(param.getCardId())
                    .phone(param.getPhone())
                    .majorId(param.getMajorId())
                    .stationId(param.getStationId())
                    .siteId(param.getSiteId())
                    .byCard(param.getByCard())
                    .note(param.getNote())
                    .auditStatus(param.getAuditStatus())
                    .hide(param.getHide())
                    .status(param.getStatus())
                    .build();
            Date date = new Date();
            student.setUpdateTime(date);
            count = studentDao.update(student);
        } catch (Exception e) {
            logger.error("updateStudent error:{}", e.getMessage());
            return JsonData.fail("修改失败");
        }
        return JsonData.success(count, "修改成功");
    }


    /**
     * 分页模糊查询
     */
    @Override
    public JsonData getStudentsByPage(String name, TailPage page) {
        try {
//            Integer totalItemsCount = studentDao.getTotalItemsCount(name);
//            List<Student> studentList = studentDao.getStudentsByPage(name, page);
//            page.setItemsTotalCount(totalItemsCount);
//            page.setItems(studentList);

        } catch (Exception e) {
            logger.error("getStudent error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(page, "查询成功");
    }

    @Override
    public JsonData getStudents(String stationId, String status, String keyWord, TailPage page) {
        try {
            Integer totalItemsCount = studentDao.getTotalItemsCounts(stationId,status,keyWord);
            List<Student> studentList = studentDao.getStudents(null,status,keyWord, page);
            page.setItemsTotalCount(totalItemsCount);
            page.setItems(studentList);
        } catch (Exception e) {
            logger.error("getStudent error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(page, "查询成功");
    }

    @Override
    public JsonData getAllStudents(String stationId, String status, String keyWord, TailPage page) {
        try {
            List<StudentDto> studentDtos = new ArrayList<>();
            List<Student> studentList = studentDao.getStudents(stationId,status,keyWord, page);
            Integer totalItemsCount = studentDao.getTotalItemsCounts(stationId,status,keyWord);
            for (Student resultDatum : studentList) {
                String id = resultDatum.getId();
                StudentDetail studentDetail = studentDetailService.getStudentDetailsById(id);
                StudentDto studentDto = new StudentDto();
                Station station = stationService.getStationById(resultDatum.getStationId());
                if (station != null) {
                    studentDto.setStationName(station.getName());
                    studentDto.setSiteCode(station.getCode());
                }
                Site site = siteService.getSiteById(resultDatum.getSiteId());
                if (site != null) {
                    studentDto.setSiteName(site.getName());
                    studentDto.setSiteCode(site.getSiteCode());
                }
                Major major = majorService.getMajor(resultDatum.getMajorId());
                if (major != null) {
                    studentDto.setMajorCode(major.getCode());
                    studentDto.setMajorName(major.getName());
                }
                studentDto.setStudent(resultDatum);
                studentDto.setStudentDetail(studentDetail);
                studentDtos.add(studentDto);
            }
            page.setItemsTotalCount(totalItemsCount);
            page.setItems(studentDtos);
        } catch (Exception e) {
            logger.error("getStudent error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(page, "查询成功");
    }

    @Override
    public JsonData saveAllStudent(StudentParam param) {
        try {
            JsonData jsonData = saveStudent(param);
            String id = (String) jsonData.getResultData();
            JsonData jsonData1 = studentDetailService.saveStudentDetail(param, id);
        } catch (Exception e) {
            logger.error("getStudent error:{}", e.getMessage());
            return JsonData.fail("查询失败");
        }
        return JsonData.success(1, "查询成功");
    }


}