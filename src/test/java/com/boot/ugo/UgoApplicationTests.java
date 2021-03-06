package com.boot.ugo;

import com.boot.ugo.entity.Customer;
import com.boot.ugo.entity.GoodsCategory;
import com.boot.ugo.mapper.CustomerMapper;
import com.boot.ugo.mapper.GoodsCategoryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UgoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    GoodsCategoryMapper categoryMapper;

    @Test
    public void testCustomer() {
        List<Customer> customers = customerMapper.selectList(null);
        customers.forEach(System.out::println);
    }

    @Test
    public void testCategory() {
        List<GoodsCategory> goodsCategories = categoryMapper.selectList(null);
        goodsCategories.forEach(System.out::println);
    }

}
