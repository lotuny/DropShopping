package com.jnucst2015.dropshopping.repository;

import com.jnucst2015.dropshopping.entity.Seller;
import com.jnucst2015.dropshopping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

public interface SellerRepository extends JpaRepository<Seller,Integer>{

    Seller findSellerByUsername(String username);

}

