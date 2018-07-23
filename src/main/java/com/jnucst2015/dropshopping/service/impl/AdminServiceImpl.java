package com.jnucst2015.dropshopping.service.impl;

import com.jnucst2015.dropshopping.repository.AdminRepository;
import com.jnucst2015.dropshopping.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;


}
