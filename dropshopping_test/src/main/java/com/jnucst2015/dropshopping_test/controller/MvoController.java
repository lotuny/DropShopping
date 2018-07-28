package com.jnucst2015.dropshopping_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvoController
{
    @GetMapping("/addMvo")
    private String addMvo() { return "onsale"; }
}
