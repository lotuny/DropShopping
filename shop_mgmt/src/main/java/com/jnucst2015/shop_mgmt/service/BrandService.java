package com.jnucst2015.shop_mgmt.service;

import com.jnucst2015.shop_mgmt.entity.Brand;
import com.jnucst2015.shop_mgmt.entity.Shop;
import org.omg.CORBA.StringHolder;
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

