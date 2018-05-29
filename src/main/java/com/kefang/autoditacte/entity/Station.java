package com.kefang.autoditacte.entity;

import lombok.*;

import java.util.Date;

/**
 * 助学机构
 * @author tanhao
 * @date 2018-5-21
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Station extends BaseEntity {
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
