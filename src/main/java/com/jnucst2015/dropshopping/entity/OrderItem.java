package com.jnucst2015.dropshopping.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class OrderItem {//订单中的单项
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "int(11) COMMENT '订单id'")
    private Integer order_id;
    @Column(columnDefinition = "int(11) COMMENT '商品id'")
    private Integer sale_info_id;
    @Column(columnDefinition = "int(11) COMMENT '数量'")
    private Integer count;
    @Column(columnDefinition = "varchar(255) COMMENT '附加信息'")
    private String notes;
    @Column(columnDefinition = "tinyint COMMENT '状态: 0-待支付, 1-待发货,2-已发货,3-已完成,4-已取消'")
    private Integer state;
    @Column(columnDefinition = "timestamp COMMENT '创建时间'")


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getSale_info_id() {
        return sale_info_id;
    }

    public void setSale_info_id(Integer sale_info_id) {
        this.sale_info_id = sale_info_id;
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