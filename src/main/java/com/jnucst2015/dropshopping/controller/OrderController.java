package com.jnucst2015.dropshopping.controller;


import com.jnucst2015.dropshopping.entity.OrderForm;
import com.jnucst2015.dropshopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 根据主键进行删除，删除后跳转到列表页面
     * @param orderId
     * @return
     */
    @GetMapping("delete/{id}")
    public String deleteStu(@PathVariable("id") Integer orderId){
        orderService.deleteByOrderID(orderId);
        return "redirect:/"; // 删除完成后生定向到首页即：列表页面（index）
    }

    /**
     * 根据主键找到要修改的记录，并通过Model将数据传给updateStu页面，并显示在文本框中。
     * @param orderId
     * @param model
     * @return
     */
    @GetMapping("update/{id}")
    public String modifStu(@PathVariable("id") Integer orderId,
                           Model model){
        OrderForm orderForm = orderService.getOrderByID(orderId);
        model.addAttribute("orderForm", orderForm);
        return "updateOrderForm";
    }

    /**
     * 接受修改的数据并进行修改操作。
     * @param orderForm
     * @return
     */
    @PostMapping("update")
    public String modifStu(OrderForm orderForm){
        orderService.updateOrderInfo(orderForm);
        return "redirect:/"; // 修改完成后重定向到首页即：列表页面（index）
    }


    /**
     * 返回添加学生的页面
     * @return
     */
    @GetMapping("add")
    public String addPage(){
        return "addOrder";
    }
    /**
     * 点击添加后接受提交过来的数据，并进行新添数据操作
     * @param orderForm
     * @return
     */
    @PostMapping("add")
    public String addOrder(OrderForm orderForm){
        orderService.addOrderInfo(orderForm);
        return "redirect:/";  //添加完成后重定向到首页即：列表页面（index）
    }

    @GetMapping
    public String getAllStu(Model model){
       List<OrderForm> lists = orderService.getAllOrder();
       model.addAttribute("orders",lists);

//        model.addAttribute("test",123456);
//
//        order order = new order();
//        order.setStuName("James");
//        order.setStuPhone("13556894843");
//        order.setStuPwd("123456");
//        order.setStuAddress("USA");
//
//        model.addAttribute("aaa",order);

        return "index";
    }



}
