package com.kefang.autoditacte.service.impl.sysmanage;

import com.kefang.autoditacte.dao.ModuleDao;
import com.kefang.autoditacte.dto.ModuleDto;
import com.kefang.autoditacte.service.sysmanage.ModuleService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 系统管理——权限管理
 */
@Service("modulesService")
public class ModuleServiceImpl implements ModuleService {
    static Logger logger = LoggerFactory.getLogger(ModuleServiceImpl.class);

    @Resource
    private ModuleDao moduleDao;

    /**
     * 将所有菜单分类
     * @return
     */

    @Override
   public List<ModuleDto> queryAllModule(){
        //查询出所有一级，二级，三级菜单
        List<ModuleDto> moduleList=moduleDao.selectAllAction();
        if(moduleList==null && moduleList.isEmpty()){
            return Collections.emptyList();
        }
          //所有的一级
        List<ModuleDto> firstList=new ArrayList<>();
         //所有模块的map
        Map<String,ModuleDto> moduleMap=new HashMap<>();//moduleId:module
        for(ModuleDto dto : moduleList){
            moduleMap.put(dto.getModuleId(),dto);
            }
        for(ModuleDto md : moduleList){//三级
           if(md.getLevel()==3){
               ModuleDto secondModule=moduleMap.get(md.getParentModuleId());
               secondModule.getChilds().add(md);
           }else if(md.getLevel()==2){//二级
                ModuleDto firstModule=moduleMap.get(md.getParentModuleId());//获取第一级
                firstModule.getChilds().add(md);//将二级添加到一级
           }else{
               firstList.add(md);//将一级放入集合
           }
        }
        return firstList;
     }
}
