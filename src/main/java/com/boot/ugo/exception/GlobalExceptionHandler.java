package com.boot.ugo.exception;

import com.boot.ugo.vo.Result;
import com.boot.ugo.vo.ReturnResult;
import com.boot.ugo.vo.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.sasl.AuthenticationException;

/**
 * GlobalExceptionHandler 全局异常处理类
 *
 * @author gnl
 */

@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception exception) {
        log.info("GlobalExceptionHandler ===> handlerException");
        return ReturnResult.fail(StatusCode.NOTFOUND, exception.getMessage());
    }

    @ExceptionHandler(CustomAuthorizationException.class)
    public Result handlerCustomAuthorizationException(CustomAuthorizationException e) {
        log.info("GlobalExceptionHandler ===> handlerCustomAuthorizationException");
        return ReturnResult.fail(StatusCode.UNAUTHORIZED, e.getMessage());
    }

    @ExceptionHandler(AuthenticationException.class)
    public Result handlerAuthenticationException(AuthenticationException exception) {
        log.info("GlobalExceptionHandler ===> handlerAuthenticationException");
        return ReturnResult.fail(StatusCode.UNAUTHORIZED, exception.getMessage());
    }

}
