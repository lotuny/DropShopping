package com.jnucst2015.dropshopping.repository;

import com.jnucst2015.dropshopping.entity.Order;
import com.jnucst2015.dropshopping.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderItem,Integer> {

    @Query(value = "select * from order_item where state=?1", nativeQuery = true)
    public List<OrderItem> selectByState(@Param("state")short state);

    @Query(value = "select * from order_item where order_id=?1", nativeQuery = true)
    public Order selectByOrderId(@Param("order_id")int orderId);

}
