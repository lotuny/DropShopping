package com.jnucst2015.dropshopping.service;

import com.jnucst2015.dropshopping.entity.Seller;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface SellerService {

    /**
     * 用户注册
     * @param seller
     * @return
     */
    String sellerRegister(Seller seller);

    /**
     * 得到所有用户
     * @return
     */
    List<Seller> listSeller();

    /**
     * 通过username查找用户
     * @param username
     * @return
     */
    Seller getOneByUsername(String username);

    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    String sellerLogin(String username, String password, HttpSession session);


    void updateSellerInfo(Seller seller);

    Seller findById(Integer id);

    void topup(Integer topup_num, Integer userId, String pay_pwd);

    void withdraw(Integer withdraw_num, Integer userId, String pay_pwd);

    //new
    Seller getSellerById(Integer Id);
    List<Seller> getAllSeller();
    Seller updateSeller(Seller seller);
    void deleteBySellerId(Integer id);
}
