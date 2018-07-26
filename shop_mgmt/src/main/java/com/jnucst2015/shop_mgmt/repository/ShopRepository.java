package com.jnucst2015.shop_mgmt.repository;


import com.jnucst2015.shop_mgmt.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

    List<Shop> findByName(String ShopName);
    List<Shop> findBySeller_id(Integer OwnerID);


}
