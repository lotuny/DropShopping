package com.jnucst2015.dropshopping.service;


import com.jnucst2015.dropshopping.entity.Company;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    Company findById(Integer id);

    void topup(Integer topup_num, Integer userId, String pay_pwd);

    void withdraw(Integer withdraw_num, Integer userId, String pay_pwd);

    //new
    Company getCompanyById(Integer Id);
    List<Company> getAllCompany();
    Company updateCompany(Company company);
    void deleteByCompanyId(Integer id);
    //
}