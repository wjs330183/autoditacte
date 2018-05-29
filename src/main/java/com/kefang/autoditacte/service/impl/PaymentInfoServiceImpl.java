package com.kefang.autoditacte.service.impl;

        import com.kefang.autoditacte.common.TailPage;
        import com.kefang.autoditacte.dao.CourseDao;
        import com.kefang.autoditacte.dao.PaymentInfoDao;
        import com.kefang.autoditacte.dao.StationDao;
        import com.kefang.autoditacte.dao.StudentDao;
        import com.kefang.autoditacte.dto.CourseDto;
        import com.kefang.autoditacte.dto.PaymentInfoDto;
        import com.kefang.autoditacte.entity.Course;
        import com.kefang.autoditacte.entity.PaymentInfo;
        import com.kefang.autoditacte.entity.Station;
        import com.kefang.autoditacte.entity.Student;
        import com.kefang.autoditacte.service.PaymentInfoService;
        import com.kefang.autoditacte.service.StationService;
        import com.kefang.autoditacte.service.StudentService;
        import org.apache.ibatis.annotations.Param;
        import org.springframework.stereotype.Service;
        import org.springframework.web.bind.annotation.RequestParam;

        import javax.annotation.Resource;
        import java.util.ArrayList;
        import java.util.List;
@Service("paymentInfoService")
public class PaymentInfoServiceImpl implements PaymentInfoService {
    @Resource
    private PaymentInfoDao paymentInfoDao;
    @Resource
    private StationDao stationDao;
    @Resource
    private StudentDao studentDao;
    @Resource
    private CourseDao courseDao;
    @Override
    public TailPage<PaymentInfoDto> getPaymentInfoByPage(@RequestParam(value = "courseId",required = false) String courseId, @RequestParam(value = "stationId",required = false)String stationId, @RequestParam(value = "status",required = false)Integer status, @Param("keyWord") String keyWord, TailPage page) {
       if(keyWord!=null) {
           TailPage tailPage = (TailPage) studentDao.getStudents(null, null, keyWord, page);
           List<Student> studentList = page.getItems();
           if (studentList != null) {
               Student student= studentList.get(0);
               List<PaymentInfo> paymentInfoList = paymentInfoDao.getPeymentInfoByStudentId(student.getId(), page);
               Integer count = paymentInfoDao.getTotalItemsCountByStudentId(student.getId());
               page.setItemsTotalCount(count);
               List<PaymentInfoDto> paymentInfoDtoLsit=null;
               for(PaymentInfo paymentInfo:paymentInfoList){
                   PaymentInfoDto paymentInfoDto=PaymentInfoDto.adapt(paymentInfo);
                   Station station= stationDao.getById(stationId);
                   paymentInfoDto.setStation(station);
                   paymentInfoDto.setStudent(student);
                   paymentInfoDtoLsit.add(paymentInfoDto);
               }
               page.setItems(paymentInfoDtoLsit);
               return page;
           }
       }
       Integer count=paymentInfoDao.getTotalItemsCount(courseId,stationId,status);
       List<PaymentInfo> paymentInfoList=paymentInfoDao.getPaymentInfoByPage(courseId,stationId,status,page);
       page.setItemsTotalCount(count);
       List<PaymentInfoDto> paymentInfoDtoList=new ArrayList<>();
       for(PaymentInfo paymentInfo:paymentInfoList){
           PaymentInfoDto paymentInfoDto=PaymentInfoDto.adapt(paymentInfo);
           Student student=studentDao.getStudentById(paymentInfo.getStudentId());
           Station station= stationDao.getById(student.getStationId());
           Course course=courseDao.getById(paymentInfo.getCourseId());
           paymentInfoDto.setStudent(student);
           paymentInfoDto.setStation(station);
           paymentInfoDto.setCourse(course);
           paymentInfoDtoList.add(paymentInfoDto);
       }
       page.setItems(paymentInfoDtoList);
       return page;
    }

}
