package com.jnucst2015.dropshopping.entity;

import javax.persistence.*;

@Entity
public class OrderItem {//订单中的单项
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "int(11) COMMENT '订单id'")
    private Integer order_id;
    @ManyToOne
    @JoinColumn(name = "sale_info_id", columnDefinition = "int(11) COMMENT '商品id'")
    private SaleInfo sale_info;
    @Column(columnDefinition = "int(11) COMMENT '数量'")
    private Integer count;
    @Column(columnDefinition = "varchar(255) COMMENT '附加信息'")
    private String notes;
    @Column(columnDefinition = "tinyint COMMENT '状态: 0-待支付, 1-待发货,2-已发货,3-已完成,4-已取消'")
    private Integer state;

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

    public SaleInfo getSale_info() {
        return sale_info;
    }

    public void setSale_info(SaleInfo sale_info) {
        this.sale_info = sale_info;
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