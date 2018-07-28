package com.jnucst2015.dropshopping.service;

import com.jnucst2015.dropshopping.entity.Cart;

import java.util.List;

public interface CartService {

    List<Cart> getAllCart();

    Cart getCartByID(Integer user_id, Integer commodity_id);

    Cart updateCart(Cart cart);

    void deleteByID(Integer user_id, Integer commodity_id);

    Cart addCart(Cart cart);
}
