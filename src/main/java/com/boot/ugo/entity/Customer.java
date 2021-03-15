package com.boot.ugo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Customer 用户实体类
 *
 * @author gnl
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String nickName;
    private String realName;
    private String password;
    private String gender;
    private String email;
    private String mobilePhone;
    private String address;

    public Customer(String nickName, String password, String gender, String email) {
        this.nickName = nickName;
        this.password = password;
        this.gender = gender;
        this.email = email;
    }
}
