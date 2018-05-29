package com.kefang.autoditacte.entity.sysmanage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * 时间设置类
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * 系统设置——时间设置
 */
public class Time  implements Serializable {
    /**
     * id
     */
    private String id;
    /**
     *上半年开始时间
     */
    private String firstStartTime;
    /**
     *上半年结束时间
     */
    private String fistEndTime;
    /**
     *年度
     */
    private Integer year;
    /**
     *下半年开始时间
     */
    private String secondStartTime;
    /**
     *下半年结束时间
     */
    private String secondEndTime;
    /**
     *综合上半年结束时间
     */
    private String firstSynthesizeEnd;
    /**
     *综合下半年结束时间
     */
    private String secondSynthesizeEnd;

}
