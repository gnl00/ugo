package com.boot.ugo;

import com.boot.ugo.entity.Customer;
import com.boot.ugo.entity.GoodsCategory;
import com.boot.ugo.mapper.CustomerMapper;
import com.boot.ugo.mapper.GoodsCategoryMapper;
import com.boot.ugo.utils.JwtTokenUtils;
import com.boot.ugo.vo.StatusCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class UgoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test() {
        System.out.println(StatusCode.OK);
    }

    @Test
    public void test1() {
        System.out.println(HttpStatus.OK);
    }

    @Test
    public void test2() {
        String token =

                "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ6c3MiLCJleHAiOjE2MTU3OTA2NTAsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX1VTRVIifSx7ImF1dGhvcml0eSI6InVzZXI6dmlldyJ9XSwidXNlcm5hbWUiOiJ6c3MifQ.0A9Q1llZpmTvhiv1YsN4BmSg-hGEG1UqHKnxWmiN2SNtFzIGbmY_VxEozHo-wkgNnY8v2Yx9u8ho-0fOk8m5Rg";

        String subject = JwtTokenUtils.getTokenSubject(token);
        System.out.println(subject);
    }

    @Test
    public void test3() {
//        String rawSalt = "gnl";
//        String rawPassword = "123456";
//
//        String salt = BCrypt.gensalt(rawSalt, rawSalt.length());
//
//        String hashpw = BCrypt.hashpw(rawPassword, salt);
//
//        System.out.println(hashpw);
    }

}
