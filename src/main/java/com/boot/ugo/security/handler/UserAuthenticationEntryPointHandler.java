package com.boot.ugo.security.handler;

import com.boot.ugo.util.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * UserAuthenticationEntryPointHandler 用户未登录处理类
 *
 * @author gnl
 */

@Slf4j
@Component
public class UserAuthenticationEntryPointHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

        log.info("UserAuthenticationEntryPointHandler ===> commence");

        ResponseUtils.responseJson(response, ResponseUtils.resultError(401, "用户未登录"));

    }
}
