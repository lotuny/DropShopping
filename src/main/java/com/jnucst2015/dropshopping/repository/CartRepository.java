package com.jnucst2015.dropshopping.repository;

import com.jnucst2015.dropshopping.entity.Cart;
import com.jnucst2015.dropshopping.entity.User_Commodity_id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, User_Commodity_id> {
}
