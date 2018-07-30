package com.jnucst2015.dropshopping_roleMgmt.controller;

import com.jnucst2015.dropshopping.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("admin_login")
    public String adminLogin() {
        return "admin_login";
    }

    //remains to modify
    @PostMapping("admin_login")
    public String adminLogin(HttpSession session,
                             @RequestParam("username") String name,
                             @RequestParam("password") String password) {
        adminService.adminLogin(name, password, session);

        return "redirect:/background/2";
    }
}
