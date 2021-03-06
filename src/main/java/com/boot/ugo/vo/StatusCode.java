package com.boot.ugo.vo;

/**
 * StatusCode 返回值状态码
 *
 * @author gnl
 */

public enum StatusCode {

    OK(200),
    UNAUTHORIZED (401),
    FORBIDDEN(403),
    NOTFOUND(404),
    MethodNotAllowed(405),
    ServiceUnavailable(503);

    private int code;

    StatusCode(int code) {}

    public int getCode() {
        return this.code;
    }

}
