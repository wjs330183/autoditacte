package com.kefang.autoditacte.param;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StationParam {
    private String id;
    private String name;
    /**
     * 编号
     */
    private String code;
    private Integer status;
    /**
     * 备注
     */
    private String note;
}
