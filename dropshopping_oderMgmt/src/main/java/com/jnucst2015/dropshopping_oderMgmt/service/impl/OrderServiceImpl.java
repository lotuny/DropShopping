package com.jnucst2015.dropshopping_oderMgmt.service.impl;

import com.jnucst2015.dropshopping.entity.Order;
import com.jnucst2015.dropshopping.entity.OrderItem;
import com.jnucst2015.dropshopping.repository.OrderRepository;
import com.jnucst2015.dropshopping_oderMgmt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderItem> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public List<OrderItem> getAllByState(short state){ return orderRepository.selectByState(state); }

    @Override
    public OrderItem getOrderByID(Integer id) {
        return orderRepository.findById(id).get();
    }

    public Order getOrderByOrderID(Integer orderId) {
        return orderRepository.selectByOrderId(orderId);
    }

//    @Override
//    public Order addOrder(Order order) {
//
//        int orderId = (int) System.currentTimeMillis();
//
////        for (OrderItem orderItem:order){
////            orderItem.setOrder_id(orderId);
////            orderRepository.save(orderItem);
////        }
//
//        return order;
//
//    }

    @Override
    public void deleteByOrderID(Integer orderId) {
        orderRepository.deleteById(orderId);
    }



//    @Override
//    public List<OrderItem> updateOrderInfo(List<OrderItem> order) {
//        for (OrderItem orderItem: order) {
//            orderRepository.save(orderItem);
//        }
//        return order;
//    }


}
