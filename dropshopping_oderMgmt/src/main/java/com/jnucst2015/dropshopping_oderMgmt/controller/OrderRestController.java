package com.jnucst2015.dropshopping_oderMgmt.controller;


import com.jnucst2015.dropshopping.entity.OrderItem;
import com.jnucst2015.dropshopping_oderMgmt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderRestController {

    @Autowired
    private OrderService orderService;


    @GetMapping("{id}")
    public OrderItem getOrderItemInfo(@PathVariable("id") Integer orderItemId){
       OrderItem orderItem = orderService.showOrderItem(orderItemId);

        return orderItem;
    }





}
