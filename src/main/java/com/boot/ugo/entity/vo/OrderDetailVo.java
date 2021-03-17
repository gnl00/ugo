package com.boot.ugo.entity.vo;

import com.boot.ugo.entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * OrderVo
 *
 * @author gnl
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailVo {

    private Cart cart;
    private List<String> picture;

}
