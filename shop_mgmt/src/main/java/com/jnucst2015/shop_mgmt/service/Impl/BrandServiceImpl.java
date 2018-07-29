package com.jnucst2015.shop_mgmt.service.Impl;

import com.jnucst2015.shop_mgmt.entity.Brand;
import com.jnucst2015.shop_mgmt.repository.BrandRepository;
import com.jnucst2015.shop_mgmt.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.BaseStream;
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;
    @Override
    public List<Brand> getAllBrand() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getBrandById(Integer Id) {
        return brandRepository.findById(Id).get();
    }

    @Override
    public List<Brand> getBrandByName(String name) {
        return brandRepository.findByName(name);
    }

    @Override
    public List<Brand> getBrandByCompanyId(Integer companyId) {
        return brandRepository.findByCompanyId(companyId);
    }

    @Override
    public List<Brand> getBrandByDescription(String description) {
        return brandRepository.findByDescriptionLike("%" + description + "%");
    }

    @Override
    public Brand addBrandInfo(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public void deleteByBrandId(Integer id) {
        brandRepository.deleteById(id);
    }

    @Override
    public Brand updateBrandInfo(Brand brand) {
        return brandRepository.save(brand);
    }
}
