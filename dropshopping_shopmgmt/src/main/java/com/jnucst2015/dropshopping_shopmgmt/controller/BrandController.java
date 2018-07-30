package com.jnucst2015.dropshopping_shopmgmt.controller;

import com.jnucst2015.dropshopping.entity.Company;
import com.jnucst2015.dropshopping_shopmgmt.entity.Brand;
import com.jnucst2015.dropshopping_shopmgmt.service.impl.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandServiceImpl brandService;
    @Autowired
    private CompanyService companyService;
    @GetMapping("")
    public String getAllByCompanyId(HttpSession session,Model model){
        Integer companyId =(Integer) session.getAttribute("userId");
            Company company = companyService.getCompanyById(companyId);
            model.addAttribute("company",company);
        List<Brand>list = brandService.getBrandByCompanyId(companyId);
        model.addAttribute("brand",list);
        return "brand-brandInput";
    }

    @PostMapping("/addBrand")
    public String addBrandByCompanyId(HttpSession session,Brand brand){
        Integer companyId =(Integer) session.getAttribute("userId");
        brand.setCompanyId(companyId);
        brandService.addBrandInfo(brand);
        return "redirect:/brand";
    }
    @GetMapping("/delete/{id}")
    public String deleteByBrandID(@PathVariable("id")Integer ID){
        brandService.deleteByBrandId(ID);
        return "redirect:/brand";
    }

    @PostMapping("/updateBrand")
    public String updateBrandByBrandId(Brand brand){
        brandService.updateBrandInfo(brand);
        return "redirect:/brand";
    }
    @PostMapping("/updateCompany")
    public String updateCompany(@RequestParam("id")Integer id,Company company){
        Company c =companyService.getCompanyById(company.getId());
        c.setDescription(company.getDescription());
        c.setName(company.getName());
        companyService.updateCompany(c);
        return "redirect:/brand";
    }




}