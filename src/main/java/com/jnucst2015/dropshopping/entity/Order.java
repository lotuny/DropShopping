package com.jnucst2015.dropshopping.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "order_form")
public class Order {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBvo_user_id() {
        return bvo_user_id;
    }

    public void setBvo_user_id(Integer bvo_user_id) {
        this.bvo_user_id = bvo_user_id;
    }

    public Integer getConsumer_id() {
        return consumer_id;
    }

    public void setConsumer_id(Integer consumer_id) {
        this.consumer_id = consumer_id;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public Integer getReceiver_info_id() {
        return receiver_info_id;
    }

    public void setReceiver_info_id(Integer receiver_info_id) {
        this.receiver_info_id = receiver_info_id;
    }

    public Timestamp getCreation_time() {
        return Creation_time;
    }

    public void setCreation_time(Timestamp creation_time) {
        Creation_time = creation_time;
    }

    public Integer getTotal_bill() {
        return total_bill;
    }

    public void setTotal_bill(Integer total_bill) {
        this.total_bill = total_bill;
    }

    public Integer getNotes() {
        return notes;
    }

    public void setNotes(Integer notes) {
        this.notes = notes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "int(11) COMMENT '借卖方id'")
    private Integer bvo_user_id;
    @Column(columnDefinition = "int(11) COMMENT '消费者id'")
    private Integer consumer_id;
    @Column(columnDefinition = "int(11) COMMENT '商店id'")
    private Integer shop_id;
    @Column(columnDefinition = "int(11) COMMENT '收件人信息id'")
    private Integer receiver_info_id;
    @Column(columnDefinition = "timestamp COMMENT '创建时间'")
    private Timestamp Creation_time;
    @Column(columnDefinition = "int(11) COMMENT '总支付费用'")
    private Integer total_bill;
    @Column(columnDefinition = "varchar(255) COMMENT '附加信息'")
    private Integer notes;



}
