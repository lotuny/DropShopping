package com.jnucst2015.dropshopping.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class User_Commodity_id implements Serializable {

    @Column(columnDefinition = "INT(11) COMMENT '消费者ID'")
    private Integer user_id;
    @Column(columnDefinition = "INT(11) COMMENT '商品ID'")
    private Integer commodity_id;

    public User_Commodity_id(Integer user_id, Integer commodity_id) {
        this.user_id = user_id;
        this.commodity_id = commodity_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(Integer commodity_id) {
        this.commodity_id = commodity_id;
    }
}
