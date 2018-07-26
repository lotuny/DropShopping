package com.jnucst2015.shop_mgmt.service.Impl;


import com.jnucst2015.shop_mgmt.entity.Shop;
import com.jnucst2015.shop_mgmt.repository.ShopRepository;
import com.jnucst2015.shop_mgmt.service.ShopService;
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
        return shopRepository.findBySeller_id(ID);
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