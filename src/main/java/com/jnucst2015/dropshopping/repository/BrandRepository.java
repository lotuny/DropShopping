package com.jnucst2015.dropshopping.repository;


import com.jnucst2015.dropshopping.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    List<Brand> findByName(String brandName);
    List<Brand> findByCompanyId(Integer companyId);
    List<Brand> findByDescriptionLike(String description);
    @Query(value="select b.companyId from Brand b group by b.companyId")
    List<Brand> findGroupByCompanyId();
    @Modifying
    @Transactional
//    @Query(value = "delete from Brand b where b.companyId=?1",nativeQuery = true)
    List<Brand> deleteBrandByCompanyId(Integer companyId);
}