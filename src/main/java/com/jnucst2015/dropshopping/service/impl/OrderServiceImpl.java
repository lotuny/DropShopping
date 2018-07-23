package com.jnucst2015.dropshopping.service.impl;

import com.jnucst2015.dropshopping.entity.OrderForm;
import com.jnucst2015.dropshopping.repository.OrderRepository;
import com.jnucst2015.dropshopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public List<OrderForm> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public OrderForm getOrderByID(Integer orderId) {
        return orderRepository.findById(orderId).get();
    }

    @Override
    public OrderForm addOrderInfo(OrderForm OrderForm) {
        return orderRepository.save(OrderForm);
    }

    @Override
    public void deleteByOrderID(Integer orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public OrderForm updateOrderInfo(OrderForm orderForm) { return orderRepository.save(orderForm); }
}
