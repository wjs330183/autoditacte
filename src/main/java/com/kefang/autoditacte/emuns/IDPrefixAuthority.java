package com.kefang.autoditacte.emuns;


/**
 * ID 前缀
 *
 * @auther wangjs
 * @date 2018-03-20
 */
public enum IDPrefixAuthority {


    MACHINE_ID("1", "机器 ID"),
    WARE_COURSE("011", "课程课件表"),
    COURSE_WARE("012", "课件课程表"),
    EXERCISE_COURSE("013", "习题课程表"),
    EXERCISE_TYPE("014", "习题类型"),
    COURSE_EXERCISE("015", "课程习题"),
    COURSE_MATCHING("016", "课程匹配"),
    SCHOOL_MANAGEMENT("017", "院校管理"),
    STUDENT_DETAIL("019", "学生详细信息");


    IDPrefixAuthority(String code, String memo) {
        this.code = code;
        this.memo = memo;
    }


    public String getCode() {
        return code;
    }

    public String getMemo() {
        return memo;
    }

    private String code;

    private String memo;
}
