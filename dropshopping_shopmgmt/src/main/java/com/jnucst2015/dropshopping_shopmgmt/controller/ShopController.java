package com.jnucst2015.dropshopping_shopmgmt.controller;

import com.jnucst2015.dropshopping.entity.Company;
import com.jnucst2015.dropshopping.entity.Seller;
import com.jnucst2015.dropshopping.service.impl.SellerServiceImpl;
import com.jnucst2015.dropshopping_shopmgmt.entity.Brand;
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
    @Autowired
    private SellerServiceImpl sellerService;


    @GetMapping("")
    public String getAllShop(HttpSession session, Model model){
        Integer sellerId = (Integer) session.getAttribute("userId");
        List<Shop> list = shopService.getShopBySellerID(sellerId);
        model.addAttribute("shops",list);
        return "shop-shopInput";
    }

    @PostMapping("/addShop")
    public String addShopByCompanyId(HttpSession session,Shop shop){
        Integer sellerId = (Integer) session.getAttribute("userId");
        shop.setSellerId(sellerId);
        shopService.addShopInfo(shop);
        return "redirect:/shop";
    }
    @GetMapping("/delete/{id}")
    public String deleteByShopID(@PathVariable("id")Integer ID){
        shopService.deleteByShopID(ID);
        return "redirect:/shop";
    }

    @PostMapping("/updateShop")
    public String updateShopById(Shop shop){
        shopService.updateShopInfo(shop);
        return "redirect:/shop";
    }



}