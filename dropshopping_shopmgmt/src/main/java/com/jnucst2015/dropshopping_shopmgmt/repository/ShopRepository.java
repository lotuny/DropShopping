package com.jnucst2015.dropshopping_shopmgmt.repository;

import com.jnucst2015.dropshopping_shopmgmt.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

    List<Shop> findByName(String ShopName);
    List<Shop> findBySellerId(Integer SellerID);
    List<Shop> findByDescriptionLike(String description);


}