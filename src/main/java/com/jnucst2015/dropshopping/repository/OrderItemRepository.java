package com.jnucst2015.dropshopping.repository;

import com.jnucst2015.dropshopping.entity.Order;
import com.jnucst2015.dropshopping.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {

    @Query(value = "select * from order_item where state=?1", nativeQuery = true)
    public List<OrderItem> selectByState(@Param("state")short state);

    @Query(value = "select * from order_item join sale_info on order_item.sale_info_id = sale_info.id where order_item.id=?1", nativeQuery = true)
    public OrderItem selectByOrderItemId(@Param("order_item.id")int orderItemId);

    @Query(value = "select * from order_item ", nativeQuery = true)
    public List<OrderItem> selectAllOrderItems();

    List<OrderItem> findAllByStateBefore(Integer integer);

    @Modifying
    @Transactional
    @Query(value = "update order_item set state = 4 where id = ?1",nativeQuery = true)
    void setOrderItemDelete(Integer orderItemId);
}
