package com.boot.ugo.entity;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * CustomerAddress 用户地址管理实体类
 *
 * @author gnl
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddress {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer customerId;
    private String address;
    private String recipient;
    private String phone;
    private Integer postalCode;
    private int isDefault;

    public CustomerAddress(Integer customerId, String address, String recipient, String phone, Integer postalCode) {
        this.customerId = customerId;
        this.address = address;
        this.recipient = recipient;
        this.phone = phone;
        this.postalCode = postalCode;
    }
}
