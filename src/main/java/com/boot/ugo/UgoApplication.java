package com.boot.ugo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * UgoApplication 主程序类
 * @MapperScan 扫描mapper 类所在的包，使用此注解就【不需要】再在mapper 接口类上标注@Mapper 注解
 *
 * @author gnl
 */

@MapperScan(basePackages = { "com.boot.ugo.mapper" })
@SpringBootApplication
public class UgoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UgoApplication.class, args);
    }

}
