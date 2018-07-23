package com.jnucst2015.dropshopping.service;

import com.jnucst2015.dropshopping.entity.Cart;
import com.jnucst2015.dropshopping.entity.User_Commodity_id;
import com.jnucst2015.dropshopping.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> getAllCart() {
        return cartRepository.findAll();
    }

    @Override
    public Cart getCartByID(Integer user_id, Integer commodity_id) {
        return cartRepository.findById(new User_Commodity_id(user_id,commodity_id)).get();
    }

    @Override
    public Cart updateCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void deleteByID(Integer user_id, Integer commodity_id) {
        cartRepository.deleteById(new User_Commodity_id(user_id,commodity_id));
    }

    @Override
    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }
}
