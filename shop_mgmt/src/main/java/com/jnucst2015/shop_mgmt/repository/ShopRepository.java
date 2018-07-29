package com.jnucst2015.shop_mgmt.repository;


import com.jnucst2015.shop_mgmt.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

    List<Shop> findByName(String ShopName);
    List<Shop> findBySellerId(Integer SellerID);
    List<Shop> findByDescriptionLike(String description);


}
