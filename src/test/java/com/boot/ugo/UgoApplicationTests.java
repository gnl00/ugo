package com.boot.ugo;

import com.boot.ugo.util.JwtTokenUtils;
import com.boot.ugo.vo.StatusCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

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

                "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ3dyIsImV4cCI6MTYxNjA3NzE2NywiYXV0aG9yaXRpZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfVVNFUiJ9LHsiYXV0aG9yaXR5IjoidXNlcjp2aWV3In1dLCJ1c2VybmFtZSI6Ind3In0.2rhuHMrQtUw4g_evnHZ4maxaSHXh3gGZsMHRjZZdwkx0KuILlcj7rxQca-BuYMpzZRVe5iFN4bA9RIqbb8YEaQ";

        Boolean expiration = JwtTokenUtils.isExpiration(token);
        System.out.println(expiration);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void test3() {

        String pw = "123456";

        String hashpw = BCrypt.hashpw(pw, BCrypt.gensalt(10));

        System.out.println(passwordEncoder.matches(pw, "$2a$10$AlyU3Q9ugYInIjDy9E.U6u2xdyXStNvjj8RKROMIirW.lcNPnTkpK"));

    }

    @Test
    public void test4() {
        System.out.println(System.currentTimeMillis());
    }

}
