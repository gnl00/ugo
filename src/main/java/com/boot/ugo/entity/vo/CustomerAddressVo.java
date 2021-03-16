package com.boot.ugo.entity.vo;

import com.boot.ugo.entity.Customer;
import com.boot.ugo.entity.CustomerAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * CustomerAddressVo
 *
 * @author gnl
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddressVo {

    private Customer customer;
    private List<CustomerAddress> addresses;

}
