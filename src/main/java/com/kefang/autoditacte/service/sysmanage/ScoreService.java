package com.kefang.autoditacte.service.sysmanage;

import com.kefang.autoditacte.entity.sysmanage.Score;
import com.kefang.autoditacte.exception.BusinessException;

/**
 * 学习分数设置
 */
public interface ScoreService {
    /**
     *
     * @param id
     * @return
     */
    Score selectById(String id);
    /**
     *
     * @param score
     * @return
     */
    void update(Score score)throws BusinessException;
    /**
     *
     * @param score
     * @return
     */
    void insert(Score score) throws BusinessException;
    /**
     *
     * @param score
     * @return
     */
    void add(Score score)throws BusinessException;
}
