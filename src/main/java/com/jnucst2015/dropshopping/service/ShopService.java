package com.jnucst2015.dropshopping.service;


import com.jnucst2015.dropshopping.entity.Shop;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ShopService {
    List<Shop> getAllShop();
    Shop getShopByID(Integer ID);
    List<Shop> getShopByName(String name);
    Optional<Shop> getShopBySellerID(Integer ID);
    Shop addShopInfo(Shop shop);
    void deleteByShopID(Integer ID);
    Shop updateShopInfo(Shop shop);
}
