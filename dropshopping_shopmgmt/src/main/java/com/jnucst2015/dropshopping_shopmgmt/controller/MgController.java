package com.jnucst2015.dropshopping_shopmgmt.controller;

import com.jnucst2015.dropshopping.entity.Company;
import com.jnucst2015.dropshopping.entity.Seller;
import com.jnucst2015.dropshopping.service.CompanyService;
import com.jnucst2015.dropshopping.service.impl.SellerServiceImpl;
import com.jnucst2015.dropshopping.entity.Brand;
import com.jnucst2015.dropshopping.entity.Shop;
import com.jnucst2015.dropshopping.service.impl.BrandServiceImpl;
import com.jnucst2015.dropshopping.service.impl.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("mg")
public class MgController {
    @Autowired
    private BrandServiceImpl brandService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ShopServiceImpl shopService;
    @Autowired
    private SellerServiceImpl sellerService;

//shop and seller
    @GetMapping("/seller")
    public String getAllSellerBySellerId(Model model){
        List<Seller> list = sellerService.getAllSeller();
        model.addAttribute("sellers",list);
//        List<Brand> list = brandService.getGroupByCompanyId();
//        model.addAttribute("companyId",list);
        return "shop-shopList";
    }

    @GetMapping("seller/mgdelete/{id}")
    public String deleteBySellerIDMg(@PathVariable("id")Integer ID){
        sellerService.deleteBySellerId(ID);
        return "redirect:/mg/seller";
    }

    @GetMapping("seller/mgupdate/{id}")
    public String updateBySellerIdMg(@PathVariable("id") Integer companyId,Model model){

        List<Shop>list = shopService.getShopBySellerID(companyId);
        model.addAttribute("shops",list);
        return "shop-shopInputMg";
    }

    @PostMapping("seller/updateShopMg")
    public String updateBrandByBrandIdMg(@RequestParam("sellerId")Integer id, Shop shop){
        shopService.updateShopInfo(shop);
        return "redirect:/mg/seller/mgupdate/" + id.toString();
    }

    @GetMapping("seller/deleteShopMg/{id}")
    public String deleteByShopIDMg (@PathVariable("id")Integer ID){
        Shop shop = shopService.getShopByID(ID);
        Integer sellerId = shop.getSellerId();
        shopService.deleteByShopID(ID);
        return "redirect:/mg/seller/mgupdate/"+sellerId.toString();
    }

    //brand and company
    @GetMapping("/company")
    public String getAllCompanyByCompanyId(Model model){
        List<Company> list = companyService.getAllCompany();
        model.addAttribute("companys",list);
        return "brand-brandMg";
    }

    @GetMapping("/company/mgdelete/{id}")
    public String deleteByCompanyID(@PathVariable("id")Integer ID){
        companyService.deleteByCompanyId(ID);
        return "redirect:/mg/company";
    }

    @GetMapping("company/mgupdate/{id}")
    public String updateByCompanyId(@PathVariable("id") Integer companyId,Model model){
        Company company = companyService.getCompanyById(companyId);
        model.addAttribute("company",company);
        List<Brand>list = brandService.getBrandByCompanyId(companyId);
        model.addAttribute("brand",list);
        return "brand-brandInputMg";
    }

    @PostMapping("company/updateBrandMg")
    public String updateBrandByBrandIdMg(@RequestParam("companyId")Integer id, Brand brand){
        brandService.updateBrandInfo(brand);
        return "redirect:/mg/company/mgupdate/" + id.toString();
    }

    @GetMapping("company/branddelete/{id}")
    public String deleteByBrandIDMg (@PathVariable("id")Integer ID){
        Brand brand = brandService.getBrandById(ID);
        Integer companyId = brand.getCompanyId();
        brandService.deleteByBrandId(ID);

        return "redirect:/mg/company/mgupdate/"+companyId.toString();
    }

    @PostMapping("company/updateCompany")
    public String updateCompany(@RequestParam("id")Integer id,Company company){
        Company c =companyService.getCompanyById(company.getId());
        c.setDescription(company.getDescription());
        c.setName(company.getName());
        companyService.updateCompany(c);
        return "redirect:/mg/company/mgupdate/"+company.getId();
    }
}
