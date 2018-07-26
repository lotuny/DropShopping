package com.jnucst2015.dropshopping_oderMgmt.service.impl;

import com.jnucst2015.dropshopping.entity.Order;
import com.jnucst2015.dropshopping.entity.OrderItem;
import com.jnucst2015.dropshopping.repository.OrderItemRepository;
import com.jnucst2015.dropshopping.repository.OrderRepository;
import com.jnucst2015.dropshopping_oderMgmt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public List<OrderItem> getAllByState(short state){ return orderItemRepository.selectByState(state); }

    @Override
    public OrderItem getOrderByID(Integer id) {
        return orderItemRepository.findById(id).get();
    }

    public OrderItem getOrderByOrderID(Integer orderId) {
        return orderItemRepository.selectByOrderItemId(orderId);
    }

//    @Override
//    public Order addOrder(Order order) {
//
//        int orderId = (int) System.currentTimeMillis();
//
////        for (OrderItem orderItem:order){
////            orderItem.setOrder_id(orderId);
////            orderItemRepository.save(orderItem);
////        }
//
//        return order;
//
//    }

    @Override
    public void deleteByOrderID(Integer orderId) {
        orderItemRepository.deleteById(orderId);
    }

    @Override
    public OrderItem showOrderItem (int orderItemId){

        return orderItemRepository.selectByOrderItemId(orderItemId);

    }

    @Override
    public List<OrderItem> showOrderItems () {
        List<OrderItem> orderItems = orderItemRepository.findAll();
        return orderItems;

    }
//    @Override
//    public List<OrderItem> updateOrderInfo(List<OrderItem> order) {
//        for (OrderItem orderItem: order) {
//            orderItemRepository.save(orderItem);
//        }
//        return order;
//    }
    @Override
    public OrderItem updateOrderItemInfo(OrderItem orderItem) {

            orderItemRepository.save(orderItem);

        return orderItem;
    }


}
