package com.kefang.autoditacte.entity.sysmanage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/*
 * 系统管理——我的信息类
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Admin implements Serializable {

    private static final long serialVersionUID = -6718233716613601135L;
    /**
     * 用户id
     */
    private String id;
    /**
     * 用户角色
     */
    private String roleId;
    /**
     * 所属教学站
     */
    private String stationId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户密码
     */
    private String passWord;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户图像 url
     */
    private String photo;
    /**
     * 用户电话
     */
    private String phone;
    /**
     * 用户学校id
     */
    private String siteId;
    /**
     * 用户备注
     */
    private String note;
    /**
     * 用户状态
     */
    private boolean state;
    /**
     * 用户创建时间
     */
    private Date createTime;
    /**
     * 用户结束时间
     */
    private Date updateTime;
    /**
     * 删除状态
     */
    private boolean isDel;
}
