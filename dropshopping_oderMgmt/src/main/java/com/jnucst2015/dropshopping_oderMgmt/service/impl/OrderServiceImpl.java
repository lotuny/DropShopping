package com.jnucst2015.dropshopping_oderMgmt.service.impl;

import com.jnucst2015.dropshopping.entity.Order;
import com.jnucst2015.dropshopping.entity.OrderItem;
import com.jnucst2015.dropshopping.entity.SaleInfo;
import com.jnucst2015.dropshopping.repository.OrderItemRepository;
import com.jnucst2015.dropshopping.repository.OrderRepository;
import com.jnucst2015.dropshopping.repository.SaleInfoRepository;
import com.jnucst2015.dropshopping_oderMgmt.service.OrderService;
import com.jnucst2015.dropshopping_oderMgmt.vo.OrderItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private SaleInfoRepository saleInfoRepository;

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public List<OrderItem> getAllByState(short state){ return orderItemRepository.selectByState(state); }

    @Override
    public OrderItem getOrderByID(Integer id) {
        return orderItemRepository.findById(id).get();
    }

    public OrderItem getOrderByOrderID(Integer orderId) {
        return orderItemRepository.selectByOrderItemId(orderId);
    }

//    @Override
//    public Order addOrder(Order order) {
//
//        int orderId = (int) System.currentTimeMillis();
//
////        for (OrderItem orderItem:order){
////            orderItem.setOrder_id(orderId);
////            orderItemRepository.save(orderItem);
////        }
//
//        return order;
//
//    }

    @Override
    public void deleteByOrderID(Integer orderId) {
        orderItemRepository.deleteById(orderId);
    }

    @Override
    public OrderItemVo updateOrderItemInfo(OrderItemVo orderItemVo) {
        OrderItem orderItem = new OrderItem();
        orderItem.setState(orderItemVo.getState());
        orderItem.setNotes(orderItemVo.getNotes());
        orderItem.setCount(orderItemVo.getCount());
        orderItem.setSale_info_id(orderItemVo.getSaleInfoId());
        orderItem.setOrder_id(orderItemVo.getOrderId());
        orderItem.setId(orderItemVo.getId());
        orderItemRepository.save(orderItem);

        Order order = new Order();
        order.setId(orderItemVo.getOrderId());
        order.setCreation_time(orderItemVo.getCreationTime());
        orderRepository.save(order);


//        SaleInfo saleInfo = new SaleInfo();
//        saleInfo.setId(orderItemVo.getSaleInfoId());
//        saleInfo.setDescription(orderItemVo.getDescription());
//        saleInfo.setName(orderItemVo.getName());
//        saleInfo.setPrice(orderItemVo.getPrice());
//        saleInfo.setCompanyId(orderItemVo.getCompanyId());
//        saleInfo.setSellerId(orderItemVo.getSellerId());
//        saleInfo.setShopId(orderItemVo.getShopId());
//        saleInfo.setMvoCmdtId(orderItemVo.getMvoCmdtId());
//        saleInfoRepository.save(saleInfo);

        return orderItemVo;
    }

    @Override
    public OrderItem showOrderItem(int orderItemId) {

        return orderItemRepository.selectByOrderItemId(orderItemId);

    }

    @Override
    public void deleteOrderItem(int orderItemId) {

        orderItemRepository.setOrderItemDelete(orderItemId);

    }

    @Override
    public List<OrderItemVo> showOrderItems () {
        List<OrderItemVo> orderItemVos = new ArrayList<OrderItemVo>();
//        List<OrderItem> orderItems = orderItemRepository.findAll();
        List<OrderItem> orderItems = orderItemRepository.findAllByStateBefore(3);
        for (OrderItem orderItem: orderItems) {
            OrderItemVo orderItemVo = new OrderItemVo();
            orderItemVo.setId(orderItem.getId());
            orderItemVo.setCount(orderItem.getCount());
            orderItemVo.setNotes(orderItem.getNotes());
            orderItemVo.setState(orderItem.getState());

            Order order = orderRepository.findOrderById(orderItem.getOrder_id());
            if (order == null) { order = new Order();}
//            else { orderItemVo.setOrder(order);}
            orderItemVo.setOrderId(order.getId());
            orderItemVo.setCreationTime(order.getCreation_time());

            SaleInfo saleInfo = saleInfoRepository.findSaleInfoById(orderItem.getSale_info_id());
            if (saleInfo == null) { saleInfo = new SaleInfo();}
//            else { orderItemVo.setSale_info(saleInfo);}
            orderItemVo.setSaleInfoId(saleInfo.getId());
            orderItemVo.setDescription(saleInfo.getDescription());
            orderItemVo.setName(saleInfo.getName());
            orderItemVo.setPrice(saleInfo.getPrice());
            orderItemVo.setCompanyId(saleInfo.getCompanyId());
            orderItemVo.setSellerId(saleInfo.getSellerId());
            orderItemVo.setShopId(saleInfo.getShopId());
            orderItemVo.setMvoCmdtId(saleInfo.getMvoCmdtId());

            orderItemVos.add(orderItemVo);
        }

        return orderItemVos;

    }
//    @Override
//    public List<OrderItem> updateOrderInfo(List<OrderItem> order) {
//        for (OrderItem orderItem: order) {
//            orderItemRepository.save(orderItem);
//        }
//        return order;
//    }



}
