package com.jnucst2015.shop_mgmt.controller;

import com.jnucst2015.shop_mgmt.entity.Brand;
import com.jnucst2015.shop_mgmt.service.Impl.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandServiceImpl brandService;
    @GetMapping("")
    public String getAllByCompanyId(Model model){
        List<Brand>list = brandService.getAllBrand();
        model.addAttribute("brand",list);
        return "brand-brandInput";
    }
    @PostMapping("/brand1")
    public String addBrandByCompanyId(Integer companyId,Brand brand){
        brand.setCompanyId(1);
        brandService.addBrandInfo(brand);
        return "redirect:/brand";
    }
    @GetMapping("/delete/{id}")
    public String deleteByBrandID(@PathVariable("id")Integer ID){
        brandService.deleteByBrandId(ID);
        return "redirect:/brand";
    }

    @GetMapping("/update/{id}")
    public String updateBrandByBrandId(@PathVariable("id") Integer id,Model model){
        Brand brand = brandService.getBrandById(id);
        model.addAttribute("brand",brand);
        return "brand-updateBrand";
    }
    @PostMapping("/update")
    public String modifyBrand(Brand brand){
        brandService.updateBrandInfo(brand);
        return "redirect:/brand";
    }

}
