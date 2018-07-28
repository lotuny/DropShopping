package com.jnucst2015.dropshopping_shopmgmt.controller;

import com.jnucst2015.dropshopping_shopmgmt.entity.Shop;
import com.jnucst2015.dropshopping_shopmgmt.service.impl.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopServiceImpl shopService;



    @GetMapping("")
    public String getAllShop(HttpSession session, Model model){
        Integer sellerId = (Integer) session.getAttribute("userId");
        List<Shop> list = shopService.getShopBySellerID(sellerId);
        model.addAttribute("shops",list);
        return "shop-shopInput";
    }

    @PostMapping("/addShop")
    public String addShopByCompanyId(HttpSession session,Shop brand){
        Integer sellerId = (Integer) session.getAttribute("userId");
        brand.setSellerId(1);
        shopService.addShopInfo(brand);
        return "redirect:/shop";
    }
    @GetMapping("/delete/{id}")
    public String deleteByShopID(@PathVariable("id")Integer ID){
        shopService.deleteByShopID(ID);
        return "redirect:/shop";
    }

    @GetMapping("/update/{id}")
    public String updateShopByBrandId(@PathVariable("id") Integer id,Model model){
        Shop shop = shopService.getShopByID(id);
        model.addAttribute("shop",shop);
        return "shop-updateShop";
    }
    @PostMapping("/update")
    public String modifyShop(Shop shop){
        shopService.updateShopInfo(shop);
        return "redirect:/shop";
    }


}