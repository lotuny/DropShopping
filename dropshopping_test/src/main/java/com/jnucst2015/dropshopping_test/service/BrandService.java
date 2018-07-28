package com.jnucst2015.dropshopping_test.service;

import com.jnucst2015.dropshopping_test.entity.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    List<Brand> getAllBrand();
    Brand getBrandById(Integer Id);
    List<Brand> getBrandByName(String name);
    List<Brand> getBrandByCompanyId(Integer companyId);
    List<Brand> getBrandByDescription(String description);
    Brand addBrandInfo(Brand brand);
    void deleteByBrandId(Integer id);
    Brand updateBrandInfo(Brand brand);
}