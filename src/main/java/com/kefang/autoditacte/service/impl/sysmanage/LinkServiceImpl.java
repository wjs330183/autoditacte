package com.kefang.autoditacte.service.impl.sysmanage;

import com.kefang.autoditacte.common.enums.ResultCode;
import com.kefang.autoditacte.dao.LinkDao;
import com.kefang.autoditacte.entity.sysmanage.Link;
import com.kefang.autoditacte.exception.BusinessException;
import com.kefang.autoditacte.service.sysmanage.LinkService;
import com.kefang.autoditacte.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 系统管理——友情链接业务接口实现层
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {
    static Logger logger = LoggerFactory.getLogger(LinkServiceImpl.class);
    @Resource
    private LinkDao linkDao;

    /**
     *  查询所有的友情链接
     * @return
     */
    @Override
    public List<Link> queryAll(){
        List<Link> linksList=new ArrayList<>();
        linksList=linkDao.selectAll();
        return linksList;
    }

    /**
     * 编辑某一个链接
     * @param link
     */
    @Override
    public  void editLink(Link link)throws BusinessException {
        if(CommonUtils.isBlank(link.getId())
                ||CommonUtils.isBlank(link.getLinkName())
                ||CommonUtils.isBlank(link.getLogoUrl())
                ||CommonUtils.isBlank(link.getLinkUrl())){
            throw new BusinessException(ResultCode.PARAMETER_ERROR);
        }
        link.setUpdateTime(new Date());
        int result=linkDao.updateById(link);
        if(result<=0){
            throw new BusinessException(ResultCode.UPDATE_ERROR);
        }

    }
}
