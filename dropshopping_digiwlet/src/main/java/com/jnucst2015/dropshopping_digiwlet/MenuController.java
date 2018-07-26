package com.jnucst2015.dropshopping_digiwlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("background")
public class MenuController {

    @GetMapping("index")
    public String showBackgroundMenu(HttpSession session) {
        session.setAttribute("role", 1);
        return "index_background";
    }
}
