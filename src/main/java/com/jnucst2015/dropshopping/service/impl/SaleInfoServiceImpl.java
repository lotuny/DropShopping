package com.jnucst2015.dropshopping.service.impl;

import com.jnucst2015.dropshopping.entity.SaleInfo;
import com.jnucst2015.dropshopping.repository.SaleInfoRepository;
import com.jnucst2015.dropshopping.service.SaleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleInfoServiceImpl implements SaleInfoService {

    @Autowired
    private SaleInfoRepository saleInfoRepository;

    @Override
    public String addSaleInfo(SaleInfo saleInfo) {
//        SaleInfo result = saleInfoRepository.getOne(saleInfo.getId());
//        if (result!=null){
//            saleInfoRepository.saveAndFlush(saleInfo);
//            return "successfully";
//        }
//        return "error";
        saleInfoRepository.saveAndFlush(saleInfo);
        return "";
    }

    @Override
    public List<SaleInfo> listSaleInfo() {
        return saleInfoRepository.findAll();
    }

    @Override
    public void deleteSaleInfo(int id) {
        saleInfoRepository.deleteById(id);
    }

    @Override
    public void updateSaleInfo(SaleInfo saleInfo) {
        saleInfoRepository.saveAndFlush(saleInfo);
    }
}
