package com.mars.framework_net;

import android.text.TextUtils;


/**
 * 自定义异常抛出
 *
 * @author devel
 */
public class HttpException extends RuntimeException {

    public HttpException(String message) {
        this.message = message;
    }

    public HttpException(int code, String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return TextUtils.isEmpty(message) ? "异常" : message;
    }


    public int getCode() {
        return code;
    }

    private int code;
    private String message;
    private BaseResponse response;

}
