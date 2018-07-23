package com.jnucst2015.dropshopping.entity;

import javax.persistence.*;

@Entity
public class OrderForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "int(11) COMMENT '商品id'")
    private Integer commodity_id;
    @Column(columnDefinition = "int(11) COMMENT '店铺id'")
    private Integer shop_id;
    @Column(columnDefinition = "varchar(11) COMMENT '发送方姓名'")
    private String sender_name;
    @Column(columnDefinition = "varchar(11) COMMENT '发送方地址'")
    private String sender_address;
    @Column(columnDefinition = "varchar(11) COMMENT '发送方电话'")
    private Integer sender_phone;
    @Column(columnDefinition = "varchar(11) COMMENT '接收方姓名'")
    private String receiver_name;
    @Column(columnDefinition = "varchar(11) COMMENT '接收方地址'")
    private String receiver_address;
    @Column(columnDefinition = "varchar(11) COMMENT '接收方电话'")
    private Integer receiver_phone;
    @Column(columnDefinition = "varchar(255) COMMENT '备注'")
    private String notes;
    @Column(columnDefinition = "tinyint COMMENT '商品id'")
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(Integer commodity_id) {
        this.commodity_id = commodity_id;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getSender_address() {
        return sender_address;
    }

    public void setSender_address(String sender_address) {
        this.sender_address = sender_address;
    }

    public Integer getSender_phone() {
        return sender_phone;
    }

    public void setSender_phone(Integer sender_phone) {
        this.sender_phone = sender_phone;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getReceiver_address() {
        return receiver_address;
    }

    public void setReceiver_address(String receiver_address) {
        this.receiver_address = receiver_address;
    }

    public Integer getReceiver_phone() {
        return receiver_phone;
    }

    public void setReceiver_phone(Integer receiver_phone) {
        this.receiver_phone = receiver_phone;
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