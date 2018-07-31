package com.jnucst2015.dropshopping.repository;

import com.jnucst2015.dropshopping.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Integer>{

    Seller findSellerByUsername(String username);

}

