package com.jnucst2015.dropshopping_test.controller;


import com.jnucst2015.dropshopping.entity.OrderItem;
import com.jnucst2015.dropshopping_test.service.OrderService;
import com.jnucst2015.dropshopping_test.vo.OrderItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("orderPage")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("delete/{id}")
    public String deleteOrder(@PathVariable("id") Integer orderId){
        orderService.changeState(4 ,orderId);
        return "redirect:/orderPage";
    }

    @GetMapping("Ship/{id}")
    public String shipOrder(@PathVariable("id") Integer orderId){
        orderService.changeState(2 ,orderId);
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
    public String getOrderItemInfos(Model model, HttpSession session) {

        String role = (String) session.getAttribute("role");
        Integer userId = (Integer) session.getAttribute("userId");
        if (role.equals("seller")) {
            List<OrderItemVo> orderItemVos = orderService.showOrderItemsBySellerId(userId);
            model.addAttribute("oderItemsVos", orderItemVos);
            return "showBVOOrder";
        } else if (role.equals("company")) {
            List<OrderItemVo> orderItemVos = orderService.showOrderItemsByCompanyId(userId);
            model.addAttribute("oderItemsVos", orderItemVos);
            return "showCompanyOrder";
        } else {
            List<OrderItemVo> orderItemVos = orderService.showOrderItems();
            model.addAttribute("oderItemsVos", orderItemVos);
            return "showOrder";
        }

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
