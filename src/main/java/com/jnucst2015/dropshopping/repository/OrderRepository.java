package com.jnucst2015.dropshopping.repository;

import com.jnucst2015.dropshopping.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {


    Order findOrderById(Integer id);

}
