package com.jnucst2015.dropshopping.service;

import com.jnucst2015.dropshopping.entity.SaleInfo;

import java.util.List;

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

    void updateSaleInfo(String name, String descrpition, Integer price, Integer id);

    void onsaleSaleInfoAgain(int id);

}
