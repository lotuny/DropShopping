package com.jnucst2015.dropshopping.service;

import com.jnucst2015.dropshopping.entity.OrderForm;

import java.util.List;

public interface OrderService {

    //返回所有学生信息
    List<OrderForm> getAllOrder();
    //根据ID查找学生信息
    OrderForm getOrderByID(Integer orderId);
    //添加学生信息
    OrderForm addOrderInfo(OrderForm orderForm);
    // 根据ID删除学生信息
    void deleteByOrderID(Integer orderId);
    // 修改学生信息
    OrderForm updateOrderInfo(OrderForm orderForm);



}
