package com.kefang.autoditacte.entity.sysmanage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * 学习设置
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
/**
 * 系统管理——学习设置
 */
public class Score implements Serializable {
    /**
     *id
     */
    private String id;
    /**
     *平时成绩满分
     */
    private Float commonGrade;
    /**
     *学习笔记满分
     */
    private Float noteGrade;
    /**
     *单次笔记得分
     */
    private Float onceNoteGrade;
    /**
     *登录满分
     */
    private Float loginGrade;
    /**
     *作业满分
     */
    private Float workGrade;
    /**
     *单次作业得分
     */
    private Float onceWorkGrade;
    /**
     *综合测试满分
     */
    private Float examGrade;
    /**
     *
     */
    private String siteid;

}
