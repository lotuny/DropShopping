package com.jnucst2015.dropshopping_test.service;

import com.jnucst2015.dropshopping.entity.SaleInfo;

import java.util.List;
import java.util.Map;

public interface SaleInfoService {

    /**
     * 加入一条SaleInfo
     * @param saleInfo
     * @return
     */
    String addSaleInfo(SaleInfo saleInfo);

    /**
     * 列出所有
     * @return
     */
    List<SaleInfo> listSaleInfo(Integer sellerId);

    List<SaleInfo> listSaleInfoWithStateOnSale(Integer sellerId);

    /**
     * 通过id删除一条
     * @param id
     * @return
     */
    void desaleSaleInfo(int id);

    void updateSaleInfo(SaleInfo saleInfo);

   // void updateSaleInfo(String name, String descrpition, Integer price, Integer saleInfoId);

    void onsaleSaleInfoAgain(int id);

    List<Map<String, Object>> getShopList(Integer sellerId);

    void delete(int id);

}
