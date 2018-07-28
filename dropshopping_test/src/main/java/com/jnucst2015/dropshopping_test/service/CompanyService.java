package com.jnucst2015.dropshopping_test.service;


import com.jnucst2015.dropshopping.entity.Company;

import javax.servlet.http.HttpSession;

public interface CompanyService {

    /**
     * 公司注册
     * @param company
     * @return
     */
    String companyRegister(Company company);

    /**
     * 公司登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    String companyLogin(String username, String password, HttpSession session);

}