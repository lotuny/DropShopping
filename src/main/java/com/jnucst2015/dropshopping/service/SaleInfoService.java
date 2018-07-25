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
    List<SaleInfo> listSaleInfo();

    /**
     * 通过id删除一条
     * @param id
     * @return
     */
    void deleteSaleInfo(int id);
}
