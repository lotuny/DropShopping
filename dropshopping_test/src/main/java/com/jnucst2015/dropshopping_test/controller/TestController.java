package com.jnucst2015.dropshopping_test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {


    @GetMapping("testlogin/{name}")
    @ResponseBody
    public Object login(@PathVariable("name") String name, HttpServletRequest request){
        request.getSession().setAttribute("login", name);
        return "登录成功";
    }

    @GetMapping("testlogin/getSession")
    @ResponseBody
    public Object getLoginSession(HttpServletRequest request) {
        Object result = request.getSession().getAttribute("login");
        return result != null ? result : "session没有获取到login对应的数据";
    }


}
