package com.boot.ugo.vo;

import org.springframework.http.HttpStatus;

/**
 * StatusCode 返回值状态码
 *
 * @author gnl
 */

public class StatusCode {

    /**
     * 200 OK
     */
    public static final int OK = HttpStatus.OK.value();

    /**
     * 401  UNAUTHORIZED
     */
    public static final int UNAUTHORIZED = HttpStatus.UNAUTHORIZED.value();

    /**
     * 403  FORBIDDEN
     */
    public static final int FORBIDDEN = HttpStatus.FORBIDDEN.value();

    /**
     * 404 NOT_FOUND
     */
    public static final int NOTFOUND = HttpStatus.NOT_FOUND.value();

    /**
     * 405  METHOD_NOT_ALLOWED
     */
    public static final int METHOD_NOT_ALLOWED = HttpStatus.METHOD_NOT_ALLOWED.value();

    /**
     * 406  NOT_ACCEPTABLE
     */
    public static final int NOT_ACCEPTABLE = HttpStatus.NOT_ACCEPTABLE.value();

    public static final int PARAMS_EXCEPTION = 455;

    /**
     * 503  SERVICE_UNAVAILABLE
     */
    public static final int SERVICE_UNAVAILABLE = HttpStatus.SERVICE_UNAVAILABLE.value();


}
