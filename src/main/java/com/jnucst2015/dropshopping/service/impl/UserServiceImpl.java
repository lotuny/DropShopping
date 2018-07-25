package com.jnucst2015.dropshopping.service.impl;

import com.jnucst2015.dropshopping.entity.User;
import com.jnucst2015.dropshopping.repository.UserRepository;
import com.jnucst2015.dropshopping.service.UserService;
import com.jnucst2015.dropshopping.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String userRegister(User user){
        String plainPwd = user.getPassword();
        user.setPassword(PasswordUtil.md5Password(plainPwd));
        System.out.print(user);
        if (userRepository.saveAndFlush(user)!=null)
            return "Register Successfully";
        else return "Error";
    }

    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }

    @Override
    public User getOneByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public String userLogin(String username, String password, HttpSession session) {
        User user = userRepository.findUserByUsername(username);
        int userId = user.getId();
        String pwd = user.getPassword();
        if (pwd.equals(PasswordUtil.md5Password(password))){
            session.setAttribute("userId",userId);
            session.setAttribute("username",username);
            return "successful";
        }else {
            session.removeAttribute("username");
            session.removeAttribute("userId");
            return "failure";
        }
    }


}
