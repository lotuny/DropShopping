package com.jnucst2015.dropshopping_oderMgmt.service;

import com.jnucst2015.dropshopping.entity.Order;
import com.jnucst2015.dropshopping.entity.OrderItem;
import com.jnucst2015.dropshopping_oderMgmt.vo.OrderItemVo;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrder();

    List<OrderItem> getAllByState(short state);

    OrderItem getOrderByID(Integer id);

    OrderItem getOrderByOrderID(Integer orderId);

//    Order addOrder(Order order);

    void deleteByOrderID(Integer orderId);

    OrderItemVo updateOrderItemInfo(OrderItemVo orderItemVo);

    OrderItem showOrderItem (int orderItemId);

    void deleteOrderItem(int orderItemId);

    List<OrderItemVo> showOrderItems ();




}
