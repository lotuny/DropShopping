package com.jnucst2015.dropshopping_test.service.impl;

import com.jnucst2015.dropshopping.entity.SaleInfo;
import com.jnucst2015.dropshopping.repository.SaleInfoRepository;
import com.jnucst2015.dropshopping_test.service.SaleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public List<SaleInfo> listSaleInfo(Integer sellerId) {
        return saleInfoRepository.findSaleInfosBySellerIdEquals(sellerId);
    }

    @Override
    public List<SaleInfo> listSaleInfoWithStateOnSale(Integer sellerId) {
        return saleInfoRepository.findSaleInfosByStateEqualsAndSellerIdEquals(1, sellerId);
    }

    @Override
    public void desaleSaleInfo(int id) {
        saleInfoRepository.daSale(id);
    }

    @Override
    public void updateSaleInfo(SaleInfo saleInfo) {
        saleInfoRepository.reduceCommodityQuantity(saleInfo.getQuantity(), saleInfo.getId());
        saleInfoRepository.saveAndFlush(saleInfo);
    }

//    @Override
//    public void updateSaleInfo(String name, String descrpition, Integer price, Integer id, Integer commodityId) {
//        saleInfoRepository.updateSaleInfo(name,descrpition,price,id, commodityId);
//    }

    @Override
    public void onsaleSaleInfoAgain(int id) {
        saleInfoRepository.onSale(id);
    }

    @Override
    public List<Map<String, Object>> getShopList(Integer sellerId) {
        return saleInfoRepository.queryShopList(sellerId);
    }

    @Override
    public void delete(int id) {
        saleInfoRepository.deleteById(id);
    }
}
