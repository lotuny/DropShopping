package com.jnucst2015.dropshopping_roleMgmt.controller;

import com.jnucst2015.dropshopping.entity.Company;
import com.jnucst2015.dropshopping.entity.SaleInfo;
import com.jnucst2015.dropshopping.entity.Seller;
import com.jnucst2015.dropshopping.entity.User;
import com.jnucst2015.dropshopping.service.CompanyService;
import com.jnucst2015.dropshopping.service.SaleInfoService;
import com.jnucst2015.dropshopping.service.SellerService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private SaleInfoService saleInfoService;

    @GetMapping("/")
    public String getHome(Session session) {
        return "index";
    }

//    @GetMapping("/index")
//    public String getIndex(Session session){
//        if (session.getProperties().get("username")==null){
//            return "redirect:/";
//        }else{
//            return "index";
//        }
//    }

    @GetMapping("user/register")
    public String getUserRegister() {
        return "register";
    }

    @PostMapping("user/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email,
                           @RequestParam("telephone") String telephone,
                           @RequestParam("role") String role) {
        User user = new User(username, password, email, telephone);
        switch (role) {
            case "借卖商":
                Seller seller = new Seller(user);
                sellerService.sellerRegister(seller);
                break;
            case "品牌商":
                Company company = new Company(user);
                companyService.companyRegister(company);
                break;
        }

        return "redirect:/";
    }

    @GetMapping("/user/login")
    public String getUserLogin(Session session) {
        if (session == null) {
            return "index";
        }
        return "login";
    }

    @PostMapping("/user/login")
    public String login(HttpSession session,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("role") String role) {
        switch (role) {
            case "借卖商":
                sellerService.sellerLogin(username, password, session);
                break;
            case "品牌商":
                companyService.companyLogin(username, password, session);
                break;
        }
        return "redirect:/";
    }

    @GetMapping("/search/{keyName}")
    public String search(@PathVariable(value = "keyName") String keyName, Model model) {
        model.addAttribute(keyName);
        return "searchresult";
    }

    @GetMapping("/user/exit")
    public String exit(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/user/seller/info")
    public String sellerInfor() {
        return "redirect:/background/index/1";
    }

    @PostMapping("/user/seller/info")
    public String updateInfo(Seller seller) {
        sellerService.updateSellerInfo(seller);
        return "redirect:/";
    }


}
