package com.jnucst2015.dropshopping.vo;

import com.jnucst2015.dropshopping.entity.SaleInfo;

import java.sql.Timestamp;


public class OrderItemVo {//订单中的单项
    private Integer id;
//    private Order order;
    private Integer orderId;
    private Timestamp creationTime;
//    private SaleInfo sale_info;
    private Integer saleInfoId;
    private String name;
    private Integer price;
    private String description;
    private Integer companyId;
    private Integer sellerId;
    private Integer shopId;
    private Integer mvoCmdtId;

    private Integer count;
    private String notes;
    private Integer state;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getSaleInfoId() {
        return saleInfoId;
    }

    public void setSaleInfoId(Integer saleInfoId) {
        this.saleInfoId = saleInfoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getMvoCmdtId() {
        return mvoCmdtId;
    }

    public void setMvoCmdtId(Integer mvoCmdtId) {
        this.mvoCmdtId = mvoCmdtId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}