package com.jnucst2015.dropshopping.service;

import com.jnucst2015.dropshopping.entity.Shop;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShopService {
    List<Shop> getAllShop();
    Shop getShopByID(Integer ID);
    List<Shop> getShopByName(String name);
    List<Shop> getShopBySellerID(Integer ID);
    List<Shop> getShopByDescription(String description);
    Shop addShopInfo(Shop shop);
    void deleteByShopID(Integer ID);
    Shop updateShopInfo(Shop shop);
}