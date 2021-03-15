package com.boot.ugo;

import com.boot.ugo.entity.Cart;
import com.boot.ugo.entity.vo.CartVo;
import com.boot.ugo.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println(cartVos);
    }

    @Test
    public void test2() {

        List<Integer> checkedIds = Arrays.asList(4, 5, 6, 7, 8);

        List<Cart> carts = cartService.list();
        List<Integer> cartIdsInDB = carts.stream().map(Cart::getId).collect(Collectors.toList());
        List<Integer> unCheckedIds = cartIdsInDB.stream().filter(id -> !checkedIds.contains(id)).collect(Collectors.toList());

        System.out.println(cartIdsInDB);
        System.out.println(checkedIds);
        System.out.println(unCheckedIds);

    }

}
