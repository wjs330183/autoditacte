package com.kefang.autoditacte.exception;

import com.kefang.autoditacte.common.enums.ResultCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 业务异常类
 */
@Setter
@Getter
public class BusinessException extends Exception{
    /**
     *  结果错误码
     */
    protected ResultCode resultCode       = ResultCode.FAIL;

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(Throwable e) {
        super(e);
    }

    /**
     * 获取  返回的结果码
     * @return
     */
    public ResultCode getCode() {
        return this.resultCode;
    }

    /**
     * 获取字符串
     * @param msg
     * @return
     */
    private static String getMsg(String msg) {
        return msg == null ? "" : msg;
    }

    public BusinessException(ResultCode resultCode, String msg) {
        super(new StringBuffer().append(resultCode).append(" ").append(getMsg(msg)).toString());
        this.resultCode = resultCode;
    }

    public BusinessException(ResultCode resultCode) {
        super(ResultCode.getDesc(resultCode.getCode()));
        this.resultCode = resultCode;
    }

}
