package com.jnucst2015.dropshopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {

    @Id
    private User_Commodity_id user_commodity_id;
    @Column(columnDefinition = "INT(11) COMMENT '商品数量'")
    private Integer quantity;

    public User_Commodity_id getUser_commodity_id() {
        return user_commodity_id;
    }

    public void setUser_commodity_id(User_Commodity_id user_commodity_id) {
        this.user_commodity_id = user_commodity_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
