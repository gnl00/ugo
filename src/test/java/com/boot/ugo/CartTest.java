package com.boot.ugo;

import com.boot.ugo.entity.vo.CartVo;
import com.boot.ugo.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * CartTest
 *
 * @author gnl
 */

@Slf4j
@SpringBootTest
public class CartTest {

    @Autowired
    CartService cartService;

    @Test
    public void test1() {
        List<CartVo> cartVos = cartService.queryByCustomerId(1);
        System.out.println(cartVos.size());
    }

}
