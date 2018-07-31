package com.jnucst2015.dropshopping.service;

import com.jnucst2015.dropshopping.entity.Order;
import com.jnucst2015.dropshopping.entity.OrderItem;
import com.jnucst2015.dropshopping.vo.OrderItemVo;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrder();

    List<OrderItem> getAllByState(short state);

    OrderItem getOrderByID(Integer id);

    OrderItem getOrderByOrderID(Integer orderId);

//    Order addOrder(Order order);

    void deleteByOrderID(Integer orderId);

    OrderItemVo updateOrderItemInfo(OrderItemVo orderItemVo);

    OrderItem showOrderItem(int orderItemId);

    void  changeState(int state, int orderItemId);

    List<OrderItemVo> showOrderItems();


    List<OrderItemVo> showOrderItemsBySellerId(Integer userId);

    List<OrderItemVo> showOrderItemsByCompanyId(Integer userId);
}
