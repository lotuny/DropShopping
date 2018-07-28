package com.jnucst2015.dropshopping_shopmgmt.controller;

import com.jnucst2015.dropshopping.entity.Company;
import com.jnucst2015.dropshopping.service.CompanyService;
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
        if(session.getAttribute("role") == "管理员"){
             return "brand-brandMg";
        }
        else{
        Integer companyId =(Integer) session.getAttribute("userId");
            Company company = companyService.getCompanyById(1);
            model.addAttribute("company",company);
        List<Brand>list = brandService.getBrandByCompanyId(1);
        model.addAttribute("brand",list);
        return "brand-brandInput";
        }
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

    @GetMapping("/update/{id}")
    public String updateBrandByBrandId(@PathVariable("id") Integer id,Model model){
        Brand brand = brandService.getBrandById(id);
        model.addAttribute("brand",brand);
        return "brand-updateBrand";
    }


//    @GetMapping("/update")
//    public String updateBrandByBrandId(HttpSession session){
//        return "redirect:/update/"+session.getAttribute("userId");
//    }
    @PostMapping("/update")
    public String modifyBrand(Brand brand){
        brandService.updateBrandInfo(brand);
        return "redirect:/brand";
    }
    @GetMapping("/mg")
    public String getAllCompanyByCompanyId(Model model){
        List<Company> list = companyService.getAllCompany();
        model.addAttribute("companys",list);
//        List<Brand> list = brandService.getGroupByCompanyId();
//        model.addAttribute("companyId",list);
        return "brand-brandMg";
    }

    @GetMapping("mgdelete/{id}")
    public String deleteByCompanyID(@PathVariable("id")Integer ID){
        brandService.deleteByCompanyId(ID);
        return "redirect:/brand/mg";
    }

    @GetMapping("mgupdate/{id}")
    public String updateByCompanyId(@PathVariable("id") Integer companyId,Model model){
        Company company = companyService.getCompanyById(companyId);
        model.addAttribute("company",company);
        List<Brand>list = brandService.getBrandByCompanyId(companyId);
        model.addAttribute("brand",list);
        return "brand-brandInputMg";
    }

}