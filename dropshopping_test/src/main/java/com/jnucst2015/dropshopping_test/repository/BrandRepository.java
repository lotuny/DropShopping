package com.jnucst2015.dropshopping_test.repository;


import com.jnucst2015.dropshopping_test.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    List<Brand> findByName(String brandName);
    List<Brand> findByCompanyId(Integer companyId);
    List<Brand> findByDescriptionLike(String description);
}