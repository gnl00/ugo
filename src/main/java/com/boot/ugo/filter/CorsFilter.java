package com.boot.ugo.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CorsFilter 跨域请求拦截器
 *
 * @author gnl
 */

@Component
public class CorsFilter extends OncePerRequestFilter {

    // static final String ORIGIN = "Origin";
    static final String OPTIONS = "OPTIONS";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 获取请求来源
        // String origin = request.getHeader(ORIGIN);
        // System.out.println(origin);

        // * or origin as u prefer
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "PUT, POST, GET, OPTIONS, DELETE, PATCH");
        response.setHeader("Access-Control-Max-Age", "3600");
        // Authorization header中自定义的token位置
        response.setHeader("Access-Control-Allow-Headers", "content-type, Authorization");

        if (OPTIONS.equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(request, response);
        }
    }

}
