package com.boot.ugo.utils;

import io.jsonwebtoken.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import sun.rmi.runtime.Log;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JwtTokenUtil Jwt工具类
 *
 * @author gnl
 */

@Slf4j
@Getter
public class JwtTokenUtils {

    public static final String JWT_HEADER = "Authorization";
    public static final String JWT_PREFIX = "Bearer ";

    private static final String JWT_SIGN_SECRET = "sdWEV6*^.53.@#$";
    private static final String JWT_ISSUER = "gnl";

    /**
     * 过期时间为1天
     */
    private static final Integer JWT_EXPIRATION = 24;

    /**
     * 记住我过期时间为7天
     */
    private static final Integer JWT_EXPIRATION_REMEMBER = 24*7;

    public static Calendar calendar = Calendar.getInstance();

    public static Date setExpiration(Integer time) {
        calendar.add(Calendar.HOUR, time);
        return calendar.getTime();
    }

    /**
     * 创建token
     *
     * @author gnl
     */
    public static String createToken(String username, boolean isRememberMe) {
        int expiration = isRememberMe ? JWT_EXPIRATION_REMEMBER : JWT_EXPIRATION;

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, JWT_SIGN_SECRET)
                .setIssuer(JWT_ISSUER)
                .setIssuedAt(calendar.getTime())
                .setSubject(username)
                .setExpiration(setExpiration(expiration))
                .compact();
    }

    public static String createToken(UserDetails userDetails) {

        Map<String, Object> map = new HashMap<>(4);
        map.put("username", userDetails.getUsername());
        map.put("authorities", userDetails.getAuthorities());

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, JWT_SIGN_SECRET)
                .setIssuer(JWT_ISSUER)
                .setIssuedAt(calendar.getTime())
                .setClaims(map)
                .setSubject(userDetails.getUsername())
                .setExpiration(setExpiration(JWT_EXPIRATION))
                .compact();
    }

    public static String createToken(Map<String, Object> map, boolean isRememberMe) {
        int expiration = isRememberMe ? JWT_EXPIRATION_REMEMBER : JWT_EXPIRATION;

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, JWT_SIGN_SECRET)
                .setIssuer(JWT_ISSUER)
                .setIssuedAt(calendar.getTime())
                .setClaims(map)
                .setExpiration(setExpiration(expiration))
                .compact();
    }

    /**
     * 获得token体
     *
     * @author gnl
     */
    public static Claims getTokenBody(String token) {

        Claims claims = null;

        try {
            claims = Jwts.parser()
                    .setSigningKey(JWT_SIGN_SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            // 即使过期也获取claims
            claims = e.getClaims();
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
        } catch (MalformedJwtException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return claims;
    }

    /**
     * 检查token是否过期
     *
     * @author gnl
     */
    public static Boolean isExpiration(String token) {

        // return getTokenBody(token).getExpiration().before(calendar.getTime());

        long expirationTime = getTokenBody(token).getExpiration().getTime();
        long currentTimeMillis = System.currentTimeMillis();
        return expirationTime < currentTimeMillis;
    }

    /**
     * 获得token body
     *
     * @author gnl
     */
    public static String getTokenSubject(String token) {
        return getTokenBody(token).getSubject();
    }


    /**
     * 刷新令牌
     *
     * @author gnl
     * @param oldToken
     * @return java.lang.String
     */
    public static String refreshToken(String oldToken) {

        Claims claims = getTokenBody(oldToken);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, JWT_SIGN_SECRET)
                .setIssuer(JWT_ISSUER)
                .setIssuedAt(calendar.getTime())
                .setClaims(claims)
                .setExpiration(setExpiration(JWT_EXPIRATION))
                .compact();
    }

}
