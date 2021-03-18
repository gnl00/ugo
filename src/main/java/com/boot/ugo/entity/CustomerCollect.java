package com.boot.ugo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * CustomerCollect 用户商品收藏实体类
 *
 * @author gnl
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCollect {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer customerId;
    private Integer goodsId;

    public CustomerCollect(Integer customerId, Integer goodsId) {
        this.customerId = customerId;
        this.goodsId = goodsId;
    }
}
