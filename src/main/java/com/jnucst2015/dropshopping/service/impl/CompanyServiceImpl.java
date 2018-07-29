package com.jnucst2015.dropshopping.service.impl;

import com.jnucst2015.dropshopping.entity.Company;
import com.jnucst2015.dropshopping.repository.CompanyRepository;
import com.jnucst2015.dropshopping.util.PasswordUtil;
import com.jnucst2015.dropshopping.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    //new
    @Override
    public Company getCompanyById(Integer Id) {
        return companyRepository.findById(Id).get();
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company updateCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void deleteByCompanyId(Integer id) {
        companyRepository.deleteById(id);
    }

    //
    @Override
    public String companyRegister(Company company) {
        String plainPwd = company.getPassword();
        company.setPassword(PasswordUtil.md5Password(plainPwd));
        companyRepository.saveAndFlush(company);
        return "";
    }

    @Override
    public String companyLogin(String username, String password, HttpSession session) {
        Company company = companyRepository.findCompanyByUsername(username);
        String pwd = company.getPassword();
        if (pwd.equals(PasswordUtil.md5Password(password))){
            session.setAttribute("companyId",company.getId());
            session.setAttribute("username",username);
            session.setAttribute("role","company");
            return "successful";
        }else {
            session.removeAttribute("username");
            session.removeAttribute("companyId");
            session.removeAttribute("role");
            return "failure";
        }
    }


}