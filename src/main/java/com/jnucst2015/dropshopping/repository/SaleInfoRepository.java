package com.jnucst2015.dropshopping.repository;

import com.jnucst2015.dropshopping.entity.Company;
import com.jnucst2015.dropshopping.entity.SaleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleInfoRepository extends JpaRepository<SaleInfo,Integer> {

    SaleInfo findSaleInfoById(Integer id);

}
