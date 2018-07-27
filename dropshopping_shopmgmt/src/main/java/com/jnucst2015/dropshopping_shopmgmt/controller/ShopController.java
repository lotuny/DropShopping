package com.jnucst2015.dropshopping_shopmgmt.controller;

import com.jnucst2015.dropshopping.entity.Shop;
import com.jnucst2015.dropshopping.service.impl.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class ShopController {

    @Autowired
    private ShopServiceImpl shopService;

    @GetMapping("")
    public String getAllShop(Model model){
        List<Shop> list = shopService.getAllShop();
        model.addAttribute("shops",list);

        return "index";
    }

    @PostMapping("/findByDifferentType")
    public String findPage(@RequestParam("searchText") String text,@RequestParam("type")Integer type,Model model){
        if(type==1){
            List<Shop> list = shopService.getShopByName(text);
            model.addAttribute("shops",list);
        }
        else if(type==3){
            Optional<Shop> list = shopService.getShopBySellerID(Integer.valueOf(text));
            model.addAttribute("shops",list);
        }
        return "findByDifferentType";
    }


    @PostMapping("/back")
    public String back(){
        return "redirect:/";
    }
    @GetMapping("addShop")
    public String addPage(){
        return "addShop";
    }

    @PostMapping("/addShop")
    public String addShop(Shop shop){
        shopService.addShopInfo(shop);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteShop(@PathVariable("id")Integer ID){
        shopService.deleteByShopID(ID);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateShop(@PathVariable("id")Integer ID,Model model){
        Shop shop=shopService.getShopByID(ID);
        model.addAttribute("shop",shop);
        return "updateShop";
    }

    @PostMapping("/update")
    public String modifyShop(Shop shop){
        shopService.updateShopInfo(shop);
        return "redirect:/";
    }

}