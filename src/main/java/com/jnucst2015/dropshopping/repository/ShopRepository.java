package com.jnucst2015.dropshopping.repository;

import com.jnucst2015.dropshopping.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

    List<Shop> findByName(String ShopName);

    @Query("SELECT s FROM Shop s WHERE s.seller_id = ?1")
    List<Shop> findBySeller_id(Integer OwnerID);
    Optional<Shop> findById(Integer OwnerID);


}
