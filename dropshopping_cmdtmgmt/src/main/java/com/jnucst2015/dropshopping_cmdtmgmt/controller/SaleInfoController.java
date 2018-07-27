package com.jnucst2015.dropshopping_cmdtmgmt.controller;

import com.jnucst2015.dropshopping.entity.SaleInfo;
import com.jnucst2015.dropshopping.service.SaleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SaleInfoController {

    @Autowired
    private SaleInfoService saleInfoService;

    @PostMapping("/addSaleInfo")
    public String add(SaleInfo saleInfo){
        saleInfoService.addSaleInfo(saleInfo);
        return "test";
    }



}
