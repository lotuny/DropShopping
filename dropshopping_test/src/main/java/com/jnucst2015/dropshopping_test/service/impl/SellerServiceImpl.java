package com.jnucst2015.dropshopping_test.service.impl;

import com.jnucst2015.dropshopping.entity.Seller;
import com.jnucst2015.dropshopping.repository.SellerRepository;
import com.jnucst2015.dropshopping.util.PasswordUtil;
import com.jnucst2015.dropshopping_test.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public String sellerRegister(Seller seller){
        String plainPwd = seller.getPassword();
        seller.setPassword(PasswordUtil.md5Password(plainPwd));
        if (sellerRepository.saveAndFlush(seller)!=null)
            return "Register Successfully";
        else return "Error";
    }

    @Override
    public List<Seller> listSeller() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller getOneByUsername(String username) {
        return sellerRepository.findSellerByUsername(username);
    }

    @Override
    public String sellerLogin(String username, String password, HttpSession session) {
        Seller seller = sellerRepository.findSellerByUsername(username);

        String pwd = seller.getPassword();
        if (pwd.equals(PasswordUtil.md5Password(password))){
            session.setAttribute("userId",seller.getId());
            session.setAttribute("username",username);
            session.setAttribute("role","seller");
            return "successful";
        }else {
            session.removeAttribute("username");
            session.removeAttribute("userId");
            session.removeAttribute("role");
            return "failure";
        }
    }

    @Override
    public void updateSellerInfo(Seller seller){
        String plainPwd = seller.getPassword();
        seller.setPassword(PasswordUtil.md5Password(plainPwd));
        sellerRepository.saveAndFlush(seller);
    }

    @Override
    public Seller findById(Integer id) {
        return sellerRepository.findById(id).get();
    }

    @Override
    public void topup(Integer topup_num, Integer userId, String pay_pwd) {
        Seller seller = findById(userId);
        if (seller.getPayPwd().equals(pay_pwd)) {
            seller.setBalance(seller.getBalance() + topup_num);
        }
    }

    @Override
    public void withdraw(Integer withdraw_num, Integer userId, String pay_pwd) {
        Seller seller = findById(userId);
        if (seller.getPayPwd().equals(pay_pwd)) {
            seller.setBalance(seller.getBalance() - withdraw_num);
        }
    }


}