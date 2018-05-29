package com.kefang.autoditacte.service.impl.sysmanage;

import com.kefang.autoditacte.common.enums.ResultCode;
import com.kefang.autoditacte.dao.ScoreDao;
import com.kefang.autoditacte.entity.sysmanage.Score;
import com.kefang.autoditacte.exception.BusinessException;
import com.kefang.autoditacte.service.sysmanage.ScoreService;
import com.kefang.autoditacte.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {
    static Logger logger = LoggerFactory.getLogger(ScoreService.class);
    @Resource
    private ScoreDao scoreDao;
    /**
     * 按id进行查询
     * @param id
     * @return
     */
    @Override
   public Score selectById(String id){
    return scoreDao.selectByPrimaryKey(id);
    }
    /**
     * 修改
     * @param score
     * @return
     */
    @Override
    public void update(Score score)throws BusinessException{
         int num=scoreDao.updateByPrimaryKey(score);
        if(num<=0){
            throw new BusinessException(ResultCode.UPDATE_ERROR);
        }
    }
    /**
     * 添加
     * @param score
     * @return
     */
    @Override
    public void insert(Score score) throws BusinessException{
        String id=UUID.randomUUID().toString();
        score.setId(id);
        int num=scoreDao.insertSelective(score);
        if(num<=0){
            throw new BusinessException(ResultCode.INSERT_ERROR);
        }
    }
    /**
     * 保存或者添加
     * @param score
     * @return
     */
    @Override
    public void add(Score score)throws BusinessException{
        if(score.getCommonGrade()<=0||score.getExamGrade()<=0
            ||score.getLoginGrade()<=0||score.getNoteGrade()<=0
            ||score.getOnceNoteGrade()<=0||score.getOnceWorkGrade()<=0
             ||score.getWorkGrade()<=0   ){
            throw new BusinessException(ResultCode.PARAMETER_ERROR);
        }
        //总分数只能是100
        double total=CommonUtils.add(score.getCommonGrade(),score.getLoginGrade(),score.getExamGrade(),score.getWorkGrade());
        if(total!=100){
            throw new BusinessException(ResultCode.TOTAL_SCORE_ERROR);
        }
        if(CommonUtils.isBlank(score.getId())){//添加
            this.insert(score);
        }else{//修改
            this.update(score);
        }

    }
}
