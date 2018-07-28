package com.jnucst2015.dropshopping_test.controller;

import com.jnucst2015.dropshopping_test.service.AdminService;
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

    @PostMapping("admin_login")
    public String adminLogin(HttpSession session,
                             @RequestParam("name") String name,
                             @RequestParam("password") String password) {
        adminService.adminLogin(name, password, session);

        return "redirect:/background/2";
    }
}
