package com.kefang.autoditacte.entity.sysmanage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统管理——友情链接类
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Link implements Serializable {

    /**
     * 链接id
     */
    private String  id;
    /**
     * 链接名称
     */
    private String linkName;
    /**
     * 链接url
     */
    private String linkUrl;
    /**
     * logo地址
     */
    private String logoUrl;
    /**
     *学校Id
     */
    private String siteId;
    /**
     *创建时间
     */
    private  Date createTime;
    /**
     *更新时间
     */
    private Date updateTime;
    /**
     *备注
     */
    private String note;
    /**
     * 状态
     */
    private int status;
}
