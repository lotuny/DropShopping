package com.jnucst2015.dropshopping_cmdtmgmt.controller;

import com.jnucst2015.dropshopping.entity.MvoCommodity;
import com.jnucst2015.dropshopping.entity.Shop;
import com.jnucst2015.dropshopping.repository.MvoCommodityRepository;
import com.jnucst2015.dropshopping.repository.SaleInfoRepository;
import com.jnucst2015.dropshopping.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RestQueryController {

    @Autowired
    private MvoCommodityRepository mvoCommodityRepository;

    @Autowired
    private SaleInfoRepository saleInfoRepository;

    @Autowired
    private CompanyService companyService;

    @GetMapping(value = "/commodity/get/{keyName}")
    public List<MvoCommodity> LIKEquery(@PathVariable(value = "keyName") String keyName, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return mvoCommodityRepository.LIKEquery(keyName);
    }

    @GetMapping(value = "/commodity/getAll")
    public List<MvoCommodity> gets(HttpServletResponse response){
        List<MvoCommodity> list = mvoCommodityRepository.findAll();
        response.setHeader("Access-Control-Allow-Origin", "*");
        return mvoCommodityRepository.findAll();
    }

//    @GetMapping("/{sellerId}")
//    public Map<Integer, String> a(@PathVariable("sellerId") Integer sellerId){
//        HashMap<Integer, String> map = new HashMap<>();
//        List<Shop> shops= shopService.findShopBySellerId(sellerId);
//        for(Shop shop:shops){
//            map.put(shop.getId(), shop.getName());
//        }
//
//    }

    @GetMapping("/shop/{sellerId}")
    public List<Map<String, Object>> getShops(@PathVariable("sellerId") Integer sellerId){
        return saleInfoRepository.query(sellerId);
    }



}
