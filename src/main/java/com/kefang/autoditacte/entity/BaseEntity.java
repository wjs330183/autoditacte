package com.kefang.autoditacte.entity;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
    private Date createTime;
    private Date updateTime;
}
