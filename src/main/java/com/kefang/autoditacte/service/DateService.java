package com.kefang.autoditacte.service;

import java.sql.Date;
import java.util.List;

public interface DateService {

    /**
     * 获取某一年到当前时间的年份
     */
    List<String> getYearToNow(String fromYear);

}
