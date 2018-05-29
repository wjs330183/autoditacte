package com.kefang.autoditacte.param;

import lombok.Getter;
import lombok.Setter;

/**
* 描述：
* @author Json
* @date 2018-05-26
*/
@Getter
@Setter
public class SiteParam {

        /**
        *ID
        */
        private String id;
        /**
        *学校名称
        */
        private String name;
        /**
        *域名前缀
        */
        private String siteUrl;
        /**
        *学校代码
        */
        private String siteCode;
        /**
        *备注
        */
        private String note;
        /**
        *是否启用:radio
        */
        private Boolean status;


}