package com.jnucst2015.dropshopping_uam.controller;

import com.jnucst2015.dropshopping.entity.User;
import com.jnucst2015.dropshopping.service.UserService;
import com.jnucst2015.dropshopping.util.PasswordUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class MyController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getHome(Session session){
        return "index";
    }

//    @GetMapping("/index")
//    public String getIndex(Session session){
//        if (session.getProperties().get("username")==null){
//            return "redirect:/";
//        }else{
//            return "index";
//        }
//    }

    @GetMapping("user/register")
    public String getUserRegister(){
        return "register";
    }

    @PostMapping("user/register")
    public String register(User user){
        String result = userService.userRegister(user);
        return "redirect:/";
    }

    @GetMapping("/user/login")
    public String getUserLogin(Session session){
        if (session==null){
            return "index";
        }
        return "login";
    }

    @PostMapping("/user/login")
    public String login(HttpSession session, @RequestParam("username") String username, @RequestParam("password") String password) {
        userService.userLogin(username,password, session);
        return "redirect:/";
    }

}
