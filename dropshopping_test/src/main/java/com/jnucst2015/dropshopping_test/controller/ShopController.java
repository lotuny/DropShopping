package com.jnucst2015.dropshopping_test.controller;

import com.jnucst2015.dropshopping.entity.Shop;
import com.jnucst2015.dropshopping_test.service.impl.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopServiceImpl shopService;



    @GetMapping("")
    public String getAllShop( Model model){
        List<Shop> list = shopService.getAllShop();
        model.addAttribute("shops",list);
        return "shop-shopInput";
    }

    @PostMapping("/addShop")
    public String addBrandByCompanyId(Integer companyId,Shop brand){
        brand.setSellerId(1);
        shopService.addShopInfo(brand);
        return "redirect:/shop";
    }
    @GetMapping("/delete/{id}")
    public String deleteByBrandID(@PathVariable("id")Integer ID){
        shopService.deleteByShopID(ID);
        return "redirect:/shop";
    }

    @GetMapping("/update/{id}")
    public String updateBrandByBrandId(@PathVariable("id") Integer id,Model model){
        Shop shop = shopService.getShopByID(id);
        model.addAttribute("shop",shop);
        return "shop-updateShop";
    }
    @PostMapping("/update")
    public String modifyBrand(Shop shop){
        shopService.updateShopInfo(shop);
        return "redirect:/shop";
    }
    @GetMapping("Mg")
    public String getAllShopBySellerId(Integer Id,Model model){
        List<Shop> list = shopService.getShopBySellerID(Id);
        model.addAttribute("shops",list);
        return "brand-brandMg";
    }

}