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

                "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2MTU3NzM4NTksImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX1VTRVIifSx7ImF1dGhvcml0eSI6InVzZXI6dmlldyJ9XSwidXNlcm5hbWUiOiJ6c3MifQ.QRU7CAncFVVYFdhOxToc5cYS2tXuNMJhxPTR7JOPr8G9lN7yzNXwuZF6KixaLqKMRY3aYRxjhs840juyhE7IOg";

        Boolean expiration = JwtTokenUtils.isExpiration(token);
        System.out.println(expiration);
    }

}
