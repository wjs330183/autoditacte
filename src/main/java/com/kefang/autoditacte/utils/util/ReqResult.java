package com.kefang.autoditacte.utils.util;

import com.kefang.autoditacte.common.enums.ResultCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ReqResult<T> implements Serializable {
    /**
     * 返回码
     */
    private int               resultCode       = ResultCode.SUCCESS.getCode();

    /**
     * 返回错误描述   正式环境下可能不返回
     */
    private String            msg;

    /**
     *   语言环境
     */
    private boolean           languageEn       = false;

    /**
     * 返回数据
     */
    public T                  data;

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode.getCode();

    }

    public void setResultCode(ResultCode resultCode, Object msg) {
        this.resultCode = resultCode.getCode();
        this.setMsg(new StringBuilder().append(resultCode).append(":")
                .append(resultCode.getDesc()).append(" ").append(String.valueOf(msg)).toString());

    }
}
