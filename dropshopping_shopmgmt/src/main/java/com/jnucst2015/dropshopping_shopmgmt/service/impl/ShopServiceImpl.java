package com.jnucst2015.dropshopping_shopmgmt.service.impl;

import com.jnucst2015.dropshopping_shopmgmt.entity.Shop;
import com.jnucst2015.dropshopping.repository.ShopRepository;
import com.jnucst2015.dropshopping_shopmgmt.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopRepository shopRepository;
    @Override
    public List<Shop> getAllShop() {
        return shopRepository.findAll();
    }

    @Override
    public Shop getShopByID(Integer ID) {
        return shopRepository.findById(ID).get();
    }

    @Override
    public List<Shop> getShopByName(String name) {
        return shopRepository.findByName(name);
    }

    @Override
    public List<Shop> getShopBySellerID(Integer ID) {
        return shopRepository.findBySellerId(ID);
    }

    @Override
    public List<Shop> getShopByDescription(String description) {
        return shopRepository.findByDescriptionLike("%" + description + "%");
    }


    @Override
    public Shop addShopInfo(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public void deleteByShopID(Integer ID) {
        shopRepository.deleteById(ID);
    }

    @Override
    public Shop updateShopInfo(Shop shop) {
        return shopRepository.save(shop);
    }
}