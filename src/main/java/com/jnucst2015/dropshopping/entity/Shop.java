package com.jnucst2015.dropshopping.entity;

import javax.persistence.*;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "int(11) COMMENT '商店ID'")
    private Integer id;
    @Column(columnDefinition = "varchar(255) COMMENT '商店名'")
    private String name;
    @Column(columnDefinition = "varchar(255) COMMENT '商店描述'")
    private String description;
    @Column(columnDefinition = "tinyint(11) COMMENT '商店分类'")
    private Integer owner_role;
    @Column(columnDefinition = "int(11) COMMENT '拥有者ID'")
    private Integer owner_id;

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

    public Integer getOwner_role() {
        return owner_role;
    }

    public void setOwner_role(Integer owner_role) {
        this.owner_role = owner_role;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }
}
