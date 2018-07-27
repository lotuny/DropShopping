package com.jnucst2015.shop_mgmt.repository;

import com.jnucst2015.shop_mgmt.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    List<Brand> findByName(String brandName);
    List<Brand> findByCompanyId(Integer companyId);
    List<Brand> findByDescriptionLike(String description);
}
