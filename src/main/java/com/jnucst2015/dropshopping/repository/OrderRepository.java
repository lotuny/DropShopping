package com.jnucst2015.dropshopping.repository;

import com.jnucst2015.dropshopping.entity.OrderForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderForm,Integer> {


}
