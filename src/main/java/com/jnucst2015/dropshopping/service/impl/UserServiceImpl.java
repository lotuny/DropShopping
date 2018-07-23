package com.jnucst2015.dropshopping.service.impl;

import com.jnucst2015.dropshopping.entity.User;
import com.jnucst2015.dropshopping.repository.UserRepository;
import com.jnucst2015.dropshopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String userRegister(User user){
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


}
