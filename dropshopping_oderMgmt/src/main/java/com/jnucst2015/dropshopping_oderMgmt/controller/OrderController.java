package com.jnucst2015.dropshopping_oderMgmt.controller;


import com.jnucst2015.dropshopping.entity.Order;
import com.jnucst2015.dropshopping.entity.OrderItem;
import com.jnucst2015.dropshopping_oderMgmt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("order/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("delete/{id}")
    public String deleteOrder(@PathVariable("id") Integer orderId){
        orderService.deleteByOrderID(orderId);
        return "redirect:/order";
    }

//    @GetMapping("update/{orderId}")
//    public String modifOrder(@PathVariable("orderId") Integer orderId,
//                           Model model){
//        List<OrderItem> order = orderService.getOrderByOrderID(orderId);
//        model.addAttribute("orderForm", order);
//        return "updateOrder";
//    }
//
//    @PostMapping("update")
//    public String modifOrder(Order order){
//        orderService.updateOrderInfo(order);
//        return "redirect:/order/";
//    }
//
//    @GetMapping("add")
//    public String addPage(){
//        return "addOrder";
//    }
//
//    @PostMapping("add")
//    public String addOrder(@ModelAttribute Order order){
//        orderService.addOrder(order);
//        return "redirect:/order/";
//    }

    @GetMapping
    public String getAllOrders(Model model){
       List<OrderItem> lists = orderService.getAllOrder();
       model.addAttribute("orders",lists);

        return "showOrder";
    }

    @GetMapping("state/{state}")
    public String getAllOrdersByState(@PathVariable("state") short state, Model model){

        List<OrderItem> lists = orderService.getAllByState(state);
        model.addAttribute("orders",lists);

        return "showOrder";
    }



}
