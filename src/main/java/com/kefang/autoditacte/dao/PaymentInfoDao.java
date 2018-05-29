package com.kefang.autoditacte.dao;

import com.kefang.autoditacte.common.TailPage;
import com.kefang.autoditacte.entity.PaymentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface PaymentInfoDao {

    int deleteByPrimaryKey(String id);


    int insert(PaymentInfo record);


    int insertSelective(PaymentInfo record);


    PaymentInfo selectByPrimaryKey(String id);


    int updateByPrimaryKeySelective(PaymentInfo record);


    int updateByPrimaryKey(PaymentInfo record);
    //通过课程id，助学机构id查总数
    List<PaymentInfo> getPaymentInfoByPage(@Param("courseId") String courseId,@Param("stationId") String stationId,@Param("status") Integer status,@Param("page") TailPage page);
    //通过学生查总数
    List<PaymentInfo> getPeymentInfoByStudentId(@Param("studentId") String studentId,@Param("page") TailPage page);
    //通过学生查总数
    Integer getTotalItemsCountByStudentId(@Param("studentId") String studentId);
    //通过课程id，助学机构id查总数
    Integer getTotalItemsCount(@Param("courseId") String courseId,@Param("stationId") String stationId,@Param("status") Integer status);


}