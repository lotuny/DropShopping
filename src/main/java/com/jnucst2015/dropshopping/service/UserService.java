package com.jnucst2015.dropshopping.service;

import com.jnucst2015.dropshopping.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {

    /**
     * 用户注册
     * @param user
     * @return
     */
    String userRegister(User user);

    /**
     * 得到所有用户
     * @return
     */
    List<User> listUser();

    /**
     * 通过username查找用户
     * @param username
     * @return
     */
    User getOneByUsername(String username);

    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    String userLogin(String username, String password, HttpSession session);
}
