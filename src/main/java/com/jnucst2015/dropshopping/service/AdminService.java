package com.jnucst2015.dropshopping.service;

import javax.servlet.http.HttpSession;

public interface AdminService {

    /**
     * 管理员登录
     * @param name
     * @param password
     * @param session
     * @return
     */
    String adminLogin(String name, String password, HttpSession session);

}