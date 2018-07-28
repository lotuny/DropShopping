package com.jnucst2015.dropshopping_test.service.impl;

import com.jnucst2015.dropshopping.entity.Admin;
import com.jnucst2015.dropshopping.repository.AdminRepository;
import com.jnucst2015.dropshopping.util.PasswordUtil;
import com.jnucst2015.dropshopping_test.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;


    @Override
    public String adminLogin(String name, String password, HttpSession session) {
        Admin admin = adminRepository.findAdminByName(name);
        String pwd = admin.getPassword();
        if (pwd.equals(PasswordUtil.md5Password(password))){
            session.setAttribute("adminId",admin.getId());
            session.setAttribute("adminName",admin.getName());
            return "successfully";
        }else {
            session.removeAttribute("adminId");
            session.removeAttribute("adminName");
            return "failure";
        }
    }
}