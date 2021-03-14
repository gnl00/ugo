package com.boot.ugo.entity.vo;

import com.boot.ugo.entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * CartVo 购物车封装类
 *
 * @author gnl
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CartVo {

    private String goodsName;
    private Cart cart;
    private List<String> picture;

}
