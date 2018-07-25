package com.jnucst2015.dropshopping.service;

import com.jnucst2015.dropshopping.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {

    String userRegister(User user);

    List<User> listUser();

    User getOneByUsername(String username);

    String userLogin(String username, String password, HttpSession session);
}
