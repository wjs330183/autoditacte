package com.kefang.autoditacte.param;

import com.kefang.autoditacte.entity.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MajorParam{
    private String id;
    //专业代码
    private String code;
    //专业名称
    private String name;
    //  `note` varchar(255) DEFAULT NULL COMMENT '备注',
    private String note;
    //  `status` bit(1) DEFAULT NULL COMMENT '状态:radio',
    private Integer status;

    private List<String> courseIdList;

}
