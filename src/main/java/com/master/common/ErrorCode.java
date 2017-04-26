package com.master.common;

/**
 * Created by Mr.Cheng on 2017/4/26 0026.
 */
public enum ErrorCode {


    ILLEGAL_PARAMS("ILLEGAL_PARAMS", "request params invalid"),
    SERVER_ERROR("SERVER_ERROR", "server is busy");

    private String code;

    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }


}
