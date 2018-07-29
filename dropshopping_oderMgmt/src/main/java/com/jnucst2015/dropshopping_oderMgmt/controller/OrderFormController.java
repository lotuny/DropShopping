package com.jnucst2015.dropshopping_oderMgmt.controller;


import com.jnucst2015.dropshopping.entity.Order;
import com.jnucst2015.dropshopping.entity.OrderItem;
import com.jnucst2015.dropshopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orderForm")
public class OrderFormController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getOrders() {
        List<Order> orderItems = orderService.getAllOrder();



        return orderItems;
    }

}
