package com.jnucst2015.dropshopping_oderMgmt.controller;


import com.jnucst2015.dropshopping.entity.OrderItem;
import com.jnucst2015.dropshopping_oderMgmt.service.OrderService;
import com.jnucst2015.dropshopping_oderMgmt.vo.OrderItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("orderPage")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("delete/{id}")
    public String deleteOrder(@PathVariable("id") Integer orderId){
        orderService.deleteOrderItem(orderId);
        return "redirect:/orderPage";
    }

    @GetMapping("update/{orderItemId}")
    public String modifOrder(@PathVariable("orderItemId") Integer orderItemId,
                           Model model){

        model.addAttribute("orderItemId", orderItemId);
        return "updateOrder";

    }

    @GetMapping("add")
    public String addfOrder(Model model){

        return "addOrder";

    }

    @PostMapping("update")
    public String modifOrder(OrderItemVo orderItemVo){
        orderService.updateOrderItemInfo(orderItemVo);
        return "redirect:/orderPage";
    }

    @PostMapping("add")
    public String addOrder(OrderItemVo orderItemVo){
        orderService.updateOrderItemInfo(orderItemVo);
        return "redirect:/orderPage";
    }

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
    public String getOrderItemInfos(Model model) {
        List<OrderItemVo> orderItemVos = orderService.showOrderItems();

        model.addAttribute("oderItemsVos", orderItemVos);
        return "showOrder";
    }

    @GetMapping("/{userId}")
    public String getOrderItemInfos(@PathVariable("userId") Integer userId,  Model model) {
        List<OrderItemVo> orderItemVos = orderService.showOrderItems();

        model.addAttribute("oderItemsVos", orderItemVos);
        return "showOrder";
    }
//
//    @GetMapping
//    public String getAllOrders(Model model){
//       List<OrderItem> lists = orderService.getAllOrder();
//       model.addAttribute("oderItems",lists);
//
//        return "showOrder";
//    }

    @GetMapping("state/{state}")
    public String getAllOrdersByState(@PathVariable("state") short state, Model model){

        List<OrderItem> lists = orderService.getAllByState(state);
        model.addAttribute("oderItems",lists);

        return "showOrder";
    }



}
