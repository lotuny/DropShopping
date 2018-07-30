package com.jnucst2015.dropshopping.entity;

import javax.persistence.*;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "int(11) COMMENT '店铺ID'")
    private Integer id;
    @Column(columnDefinition = "varchar(255) COMMENT '店铺名'")
    private String name;
    @Column(columnDefinition = "varchar(255) COMMENT '店铺描述'")
    private String description;
    @Column(columnDefinition = "int(11) COMMENT '借卖方ID'")
    private Integer sellerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer seller_id) {
        this.sellerId = seller_id;
    }
}