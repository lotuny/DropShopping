package com.jnucst2015.dropshopping_oderMgmt.service;

import com.jnucst2015.dropshopping.entity.Order;
import com.jnucst2015.dropshopping.entity.OrderItem;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrder();

    List<OrderItem> getAllByState(short state);

    OrderItem getOrderByID(Integer id);

    OrderItem getOrderByOrderID(Integer orderId);

//    Order addOrder(Order order);

    void deleteByOrderID(Integer orderId);

    OrderItem updateOrderItemInfo(OrderItem orderItem);

    OrderItem showOrderItem (int orderItemId);

    List<OrderItem> showOrderItems ();




}
