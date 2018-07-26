package com.jnucst2015.dropshopping.repository;

import com.jnucst2015.dropshopping.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

    List<Shop> findByName(String ShopName);
    Optional<Shop> findById(Integer OwnerID);


}
