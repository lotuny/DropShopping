package com.jnucst2015.dropshopping_test.service;

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
}
