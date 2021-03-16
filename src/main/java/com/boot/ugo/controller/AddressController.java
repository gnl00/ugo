package com.boot.ugo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.boot.ugo.entity.Customer;
import com.boot.ugo.entity.CustomerAddress;
import com.boot.ugo.entity.vo.CustomerAddressVo;
import com.boot.ugo.service.CustomerAddressService;
import com.boot.ugo.vo.Result;
import com.boot.ugo.vo.ReturnResult;
import com.boot.ugo.vo.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * AddressController 地址管理Controller
 *
 * @author gnl
 */

@RequestMapping("/ugo/add")
@RestController
public class AddressController {

    @Autowired
    CustomerController customerController;

    @Autowired
    CustomerAddressService addressService;

    @GetMapping
    public Result getAddress(HttpServletRequest request) {
        Customer customer = customerController.getUserFromToken(request);

        if (customer != null) {
            Integer customerId = customer.getId();
            QueryWrapper<CustomerAddress> addressWrapper = new QueryWrapper<>();
            addressWrapper.eq("customer_id", customerId);
            List<CustomerAddress> addresses = addressService.list(addressWrapper);
            CustomerAddressVo vo = new CustomerAddressVo(customer, addresses);

            if (null != vo) {
                return ReturnResult.ok(vo);
            }
            return ReturnResult.fail(StatusCode.SERVICE_UNAVAILABLE, "操作失败");
        }
        return ReturnResult.fail(StatusCode.SERVICE_UNAVAILABLE, "操作失败");

    }

    @GetMapping("/{addId}")
    public Result getAddressByAddressId(@PathVariable Integer addId) {

        CustomerAddress address = addressService.getById(addId);

        if (address != null) {
            return ReturnResult.ok(address);
        }
        return ReturnResult.fail(StatusCode.SERVICE_UNAVAILABLE, "操作失败");
    }

    @PostMapping
    public Result addAddress(@RequestBody Map<String, Object> map, HttpServletRequest request) {
        Customer customer = customerController.getUserFromToken(request);

        System.out.println(map);

        Integer id = (Integer) map.get("id");
        String address = (String) map.get("address");
        String recipient = (String) map.get("recipient");
        String phone = (String) map.get("phone");
        String postalCode = (String) map.get("postalCode");
        Boolean isDefault = (Boolean) map.get("isDefault");

        CustomerAddress customerAddress = new CustomerAddress(customer.getId(), address, recipient, phone, Integer.valueOf(postalCode));

        if (isDefault) {
            // 当前为默认
            customerAddress.setIsDefault(1);

            // 将数据库中的默认修改为0
            QueryWrapper<CustomerAddress> wrapper = new QueryWrapper<>();
            wrapper.eq("is_default", 1);
            CustomerAddress addressInDB = addressService.getOne(wrapper);
            addressInDB.setIsDefault(0);
            addressService.updateById(addressInDB);

        } else {
            customerAddress.setIsDefault(0);
        }

        if (id != null) {
            customerAddress.setId(id);
        }

        boolean saveOrUpdate = addressService.saveOrUpdate(customerAddress);

        if (saveOrUpdate) {
            return ReturnResult.ok();
        }

        return ReturnResult.fail(StatusCode.SERVICE_UNAVAILABLE, "操作失败");
    }

    @DeleteMapping("/del/{addId}")
    public Result deleteAddress(@PathVariable Integer addId) {
        boolean remove = addressService.removeById(addId);

        if (remove) {
            return ReturnResult.ok();
        }
        return ReturnResult.fail(StatusCode.SERVICE_UNAVAILABLE, "操作失败");
    }

}
