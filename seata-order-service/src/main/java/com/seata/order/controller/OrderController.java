package com.seata.order.controller;

import com.seata.order.entity.CommonResult;
import com.seata.order.entity.Order;
import com.seata.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/create")
    public CommonResult create(Order order) {
        orderService.create(order);

        return new CommonResult("订单创建成功!", 200);
    }
}
